package org.example;

import java.util.Scanner;

public class ATM
{
    int pin=123;
    int balance;

    Scanner sc=new Scanner(System.in);

    public void checkPin()
    {
        System.out.print("Enter your pin :");
        int enterPin=sc.nextInt();
        if(enterPin==pin)
        {
            menu();
        }
        else {
            System.out.println("Incorrect pin");
            System.out.println("------------------");
            System.out.println("Enter correct pin");
            checkPin();
        }
    }

    public void menu()
    {
        System.out.println("---------------------");
        System.out.println("Enter your choice: ");
        System.out.println("1 : Check A/C Balance");
        System.out.println("2 : Withdraw Balance");
        System.out.println("3 : Deposit Balance");
        System.out.println("4 : Exit");

        int option =sc.nextInt();

        switch (option)
        {
            case 1 : checkBalance();
            case 2 : withdrawBalance();
            case 3: depositBalance();
            case 4:
                System.out.println("Thank you for using our application");
                break;
            default:
                System.out.println("Enter a valid choice");
                menu();
        }
    }

    public void checkBalance()
    {
        System.out.println("Available balance is : "+balance);
        menu();
    }

    public void withdrawBalance()
    {
        System.out.println("Enter amount : ");
        int amount=sc.nextInt();
        if(amount<balance)
        {
            balance-=amount;
            System.out.println(amount+" has been withdraw");
        }
        else{
            System.out.println("Insufficient amount");
        }
        menu();
    }

    public void depositBalance()
    {
        System.out.println("Enter amount");
        int amount=sc.nextInt();
        balance+=amount;
        System.out.println(amount+" deposit successfully");
        menu();
    }
}
