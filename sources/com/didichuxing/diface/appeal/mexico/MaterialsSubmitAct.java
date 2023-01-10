package com.didichuxing.diface.appeal.mexico;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.act.DFStyleBaseAct;
import com.didichuxing.diface.appeal.AppealDoneEvent;
import com.didichuxing.diface.appeal.AppealLauncher;
import com.didichuxing.diface.appeal.AppealResultAct;
import com.didichuxing.diface.appeal.TakePhotoDoneEvent2;
import com.didichuxing.diface.appeal.TakePhotoGuideAct;
import com.didichuxing.diface.appeal.TakePhotoInfo;
import com.didichuxing.diface.appeal.mexico.adapter.MaterialsSubmitAdapter;
import com.didichuxing.diface.appeal.mexico.adapter.OnItemClickListener;
import com.didichuxing.diface.appeal.mexico.model.AppealAdditionTypesBean;
import com.didichuxing.diface.appeal.mexico.model.DocumentCardsBean;
import com.didichuxing.diface.appeal.mexico.toolkit.Counter;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.ToastUtil;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MaterialsSubmitAct extends DFStyleBaseAct implements C16207a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Button f49727a;

    /* renamed from: b */
    private ListView f49728b;

    /* renamed from: c */
    private MaterialsSubmitAdapter f49729c;

    /* renamed from: d */
    private AppealAdditionTypesBean f49730d;

    /* renamed from: e */
    private Counter f49731e;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.act_df_materials_submit_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public void onCanceled() {
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.df_appeal_materials_submit_loading_msg;
    }

    public static void start(Context context, AppealAdditionTypesBean appealAdditionTypesBean) {
        Intent intent = new Intent(context, MaterialsSubmitAct.class);
        intent.putExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM, appealAdditionTypesBean);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f49730d = (AppealAdditionTypesBean) intent.getSerializableExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_ENTER_SUBMIT_MATERIALS);
        this.f49731e = new Counter(this.f49730d.getDocumentCards(), new Runnable() {
            public void run() {
                if (MaterialsSubmitAct.this.f49727a != null) {
                    MaterialsSubmitAct.this.f49727a.setEnabled(true);
                }
            }
        });
        this.f49728b = (ListView) findViewById(R.id.lv_content_list);
        MaterialsSubmitAdapter materialsSubmitAdapter = new MaterialsSubmitAdapter(this);
        this.f49729c = materialsSubmitAdapter;
        this.f49728b.setAdapter(materialsSubmitAdapter);
        this.f49729c.addAllItem(this.f49730d.getDocumentCards(), true);
        this.f49729c.setOnItemClickListener(new OnItemClickListener<DocumentCardsBean>() {
            public void onClick(View view, int i, DocumentCardsBean documentCardsBean) {
                TakePhotoGuideAct.start(MaterialsSubmitAct.this, documentCardsBean);
            }
        });
        Button button = (Button) findViewById(R.id.submit_btn);
        this.f49727a = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MaterialsSubmitAct.this.m37223b();
            }
        });
    }

    @Subscribe
    public void onAppealDoneEvent(AppealDoneEvent appealDoneEvent) {
        finish();
    }

    @Subscribe
    public void onTakePhotoDoneEvent(TakePhotoDoneEvent2 takePhotoDoneEvent2) {
        Counter counter = this.f49731e;
        if (counter != null) {
            counter.remove(takePhotoDoneEvent2.documentCardsBean);
        }
        this.f49729c.takeDone(takePhotoDoneEvent2.documentCardsBean);
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        Counter counter = this.f49731e;
        if (counter == null || counter.residue() != 0) {
            super.onLeftTitleBtnClicked();
        } else {
            m37221a();
        }
    }

    public void onBackPressed() {
        Counter counter = this.f49731e;
        if (counter == null || counter.residue() != 0) {
            super.onBackPressed();
        } else {
            m37221a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        TakePhotoInfo.delAllPhotos(getCacheDir());
    }

    /* renamed from: a */
    private void m37221a() {
        new BackConfirmDFragment().show(getSupportFragmentManager(), "dialog");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m37223b() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SUBMIT_MATERIALS_CLICKED);
        showProgress();
        GlobalSubmitParam c = m37225c();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m37222a(arrayList, arrayList2);
        new SubmitModel(this).submit(c, arrayList, arrayList2, new AbsRpcCallback<NewBaseResult<SubmitResult>, SubmitResult>() {
            /* access modifiers changed from: protected */
            public void failure(int i, String str) {
                LogUtils.m37051d("submit materials failed, code====" + i + ", msg=" + str);
                MaterialsSubmitAct.this.hideProgress();
                ToastUtil.showToastInfo((Context) MaterialsSubmitAct.this, i == 100004 ? R.string.df_appeal_materials_submit_repeated_failed_msg : R.string.df_appeal_materials_submit_failed_msg);
            }

            /* access modifiers changed from: protected */
            public void success(SubmitResult submitResult, int i, String str) {
                MaterialsSubmitAct.this.hideProgress();
                LogUtils.m37051d("submit materials, code====" + i + ", msg=" + str);
                DiFaceFacade.getInstance().reportEventWithCode(DiFaceLogger.EVENT_ID_SUBMIT_MATERIALS_CALLBACK, i);
                ToastUtil.showToastInfo((Context) MaterialsSubmitAct.this, (int) R.string.df_appeal_materials_submit_success_msg);
                AppealResultAct.start(MaterialsSubmitAct.this, 2, str);
            }
        });
    }

    /* renamed from: a */
    private void m37222a(List<String> list, List<File> list2) {
        AppealAdditionTypesBean appealAdditionTypesBean = this.f49730d;
        if (appealAdditionTypesBean != null && appealAdditionTypesBean.getDocumentCards() != null && this.f49730d.getDocumentCards().size() > 0) {
            for (DocumentCardsBean next : this.f49730d.getDocumentCards()) {
                list.add(next.getArgs());
                File cacheDir = getCacheDir();
                list2.add(new File(cacheDir, next.getArgs() + ".jpg"));
            }
        }
    }

    /* renamed from: c */
    private GlobalSubmitParam m37225c() {
        GlobalSubmitParam globalSubmitParam = new GlobalSubmitParam();
        globalSubmitParam.token = this.f49730d.getToken();
        globalSubmitParam.faceSessionId = this.f49730d.getSessionId();
        globalSubmitParam.language = DiFaceFacade.getInstance().getLanguage();
        return globalSubmitParam;
    }

    public void onConfirmed() {
        finish();
    }
}
