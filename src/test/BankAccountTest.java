package test;

/*
Clase de pruebas unitarias para BankAccount.
Verifica el correcto funcionamiento de las operaciones bancarias.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void testInitialBalanceIsZero() {
        BankAccount account = new BankAccount();
        double balance = account.getBalance();
        assertEquals(0.0, balance, 0.001);
    }

    @Test
    public void testPositiveDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        double balance = account.getBalance();
        assertEquals(100.0, balance, 0.001);
    }

    @Test
    public void testNegativeDepositDoesNotChangeBalance() {
        BankAccount account = new BankAccount();
        account.deposit(-50);
        double balance = account.getBalance();
        assertEquals(0.0, balance, 0.001);
    }

    @Test
    public void testValidWithdrawal() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        account.withdraw(40);
        double balance = account.getBalance();
        assertEquals(60.0, balance, 0.001);
    }

    @Test
    public void testWithdrawalExceedingBalanceNotAllowed() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        account.withdraw(2000);
        double balance = account.getBalance();
        assertEquals(100.0, balance, 0.001);
    }
}
