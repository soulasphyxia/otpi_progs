package org.example.labs;

import org.example.algorithms.ShannonFanoEncoder;
import org.example.utils.Letter;
import org.example.utils.Utils;

import java.lang.reflect.Array;
import java.util.*;

public class Lab3 {

    public static void solve(){
        String s = "МАСЛЮК ВИТАЛИЙ ОЛЕГОВИЧ";
        HashSet<Character> alphabetSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            alphabetSet.add(s.charAt(i));
        }

        ArrayList<Letter> alphabet = new ArrayList<>();
        for(Character c : alphabetSet){
            if(c.equals(' ')){
                alphabet.add(new Letter("\" \"", (double) Utils.count(c, s) / s.length()));
            }else{
                alphabet.add(new Letter(String.valueOf(c), (double) Utils.count(c, s) / s.length()));
            }
        }
        alphabet.sort(Collections.reverseOrder());
        ShannonFanoEncoder encoder = new ShannonFanoEncoder(alphabet);
        HashMap<Letter, String> codes = encoder.encode();
        double[] probs = new double[alphabet.size()];
        for(int i = 0; i < probs.length; i++){
            probs[i] = alphabet.get(i).getProb();
        }

        System.out.println("Лабораторная работа №3: Кодировка Шеннона-Фано по блокам");
        System.out.println("Маслюк Виталий 8В14");
        System.out.println("----------------------------------------------------");
        System.out.println("Задание 1: Кодирование ФИО");
        System.out.println("Hmax = " + String.format("%.2f",Utils.log2(s.length())));
        System.out.println("H = " + String.format("%.2f",Utils.calculateEntropy(probs)));
        System.out.println("Коды для алфавита:");
        double kc = 0;
        for(Letter key : alphabet){
            System.out.println(key + " = " + codes.get(key));
            kc += key.getProb() * codes.get(key).length();
        }

        System.out.println("Кс = " + kc);

        System.out.println("D: " + String.format("%.2f",Utils.calculateReduancy(probs, s.length())));
        System.out.println("----------------------------------------------------");
        System.out.println("Задание 2: Блочное кодирование");
        System.out.println("Вариант 2. Вероятности: a = 0.3, b = 0.7");
        double a = 0.3;
        double b = 0.7;
        ArrayList<Double> diffs = new ArrayList<>();
        System.out.println("1. Кодирование по одному символу: ");
        alphabet.clear();
        alphabet.add(new Letter("a",a));
        alphabet.add(new Letter("b",b));
        encoder.setLetters(alphabet);
        codes = encoder.encode();

        System.out.println("Коды:");
        System.out.println(codes);
        double L1 = calculateL1(codes);
        double H1 = calculateH1(codes);
        System.out.println("L1 = " + String.format("%.2f",L1));
        System.out.println("H1 = " + String.format("%.2f",H1));
        diffs.add(Math.abs(L1 - H1));

        System.out.println("2. Кодирование по два символа: ");
        alphabet.clear();
        alphabet.add(new Letter("aa",a*a));
        alphabet.add(new Letter("ab",a*b));
        alphabet.add(new Letter("ba",b*a));
        alphabet.add(new Letter("bb",b*b));
        encoder.setLetters(alphabet);
        codes = encoder.encode();
        System.out.println("Коды:");
        System.out.println(codes);
        L1 = calculateL1(codes);
        H1 = calculateH1(codes);
        System.out.println("L1 = " + String.format("%.2f",L1));
        System.out.println("H1 = " + String.format("%.2f",H1));
        diffs.add(Math.abs(L1 - H1));
        System.out.println("3. Кодирование по три символа: ");
        alphabet.clear();
        alphabet.add(new Letter("aaa",a*a*a));
        alphabet.add(new Letter("aab",a*a*b));
        alphabet.add(new Letter("aba",a*a*b));
        alphabet.add(new Letter("baa",a*a*b));
        alphabet.add(new Letter("abb",a*b*b));
        alphabet.add(new Letter("bab",a*b*b));
        alphabet.add(new Letter("bba",a*b*b));
        alphabet.add(new Letter("bbb",b*b*b));
        encoder.setLetters(alphabet);
        codes = encoder.encode();
        System.out.println("Коды:");
        System.out.println(codes);
        L1 = calculateL1(codes);
        H1 = calculateH1(codes);
        System.out.println("L1 = " + String.format("%.2f",L1));
        System.out.println("H1 = " + String.format("%.2f",H1));
        diffs.add(Math.abs(L1 - H1));

        System.out.println("Сравним полученные разницы L1 и H1:");
        for(int i = 0; i < diffs.size(); i++){
            System.out.println(i+1 + "." + "|L1 - H2| = " + diffs.get(i));
        }

        double min = diffs.stream().sorted().toList().get(0);
        int index = diffs.indexOf(min);


        System.out.println("Оптимальное количество блоков для кодирования: " + (index + 1));




        System.out.println("----------------------------------------------------");
    }


    private static double calculateL1(HashMap<Letter, String> codes){
        double L1 = 0;
        for(Letter l : codes.keySet()){
            L1 += l.getProb() * codes.get(l).length();
        }
        return L1;
    }
    private static double calculateH1(HashMap<Letter, String> codes){
        ArrayList<Letter> codesLetters = new ArrayList<>(codes.keySet());
        double[] probs = new double[codesLetters.size()];
        for(int i = 0; i < probs.length; i++){
            probs[i] = codesLetters.get(i).getProb();
        }

        return Utils.calculateEntropy(probs);
    }




}
