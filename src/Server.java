import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("Server is listening on port 8081");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientGreeting = in.readLine();
            System.out.println("Client: " + clientGreeting);

            if (containsRussianLetters(clientGreeting)) {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Що таке паляниця?");
                String answer = in.readLine();
                if (answer.equalsIgnoreCase("Хліб")) {
                    out.println("Data and time: " + java.time.LocalDateTime.now());
                    out.println("Bay!");
                } else {
                    out.println("Incorrect answer. Disconnect.");
                    clientSocket.close();
                }
            } else {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Hello from the server!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean containsRussianLetters(String input) {
        return input.matches(".*[а-яА-Я].*");
    }
}
