package com.threatmetrix.TrustDefender.fcuqtqpahmoqinu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class hggggg {
    private static int b00670067g0067g0067 = 9;
    private static ArrayList<ghgggg> b0067gg0067g0067 = null;
    private static ArrayList<hhgggg> bg0067g0067g0067 = null;
    public static boolean bggg0067g0067 = true;

    private static String b006800680068hhh(String str, char c, char c2) {
        bh0068h0068hh();
        try {
            return b0067gg0067g0067.get(c2).bhh0068hhh(str, c);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void b00680068h0068hh(int i) {
        if (i > 128 || i < 0) {
            i = 0;
        }
        b00670067g0067g0067 = i;
    }

    private static String b0068hh0068hh(String str, char c, char c2, char c3) {
        bh0068h0068hh();
        try {
            return bg0067g0067g0067.get(c3).b0068h0068hhh(str, c, c2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String bh00680068hhh(String str, char c, char c2) {
        return b006800680068hhh(str, c, c2).intern();
    }

    private static synchronized void bh0068h0068hh() {
        synchronized (hggggg.class) {
            if (bggg0067g0067) {
                bggg0067g0067 = false;
                b0067gg0067g0067 = new ArrayList<>(7);
                bg0067g0067g0067 = new ArrayList<>(4);
                b0067gg0067g0067.add(new gghggg());
                b0067gg0067g0067.add(new hghggg());
                b0067gg0067g0067.add(new ghhggg());
                b0067gg0067g0067.add(new hhhggg());
                b0067gg0067g0067.add(new ggghgg());
                b0067gg0067g0067.add(new hgghgg());
                bg0067g0067g0067.add(new ghghgg());
                bg0067g0067g0067.add(new hhghgg());
                bg0067g0067g0067.add(new gghhgg());
                bg0067g0067g0067.add(new hghhgg());
                Collections.shuffle(b0067gg0067g0067, new Random((long) b00670067g0067g0067));
                Collections.shuffle(bg0067g0067g0067, new Random((long) b00670067g0067g0067));
            }
        }
    }

    public static String bhhh0068hh(String str, char c, char c2, char c3) {
        return b0068hh0068hh(str, c, c2, c3).intern();
    }
}
