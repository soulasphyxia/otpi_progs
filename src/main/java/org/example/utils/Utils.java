package org.example.utils;

import java.util.Arrays;
import java.util.Collections;

public class Utils {
    public static double log2(int n){
        return Math.log(n) / Math.log(2);
    }

    public static double log2(double n){
        return Math.log(n) / Math.log(2);
    }

    public static double calculateEntropy(double[] probs){
        return -Arrays.stream(probs).reduce(0, (sum,x) -> sum + x * log2(x));
    }

    public static double calculateReduancy(double[] probs, int len){
        return 1 - calculateEntropy(probs)/log2(len);
    }

    public static int count(Character target, String str){
        int k = 0;
        String[] arr = str.split("");
        for(String c: arr){
            if(c.equals(String.valueOf(target))){
                k++;
            }
        }
        return k;
    }

    public static int calculateEfficiency(int a, int b){
        return 100 - Math.round((float) a /b * 100);
    }


}
