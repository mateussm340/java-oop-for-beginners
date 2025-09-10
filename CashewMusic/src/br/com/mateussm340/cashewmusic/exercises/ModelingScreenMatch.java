package br.com.mateussm340.cashewmusic.exercises;

import java.time.LocalDateTime;

public class ModelingScreenMatch {
    public static void main(String[] args) {
        // 1.1
        Person person = new Person();
        person.showMessage();

        // 1.2
        Calculator calculator = new Calculator();
        calculator.returnDoubleNumber(45);

        // 1.3
        Music music = new Music();
        music.title = "Tarde Demais";
        music.artist = "Dorgival Dantas";
        music.yearRelease = 2010;

        music.rate(8.0);
        music.rate(5.0);
        music.rate(5.0);
        music.showTechnicalSheet();

        // 1.4
        Car car = new Car();
        car.model = "Corolla";
        car.year = 2019;
        car.viewTechnicalSheet();

        // 1.5
        Student student = new Student();
        student.lastName = "Mateus Maciel";
        student.age = 24;
        student.viewTechnicalSheet();
    }

    public void generateAsterisk() {
        int limitTotal = 40;
        String asteriskTotal = "*";
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < limitTotal; i++) {
            stringBuffer.append(asteriskTotal);
        }

        System.out.println(stringBuffer);
    }
}

// 1.1
class Person {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();

    public void showMessage() {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Olá, mundo!");
    }
}

// 1.2
class Calculator {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();

    public void returnDoubleNumber(int number) {
        modelingScreenMatch.generateAsterisk();
        int doubleNumber = number * 2;
        System.out.println("O dobro de " + number + " é " + doubleNumber);
    }
}

// 1.3
class Music {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    String title;
    String artist;
    int yearRelease;
    double totalRatings;
    int ratingCount;

    public void showTechnicalSheet() {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Título da música: " + this.title);
        System.out.println("Artista: " + this.artist);
        System.out.println("Ano de lançamento: " + this.yearRelease);
        System.out.println("Nota da música: " + getRating());
    }

    public void rate(double rating) {
        totalRatings += rating;
        ratingCount++;
    }

    public double getRating() {
        return totalRatings / ratingCount;
    }
}

class Car {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    String model;
    int year;
    LocalDateTime dateTime = LocalDateTime.now();
    int currentYear = dateTime.getYear();

    public void viewTechnicalSheet() {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Modelo do carro: " + this.model);
        System.out.println("Ano: " + this.year);
        System.out.println("Idade do carro: " + calculateCarAge() + " anos");
    }

    public int calculateCarAge() {
        return currentYear - year;
    }
}

// 1.5
class Student {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    String lastName;
    int age;

    public void viewTechnicalSheet() {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Nome do aluno: " + this.lastName);
        System.out.println("Idade do aluno: " + this.age);
    }
}