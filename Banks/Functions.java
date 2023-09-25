import java.util.Scanner;
import java.util.*;

public class Functions {
    static Scanner scanner = new Scanner(System.in);
    private String[] receiver = {"Nguyen Van Hung", "Pham My Hanh", "Le Viet Quang", "Tran My Tam", "Nguyen Hong Nhung"};

    public void transferMoney(Card card) {
        System.out.print("Enter the recipient account number: ");
        String recipientAccountNumber = Functions.scanner.next();
        Random random = new Random();
        int index = random.nextInt(receiver.length);
        System.out.println(receiver[index]);
        System.out.print("Enter the amount you want to send: ");
        double money = Functions.scanner.nextDouble();
        card.setAccountBalance(card.getAccountBalance() - money);
        System.out.println("Successful deposit!");
        Functions.scanner.nextLine();
    }

    public void viewAccountInformation(User user, Card card) {
        String information = user.getName() + "\n" + card.getAccountNumber() + "\n" + String.valueOf(card.getAccountBalance());
        System.out.println(information);

    }
}
