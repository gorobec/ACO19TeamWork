package week7.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by SmooZzzie on 21.05.2017.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.101", 5555);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);


        while (true) {
            System.out.println("Server: ");
            String serverMessage = reader.readLine();
            System.out.println(serverMessage);

            if (serverMessage.equalsIgnoreCase("Bye")) break;


            System.out.println("Client: ");
            writer.write(console.readLine() + "\n");
            writer.flush();
        }
    }
}
