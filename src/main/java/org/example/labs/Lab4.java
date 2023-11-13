package org.example.labs;

import org.example.algorithms.HuffmanEncoder;
import org.example.utils.Letter;

import java.util.ArrayList;
import java.util.TreeMap;

public class Lab4 {


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

        HuffmanEncoder encoder = new HuffmanEncoder(Z);
        encoder.encode();



    }






}
