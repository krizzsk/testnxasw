package com.didi.safety.god.manager;

import android.content.Context;
import android.os.Environment;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.greatwall.protocol.ComponentBridge;
import com.didi.ifx.license.IFXLicenseClient;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.safety.god.greatwall.SafetyGodComponent;
import com.didi.safety.god.http.SafetyHttp;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.manager.callback.SafetyGodCallBack;
import com.didi.safety.god.util.LogUtils;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.didi.sdk.util.FileUtil;
import com.didi.sec.algo.AlgDetector;
import com.didi.sec.algo.RawDetectInfo;
import com.didichuxing.dfbasesdk.logupload2.LogReporter2;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GodManager {
    public static final int CODE_ENTER_SDK_NULL_CALLBACK = 113;
    public static final int CODE_ENTER_SDK_REPEAT = 112;
    public static final int CODE_FAIL_CANCEL = 100;
    public static final int CODE_FAIL_CARTYPE_APPEALING = 105;
    public static final int CODE_FAIL_CHANGE_CAR = 104;
    public static final int CODE_FAIL_GRTOCR_ERROR = 107;
    public static final int CODE_FAIL_INIT_ERROR = 110;
    public static final int CODE_FAIL_INIT_PARAMS_ERROR = 108;
    public static final int CODE_FAIL_NO_CAMERA_PERMISSION = 109;
    public static final int CODE_FAIL_OCR_FIELDS_MISSING = 101;
    public static final int CODE_FAIL_REGISTER = 102;
    public static final int CODE_FAIL_RENT_CAR = 106;
    public static final int CODE_FAIL_UPLOAD_ERROR = 103;
    public static final int CODE_FAIL_VIN_NOT_CONSISTENT = 111;
    public static final int CODE_OK = 100000;

    /* renamed from: a */
    private static GodManager f37341a = null;

    /* renamed from: o */
    private static final String f37342o = "door_models";

    /* renamed from: p */
    private static final String[] f37343p = {"cl_driver_shuffle0.5_iter_150000.old.all.bin"};

    /* renamed from: q */
    private static final String[] f37344q = {"2424499eb37220704a2596e40d9f0456"};

    /* renamed from: b */
    private AlgDetector f37345b;

    /* renamed from: c */
    private CallbackFunction f37346c;

    /* renamed from: d */
    private CallbackFunction f37347d;

    /* renamed from: e */
    private SafetyGodCallBack f37348e;

    /* renamed from: f */
    private String f37349f = "model-all-in.bin";

    /* renamed from: g */
    private boolean f37350g;

    /* renamed from: h */
    private Context f37351h;

    /* renamed from: i */
    private String f37352i;

    /* renamed from: j */
    private String f37353j;

    /* renamed from: k */
    private long f37354k;

    /* renamed from: l */
    private String f37355l;

    /* renamed from: m */
    private boolean f37356m;

    /* renamed from: n */
    private String f37357n;

    /* renamed from: r */
    private IFXLicenseClient f37358r;

    /* renamed from: s */
    private int f37359s;

    /* renamed from: t */
    private LogReporter2 f37360t;

    /* renamed from: u */
    private Config f37361u;

    public static class Config {
        public String appealUrl;
        public float clearPicProportion;
        public float dectConf = 0.5f;
        public int delayedFocusTime = 2000;
        public boolean failCaseSwitch;
        public double mScreenCheckRate = 1.0d;
        public boolean standardLabelTimeoutSwitch;
        public boolean successCaseSwitch;
        public int timeOutEngine = 1000;
        public long timeOutSec = 20000;
    }

    public void init(String str, String str2, String str3, String str4) {
    }

    public static synchronized GodManager getInstance() {
        GodManager godManager;
        synchronized (GodManager.class) {
            if (f37341a == null) {
                f37341a = new GodManager();
            }
            godManager = f37341a;
        }
        return godManager;
    }

    private GodManager() {
    }

    public void setLogReporter(LogReporter2 logReporter2) {
        this.f37360t = logReporter2;
    }

    public void log(Map<String, Object> map) {
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        map.putAll(SafetyHttp.getCommonBodyParams());
        LogReporter2 logReporter2 = this.f37360t;
        if (logReporter2 != null) {
            logReporter2.log(map);
        }
    }

    public void setLanguage(String str) {
        this.f37357n = str;
    }

    public String getLanguage() {
        return this.f37357n;
    }

    public void setManual(boolean z) {
        this.f37356m = z;
    }

    public boolean getManualState() {
        return this.f37356m;
    }

    public String getMainPage() {
        return this.f37355l;
    }

    public void setMainPage(String str) {
        this.f37355l = str;
    }

    public void executeFinish(int i) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj = SafetyHttp.getCommonBodyParams().get("keeperId");
            if (obj == null) {
                str = "";
            } else {
                str = obj.toString();
            }
            jSONObject.put("keeperId", str);
            ComponentBridge.getInstance().executeFinish(SafetyGodComponent.NAME, i, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            ComponentBridge.getInstance().executeFinish(SafetyGodComponent.NAME, 4, jSONObject);
        }
    }

    public void executeFinish(int i, JSONObject jSONObject) {
        String str;
        try {
            Object obj = SafetyHttp.getCommonBodyParams().get("keeperId");
            if (obj == null) {
                str = "";
            } else {
                str = obj.toString();
            }
            jSONObject.put("keeperId", str);
            ComponentBridge.getInstance().executeFinish(SafetyGodComponent.NAME, i, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            ComponentBridge.getInstance().executeFinish(SafetyGodComponent.NAME, 4, jSONObject);
        }
    }

    public synchronized void init(Context context) {
        this.f37351h = context.getApplicationContext();
        m28184a(context);
    }

    public void loadModel() {
        if (this.f37345b == null) {
            this.f37345b = new AlgDetector();
        }
        File dir = this.f37351h.getDir(f37342o, 0);
        AlgDetector algDetector = this.f37345b;
        this.f37350g = algDetector.init(dir.getAbsolutePath() + "/cl_driver_shuffle0.5_iter_150000.old.all.bin");
        LogUtils.m28313i("AlgDetector init ok? " + this.f37350g);
    }

    public long getCacheModelVersion() {
        AlgDetector algDetector = this.f37345b;
        if (algDetector != null) {
            this.f37354k = algDetector.GetModelVersion(0);
        }
        return this.f37354k;
    }

    public long getDownloadModelVersion(String str) {
        AlgDetector algDetector = this.f37345b;
        if (algDetector != null) {
            this.f37354k = algDetector.GetModelVersion(1);
        }
        this.f37353j = str;
        return this.f37354k;
    }

    public File getDownloadPath() {
        File b = m28186b(this.f37351h);
        return new File(b, HotpatchStateConst.DOWNLOAD + File.separator + this.f37349f);
    }

    public void release() {
        AlgDetector algDetector = this.f37345b;
        if (algDetector != null) {
            algDetector.uninit();
        }
        f37341a = null;
    }

    /* renamed from: a */
    private void m28184a(Context context) {
        int i = 0;
        File dir = context.getDir(f37342o, 0);
        while (true) {
            String[] strArr = f37343p;
            if (i < strArr.length) {
                String str = strArr[i];
                File file = new File(dir, str);
                if (!file.exists() || !f37344q[i].equals(FileUtil.getFileMD5(file))) {
                    m28185a(context, str, file);
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m28185a(Context context, String str, File file) {
        try {
            FileUtil.copy(context.getAssets().open(str), new FileOutputStream(file));
            LogUtils.m28307d("unzip file " + str + " success, local path = " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private File m28186b(Context context) {
        File file;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = context.getExternalCacheDir();
        } else {
            file = context.getCacheDir();
        }
        return new File(file, "safety");
    }

    public RawDetectInfo yuvdetect(byte[] bArr, int i, int i2) {
        AlgDetector algDetector = this.f37345b;
        if (algDetector == null || ((double) (i * i2)) * 1.5d != ((double) bArr.length) || !this.f37350g) {
            return null;
        }
        return algDetector.detectYuv(bArr, i, i2);
    }

    public RawDetectInfo detect(byte[] bArr, int i, int i2) {
        AlgDetector algDetector = this.f37345b;
        if (algDetector == null || !this.f37350g) {
            return null;
        }
        return algDetector.detectArgb(bArr, i, i2);
    }

    public float calculateLightness(byte[] bArr, int i, int i2) {
        AlgDetector algDetector = this.f37345b;
        if (algDetector == null || ((double) (i * i2)) * 1.5d != ((double) bArr.length) || !this.f37350g) {
            return 0.0f;
        }
        return algDetector.calculatelightness(bArr, i, i2, 0, false);
    }

    public void setCallbackFunction(CallbackFunction callbackFunction) {
        this.f37346c = callbackFunction;
    }

    public void setCancelCallbackFunction(CallbackFunction callbackFunction) {
        this.f37347d = callbackFunction;
    }

    public void setReturnCallback(SafetyGodCallBack safetyGodCallBack) {
        this.f37348e = safetyGodCallBack;
    }

    public SafetyGodCallBack getReturnCallback() {
        return this.f37348e;
    }

    public void quitAndReturnConfig(SafetyGodResult safetyGodResult) {
        if (this.f37348e != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cmd", "QUIT_SDK_SUCCESSFULLY");
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "Quit SafetyGod sdk successfully");
            SafetyTraceEventHandler.trace(hashMap);
            release();
            this.f37348e.onCallBack(safetyGodResult);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("cmd", "CALLBACK_NULL");
        hashMap2.put(DMWebSocketListener.KEY_ERR_MSG, "quit safetyGod sdk when callback is null");
        SafetyTraceEventHandler.trace(hashMap2);
        release();
    }

    public void callbackOut(int i, String str, String str2) {
        SafetyGodResult safetyGodResult = new SafetyGodResult();
        try {
            safetyGodResult.setReturnCode(i);
            safetyGodResult.setMessage(str);
            safetyGodResult.setKeeperID(str2);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        quitAndReturnConfig(safetyGodResult);
    }

    public void callBackLast(int i, String str, String str2, Map map) {
        SafetyGodResult safetyGodResult = new SafetyGodResult();
        try {
            safetyGodResult.setReturnCode(i);
            safetyGodResult.setMessage(str);
            safetyGodResult.setKeeperID(str2);
            safetyGodResult.setJson(map);
            HashMap hashMap = new HashMap();
            hashMap.put("cmd", "CALLBACK");
            hashMap.put("code", Integer.valueOf(i));
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, str);
            hashMap.put("params", map);
            SafetyTraceEventHandler.trace(hashMap);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        quitAndReturnConfig(safetyGodResult);
    }

    public void setConfig(Config config) {
        this.f37361u = config;
    }

    public Config getConfig() {
        if (this.f37361u == null) {
            this.f37361u = new Config();
        }
        return this.f37361u;
    }
}
