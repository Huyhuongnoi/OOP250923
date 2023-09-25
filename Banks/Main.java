import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean flag = true;
        while (true) {
            if (flag == false) {
                break;
            }
            System.out.println("YUH BANK WELCOME!");
            System.out.println("1. Login\n2. Register");
            System.out.print("choose: ");
            int choose = Main.scanner.nextInt();
            switch (choose) {
                case 1:
                    Main.bank.login();
                    break;
                case 2:
                    Main.bank.Register();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
    /*public static void writeData(){
        try{
            FileWriter fw = new FileWriter("D:\\Banks\\data.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for(String val:Main.bank.userData()){
                bw.write(val);
                bw.newLine();
            }
            fw.close();
            bw.close();

        } catch(Exception e){
            System.out.println(e);
        }

    }*/
}
