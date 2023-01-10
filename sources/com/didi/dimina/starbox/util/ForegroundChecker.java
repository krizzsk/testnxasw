package com.didi.dimina.starbox.util;

import com.didi.dimina.starbox.p108ui.windowpop.DefaultDispatcher;
import com.didi.dimina.starbox.p108ui.windowpop.Dispatcher;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class ForegroundChecker implements Runnable {

    /* renamed from: a */
    private static volatile ForegroundChecker f20038a;

    /* renamed from: b */
    private Dispatcher f20039b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final LinkedList<OnForegroundChange> f20040c = new LinkedList<>();

    /* renamed from: d */
    private final StringBuilder f20041d = new StringBuilder();

    /* renamed from: e */
    private boolean f20042e = false;

    public interface OnForegroundChange {
        void onChange(boolean z);
    }

    public static ForegroundChecker getIns() {
        if (f20038a == null) {
            synchronized (ForegroundChecker.class) {
                if (f20038a == null) {
                    f20038a = new ForegroundChecker();
                }
            }
        }
        return f20038a;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.f20039b = dispatcher;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Dispatcher m16977a() {
        if (this.f20039b == null) {
            this.f20039b = new DefaultDispatcher();
        }
        return this.f20039b;
    }

    public synchronized void addChecker(final OnForegroundChange onForegroundChange) {
        m16977a().post(new Runnable() {
            public void run() {
                boolean isEmpty = ForegroundChecker.this.f20040c.isEmpty();
                ForegroundChecker.this.f20040c.add(onForegroundChange);
                if (isEmpty) {
                    ForegroundChecker.this.m16977a().post(ForegroundChecker.this);
                }
            }
        });
    }

    public synchronized void removeChecker(final OnForegroundChange onForegroundChange) {
        m16977a().post(new Runnable() {
            public void run() {
                ForegroundChecker.this.f20040c.remove(onForegroundChange);
            }
        });
    }

    public void run() {
        try {
            FileReader fileReader = new FileReader("/proc/self/oom_adj");
            this.f20041d.delete(0, this.f20041d.length());
            char[] cArr = new char[16];
            while (true) {
                int read = fileReader.read(cArr);
                if (read == -1) {
                    break;
                }
                this.f20041d.append(cArr, 0, read);
            }
            boolean z = Integer.parseInt(this.f20041d.toString().trim()) <= 0;
            if (this.f20042e != z) {
                Iterator it = this.f20040c.iterator();
                while (it.hasNext()) {
                    ((OnForegroundChange) it.next()).onChange(z);
                }
            }
            this.f20042e = z;
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.f20040c.isEmpty()) {
            this.f20042e = false;
        } else {
            m16977a().postDelay(this, 250);
        }
    }
}
