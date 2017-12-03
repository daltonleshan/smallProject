import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            System.err.println("ERROR: Could not listen on port 8000");
            System.exit(-1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("ERROR: Server could not accept");
            System.exit(-1);
        }

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                        clientSocket.getInputStream()));
            String input, output;
            while (true) {
                out.println(in.readLine());
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("ERROR: Read failed!");
            System.exit(-1);
        }
        clientSocket.close();
        serverSocket.close();

    }


}
