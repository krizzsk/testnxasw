package com.didiglobal.p205sa.biz.component.safeToolKit.view;

import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.view.SAJarvisShareFragment */
public class SAJarvisShareFragment extends SimplePopupBase {

    /* renamed from: a */
    private TextView f53623a;

    /* renamed from: b */
    private TextView f53624b;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.sa_jarvis_share_fragment;
    }

    public static SAJarvisShareFragment newInstance() {
        return new SAJarvisShareFragment();
    }

    /* access modifiers changed from: protected */
    public void initView() {
        if (this.mRootView != null) {
            this.f53623a = (TextView) this.mRootView.findViewById(R.id.drawer_title);
            this.f53624b = (TextView) this.mRootView.findViewById(R.id.drawer_btn_got_it);
            this.f53623a.setText(R.string.GRider_Global_Trip_share_czSq);
            this.f53624b.setText(R.string.global_new_guide_ok);
            this.f53624b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SAJarvisShareFragment.this.dismissAllowingStateLoss();
                }
            });
        }
    }
}
