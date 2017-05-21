package week7.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by gorobec on 21.05.17.
 */
public class Client {
    private static final int PORT = 5555;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.101", PORT);

        BufferedReader reader =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console =  new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String serverMessage = reader.readLine();
            System.out.print("Server: ");
            System.out.println(serverMessage);

            if(serverMessage.equalsIgnoreCase("Bye")) break;

            System.out.print("Client: ");
            writer.write(console.readLine() + "\n");
            writer.flush();
        }

    }
}
