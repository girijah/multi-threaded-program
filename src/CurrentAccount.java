

public class CurrentAccount implements BankAccount {

    private int balance;
    private int accountNumber;
    private String accountHolder;
    private Statement statement;

    public CurrentAccount (String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.statement = new Statement(accountHolder, accountNumber);
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolder() {
        return accountHolder;
    }

    @Override
    public synchronized void deposit(Transaction t) {
        if(this.isOverdrawn()) {
            System.err.println("\n*** "+ getAccountHolder()+"'s account "+getAccountNumber()+" "+ "is overdrawn! Current account balance "+ getBalance() + "\n");
        }

        balance += t.getAmount();
        statement.addTransaction(t.getCID(), t.getAmount(), balance);
        notifyAll();
    }

    @Override
    public synchronized void withdrawal(Transaction t) {
        if(t.getAmount() > 0) {

            if(this.isOverdrawn()) {
                System.err.println("\n*** "+ getAccountHolder()+"'s account "+getAccountNumber()+" "+ "is overdrawn! Current account balance "+ getBalance() + "\n");
            }

        int amount = t.getAmount();
            while (this.balance < amount) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            balance -= t.getAmount();
            statement.addTransaction(t.getCID(), t.getAmount(), balance);

        }
    }

    @Override
    public boolean isOverdrawn() {
        if(balance < 0){
            return true;
        }
        return false;
    }

    @Override
    public void printStatement() {
        //System.out.println("\n Statement: Account Holder - "+accountHolder+ "\t \t Account Number - "+ accountNumber+" \t\t Balance - " + balance);
        statement.print();
    }
}
