package edu.course.lab02;

public class BankAccount {
    private int balance;

    public BankAccount(int rebalance) {
        this.balance = rebalance;
    }

    public void deposit(int amount){
        if (amount <= 0){
            throw new IllegalArgumentException("amount не может быть отрицательным");
        }
        this.balance += amount;
    }
    public void withdraw(int amount){
        if (amount  <= 0){
            throw new IllegalArgumentException("amount не может быть отрицательным");
        }
        if (amount > balance){
            throw  new IllegalArgumentException("amount не может превышать остаток");
        }
        this.balance -= amount;
    }
    public int getBalance(){
        return balance;
    }
}
