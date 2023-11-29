package org.example.labs;

import org.example.algorithms.EliasDecoding;
import org.example.algorithms.EliasEncoding;

public class Lab5 {

    public static void solve(){
        System.out.println("Лабораторная работа №5: Кодирование дельта-,омега-, гамма- кодами Элиаса");
        System.out.println("Маслюк Виталий 8В14 Вариант 2");
        System.out.println("1.Закодировать число 63 гамма-, дельта- и омега- кодом Элиаса");
        int n = 63;
        System.out.println("1.1. Число 63 в гамма-коде: " + EliasEncoding.gammaEncoding(n));
        System.out.println("1.2. Число 63 в дельта-коде: " + EliasEncoding.deltaEncoding(n));
        System.out.println("1.3. Число 63 в омега-коде: " + EliasEncoding.omegaEncoding(n));

        System.out.println("2. Декодирование гамма-кода Элиаса:");
        System.out.println("2.1. 011 => " + EliasDecoding.gammaDecoding("011"));
        System.out.println("2.2. 0001010 => " + EliasDecoding.gammaDecoding("0001010"));

        System.out.println("3. Декодирование дельта-кода Элиаса:");
        System.out.println("3.1. 01110 => " + EliasDecoding.deltaDecoding("01110"));
        System.out.println("3.2. 0011011011 => " + EliasDecoding.deltaDecoding("0011011011"));

        System.out.println("4. Декодирование омега-кода Элиаса:");
        System.out.println("4.1. 101100 => " + EliasDecoding.omegaDecoding("101100"));
        System.out.println("4.2. 10100101000 => " + EliasDecoding.omegaDecoding("10100101000"));
    }
}
