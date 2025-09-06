package br.com.mateussm340.cashewbank.controllers;

import java.util.Scanner;

import br.com.mateussm340.cashewbank.screen.GraphicInterfaceGeneral;

public class ControllerOperation {
    GraphicInterfaceGeneral graphicInterfaceGeneral = new GraphicInterfaceGeneral();
    Scanner reading = new Scanner(System.in);

    public void showBalanceClient(double balanceClient) {
        System.out.println("O saldo atual é R$ " + balanceClient);
    }

    public double depositBalanceInAccountClient(double balanceClient) {
        System.out.println("2 - Depositar.\n");
        System.out.print("-> Digite o valor do deposito: ");
        double deposit = reading.nextDouble();

        if (deposit > 0) {
            balanceClient += deposit;
            System.out.println("-> O deposito de R$ " + deposit + " foi realizado com sucesso");

            showBalanceClient(balanceClient);
        } else {
            System.out.println("-> Não é possível realizar um deposito no valor de R$ " + deposit);
        }

        return balanceClient;
    }

    public double withdrawCustomerAccountClient(double balanceClient) {
        System.out.println("3 - Sacar\n");
        System.out.print("-> Digite o valor do saque: ");
        double withdraw = reading.nextDouble();

        if (withdraw <= balanceClient && withdraw > 0) {
            System.out.println("Você sacou R$ " + withdraw + " de R$ " + balanceClient);
            balanceClient -= withdraw;

            showBalanceClient(balanceClient);
        } else {
            System.out.println("Você não pode realizar um saque no valor de R$ " + withdraw);
        }

        return balanceClient;
    }
}