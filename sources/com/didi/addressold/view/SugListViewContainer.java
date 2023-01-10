package com.didi.addressold.view;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.didi.address.view.IPoiChangeListener;
import com.didi.address.view.ISugViewController;
import com.didi.addressold.util.ViewUtils;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.model.Padding;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

public class SugListViewContainer extends FrameLayout implements ISugViewController {

    /* renamed from: a */
    float f9766a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ISugMapCtrlCallback f9767b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ISugContainerOpCallback f9768c;

    /* renamed from: d */
    private IPoiChangeListener f9769d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ArrayList<IPoiChangeListener> f9770e;

    /* renamed from: f */
    private Scroller f9771f;

    /* renamed from: g */
    private LinearLayout f9772g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SugListView f9773h;

    /* renamed from: i */
    private CommonAddressView f9774i;

    /* renamed from: j */
    private ViewGroup f9775j;

    /* renamed from: k */
    private ViewGroup f9776k;

    /* renamed from: l */
    private ViewGroup f9777l;

    /* renamed from: m */
    private ViewGroup f9778m;
    public boolean mIsMapDragged;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public TextView f9779n;

    /* renamed from: o */
    private ImageView f9780o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f9781p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f9782q;

    /* renamed from: r */
    private boolean f9783r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public View.OnClickListener f9784s;

    /* renamed from: t */
    private boolean f9785t;

    /* renamed from: u */
    private boolean f9786u;

    /* renamed from: v */
    private int f9787v;

    /* renamed from: w */
    private boolean f9788w;

    public int getScrollTime() {
        return 650;
    }

    public void onMapTouch() {
    }

