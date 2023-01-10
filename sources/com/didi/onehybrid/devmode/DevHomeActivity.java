package com.didi.onehybrid.devmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.didi.onehybrid.FusionWebActivity;
import com.didi.onehybrid.resource.FusionCacheClient;
import com.didi.onehybrid.resource.offline.OfflineBundleManager;
import com.didi.onehybrid.util.C11212Util;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Map;

public class DevHomeActivity extends Activity implements View.OnClickListener {

    /* renamed from: a */
    private static final String f31992a = "xxx";

    /* renamed from: b */
    private FusionRuntimeInfo f31993b;

    /* renamed from: c */
    private View f31994c;

    /* renamed from: d */
    private View f31995d;

    /* renamed from: e */
    private TextView f31996e;

    /* renamed from: f */
    private TextView f31997f;

    /* renamed from: g */
    private View f31998g;

    /* renamed from: h */
    private TextView f31999h;

    /* renamed from: i */
    private TextView f32000i;

    /* renamed from: j */
    private View f32001j;

    /* renamed from: k */
    private TextView f32002k;

    /* renamed from: l */
    private TextView f32003l;

    /* renamed from: m */
    private View f32004m;

    /* renamed from: n */
    private TextView f32005n;

    /* renamed from: o */
    private TextView f32006o;

    /* renamed from: p */
    private View f32007p;

    /* renamed from: q */
    private TextView f32008q;

    /* renamed from: r */
    private TextView f32009r;

    /* renamed from: s */
    private View f32010s;

    /* renamed from: t */
    private TextView f32011t;

    /* renamed from: u */
    private TextView f32012u;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_dev_home);
        this.f31993b = (FusionRuntimeInfo) getIntent().getSerializableExtra("fusionRuntimeInfo");
        m24396a();
    }

    /* renamed from: a */
    private void m24396a() {
        View findViewById = findViewById(R.id.title_back);
        this.f31994c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DevHomeActivity.this.finish();
            }
        });
        View findViewById2 = findViewById(R.id.render_info);
        this.f31995d = findViewById2;
        findViewById2.setOnClickListener(this);
        this.f31996e = (TextView) findViewById(R.id.render_info_text);
        this.f31997f = (TextView) findViewById(R.id.render_info_time);
        m24397b();
        View findViewById3 = findViewById(R.id.offline_bundle);
        this.f31998g = findViewById3;
        findViewById3.setOnClickListener(this);
        this.f31999h = (TextView) findViewById(R.id.offline_bundle_text);
        this.f32000i = (TextView) findViewById(R.id.offline_bundle_size);
        m24398c();
        View findViewById4 = findViewById(R.id.file_cache);
        this.f32001j = findViewById4;
        findViewById4.setOnClickListener(this);
        this.f32002k = (TextView) findViewById(R.id.file_cache_text);
        this.f32003l = (TextView) findViewById(R.id.file_cache_size);
        m24399d();
        View findViewById5 = findViewById(R.id.bridge_info);
        this.f32004m = findViewById5;
        findViewById5.setOnClickListener(this);
        this.f32005n = (TextView) findViewById(R.id.bridge_info_text);
        this.f32006o = (TextView) findViewById(R.id.bridge_info_count);
        m24400e();
        View findViewById6 = findViewById(R.id.total_offline);
        this.f32007p = findViewById6;
        findViewById6.setOnClickListener(this);
        this.f32008q = (TextView) findViewById(R.id.total_offline_text);
        this.f32009r = (TextView) findViewById(R.id.total_offline_size);
        m24401f();
        View findViewById7 = findViewById(R.id.fusion_test);
        this.f32010s = findViewById7;
        findViewById7.setOnClickListener(this);
        this.f32011t = (TextView) findViewById(R.id.fusion_test_title);
        this.f32012u = (TextView) findViewById(R.id.fusion_test_content);
        m24402g();
    }

    /* renamed from: b */
    private void m24397b() {
        this.f31996e.setText("渲染信息");
        TextView textView = this.f31997f;
        textView.setText(this.f31993b.getRenderInfo().totalTime + "ms >");
    }

    /* renamed from: c */
    private void m24398c() {
        this.f31999h.setText(String.format("当前页面离线包(%d个)", new Object[]{Integer.valueOf(this.f31993b.getRenderInfo().mBundles.size())}));
        this.f32000i.setText(C11212Util.smartConvert(this.f31993b.getRenderInfo().getOfflineSize()) + " >");
    }

    /* renamed from: d */
    private void m24399d() {
        this.f32002k.setText("文件缓存");
        long cacheFileSize = this.f31993b.getRenderInfo().getCacheFileSize(FusionCacheClient.getHybridDir());
        this.f32003l.setText(C11212Util.smartConvert(cacheFileSize) + " >");
    }

    /* renamed from: e */
    private void m24400e() {
        this.f32005n.setText("Bridge调用信息");
        TextView textView = this.f32006o;
        textView.setText(this.f31993b.getBridgeInfoMap().size() + "个 >");
    }

    /* renamed from: f */
    private void m24401f() {
        if (OfflineBundleManager.isInitialized()) {
            OfflineBundleManager.getInstance().getOfflineInfo(this.f31993b);
        }
        this.f32008q.setText(String.format("所有页面离线包(%d个)", new Object[]{Integer.valueOf(this.f31993b.getRenderInfo().bundles.size())}));
        long j = 0;
        for (Map.Entry<String, Long> value : this.f31993b.getRenderInfo().bundles.entrySet()) {
            j += ((Long) value.getValue()).longValue();
        }
        this.f32009r.setText(C11212Util.smartConvert(j));
    }

    /* renamed from: g */
    private void m24402g() {
        this.f32011t.setText("打开FusionBridge Demo页面(乘客端)");
        this.f32012u.setText(IMTextUtils.STREET_IMAGE_TAG_END);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.render_info) {
            Intent intent = new Intent(this, DevRenderInfoActivity.class);
            intent.putExtra("renderInfo", this.f31993b.getRenderInfo());
            startActivity(intent);
        } else if (id == R.id.bridge_info) {
            Intent intent2 = new Intent(this, DevBridgeInfoActivity.class);
            intent2.putExtra("fusionRuntimeInfo", this.f31993b);
            startActivity(intent2);
        } else if (id == R.id.offline_bundle) {
            Intent intent3 = new Intent(this, OfflineDetailActivity.class);
            intent3.putExtra(Const._FUSION_OFFLINE_CACHE_INFO, this.f31993b);
            startActivity(intent3);
        } else if (id == R.id.file_cache) {
            startActivity(new Intent(this, CacheDetailActivity.class));
        } else if (id == R.id.total_offline) {
            Intent intent4 = new Intent(this, TotalOfflineActivity.class);
            intent4.putExtra(Const._FUSION_ALL_OFFLINE_CACHE_INFO, this.f31993b);
            startActivity(intent4);
        } else if (id == R.id.fusion_test) {
            Intent intent5 = new Intent(this, FusionWebActivity.class);
            intent5.putExtra("url", f31992a);
            startActivity(intent5);
        }
    }
}
