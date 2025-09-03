package br.com.mateussm340.cashewbank.exercises;

// 1.1
public class FirstProgramJava {
    public static void main(String[] args) {
        System.out.println("Olá, Mateus");
        System.out.println("Tudo bem?");
    }
}

// 1.2
class Studies {
    public static void main(String[] args) {
        String studies = """
                -> Meus estudos: 

                1. Java.
                2. Angular.
                3. SQL               
                """;

        System.out.println(studies);
    }
}

// 1.3
class Sum {
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 5;
        int sumNumbers = number1 + number2;

        System.out.println(number1 + " + " + number2 + " = " + (sumNumbers));
    }
}


// 1.4
class Subtraction {
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 5;
        int subtractionNumbers = number1 - number2;

        System.out.println(number1 + " - " + number2 + " = " + (subtractionNumbers));
    }
}