public class Parent extends Thread {
    private BankAccount account;
    private String parentName;

    public Parent(ThreadGroup humanThreadGroup, String name, BankAccount account, String parentName) {
        super(humanThreadGroup, name);
        this.account = account;
        this.parentName = parentName;
    }

    public String getParentName() {
        return parentName;
    }

    @Override
    public void run() {

        System.out.println("Parent's top-up gifts transactions starts..");

        try {
            sleep( (int)(Math.random() * 3000) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nParent "+getParentName()+" going to deposit 900");
        Transaction t1 = new Transaction(getName(), 900);
        System.out.println("Parent "+getParentName()+" deposits 900");
        account.deposit(t1);
        System.out.println("Parent "+getParentName()+" deposited 900 \n");
        System.out.println(t1.toString());


        try {
            sleep( (int)(Math.random() * 1000) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nParent "+getParentName()+"  going to deposit 1000");
        Transaction t2 = new Transaction(getName(), 1000);
        System.out.println("Parent "+getParentName()+"  deposits 1000");
        account.deposit(t2);
        System.out.println("Parent "+getParentName()+"  deposited 1000 \n");
        System.out.println(t2.toString());

        System.out.println("\nParent transactions terminates..");
    }

}
