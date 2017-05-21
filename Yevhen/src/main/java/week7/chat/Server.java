package week7.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by gorobec on 21.05.17.
 */
public class Server {
    private static final int PORT = 5555;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        Socket socket = serverSocket.accept();


        BufferedReader reader =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader console =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());


        while (true){
        System.out.print("Server: ");
        String message = console.readLine();
        writer.write(message + "\n");
        writer.flush();

        if(message.equalsIgnoreCase("Bye")) break;

        String clientMessage = reader.readLine();
        System.out.print("Client: ");
        System.out.println(clientMessage);}

    }
}
