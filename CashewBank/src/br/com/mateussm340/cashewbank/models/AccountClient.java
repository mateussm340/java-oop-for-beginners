package br.com.mateussm340.cashewbank.models;

import br.com.mateussm340.cashewbank.screen.GraphicInterfaceGeneral;
import br.com.mateussm340.cashewbank.screen.MenuList;

public class AccountClient {
    private String lastName = "Mateus da Silva Nunes";
    private String type = "Corrente";
    private double balance = 2500.50;
    private MenuList menuList = new MenuList();
    private GraphicInterfaceGeneral graphicInterfaceGeneral = new GraphicInterfaceGeneral();

    public void showCustomerDataClient() {
        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();

        String messageCustomer = """
                Dados inicias do cliente 

                Nome: %s 
                Tipo de conta: %s
                Saldo inicial: R$ %.2f
                """.formatted(this.lastName, this.type, this.balance);

        System.out.print(messageCustomer);
        int chosenOption = menuList.showMenuListOnScreen();
        menuList.showMenuOptionsList(chosenOption, balance);

        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();
    }
}