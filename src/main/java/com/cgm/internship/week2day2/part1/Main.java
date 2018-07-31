package com.cgm.internship.week2day2.part1;

public class Main {
    public static void main(String[] args) {
        FunctionalInterface base = (double a, double b) -> a + b;
        RandomClass.applyInterface(30,15,base);
    }
}
