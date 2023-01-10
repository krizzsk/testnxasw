package com.didi.dimina.starbox.module.jsbridge;

import com.didi.dimina.container.DMMina;

public class JSBridgeManager {

    /* renamed from: a */
    private final DMMina f19880a;

    /* renamed from: b */
    private DMMinaInfoSubJSBridge f19881b;

    /* renamed from: c */
    private GCSubJSBridge f19882c;

    /* renamed from: d */
    private BundleUrlSubJSBridge f19883d;

    /* renamed from: e */
    private ScanSubJSBridge f19884e;

    /* renamed from: f */
    private DevModeSubJSBridge f19885f;

    /* renamed from: g */
    private VConsoleJSBridge f19886g;

    /* renamed from: h */
    private ExtendSubJSBridge f19887h;

    /* renamed from: i */
    private InputModalSubJSBridge f19888i;

    /* renamed from: j */
    private DiminaDemoSubJSBridge f19889j;

    public JSBridgeManager(DMMina dMMina) {
        this.f19880a = dMMina;
    }

    public InputModalSubJSBridge getInputModalSubJSBridge() {
        if (this.f19888i == null) {
            synchronized (this) {
                if (this.f19888i == null) {
                    this.f19888i = new InputModalSubJSBridge(this.f19880a.getActivity());
                }
            }
        }
        return this.f19888i;
    }

    public ExtendSubJSBridge getExtendSubJSBridge() {
        if (this.f19887h == null) {
            synchronized (this) {
                if (this.f19887h == null) {
                    this.f19887h = new ExtendSubJSBridge();
                }
            }
        }
        return this.f19887h;
    }

    public VConsoleJSBridge getVConsoleJSBridge() {
        if (this.f19886g == null) {
            synchronized (this) {
                if (this.f19886g == null) {
                    this.f19886g = new VConsoleJSBridge();
                }
            }
        }
        return this.f19886g;
    }

    public DMMinaInfoSubJSBridge getDMMinaInfoSubJSBridge() {
        if (this.f19881b == null) {
            synchronized (this) {
                if (this.f19881b == null) {
                    this.f19881b = new DMMinaInfoSubJSBridge();
                }
            }
        }
        return this.f19881b;
    }

    public GCSubJSBridge getGCSubJSBridge() {
        if (this.f19882c == null) {
            synchronized (this) {
                if (this.f19882c == null) {
                    this.f19882c = new GCSubJSBridge(this.f19880a.getActivity());
                }
            }
        }
        return this.f19882c;
    }

    public BundleUrlSubJSBridge getBundleUrlSubJSBridge() {
        if (this.f19883d == null) {
            synchronized (this) {
                if (this.f19883d == null) {
                    this.f19883d = new BundleUrlSubJSBridge(this.f19880a.getActivity());
                }
            }
        }
        return this.f19883d;
    }

    public ScanSubJSBridge getScanSubJSBridge() {
        if (this.f19884e == null) {
            synchronized (this) {
                if (this.f19884e == null) {
                    this.f19884e = new ScanSubJSBridge(this.f19880a.getActivity());
                }
            }
        }
        return this.f19884e;
    }

    public DevModeSubJSBridge getDevModeSubJSBridge() {
        if (this.f19885f == null) {
            synchronized (this) {
                if (this.f19885f == null) {
                    this.f19885f = new DevModeSubJSBridge(this.f19880a);
                }
            }
        }
        return this.f19885f;
    }

    public DiminaDemoSubJSBridge getDiminaDemoSubJSBridge() {
        if (this.f19889j == null) {
            synchronized (this) {
                if (this.f19889j == null) {
                    this.f19889j = new DiminaDemoSubJSBridge(this.f19880a);
                }
            }
        }
        return this.f19889j;
    }
}
