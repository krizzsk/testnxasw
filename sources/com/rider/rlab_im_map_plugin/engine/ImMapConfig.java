package com.rider.rlab_im_map_plugin.engine;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.flutter.nacho2.p116v2.NachoAction;
import com.didi.rlab.uni_im_map.map.IMMapLogServiceRegister;
import com.didi.rlab.uni_im_map.map.IMMapOmegaServiceRegister;
import com.didi.rlab.uni_im_map.map.IMXpannelServiceRegister;
import com.didi.rlab.uni_im_map.map.MapIMNavigationServicePlugin;
import com.didi.rlab.uni_im_map.map.MapIMServicePlugin;
import com.didi.rlab.uni_im_map.map.MapIMServiceRegister;
import com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.rider.rlab_im_map_plugin.channel.IMMapLogServiceImpl;
import com.rider.rlab_im_map_plugin.channel.IMMapOmegaServiceImpl;
import com.rider.rlab_im_map_plugin.channel.MapIMServiceImpl;
import com.rider.rlab_im_map_plugin.channel.NavIMServiceImpl;
import com.rider.rlab_im_map_plugin.channel.XpannelServiceImpl;
import com.rider.rlab_im_map_plugin.tool.ImCallFrom;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import java.util.Locale;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.plugin.common.BinaryMessenger;

public final class ImMapConfig {

    /* renamed from: a */
    private static final Logger f58614a = LoggerFactory.getLogger("ImMapEngine");

    /* renamed from: b */
    private static volatile ImMapConfig f58615b = null;

    /* renamed from: c */
    private Context f58616c;

    /* renamed from: d */
    private boolean f58617d = false;

    /* renamed from: e */
    private boolean f58618e = false;

    /* renamed from: f */
    private String f58619f;

    /* renamed from: g */
    private ImCallFrom f58620g;

    /* renamed from: h */
    private ImFavorFrom f58621h;

    /* renamed from: i */
    private boolean f58622i = true;

    /* renamed from: j */
    private String f58623j;

    /* renamed from: k */
    private String f58624k;

    /* renamed from: l */
    private int f58625l;

    /* renamed from: m */
    private int f58626m;

    /* renamed from: n */
    private int f58627n;

    /* renamed from: o */
    private boolean f58628o;

    /* renamed from: p */
    private boolean f58629p;

    /* renamed from: q */
    private OnSelectNavListener f58630q;

    /* renamed from: r */
    private CustomerConfigListener f58631r;

    /* renamed from: s */
    private OmegaParamsCallback f58632s;

    /* renamed from: t */
    private Locale f58633t;

    /* renamed from: u */
    private boolean f58634u = false;

    /* renamed from: v */
    private LatLng f58635v;

    /* renamed from: w */
    private boolean f58636w = false;

    /* renamed from: x */
    private NachoAction f58637x;

    /* renamed from: y */
    private boolean f58638y = false;

    /* renamed from: z */
    private int f58639z = 0;

    private ImMapConfig() {
    }

    public static ImMapConfig getInstance() {
        ImMapConfig imMapConfig;
        if (f58615b != null) {
            return f58615b;
        }
        synchronized (ImMapConfig.class) {
            if (f58615b == null) {
                f58615b = new ImMapConfig();
            }
            imMapConfig = f58615b;
        }
        return imMapConfig;
    }

    public ImMapConfig setImCallFrom(ImCallFrom imCallFrom) {
        this.f58620g = imCallFrom;
        return this;
    }

    public ImMapConfig setImFavorFrom(ImFavorFrom imFavorFrom) {
        this.f58621h = imFavorFrom;
        return this;
    }

    public ImMapConfig setUserNewMap(boolean z) {
        this.f58622i = z;
        return this;
    }

    public ImMapConfig setProductId(String str) {
        this.f58623j = str;
        return this;
    }

    public ImMapConfig setToken(String str) {
        this.f58624k = str;
        return this;
    }

    public ImMapConfig setNavType(int i) {
        this.f58625l = i;
        return this;
    }

    public ImMapConfig setZoomLevel(int i) {
        this.f58626m = i;
        return this;
    }

    public ImMapConfig setTravelMode(int i) {
        this.f58627n = i;
        return this;
    }

    public ImMapConfig setDowngradeMap(boolean z) {
        this.f58617d = z;
        return this;
    }

    public ImMapConfig setMapStyle(String str) {
        this.f58619f = str;
        return this;
    }

    public ImMapConfig setGoogleNav(boolean z) {
        this.f58628o = z;
        return this;
    }

    public ImMapConfig setIsDebug(boolean z) {
        this.f58629p = z;
        return this;
    }

    public ImMapConfig setDowngradeMapNavigation(boolean z) {
        this.f58618e = z;
        return this;
    }

    public ImMapConfig setOnSelectNavListener(OnSelectNavListener onSelectNavListener) {
        this.f58630q = onSelectNavListener;
        return this;
    }

    public ImMapConfig setCustomerConfigListener(CustomerConfigListener customerConfigListener) {
        this.f58631r = customerConfigListener;
        return this;
    }