    public SugListViewContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public SugListViewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SugListViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8506a();
    }

    public ListView getListView() {
        return this.f9773h;
    }

    /* renamed from: a */
    private void m8506a() {
        LayoutInflater.from(getContext()).inflate(R.layout.old_layout_list_view, this);
        this.f9771f = new Scroller(getContext());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lv_root);
        this.f9772g = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        SugListView sugListView = (SugListView) findViewById(R.id.lv);
        this.f9773h = sugListView;
        sugListView.setHeaderDividersEnabled(false);
        this.f9773h.setDivider((Drawable) null);
        this.f9773h.setDividerHeight(0);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_address_list_header_view, this.f9773h, false);
        this.f9774i = (CommonAddressView) viewGroup.findViewById(R.id.common_address_view);
        this.f9773h.addHeaderView(viewGroup);
        this.f9775j = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_tips_info_header_view, this.f9773h, false);
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_address_select_poi_view, this.f9773h, false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.select_poi_layout);
        this.f9776k = viewGroup3;
        viewGroup3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SugListViewContainer.this.f9768c != null) {
                    SugListViewContainer.this.f9768c.hideInputWindow();
                }
                if (SugListViewContainer.this.f9784s != null) {
                    SugListViewContainer.this.f9784s.onClick(view);
                }
                SugListViewContainer.this.scrollToBottom();
                if (SugListViewContainer.this.f9773h.getAdapter() != null && SugListViewContainer.this.f9773h.getAdapter().getCount() > 0) {
                    SugListViewContainer.this.f9773h.smoothScrollToPosition(0);
                }
            }
        });
        this.f9773h.addFooterView(viewGroup2);
        this.f9777l = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_address_power_by_google_view, this.f9773h, false);
        this.f9773h.setAdapter(new ArrayAdapter(getContext(), 17367043, new String[0]));
        m8510b();
        m8514d();
    }

    /* renamed from: b */
    private void m8510b() {
        this.f9778m = (ViewGroup) findViewById(R.id.layout_map_ctrl);
        this.f9779n = (TextView) findViewById(R.id.tv_confirm);
        ImageView imageView = (ImageView) findViewById(R.id.iv_reset_map);
        this.f9780o = imageView;
        imageView.setContentDescription(getResources().getString(R.string.global_sug_contentdiscription_reset_click));
        this.f9780o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SugListViewContainer.this.f9767b != null) {
                    SugListViewContainer.this.f9767b.onResetBtnClick();
                    if (view != null) {
                        view.setVisibility(8);
                    }
                }
            }
        });
        m8512c();
        this.f9779n.post(new Runnable() {
            public void run() {
                SugListViewContainer sugListViewContainer = SugListViewContainer.this;
                int unused = sugListViewContainer.f9782q = sugListViewContainer.f9779n.getMeasuredHeight() + ((RelativeLayout.LayoutParams) SugListViewContainer.this.f9779n.getLayoutParams()).topMargin + ((RelativeLayout.LayoutParams) SugListViewContainer.this.f9779n.getLayoutParams()).bottomMargin;
                SystemUtils.log(3, "xu", "mMapTopPadding:" + SugListViewContainer.this.f9781p + ", mMapBottomPadding:" + SugListViewContainer.this.f9782q, (Throwable) null, "com.didi.addressold.view.SugListViewContainer$4", 199);
            }
        });
    }

    /* renamed from: c */
    private void m8512c() {
        if (this.f9779n != null) {
            try {
                if (DidiThemeManager.getIns().getResPicker(getContext()) == null) {
                    SystemUtils.log(3, "sfs", "SugListViewContainer initConfirmButton() DidiThemeManager.getIns().getResPicker(getContext()) == null", (Throwable) null, "com.didi.addressold.view.SugListViewContainer", 208);
                    DidiThemeManager.getIns().init((Application) getContext().getApplicationContext());
                }
                this.f9779n.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(this.f9779n.getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
                this.f9779n.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_selector));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private void m8514d() {
        this.f9770e = new ArrayList<>();
        this.f9769d = new IPoiChangeListener() {
            public void onPinLoading(double d, double d2) {
                Iterator it = SugListViewContainer.this.f9770e.iterator();
                while (it.hasNext()) {
                    ((IPoiChangeListener) it.next()).onPinLoading(d, d2);
                }
            }

            public void onPinPoiChanged(Address address) {
                Iterator it = SugListViewContainer.this.f9770e.iterator();
                while (it.hasNext()) {
                    IPoiChangeListener iPoiChangeListener = (IPoiChangeListener) it.next();
                    String string = SugListViewContainer.this.getResources().getString(R.string.global_sug_current_location);
                    if (TextUtils.isEmpty(address.displayName) || address.displayName.equals(string)) {
                        address.displayName = string;
                        address.address = string;
                        address.fullName = string;
                    }
                    iPoiChangeListener.onPinPoiChanged(address);
                }
            }

            public void onPinFetchPoiFailed(Address address) {
                Iterator it = SugListViewContainer.this.f9770e.iterator();
                while (it.hasNext()) {
                    ((IPoiChangeListener) it.next()).onPinFetchPoiFailed(address);
                }
            }
        };
    }

    public void setDragEnable(boolean z) {
        this.f9783r = z;
    }

    public void setConfirmBtnClickListener(View.OnClickListener onClickListener) {
        this.f9779n.setOnClickListener(onClickListener);
    }

    public void setConfirmBtnEnabled(boolean z) {
        this.f9779n.setEnabled(z);
    }

    public void addPoiListener(IPoiChangeListener iPoiChangeListener) {
        if (iPoiChangeListener != null) {
            synchronized (this.f9770e) {
                if (!this.f9770e.contains(iPoiChangeListener)) {
                    this.f9770e.add(iPoiChangeListener);
                }
            }
        }
    }

    public void removePoiListener(IPoiChangeListener iPoiChangeListener) {
        synchronized (this.f9770e) {
            this.f9770e.remove(iPoiChangeListener);
        }
    }

    public void setOperCallback(ISugMapCtrlCallback iSugMapCtrlCallback) {
        this.f9767b = iSugMapCtrlCallback;
    }

    public void setSugContainerOpCallback(ISugContainerOpCallback iSugContainerOpCallback) {
        this.f9768c = iSugContainerOpCallback;
    }

    public void onMapScroll() {
        if (this.f9772g.getVisibility() != 4) {
            this.f9772g.setVisibility(4);
            this.f9771f.forceFinished(true);
            if (getScrollY() != 0) {
                scrollTo(0, 0);
            }
            this.mIsMapDragged = true;
            if (!isMapCtrlState()) {
                this.f9778m.setVisibility(0);
            }
        }
        this.f9780o.setVisibility(0);
    }

    public IPoiChangeListener getPoiChangeListener() {
        return this.f9769d;
    }

    public Address getTargetAddress() {
        ISugContainerOpCallback iSugContainerOpCallback = this.f9768c;
        if (iSugContainerOpCallback == null) {
            return null;
        }
        return iSugContainerOpCallback.getTargetAddress();
    }

    public boolean isMapCtrlState() {
        return this.f9778m.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    public int getScrollerCurrY() {
        Scroller scroller = this.f9771f;
        if (scroller != null) {
            return scroller.getCurrY();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8507a(int i, int i2) {
        ISugContainerOpCallback iSugContainerOpCallback;
        if (!this.f9785t) {
            this.f9778m.setVisibility(4);
            this.f9772g.setVisibility(0);
            int scrollY = getScrollY();
            this.f9771f.startScroll(0, scrollY, 0, i - scrollY, i2);
            if (i == 0) {
                ISugContainerOpCallback iSugContainerOpCallback2 = this.f9768c;
                if (iSugContainerOpCallback2 != null) {
                    iSugContainerOpCallback2.onScrollToTop();
                }
            } else if (i == getScrollYMax() && (iSugContainerOpCallback = this.f9768c) != null) {
                iSugContainerOpCallback.onScrollToBottom();
            }
            invalidate();
        }
    }

    public void scrollToTop() {
        post(new Runnable() {
            public void run() {
                if (SugListViewContainer.this.getScrollerCurrY() != 0) {
                    SugListViewContainer sugListViewContainer = SugListViewContainer.this;
                    sugListViewContainer.m8507a(0, sugListViewContainer.getScrollTime());
                }
            }
        });
    }

    public void scrollToBottom() {
        post(new Runnable() {
            public void run() {
                if (SugListViewContainer.this.getScrollerCurrY() != SugListViewContainer.this.getScrollYMax()) {
                    SugListViewContainer sugListViewContainer = SugListViewContainer.this;
                    sugListViewContainer.m8507a(sugListViewContainer.getScrollYMax(), SugListViewContainer.this.getScrollTime());
                }
            }
        });
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f9771f.computeScrollOffset()) {
            scrollTo(this.f9771f.getCurrX(), this.f9771f.getCurrY());
            invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f9783r) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            float rawY = motionEvent.getRawY();
            this.f9766a = rawY;
            if (rawY < ((float) (getTop() - getScrollY()))) {
                this.f9786u = true;
            } else {
                this.f9786u = false;
            }
        } else if (actionMasked == 2) {
            float rawY2 = motionEvent.getRawY() - this.f9766a;
            if (this.f9773h.isScrollToTop() && rawY2 > 0.0f) {
                return true;
            }
            if (getScrollY() < 0 && rawY2 < ((float) (-ViewUtils.dip2px(getContext(), 7.0f)))) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f9783r || isMapCtrlState()) {
            return super.onTouchEvent(motionEvent);
        }
        int rawY = (int) motionEvent.getRawY();
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (rawY < rect.top + Math.abs(getScrollY())) {
            return super.onTouchEvent(motionEvent);
        }
        if (rawY < getTop() - getScrollY() && this.f9786u) {
            return super.onTouchEvent(motionEvent);
        }
        if (getScrollY() <= (-getScrollYMax()) * -1 && rawY - this.f9787v > 0) {
            this.f9787v = rawY;
            if (getScrollY() < (-getScrollYMax()) * -1) {
                scrollTo(0, (-getScrollYMax()) * -1);
            }
            return super.onTouchEvent(motionEvent);
        } else if (getScrollY() < 0 || rawY - this.f9787v >= 0) {
            int action = motionEvent.getAction();
            if (action == 1) {
                if (getScrollY() >= 0 || getScrollY() <= getScrollYMax()) {
                    m8507a(0, 0);
                } else if (getScrollY() < getScrollYMax() / 2) {
                    m8507a(getScrollYMax(), getScrollTime());
                } else {
                    m8507a(0, getScrollTime());
                }
                rawY = 0;
            } else if (action == 2) {
                ViewUtils.hideInputWindow(getContext(), this);
                if (this.f9787v == 0) {
                    this.f9787v = rawY;
                }
                scrollBy(0, -(rawY - this.f9787v));
            }
            this.f9787v = rawY;
            return true;
        } else {
            this.f9787v = rawY;
            if (getScrollY() > 0) {
                scrollTo(0, 0);
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ISugContainerOpCallback iSugContainerOpCallback = this.f9768c;
        if (iSugContainerOpCallback != null) {
            iSugContainerOpCallback.onSugContainerScrollChanged(i, i2, i3, i4);
        }
        if (this.f9767b != null) {
            if (this.f9772g.getVisibility() != 0) {
                this.f9767b.onDeparturePinShow(true, new Padding(0, this.f9781p, 0, this.f9782q));
            } else if (i2 == 0) {
                this.f9767b.onDeparturePinShow(false, (Padding) null);
            } else {
                this.f9767b.onDeparturePinShow(true, new Padding(0, this.f9781p, 0, this.f9782q));
            }
        }
        if (i2 < 0 && !this.f9788w) {
            this.f9788w = true;
            this.f9773h.setBackgroundDrawable(getResources().getDrawable(R.drawable.old_poi_one_address_listview_bg));
        } else if (i2 >= 0 && this.f9788w) {
            this.f9788w = false;
            this.f9773h.setBackgroundColor(-1);
        }
    }

    public int getScrollYMax() {
        int i;
        CommonAddressView commonAddressView = this.f9774i;
        if (commonAddressView == null || commonAddressView.getVisibility() != 0) {
            i = ViewUtils.dip2px(getContext(), 140.0f);
        } else {
            i = this.f9774i.getMeasuredHeight() + ((RelativeLayout.LayoutParams) this.f9774i.getLayoutParams()).topMargin;
        }
        return Math.min(0, (-getMeasuredHeight()) + i);
    }

    public void setTopPadding(int i) {
        this.f9781p = i;
        SystemUtils.log(3, "xu", "mMapTopPadding:" + this.f9781p + ", mMapBottomPadding:" + this.f9782q, (Throwable) null, "com.didi.addressold.view.SugListViewContainer", 564);
    }

    public void showCommonAddressHeaderView(boolean z) {
        this.f9774i.setVisibility(z ? 0 : 8);
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f9773h.removeHeaderView(this.f9775j);
        if (tipsInfo != null && !TextUtils.isEmpty(tipsInfo.content)) {
            this.f9773h.addHeaderView(this.f9775j);
            TextView textView = (TextView) this.f9775j.findViewById(R.id.tips_info_view);
            textView.setText(tipsInfo.content);
            if (!TextUtils.isEmpty(tipsInfo.content_color)) {
                textView.setTextColor(Color.parseColor(tipsInfo.content_color));
            }
            if (!TextUtils.isEmpty(tipsInfo.background_color)) {
                ((RelativeLayout) this.f9775j.findViewById(R.id.tips_info_layout)).setBackgroundColor(Color.parseColor(tipsInfo.background_color));
            }
        }
    }

    public void showSelectPoiFooterView(boolean z) {
        this.f9776k.setVisibility(z ? 0 : 8);
    }

    public void setOnSelectPoiFooterViewClickListener(View.OnClickListener onClickListener) {
        this.f9784s = onClickListener;
    }

    public void onlyShowSelectPoiFooterView() {
        this.f9773h.setVisibility(0);
        this.f9773h.setAdapter(new ArrayAdapter(getContext(), 17367043, new String[0]));
        this.f9776k.setVisibility(0);
        this.f9773h.removeFooterView(this.f9777l);
    }

    public void updateLogoView(boolean z, String str, int i, int i2) {
        this.f9773h.removeFooterView(this.f9777l);
        if (z && !TextUtils.isEmpty(str) && i > 0 && i2 > 0) {
            ImageView imageView = (ImageView) this.f9777l.findViewById(R.id.powered_by_img);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (ViewUtils.isBigScreen(getContext())) {
                layoutParams.width = i * 3;
                layoutParams.height = i2 * 3;
            } else {
                layoutParams.width = i;
                layoutParams.height = i2;
            }
            imageView.setLayoutParams(layoutParams);
            Glide.with(getContext().getApplicationContext()).load(str).into(imageView);
            this.f9773h.addFooterView(this.f9777l, (Object) null, false);
        }
    }

    public void setHomeAddress(Address address) {
        this.f9774i.setHome(address);
    }

    public Address getHomeAddress() {
        return this.f9774i.getHomeAddress();
    }

    public void setCompanyAddress(Address address) {
        this.f9774i.setCompany(address);
    }

    public Address getCompanyAddress() {
        return this.f9774i.getCompanyAddress();
    }

    public void setCommonAddressViewClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.f9774i.setHomeClickListener(onClickListener);
        this.f9774i.setCompanyClickListener(onClickListener2);
        this.f9774i.setCommonAddressClickListener(onClickListener3);
    }

    public void onDestory() {
        this.f9785t = true;
    }
}
