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
            ObjectOutputStream sendObject = new ObjectOutputStream(out);

            int sinkiOrMember=inputData.readInt();

            if (sinkiOrMember==1) {
                int memberNumber=inputData.readInt();
                try {
                ObjectInputStream inputObject=new ObjectInputStream(new FileInputStream(Integer.toString(memberNumber)));
                    Account accountData=(Account)inputObject.readObject();
                sendObject.writeObject(accountData);
                    inputObject.close();

                } catch (Exception e) {
                Account accountData =new Account();
                accountData.checkAccount();
                sendObject.writeObject(accountData);

                }

            }else{
            Account accountData =new Account();
                accountData.checkAccount();
                sendObject.writeObject(accountData);
            }
            ObjectInputStream installObject = new ObjectInputStream(in);

            Account inputAccount =(Account)installObject.readObject();

            ObjectOutput outputObject =new ObjectOutputStream(new FileOutputStream(inputAccount.accountID));
            outputObject.writeObject(inputAccount);
            outputObject.close();


            installObject.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    


}