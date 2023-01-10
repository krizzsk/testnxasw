package com.didi.aoe.library.api.interpreter;

public final class InterpreterInitResult {

    /* renamed from: a */
    private int f10006a;

    /* renamed from: b */
    private String f10007b;

    /* renamed from: a */
    private static String m8687a(int i) {
        switch (i) {
            case -2:
                return "STATUS_INNER_ERROR";
            case -1:
                return "STATUS_UNDEFINE";
            case 0:
                return "STATUS_OK";
            case 1:
                return "STATUS_CONFIG_PARSE_ERROR";
            case 2:
                return "STATUS_CONNECTION_WAITTING";
            case 3:
                return "STATUS_MODEL_DOWNLOAD_WAITING";
            case 4:
                return "STATUS_MODEL_LOAD_FAILED";
            default:
                return "UNKNOWN";
        }
    }

    private InterpreterInitResult(int i, String str) {
        this.f10006a = i;
        this.f10007b = str;
    }

    public int getCode() {
        return this.f10006a;
    }

    public void setCode(int i) {
        this.f10006a = i;
    }

    public String getMsg() {
        return this.f10007b;
    }

    public void setMsg(String str) {
        this.f10007b = str;
    }

    public static InterpreterInitResult create(int i) {
        return create(i, m8687a(i));
    }

    public static InterpreterInitResult create(int i, String str) {
        return new InterpreterInitResult(i, str);
    }

    public String toString() {
        return "InterpreterInitResult{code=" + this.f10006a + ", msg='" + this.f10007b + '\'' + '}';
    }
}
