package br.com.mateussm340.cashewbank.screen;

import java.util.Scanner;

import br.com.mateussm340.cashewbank.controllers.ControllerOperation;

public class MenuList {
    private Scanner reading = new Scanner(System.in);
    private ControllerOperation controllerOperation = new ControllerOperation();
    private GraphicInterfaceGeneral graphicInterfaceGeneral = new GraphicInterfaceGeneral();

    public int showMenuListOnScreen() {
        String messageMenuListOptions = """

                Operações:

                1 - Consultar saldos.
                2 - Depositar.
                3 - Sacar.
                4 - Sair.
                """;

        System.out.println(messageMenuListOptions);
        System.out.print("Digite a opção desejada: ");
        int chosenOption = reading.nextInt();

        return chosenOption;
    }

    public void showMenuOptionsList(int chosenOption, double balanceClient) {
        while (chosenOption != 4) {

            graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();

            switch (chosenOption) {
                case 1:
                    controllerOperation.showBalanceClient(balanceClient);
                    chosenOption = showMenuListOnScreen();
                    break;
                case 2:
                    balanceClient = controllerOperation.depositBalanceInAccountClient(balanceClient);
                    chosenOption = showMenuListOnScreen();
                    break;
                case 3:
                    balanceClient = controllerOperation.withdrawCustomerAccountClient(balanceClient);
                    chosenOption = showMenuListOnScreen();
                    break;
                case 4:
                    System.out.println("4 - Sair");
                    break;
            }
        }
    }
}