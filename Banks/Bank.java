import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Bank {
    private Functions functions = new Functions();
    private static List<User> userList = new ArrayList<>();
    private static List<Card> cardList = new ArrayList<>();
    public static final int specifiedAge = 18;
    static Scanner scanner = new Scanner(System.in);

    public void Register() {
        System.out.println("you are registering an account: ");
        System.out.print("Your name: ");
        Main.scanner.nextLine();
        String name = Bank.scanner.nextLine();
        System.out.print("Your age: ");
        int age = Bank.scanner.nextInt();
        if (age < specifiedAge) {
            System.out.println("You are not old enough to create an account. Account creation failed!");
            Bank.scanner.nextLine();
        } else {
            Bank.scanner.nextLine();
            System.out.print("Your gender: ");
            String sex = Bank.scanner.nextLine();
            System.out.print("Your address: ");
            String address = Bank.scanner.nextLine();
            System.out.print("Enter your account number: ");
            String accountNumber = Bank.scanner.next();
            System.out.print("Enter your password: ");
            String pass = Bank.scanner.next();
            System.out.print("How much money do you want to deposit: ");
            double money = Bank.scanner.nextDouble();
            User user = new User(name, age, sex, address);
            Card card = new Card(name, accountNumber, pass, money);
            userList.add(user);
            cardList.add(card);
        }
        System.out.println("Account successfully created!");
        Bank.scanner.nextLine();
    }

    /*public List<String> userData(){
        List<String> stringList = new ArrayList<>();
        int len = userList.size() - 1;
        for (int index = 0; index <= len; index++){
            stringList.add(userList.get(index).informationUser() + cardList.get(0).dataCard());
        }
        return stringList;
    }*/
    public void login() {
        System.out.print("Enter your account: ");
        String account = Bank.scanner.next();
        System.out.print("Enter your password: ");
        String pass = Bank.scanner.next();
        int len = Bank.cardList.size();
        boolean flag = false;
        boolean run = true;
        for (int idx = 0; idx < len; idx++) {
            if (Objects.equals(Bank.cardList.get(idx).getAccountNumber(), account) && Objects.equals(Bank.cardList.get(idx).getPass(), pass)) {
                flag = true;
                System.out.println("Logged in successfully!");
                while (run) {
                    System.out.println("Choose one of the following functions");
                    System.out.println("1: Transfer Money\n2: View Account Information\n3: Exit");
                    System.out.print("You choose: ");
                    int choose = Bank.scanner.nextInt();
                    switch (choose) {
                        case 1:
                            functions.transferMoney(Bank.cardList.get(idx));
                            break;
                        case 2:
                            functions.viewAccountInformation(Bank.userList.get(idx), Bank.cardList.get(idx));
                            break;
                        case 3:
                            run = false;
                            break;
                        default:
                            System.out.println("Function does not exist!");
                            break;
                    }
                }
            }
        }
        if (flag == false) {
            System.out.println("Login failed. Account does not exist!");
            Bank.scanner.nextLine();
        }
    }
}
