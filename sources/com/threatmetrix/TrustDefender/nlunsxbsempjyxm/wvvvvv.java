package com.threatmetrix.TrustDefender.nlunsxbsempjyxm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class wvvvvv {
    private static ArrayList<wwvvvv> b006E006E006En006Enn = null;
    public static boolean b006En006En006Enn = true;
    private static ArrayList<vwvvvv> bn006E006En006Enn = null;
    private static int bnnn006E006Enn = 47;

    public static String b006E006Enn006E006En(String str, char c, char c2, char c3) {
        return bnn006En006E006En(str, c, c2, c3).intern();
    }

    private static synchronized void b006En006En006E006En() {
        synchronized (wvvvvv.class) {
            if (b006En006En006Enn) {
                b006En006En006Enn = false;
                bn006E006En006Enn = new ArrayList<>(7);
                b006E006E006En006Enn = new ArrayList<>(4);
                bn006E006En006Enn.add(new vvwvvv());
                bn006E006En006Enn.add(new wvwvvv());
                bn006E006En006Enn.add(new vwwvvv());
                bn006E006En006Enn.add(new wwwvvv());
                bn006E006En006Enn.add(new vvvwvv());
                bn006E006En006Enn.add(new wvvwvv());
                b006E006E006En006Enn.add(new vwvwvv());
                b006E006E006En006Enn.add(new wwvwvv());
                b006E006E006En006Enn.add(new vvwwvv());
                b006E006E006En006Enn.add(new wvwwvv());
                Collections.shuffle(bn006E006En006Enn, new Random((long) bnnn006E006Enn));
                Collections.shuffle(b006E006E006En006Enn, new Random((long) bnnn006E006Enn));
            }
        }
    }

    public static String b006Ennn006E006En(String str, char c, char c2) {
        return bn006Enn006E006En(str, c, c2).intern();
    }

    public static void bn006E006En006E006En(int i) {
        if (i > 128 || i < 0) {
            i = 0;
        }
        bnnn006E006Enn = i;
    }

    private static String bn006Enn006E006En(String str, char c, char c2) {
        b006En006En006E006En();
        try {
            return bn006E006En006Enn.get(c2).b006E006E006E006En006En(str, c);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String bnn006En006E006En(String str, char c, char c2, char c3) {
        b006En006En006E006En();
        try {
            return b006E006E006En006Enn.get(c3).bnnnn006E006En(str, c, c2);
        } catch (Exception unused) {
            return "";
        }
    }
}
