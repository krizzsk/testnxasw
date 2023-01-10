package com.didi.onehybrid.devmode;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class DevBridgeDetailActivity extends Activity {

    /* renamed from: a */
    private FusionRuntimeInfo.BridgeInfo f31981a;

    /* renamed from: b */
    private View f31982b;

    /* renamed from: c */
    private TextView f31983c;

    /* renamed from: d */
    private TextView f31984d;

    /* renamed from: e */
    private TextView f31985e;

    /* renamed from: f */
    private TextView f31986f;

    /* renamed from: g */
    private TextView f31987g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_dev_bridge_detail);
        this.f31981a = (FusionRuntimeInfo.BridgeInfo) getIntent().getSerializableExtra("bridgeInfo");
        m24393a();
    }

    /* renamed from: a */
    private void m24393a() {
        View findViewById = findViewById(R.id.title_back);
        this.f31982b = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DevBridgeDetailActivity.this.finish();
            }
        });
        this.f31983c = (TextView) findViewById(R.id.call_pass_result);
        this.f31984d = (TextView) findViewById(R.id.bridge_version_content);
        this.f31985e = (TextView) findViewById(R.id.call_info_content);
        this.f31986f = (TextView) findViewById(R.id.call_args_content);
        this.f31987g = (TextView) findViewById(R.id.call_result_content);
        m24394b();
    }

    /* renamed from: b */
    private void m24394b() {
        if (this.f31981a.isRejected) {
            this.f31983c.setText("调用被拒绝");
            this.f31984d.setText("--------未知---------");
            this.f31985e.setText(this.f31981a.bridgeUrl);
            this.f31986f.setText("--------未知---------");
            this.f31987g.setText(this.f31981a.errMsg);
            return;
        }
        if (TextUtils.isEmpty(this.f31981a.errMsg)) {
            this.f31983c.setText("调用成功");
        } else {
            this.f31983c.setText("调用失败");
        }
        this.f31984d.setText(this.f31981a.bridgeVersion);
        TextView textView = this.f31985e;
        textView.setText(this.f31981a.moduleName + "." + this.f31981a.functionName);
        this.f31986f.setText(this.f31981a.args);
        if (!TextUtils.isEmpty(this.f31981a.callbackResult)) {
            this.f31987g.setText(this.f31981a.callbackResult);
        } else if (!TextUtils.isEmpty(this.f31981a.errMsg)) {
            this.f31987g.setText(this.f31981a.errMsg);
        } else {
            this.f31987g.setText("--------无响应信息---------");
        }
    }
}
