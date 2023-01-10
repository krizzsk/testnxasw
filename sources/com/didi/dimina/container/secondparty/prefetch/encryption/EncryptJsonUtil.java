package com.didi.dimina.container.secondparty.prefetch.encryption;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EncryptJsonUtil {

    /* renamed from: a */
    private static final Gson f19320a = new GsonBuilder().create();

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return f19320a.toJson(obj);
    }
}
