public class University extends Thread {
    private BankAccount account;
    private String universityName;

    public University(ThreadGroup organizationThreadGroup, String name, BankAccount account, String universityName) {
        super(organizationThreadGroup, name);
        this.account = account;
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    @Override
    public void run() {
        System.out.println("\n"+ getUniversityName()+"  transactions starts..");

        try {
            sleep( (int)(Math.random() * 2000) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n"+ getUniversityName()+" going to withdraw 2000");
        Transaction t1 = new Transaction(getName(), 900);
        System.out.println(getUniversityName()+"  withdraws 2000");
        account.withdrawal(t1);
        System.out.println(getUniversityName()+"  withdrew 2000 \n");
        System.out.println(t1.toString());


        try {
            sleep( (int)(Math.random() * 1000) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n"+ getUniversityName()+" going to withdraw 1000");
        Transaction t2 = new Transaction(getName(), 400);
        System.out.println(getUniversityName()+"  withdraws 1000");
        account.withdrawal(t2);
        System.out.println(getUniversityName()+"  withdrew 1000 \n");
        System.out.println(t2.toString());

        try {
            sleep( (int)(Math.random() * 1000) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n"+ getUniversityName()+" going to withdraw 1100");
        Transaction t3 = new Transaction(getName(), 1100);
        System.out.println(getUniversityName()+"  withdraws 1100");
        account.withdrawal(t3);
        System.out.println(getUniversityName()+"  withdrew 1100 \n");
        System.out.println(t3.toString());

        System.out.println("\n"+ getUniversityName()+"  transactions terminates..");
    }
}
