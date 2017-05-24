package week7.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by SmooZzzie on 21.05.2017.
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5555);
        Socket socket = serverSocket.accept();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);


        while (true) {
            System.out.println("Server: ");
            String message = console.readLine();
            writer.write(message + "\n");
            writer.flush();

            if (message.equalsIgnoreCase("Bye")) break;


            System.out.println("Client: ");
            String clientMessage = reader.readLine();
            System.out.println(clientMessage);

        }
    }
}
