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


            int sinkiOrMember=inputData.readInt();

            if (sinkiOrMember==1) {
                int memberNumber=inputData.readInt();
                try {
                ObjectInputStream inputObject=new ObjectInputStream(new FileInputStream(Integer.toString(memberNumber)));
                    Account accountData=(Account)inputObject.readObject();
                    inputObject.close();
                } catch (Exception e) {
                Account accountData =new Account();
                accountData.checkAccount();

                }

            }else{
            Account accountData =new Account();
                accountData.checkAccount();
            }
                outputObject.writeObject(accountData);


ObjectOutput outputObject=new ObjectOutputStream(new FileOutputStream(Integer.toString(accountData.accountID)));
outputObject.writeObject(accountData);
outputObject.flush();
outputObject.close();

/*
            FileOutputStream outFile = new FileOutputStream(account.accountID);
            ObjectOutputStream objectOut = new ObjectOutputStream(outFile);        
            objectOut.writeObject(account);
            objectOut.close();
  
  */

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    


}