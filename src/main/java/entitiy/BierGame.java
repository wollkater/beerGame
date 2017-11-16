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
import static sun.plugin2.main.client.ServiceDelegate.get;

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

		init();

	}

	public static void broadcastMessage(String message) {
		userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
			try {
				session.getRemote().sendString(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
