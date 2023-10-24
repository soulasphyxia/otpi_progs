package org.example;

import org.example.labs.Lab1;
import org.example.labs.Lab2;
import org.example.labs.Lab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
                Программная реализация лабораторных работ по ОТПИ:
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
                case 2 -> Lab2.solve();
                case 3 -> Lab3.solve();
                default -> exit = true;
            }
        }


    }
}