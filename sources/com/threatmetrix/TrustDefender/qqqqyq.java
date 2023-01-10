package com.threatmetrix.TrustDefender;

public final class qqqqyq {
    public static final String b0062006200620062bb = "__orientation";
    public static final String b00620062b0062bb = "description";
    public static final String b0062b00620062bb = "Cloned";
    public static final String b0062bbb0062b = ("{\"description\":\"" + yyyyqq.JSON_EXCEPTION.bb0062bb0062b + "\"}");
    public static final String bb006200620062bb = "__";
    public static final String bbb00620062bb = "result";
    public static final String bbbbb0062b = ("{\"description\":\"" + yyyyqq.COULD_NOT_CHECK.bb0062bb0062b + "\"}");

    public enum yyyyqq {
        INCONSISTENT_PATH("Invalid Data Path", true),
        MULTIPLE_PID("Multiple PID same UID", true),
        INVALID_COMM_CONTENT("Invalid comm Name", true),
        COULD_NOT_CHECK("Could Not Check", false),
        JSON_EXCEPTION("Json exception", false),
        NOT_CLONED("Not Cloned", false);
        
        public boolean b00620062bb0062b;
        public String bb0062bb0062b;

        private yyyyqq(String str, boolean z) {
            this.bb0062bb0062b = str;
            this.b00620062bb0062b = z;
        }
    }
}
