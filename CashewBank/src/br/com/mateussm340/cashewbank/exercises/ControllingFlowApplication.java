package br.com.mateussm340.cashewbank.exercises;

import java.util.Random;
import java.util.Scanner;

import br.com.mateussm340.cashewbank.screen.GraphicInterfaceGeneral;

public class ControllingFlowApplication {
    GraphicInterfaceGeneral graphicInterfaceGeneral = new GraphicInterfaceGeneral();
    Scanner reading = new Scanner(System.in);

    public static void main(String[] args) {
        ControllingFlowApplication controllingFlowApplication = new ControllingFlowApplication();

        controllingFlowApplication.positiveNegativeNumber();
        controllingFlowApplication.numberComparator();
        controllingFlowApplication.areaCalculator();
        controllingFlowApplication.showMultiplicationTableOnScreen();
        controllingFlowApplication.checkingOddEvenNumbers();
        controllingFlowApplication.findOutFactorialNumber();
        controllingFlowApplication.gameSecretNumber();
    }

    // 3.1
    public void positiveNegativeNumber() {
        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();

        System.out.print("Digite um número inteiro diferente de zero: ");
        int number = reading.nextInt();

        String textDefault = "O número " + number + " ";

        if (number > 0) {
            System.out.println(textDefault + "é positivo");
        } else if (number < 0) {
            System.out.println(textDefault + "é negativo");
        } else {
            System.out.println(textDefault + "não é positivo/negativo");
        }
    }

    // 3.2
    public void numberComparator() {
        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();

        System.out.print("Digite um número inteiro: ");
        int numberOne = reading.nextInt();

        System.out.print("Digite outro número inteiro: ");
        int numberTwo = reading.nextInt();

        if (numberOne == numberTwo) {
            System.out.println(numberOne + " é igual ao " + numberTwo);
        } else if (numberOne != numberTwo) {
            System.out.println(numberOne + " é diferente de " + numberTwo);
        }

        if (numberOne >= numberTwo) {
            System.out.println(numberOne + " é maior ou igual ao " + numberTwo);
        } else if (numberTwo >= numberOne) {
            System.out.println(numberTwo + " é maior ou igual ao " + numberOne);
        }
    }

    // 3.3
    public int menuListAreaCalculator() {
        String menuOptions = """
                -------------------------------
                1. Calcular área do quadrado.
                2. Calcular área do círculo.
                3. Sair.
                -------------------------------
                """;

        System.out.println(menuOptions);

        System.out.print("Escolha uma opção: ");
        int chosenOption = reading.nextInt();

        return chosenOption;
    }

    public void areaCalculator() {
        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();

        int chosenOption = menuListAreaCalculator();

        while (chosenOption != 3) {
            switch (chosenOption) {
                case 1:
                    System.out.println("Calculando área do quadrado: ");

                    System.out.print("-> Digite o lado do quadrado em cm: ");
                    double side = reading.nextDouble();
                    double areaSide = side * side;

                    System.out.println("-> Área total do quadrado é " + areaSide + "cm2");

                    chosenOption = menuListAreaCalculator();
                    break;
                case 2:
                    System.out.println("Calculando área do círculo: ");

                    System.out.print("-> Digite o raio do círculo em cm: ");
                    double circleRadius = reading.nextDouble();
                    double areaCircle = 3.14 * Math.pow(circleRadius, 2);

                    System.out.println("-> Área total do círculo é " + areaCircle + " cm2");
                    chosenOption = menuListAreaCalculator();
                    break;
            }
        }
    }

    // 3.4
    public void showMultiplicationTableOnScreen() {
        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();

        System.out.print("Digite um número entre 1 e 10: ");
        int number = reading.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }

    // 3.5
    public void checkingOddEvenNumbers() {
        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();

        int number = -1;

        while (number < 0) {
            System.out.print("Digite um número (Iniciando do zero): ");
            number = reading.nextInt();
        }

        for (int i = 0; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " é par");
            }

            if (i % 2 != 0) {
                System.out.println(i + " é ímpar");
            }
        }
    }

    // 3.6
    public void findOutFactorialNumber() {
        graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();

        System.out.print("Digite um número: ");
        int number = reading.nextInt();

        int factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        System.out.println("O fatorial do número " + number + " é " + factorial);
    }

    // Challenge Extra - Secret Number
    public void gameSecretNumber() {
        Random random = new Random();

        int numberMax = 10;
        int secretNumber = random.nextInt(numberMax);
        int kick = 0;
        int attempt = 1;
        int numberAttemptLimit = 6;
        int numberAttemptRemaining = numberAttemptLimit - attempt;
        String wordAttempt = attempt > 1 ? "tentativas" : "tentativa";

        System.out.println(secretNumber);

        while (attempt != numberAttemptLimit) {
            graphicInterfaceGeneral.generateSequenceAsteriskAutomatic();
            System.out.println("Quantidade restante de tentativa: " + numberAttemptRemaining);

            System.out.print("Digite um chute para número secreto (Tentativa " + (attempt) + "): ");
            kick = reading.nextInt();

            if (kick == secretNumber) {
                System.out.println("Você acertou o número secreto " + secretNumber + " com " + attempt + " " + wordAttempt);
                break;
            } else {
                if (kick > secretNumber) {
                    System.out.println("O número secreto é menor que " + kick);
                } else {
                    System.out.println("O número secreto é maior que " + kick);
                }

                attempt++;
            }

            numberAttemptRemaining--;
        }

        if (numberAttemptRemaining == 0 && kick != secretNumber) {
            System.out.println("Você atingiu o limite máximo de " + (attempt - 1) + " " + wordAttempt + ", tente novamente");
        }
    }
}