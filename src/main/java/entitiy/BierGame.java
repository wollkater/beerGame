package entitiy;

import com.beust.jcommander.JCommander;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.jetty.websocket.api.*;

import static spark.Spark.init;
import static spark.Spark.staticFileLocation;
import static spark.Spark.webSocket;

import org.json.JSONObject;
import org.sql2o.Sql2o;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.PostgresQuirks;

import config.CommandLineOptions;
import socket.TradeWebSocketHandler;


/**
 * Created by marcel on 04.10.17.
 */
public class BierGame {

	// this map is shared between sessions and threads, so it needs to be thread-safe (http://stackoverflow.com/a/2688817)
	static public Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
	static public int nextUserNumber = 1; //Used for creating the next username

	public static void main(String[] args) {
		staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)
		webSocket("/trade", TradeWebSocketHandler.class);
		CommandLineOptions options = new CommandLineOptions();
		new JCommander(options, args);


		Sql2o sql2o = new Sql2o("jdbc:postgresql://" + options.getDbHost() + ":" + options.getDbPort() + "/" + options.getDatabase(),
				options.getDbUsername(), options.getDbPassword(), new PostgresQuirks() {
			{
				// make sure we use default UUID converter.
				converters.put(UUID.class, new UUIDConverter());
			}
		});

		Brewery brewery = new Brewery();
		Storage storage = new Storage();
		Resource beer5 = new Resource(ResourceType.BEER, 5);
		Resource water5 = new Resource(ResourceType.WATER, 5);
		Resource hop5 = new Resource(ResourceType.HOPS, 5);
		Resource hop3 = new Resource(ResourceType.HOPS, 3);
		Resource water2 = new Resource(ResourceType.WATER, 2);

		brewery.setLager(storage);
		HashMap<Resource, Integer> resources = new HashMap<>();
		resources.put(beer5, 5);
		resources.put(water5, 20);
		resources.put(hop5, 2);
		resources.put(hop3, 5);
		resources.put(water2, 5);
		storage.setResources(resources);

		brewery.brew();

		brewery.getLager().getResources().forEach((resource, integer) -> System.out.println(resource.getType() + " of Quality " + resource.getQuality() + ": " + integer));

		init();



	}

	public static void broadcastMessage(String sender, String message) {
		userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
			try {

				session.getRemote().sendString(String.valueOf(new JSONObject()
						.put("userMessage", message)
						.put("userlist", userUsernameMap.values())
				));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
