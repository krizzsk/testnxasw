package com.didichuxing.diface.appeal.brazil;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.TakePhotoDoneEvent;
import com.didichuxing.diface.appeal.TakePhotoInfo;
import com.squareup.otto.Subscribe;
import com.taxis99.R;

public class BRTakePhotoGuideAct extends DFBaseAct {

    /* renamed from: a */
    private ImageView f49696a;

    /* renamed from: b */
    private TextView f49697b;

    /* renamed from: c */
    private TextView f49698c;

    /* renamed from: d */
    private TextView f49699d;

    /* renamed from: e */
    private TextView f49700e;

    /* renamed from: f */
    private Button f49701f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f49702g;

    /* renamed from: h */
    private final SparseArray<ResInfo> f49703h = new SparseArray<>();

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.br_act_df_take_photo_guide_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context, int i) {
        Intent intent = new Intent(context, BRTakePhotoGuideAct.class);
        intent.putExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, i);
        context.startActivity(intent);
    }

    public static class ResInfo {
        /* access modifiers changed from: private */
        public final int imageRes;
        /* access modifiers changed from: private */
        public final int stringArray;

        ResInfo(int i, int i2) {
            this.imageRes = i;
            this.stringArray = i2;
        }
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f49703h.put(1, new ResInfo(R.drawable.br_df_appeal_driver_license_g1, R.array.df_appeal_driver_license_g1));
        this.f49703h.put(2, new ResInfo(R.drawable.df_appeal_driver_license_g2_qr, R.array.df_appeal_driver_license_g2_qr));
        this.f49703h.put(3, new ResInfo(R.drawable.df_appeal_doc_rg, R.array.df_appeal_doc_type_RG));
        this.f49703h.put(4, new ResInfo(R.drawable.df_appeal_doc_cdr, R.array.df_appeal_doc_type_cdr));
        this.f49703h.put(5, new ResInfo(R.drawable.br_df_appeal_doc_cdt, R.array.df_appeal_doc_type_cdt));
        this.f49703h.put(6, new ResInfo(R.drawable.br_df_appeal_doc_passport, R.array.df_appeal_doc_type_passport));
        this.f49703h.put(7, new ResInfo(R.drawable.br_df_appeal_self_photo, R.array.df_appeal_self_photo));
        this.f49702g = intent.getIntExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, 0);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        boolean isValidType = TakePhotoInfo.isValidType(this.f49702g);
        CheckUtils.checkAssert(isValidType, "invalid photoType, mPhotoType=" + this.f49702g);
        if (!isValidType) {
            finish();
            return;
        }
        this.f49696a = (ImageView) findViewById(R.id.photo_demo);
        this.f49697b = (TextView) findViewById(R.id.photo_req0);
        this.f49698c = (TextView) findViewById(R.id.photo_req1);
        this.f49699d = (TextView) findViewById(R.id.photo_req2);
        this.f49700e = (TextView) findViewById(R.id.photo_req3);
        Button button = (Button) findViewById(R.id.take_photo_btn);
        this.f49701f = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoGuideAct bRTakePhotoGuideAct = BRTakePhotoGuideAct.this;
                BRTakePhotoAct.start(bRTakePhotoGuideAct, bRTakePhotoGuideAct.f49702g);
            }
        });
        m37197a(this.f49703h.get(this.f49702g));
    }

    /* renamed from: a */
    private void m37197a(ResInfo resInfo) {
        this.f49696a.setImageResource(resInfo.imageRes);
        String[] stringArray = getResources().getStringArray(resInfo.stringArray);
        TextView[] textViewArr = {this.f49697b, this.f49698c, this.f49699d, this.f49700e};
        for (int i = 0; i < stringArray.length; i++) {
            String str = stringArray[i];
            if (!TextUtils.isEmpty(str)) {
                textViewArr[i].setVisibility(0);
                textViewArr[i].setText(str);
            } else {
                textViewArr[i].setVisibility(8);
            }
        }
    }

    @Subscribe
    public void onTakePhotoDoneEvent(TakePhotoDoneEvent takePhotoDoneEvent) {
        if (!TakePhotoInfo.FILE_DOC_RG_FRONT.equals(takePhotoDoneEvent.photo)) {
            finish();
        }
    }
}
