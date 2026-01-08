public class Gmail implements EmailSender {
    @Override
    public void sendEmail(String email) {
        System.out.println("Sending Email Using Gmail");
    }
}
