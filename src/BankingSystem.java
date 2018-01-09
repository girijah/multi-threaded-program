public class BankingSystem {

    public static void main (String args[]) {

        System.out.println("\n.. Banking System Process ..\n");

        ThreadGroup organizationThreadGroup = new ThreadGroup("Organization");
        ThreadGroup humanThreadGroup = new ThreadGroup("Human");
        System.out.println("# Two Thread groups created");

        CurrentAccount account = new CurrentAccount("George", 2121);
        System.out.println("# Current Account created");

        Student student = new Student(humanThreadGroup, "Student", account);
        System.out.println("# Student created");
        Parent parent = new Parent(humanThreadGroup, "Parent", account, "Miller");
        System.out.println("# Parent created");

        LoanCompany loanCompany = new LoanCompany(organizationThreadGroup, "LoanCompany", account, "Commercial Credits");
        System.out.println("# Loan company created");
        University university = new University(organizationThreadGroup, "University", account, "University of Westminster");
        System.out.println("# University created");

        student.start();
        parent.start();
        loanCompany.start();
        university.start();

        System.out.println("\nAll threads started.. \n");


        try {
            student.join();
            parent.join();
            loanCompany.join();
            university.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n All threads terminated. \n");

        account.printStatement();

        System.out.println("Banking System process terminated successfully!");

    }

}
