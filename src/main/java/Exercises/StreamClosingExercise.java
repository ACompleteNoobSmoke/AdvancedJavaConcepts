package Exercises;

import Model.Customer;
import Model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

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

    public void number6() {
        transactions.stream()
                .filter(transaction -> Double.valueOf("300").compareTo(transaction.amount()) < 0)
                .forEach(System.out::println);
    }

    public void number7() {
        transactions.stream()
                .collect(Collectors.groupingBy(s -> s.customer().id()));
    }

    public void number8() {
        Transaction firstTransaction = transactions.stream()
                .findFirst().orElse(null);
        System.out.println(firstTransaction);
    }

    public void number9() {
        boolean isGreaterThan100 = transactions.stream()
                .map(Transaction::amount)
                .anyMatch(t -> t > 100);
        System.out.println("Greater Than 100: " + isGreaterThan100);
    }

    public void number10() {
        transactions.stream()
                .sorted(Comparator.comparingDouble(Transaction::amount))
                .forEach(System.out::println);
    }

    public void number11() {
        double average = transactions.stream()
                .mapToDouble(Transaction::amount)
                .average().orElse(-1);

        System.out.println("Average: " + average);
    }

    public void number12() {
        transactions.stream()
                .filter(transaction -> transaction.customer().name().equals("Customer 1"))
                .forEach(System.out::println);
    }

    public void number13() {
        List<Transaction> transactionList = transactions.stream().distinct().toList();
        transactionList.forEach(System.out::println);
    }

    public void number14() {
        String names = transactions.stream()
                .map(transaction -> transaction.customer().name())
                .distinct()
                        .collect(Collectors.joining(","));
        System.out.println(names);
    }

    public void number15() {
        Transaction earliestTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::date))
                .orElse(null);
        System.out.println(earliestTransaction);
    }

    public void number16() {
        List<Transaction> transactionList = transactions.stream()
                .filter(Objects::nonNull)
                .filter(transaction -> transaction.date().contains("2024"))
                .toList();
        transactionList.forEach(System.out::println);
    }

    public void number17() {
        Map<Customer, Double> customerSum = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::customer, Collectors.summingDouble(Transaction::amount)));

        customerSum.forEach((k, v) -> {
            System.out.println("Customer: " + k.name());
            System.out.println("Sum: " + v);
            System.out.println();
        });
    }

    public void number18() {
        List<Transaction> debitList = transactions.stream()
                .filter(Objects::nonNull)
                .filter(transaction -> transaction.type().contains("DEBIT"))
                .toList();
        debitList.forEach(System.out::println);
    }

    public void number19() {
        Map<String, List<Transaction>> transactionMap = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::type));

        transactionMap.forEach((k, v) -> {
            System.out.println("Type: " + k);
            v.forEach(System.out::println);
            System.out.println();
        });
    }

    public void number20() {
        List<Transaction> transactionList = transactions.stream()
                .filter(transaction -> transaction.customer().email().contains("example.com"))
                .toList();
        transactionList.forEach(System.out::println);
    }

    public static void main(String[] args) {

    }
}
