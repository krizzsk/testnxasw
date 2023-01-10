package com.threatmetrix.TrustDefender;

import javax.annotation.Nonnull;

public class kjjjjj {
    public static final String b006D006Dm006D006D006D = "enableOptions";
    public static final String b006Dm006D006D006D006D = "quietPeriod";
    public static final String bm006D006D006D006D006D = "sdkVersion";
    public static final String bmm006D006D006D006D = "disableOptions";
    private String b006F006Foooo = "";
    private long b006Fooooo = 0;
    private long bo006Foooo = 0;
    private int boo006Fooo = 0;

    public void b00680068006800680068h(String str) {
        this.b006F006Foooo = str;
    }

    public String b00680068h00680068h() {
        return this.b006F006Foooo;
    }

    public void b0068h006800680068h(long j) {
        this.b006Fooooo = j;
    }

    public long b0068hh00680068h() {
        return this.b006Fooooo;
    }

    public void bh0068006800680068h(int i) {
        this.boo006Fooo = i;
    }

    public int bh0068h00680068h() {
        return this.boo006Fooo;
    }

    public void bhh006800680068h(long j) {
        this.bo006Foooo = j;
    }

    public long bhhh00680068h() {
        return this.bo006Foooo;
    }

    public boolean bhhhhh0068(long j, long j2, @Nonnull String str, int i) {
        return (j == this.b006Fooooo && j2 == this.bo006Foooo && str.equals(this.b006F006Foooo) && i == this.boo006Fooo) ? false : true;
    }
}
