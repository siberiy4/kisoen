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
            InputStream in=socket.getInputStream();
            OutputStream out=socket.getOutputStream();


            DataInputStream inputData = new DataInputStream(in);
            ObjectOutputStream outputObject = new ObjectOutputStream(out);

            int sinkiOrMember=inputData.readInt();

            if (sinkiOrMember==1) {
                int memberNumber=inputData.readInt();
                try {
                ObjectInputStream inputObject=new ObjectInputStream(new FileInputStream(Integer.toString(memberNumber)));
                    Account accountData=(Account)inputObject.readObject();
                    inputObject.close();
                outputObject.writeObject(accountData);

                } catch (Exception e) {
                Account accountData =new Account();
                accountData.checkAccount();
                outputObject.writeObject(accountData);

                }

            }else{
            Account accountData =new Account();
                accountData.checkAccount();
                outputObject.writeObject(accountData);
            }


            ObjectInputStream in = new ObjectInputStream(sock.getInputStream());

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    


}