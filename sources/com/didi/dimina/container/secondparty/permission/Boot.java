package com.didi.dimina.container.secondparty.permission;

import android.os.Build;
import com.didi.dimina.container.secondparty.permission.install.InstallRequest;
import com.didi.dimina.container.secondparty.permission.install.NRequestFactory;
import com.didi.dimina.container.secondparty.permission.install.ORequestFactory;
import com.didi.dimina.container.secondparty.permission.notify.Notify;
import com.didi.dimina.container.secondparty.permission.notify.option.NotifyOption;
import com.didi.dimina.container.secondparty.permission.option.Option;
import com.didi.dimina.container.secondparty.permission.overlay.LRequestFactory;
import com.didi.dimina.container.secondparty.permission.overlay.MRequestFactory;
import com.didi.dimina.container.secondparty.permission.overlay.OverlayRequest;
import com.didi.dimina.container.secondparty.permission.runtime.Runtime;
import com.didi.dimina.container.secondparty.permission.runtime.option.RuntimeOption;
import com.didi.dimina.container.secondparty.permission.setting.Setting;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class Boot implements Option {

    /* renamed from: a */
    private static final InstallRequestFactory f19196a;

    /* renamed from: b */
    private static final OverlayRequestFactory f19197b;

    /* renamed from: c */
    private final Source f19198c;

    public interface InstallRequestFactory {
        InstallRequest create(Source source);
    }

    public interface OverlayRequestFactory {
        OverlayRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f19196a = new ORequestFactory();
        } else {
            f19196a = new NRequestFactory();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            f19197b = new MRequestFactory();
        } else {
            f19197b = new LRequestFactory();
        }
    }

    public Boot(Source source) {
        this.f19198c = source;
    }

    public RuntimeOption runtime() {
        return new Runtime(this.f19198c);
    }

    public InstallRequest install() {
        return f19196a.create(this.f19198c);
    }

    public OverlayRequest overlay() {
        return f19197b.create(this.f19198c);
    }

    public NotifyOption notification() {
        return new Notify(this.f19198c);
    }

    public Setting setting() {
        return new Setting(this.f19198c);
    }
}
