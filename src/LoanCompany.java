public class LoanCompany extends Thread {
    private BankAccount account;
    private String companyName;

    public LoanCompany(ThreadGroup organizationThreadGroup, String name, BankAccount account, String companyName) {
        super(organizationThreadGroup, name);
        this.account = account;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void run() {
        System.out.println("Loan Company "+getCompanyName()+"  transactions starts..");

        try {
            sleep( (int)(Math.random() * 2000) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nLoan Company "+getCompanyName()+" going to deposit 50");
        Transaction t1 = new Transaction(getName(), 50);
        System.out.println("Loan Company "+getCompanyName()+"  deposits 50");
        account.deposit(t1);
        System.out.println("Loan Company "+getCompanyName()+"  deposited 50 \n");
        System.out.println(t1.toString());


        try {
            sleep( (int)(Math.random() * 1000) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nLoan Company "+getCompanyName()+" going to deposit 350");
        Transaction t2 = new Transaction(getName(), 350);
        System.out.println("Loan Company "+getCompanyName()+"  deposits 350");
        account.deposit(t2);
        System.out.println("Loan Company "+getCompanyName()+"  deposited 350 \n");
        System.out.println(t2.toString());

        try {
            sleep( (int)(Math.random() * 1000) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nLoan Company "+getCompanyName()+" going to deposit 2000");
        Transaction t3 = new Transaction(getName(), 2000);
        System.out.println("Loan Company "+getCompanyName()+"  deposits 2000");
        account.deposit(t3);
        System.out.println("Loan Company "+getCompanyName()+"  deposited 2000 \n");
        System.out.println(t3.toString());

        System.out.println("\nLoan Company "+getCompanyName()+"  transactions terminates..");
    }
}
