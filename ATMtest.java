import java.util.Scanner;

public class ATMtest {
    public static void main(String args[]){
        Account[] accounts = new Account[10];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
            accounts[i].setId(i);
            accounts[i].setBalance(50);
        }

        int id;
        int choice;
        Scanner input = new Scanner(System.in);


        System.out.print("Enter an account id: ");
        id = input.nextInt();

        while(id<0 || id > 9){
            System.out.println("Wrong ID! Enter again: ");
            id = input.nextInt();

        }

        do{
            System.out.println("Main menu: ");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
            System.out.print("Enter a choice: ");
            choice = input.nextInt();



        switch (choice)
        {
            case 1: {
                System.out.println("The balance is " + accounts[id].getBalance());
                break;
            }
            case 2: {
                double amount;
                System.out.print("Enter an amount to withdraw: ");
                amount = input.nextDouble();
                accounts[id].withdraw(amount);
                break;
            }
            case 3: {
                double amount;
                System.out.print("Enter an amount to deposit: ");
                amount = input.nextDouble();
                accounts[id].deposit(amount);
                break;
            }
            case 4:
                System.out.println("Bye!!");
                break;
        }


        }while (choice!=4);

    }

}
