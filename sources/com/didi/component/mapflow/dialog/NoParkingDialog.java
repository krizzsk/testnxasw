package com.didi.component.mapflow.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.AlertDialogBase;
import com.taxis99.R;

public class NoParkingDialog extends AlertDialogBase {

    /* renamed from: a */
    private View f16039a;

    /* renamed from: b */
    private TextView f16040b;

    /* renamed from: c */
    private TextView f16041c;

    /* renamed from: d */
    private CustomLottieAnimationView f16042d;

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.f16039a;
    }

    public void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_noparking_dialog, (ViewGroup) null);
        this.f16039a = inflate;
        this.f16040b = (TextView) inflate.findViewById(R.id.tv_global_noparking_content);
        this.f16041c = (TextView) this.f16039a.findViewById(R.id.tv_global_noparking_confirm);
        CustomLottieAnimationView customLottieAnimationView = (CustomLottieAnimationView) this.f16039a.findViewById(R.id.global_noparking_image);
        this.f16042d = customLottieAnimationView;
        customLottieAnimationView.setImageAssetsFolder("images");
        this.f16042d.setAnimation("no_park_dialog.json");
        this.f16041c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NoParkingDialog.this.dismiss();
            }
        });
    }
}
