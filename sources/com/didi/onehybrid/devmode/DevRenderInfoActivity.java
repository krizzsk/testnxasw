package com.didi.onehybrid.devmode;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class DevRenderInfoActivity extends Activity {

    /* renamed from: a */
    private FusionRuntimeInfo.RenderInfo f32013a;

    /* renamed from: b */
    private View f32014b;

    /* renamed from: c */
    private TextView f32015c;

    /* renamed from: d */
    private TextView f32016d;

    /* renamed from: e */
    private TextView f32017e;

    /* renamed from: f */
    private TextView f32018f;

    /* renamed from: g */
    private TextView f32019g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_dev_render_info);
        this.f32013a = (FusionRuntimeInfo.RenderInfo) getIntent().getSerializableExtra("renderInfo");
        m24403a();
    }

    /* renamed from: a */
    private void m24403a() {
        View findViewById = findViewById(R.id.title_back);
        this.f32014b = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DevRenderInfoActivity.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.url_content);
        this.f32015c = textView;
        textView.setText(this.f32013a.reqUrl);
        TextView textView2 = (TextView) findViewById(R.id.render_time_content);
        this.f32016d = textView2;
        textView2.setText(this.f32013a.totalTime + "ms");
        this.f32017e = (TextView) findViewById(R.id.offline_bundle_content);
        if (this.f32013a.mBundles == null || this.f32013a.mBundles.isEmpty()) {
            this.f32017e.setText("------无------");
        } else {
            for (Map.Entry<String, HashMap<String, String>> value : this.f32013a.mBundles.entrySet()) {
                for (Map.Entry key : ((HashMap) value.getValue()).entrySet()) {
                    TextView textView3 = this.f32017e;
                    textView3.append(((String) key.getKey()) + "\n");
                }
            }
        }
        this.f32018f = (TextView) findViewById(R.id.file_cache_content);
        if (this.f32013a.fileCacheRes == null || this.f32013a.fileCacheRes.isEmpty()) {
            this.f32018f.setText("------无------");
        } else {
            for (String str : this.f32013a.fileCacheRes) {
                TextView textView4 = this.f32018f;
                textView4.append(str + "\n");
            }
        }
        this.f32019g = (TextView) findViewById(R.id.cdn_content);
        if (this.f32013a.cdnRes == null || this.f32013a.cdnRes.isEmpty()) {
            this.f32019g.setText("------无------");
            return;
        }
        for (String str2 : this.f32013a.cdnRes) {
            TextView textView5 = this.f32019g;
            textView5.append(str2 + "\n");
        }
    }
}
