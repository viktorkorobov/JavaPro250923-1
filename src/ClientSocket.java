
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) {
      try {
            Socket socket = new Socket("localhost", 8081);
           Scanner scanner =new Scanner(System.in);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(scanner.next());


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = in.readLine();
            System.out.println("Server: " + serverResponse);

            if(serverResponse.equals("Що таке паляниця?")){
                out.println(scanner.next());
                String dateTime = in.readLine();
                System.out.println("Server respone: " + dateTime);
                serverResponse = in.readLine();
                System.out.println("Server respone: " + serverResponse);
            } else System.out.println("Incorrect answer");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
