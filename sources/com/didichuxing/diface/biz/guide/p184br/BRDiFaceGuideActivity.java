package com.didichuxing.diface.biz.guide.p184br;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.AppealCanceledEvent;
import com.didichuxing.diface.appeal.AppealDoneEvent;
import com.didichuxing.diface.appeal.AppealLauncher;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.appeal.AppealResultAct;
import com.didichuxing.diface.appeal.ReappealEvent;
import com.didichuxing.diface.biz.guide.GuideHelper;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.data.PreGuideContent;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.saimageloader.DiSafetyImageLoader;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.util.HashMap;

/* renamed from: com.didichuxing.diface.biz.guide.br.BRDiFaceGuideActivity */
public class BRDiFaceGuideActivity extends DFBaseAct {

    /* renamed from: a */
    private TextView f50038a;

    /* renamed from: b */
    private Button f50039b;

    /* renamed from: c */
    private ImageView f50040c;

    /* renamed from: d */
    private GuideResult f50041d;

    /* renamed from: e */
    private PreGuideContent f50042e;

    /* renamed from: f */
    private GuideHelper f50043f;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.br_activity_diface_guide_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void realStart(Activity activity, GuideResult guideResult, PreGuideContent preGuideContent) {
        Intent intent = new Intent(activity, BRDiFaceGuideActivity.class);
        intent.putExtra(GuideHelper.EXTRA_KEY_GUIDE_RESULT, guideResult);
        intent.putExtra(GuideHelper.EXTRA_KEY_PRE_GUIDE_RESULT, preGuideContent);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        DiFaceFacade.getInstance().report("7", DiFaceLogger.getExitType("2"), (HashMap<String, Object>) null);
        m37426c();
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f50041d = (GuideResult) intent.getSerializableExtra(GuideHelper.EXTRA_KEY_GUIDE_RESULT);
        this.f50042e = (PreGuideContent) intent.getSerializableExtra(GuideHelper.EXTRA_KEY_PRE_GUIDE_RESULT);
        this.f50043f = new GuideHelper(this);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        DiFaceFacade.getInstance().report("6");
        m37423a();
    }

    /* renamed from: a */
    private void m37423a() {
        this.f50038a = (TextView) findViewById(R.id.guide_act_note2);
        this.f50039b = (Button) findViewById(R.id.bt_start_detect);
        this.f50040c = (ImageView) findViewById(R.id.guide_act_face);
        this.f50039b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report("10");
                BRDiFaceGuideActivity.this.toBioassayAct();
            }
        });
        m37425b();
        int i = this.f50041d.data.code;
        String str = this.f50041d.data.message;
        GuideResult.Result result = this.f50041d.data.result;
        if (i == 100006) {
            m37424a(str);
        }
    }

    /* renamed from: b */
    private void m37425b() {
        PreGuideContent preGuideContent = this.f50042e;
        if (preGuideContent != null) {
            if (!TextUtils.isEmpty(preGuideContent.guideImg)) {
                DiSafetyImageLoader.with(this).load(this.f50042e.guideImg).placeholder((int) R.drawable.br_df_guide_face_place_holder).error((int) R.drawable.br_guide_act_demo_face).into(this.f50040c);
            }
            GuideHelper.setTextViewText(this.mTitle, this.f50042e.guideTitle);
            GuideHelper.setTextViewText((TextView) findViewById(R.id.guide_act_title), this.f50042e.guideBlackTxt);
            GuideHelper.setTextViewText(this.f50038a, this.f50042e.guideFineTxt);
            if (TextUtils.isEmpty(this.f50042e.agreementContent) || TextUtils.isEmpty(this.f50042e.agreementTitle) || TextUtils.isEmpty(this.f50042e.checkBoxText)) {
                GuideHelper.setViewVisible(findViewById(R.id.ll_agreement_container), false);
                return;
            }
            try {
                GuideHelper.setViewVisible(findViewById(R.id.ll_agreement_container), true);
                GuideHelper.initAgreementText(this, (TextView) findViewById(R.id.tv_agreement_text), this.f50042e, R.color.df_checkbox_high_light);
                GuideHelper.initAgreementCheckBox(this, (CheckBox) findViewById(R.id.cb_agreement), this.f50042e.checkBoxStatus, this.f50039b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m37424a(String str) {
        AppealResultAct.start(this, 3, str);
    }

    @Subscribe
    public void onReappealEvent(ReappealEvent reappealEvent) {
        AppealParam appealParam = new AppealParam();
        appealParam.token = this.f50041d.token;
        appealParam.faceSessionId = this.f50041d.data.result.appealInfo.faceSessionId;
        appealParam.country = this.f50041d.data.result.country;
        appealParam.bizCode = String.valueOf(this.f50041d.bizCode);
        AppealLauncher.start(this, appealParam);
    }

    @Subscribe
    public void onAppealDoneEvent(AppealDoneEvent appealDoneEvent) {
        if (appealDoneEvent.status == 2) {
            finishWithResult(new DiFaceResult(114));
        }
    }

    @Subscribe
    public void onAppealCanceledEvent(AppealCanceledEvent appealCanceledEvent) {
        finishWithResult(new DiFaceResult(103, appealCanceledEvent.getMsg()));
    }

    public void toBioassayAct() {
        this.f50043f.toBioassayAct(this, this.f50041d);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            try {
                LogUtils.m37051d("onActResult====, resultCode=" + i2);
                if (i2 == -1) {
                    finishWithResult((DiFaceResult) intent.getSerializableExtra(DiFace.DIFACE_RESULT_KEY));
                }
            } catch (Exception unused) {
                finishWithResult(new DiFaceResult(106));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void makeFaceResult(DiFaceResult diFaceResult) {
        super.makeFaceResult(diFaceResult);
        DiFaceFacade.getInstance().notifyCallback(diFaceResult);
    }

    public void onBackPressed() {
        DiFaceFacade.getInstance().report("7", DiFaceLogger.getExitType("1"), (HashMap<String, Object>) null);
        m37426c();
    }

    /* renamed from: c */
    private void m37426c() {
        new AlertDialogFragment.Builder(this).setMessage(getString(R.string.df_exit_sdk_dialog_title)).setPositiveButton((int) R.string.df_exit_sdk_dialog_positive_btn, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SDK_EXIT_DIALOG_CANCEL);
                alertDialogFragment.dismiss();
            }
        }).setPositiveButtonDefault().setCancelable(false).setNegativeButton((int) R.string.df_exit_sdk_dialog_negative_btn, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SDK_EXIT_DIALOG_CONFIRM);
                alertDialogFragment.dismiss();
                BRDiFaceGuideActivity.this.finishWithResult(new DiFaceResult(102));
            }
        }).create().show(getSupportFragmentManager(), "");
    }
}
