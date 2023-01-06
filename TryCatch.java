package CoffeeMachine;


import java.util.Scanner;


public class TryCatch {

    static  Scanner scan= new Scanner (System.in);

    public static int intGiris(){
        int secim=0;
        boolean flag= false;
        do {
            if(flag==true){
                scan.nextLine();



            }
            System.out.println(" please choose \n");
            try{
                secim=scan.nextInt();
                scan.nextLine();



                break;
            }catch (Exception e){
                System.out.println(" try again hatalı ");
                flag=true;

            }
        }
        while (flag);
        return secim;

    }
}
