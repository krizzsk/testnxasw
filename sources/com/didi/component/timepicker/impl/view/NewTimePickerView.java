package com.didi.component.timepicker.impl.view;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.widget.NewBubbleHelper;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import com.taxis99.R;
import java.util.Collection;

public class NewTimePickerView extends TimePickerView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public NewBubbleHelper f18014a;

    /* renamed from: b */
    private ImageView f18015b = ((ImageView) this.mRootView.findViewById(R.id.iv_timepicker_icon));

    /* renamed from: c */
    private boolean f18016c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LEGOBubble f18017d;

    public NewTimePickerView(Activity activity, ViewGroup viewGroup) {
        super(activity, viewGroup);
        if (this.f18016c) {
            this.mRootView.findViewById(R.id.divider).setVisibility(0);
        }
    }

    public int getLayoutId() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.mFormOperationModel == null || CollectionUtils.isEmpty((Collection) newEstimateItem.mFormOperationModel.items)) {
            this.f18016c = false;
            return R.layout.global_new_timepicker_entrance_layout_horizontal;
        }
        this.f18016c = true;
        return R.layout.global_new_timepicker_entrance_layout_vertical;
    }

    public void setIcon(String str) {
        if (!StringUtil.isNullOrEmpty(str) && this.f18015b != null) {
            Glide.with(this.mContext.getApplicationContext()).load(str).into(this.f18015b);
        }
    }

    public void showBookingGuideTips(BubbleItemModel bubbleItemModel) {
        LEGOBubble lEGOBubble = this.f18017d;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            this.f18017d.dismiss();
        }
        NewBubbleHelper newBubbleHelper = new NewBubbleHelper(this.mContext, bubbleItemModel);
        this.f18014a = newBubbleHelper;
        LEGOBubble.Builder builder = newBubbleHelper.getmBuilder();
        builder.setMaxLines(2);
        builder.setContentViewOnClick(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewTimePickerView.this.f18014a.saveBubbleShowCount(NewTimePickerView.this.mContext);
                NewTimePickerView.this.f18014a.trackEvent(false);
                NewTimePickerView.this.f18017d.dismiss();
            }
        });
        LEGOBubble build = builder.build();
        this.f18017d = build;
        if (!build.isShowing() && this.mRootView != null && this.mRootView.getRootView().isAttachedToWindow()) {
            this.f18014a.trackEvent(true);
            this.f18017d.show(this.mRootView, ResourcesHelper.getDimensionPixelSize(this.mContext, R.dimen.time_pick_bubble_xoff), (-this.mRootView.getMeasuredHeight()) - ResourcesHelper.getDimensionPixelSize(this.mContext, R.dimen.time_pick_bubble_yoff), 1999);
        }
    }

    public void dismissNewBubble() {
        LEGOBubble lEGOBubble = this.f18017d;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            this.f18017d.dismiss();
        }
    }

    public void setEnable(boolean z) {
        LEGOBubble lEGOBubble;
        this.mRootView.setVisibility(z ? 0 : 8);
        if (!z && (lEGOBubble = this.f18017d) != null && lEGOBubble.isShowing()) {
            this.f18017d.dismiss();
        }
    }
}
