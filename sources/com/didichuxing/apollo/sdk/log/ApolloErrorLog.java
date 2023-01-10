package com.didichuxing.apollo.sdk.log;

public class ApolloErrorLog {

    /* renamed from: a */
    private String f48275a = "";

    public String getLogKey() {
        return "error_msg";
    }

    public ApolloErrorLog(String str) {
        if (str != null) {
            this.f48275a = str;
        }
    }

    public String getErrorMsg() {
        String str = this.f48275a;
        return str == null ? "" : str;
    }
}
