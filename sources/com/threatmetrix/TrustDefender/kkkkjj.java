package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqttqq;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class kkkkjj {
    private static final boolean b00640064dd00640064 = false;
    private static final Hashtable<String, Long> b0064ddd00640064 = new Hashtable<>();
    private static final int bd0064dd00640064 = 1000;
    private static volatile int bdd0064d00640064 = 0;
    private static final String bdddd00640064 = yyyyqy.b0074t007400740074t(kkkkjj.class);
    private long b0064d0064d00640064 = tqttqq.tttttq.b00760076v0076v0076();

    public static void b007300730073s00730073s(int i) {
        if (i > 0) {
            bdd0064d00640064 = i;
        }
    }

    public static void bs00730073s00730073s() {
        b0064ddd00640064.clear();
    }

    @Nullable
    public static String bsss007300730073s(long j) {
        long b00760076v0076v0076 = tqttqq.tttttq.b00760076v0076v0076() - j;
        if (bdd0064d00640064 <= 0 || b00760076v0076v0076 <= TimeUnit.MILLISECONDS.convert((long) bdd0064d00640064, TimeUnit.SECONDS)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(b0064ddd00640064.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
                return entry2.getValue().compareTo(entry.getValue());
            }
        });
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("tt:%s;", new Object[]{decimalFormat.format(((double) b00760076v0076v0076) / 1000.0d)}));
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String[] split = ((String) entry.getKey()).split(":");
            sb.append(String.format("%s:%s;", new Object[]{split[split.length - 1], decimalFormat.format(((Long) entry.getValue()).doubleValue() / 1000.0d)}));
            i++;
            if (i >= 10) {
                break;
            }
        }
        return sb.toString();
    }

    public void b0073s0073s00730073s(@Nonnull String str, @Nonnull String str2) {
        long b00760076v0076v0076 = tqttqq.tttttq.b00760076v0076v0076() - this.b0064d0064d00640064;
        b0064ddd00640064.put(String.format(Locale.getDefault(), "%03d:%s:%s", new Object[]{Integer.valueOf(b0064ddd00640064.size()), str, str2}), Long.valueOf(b00760076v0076v0076));
        this.b0064d0064d00640064 = tqttqq.tttttq.b00760076v0076v0076();
    }
}
