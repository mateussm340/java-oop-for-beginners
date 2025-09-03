package br.com.mateussm340.cashewbank.exercises;

import br.com.mateussm340.cashewbank.screen.GraphicInterfaceGeneral;

public class BuildingCatalogFilms {
    GraphicInterfaceGeneral graphicInterfaceGeneral = new GraphicInterfaceGeneral();

    public static void main(String[] args) {
        BuildingCatalogFilms buildingCatalogFilms = new BuildingCatalogFilms();

        buildingCatalogFilms.calculateMedia(8.5, 5.5);
        buildingCatalogFilms.castingVariables();
        buildingCatalogFilms.concatenationStringChar();
        buildingCatalogFilms.returnTotalProductPrice();
        buildingCatalogFilms.dollarConverter();
        buildingCatalogFilms.discountProduct();
    }

    // 2.1
    public void calculateMedia(double numberOne, double numberTwo) {
        double average = (numberOne + numberTwo) / 2;

        String message = """
                Nota 1: %.1f
                Nota 2: %.1f
                Média: %.2f
                """.formatted(numberOne, numberTwo, average);

        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();
        System.out.print(message);
    }

    // 2.2
    public void castingVariables() {
        int totalNumber = 2;
        double average = (3.5 + 5.5) / totalNumber;
        int rating = (int) average / totalNumber;

        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();
        System.out.println("Média: " + average);
        System.out.println("Classificação (1 até 5): " + rating);
    }

    // 2.3
    public void concatenationStringChar() {
        String nameInitial = "Mateu";
        char finalLetter = 's';
        String lastName = nameInitial + finalLetter;

        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();
        System.out.println(nameInitial + " + " + finalLetter + " = " + (lastName));
        System.out.println(nameInitial + finalLetter);
    }

    // 2.4
    public void returnTotalProductPrice() {
        double priceProduct = 250.90;
        int amount = 4;
        double totalProductPrice = priceProduct * amount;

        String message = """
                Preço do produto: %.2f
                Quantidade: %d
                Preço total: %.2f                
                """.formatted(priceProduct, amount, totalProductPrice);

        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();
        System.out.print(message);
    }

    // 2.5
    public void dollarConverter() {
        double dollarValue = 567.90;
        double dollarExchange = 5.43;
        double realValue = dollarValue * dollarExchange;

        String message = """
                Dólar: %.2f em reais: R$ %.2f                
                """.formatted(dollarValue, realValue);

        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();
        System.out.print(message);
    }

    // 2.6
    public void discountProduct() {
        double priceProduct = 456.90;
        int percentage = 30;
        double discount = (double) percentage / 100;
        double newPriceProduct = priceProduct - (priceProduct * discount);

        String message = """
                Preço do produto: %.2f
                Porcentagem: %d por cento
                Novo preço: %.2f
                """.formatted(priceProduct, percentage, newPriceProduct);

        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();
        System.out.print(message);
    }
}

