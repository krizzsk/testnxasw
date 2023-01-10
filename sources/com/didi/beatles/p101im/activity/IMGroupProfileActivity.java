package com.didi.beatles.p101im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.adapter.IMGroupProfileAdapter;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IMModifyGroupForbidCallback;
import com.didi.beatles.p101im.module.IMSessionCallback;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.module.entity.IMUser;
import com.didi.beatles.p101im.module.impl.IMGroupUserInfoCallback;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.IMSlideSwitch;
import com.didi.beatles.p101im.views.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.activity.IMGroupProfileActivity */
public class IMGroupProfileActivity extends IMBaseActivity {

    /* renamed from: a */
    private static final String f10742a = "extra_sid";

    /* renamed from: b */
    private static final String f10743b = "extra_forbid";

    /* renamed from: c */
    private static final int f10744c = 5;

    /* renamed from: d */
    private RecyclerView f10745d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f10746e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IMSlideSwitch f10747f;

    /* renamed from: g */
    private CommonTitleBar f10748g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IMGroupProfileAdapter f10749h;

    /* renamed from: i */
    private long f10750i;

    /* renamed from: j */
    private boolean f10751j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IMSession f10752k;

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.activity_group_profile);
        m9368a();
        m9374c();
        m9372b();
    }

    public static void startActivity(Context context, long j) {
        Intent intent = new Intent(context, IMGroupProfileActivity.class);
        intent.putExtra(f10742a, j);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    private void m9368a() {
        this.f10750i = getIntent().getLongExtra(f10742a, 0);
    }

    /* renamed from: b */
    private void m9372b() {
        IMManager.getInstance().getSessionModel().getSessionFromLocal(this.f10750i, new IMSessionCallback() {
            public void onSessionOptionResult(List<IMSession> list, int i) {
            }

            public void onSessionStatusUpdate(List<IMSession> list) {
            }

            public void onSessionLoad(List<IMSession> list) {
                if (list != null && list.size() != 0) {
                    IMSession unused = IMGroupProfileActivity.this.f10752k = list.get(0);
                    IMGroupProfileActivity.this.f10746e.setText(IMGroupProfileActivity.this.f10752k.getSessionName());
                    IMGroupProfileActivity.this.f10747f.setState(IMGroupProfileActivity.this.f10752k.getIsForbid());
                }
            }
        });
        IMManager.getInstance().getUserModel().getUserInfo(this.f10750i, (IMGroupUserInfoCallback) new IMGroupUserInfoCallback() {
            public void onUserInfoLoaded(List<IMUser> list) {
                IMGroupProfileActivity.this.f10749h.updateData(list);
            }
        }, true);
    }

    /* renamed from: c */
    private void m9374c() {
        this.f10745d = (RecyclerView) findViewById(R.id.profile_recyclerview);
        this.f10747f = (IMSlideSwitch) findViewById(R.id.forbid_slide_switch);
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.group_title_bar);
        this.f10748g = commonTitleBar;
        commonTitleBar.setTitle(IMResource.getString(R.string.im_group_title));
        this.f10746e = (TextView) findViewById(R.id.im_group_name);
        this.f10747f.setSlideListener(new IMSlideSwitch.SlideListener() {
            public void open(boolean z) {
                if (z) {
                    IMGroupProfileActivity.this.m9370a(true);
                }
            }

            public void close(boolean z) {
                if (z) {
                    IMGroupProfileActivity.this.m9370a(false);
                }
            }
        });
        this.f10748g.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMGroupProfileActivity.this.finish();
            }
        });
        m9376d();
    }

    /* renamed from: d */
    private void m9376d() {
        IMGroupProfileAdapter iMGroupProfileAdapter = new IMGroupProfileAdapter();
        this.f10749h = iMGroupProfileAdapter;
        iMGroupProfileAdapter.setData((List<IMUser>) null, this);
        this.f10745d.setAdapter(this.f10749h);
        this.f10745d.setLayoutManager(new GridLayoutManager((Context) this, 5, 1, false));
        this.f10745d.setPadding((IMViewUtil.getWindowWidth(this) - (IMViewUtil.dp2px(this, 45.0f) * 5)) / 6, 0, 0, IMViewUtil.dp2px(this, 15.0f));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9370a(boolean z) {
        IMManager.getInstance().getSessionModel().modifyGroupForbidState(this.f10750i, z, new IMModifyGroupForbidCallback() {
            public void onFailed(String str) {
            }

            public void onSucceed() {
            }
        });
    }
}
