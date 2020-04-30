import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    public  ClientThread(Socket socket) {this.socket = socket;}
    public void run ()
    {
        try {
            //Get the request from the input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            //Send the response to the output stream
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String response = "";
            while (!request.equals("stop"))
            {
                response = "Server received the request " + request;
                out.println(response);
                out.flush();
                request = in.readLine();
            }
            response = "Server stopped";
            System.out.println("Server closed connection with this client");
            out.println(response);
            out.flush();
            try {
                socket.close();
            } catch (IOException e)
            {
                System.err.println(e);
            }
        } catch (IOException e) {
            System.err.println("Communication error..." + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e)
            {
                System.err.println(e);
            }
        }
    }
}
