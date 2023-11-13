package org.example.algorithms;

import org.example.utils.Letter;

import java.util.*;

public class HuffmanEncoder {

    private ArrayList<Letter> letters;

    private HashMap<Letter, String> codes;


    public HuffmanEncoder(ArrayList<Letter> letters){
        this.letters = letters;
    }


    public HashMap<Letter, String> encode(){
        //ПОПРОБОВАТЬ PRIORITY QUEUE
        PriorityQueue<Letter> pq = new PriorityQueue<>();
        pq.addAll(letters);
        while(pq.size() != 1){
            Letter l1 = pq.poll();
            Letter l2 = pq.poll();
            System.out.println(l1 + " " + l2);
            l1.setProb(l1.getProb() + l2.getProb());
            pq.add(l1);
        }
        System.out.println(pq.peek().getProb());



        return codes;
    }


    public ArrayList<Letter> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Letter> letters) {
        this.letters = letters;
    }
}
