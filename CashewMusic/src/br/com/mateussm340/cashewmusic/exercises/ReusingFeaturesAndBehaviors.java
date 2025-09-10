package br.com.mateussm340.cashewmusic.exercises;

public class ReusingFeaturesAndBehaviors {
    public static void main(String[] args) {
        ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();

        // 3.1
        AppCar appCar = new AppCar();
        appCar.setModel("Corolla");
        appCar.setPrices(45900, 39800, 40800);
        appCar.viewTechnicalSheet();

        // 3.2
        modelingScreenMatch.generateAsterisk();
        Dog dog = new Dog();
        dog.emitSound();
        dog.wagTail();

        Cat cat = new Cat();
        cat.emitSound();
        cat.scratchFurniture();

        // 3.3
        modelingScreenMatch.generateAsterisk();
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(3500);
        currentAccount.withdraw(400);
        currentAccount.chargeMonthlyFee();
        currentAccount.checkBalance();

        // 3.4
        modelingScreenMatch.generateAsterisk();
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.listPrimes(20);

        PrimeCheck primeCheck = new PrimeCheck();
        primeCheck.isPrime(12);

        PrimeGenerator primeGenerator = new PrimeGenerator();
        primeGenerator.generateNextPrime(90);
    }
}

// 3.1
class AppCar {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    private String model;
    private double priceOne;
    private double priceTwo;
    private double priceThree;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setPrices(double priceOne, double priceTwo, double priceThree) {
        this.priceOne = priceOne;
        this.priceTwo = priceTwo;
        this.priceThree = priceThree;
    }

    public void viewTechnicalSheet() {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Modelo do carro: " + getModel());
        System.out.println("Preço 01: " + this.priceOne);
        System.out.println("Preço 02: " + this.priceTwo);
        System.out.println("Preço 03: " + this.priceThree);
        System.out.println("-------------------------------------");
        System.out.println("Maior preço: " + showHighestPrice());
        System.out.println("Menor preço: " + showLowestPrice());
    }

    public double showHighestPrice() {
        double highestPrice = this.priceOne;

        if (this.priceTwo > highestPrice) {
            highestPrice = this.priceTwo;
        }

        if (this.priceThree > highestPrice) {
            highestPrice = this.priceThree;
        }

        return highestPrice;
    }

    public double showLowestPrice() {
        double lowestPrice = this.priceOne;

        if (this.priceTwo < lowestPrice) {
            lowestPrice = this.priceTwo;
        }

        if (this.priceThree < lowestPrice) {
            lowestPrice = this.priceThree;
        }

        return lowestPrice;
    }
}

// 3.2
class Animal {
    public void emitSound() {
        System.out.println("emissão padrão de som animal");
    }
}

class Dog extends Animal {
    @Override
    public void emitSound() {
        System.out.println("Som do cachorro: auauau");
    }

    public void wagTail() {
        System.out.println("-> O cachorro está abanando o rabo");
    }
}

class Cat extends Animal {
    @Override
    public void emitSound() {
        System.out.println("Som do gato: miau");
    }

    public void scratchFurniture() {
        System.out.println("-> O gato está arranhando os móveis");
    }
}

// 3.3
class AppBankAccount {
    private int number;
    protected double balance;
    protected double rate;

    public void deposit(double value) {
        if (value > 0) {
            balance += value;
        }
    }

    public void withdraw(double value) {
        if (value <= balance && value > 0) {
            balance -= value;
        }
    }

    public void checkBalance() {
        System.out.println("Saldo atual: " + this.balance);
    }
}

class CurrentAccount extends AppBankAccount {
    public void chargeMonthlyFee() {
        rate = 0.1;
        double monthlyFee = this.balance * rate;
        System.out.println("Taxa mensal: " + monthlyFee);
    }
}

// 3.4
class PrimeNumbers {
    public boolean checkPrimality(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void listPrimes(int limitNumber) {
        for (int i = 2; i <= limitNumber; i++) {
            if (checkPrimality(i)) {
                System.out.print("[" + i + "]");
            }
        }
    }
}

class PrimeCheck extends PrimeNumbers {
    public void isPrime(int number) {
        System.out.println(".");

        if (checkPrimality(number)) {
            System.out.println(number + " é um número primo");
        } else {
            System.out.println(number + " não é um número primo");
        }
    }
}

class PrimeGenerator extends PrimeNumbers {
    public void generateNextPrime(int lastNumberKnownPrime) {
        int nextNumber = lastNumberKnownPrime + 1;

        while (!checkPrimality(nextNumber)) {
            nextNumber++;
        }

        System.out.println(
                "O próximo número primo depois de " + lastNumberKnownPrime + " é " + nextNumber);

        rangeOfNonPrimes(lastNumberKnownPrime, nextNumber);
    }

    public void rangeOfNonPrimes(int startNumber, int endNumber) {
        System.out.print("Intervalo não primo: ");
        for (int i = startNumber; i < endNumber; i++) {
            System.out.print("[" + i + "]");
        }
    }
}