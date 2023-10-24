package org.example.labs;

import org.example.algorithms.RLE_PCX;
import org.example.utils.Utils;

public class Lab1 {

    public static void solve(){
        String toEncode = "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD03245674616416ADC2AD1C1DFBEDDFBEDFEBEFFCD";
        String toDecode = "C1FFC5EFC3C2A1D0BFBEC1C6C3FF";

        System.out.println("Лабораторная работа №1: RLE");
        System.out.println("Маслюк Виталий 8В14 Вариант 12\n");
        System.out.println("Строка для сжатия: " + toEncode);
        String encodedString = RLE_PCX.encode(toEncode);

        System.out.println("Сжатая строка: " + encodedString);

        System.out.println("Эффективность сжатия: " + Utils.calculateEfficiency(encodedString.length(), toEncode.length()) + "%" + "\n");
        System.out.println("Строка для распаковки: " + toDecode);
        String decodedString = RLE_PCX.decode(toDecode);
        System.out.println("Распакованная строка: " + decodedString);
        System.out.println("Эффективность сжатия: " + Utils.calculateEfficiency(toDecode.length(), decodedString.length()) + "%");

    }



}
