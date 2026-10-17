import java.io.*;
import java.net.*;
import java.time.*;


public class Server {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        try (ServerSocket server = new ServerSocket(1200);
             Socket socket = server.accept();
             DataInputStream in = new DataInputStream(socket.getInputStream())) {

            System.out.println("Server started. Waiting for client...");
            String line;
            while (!(line = in.readUTF()).equals("End")) {
                System.out.println(time + " Client: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}