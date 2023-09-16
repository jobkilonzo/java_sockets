import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class GreetingClient {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter Server Address: ");
        String serverName = userInput.next();
        System.out.println("Enter Port Number: ");
        String port = userInput.next();

        try{
            System.out.println("Connecting to " + serverName + " on Port " + port);
            Socket client = new Socket(serverName, Integer.parseInt(port));
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            System.out.println("Enter a first number: ");
            Integer x = userInput.nextInt();
            System.out.println("Enter second number: ");
            Integer y = userInput.nextInt();

            out.writeInt(x);
            out.writeInt(y);

            InputStream inFromServer = client.getInputStream();
            DataInputStream in =
                    new DataInputStream(inFromServer);
            System.out.println("Server responds: " +in.readInt());
            client.close();
        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
