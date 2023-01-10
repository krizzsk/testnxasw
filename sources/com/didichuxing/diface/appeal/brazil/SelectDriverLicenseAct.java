package com.didichuxing.diface.appeal.brazil;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.fragment.app.FragmentTransaction;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.AppealCanceledEvent;
import com.didichuxing.diface.appeal.AppealDoneEvent;
import com.didichuxing.diface.appeal.AppealLauncher;
import com.didichuxing.diface.appeal.SubmitParam;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.util.HashMap;

public class SelectDriverLicenseAct extends DFBaseAct {
    public static final int DRIVER_LICENSE_ONE = 1;
    public static final int DRIVER_LICENSE_TWO = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RadioButton f49713a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RadioButton f49714b;

    /* renamed from: c */
    private Button f49715c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SubmitParam f49716d;

    /* renamed from: e */
    private boolean f49717e;

    /* renamed from: f */
    private final CompoundButton.OnCheckedChangeListener f49718f = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AutoTrackHelper.trackViewOnClick(compoundButton, z);
            if (z) {
                int id = compoundButton.getId();
                if (id == R.id.rb_btn1) {
                    SelectDriverLicenseAct.this.f49714b.setChecked(false);
                } else if (id == R.id.rb_btn2) {
                    SelectDriverLicenseAct.this.f49713a.setChecked(false);
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.act_df_select_driver_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context, SubmitParam submitParam) {
        Intent intent = new Intent(context, SelectDriverLicenseAct.class);
        intent.putExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM, submitParam);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f49716d = (SubmitParam) intent.getSerializableExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_ENTER_SELECT_DRIVER_LICENSE);
        RadioButton radioButton = (RadioButton) findViewById(R.id.rb_btn1);
        this.f49713a = radioButton;
        radioButton.setOnCheckedChangeListener(this.f49718f);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rb_btn2);
        this.f49714b = radioButton2;
        radioButton2.setOnCheckedChangeListener(this.f49718f);
        Button button = (Button) findViewById(R.id.next_btn);
        this.f49715c = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean isChecked = SelectDriverLicenseAct.this.f49713a.isChecked();
                SelectDriverLicenseAct.this.f49716d.driverLicenseType = isChecked ? 2 : 1;
                if (isChecked) {
                    SelectDriverLicenseAct.this.m37210a();
                } else {
                    SelectDriverLicenseAct.this.m37212b();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37210a() {
        HashMap hashMap = new HashMap();
        hashMap.put("driverType", Integer.valueOf(this.f49716d.driverLicenseType));
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SELECT_DRIVER_LICENSE_NEXT_CLICKED, (HashMap<String, Object>) hashMap);
        MaterialsSubmitAct.start(this, this.f49716d);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m37212b() {
        AdditionalDocAct.start(this);
    }

    /* renamed from: c */
    private void m37213c() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.df_view_anim_slide_up, 0);
        beginTransaction.replace(R.id.base_fragment_container, AdditionalDocFragment.newInstance());
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
        this.f49717e = true;
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        BusUtils.post(new AppealCanceledEvent());
        finish();
    }

    public void onBackPressed() {
        if (this.f49717e) {
            super.onBackPressed();
            this.f49717e = false;
            return;
        }
        BusUtils.post(new AppealCanceledEvent());
        finish();
    }

    @Subscribe
    public void onAppealDoneEvent(AppealDoneEvent appealDoneEvent) {
        finish();
    }

    @Subscribe
    public void onAdditionalDocSelectDoneEvent(AdditionalDocSelectDoneEvent additionalDocSelectDoneEvent) {
        this.f49717e = false;
        if (!additionalDocSelectDoneEvent.isCancel()) {
            this.f49716d.additionalDocType = additionalDocSelectDoneEvent.select;
            m37210a();
        }
    }
}
