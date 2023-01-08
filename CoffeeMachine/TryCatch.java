package CoffeeMachine.CoffeeMachine;

import java.util.Scanner;

public class TryCatch {
    static Scanner scan = new Scanner(System.in);

    public static int GetValueFromUser() {
        int choose = 0;
        boolean flag = false;
        do {
            if (flag == true) {
                scan.nextLine();
            }
            System.out.println("Please choose");
            try {
                choose = scan.nextInt();
                scan.nextLine();
                if (choose > 7) {
                    System.out.println("Try again");
                    Steps steps = new Steps();
                    steps.toList();
                    return GetValueFromUser();
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong typing");
                flag = true;
            }
        } while (flag);
        return choose;
    }
}
