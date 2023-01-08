package CoffeeMachine.CoffeeMachine;

import java.util.*;

public class Steps implements ToDoList {
    static int Total = 0;
    static Scanner scan;
    static String whichCoffee;

    static int totalBill;
    static boolean randomflag = false;
    static int randomValue;
    static int coffeCounter = 0;

    static int dailyCoffeValue = 0;

    public Steps() {
    }

    public static void start() throws InterruptedException {
        System.out.println("Welcome to coffee world");
        screen();
    }

    public static void DailyCoffee() {
        dailyCoffeValue = new Random().nextInt(0, 6);
        switch (dailyCoffeValue) {
            case 1:
                System.out.println("Daily coffee is Espresso");
                break;
            case 2:
                System.out.println("Daily coffee is Filter Coffee");
                break;
            case 3:
                System.out.println("Daily coffee is Americano");
                break;
            case 4:
                System.out.println("Daily coffee is Macchiato");
                break;
            case 5:
                System.out.println("Daily coffee is Latte");
                break;
        }
    }

    public static void screen() throws InterruptedException {
        if (dailyCoffeValue == 0)
        DailyCoffee();
        Steps obj = new Steps();
        int choose = randomValue;

        if (randomflag == false) {
            obj.toList();
            choose = TryCatch.GetValueFromUser();
        } else {
            randomflag = false;
        }
        switch (choose) {
            case 1:
                whichCoffee = "Espresso";
                totalBill += (dailyCoffeValue == 1 ? 24 : 27);
                obj.coffeeSize();
                obj.addSugar();
                obj.holdOn();
                obj.bill();
                break;
            case 2:
                whichCoffee = "Filter Coffee";
                totalBill += (dailyCoffeValue == 2 ? 22 : 25);
                obj.coffeeSize();
                obj.addMilk();
                obj.holdOn();
                obj.bill();
                break;
            case 3:
                totalBill += (dailyCoffeValue == 3 ? 24 : 27);
                whichCoffee = "Americano";
                obj.coffeeSize();
                obj.holdOn();
                obj.bill();
                break;
            case 4:
                whichCoffee = "Macchiato";
                totalBill += (dailyCoffeValue == 4 ? 32 : 35);
                obj.coffeeSize();
                obj.addMilk();
                obj.holdOn();
                obj.bill();
                break;
            case 5:
                whichCoffee = "Latte";
                totalBill += (dailyCoffeValue == 5 ? 34 : 37);
                obj.coffeeSize();
                obj.addMilk();
                obj.addSugar();
                obj.holdOn();
                obj.bill();
            case 6:
                randomValue = new Random().nextInt(1, 6);
                randomflag = true;
                screen();
                break;
        }
    }

    public void holdOn() throws InterruptedException {
        System.out.print("\n" + whichCoffee + " is prepearing");

        for (int i = 1; i <= 3; ++i) {
            System.out.print(".");
            Thread.sleep(2000L);
        }

        System.out.println("\nCoffee is ready! \n");
    }

    public void toList() {
        if (coffeCounter < 2)
            System.out.println("Buy " + (2 - coffeCounter) + " coffee, other coffee is free");
        else
            System.out.println("You have free coffee");
        System.out.println("1-Espresso\n2-Filter Coffee\n3-Americano\n4-Macchiato\n5-Latte\n6-Random Coffee\n7-Exit");
    }

    public void addMilk() throws InterruptedException {
        System.out.println("\nDo you wanna add milk?\n1-Yes\n2-No");
        scan = new Scanner(System.in);
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("1")) {
            System.out.print("1-Lactose free\n2-Normal\n");
            String answer2 = scan.nextLine();
            if (answer2.equalsIgnoreCase("1")) {
                System.out.print("Lactose free milk is adding");
                for (int i = 1; i <= 3; ++i) {
                    System.out.print(".");
                    Thread.sleep(1000L);
                }
            } else {
                System.out.print("Adding milk");

                for (int i = 1; i <= 3; ++i) {
                    System.out.print(".");
                    Thread.sleep(2000L);
                }
            }
        } else if (answer.equalsIgnoreCase("2")) {
            System.out.print("No milk\n");
        } else {
            this.addMilk();
        }
    }

    public void addSugar() throws InterruptedException {
        System.out.println("\nDo you wanna add sugar?\n1-Yes\n2-No");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("1")) {
            System.out.println("How many cubes of sugar do you want to add?\n ");
            TryCatch TryCatch = new TryCatch();
            int sugar = TryCatch.GetValueFromUser();
            System.out.print("" + sugar + " cubes sugar are adding");
            for (int i = 1; i <= 3; ++i) {
                System.out.print(".");
                Thread.sleep(1000L);
            }
        } else if (answer.equalsIgnoreCase("2")) {
            System.out.println("No Sugar");
        } else {
            System.out.println("Wrong typing");
            this.addSugar();
        }
    }

    public void coffeeSize() {

        System.out.println("Which size do you want your coffee\n1----> Small \n2----> Medium\n3---> Large");
        int choose = TryCatch.GetValueFromUser();
        if (choose == 1) {

            setBill(0);
        } else if (choose == 2) {

            setBill(3);
        } else if (choose == 3) {

            setBill(5);

        } else {
            System.out.println("try again");
            this.coffeeSize();
        }

    }

    public void bill() throws InterruptedException {
        coffeCounter++;
        if (coffeCounter >= 3) {
            totalBill = coffeCounter = 0;
        }
        Total += totalBill;
        System.out.println("Bill is ----> " + Total);
        totalBill = 0;
        while (true) {
            System.out.print("\nPress 1 to exit press 2 to buy another coffee\n");
            int choose = TryCatch.GetValueFromUser();
            if (choose == 1) {
                this.exit();
                break;
            }
            if (choose == 2) {
                screen();
                break;
            }
            System.out.println("Try again");
        }
    }

    public void exit() {
        System.out.println("We are waiting for you again");
    }

    public void setBill(int i) {
        Steps.totalBill += i;
    }
}