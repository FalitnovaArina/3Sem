package book;

import java.util.Scanner;

public class Menu {
    public static void getMenu(){
        System.out.println("1)Output calls");
        System.out.println("2)Add new call");
        System.out.println("3)Delete call");
        System.out.println("4)Output calls date to date");
        System.out.println("5)Output calls from specific person");
        System.out.println("6)Output calls to specific person");
        System.out.println("7)Exit");
    }

    public static DateTime getDateTime(){
        Scanner input = new Scanner(System.in);
        DateTime dateTime = new DateTime();
        System.out.println("Enter year: ");
        dateTime.setYear(input.nextInt());
        System.out.println("Enter month: ");
        dateTime.setMonth(input.nextInt());
        System.out.println("Enter day: ");
        dateTime.setDay(input.nextInt());
        return dateTime;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filePath = new String("C:\\Users\\korol\\IdeaProjects\\book\\src\\memory.txt");
        boolean exit = true;
        Book.addFromFile(filePath);
        while(exit){
            getMenu();
            switch(input.nextInt()){
                case(1):
                    Book.callsOutput();
                    break;
                case(2):
                    Book.add();
                    break;
                case(3):
                    Book.remove();
                    break;
                case(4):
                    Book.dateToDate(getDateTime(), getDateTime());
                    break;
                case(5):
                    Book.outputFrom();
                    break;
                case(6):
                    Book.outputTo();
                    break;
                case(7):
                    exit = false;
            }
        }
        Book.addToFile(filePath);
    }
}
