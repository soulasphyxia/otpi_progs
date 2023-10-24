package org.example.labs;

import jdk.jshell.execution.Util;
import org.example.algorithms.ShannonFanoEncoder;
import org.example.utils.Letter;
import org.example.utils.Utils;

import java.util.*;

public class Lab2 {

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


        ShannonFanoEncoder encoder = new ShannonFanoEncoder(Z);
        HashMap<Letter, String> codes = encoder.encode();
        List<Letter> keyList = new ArrayList<>(codes.keySet());
        keyList.sort(Collections.reverseOrder());
        double[] probs = new double[Z.size()];
        for(int i = 0; i < probs.length; i++){
            probs[i] = Z.get(i).getProb();
        }


        System.out.println("Лабораторная работа №2: Кодировка Шеннона-Фано");
        System.out.println("Маслюк Виталий 8В14 Вариант 12");
        System.out.println("Алфавит: Z(z1-z8) " + Arrays.toString(probs));
        System.out.println("Hmax = " + Utils.log2(Z.size()));
        System.out.println("H = " + String.format("%.2f",Utils.calculateEntropy(probs)));
        System.out.println("Коды для алфавита:");
        double kc = 0;
        for(Letter key : keyList){
            System.out.println(key + " = " + codes.get(key));
            kc += key.getProb() * codes.get(key).length();
        }

        System.out.println("Кс = " + kc);

        System.out.println("D: " + String.format("%.2f",Utils.calculateReduancy(probs, Z.size())));





    }
}
