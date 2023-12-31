package org.example.algorithms;

public class RLE_PCX {
    public static String encode(String msg) {
        StringBuilder encodedString = new StringBuilder();
        int i = 0;
        while(i < msg.length() - 1){
            int k = 1;

            String msgByte = String.valueOf(msg.charAt(i)) + msg.charAt(i + 1);

            int j = i + 2;

            while(j < msg.length() - 1){
                String msgNextByte= String.valueOf(msg.charAt(j)) + msg.charAt(j + 1);
                if(msgByte.equals(msgNextByte)){
                    k++;
                    j += 2;
                    i += 2;
                }
                else{
                    break;
                }
            }

            if(k != 1){
                encodedString.append(toByteCounter(k)).append(msgByte);
            }
            else{
                if(isByteCounter(msgByte)){
                    encodedString.append(toByteCounter(1)).append(msgByte);
                }else{
                    encodedString.append(msgByte);
                }
            }

            i += 2;
        }
        return encodedString.toString();
    }

    public static String decode(String msg) {
        StringBuilder decodedString = new StringBuilder();
        int i = 0;
        while(i < msg.length() - 1){
            String msgByte= String.valueOf(msg.charAt(i)) + msg.charAt(i + 1);
            if(isByteCounter(msgByte)){
                String msgNextByte = String.valueOf(msg.charAt(i + 2)) + msg.charAt(i + 3);
                int count = countInBinary(msgByte);
                decodedString
                        .append(msgNextByte
                        .repeat(Math.max(0, count)));
                i += 4;
            } else{
              decodedString.append(msgByte);
              i += 2;
            }
        }
        return decodedString.toString();
    }


    private static boolean isByteCounter(String byte_){
        String mask = "11000000";
        return Integer.toBinaryString(Integer.parseInt(byte_,16) & Integer.parseInt(mask,2))
                .startsWith("11");
    }
    private static int countInBinary(String byte_){
        return Integer.parseInt(
                Integer.toBinaryString(Integer.parseInt(byte_,16))
                        .substring(2),
                2);
    }

    private static String toByteCounter(int n){
        String mask = "11000000";
        return Integer.toHexString(n | Integer.parseInt(mask,2)).toUpperCase();
    }
}
