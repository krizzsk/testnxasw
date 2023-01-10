package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class hggggg {
    private static int b006E006En006E006En = 9;
    private static ArrayList<ghgggg> b006Enn006E006En = null;
    private static ArrayList<hhgggg> bn006En006E006En = null;
    public static boolean bnnn006E006En = true;

    private static String b006E006E006En006E006E(String str, char c, char c2, char c3) {
        bnnn006E006E006E();
        try {
            return bn006En006E006En.get(c3).b006E006Enn006E006E(str, c, c2);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String b006En006En006E006E(String str, char c, char c2) {
        bnnn006E006E006E();
        try {
            return b006Enn006E006En.get(c2).bn006Enn006E006E(str, c);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void b006Enn006E006E006E(int i) {
        if (i > 128 || i < 0) {
            i = 0;
        }
        b006E006En006E006En = i;
    }

    public static String bn006E006En006E006E(String str, char c, char c2, char c3) {
        return b006E006E006En006E006E(str, c, c2, c3).intern();
    }

    public static String bnn006En006E006E(String str, char c, char c2) {
        return b006En006En006E006E(str, c, c2).intern();
    }

    private static synchronized void bnnn006E006E006E() {
        synchronized (hggggg.class) {
            if (bnnn006E006En) {
                bnnn006E006En = false;
                b006Enn006E006En = new ArrayList<>(7);
                bn006En006E006En = new ArrayList<>(4);
                b006Enn006E006En.add(new gghggg());
                b006Enn006E006En.add(new hghggg());
                b006Enn006E006En.add(new ghhggg());
                b006Enn006E006En.add(new hhhggg());
                b006Enn006E006En.add(new ggghgg());
                b006Enn006E006En.add(new hgghgg());
                bn006En006E006En.add(new ghghgg());
                bn006En006E006En.add(new hhghgg());
                bn006En006E006En.add(new gghhgg());
                bn006En006E006En.add(new hghhgg());
                Collections.shuffle(b006Enn006E006En, new Random((long) b006E006En006E006En));
                Collections.shuffle(bn006En006E006En, new Random((long) b006E006En006E006En));
            }
        }
    }
}
