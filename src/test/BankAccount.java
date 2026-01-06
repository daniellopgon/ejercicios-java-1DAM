package test;
/*
Crea una clase de test llamada CuentaBancariaTest y realiza pruebas unitarias para cada uno de los siguientes casos:

Casos a probar:

Al crear una cuenta, el saldo inicial debe ser 0.

Al depositar una cantidad positiva, el saldo debe aumentar correctamente.

Si se intenta depositar una cantidad negativa o cero, el saldo no debe cambiar.

Al retirar una cantidad menor o igual al saldo, el saldo debe disminuir correctamente.

Si se intenta retirar una cantidad mayor que el saldo, el saldo no debe cambiar.
 */

public class BankAccount {

    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount >= 0) {
            this.balance = balance + amount;
        } else {
            System.out.println(" Error al ingresar la cantidad ");
        }
    }

    public void withdraw(double amount) {
        if (balance >= 0 && amount <= balance) {
            this.balance = balance - amount;
        } else {
            System.out.println(" Error no tienes saldo disponible ");
        }
    }

    public double getBalance() {
        return balance;
    }
}
