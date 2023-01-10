package com.didiglobal.eevee.mew;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didiglobal.common.common.model.EeveeRichText;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.didiglobal.common.common.util.EeveeRichTextUtil;
import com.didiglobal.mew.framework.MUIUtils;
import com.didiglobal.mew.framework.widget.p201ff.MFFCardProperty;
import com.didiglobal.mew.framework.widget.p201ff.MFallsFlow;
import com.didiglobal.mew.framework.widget.p202vp.MVPCardProperty;
import com.didiglobal.mew.framework.widget.p202vp.MViewPager;
import com.taxis99.R;
import java.util.List;

public class EMewView implements EeveeIView<C17606a> {

    /* renamed from: a */
    private View f52639a;

    /* renamed from: b */
    private C17606a f52640b;

    /* renamed from: c */
    private MFallsFlow f52641c;

    /* renamed from: d */
    private MViewPager f52642d;

    /* renamed from: e */
    private Context f52643e;

    public EMewView(Context context) {
        this.f52643e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_mew_comp, (ViewGroup) null);
        this.f52639a = inflate;
        this.f52641c = (MFallsFlow) inflate.findViewById(R.id.mew_mff);
        MViewPager mViewPager = new MViewPager(context);
        this.f52642d = mViewPager;
        this.f52641c.initHeaderView(mViewPager);
        this.f52641c.setVisibility(true);
    }

    public View getView() {
        return this.f52639a;
    }

    public void setPresenter(C17606a aVar) {
        this.f52640b = aVar;
        aVar.setIView(this);
    }

    public void setViewPagerTitle(EeveeRichText eeveeRichText, int i) {
        TextView textView = new TextView(this.f52643e);
        if (eeveeRichText != null) {
            EeveeRichTextUtil.setText(textView, eeveeRichText);
        }
        textView.setTextSize(20.0f);
        textView.setTextColor(-16777216);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setLayoutParams(layoutParams);
        this.f52642d.setViewPagerExtView(textView, MUIUtils.getStatusBarHeight(this.f52643e) + MUIUtils.dip2pxInt(this.f52643e, 20.0f));
    }

    public void pagerSetData(List<MVPCardProperty> list) {
        this.f52642d.setData(list);
    }

    public void flowSetData(List<MFFCardProperty> list) {
        this.f52641c.setData(list);
    }

    public void setOverlapSpace(int i) {
        this.f52641c.setOverlapSpace(i);
    }

    public void setListViewElevation(int i, int i2) {
        this.f52641c.setListViewElevation(i, i2);
    }

    public void setAlignOrientation(int i) {
        if (i == 1) {
            this.f52641c.setAlignBottom(true);
        } else {
            this.f52641c.setAlignBottom(false);
        }
    }

    public void setMarginBottom(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52641c.getLayoutParams();
        layoutParams.bottomMargin = i;
        this.f52641c.setLayoutParams(layoutParams);
    }
}
