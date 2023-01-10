package com.yanzhenjie.permission.notify;

import android.os.Build;
import com.yanzhenjie.permission.notify.listener.J1RequestFactory;
import com.yanzhenjie.permission.notify.listener.J2RequestFactory;
import com.yanzhenjie.permission.notify.listener.ListenerRequest;
import com.yanzhenjie.permission.notify.option.NotifyOption;
import com.yanzhenjie.permission.source.Source;

public class Notify implements NotifyOption {

    /* renamed from: a */
    private static final PermissionRequestFactory f58970a;

    /* renamed from: b */
    private static final ListenerRequestFactory f58971b;

    /* renamed from: c */
    private Source f58972c;

    public interface ListenerRequestFactory {
        ListenerRequest create(Source source);
    }

    public interface PermissionRequestFactory {
        PermissionRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f58970a = new ORequestFactory();
        } else {
            f58970a = new NRequestFactory();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            f58971b = new J2RequestFactory();
        } else {
            f58971b = new J1RequestFactory();
        }
    }

    public Notify(Source source) {
        this.f58972c = source;
    }

    public PermissionRequest permission() {
        return f58970a.create(this.f58972c);
    }

    public ListenerRequest listener() {
        return f58971b.create(this.f58972c);
    }
}
