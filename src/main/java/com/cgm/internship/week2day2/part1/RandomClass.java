package com.cgm.internship.week2day2.part1;

public class RandomClass {

    public static void applyInterface(double a, double b, FunctionalInterface functionalInterface){
        System.out.println(functionalInterface.calculate(a,b));
    }
}
