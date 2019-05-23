import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ATM_Server_Thread extends Thread {
    private Socket socket;

    public ATM_Server_Thread(Socket socket) { // コンストラクタ
        this.socket = socket;
    }

    public void run() {
        try {

            byte[] rbuf = new byte[64];
            int len = in.read(rbuf);
            String str = new String(rbuf,0,len);
            if(str="0"){
                Account people = new Account();
                
            }


            if()



            FileOutputStream outFile = new FileOutputStream(account.accountID);
            ObjectOutputStream objectOut = new ObjectOutputStream(outFile);
            objectOut.writeObject(account);
            objectOut.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}