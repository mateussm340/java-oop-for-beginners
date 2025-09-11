package br.com.mateussm340.cashewmusic.exercises;

public class CommonBehaviorHandler {
    public static void main(String[] args) {
        ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();

        // 4.1
        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.showConversionToReal(250);

        // 4.2
        RectangularRoomCalculator rectangularRoomCalculator = new RectangularRoomCalculator();
        rectangularRoomCalculator.showRectangleCalculation(4, 8);

        // 4.3
        MultiplicationTable multiplicationTable = new MultiplicationTable();
        multiplicationTable.showTable(6);

        // 4.4
        DefaultTemperatureConverter defaultTemperatureConverter = new DefaultTemperatureConverter();
        defaultTemperatureConverter.viewTechnicalSheet(36, 96.8);

        // 4.5
        modelingScreenMatch.generateAsterisk();
        AppBook appBook = new AppBook();
        appBook.setPrice(450);
        appBook.setRate(10);

        AppPhysicalProduct appPhysicalProduct = new AppPhysicalProduct();
        appPhysicalProduct.setPrice(560);
        appPhysicalProduct.setRate(40);

        // 4.6
        appBook.setAmount(5);
        appBook.viewTecnhicalSheet();

        appPhysicalProduct.setAmount(10);
        appPhysicalProduct.viewTecnhicalSheet();
    }
}

// 4.1
class CurrencyConverter implements FinancialConversion {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    private double dollarToday = 5.45;

    @Override
    public double convertDollarToReal(double dollar) {
        return dollar * this.dollarToday;
    }

    public void showConversionToReal(double valueDollar) {
        modelingScreenMatch.generateAsterisk();
        System.out.println(String.format("Valor em real: R$ %.2f ", convertDollarToReal(valueDollar)));
    }
}

interface FinancialConversion {
    double convertDollarToReal(double dollar);
}

// 4.2
class RectangularRoomCalculator implements GeometricCalculation {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();

    @Override
    public double calculateArea(double height, double width) {
        return height * width;
    }

    public double calculatePerimeter(double height, double width) {
        return 2 * (height + width);
    }

    public void showRectangleCalculation(double height, double width) {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Cálculo da base retangular: ");
        System.out.println("Area: " + calculateArea(height, width) + " cm2");
        System.out.println("Perímetro: " + calculatePerimeter(height, width) + " cm");
    }
}

interface GeometricCalculation {
    double calculateArea(double height, double width);
    double calculatePerimeter(double height, double width);
}

// 4.3
class MultiplicationTable implements IMultiplicationTable {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();

    @Override
    public void showTable(int number) {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Tabuada do número: " + number);

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }
}

interface IMultiplicationTable {
    void showTable(int number);
}

// 4.4
class DefaultTemperatureConverter implements TemperatureConverter {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();

    @Override
    public double celsiusToFahrenheit(int celsius) {
        return celsius * 1.8 + 32;
    }

    @Override
    public int fahrenheitToCelsius(double fahrenheit) {
        return (int) ((fahrenheit - 32) / 1.8);
    }

    public void viewTechnicalSheet(int celsius, double fahrenheit) {
        modelingScreenMatch.generateAsterisk();
        String messageSuccess = """
                1. %d Celsius = %.1f Fahrenheit
                2. %.1f Fahrenheit = %d Celsius 
                """.formatted(celsius, celsiusToFahrenheit(celsius), fahrenheit, fahrenheitToCelsius(fahrenheit));

        System.out.print(messageSuccess);
    }
}

interface TemperatureConverter {
    double celsiusToFahrenheit(int celsius);
    int fahrenheitToCelsius(double fahrenheit);
}

// 4.5
class AppProduct implements Calculable {
    protected double price;
    protected double rate;
    protected int amount;

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setRate(double rate) {
        this.rate = (rate / 100);
    }

    public double getRate() {
        return this.rate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    @Override
    public double calculateFinalPrice(double price) {
        return getPrice() - (getPrice() * getRate());
    }

    @Override
    public double calculateTotalProductPrice(double price, int amount) {
        double priceFinal = getPrice() * getAmount();

        return priceFinal - (priceFinal * getRate());
    }

    public void viewTecnhicalSheet() {
        int getDiscount = (int) (getRate() * 100);

        String messageSuccess = """
                -> Cálculo (Preço Final) - Preço: %.2f | Desconto: %d por cento | Preço Final: %.2f 
                -> Cálculo (Preço Total do Produto) - Preço: %.2f | Quantidade: %d | Desconto: %d por cento | Preço Final: %.2f
                ------------------------------------------------------------------------------------------------------
                """.formatted(
                        getPrice(), getDiscount, calculateFinalPrice(getPrice()),
                        getPrice(), getAmount(), getDiscount, calculateTotalProductPrice(getPrice(), getAmount()));

        System.out.print(messageSuccess);
    }
}

class AppBook extends AppProduct implements Calculable {

}

class AppPhysicalProduct extends AppProduct implements Calculable {

}

interface Calculable {
    double calculateFinalPrice(double price);
    double calculateTotalProductPrice(double price, int amount);
}