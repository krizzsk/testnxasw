package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.jjkjkj;
import com.threatmetrix.TrustDefender.qttqtt;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class qqqyyq implements jjkjkj.jjjkjk {
    /* access modifiers changed from: private */
    public static final String baaaa00610061 = yyyyqy.b0074t007400740074t(qqqyyq.class);
    @Nullable
    private volatile String b00610061aa00610061 = null;
    /* access modifiers changed from: private */
    @Nullable
    public volatile String b0061aaa00610061 = null;
    /* access modifiers changed from: private */
    public volatile boolean ba0061aa00610061 = false;

    public private class qyyqyq implements InvocationHandler {
        private qyyqyq() {
        }

        @Nullable
        public Object invoke(Object obj, @Nonnull Method method, @Nullable Object[] objArr) throws Throwable {
            qttqtt.qtqttt qtqttt;
            if (!qttqtt.b0063ccccc.equals(method.getName()) || (qtqttt = qttqtt.b00630063c0063cc) == null || objArr == null || objArr.length <= 0) {
                return null;
            }
            if (qttqtt.by007900790079y0079(objArr[0])) {
                Object bs00730073s007300730073 = kkjkjk.bs00730073s007300730073(objArr[0], qtqttt.b0063c0063006300630063, new Object[0]);
                if (!(bs00730073s007300730073 instanceof String)) {
                    return null;
                }
                String unused = qqqyyq.this.b0061aaa00610061 = (String) bs00730073s007300730073;
                return null;
            }
            yyyyqy.qyyyqy.bt0074tttt(qqqyyq.baaaa00610061, "Couldn't get SafetyNet result, should try next time");
            boolean unused2 = qqqyyq.this.ba0061aa00610061 = false;
            return null;
        }
    }

    public void attest(tqtqqt tqtqqt, String str) {
        if (tqtqqt == null) {
            yyyyqy.b007400740074tt0074(baaaa00610061, "Null context");
        } else if (!this.ba0061aa00610061) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (bytes.length >= 16) {
                qttqtt.b0079007900790079y0079(tqtqqt.bll006C006C006C006C, bytes, new qyyqyq());
                this.ba0061aa00610061 = true;
                this.b00610061aa00610061 = str;
                yyyyqy.qyyyqy.bt0074tttt(baaaa00610061, "Called SafetyNet API");
                return;
            }
            yyyyqy.bt0074007400740074t(baaaa00610061, "SafetyNet failure: Invalid nonce format");
        }
    }

    public String getNonce() {
        return this.b00610061aa00610061;
    }

    public String getResult() {
        return this.b0061aaa00610061;
    }
}
