package com.didi.beatles.p101im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.api.entity.IMNewstandResponse;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IMNewstandInfoCallback;
import com.didi.beatles.p101im.views.IMProfileHeaderView;
import com.didi.beatles.p101im.views.messageCard.IMOneMessageCard1;
import com.didi.beatles.p101im.views.messageCard.IMOneMessageCard2;
import com.didi.beatles.p101im.views.messageCard.IMOneMessageCard3;
import com.didi.beatles.p101im.views.titlebar.CommonTitleBar;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.activity.IMUserProfileActivity */
public class IMUserProfileActivity extends IMBaseActivity {
    public static int ONE_MESSAGE_CARD_1 = 1;
    public static int ONE_MESSAGE_CARD_2 = 2;
    public static int ONE_MESSAGE_CARD_3 = 3;
    public static String USER_ID = "user_id";
    public static String USER_TITLE = "user_title";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CommonTitleBar f10863a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMProfileHeaderView f10864b;

    /* renamed from: c */
    private LinearLayout f10865c;

    /* renamed from: d */
    private TextView f10866d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IMNewstandResponse.NewStandInfo f10867e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f10868f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f10869g;

    /* renamed from: h */
    private long f10870h;

    /* renamed from: i */
    private String f10871i;

    public static void startActivity(Context context, String str, long j) {
        Intent intent = new Intent(context, IMUserProfileActivity.class);
        intent.putExtra(USER_ID, j);
        intent.putExtra(USER_TITLE, str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.im_user_profile_activity);
        m9528b();
        this.f10870h = getIntent().getLongExtra(USER_ID, 0);
        this.f10871i = getIntent().getStringExtra(USER_TITLE);
        m9525a();
    }

    /* renamed from: a */
    private void m9525a() {
        IMManager.getInstance().getNewstandInfo(this.f10870h, new IMNewstandInfoCallback() {
            public void onNewstandInfoLoaded(long j, IMNewstandResponse iMNewstandResponse) {
                if (iMNewstandResponse == null || iMNewstandResponse.Info == null) {
                    IMUserProfileActivity.this.f10868f.setVisibility(0);
                    IMUserProfileActivity.this.f10869g.setVisibility(8);
                    return;
                }
                IMNewstandResponse.NewStandInfo unused = IMUserProfileActivity.this.f10867e = iMNewstandResponse.Info;
                if (IMUserProfileActivity.this.f10867e.user != null && !TextUtils.isEmpty(IMUserProfileActivity.this.f10867e.user.user_name)) {
                    IMUserProfileActivity.this.f10863a.setTitle(IMUserProfileActivity.this.f10867e.user.user_name);
                }
                IMUserProfileActivity.this.f10864b.bindUserInfo(IMUserProfileActivity.this.f10867e);
                IMUserProfileActivity iMUserProfileActivity = IMUserProfileActivity.this;
                iMUserProfileActivity.m9526a(iMUserProfileActivity.f10867e);
            }
        });
    }

    /* renamed from: b */
    private void m9528b() {
        this.f10863a = (CommonTitleBar) findViewById(R.id.im_title_bar);
        if (!TextUtils.isEmpty(this.f10871i)) {
            this.f10863a.setTitle(this.f10871i);
        }
        this.f10863a.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMUserProfileActivity.this.finish();
            }
        });
        this.f10869g = findViewById(R.id.profile_content);
        this.f10868f = findViewById(R.id.im_empty_layout);
        this.f10864b = (IMProfileHeaderView) findViewById(R.id.profile_header);
        this.f10865c = (LinearLayout) findViewById(R.id.profile_history_contain);
        this.f10866d = (TextView) findViewById(R.id.aciton_title);
    }

    /* renamed from: c */
    private void m9531c() {
        this.f10865c.setVisibility(8);
        this.f10866d.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9526a(IMNewstandResponse.NewStandInfo newStandInfo) {
        if (newStandInfo == null) {
            m9531c();
            return;
        }
        IMNewstandResponse.NewStandHistory newStandHistory = newStandInfo.history;
        if (newStandHistory == null) {
            m9531c();
        } else if (newStandHistory.message.length > 0) {
            this.f10866d.setVisibility(0);
            for (int i = 0; i < newStandHistory.message.length; i++) {
                int i2 = newStandHistory.message[i].template;
                IMNewstandResponse.NewStandMessage newStandMessage = newStandHistory.message[i];
                if (i2 == ONE_MESSAGE_CARD_1) {
                    IMOneMessageCard1 iMOneMessageCard1 = new IMOneMessageCard1(this);
                    iMOneMessageCard1.bindViewData(newStandMessage, i);
                    this.f10865c.addView(iMOneMessageCard1);
                } else if (i2 == ONE_MESSAGE_CARD_2) {
                    IMOneMessageCard2 iMOneMessageCard2 = new IMOneMessageCard2(this);
                    iMOneMessageCard2.bindViewData(newStandMessage, i);
                    this.f10865c.addView(iMOneMessageCard2);
                } else if (i2 == ONE_MESSAGE_CARD_3) {
                    IMOneMessageCard3 iMOneMessageCard3 = new IMOneMessageCard3(this);
                    iMOneMessageCard3.bindViewData(newStandMessage, i);
                    this.f10865c.addView(iMOneMessageCard3);
                }
            }
        } else {
            m9531c();
        }
    }
}
