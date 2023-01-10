package com.didichuxing.diface.appeal;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.diface.act.DFStyleBaseAct;
import com.didichuxing.diface.appeal.mexico.model.DocumentCardsBean;
import com.didichuxing.saimageloader.DiSafetyImageLoader;
import com.squareup.otto.Subscribe;
import com.taxis99.R;

public class TakePhotoGuideAct extends DFStyleBaseAct {

    /* renamed from: a */
    private ImageView f49656a;

    /* renamed from: b */
    private TextView f49657b;

    /* renamed from: c */
    private Button f49658c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DocumentCardsBean f49659d;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.act_df_take_photo_guide_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context, DocumentCardsBean documentCardsBean) {
        Intent intent = new Intent(context, TakePhotoGuideAct.class);
        intent.putExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, documentCardsBean);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f49659d = (DocumentCardsBean) intent.getSerializableExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        this.f49656a = (ImageView) findViewById(R.id.iv_demo_pic);
        this.f49657b = (TextView) findViewById(R.id.iv_content);
        DiSafetyImageLoader.with(this).load(this.f49659d.getDocPicDemo()).placeholder((int) R.drawable.df_guide_face_place_holder).into(this.f49656a);
        this.f49657b.setText(this.f49659d.getRequirement());
        Button button = (Button) findViewById(R.id.take_photo_btn);
        this.f49658c = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoGuideAct takePhotoGuideAct = TakePhotoGuideAct.this;
                TakePhotoAct.start(takePhotoGuideAct, takePhotoGuideAct.f49659d);
            }
        });
    }

    @Subscribe
    public void onTakePhotoDoneEvent(TakePhotoDoneEvent2 takePhotoDoneEvent2) {
        finish();
    }
}
