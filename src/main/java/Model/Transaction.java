package Model;

public record Transaction(
        int id,
        double amount,
        String type,
        String date,
        Customer customer
){

}
