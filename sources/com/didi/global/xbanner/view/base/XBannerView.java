package com.didi.global.xbanner.view.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.xbanner.basemodel.XBCardView;
import com.didi.global.xbanner.basemodel.XBCardViewData;
import com.didi.global.xbanner.utils.DisplayUtils;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.global.xbanner.view.recycler.XBannerItemBean;
import com.didi.global.xbanner.view.recycler.XBannerOnScrollListener;
import com.didi.global.xbanner.view.recycler.XBannerPagerSnapHelper;
import com.didi.global.xbanner.view.recycler.XBannerRecyclerAdapter;
import com.didi.global.xbanner.view.recycler.XBannerScrollChangedListener;
import com.didi.global.xbanner.view.recycler.XbCardReloadListener;
import com.taxis99.R;
import java.util.List;

public class XBannerView extends RelativeLayout implements XbCardReloadListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RecyclerView f24862a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CardView f24863b;

    /* renamed from: c */
    private ImageView f24864c;

    /* renamed from: d */
    private XBannerRecyclerAdapter f24865d;

    /* renamed from: e */
    private Activity f24866e;

    /* renamed from: f */
    private XBannerInterceptFrame f24867f;

    /* renamed from: g */
    private XBannerOnScrollListener f24868g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f24869h = false;

    /* renamed from: i */
    private ExpandViewCallback f24870i;

    public XBannerView(Context context) {
        super(context);
        init(context);
    }

    public XBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public XBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.xbanner_view, this);
        this.f24862a = (RecyclerView) findViewById(R.id.xb_recycler_view);
        this.f24863b = (CardView) findViewById(R.id.xb_expand_view);
        this.f24862a.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f24862a.setOnFlingListener((RecyclerView.OnFlingListener) null);
        new XBannerPagerSnapHelper().attachToRecyclerView(this.f24862a);
        XBannerOnScrollListener xBannerOnScrollListener = new XBannerOnScrollListener();
        this.f24868g = xBannerOnScrollListener;
        this.f24862a.addOnScrollListener(xBannerOnScrollListener);
        this.f24864c = (ImageView) findViewById(R.id.shrink_icon);
    }

    public void setScrollChangedListener(XBannerScrollChangedListener xBannerScrollChangedListener) {
        this.f24868g.setScrollChangedListener(xBannerScrollChangedListener);
    }

    public void setXBannerExpandView(XBCardView xBCardView, XBCardViewData xBCardViewData, ExpandViewCallback expandViewCallback) {
        if (xBCardViewData != null) {
            View createView = xBCardView.createView(getContext(), xBCardViewData, XBannerUtil.getFullItemWidthWithoutMargin(getContext()));
            this.f24870i = expandViewCallback;
            if (createView != null) {
                m19948a(createView);
            } else {
                xBCardView.setReloadListener(this);
            }
        }
    }

    /* renamed from: a */
    private void m19948a(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f24863b.getLayoutParams();
        marginLayoutParams.width = XBannerUtil.getFullItemWidthWithoutMargin(view.getContext());
        marginLayoutParams.height = XBannerUtil.getUnfoldDefaultItemHeight(view.getContext());
        marginLayoutParams.leftMargin = (DisplayUtils.getScreenWidth(view.getContext()) - XBannerUtil.getFullItemWidthWithoutMargin(view.getContext())) / 2;
        marginLayoutParams.rightMargin = (DisplayUtils.getScreenWidth(view.getContext()) - XBannerUtil.getFullItemWidthWithoutMargin(view.getContext())) / 2;
        this.f24863b.setLayoutParams(marginLayoutParams);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setExpandVisibility(true);
        if (this.f24863b.getChildCount() > 1) {
            this.f24863b.removeViewAt(0);
        }
        this.f24863b.addView(view, 0);
        ExpandViewCallback expandViewCallback = this.f24870i;
        if (expandViewCallback != null) {
            expandViewCallback.onExpandViewShow();
        }
        this.f24864c.setVisibility(0);
        if (this.f24866e != null && m19951b() && this.f24867f == null) {
            XBannerInterceptFrame xBannerInterceptFrame = new XBannerInterceptFrame(getContext());
            this.f24867f = xBannerInterceptFrame;
            xBannerInterceptFrame.setNotInterceptArea(this.f24863b);
            this.f24867f.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f24867f.setInterceptListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XBannerView.this.expandViewDismiss();
                }
            });
            ((ViewGroup) this.f24866e.getWindow().getDecorView()).addView(this.f24867f);
            this.f24867f.setVisibility(0);
            this.f24864c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XBannerView.this.expandViewDismiss();
                }
            });
        }
    }

    public void expandViewDismiss() {
        XBannerInterceptFrame xBannerInterceptFrame = this.f24867f;
        if (xBannerInterceptFrame != null && xBannerInterceptFrame.getVisibility() == 0) {
            this.f24867f.setVisibility(8);
            ((ViewGroup) this.f24866e.getWindow().getDecorView()).removeView(this.f24867f);
        }
        if (this.f24863b != null) {
            setExpandVisibility(false);
        }
        ExpandViewCallback expandViewCallback = this.f24870i;
        if (expandViewCallback != null) {
            expandViewCallback.onExpandViewDismiss();
        }
    }

    private void setExpandVisibility(boolean z) {
        if (z) {
            this.f24863b.setVisibility(0);
            this.f24862a.setVisibility(8);
            return;
        }
        m19947a();
    }

    public RecyclerView getRecyclerView() {
        return this.f24862a;
    }

    public void scrollToEnd() {
        RecyclerView recyclerView = this.f24862a;
        recyclerView.scrollToPosition(recyclerView.getChildCount() - 1);
    }

    public void scrollToStart() {
        this.f24862a.scrollToPosition(0);
    }

    /* renamed from: a */
    private void m19947a() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f24863b, "ScaleY", new float[]{1.0f, 0.5f});
        this.f24863b.setPivotX(0.0f);
        this.f24863b.setPivotY((float) XBannerUtil.getUnfoldDefaultItemHeight(getContext()));
        this.f24862a.setVisibility(0);
        this.f24862a.setAlpha(0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f24862a, "alpha", new float[]{0.0f, 1.0f});
        ofFloat2.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = XBannerView.this.f24869h = false;
            }

            public void onAnimationEnd(Animator animator) {
                XBannerView.this.f24862a.setAlpha(1.0f);
            }
        });
        if ((this.f24862a.getAdapter() == null ? 0 : this.f24862a.getAdapter().getItemCount()) > 1) {
            animatorSet.playTogether(new Animator[]{ofFloat, ObjectAnimator.ofFloat(this.f24863b, "ScaleX", new float[]{1.0f, ((float) XBannerUtil.getItemWidth(getContext())) / ((float) XBannerUtil.getFullItemWidthWithoutMargin(getContext()))}), ofFloat2});
        } else {
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f24863b, "alpha", new float[]{1.0f, 0.0f});
        ofFloat3.setDuration(100);
        ofFloat3.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                XBannerView.this.f24863b.setVisibility(8);
                boolean unused = XBannerView.this.f24869h = true;
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(new Animator[]{animatorSet, ofFloat3});
        animatorSet2.start();
    }

    public List<XBannerItemBean> getData() {
        return this.f24865d.getData();
    }

    public void setAttachedActivity(Activity activity) {
        this.f24866e = activity;
    }

    /* renamed from: b */
    private boolean m19951b() {
        CardView cardView = this.f24863b;
        if (cardView == null || cardView.getChildCount() == 0 || this.f24863b.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void setData(Context context, List<XBannerItemBean> list) {
        XBannerRecyclerAdapter xBannerRecyclerAdapter = this.f24865d;
        if (xBannerRecyclerAdapter == null) {
            XBannerRecyclerAdapter xBannerRecyclerAdapter2 = new XBannerRecyclerAdapter(list, context);
            this.f24865d = xBannerRecyclerAdapter2;
            this.f24862a.setAdapter(xBannerRecyclerAdapter2);
            return;
        }
        xBannerRecyclerAdapter.setData(list);
    }

    public void addData(Context context, List<XBannerItemBean> list) {
        XBannerRecyclerAdapter xBannerRecyclerAdapter = this.f24865d;
        if (xBannerRecyclerAdapter == null) {
            XBannerRecyclerAdapter xBannerRecyclerAdapter2 = new XBannerRecyclerAdapter(list, context);
            this.f24865d = xBannerRecyclerAdapter2;
            this.f24862a.setAdapter(xBannerRecyclerAdapter2);
            return;
        }
        xBannerRecyclerAdapter.addData(list);
    }

    public void removeItem(int i) {
        XBannerRecyclerAdapter xBannerRecyclerAdapter = this.f24865d;
        if (xBannerRecyclerAdapter != null) {
            xBannerRecyclerAdapter.removeItem(i);
        }
    }

    public void removeItemByCardId(String str) {
        XBannerRecyclerAdapter xBannerRecyclerAdapter = this.f24865d;
        if (xBannerRecyclerAdapter != null) {
            xBannerRecyclerAdapter.removeItemByCardId(str);
        }
    }

    public void onViewReload(View view) {
        if (this.f24870i != null) {
            m19948a(view);
        }
    }
}
