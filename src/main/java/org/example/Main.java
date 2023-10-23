package org.example;

import org.example.labs.Lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Программная реализация лабораторных рабор по ОТПИ:
                1.Лаб.работа №1 "RLE-алгоритм"
                2.Лаб.работа №2 "Кодирование методом Шеннона-Фано"
                3.Лаб.работа №3 "Кодирование методом Шеннона-Фано по блокам"
                """);
        boolean exit = false;
        while(!exit){
            System.out.print("Введите опцию: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch(option){
                case 1 -> Lab1.solve();
                case 2 -> System.out.println("lab 2");
                case 3 -> System.out.println("lab 3");
                default -> exit = true;
            }
        }


    }
}