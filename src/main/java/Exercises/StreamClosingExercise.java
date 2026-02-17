package Exercises;

import Model.Customer;
import Model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StreamClosingExercise {

    private List<Transaction> transactions;

    public StreamClosingExercise() {
        this.transactions = getTransactions();
    }

    public List<Transaction> getTransactions() {
        List<Transaction> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(
                    new Transaction(
                            i,
                            Math.random() * 1000,
                            i % 2 == 0 ? "CREDIT" :"DEBIT",
                            "2026-" + String.format("%02d", (i % 12) + 1) + "-" + String.format("%02d", (i % 28 + 1)),
                            new Customer(i, "Customer " + i, "customer_" + i + "@example.com")
                    )
            );
        }
        return list;
    }

    public void number1() {
        transactions.stream()
                .filter(t -> "CREDIT".equals(t.type()))
                .forEach(System.out::println);
    }

    public void number2() {
        double totalSum = transactions.stream()
                .mapToDouble(Transaction::amount)
                .sum();
        System.out.println("Total Sum :" + totalSum);
    }

    public void number3() {
        double highestTransaction = transactions.stream()
                .mapToDouble(Transaction::amount)
                .sorted()
                .reduce((first, second) -> second)
                .orElse(0);
        System.out.println("Highest Transaction: " + highestTransaction);
    }

    public void number4() {
        int totalTransactions = transactions.size();
        int totalDebitCount = (int) transactions.stream()
                .filter(transaction -> "DEBIT".equals(transaction.type()))
                .count();
        int totalCreditCount = totalTransactions - totalDebitCount;

        System.out.println("Total Transaction: " + totalTransactions);
        System.out.println("Total Debit Count: " + totalDebitCount);
        System.out.println("Total Credit Count: " + totalCreditCount);
    }

    public void number5() {
        transactions.stream()
                .map(Transaction::customer)
                .distinct()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {

    }
}
