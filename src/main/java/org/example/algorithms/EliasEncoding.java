package org.example.algorithms;

public class EliasEncoding {
    public static String gammaEncoding(int n){
        String bin = Integer.toBinaryString(n);
        return "0".repeat(bin.length() - 1) + bin;
    }

    public static String deltaEncoding(int n){
        String bin = Integer.toBinaryString(n);
        return gammaEncoding(bin.length()) + bin.substring(1);
    }

    public static String omegaEncoding(int n){
        StringBuilder answer = new StringBuilder();
        String bin = Integer.toBinaryString(n);
        answer.append(bin).append("0");
        int i = 0;
        while(i != 1){
            i = bin.length() - 1;
            bin = Integer.toBinaryString(i);
            if(!bin.equals("1")){
                answer.insert(0, bin);
            }
        }

        return answer.toString();
    }

}