    public ImMapConfig setOmegaParamsCallback(OmegaParamsCallback omegaParamsCallback) {
        this.f58632s = omegaParamsCallback;
        return this;
    }

    public ImMapConfig setLocale(Locale locale) {
        this.f58633t = locale;
        return this;
    }

    public ImMapConfig setShowMapTool(boolean z) {
        this.f58634u = z;
        return this;
    }

    public ImMapConfig setMockLatLng(LatLng latLng) {
        this.f58635v = latLng;
        return this;
    }

    public ImMapConfig setNachoAction(NachoAction nachoAction) {
        this.f58637x = nachoAction;
        return this;
    }

    public ImMapConfig setHmsService(boolean z) {
        this.f58638y = z;
        return this;
    }

    public ImMapConfig setBusinessType(int i) {
        this.f58639z = i;
        return this;
    }

    public void build(Context context) {
        this.f58616c = context;
        ImCallFrom imCallFrom = this.f58620g;
        if (imCallFrom == null) {
            f58614a.info("callFrom must be not null , please set", new Object[0]);
            throw new NullPointerException("callFrom must be not null , please set");
        } else if (this.f58633t == null) {
            f58614a.info("locale must be not null , please set", new Object[0]);
            throw new NullPointerException("locale must be not null , please set");
        } else if (this.f58632s != null) {
            if (this.f58625l == 0) {
                if (imCallFrom == ImCallFrom.IMMAP_RLAB_D) {
                    this.f58625l = 1;
                } else if (this.f58620g == ImCallFrom.IMMAP_RLAB_C) {
                    this.f58625l = 2;
                } else {
                    this.f58625l = 1;
                }
            }
            if (this.f58626m == 0) {
                this.f58626m = 14;
            }
            if (this.f58627n == 0) {
                this.f58627n = 1;
            }
            if (this.f58621h == null) {
                this.f58621h = ImFavorFrom.IMMAP_GLOBAL;
            }
            FlutterEngine flutterEngine = null;
            NachoAction nachoAction = this.f58637x;
            if (nachoAction != null) {
                flutterEngine = nachoAction.getEngine();
            }
            if (flutterEngine != null) {
                BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
                new MapIMServicePlugin().setup(binaryMessenger);
                new MapIMNavigationServicePlugin().setup(binaryMessenger);
                IMXpannelServiceRegister.setup(binaryMessenger, new XpannelServiceImpl());
                MapIMServiceRegister.setup(binaryMessenger, new MapIMServiceImpl());
                NavigationIMServiceRegister.setup(binaryMessenger, new NavIMServiceImpl());
                IMMapLogServiceRegister.setup(binaryMessenger, new IMMapLogServiceImpl());
                IMMapOmegaServiceRegister.setup(binaryMessenger, new IMMapOmegaServiceImpl());
                f58614a.info("initialize im sdk", new Object[0]);
                return;
            }
            f58614a.info("engine is null , preinitialization", new Object[0]);
            throw new NullPointerException("初始化该IM地图库，必须放到初始化flutter之后，才能保证flutter和na交互正常");
        } else {
            f58614a.info("omega must be not null , please set", new Object[0]);
            throw new NullPointerException("omega must be not null , please set");
        }
    }

    public boolean isDowngradeMap() {
        return this.f58617d;
    }

    public Context getContext() {
        return this.f58616c;
    }

    public String getRouterPath() {
        return "http://rider.didichuxing.com" + ImCommons.ROUTE_PAGE_MAIN + ImCommons.IM_PATH;
    }

    public String getMapStyle() {
        return this.f58619f;
    }

    public ImCallFrom getCallFrom() {
        return this.f58620g;
    }

    public ImFavorFrom getFavorFrom() {
        return this.f58621h;
    }

    public boolean isUserNewMap() {
        return this.f58622i;
    }

    public String getProductId() {
        return this.f58623j;
    }

    public String getToken() {
        return this.f58624k;
    }

    public int getNavType() {
        return this.f58625l;
    }

    public int getZoomLevel() {
        return this.f58626m;
    }

    public int getTravelMode() {
        return this.f58627n;
    }

    public boolean isGoogleNav() {
        return this.f58628o;
    }

    public boolean isDebug() {
        return this.f58629p;
    }

    public boolean isDowngradeMapNavigation() {
        return this.f58618e;
    }

    public OnSelectNavListener getOnSelectNavListener() {
        return this.f58630q;
    }

    public CustomerConfigListener getCustomerConfigListener() {
        return this.f58631r;
    }

    public OmegaParamsCallback getOmegaParamsCallback() {
        return this.f58632s;
    }

    public Locale getLocale() {
        return this.f58633t;
    }

    public boolean isShowMapTool() {
        return this.f58634u;
    }

    public LatLng getMockLatLng() {
        return this.f58635v;
    }

    public NachoAction getNachoAction() {
        return this.f58637x;
    }

    public boolean isHmsService() {
        return this.f58638y;
    }

    public int getBusinessType() {
        return this.f58639z;
    }
}
