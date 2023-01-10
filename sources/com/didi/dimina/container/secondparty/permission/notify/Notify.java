package com.didi.dimina.container.secondparty.permission.notify;

import android.os.Build;
import com.didi.dimina.container.secondparty.permission.notify.listener.J1RequestFactory;
import com.didi.dimina.container.secondparty.permission.notify.listener.J2RequestFactory;
import com.didi.dimina.container.secondparty.permission.notify.listener.ListenerRequest;
import com.didi.dimina.container.secondparty.permission.notify.option.NotifyOption;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class Notify implements NotifyOption {

    /* renamed from: a */
    private static final PermissionRequestFactory f19250a;

    /* renamed from: b */
    private static final ListenerRequestFactory f19251b;

    /* renamed from: c */
    private final Source f19252c;

    public interface ListenerRequestFactory {
        ListenerRequest create(Source source);
    }

    public interface PermissionRequestFactory {
        PermissionRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f19250a = new ORequestFactory();
        } else {
            f19250a = new NRequestFactory();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            f19251b = new J2RequestFactory();
        } else {
            f19251b = new J1RequestFactory();
        }
    }

    public Notify(Source source) {
        this.f19252c = source;
    }

    public PermissionRequest permission() {
        return f19250a.create(this.f19252c);
    }

    public ListenerRequest listener() {
        return f19251b.create(this.f19252c);
    }
}
