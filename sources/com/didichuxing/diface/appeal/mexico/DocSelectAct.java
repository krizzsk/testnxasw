package com.didichuxing.diface.appeal.mexico;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.diface.act.DFStyleBaseAct;
import com.didichuxing.diface.appeal.AppealCanceledEvent;
import com.didichuxing.diface.appeal.AppealDoneEvent;
import com.didichuxing.diface.appeal.AppealLauncher;
import com.didichuxing.diface.appeal.mexico.adapter.DocSelectAdapter;
import com.didichuxing.diface.appeal.mexico.model.AppealAdditionTypesBean;
import com.didichuxing.diface.appeal.mexico.model.AppealParameters;
import com.didichuxing.diface.utils.ToastUtil;
import com.squareup.otto.Subscribe;
import com.taxis99.R;

public class DocSelectAct extends DFStyleBaseAct {

    /* renamed from: a */
    private ListView f49723a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DocSelectAdapter f49724b;

    /* renamed from: c */
    private Button f49725c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppealParameters f49726d;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.act_df_additional_doc_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context, AppealParameters appealParameters) {
        Intent intent = new Intent(context, DocSelectAct.class);
        intent.putExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM, appealParameters);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f49726d = (AppealParameters) intent.getSerializableExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        this.f49723a = (ListView) findViewById(R.id.lv_content_list);
        this.f49725c = (Button) findViewById(R.id.next_btn);
        DocSelectAdapter docSelectAdapter = new DocSelectAdapter(this);
        this.f49724b = docSelectAdapter;
        this.f49723a.setAdapter(docSelectAdapter);
        this.f49724b.addAllItem(this.f49726d.getAppealAdditionTypes(), true);
        this.f49725c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AppealAdditionTypesBean current = DocSelectAct.this.f49724b.getCurrent();
                if (current != null) {
                    current.setToken(DocSelectAct.this.f49726d.getToken());
                    current.setSessionId(DocSelectAct.this.f49726d.getSessionId());
                    MaterialsSubmitAct.start(DocSelectAct.this, current);
                    return;
                }
                ToastUtil.showToastInfo((Context) DocSelectAct.this, (int) R.string.df_bi_failed_act_system_error_title);
            }
        });
    }

    @Subscribe
    public void onAppealDoneEvent(AppealDoneEvent appealDoneEvent) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        onBackPressed();
    }

    public void onBackPressed() {
        BusUtils.post(new AppealCanceledEvent());
        finish();
    }
}
