package book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private static ArrayList<Call> book = new ArrayList();

    public static void addFromFile(String filename){
        try(FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader)){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(" ");
                Subscriber outcoming = new Subscriber(data[0],data[1]);
                Subscriber incoming = new Subscriber(data[2],data[3]);
                DateTime dateTime = new DateTime(Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6]),Integer.parseInt(data[7]),Integer.parseInt(data[8]));
                book.add(new Call(outcoming,incoming,dateTime,Integer.parseInt(data[9])));
            }
        }
        catch (IOException e){
        }
    }

    public static void addToFile(String filename){
        try(FileWriter fileWriter = new FileWriter(filename)){
            for(Call cur : book) {
                fileWriter.write(cur.toString() + "\n");
            }
        }
        catch(IOException e){
        }
    }

    public static void callsOutput(){
        int ind = 1;
        for(Call cur : book){
            System.out.println( ind + " " + cur.toString());
            ind++;
        }
    }

    public static void add(){
        Scanner input = new Scanner(System.in);
        Call call = new Call();
        Subscriber out = new Subscriber();
        Subscriber in = new Subscriber();
        DateTime dateTime = new DateTime();

        System.out.println("Enter caller: ");
        out.setName(input.nextLine());
        System.out.println("Enter caller number: ");
        out.setPhone(input.nextLine());
        call.setOutgoing(out);

        System.out.println("Enter incomer: ");
        in.setName(input.nextLine());
        System.out.println("Enter caller number: ");
        in.setPhone(input.nextLine());
        call.setIncoming(in);

        System.out.println("Enter year: ");
        dateTime.setYear(input.nextInt());
        System.out.println("Enter month: ");
        dateTime.setMonth(input.nextInt());
        System.out.println("Enter day: ");
        dateTime.setDay(input.nextInt());

        System.out.println("Enter hour: ");
        dateTime.setHour(input.nextInt());
        System.out.println("Enter minutes: ");
        dateTime.setMinutes(input.nextInt());
        call.setDateTime(dateTime);

        System.out.println("Enter duration: ");
        call.setDuration(input.nextInt());
        book.add(call);
    }

    public static void remove(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of call: ");
        book.remove(input.nextInt() - 1);
    }

    public static void dateToDate(DateTime begin, DateTime end){
        for(Call cur : book){
            if( !begin.isBigger(cur.getDateTime()) && end.isBigger(cur.getDateTime())){
                System.out.println(cur);
            }
        }
    }

    public static void outputFrom(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter caller name: ");
        String name = input.nextLine();
        int ind = 1;
        for(Call cur : book){
            if(cur.getOutgoing().getName().equals(name)){
                System.out.println(ind + " " + cur.toString());
            }
            ind++;
        }
    }

    public static void outputTo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter incomer name: ");
        String name = input.nextLine();
        int ind = 1;
        for(Call cur : book){
            if(cur.getIncoming().getName().equals(name)){
                System.out.println(ind + " " + cur.toString());
            }
            ind++;
        }
    }

}
