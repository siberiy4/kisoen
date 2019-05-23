import java.io.*;
import java.text.DateFormat;
import java.util.*;
import com.sun.javafx.tk.quantum.PathIteratorHelper.Struct;

/**
 * Account
 */

/**
 * Log
 */
public class Log {

    Sting day;
    string operation;
    long amount;
    long balance;

    public Log(String day, string operation, long amount, long balance) {
        day = this.day;
        operation = this.operation;
        amount = this.amount;
        balance = this.balance;
    }
}

public class Account implements Serializable {
    public final String bankName;
    public final String branchName;
    public final String accountHolder;
    public final String accountID;
    public final String accountPIN;
    public long amount;
    List<Log> logList = new ArrayList<Log>();

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

    public int checkAccount() {

    }

    public void deposit(int value) {
        amount += value;
        Calendar cal = Calendar.getInstance();
        String now = DateFormat(cal);
        System.out.println(now + "," + accountID + ", Deposit" + value + ", " + amount);
        makeLog(now, "deposit", valie, amount);
    }

    public long withdrawal(int value) {
        amount -= value;
        Calendar cal = Calendar.getInstance();
        String now = DateFormat(cal);
        System.out.println(now + "," + accountID + ", Withdrawal" + value + ", " + amount);
        makeLog(now, "withdrawal", value, amount);
    }

    public long getBalance() {
        return amount;
    }

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
