package com.threatmetrix.TrustDefender;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.threatmetrix.TrustDefender.qttqtt;
import com.threatmetrix.TrustDefender.tqttqq;
import com.yanzhenjie.permission.runtime.Permission;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class jkjjjj implements qttqtt.qqqttt {
    private static final int b006F006F006F006Foo = 2;
    private static final int b006Fo006F006Foo = 0;
    private static final String b006Fo006Fooo = yyyyqy.b0074t007400740074t(jkjjjj.class);
    private static final int b006Fooo006Fo = 4;
    private static final int bo006F006F006Foo = 1;
    private static final int boo006F006Foo = -1;
    private static final int boooo006Fo = 3;
    /* access modifiers changed from: private */
    public kjjkjj b006F006F006Fooo;
    private volatile boolean b006F006Fo006Foo = false;
    private HandlerThread b006Foo006Foo = null;
    /* access modifiers changed from: private */
    public jjjkjj bo006F006Fooo;
    private Context bo006Fo006Foo;
    /* access modifiers changed from: private */
    public final AtomicInteger bo006Foo006Fo = new AtomicInteger(0);
    private qttqtt.tqqttt booo006Foo;

    public private class jjkjjj implements InvocationHandler {
        private jjkjjj() {
        }

        @Nullable
        public Object invoke(Object obj, @Nonnull Method method, @Nullable Object[] objArr) throws Throwable {
            if (!qttqtt.br00720072007200720072.equals(method.getName())) {
                return qttqtt.by0079y0079y0079(this, method, objArr);
            }
            if (jkjjjj.this.bhh00680068h0068() && objArr != null && objArr.length > 0) {
                jkjjjj.this.bo006F006Fooo.onLocationChanged(objArr[0]);
            }
            return null;
        }
    }

    public private class kjkjjj implements InvocationHandler {
        public final boolean boo006Fo006Fo;

        public kjkjjj(boolean z) {
            this.boo006Fo006Fo = z;
        }

        private void b0068hhhh0068(boolean z) {
            AtomicInteger atomicInteger;
            int i;
            int i2;
            if (jkjjjj.this.bhh00680068h0068()) {
                if (z) {
                    atomicInteger = jkjjjj.this.bo006Foo006Fo;
                    i2 = 2;
                    i = 1;
                } else {
                    atomicInteger = jkjjjj.this.bo006Foo006Fo;
                    i2 = 4;
                    i = 3;
                }
                atomicInteger.compareAndSet(i2, i);
            }
        }

        private void bh0068hhh0068(boolean z) {
            if (jkjjjj.this.bhh00680068h0068()) {
                if (!z) {
                    jkjjjj.this.bo006Foo006Fo.compareAndSet(4, 1);
                } else if (jkjjjj.this.bo006Foo006Fo.compareAndSet(2, 3)) {
                    jkjjjj.this.b006F006F006Fooo.b007300730073ssss();
                }
                jkjjjj.this.bhhh0068h0068();
            }
        }

        @Nullable
        public Object invoke(Object obj, @Nonnull Method method, @Nullable Object[] objArr) throws Throwable {
            if (!qttqtt.b0063ccccc.equals(method.getName())) {
                return qttqtt.by0079y0079y0079(this, method, objArr);
            }
            if (objArr == null || objArr.length <= 0) {
                return null;
            }
            if (qttqtt.by007900790079y0079(objArr[0])) {
                bh0068hhh0068(this.boo006Fo006Fo);
                return null;
            }
            b0068hhhh0068(this.boo006Fo006Fo);
            return null;
        }
    }

    private void b0068h00680068h0068() {
        if (bhh00680068h0068() && this.bo006Foo006Fo.compareAndSet(3, 4)) {
            this.booo006Foo.by0079yyy0079(new kjkjjj(false));
        }
    }

    private void bh006800680068h0068() {
        if (bhh00680068h0068()) {
            tqttqq tqttqq = new tqttqq();
            tqttqq.getClass();
            tqttqq.qtqttq qtqttq = new tqttqq.qtqttq(this.bo006Fo006Foo);
            boolean b0076v0076v0076v = qtqttq.b0076v0076v0076v(Permission.ACCESS_FINE_LOCATION, this.bo006Fo006Foo.getPackageName());
            boolean b0076v0076v0076v2 = qtqttq.b0076v0076v0076v(Permission.ACCESS_COARSE_LOCATION, this.bo006Fo006Foo.getPackageName());
            if ((b0076v0076v0076v || b0076v0076v0076v2) && this.bo006Foo006Fo.compareAndSet(1, 2)) {
                this.booo006Foo.b00790079yyy0079(new kjkjjj(true), this.b006Foo006Foo.getLooper());
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean bhh00680068h0068() {
        return (this.booo006Foo == null || this.bo006F006Fooo == null || this.b006F006F006Fooo == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public void bhhh0068h0068() {
        if (this.b006F006Fo006Foo) {
            b0068h00680068h0068();
        } else {
            bh006800680068h0068();
        }
    }

    public void b0068006800680068h0068(boolean z) {
        this.b006F006Fo006Foo = z;
        bhhh0068h0068();
    }

    public boolean b00680068h0068h0068() {
        return this.bo006Foo006Fo.get() > 0;
    }

    public void b0068hh0068h0068() {
        if (this.booo006Foo != null) {
            this.bo006Foo006Fo.set(-1);
            this.booo006Foo.b0079yyyy0079();
            this.booo006Foo = null;
        }
    }

    public boolean bh0068h0068h0068(Context context, long j, long j2, int i, jjjkjj jjjkjj, kjjkjj kjjkjj, HandlerThread handlerThread) {
        Context context2 = context;
        if (context2 == null) {
            yyyyqy.b007400740074tt0074(b006Fo006Fooo, "Null context");
            return false;
        }
        this.b006F006F006Fooo = kjjkjj;
        this.bo006F006Fooo = jjjkjj;
        this.b006Foo006Foo = handlerThread;
        this.bo006Fo006Foo = context2;
        this.bo006Foo006Fo.set(0);
        qttqtt.tqqttt b00790079y0079y0079 = qttqtt.b00790079y0079y0079(context, j, j2, i, this, new jjkjjj(), new jjkjjj(), new Handler(handlerThread.getLooper()));
        this.booo006Foo = b00790079y0079y0079;
        return b00790079y0079y0079 != null;
    }

    public void onConnectionFailed() {
        this.bo006Foo006Fo.set(-1);
    }

    public void onServiceConnected() {
        if (this.bo006Foo006Fo.compareAndSet(0, 1)) {
            bhhh0068h0068();
        }
    }
}
