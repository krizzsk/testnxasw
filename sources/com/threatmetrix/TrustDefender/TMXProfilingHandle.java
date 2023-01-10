package com.threatmetrix.TrustDefender;

public interface TMXProfilingHandle {

    public static class Result {
        private final String b00640064dd0064d;
        private final TMXStatusCode bdd0064d0064d;

        public Result(String str, TMXStatusCode tMXStatusCode) {
            this.b00640064dd0064d = str;
            this.bdd0064d0064d = tMXStatusCode;
        }

        public String getSessionID() {
            return this.b00640064dd0064d;
        }

        public TMXStatusCode getStatus() {
            return this.bdd0064d0064d;
        }
    }

    void cancel();

    String getSessionID();
}
