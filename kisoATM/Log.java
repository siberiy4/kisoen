import java.io.Serializable;

public class Log implements Serializable {

    private static final long serialVersionUID = 2L;
    String day;// 操作日
    String operation;// 操作した内容
    long amount;// 操作した量
    long balance;// 操作した結果の残高

    public Log(String day, String operation, long amount, long balance) {
        day = this.day;
        operation = this.operation;
        amount = this.amount;
        balance = this.balance;
    }
}
