package client;

import java.net.URISyntaxException;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class Client {
    private Socket socket;

    public Client() {
        try {
            socket = IO.socket("http://localhost:3000");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        socket.connect();
        // TODO: fix null socket.id() when new socket is created.
        String id = socket.id();
        System.out.println(String.format("You connected with id: %s", id));
    }

    public void sendMessage(String message) {
        socket.emit("message", message);
    }

    public void onMessage(Emitter.Listener listener) {
        socket.on("message", listener);
    }

    public void disconnect() {
        socket.disconnect();
    }
    public void on(String event, Emitter.Listener listener) {
        socket.on(event, listener);
    }
}



