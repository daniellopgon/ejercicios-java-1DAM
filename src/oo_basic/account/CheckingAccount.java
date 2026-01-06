package oo_basic.account;

/*
Se desea llevar un control del estado de una cuenta corriente.
La cuenta corriente está caracterizada por su saldo y sobre ella se
pueden realizar tres tipos de operaciones:
saldo: devuelve el saldo de la cuenta (puede ser negativo).
imposición (cantidad): ingresa en la cuenta una cantidad de dinero.
reintegro (cantidad): saca de la cuenta una determinada cantidad de dinero.
        Supón que la cuenta corriente tiene inicialmente un saldo de cero y cree una clase CuentaCorriente con toda la funcionalidad necesaria.
Escriba una clase con un método main que pruebe la funcionalidad descrita.
 */

public class CheckingAccount {
    int balance;

    public CheckingAccount() {
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amountToDeposit) {
        this.balance = getBalance() + amountToDeposit;
    }

    public void withdraw(int amountToWithdraw) {
        this.balance = getBalance() - amountToWithdraw;
    }
}
