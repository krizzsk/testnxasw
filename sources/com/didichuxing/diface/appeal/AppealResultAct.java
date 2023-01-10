package com.didichuxing.diface.appeal;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.util.HashMap;

public class AppealResultAct extends DFBaseAct {
    public static final int STATUS_FAIL = 3;
    public static final int STATUS_UNDERWAY = 2;

    /* renamed from: a */
    private ImageView f49631a;

    /* renamed from: b */
    private TextView f49632b;

    /* renamed from: c */
    private TextView f49633c;

    /* renamed from: d */
    private Button f49634d;

    /* renamed from: e */
    private Button f49635e;

    /* renamed from: f */
    private int f49636f;

    /* renamed from: g */
    private String f49637g;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_result_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.act_df_appeal_result_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context, int i, String str) {
        Intent intent = new Intent(context, AppealResultAct.class);
        intent.putExtra("status", i);
        intent.putExtra("desc", str);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f49636f = intent.getIntExtra("status", 2);
        this.f49637g = intent.getStringExtra("desc");
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(this.f49636f));
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_ENTER_APPEAL_RESULT, (HashMap<String, Object>) hashMap);
        ImageView imageView = (ImageView) findViewById(R.id.result_status_icon);
        this.f49631a = imageView;
        imageView.setImageResource(m37154b());
        TextView textView = (TextView) findViewById(R.id.result_title_tv);
        this.f49632b = textView;
        textView.setText(m37155c());
        TextView textView2 = (TextView) findViewById(R.id.result_desc_tv);
        this.f49633c = textView2;
        textView2.setText(this.f49637g);
        this.f49634d = (Button) findViewById(R.id.main_btn);
        this.f49635e = (Button) findViewById(R.id.secondary_btn);
        if (this.f49636f == 3) {
            this.f49634d.setText(R.string.df_appeal_result_main_btn_text);
            this.f49634d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_RESULT_REAPPEAL_CLICKED);
                    BusUtils.post(new ReappealEvent());
                }
            });
            this.f49635e.setVisibility(0);
            this.f49635e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_RESULT_EXIT_CLICKED);
                    AppealResultAct.this.m37152a();
                }
            });
            return;
        }
        this.f49634d.setText(R.string.df_exit);
        this.f49634d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_RESULT_EXIT_CLICKED);
                AppealResultAct.this.m37152a();
            }
        });
    }

    @Subscribe
    public void onAppealRequestSuccessEvent(AppealRequestSuccessEvent appealRequestSuccessEvent) {
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37152a() {
        BusUtils.post(new AppealDoneEvent(this.f49636f));
        finish();
    }

    /* renamed from: b */
    private int m37154b() {
        return this.f49636f == 3 ? R.drawable.df_appeal_result_failed : R.drawable.df_appeal_result_underway;
    }

    /* renamed from: c */
    private int m37155c() {
        return this.f49636f == 3 ? R.string.df_appeal_result_title_fail : R.string.df_appeal_result_title_underway;
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        m37152a();
    }

    public void onBackPressed() {
        m37152a();
    }
}
