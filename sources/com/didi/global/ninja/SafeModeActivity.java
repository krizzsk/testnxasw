package com.didi.global.ninja;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.GlobalCountryCode;
import com.taxis99.R;
import java.io.File;
import java.math.BigDecimal;

public class SafeModeActivity extends Activity {
    public static final String SAFE_MODE_BUTTON_TEXT = "SAFE_MODE_BUTTON_TEXT";
    public static final String SAFE_MODE_IMAGE_URL = "SAFE_MODE_IMAGE_URL";
    public static final String SAFE_MODE_MESSAGE = "SAFE_MODE_MESSAGE";
    public static final String SAFE_MODE_TITLE = "SAFE_MODE_TITLE";

    /* renamed from: a */
    private Button f24780a;

    /* renamed from: b */
    private Button f24781b;

    /* renamed from: c */
    private Button f24782c;

    /* renamed from: d */
    private View.OnClickListener f24783d = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (view.getId() == R.id.btn_reboot_phone) {
                SystemUtils.showToast(Toast.makeText(SafeModeActivity.this, "请长按电源键，选择重启手机", 1));
            } else if (view.getId() == R.id.btn_clean_cache) {
                SystemUtils.log(6, "lmf", ">>>clearNativeCache>>>>>", (Throwable) null, "com.didi.global.ninja.SafeModeActivity$1", 42);
                SafeModeActivity safeModeActivity = SafeModeActivity.this;
                safeModeActivity.m19871c((Context) safeModeActivity);
                SystemUtils.log(6, "lmf", ">>>clearExternalCache>>>>>", (Throwable) null, "com.didi.global.ninja.SafeModeActivity$1", 44);
                SafeModeActivity safeModeActivity2 = SafeModeActivity.this;
                safeModeActivity2.m19872d(safeModeActivity2);
            } else {
                view.getId();
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_safe_mode);
        this.f24780a = (Button) findViewById(R.id.btn_reboot_phone);
        this.f24781b = (Button) findViewById(R.id.btn_clean_cache);
        this.f24782c = (Button) findViewById(R.id.btn_close);
        this.f24780a.setOnClickListener(this.f24783d);
        this.f24781b.setOnClickListener(this.f24783d);
        this.f24782c.setOnClickListener(this.f24783d);
    }

    /* renamed from: a */
    private String m19864a(Context context) throws Exception {
        long c = m19870c(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            c += m19870c(context.getExternalCacheDir());
        }
        return m19863a((double) c);
    }

    /* renamed from: b */
    private void m19867b(Context context) {
        m19866a(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            m19866a(context.getExternalCacheDir());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19871c(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            m19866a(context.getDataDir());
            return;
        }
        m19866a(context.getCacheDir());
        m19866a(context.getFilesDir());
        if (Build.VERSION.SDK_INT >= 21) {
            m19866a(context.getCodeCacheDir());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m19872d(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (Build.VERSION.SDK_INT >= 21) {
                for (File a : context.getExternalMediaDirs()) {
                    m19866a(a);
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (File a2 : context.getExternalCacheDirs()) {
                    m19866a(a2);
                }
                for (File a3 : context.getExternalFilesDirs((String) null)) {
                    m19866a(a3);
                }
                return;
            }
            m19866a(context.getExternalCacheDir());
            m19866a(context.getExternalFilesDir((String) null));
        }
    }

    /* renamed from: a */
    private boolean m19866a(File file) {
        if (file == null || !file.isDirectory()) {
            return true;
        }
        String[] list = file.list();
        for (String file2 : list) {
            if (!m19869b(new File(file, file2))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private boolean m19869b(File file) {
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!m19866a(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: c */
    private long m19870c(File file) throws Exception {
        long j;
        long j2 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    j = m19870c(listFiles[i]);
                } else {
                    j = listFiles[i].length();
                }
                j2 += j;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j2;
    }

    /* renamed from: a */
    private String m19863a(double d) {
        double d2 = d / 1024.0d;
        if (d2 < 1.0d) {
            return "0K";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(d2));
            return bigDecimal.setScale(2, 4).toPlainString() + "KB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d3));
            return bigDecimal2.setScale(2, 4).toPlainString() + "MB";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            BigDecimal bigDecimal3 = new BigDecimal(Double.toString(d4));
            return bigDecimal3.setScale(2, 4).toPlainString() + GlobalCountryCode.ENGLAND;
        }
        BigDecimal bigDecimal4 = new BigDecimal(d5);
        return bigDecimal4.setScale(2, 4).toPlainString() + "TB";
    }
}
