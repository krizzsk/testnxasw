package com.didiglobal.mew.framework.widget.p202vp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didiglobal.mew.framework.widget.vp.MViewPager */
public class MViewPager extends RelativeLayout {

    /* renamed from: a */
    private ViewPager2 f52792a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewPager2.OnPageChangeCallback f52793b;

    /* renamed from: c */
    private RelativeLayout f52794c;

    /* renamed from: d */
    private MVpAdapter f52795d;

    /* renamed from: e */
    private ViewPager2.OnPageChangeCallback f52796e = new ViewPager2.OnPageChangeCallback() {
        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
            if (MViewPager.this.f52793b != null) {
                MViewPager.this.f52793b.onPageScrollStateChanged(i);
            }
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            if (MViewPager.this.f52793b != null) {
                MViewPager.this.f52793b.onPageSelected(i);
            }
        }
    };

    public MViewPager(Context context) {
        super(context);
        m39627a(context, (AttributeSet) null, 0);
    }

    public MViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39627a(context, attributeSet, 0);
    }

    public MViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39627a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m39627a(Context context, AttributeSet attributeSet, int i) {
        View.inflate(context, R.layout.mew_widget_vp, this);
        this.f52794c = (RelativeLayout) findViewById(R.id.mew_vp_ext);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.mew_vp);
        this.f52792a = viewPager2;
        viewPager2.setOrientation(0);
        this.f52792a.registerOnPageChangeCallback(this.f52796e);
        MVpAdapter mVpAdapter = new MVpAdapter();
        this.f52795d = mVpAdapter;
        this.f52792a.setAdapter(mVpAdapter);
    }

    public void clear() {
        this.f52795d.clear();
    }

    public void setData(List<MVPCardProperty> list) {
        this.f52795d.setCardPropertyList(list);
    }

    public void addData(List<MVPCardProperty> list) {
        this.f52795d.addCardPropertyList(list);
    }

    public void addData(int i, MVPCardProperty mVPCardProperty) {
        this.f52795d.addCardProperty(i, mVPCardProperty);
    }

    public void setPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f52793b = onPageChangeCallback;
    }

    public void setViewPagerExtView(View view, int i) {
        this.f52794c.removeAllViews();
        this.f52794c.addView(view);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52794c.getLayoutParams();
        layoutParams.topMargin = i;
        this.f52794c.setLayoutParams(layoutParams);
    }
}
