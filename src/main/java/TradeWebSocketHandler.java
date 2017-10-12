import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import org.eclipse.jetty.websocket.api.*;

/**
 * Created by marcel on 04.10.17.
 */
@WebSocket
public class TradeWebSocketHandler {

	private String sender, msg;

	@OnWebSocketConnect
	public void onConnect(Session user) throws Exception {
		String username = "User" + BierGame.nextUserNumber++;
		BierGame.userUsernameMap.put(user, username);
		BierGame.broadcastMessage(sender = "Server", msg = (username + " joined the chat"));
		System.out.println("Someone joined the chat");
	}

	@OnWebSocketClose
	public void onClose(Session user, int statusCode, String reason) {
		String username = BierGame.userUsernameMap.get(user);
		BierGame.userUsernameMap.remove(user);
		BierGame.broadcastMessage(sender = "Server", msg = (username + " left the chat"));
	}

	@OnWebSocketMessage
	public void onMessage(Session user, String message) {
		BierGame.broadcastMessage(sender = BierGame.userUsernameMap.get(user), msg = message);
	}
}
