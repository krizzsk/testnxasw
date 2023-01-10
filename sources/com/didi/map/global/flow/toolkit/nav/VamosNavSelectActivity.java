package com.didi.map.global.flow.toolkit.nav;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.map.global.flow.toolkit.nav.VamosNavAdapter;
import com.didi.map.global.flow.utils.VamosNavUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class VamosNavSelectActivity extends Activity {

    /* renamed from: a */
    private static final String f29732a = VamosNavSelectActivity.class.getSimpleName();

    /* renamed from: b */
    private RecyclerView f29733b;

    /* renamed from: c */
    private ImageView f29734c;

    /* renamed from: d */
    private View f29735d;

    /* renamed from: e */
    private VamosNavAdapter f29736e;

    /* renamed from: f */
    private List<VamosNavModel> f29737f;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
        }
        setContentView(R.layout.activity_vamos_nav_select);
        m23063a();
        m23066b();
    }

    /* renamed from: a */
    private void m23063a() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_nav_main);
        this.f29733b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f29733b.addItemDecoration(new VamosNavHorizonDivider(this, R.drawable.nav_divider));
        this.f29734c = (ImageView) findViewById(R.id.iv_nav_close);
        this.f29735d = findViewById(R.id.v_empty_area);
    }

    /* renamed from: b */
    private void m23066b() {
        this.f29734c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VamosNavSelectActivity.this.m23067b(view);
            }
        });
        this.f29735d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VamosNavSelectActivity.this.m23064a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23067b(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23064a(View view) {
        finish();
    }

    /* renamed from: c */
    private void m23068c() {
        VamosNavAdapter vamosNavAdapter = new VamosNavAdapter(this, this.f29737f);
        this.f29736e = vamosNavAdapter;
        this.f29733b.setAdapter(vamosNavAdapter);
        this.f29736e.setOnNavItemClickListener(new VamosNavAdapter.OnNavItemClickListener() {
            public final void onNavItemClicked(VamosNavModel vamosNavModel) {
                VamosNavSelectActivity.this.m23065a(vamosNavModel);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23065a(VamosNavModel vamosNavModel) {
        if (vamosNavModel != null) {
            if (vamosNavModel.isInstalled) {
                VamosNavUtils.sCurChoice = vamosNavModel.pkgName;
                VamosNavUtils.startNavDirectly(this);
                VamosNavUtils.trackEventClickNavBtn(0);
            } else {
                VamosNavUtils.goToGooglePlay(this, vamosNavModel.pkgName);
            }
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        List<VamosNavModel> curNavAppList = VamosNavUtils.getCurNavAppList(this);
        this.f29737f = curNavAppList;
        VamosNavAdapter vamosNavAdapter = this.f29736e;
        if (vamosNavAdapter == null) {
            m23068c();
            return;
        }
        vamosNavAdapter.setDataList(curNavAppList);
        this.f29736e.notifyDataSetChanged();
    }
}
