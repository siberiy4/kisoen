import java.io.*;
import java.text.DateFormat;
import java.util.*;
import com.sun.javafx.tk.quantum.PathIteratorHelper.Struct;

public class Log {

    Sting day;// 操作日
    string operation;// 操作した内容
    long amount;// 操作した量
    long balance;// 操作した結果の残高

    public Log(String day, string operation, long amount, long balance) {
        day = this.day;
        operation = this.operation;
        amount = this.amount;
        balance = this.balance;
    }
}

public class Account implements Serializable {
    public final String bankName;// 銀行名
    public final String branchName;// 支店名
    public final String accountHolder;// 名義
    public final String accountID;// 口座ID
    public final String accountPIN;// 暗証番号
    public long amount;// 残高
    List<Log> logList = new ArrayList<Log>();// ログの配列

    public Account(String Holder, int ID, char PIN[], long value) {
        bankName = "35銀行";
        branchName = "オンライン支店";
        accountHolder = Holder;
        accountID = ID;
        accountPIN = PIN;
        amount = value;
        System.out.println("make account" + now + "," + accountID + ", \t," + value + ", " + amount);
    }

    public void name() {

    }

    /*
     * public int checkAccount() {
     * 
     * }
     */
    // 預金操作
    public void deposit(int value) {
        amount += value;// 預金操作
        Calendar cal = Calendar.getInstance();
        String now = DateFormat(cal);
        System.out.println(now + "," + accountID + ", Deposit" + value + ", " + amount);
        makeLog(now, "deposit", valie, amount);
    }

    // 出金
    public long withdrawal(int value) {
        amount -= value;// 出金操作
        Calendar cal = Calendar.getInstance();
        String now = DateFormat(cal);
        System.out.println(now + "," + accountID + ", Withdrawal" + value + ", " + amount);
        makeLog(now, "withdrawal", value, amount);
    }

    // 残高を取る
    public long getBalance() {
        return amount;
    }

    // ログを蓄積
    public void makeLog(string l, string ope, long a, long b) {
        Log tmpLog = new Log();
        tmpLog.day = l;
        tmpLog.operation = ope;
        tmpLog.amount = a;
        tmpLog.balance = b;

        logList.add(tmpLog);
        try (File file = new File(accountID + ".txt")) {
            if (file.exists()) {
                FileWriter filewriter = new FileWriter(file, true);
                filewriter.write(tmpLog.day + " " + tmpLog.operation + " " + tmpLog.amount + " " + tmpLog.balance);
                filewriter.close();
            } else {
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
