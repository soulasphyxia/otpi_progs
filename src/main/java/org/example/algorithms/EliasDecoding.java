package org.example.algorithms;

public class EliasDecoding {
    public static int gammaDecoding(String str){
        return Integer.parseInt(str.substring(str.indexOf('1')),2);
    }

    public static int deltaDecoding(String str){
        int m = str.indexOf('1');

        return Integer.parseInt("1" + str.substring(2*m+1),2);
    }
    public static int omegaDecoding(String str){
        int n = 1;
        int i = 0;
        while(str.charAt(i) != '0'){
            System.out.println(i + " " + n);
            n = Integer.parseInt(getSlice(str,i,n + 1),2);
            System.out.println(n);
            i = n + 1;
        }


        return n;
    }


    public static String getSlice(String str, int startIndex, int count){
        StringBuilder slice = new StringBuilder();
        for(int i = startIndex; i < startIndex + count; i++){
            slice.append(str.charAt(i));
        }
        return slice.toString();
    }
}
