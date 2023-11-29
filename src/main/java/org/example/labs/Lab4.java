package org.example.labs;

import org.example.algorithms.HuffmanEncoder;
import org.example.algorithms.ShannonFanoEncoder;
import org.example.utils.Letter;
import org.example.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class Lab4 {


    public static void solve(){
        ArrayList<Letter> Z = new ArrayList<>();
        Z.add(new Letter("z1",0.24));
        Z.add(new Letter("z2",0.23));
        Z.add(new Letter("z3",0.16));
        Z.add(new Letter("z4",0.14));
        Z.add(new Letter("z5",0.08));
        Z.add(new Letter("z6",0.06));
        Z.add(new Letter("z7",0.06));
        Z.add(new Letter("z8",0.03));
        double[] probs = new double[Z.size()];
        for(int i = 0; i < probs.length; i++){
            probs[i] = Z.get(i).getProb();
        }
        HuffmanEncoder encoder = new HuffmanEncoder();
        HashMap<Letter,String> codes = encoder.encode(Z);
        System.out.println("Лабораторная работа №4: Кодирование алгоритмом Хаффмена");
        System.out.println("Маслюк Виталий 8В14 Вариант 12");
        System.out.println("----------------------------------------------------");
        System.out.println("Задание 1: Провести эффективное кодирование алгоритмом Хаффмена");
        System.out.println("Hmax = " + String.format("%.2f", Utils.log2(Z.size())));
        System.out.println("H = " + String.format("%.2f",Utils.calculateEntropy(probs)));
        System.out.println("Коды для алфавита:");
        double kc = 0;
        for(Letter key : codes.keySet().stream().sorted(Comparator.reverseOrder()).toList()){
            System.out.println(key + " = " + codes.get(key));
            kc += key.getProb() * codes.get(key).length();
        }

        System.out.println("Кс = " + kc);

        System.out.println("D: " + String.format("%.2f",Utils.calculateReduancy(probs, Z.size())));
        System.out.println("----------------------------------------------------");
        System.out.println("Задание 2. Блочное кодирование Шеннона-Фано + алгоритм Хаффмена");
        System.out.println("Вероятности: z1 = 0.8, z2 = 0.2");
        Z.clear();
        double a = 0.8;
        double b = 0.2;
        Z.add(new Letter("z1",a));
        Z.add(new Letter("z2",b));
        probs = new double[2];
        probs[0] = a;
        probs[1] = b;
        double H = Utils.calculateEntropy(probs);
        System.out.println("H = " + H);
        System.out.println("Применим метод Шеннона-Фано по блокам:");
        ShannonFanoEncoder shannonFanoEncoder = new ShannonFanoEncoder(Z);
        System.out.println();
        System.out.println("По одному символу:");
        codes = shannonFanoEncoder.encode();
        kc = 0;
        for(Letter key : codes.keySet().stream().sorted(Comparator.reverseOrder()).toList()){
            System.out.println(key + " = " + codes.get(key));
            kc += key.getProb() * codes.get(key).length();
        }
        System.out.println(String.format("nср = %.3f",kc));
        System.out.println(String.format("nср/1 = %.2f на %.0f%% больше энтропии",kc,(kc - H)*100));
        Z.clear();
        Z.add(new Letter("z1",a * a));
        Z.add(new Letter("z2",a * b));
        Z.add(new Letter("z3",b * a));
        Z.add(new Letter("z4",b * b));
        System.out.println();
        System.out.println("По два символа:");
        codes = shannonFanoEncoder.encode();
        kc = 0;
        for(Letter key : codes.keySet().stream().sorted(Comparator.reverseOrder()).toList()){
            System.out.println(key + " = " + codes.get(key));
            kc += key.getProb() * codes.get(key).length();
        }
        System.out.println(String.format("nср = %.3f",kc));
        System.out.println(String.format("nср/2 = %.2f на %.1f%% больше энтропии",kc/2,(kc/2 - H)*100));
        Z.clear();
        Z.add(new Letter("z1",a * a * a));
        Z.add(new Letter("z2",a * a * b));
        Z.add(new Letter("z3",a * a * b));
        Z.add(new Letter("z4",a * a * b));
        Z.add(new Letter("z5",b * b * a));
        Z.add(new Letter("z6",b * b * a));
        Z.add(new Letter("z7",b * b * a));
        Z.add(new Letter("z8",b * b * b));
        System.out.println();
        System.out.println("По три символа:");
        codes = shannonFanoEncoder.encode();
        kc = 0;
        for(Letter key : codes.keySet().stream().sorted(Comparator.reverseOrder()).toList()){
            System.out.println(key + " = " + codes.get(key));
            kc += key.getProb() * codes.get(key).length();
        }
        System.out.println(String.format("nср = %.3f",kc));
        System.out.println(String.format("nср/3 = %.2f на %.1f%% больше энтропии",kc/3,(kc/3 - H)*100));
        System.out.println();
        System.out.println("Определим коды Хаффмена для 3-х знаковых комбинаций: ");
        codes = encoder.encode(Z);
        kc = 0;
        for(Letter key : codes.keySet().stream().sorted(Comparator.reverseOrder()).toList()){
            System.out.println(key + " = " + codes.get(key));
            kc += key.getProb() * codes.get(key).length();
        }
        System.out.println(String.format("nср = %.3f",kc));
        System.out.println(String.format("nср/3 = %.2f на %.1f%% больше энтропии",kc/3,(kc/3 - H)*100));
    }






}
