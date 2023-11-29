package org.example.algorithms;

public class    EliasDecoding {
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
        int index = str.lastIndexOf('0');
        while(i != index){
            String bin = getSlice(str,i, n + 1);
            n = Integer.parseInt(bin,2);
            i += bin.length();
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
