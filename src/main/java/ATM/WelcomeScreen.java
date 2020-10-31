package ATM;

import java.util.Scanner;

public class WelcomeScreen {

    public static void WelcomeScreen() {

        System.out.println("\t-= Welcome =-" +
                "\n\t-= Group 1 =-" +
                "\n  -= ATM Project =-" +
                "\nPlease Enter Card Number");
        Scanner sc = new Scanner(System.in);
        String cardNum = sc.nextLine();

        for(int i = 1; i <= DataBase.lengthOfList(); i++) {
            if (cardNum.equals(DataBase.readExcelFile(i, 0))) {
                if(DataBase.readExcelFile(i, 1).equals("0")) {
                    if(isPinCorrect(i)) {
                        MainMenu.menu(i);
                    }
                } else {
                    System.out.println("Your account is blocked");
                }
            }
        }
    }

    public static boolean isPinCorrect(int clientNum) {

        boolean result = false;
        for(int i = 0; i < 3; i++) {
            int count = 0;
            System.out.println("Enter your PIN");
            Scanner sc = new Scanner(System.in);
            String pin =  sc.nextLine();
            if(pin.equals(DataBase.readExcelFile(clientNum, 2))) {
                System.out.println(DataBase.readExcelFile(clientNum, 2));
                result = true;
                break;
            } else {
                System.out.println("Try again");
                count++;
                if(count == 2) {
                    System.out.println("Account is blocked - call the office");
                    //make a record in the client's file
                    break;
                }
            }
        }
        return result;
    }
}
