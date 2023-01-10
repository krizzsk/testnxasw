package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.kkjkjk;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class yyqyqq extends kkjkjk {
    private static final Method b00620062bbb0062 = b00730073ss007300730073(bbbbbb0062, "getAvailableBlocks", new Class[0]);
    private static final Method b0062b0062bb0062 = b00730073ss007300730073(bbbbbb0062, "getBlockCount", new Class[0]);
    private static final Method b0062bbbb0062;
    private static final Method bb00620062bb0062 = b00730073ss007300730073(bbbbbb0062, "getBlockCountLong", new Class[0]);
    private static final Method bb0062bbb0062 = b00730073ss007300730073(bbbbbb0062, "getBlockSizeLong", new Class[0]);
    private static final Method bbb0062bb0062 = b00730073ss007300730073(bbbbbb0062, "getAvailableBlocksLong", new Class[0]);
    private static final Class<?> bbbbbb0062;
    @Nullable
    private final Object b006200620062bb0062;

    static {
        Class<?> b00730073s0073s00730073 = b00730073s0073s00730073(kkjkjk.jjkkjk.STAT_FS);
        bbbbbb0062 = b00730073s0073s00730073;
        b0062bbbb0062 = b00730073ss007300730073(b00730073s0073s00730073, "getBlockSize", new Class[0]);
    }

    public yyqyqq(String str) {
        Object obj;
        Class<?> cls = bbbbbb0062;
        if (cls == null) {
            obj = null;
        } else {
            obj = kkjkjk.bs0073ss007300730073(cls, new Class[]{String.class}, new Object[]{str});
        }
        this.b006200620062bb0062 = obj;
    }

    public long b006900690069i0069i() {
        Integer num;
        Long l;
        Method method = bb0062bbb0062;
        if (method != null && (l = (Long) bs00730073s007300730073(this.b006200620062bb0062, method, new Object[0])) != null) {
            return l.longValue();
        }
        Method method2 = b0062bbbb0062;
        if (method2 == null || (num = (Integer) bs00730073s007300730073(this.b006200620062bb0062, method2, new Object[0])) == null) {
            return 0;
        }
        return (long) num.intValue();
    }

    public long b0069i0069i0069i() {
        Integer num;
        Long l;
        Method method = bbb0062bb0062;
        if (method != null && (l = (Long) bs00730073s007300730073(this.b006200620062bb0062, method, new Object[0])) != null) {
            return l.longValue();
        }
        Method method2 = b00620062bbb0062;
        if (method2 == null || (num = (Integer) bs00730073s007300730073(this.b006200620062bb0062, method2, new Object[0])) == null) {
            return 0;
        }
        return (long) num.intValue();
    }

    public long bi00690069i0069i() {
        Integer num;
        Long l;
        Method method = bb00620062bb0062;
        if (method != null && (l = (Long) bs00730073s007300730073(this.b006200620062bb0062, method, new Object[0])) != null) {
            return l.longValue();
        }
        Method method2 = b0062b0062bb0062;
        if (method2 == null || (num = (Integer) bs00730073s007300730073(this.b006200620062bb0062, method2, new Object[0])) == null) {
            return 0;
        }
        return (long) num.intValue();
    }
}
