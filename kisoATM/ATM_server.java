import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * ATM_server
 */
public class ATM_server {
    public static final int ECHO_PORT = 40001;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        System.out.println("hazimatta");
        try {
            serverSocket = new ServerSocket(ECHO_PORT);

  

            while (true) {
                Socket socket = serverSocket.accept();
                ATM_Server_Thread th = new ATM_Server_Thread(socket);
                th.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
            }
        }

    }
}