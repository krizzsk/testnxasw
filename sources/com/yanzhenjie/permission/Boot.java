package com.yanzhenjie.permission;

import android.os.Build;
import com.yanzhenjie.permission.install.InstallRequest;
import com.yanzhenjie.permission.install.NRequestFactory;
import com.yanzhenjie.permission.install.ORequestFactory;
import com.yanzhenjie.permission.notify.Notify;
import com.yanzhenjie.permission.notify.option.NotifyOption;
import com.yanzhenjie.permission.option.Option;
import com.yanzhenjie.permission.overlay.LRequestFactory;
import com.yanzhenjie.permission.overlay.MRequestFactory;
import com.yanzhenjie.permission.overlay.OverlayRequest;
import com.yanzhenjie.permission.runtime.Runtime;
import com.yanzhenjie.permission.runtime.option.RuntimeOption;
import com.yanzhenjie.permission.setting.Setting;
import com.yanzhenjie.permission.source.Source;

public class Boot implements Option {

    /* renamed from: a */
    private static final InstallRequestFactory f58908a;

    /* renamed from: b */
    private static final OverlayRequestFactory f58909b;

    /* renamed from: c */
    private Source f58910c;

    public interface InstallRequestFactory {
        InstallRequest create(Source source);
    }

    public interface OverlayRequestFactory {
        OverlayRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f58908a = new ORequestFactory();
        } else {
            f58908a = new NRequestFactory();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            f58909b = new MRequestFactory();
        } else {
            f58909b = new LRequestFactory();
        }
    }

    public Boot(Source source) {
        this.f58910c = source;
    }

    public RuntimeOption runtime() {
        return new Runtime(this.f58910c);
    }

    public InstallRequest install() {
        return f58908a.create(this.f58910c);
    }

    public OverlayRequest overlay() {
        return f58909b.create(this.f58910c);
    }

    public NotifyOption notification() {
        return new Notify(this.f58910c);
    }

    public Setting setting() {
        return new Setting(this.f58910c);
    }
}
