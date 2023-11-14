package org.example.algorithms;

import org.example.utils.Letter;

import java.util.*;
import java.util.stream.Collectors;

public class HuffmanEncoder {

    public HuffmanEncoder(){

    }


    public HashMap<Letter, String> encode(ArrayList<Letter> letters){
        PriorityQueue<Letter> pq = new PriorityQueue<>();
        HashMap<Letter, String> codes = new HashMap<>();
        HashMap<Letter,String> tempHashMap = new HashMap<>();
        int letterLength = letters.get(0).getValue().length();
        pq.addAll(letters);
        while(pq.size() != 1){
            Letter l1 = pq.poll();
            Letter l2 = pq.poll();
            Letter sum = new Letter(l1.getValue()+l2.getValue(),l1.getProb()+ l2.getProb());
            if(!tempHashMap.containsKey(l1)){
                tempHashMap.put(l1,"0");
            }else{
                tempHashMap.put(l1,tempHashMap.get(l1) + "0");
            }
            if(!tempHashMap.containsKey(l2)){
                tempHashMap.put(l2,"1");
            }else{
                tempHashMap.put(l2,tempHashMap.get(l2) + "1");
            }
            pq.add(sum);
        }
        List<Letter> sortedLetters = tempHashMap.keySet().stream().sorted(Comparator.comparingInt(x -> x.getValue().length())).collect(Collectors.toList());
        for(Letter l : sortedLetters){
            if(l.getValue().length() == letterLength){
                StringBuilder code = new StringBuilder();
                for(Letter k : tempHashMap.keySet()){
                    if(k.getValue().contains(l.getValue())){
                        code.append(tempHashMap.get(k));
                    }
                }
                codes.put(l,code.reverse().toString());
            }
        }
        return codes;
    }



}
