package br.com.mateussm340.cashewmusic.exercises;

import java.util.ArrayList;
import java.util.List;

public class ControllingDataAccessAndWriting {
    public static void main(String[] args) {
        // 2.1
        BankAccount bankAccount = new BankAccount();
        bankAccount.setNumber(1);
        bankAccount.setHolder("Mateus");
        bankAccount.setBalance(450.50);
        bankAccount.viewTechnicalSheet();

        // 2.2
        AgePerson agePerson = new AgePerson();
        agePerson.setLastName("Mateus Maciel");
        agePerson.setAge(24);
        agePerson.ageCheck();

        // 2.3
        Product product = new Product();
        product.setName("Computador");
        product.setPrice(4500);
        product.viewTecnhicalSheet();
        product.applyDiscount();

        // 2.4
        StudentAssessment studentAssessment = new StudentAssessment();
        studentAssessment.setLastName("Mateus Maciel");
        studentAssessment.setGrade(4.0);
        studentAssessment.setGrade(5.0);
        studentAssessment.setGrade(9.0);
        studentAssessment.viewTechnicalSheet();

        // 2.5
        Book book = new Book();
        book.setTitle("Algum livro aí");
        book.setAuthor("Júlio Casares");
        book.viewTechnicalSheet();
    }
}

// 2.1
class BankAccount {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    private int number;
    private double balance;
    private String holder;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getHolder() {
        return this.holder;
    }

    public void viewTechnicalSheet() {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Número da conta: A098B-" + getNumber());
        System.out.println("Titular: " + getHolder());
        System.out.println("Saldo: R$ " + getBalance());
    }
}

// 2.2
class AgePerson {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    private String lastName;
    private int age;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void ageCheck() {
        modelingScreenMatch.generateAsterisk();
        if (getAge() > 17) {
            System.out.println(getLastName() + " é maior de idade");
        } else if (getAge() > 0 && getAge() <= 17) {
            System.out.println(getLastName() + " é menor de idade");
        } else {
            System.out.println(getLastName() + ", idade invalida");
        }

        System.out.println("Idade: " + getAge());
    }
}

// 2.3
class Product {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    private String name;
    private double price;
    private double rate;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void viewTecnhicalSheet() {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Produto: " + getName());
        System.out.println("Preço: " + getPrice());
    }

    public void applyDiscount() {
        this.rate = 0.5;
        double newPrice = getPrice() - (getPrice() * rate);
        System.out.println("Preço com desconto: R$ " + newPrice);
    }
}

// 2.4
class StudentAssessment {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    private String lastName;
    private double grade;
    private double sumGrade;
    private int totalGrade;
    private List<Double> listGrade = new ArrayList<>();

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setGrade(double grade) {
        this.grade = grade;
        this.sumGrade += grade;
        this.totalGrade++;
        listGrade.add(grade);
    }

    public double getGrade() {
        return this.grade;
    }

    public void viewTechnicalSheet() {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Nome do aluno: " + this.getLastName());
        System.out.println("Média do aluno: " + calculateAverage());
        System.out.print("Notas adicionadas: ");

        for (int i = 0; i < listGrade.size(); i++) {
            System.out.print("(" + listGrade.get(i) + ")");
        }

        System.out.println(".");
    }

    public double calculateAverage() {
        return this.sumGrade / this.totalGrade;
    }
}

// 2.5
class Book {
    ModelingScreenMatch modelingScreenMatch = new ModelingScreenMatch();
    private String title;
    private String author;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void viewTechnicalSheet() {
        modelingScreenMatch.generateAsterisk();
        System.out.println("Título do livro: " + getTitle());
        System.out.println("Autor: " + getAuthor());
    }
}