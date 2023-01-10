package p242if;

/* renamed from: if.do */
/* compiled from: AssuranceType */
public enum C21998do {
    GENUINE_PRESENCE_ASSURANCE {
        public String toString() {
            return "genuine_presence";
        }
    },
    LIVENESS {
        public String toString() {
            return "liveness";
        }
    };

    /* renamed from: do */
    public static C21998do m45179do(String str) {
        if (str != null && !str.isEmpty()) {
            for (C21998do doVar : values()) {
                if (doVar.name().equalsIgnoreCase(str)) {
                    return doVar;
                }
            }
        }
        return null;
    }
}
