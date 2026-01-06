import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    private Gmail getGmail() {
        return new Gmail();
    }

    private Hotmail getHotmail() {
        return new Hotmail();
    }

    private EmailSender getEmailSender(int choice) {
        return switch (choice) {
            case 1 -> getGmail();
            case 2 -> getHotmail();
            default -> null;
        };
    }
    public static void main(String[] args) {
        int choice = input.nextInt();
        EmailSender emailSender = new Main().getEmailSender(choice);
        if (emailSender != null) emailSender.sendEmail();
    }
}
