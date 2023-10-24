package org.example.utils;

import java.util.Comparator;

public class Letter implements Comparable<Letter> {

    private String value;
    private Double prob;

    public Letter(String value, double prob) {
        this.value = value;
        this.prob = prob;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int compareTo(Letter o) {
        return this.prob.compareTo(o.getProb());
    }
}
