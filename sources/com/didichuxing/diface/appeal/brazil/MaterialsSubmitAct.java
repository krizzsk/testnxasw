package com.didichuxing.diface.appeal.brazil;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.StrToNumUtils;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.AppealDoneEvent;
import com.didichuxing.diface.appeal.AppealLauncher;
import com.didichuxing.diface.appeal.AppealResultAct;
import com.didichuxing.diface.appeal.DelPhotoDoneEvent;
import com.didichuxing.diface.appeal.SubmitParam;
import com.didichuxing.diface.appeal.TakePhotoDoneEvent;
import com.didichuxing.diface.appeal.TakePhotoInfo;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.ToastUtil;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;

public class MaterialsSubmitAct extends DFBaseAct {

    /* renamed from: a */
    private TextView f49704a;

    /* renamed from: b */
    private TextView f49705b;

    /* renamed from: c */
    private TextView f49706c;

    /* renamed from: d */
    private Button f49707d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SubmitParam f49708e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f49709f;

    /* renamed from: g */
    private boolean f49710g;

    /* renamed from: h */
    private boolean f49711h;

    /* renamed from: i */
    private boolean f49712i;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.br_act_df_materials_submit_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.df_appeal_materials_submit_loading_msg;
    }

    public static void start(Context context, SubmitParam submitParam) {
        Intent intent = new Intent(context, MaterialsSubmitAct.class);
        intent.putExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM, submitParam);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        SubmitParam submitParam = (SubmitParam) intent.getSerializableExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM);
        this.f49708e = submitParam;
        this.f49709f = submitParam.driverLicenseType == 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m37199a(String str) {
        return StrToNumUtils.toInt(str, 1) + 2;
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_ENTER_SUBMIT_MATERIALS);
        findViewById(R.id.doc_type_container).setVisibility(this.f49709f ? 8 : 0);
        TextView textView = (TextView) findViewById(R.id.doc_type_take_photo);
        this.f49704a = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MaterialsSubmitAct materialsSubmitAct = MaterialsSubmitAct.this;
                BRTakePhotoGuideAct.start(MaterialsSubmitAct.this, materialsSubmitAct.m37199a(materialsSubmitAct.f49708e.additionalDocType));
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.driver_photo_take_photo);
        this.f49705b = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoGuideAct.start(MaterialsSubmitAct.this, MaterialsSubmitAct.this.f49709f ? 2 : 1);
            }
        });
        TextView textView3 = (TextView) findViewById(R.id.face_photo_take_photo);
        this.f49706c = textView3;
        textView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoGuideAct.start(MaterialsSubmitAct.this, 7);
            }
        });
        TextView textView4 = (TextView) findViewById(R.id.driver_photo_title);
        TextView textView5 = (TextView) findViewById(R.id.driver_photo_desc);
        if (this.f49709f) {
            textView4.setText(R.string.df_appeal_materials_driver_qrcode_note);
            textView5.setText(R.string.df_appeal_materials_driver_qrcode_desc);
            this.f49712i = true;
        } else {
            ((TextView) findViewById(R.id.doc_type_title)).setText(getResources().getStringArray(R.array.df_appeal_additional_docs)[StrToNumUtils.toInt(this.f49708e.additionalDocType, 1) - 1]);
            textView4.setText(R.string.df_appeal_materials_driver_note);
            textView5.setText(R.string.df_appeal_materials_driver_desc);
        }
        Button button = (Button) findViewById(R.id.submit_btn);
        this.f49707d = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MaterialsSubmitAct.this.m37206c();
            }
        });
    }

    @Subscribe
    public void onAppealDoneEvent(AppealDoneEvent appealDoneEvent) {
        finish();
    }

    @Subscribe
    public void onTakePhotoDoneEvent(TakePhotoDoneEvent takePhotoDoneEvent) {
        String str = takePhotoDoneEvent.photo;
        if (TakePhotoInfo.FILE_DRIVER_LICENSE.equals(str) || TakePhotoInfo.FILE_DRIVER_QR.equals(str)) {
            m37201a(true);
            this.f49705b.setText(R.string.df_retake_photo);
        } else if (TakePhotoInfo.FILE_SELF_PHOTO.equals(str)) {
            m37204b(true);
            this.f49706c.setText(R.string.df_retake_photo);
        } else if (!TakePhotoInfo.FILE_DOC_RG_FRONT.equals(str)) {
            m37208c(true);
            this.f49704a.setText(R.string.df_retake_photo);
        }
    }

    @Subscribe
    public void onDelPhotoDoneEvent(DelPhotoDoneEvent delPhotoDoneEvent) {
        new File(getCacheDir(), delPhotoDoneEvent.photo).delete();
    }

    /* renamed from: a */
    private void m37201a(boolean z) {
        this.f49710g = z;
        this.f49707d.setEnabled(m37202a());
    }

    /* renamed from: b */
    private void m37204b(boolean z) {
        this.f49711h = z;
        this.f49707d.setEnabled(m37202a());
    }

    /* renamed from: c */
    private void m37208c(boolean z) {
        this.f49712i = z;
        this.f49707d.setEnabled(m37202a());
    }

    /* renamed from: a */
    private boolean m37202a() {
        return this.f49710g && this.f49711h && this.f49712i;
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        if (m37202a()) {
            m37203b();
        } else {
            super.onLeftTitleBtnClicked();
        }
    }

    public void onBackPressed() {
        if (m37202a()) {
            m37203b();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        TakePhotoInfo.delAllPhotos(getCacheDir());
    }

    /* renamed from: b */
    private void m37203b() {
        new AlertDialogFragment.Builder(this).setTitle(getString(R.string.df_appeal_materials_exit_dialog_title)).setMessage(getString(R.string.df_appeal_materials_exit_dialog_msg)).setPositiveButton((int) R.string.df_del_photo_dialog_confirm_btn_text, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                MaterialsSubmitAct.this.finish();
            }
        }).setPositiveButtonDefault().setCancelable(false).setNegativeButton((int) R.string.df_del_photo_dialog_cancel_btn_text, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
            }
        }).create().show(getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m37206c() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SUBMIT_MATERIALS_CLICKED);
        showProgress();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("bareHeadPhoto");
        arrayList2.add(new File(getCacheDir(), TakePhotoInfo.FILE_SELF_PHOTO));
        arrayList.add("driverLicensePhoto");
        arrayList2.add(new File(getCacheDir(), this.f49709f ? TakePhotoInfo.FILE_DRIVER_QR : TakePhotoInfo.FILE_DRIVER_LICENSE));
        String str = this.f49708e.additionalDocType;
        if (!TextUtils.isEmpty(str)) {
            arrayList.add("extraPic");
            int a = m37199a(str);
            arrayList2.add(new File(getCacheDir(), TakePhotoInfo.getFileName(a, 0)));
            if (TakePhotoInfo.isSpecialRGType(a)) {
                arrayList.add("extraPic1");
                arrayList2.add(new File(getCacheDir(), TakePhotoInfo.FILE_DOC_RG_BACK));
            }
            this.f49708e.buildExtra("additionalDocType", str);
        }
        new SubmitModel(this).submit(this.f49708e, arrayList, arrayList2, new AbsHttpCallback<SubmitResult>() {
            public void onSuccess(SubmitResult submitResult) {
                MaterialsSubmitAct.this.hideProgress();
                int i = submitResult.data.code;
                String str = submitResult.data.message;
                LogUtils.m37051d("submit materials, code====" + i + ", msg=" + str);
                DiFaceFacade.getInstance().reportEventWithCode(DiFaceLogger.EVENT_ID_SUBMIT_MATERIALS_CALLBACK, i);
                if (i == 100000) {
                    ToastUtil.showToastInfo((Context) MaterialsSubmitAct.this, (int) R.string.df_appeal_materials_submit_success_msg);
                    AppealResultAct.start(MaterialsSubmitAct.this, 2, str);
                    return;
                }
                onFailed(i, str);
            }

            public void onFailed(int i, String str) {
                LogUtils.m37051d("submit materials failed, code====" + i + ", msg=" + str);
                MaterialsSubmitAct.this.hideProgress();
                ToastUtil.showToastInfo((Context) MaterialsSubmitAct.this, i == 100004 ? R.string.df_appeal_materials_submit_repeated_failed_msg : R.string.df_appeal_materials_submit_failed_msg);
            }
        });
    }
}
