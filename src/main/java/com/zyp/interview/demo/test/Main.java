package com.zyp.interview.demo.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {

        double[] a = {1,2,3,4};
        int n = 3;
        int x = 2;
        double f = f2(n, a, x);
        System.out.println(f);


    }

    public static double f1(int n, double a[], double x) {
        double p = a[0];
        for (int i = 1; i <= n; i++) {
            p += (a[i] * Math.pow(x, i));
        }
        return p;
    }

    public static double f2(int n,double a[],double x){
        double p = a[n];
        for (int i = n; i > 0; i--) {
            p = a[i - 1] + p * x;
        }
        return p;
    }




}
