package com.didi.component.expectation.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.expectation.model.FlexRaiseSheet;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class FlexRaiseDialogView extends SimplePopupBase {

    /* renamed from: c */
    private static final String f15542c = "felx_raise_data";

    /* renamed from: a */
    private FlexRaiseSheetView f15543a;

    /* renamed from: b */
    private ImageView f15544b;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_flex_raise_dialog_layout;
    }

    public static FlexRaiseDialogView newInstance(FlexRaiseSheet flexRaiseSheet) {
        FlexRaiseDialogView flexRaiseDialogView = new FlexRaiseDialogView();
        Bundle bundle = new Bundle();
        if (flexRaiseSheet != null) {
            bundle.putSerializable(f15542c, flexRaiseSheet);
        }
        flexRaiseDialogView.setArguments(bundle);
        return flexRaiseDialogView;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f15543a = (FlexRaiseSheetView) this.mRootView.findViewById(R.id.flex_bargain_card_layout);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.flex_close_img);
        this.f15544b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FlexRaiseDialogView.this.dismiss();
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getSerializable(f15542c) != null) {
            setData((FlexRaiseSheet) arguments.getSerializable(f15542c));
        }
    }

    public void setData(FlexRaiseSheet flexRaiseSheet) {
        FlexRaiseSheetView flexRaiseSheetView = this.f15543a;
        if (flexRaiseSheetView != null) {
            flexRaiseSheetView.setData(flexRaiseSheet);
            this.f15543a.setSimplePopupBase(this);
        }
    }
}
