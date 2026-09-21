package edu.course.lab02;
import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void constructorAcceptsZeroBalance() {
        BankAccount account = new BankAccount(0);
        assertEquals(0, account.getBalance());
    }

    @Test
    void constructorAcceptsPositiveBalance() {
        BankAccount account = new BankAccount(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void constructorThrowsForNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-1));
    }


    @Test
    void depositIncreasesBalance() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void depositThrowsForZero() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    void depositThrowsForNegative() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
    }

    @Test
    void depositDoesNotChangeBalanceWhenThrows() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
        assertEquals(100, account.getBalance());
    }


    @Test
    void withdrawDecreasesBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    @Test
    void withdrawFullBalanceLeavesZero() {
        BankAccount account = new BankAccount(100);
        account.withdraw(100);
        assertEquals(0, account.getBalance());
    }

    @Test
    void withdrawThrowsForZero() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }

    @Test
    void withdrawThrowsForNegative() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
    }

    @Test
    void withdrawThrowsWhenAmountExceedsBalance() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(150));
    }

    @Test
    void withdrawDoesNotChangeBalanceWhenThrows() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(150));
        assertEquals(100, account.getBalance());
    }

}