package CoffeeMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;


public class Steps extends CoffeeTypes implements ToDoList {
    static int a=0;
    static boolean randomflag=false;
    static Scanner scan = new Scanner(System.in);
    static String whichCoffee = "";
    static Map<String, CoffeeTypes>coffeeTypesMap=new HashMap<>();


    static int totalBill = 0;

    public static void start() throws InterruptedException {
        System.out.println(" hosgeldiniz ustamm ");
        giris();
    }

    public static void giris() throws InterruptedException {
        Steps obj = new Steps();
        obj.toList();
        int secim= a;

        if (randomflag=false){
         secim = TryCatch.intGiris();}
        else { randomflag=false;
        }

        switch (secim) {
            case 1:
                whichCoffee = " Türk Kahvesi";
                obj.coffeeSize();
                obj.addSugar();
                obj.addMilk();
                obj.holdOn();
                obj.bill();
                break;
            case 2:
                whichCoffee = " Filtre Kahve";
                obj.coffeeSize();
                obj.addMilk();
                obj.holdOn();
                obj.bill();
                break;

            case 3:
                whichCoffee = "Expresso";
                obj.coffeeSize();
                obj.addSugar();
                obj.addMilk();
                obj.holdOn();
                obj.bill();
                break;

            case 4:



            case 5:
                  a = new Random().nextInt(1,4);
                  randomflag=true;

            giris();



        }

    }


    @Override
    public void holdOn() throws InterruptedException {
        System.out.print(whichCoffee + " prepearing");
        for (int i = 1; i <= 3; i++) {
            System.out.print(" . ");
            Thread.sleep(1000);

        }
        System.out.println(" coffee is ready \n");

    }

    @Override
    public void toList() {
        System.out.println("1 -----> Espersso \n**2-Latte\n**3-Americano\n**4-Exit");
    }

    @Override
    public void addMilk() throws InterruptedException {
        System.out.println("\n wanna add milk?");
        String answer = scan.next();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("\n laktozsuz veya normal ? ");
            String answer2= scan.next();
            if(answer2.equalsIgnoreCase("laktossuz")) {
                System.out.print("laktossuz adding milk");
                for (int i = 1; i <= 3; i++) {
                    System.out.print(".");
                    Thread.sleep(1000);

                }
            }else if (answer2.equalsIgnoreCase("normal"));
            System.out.print("adding milk");
            for (int i = 1; i <= 3; i++) {
                System.out.print(".");
                Thread.sleep(1000);
            }
        } else if (answer.equalsIgnoreCase("no")) {
            System.out.print("no milk ");

        } else {
            System.out.println("try again");
            addMilk();
        }
    }

    @Override
    public void addSugar() throws InterruptedException {
        System.out.println("Do you wanna add sugar ? ( yes or no )");
        String answer = scan.next();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("how many sugar cubes\n ");
            TryCatch TryCatch = new TryCatch();
            int sugar = TryCatch.intGiris();
            System.out.print(sugar + "sugar adding");
            for (int i = 1;i<=3 ; i++) {
                System.out.print(".");
                Thread.sleep(1000);
            }
        } else if (answer.equalsIgnoreCase("no")) {
            System.out.println("NO SUGAR ");



        } else {
            System.out.println(" please try again");
            addSugar();
        }

    }

    @Override
    public void coffeeSize() {
        CoffeeTypes coffee = new CoffeeTypes();
        System.out.println(" which size do you want your coffee\n1----> small \n2---->medium\n3---> large");
        int secim = TryCatch.intGiris();
        if (secim == 1) {
            coffee.setSize("small");
            coffee.setPrice(secim);
            coffeeTypesMap.put(whichCoffee,coffee);


        } else if (secim == 2) {
            coffee.setSize("medium");
            coffee.setPrice(secim);
            coffeeTypesMap.put(whichCoffee,coffee);

        } else if (secim == 3) {
            coffee.setSize("large");
            coffee.setPrice(secim);
            coffeeTypesMap.put(whichCoffee,coffee);


        } else {
            System.out.println("try again");
            coffeeSize();
        }
totalBill+=coffee.getPrice();

    }

    @Override
    public void bill() throws InterruptedException {
        System.out.println(" bill is ---->" + totalBill);
        while (true) {
            System.out.print("\n press 1 to exit press 2 to buy another coffee");
            int secim = TryCatch.intGiris();
            if (secim == 1) {
                exit();
                break;

            } else if (secim == 2) {
                giris();
                break;


            } else {
                System.out.println("try again");
            }
        }
    }

    @Override
    public void exit() {
        System.out.println("come again");
    }
}


