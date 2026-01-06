package oo_basic.account;

public class CheckingAccountMain {

    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount();

        account.deposit(1000);

        System.out.println(" Saldo después del ingreso: " + account.getBalance());

        account.withdraw(200);

        System.out.println(" Saldo después del reintegro: " + account.getBalance());

    }
}
