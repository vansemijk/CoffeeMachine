package CoffeeMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class Steps extends CoffeeTypes implements ToDoList {
    static Scanner scan;
    static String whichCoffee;
    static Map<String, CoffeeTypes> coffeeTypesMap;
    static int totalBill;
    static boolean randomflag=false;
    static int randomValue;

    public Steps() {
    }

    public static void start() throws InterruptedException {
        System.out.println("Welcome to coffee world");
        giris();
    }

    public static void giris() throws InterruptedException {
        Steps obj = new Steps();
        int secim = randomValue;

		if (randomflag == false) {
			obj.toList();
			secim = TryCatch.intGiris();
		} else {
			randomflag = false;
		}
        switch (secim) {
            case 1:
                whichCoffee = "Espresso";
                totalBill += 20;
                obj.coffeeSize();
                obj.addSugar();
                obj.holdOn();
                obj.bill();
                break;
            case 2:
                whichCoffee = " Filter Coffee";
                totalBill += 25;
                obj.coffeeSize();
                obj.addMilk();
                obj.holdOn();
                obj.bill();
                break;
            case 3:
                totalBill += 30;
                whichCoffee = "Americano";
                obj.coffeeSize();
                obj.addSugar();
                obj.holdOn();
                obj.bill();
                break;
            case 4:
                whichCoffee = "Cappucino";
                totalBill += 20;
                obj.coffeeSize();
                obj.addSugar();
                obj.holdOn();
                obj.bill();
                break;
            case 5:
                whichCoffee = "Latte";
                totalBill += 20;
                obj.coffeeSize();
                obj.addMilk();
                obj.addSugar();
                obj.holdOn();
                obj.bill();
            case 6:
    			randomValue = new Random().nextInt(1, 6);
    			randomflag = true;
    			giris();
    			break;
    		
        }

    }

    public void holdOn() throws InterruptedException {
        System.out.print(whichCoffee + " is prepearing");

        for(int i = 1; i <= 3; ++i) {
            System.out.print(".");
            Thread.sleep(1000L);
        }

        System.out.println("Coffe is ready \n");
    }

    public void toList() {
        System.out.println("1-Espresso\n2-Filter Coffee\n3-Americano\n4-Cappucino\n5-Latte\n6-Random Coffe\n7-Exit");
    }

    public void addMilk() throws InterruptedException {
        System.out.println("\n Do you wanna add milk?\n1-yes\n2-no");
        String answer = scan.next();
        if (answer.equalsIgnoreCase("1")) {
            System.out.print("adding milk");

            for(int i = 1; i <= 3; ++i) {
                System.out.print(".");
                Thread.sleep(1000L);
            }
        } else if (answer.equalsIgnoreCase("2")) {
            System.out.print("no milk ");
        } else {
            this.addMilk();
        }

    }

    public void addSugar() throws InterruptedException {
        System.out.println("Do you wanna add sugar?\n1-yes\n2-no");
        String answer = scan.next();
        if (answer.equalsIgnoreCase("1")) {
            System.out.println("how many sugar cubes\n ");
            TryCatch TryCatch = new TryCatch();
            int sugar = TryCatch.intGiris();
            System.out.print("" + sugar + "sugar adding");

            for(int i = 1; i <= 3; ++i) {
                System.out.print(".");
                Thread.sleep(1000L);
            }
        } else if (answer.equalsIgnoreCase("2")) {
            System.out.println("NO SUGAR ");
        } else {
            System.out.println(" please try again");
            this.addSugar();
        }

    }

    public void coffeeSize() {
        CoffeeTypes coffee = new CoffeeTypes();
        System.out.println(" which size do you want your coffee\n1----> small \n2---->medium\n3---> large");
        int secim = TryCatch.intGiris();
        if (secim == 1) {
            coffee.setSize("small");
            coffee.setBill(5);
            coffeeTypesMap.put(whichCoffee, coffee);
        } else if (secim == 2) {
            coffee.setSize("medium");
            coffee.setBill(10);
            coffeeTypesMap.put(whichCoffee, coffee);
        } else if (secim == 3) {
            coffee.setSize("large");
            coffee.setBill(15);
            coffeeTypesMap.put(whichCoffee, coffee);
        } else {
            System.out.println("try again");
            this.coffeeSize();
        }

        totalBill += coffee.getPrice();
    }

    public void bill() throws InterruptedException {
        System.out.println(" bill is ---->" + totalBill);

        while(true) {
            System.out.print("\n press 1 to exit press 2 to buy another coffee");
            int secim = TryCatch.intGiris();
            if (secim == 1) {
                this.exit();
                break;
            }

            if (secim == 2) {
                giris();
                break;
            }

            System.out.println("try again");
        }

    }

    public void exit() {
        System.out.println("We are waiting for you again");
    }

    static {
        scan = new Scanner(System.in);
        whichCoffee = "";
        coffeeTypesMap = new HashMap();
        totalBill = 0;
    }
}