package org.example.algorithms;

import org.example.utils.Letter;

import java.util.*;

public class HuffmanEncoder {

    private ArrayList<Letter> letters;

    private HashMap<Letter, String> codes;


    public HuffmanEncoder(ArrayList<Letter> letters){
        this.letters = letters;
        this.codes = new HashMap<>();
    }


    public HashMap<Letter, String> encode(){
        //ПОПРОБОВАТЬ PRIORITY QUEUE
        PriorityQueue<Letter> pq = new PriorityQueue<>();
        TreeMap<Letter, Double> map = new TreeMap<>();
        pq.addAll(letters);
        while(pq.size() != 1){
            Letter l1 = pq.poll();
            Letter l2 = pq.poll();
            map.put(l1,l1.getProb());
            map.put(l2,l2.getProb());
            pq.add(new Letter(l1.getValue()+l2.getValue(),l1.getProb()+ l2.getProb()));
        }

        System.out.println(map);


        return codes;
    }


    public ArrayList<Letter> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Letter> letters) {
        this.letters = letters;
    }
}
