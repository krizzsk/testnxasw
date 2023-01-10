package com.didi.dcrypto.model;

public class AccountInfoMulticoinBalance {

    /* renamed from: a */
    private String f18357a;

    /* renamed from: b */
    private String f18358b;

    /* renamed from: c */
    private String f18359c;

    /* renamed from: d */
    private String f18360d;

    /* renamed from: e */
    private String f18361e;

    /* renamed from: f */
    private String f18362f;

    /* renamed from: g */
    private String f18363g;

    /* renamed from: h */
    private String f18364h;

    /* renamed from: i */
    private String f18365i;

    /* renamed from: j */
    private int f18366j;

    /* renamed from: k */
    private String f18367k;

    /* renamed from: l */
    private String f18368l;

    public AccountInfoMulticoinBalance(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11) {
        this.f18357a = str;
        this.f18358b = str2;
        this.f18359c = str3;
        this.f18360d = str4;
        this.f18361e = str5;
        this.f18362f = str6;
        this.f18363g = str7;
        this.f18364h = str8;
        this.f18365i = str9;
        this.f18366j = i;
        this.f18367k = str10;
        this.f18368l = str11;
    }

    public String getBalance() {
        return this.f18357a;
    }

    public void setBalance(String str) {
        this.f18357a = str;
    }

    public String getCurrency_symbol() {
        return this.f18358b;
    }

    public void setCurrency_symbol(String str) {
        this.f18358b = str;
    }

    public String getBalance_available() {
        return this.f18359c;
    }

    public void setBalance_available(String str) {
        this.f18359c = str;
    }

    public String getBalance_locked() {
        return this.f18360d;
    }

    public void setBalance_locked(String str) {
        this.f18360d = str;
    }

    public String getAmount_brl() {
        return this.f18361e;
    }

    public void setAmount_brl(String str) {
        this.f18361e = str;
    }

    public String getPrice_ask() {
        return this.f18362f;
    }

    public void setPrice_ask(String str) {
        this.f18362f = str;
    }

    public String getPrice_bid() {
        return this.f18363g;
    }

    public void setPrice_bid(String str) {
        this.f18363g = str;
    }

    public String getMidnight_price() {
        return this.f18364h;
    }

    public void setMidnight_price(String str) {
        this.f18364h = str;
    }

    public String getDaily_profit_loss() {
        return this.f18365i;
    }

    public void setDaily_profit_loss(String str) {
        this.f18365i = str;
    }

    public int getHas_transaction() {
        return this.f18366j;
    }

    public void setHas_transaction(int i) {
        this.f18366j = i;
    }

    public String getIcon_url() {
        return this.f18367k;
    }

    public void setIcon_url(String str) {
        this.f18367k = str;
    }

    public String getCrypto_title() {
        return this.f18368l;
    }

    public void setCrypto_title(String str) {
        this.f18368l = str;
    }
}
