import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * ATM_Server_Th
 */
public class ATM_Server_Thread extends Thread {
    private Socket socket;

    public FileRcvThread(Socket socket){
        this.socket=socket;
    }

    public void run() {
        try {

        } catch (Exception e) {

        }

    }

}

/**
 * ATM_server
 */
public class ATM_server {
    final static int PORT = 40001;

    public static void main(String[] args) {

        ATM_server ATM = new ATM_server();

        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                try {

                    Socket socket = server.accept();
                    ATM_Server_Thread th = new ATM_Server_Thread(socket);
                    th.start();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}