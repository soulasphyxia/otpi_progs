package org.example.algorithms;

import org.example.utils.Letter;

import java.util.*;

public class ShannonFanoEncoder {
    private HashMap<Letter,String> codes;

    private ArrayList<Letter> letters;
    public ShannonFanoEncoder(ArrayList<Letter> letters){
        this.letters = letters;
    }

    public HashMap<Letter, String> encode(){
        this.codes = new HashMap<>();
        letters.sort(Collections.reverseOrder());
        calculateCodes(letters);

        return codes;
    }

    public void calculateCodes(ArrayList<Letter> letters){

        double[] prefixSums = new double[letters.size()];
        prefixSums[0] = letters.get(0).getProb();
        for(int i = 1; i < letters.size(); i++){
            prefixSums[i] = prefixSums[i - 1] + letters.get(i).getProb();
        }

        double[] diffs = new double[prefixSums.length];

        for(int i = 0; i < diffs.length; i++){
            diffs[i] = Math.abs(prefixSums[prefixSums.length - 1] - 2 * prefixSums[i]);
        }
        int borderIndex = 0;
        double min = Arrays.stream(diffs).min().getAsDouble();
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] == min){
                borderIndex = i;
                break;
            }
        }

        ArrayList<Letter> left = new ArrayList<>(letters.subList(0,borderIndex + 1));
        ArrayList<Letter> right = new ArrayList<>(letters.subList(borderIndex + 1,letters.size()));

        for(Letter l : left){
            if(!codes.containsKey(l)){
                codes.put(l,"1");
            }else{
                codes.put(l,codes.get(l) + "1");
            }
        }
        for(Letter l : right){
            if(!codes.containsKey(l)){
                codes.put(l,"0");
            }else{
                codes.put(l,codes.get(l) + "0");
            }
        }

        if(left.size() != 1){
            calculateCodes(left);
        }

        if(right.size() != 1){
            calculateCodes(right);
        }

    }

    public void setLetters(ArrayList<Letter> letters) {
        this.letters = letters;
    }

    public ArrayList<Letter> getLetters() {
        return letters;
    }
}
