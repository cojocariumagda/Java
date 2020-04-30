import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) throws IOException{
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try {
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            /*String request = "World";
            out.println(request);*/

            String inputRequest = "";

            while(!inputRequest.equals("stop"))
            {
                Scanner keyboardRequest = new Scanner(System.in);
                System.out.println("Give me your command/request");
                inputRequest = keyboardRequest.nextLine();
                out.println(inputRequest);
                String response = in.readLine();
                System.out.println(response);
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
        catch (ConnectException e)
        {
            System.err.println("Connection refused - server is not up");
        }
    }
}
