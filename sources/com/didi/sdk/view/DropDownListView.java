package com.didi.sdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C11267R;
import com.taxis99.R;

public class DropDownListView extends ListView implements AbsListView.OnScrollListener {
    public static final int HEADER_STATUS_CLICK_TO_LOAD = 1;
    public static final int HEADER_STATUS_DROP_DOWN_TO_LOAD = 2;
    public static final int HEADER_STATUS_LOADING = 4;
    public static final int HEADER_STATUS_RELEASE_TO_LOAD = 3;

    /* renamed from: A */
    private boolean f40503A = false;

    /* renamed from: B */
    private int f40504B;

    /* renamed from: C */
    private int f40505C;

    /* renamed from: D */
    private boolean f40506D = false;

    /* renamed from: E */
    private RotateAnimation f40507E;

    /* renamed from: F */
    private RotateAnimation f40508F;

    /* renamed from: G */
    private int f40509G;

    /* renamed from: H */
    private int f40510H;

    /* renamed from: I */
    private float f40511I;

    /* renamed from: J */
    private boolean f40512J = false;

    /* renamed from: a */
    private boolean f40513a = true;

    /* renamed from: b */
    private boolean f40514b = true;

    /* renamed from: c */
    private boolean f40515c = false;

    /* renamed from: d */
    private String f40516d;

    /* renamed from: e */
    private String f40517e;

    /* renamed from: f */
    private String f40518f;

    /* renamed from: g */
    private String f40519g;

    /* renamed from: h */
    private String f40520h;

    /* renamed from: i */
    private String f40521i;

    /* renamed from: j */
    private String f40522j;

    /* renamed from: k */
    private Context f40523k;

    /* renamed from: l */
    private RelativeLayout f40524l;

    /* renamed from: m */
    private ImageView f40525m;

    /* renamed from: n */
    private ProgressBar f40526n;

    /* renamed from: o */
    private TextView f40527o;

    /* renamed from: p */
    private TextView f40528p;

    /* renamed from: q */
    private RelativeLayout f40529q;

    /* renamed from: r */
    private ProgressBar f40530r;

    /* renamed from: s */
    private Button f40531s;

    /* renamed from: t */
    private OnDropDownListener f40532t;

    /* renamed from: u */
    private AbsListView.OnScrollListener f40533u;

    /* renamed from: v */
    private float f40534v = 1.5f;

    /* renamed from: w */
    private int f40535w;

    /* renamed from: x */
    private boolean f40536x = true;

    /* renamed from: y */
    private boolean f40537y = true;

    /* renamed from: z */
    private boolean f40538z = true;

    public interface OnDropDownListener {
        void onDropDown();
    }

    public DropDownListView(Context context) {
        super(context);
        m30438a(context);
    }

    public DropDownListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30439a(context, attributeSet);
        m30438a(context);
    }

    public DropDownListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30439a(context, attributeSet);
        m30438a(context);
    }

    /* renamed from: a */
    private void m30438a(Context context) {
        this.f40523k = context;
        m30437a();
        m30442b();
        super.setOnScrollListener(this);
    }

    /* renamed from: a */
    private void m30437a() {
        RelativeLayout relativeLayout = this.f40524l;
        if (relativeLayout != null) {
            if (this.f40513a) {
                addHeaderView(relativeLayout);
            } else {
                removeHeaderView(relativeLayout);
            }
        } else if (this.f40513a) {
            this.f40535w = this.f40523k.getResources().getDimensionPixelSize(R.dimen.drop_down_list_header_release_min_distance);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.f40507E = rotateAnimation;
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.f40507E.setDuration(250);
            this.f40507E.setFillAfter(true);
            RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.f40508F = rotateAnimation2;
            rotateAnimation2.setInterpolator(new LinearInterpolator());
            this.f40508F.setDuration(250);
            this.f40508F.setFillAfter(true);
            this.f40516d = this.f40523k.getString(R.string.drop_down_list_header_default_text);
            this.f40517e = this.f40523k.getString(R.string.drop_down_list_header_pull_text);
            this.f40518f = this.f40523k.getString(R.string.drop_down_list_header_release_text);
            this.f40519g = this.f40523k.getString(R.string.drop_down_list_header_loading_text);
            RelativeLayout relativeLayout2 = (RelativeLayout) ((LayoutInflater) this.f40523k.getSystemService("layout_inflater")).inflate(R.layout.v_drop_down_list_header, this, false);
            this.f40524l = relativeLayout2;
            this.f40527o = (TextView) relativeLayout2.findViewById(R.id.drop_down_list_header_default_text);
            this.f40525m = (ImageView) this.f40524l.findViewById(R.id.drop_down_list_header_image);
            this.f40526n = (ProgressBar) this.f40524l.findViewById(R.id.drop_down_list_header_progress_bar);
            this.f40528p = (TextView) this.f40524l.findViewById(R.id.drop_down_list_header_second_text);
            this.f40524l.setClickable(true);
            this.f40524l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DropDownListView.this.onDropDown();
                }
            });
            this.f40527o.setText(this.f40516d);
            addHeaderView(this.f40524l);
            m30441a((View) this.f40524l);
            this.f40509G = this.f40524l.getMeasuredHeight();
            this.f40510H = this.f40524l.getPaddingTop();
            this.f40505C = 1;
        }
    }

    /* renamed from: b */
    private void m30442b() {
        RelativeLayout relativeLayout = this.f40529q;
        if (relativeLayout != null) {
            if (this.f40514b) {
                addFooterView(relativeLayout);
            } else {
                removeFooterView(relativeLayout);
            }
        } else if (this.f40514b) {
            this.f40520h = this.f40523k.getString(R.string.drop_down_list_footer_default_text);
            this.f40521i = this.f40523k.getString(R.string.drop_down_list_footer_loading_text);
            this.f40522j = this.f40523k.getString(R.string.drop_down_list_footer_no_more_text);
            RelativeLayout relativeLayout2 = (RelativeLayout) ((LayoutInflater) this.f40523k.getSystemService("layout_inflater")).inflate(R.layout.v_drop_down_list_footer, this, false);
            this.f40529q = relativeLayout2;
            Button button = (Button) relativeLayout2.findViewById(R.id.drop_down_list_footer_button);
            this.f40531s = button;
            button.setDrawingCacheBackgroundColor(0);
            this.f40531s.setEnabled(true);
            this.f40530r = (ProgressBar) this.f40529q.findViewById(R.id.drop_down_list_footer_progress_bar);
            addFooterView(this.f40529q);
        }
    }

    public boolean isDropDownStyle() {
        return this.f40513a;
    }

    public void setDropDownStyle(boolean z) {
        if (this.f40513a != z) {
            this.f40513a = z;
            m30437a();
        }
    }

    public boolean isOnBottomStyle() {
        return this.f40514b;
    }

    public void setOnBottomStyle(boolean z) {
        if (this.f40514b != z) {
            this.f40514b = z;
            m30442b();
        }
    }

    public boolean isAutoLoadOnBottom() {
        return this.f40515c;
    }

    public void setAutoLoadOnBottom(boolean z) {
        this.f40515c = z;
    }

    public boolean isShowFooterProgressBar() {
        return this.f40537y;
    }

    public void setShowFooterProgressBar(boolean z) {
        this.f40537y = z;
    }

    public boolean isShowFooterButton() {
        return this.f40538z;
    }

    public void setIsShowFooterButton(boolean z) {
        this.f40538z = z;
    }

    public boolean isShowFooterWhenNoMore() {
        return this.f40503A;
    }

    public void setShowFooterWhenNoMore(boolean z) {
        this.f40503A = z;
    }

    public Button getFooterButton() {
        return this.f40531s;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (this.f40513a) {
            setSecondPositionVisible();
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f40533u = onScrollListener;
    }

    public void setOnDropDownListener(OnDropDownListener onDropDownListener) {
        this.f40532t = onDropDownListener;
    }

    public void setOnBottomListener(View.OnClickListener onClickListener) {
        if (this.f40514b) {
            this.f40531s.setOnClickListener(onClickListener);
            return;
        }
        throw new RuntimeException("isOnBottomStyle is false, cannot call setOnBottomListener, you can call setOnBottomStyle(true) at first.");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (!this.f40513a) {
            return super.onTouchEvent(motionEvent);
        }
        this.f40506D = false;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40511I = motionEvent.getY();
        } else if (action == 1) {
            if (!isVerticalScrollBarEnabled()) {
                setVerticalScrollBarEnabled(true);
            }
            if (getFirstVisiblePosition() == 0 && (i = this.f40505C) != 4) {
                if (i == 2) {
                    m30445e();
                    setSecondPositionVisible();
                } else if (i == 3) {
                    onDropDown();
                }
            }
        } else if (action == 2) {
            m30440a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f40513a) {
            if (this.f40504B != 1 || this.f40505C == 4) {
                if (this.f40504B == 2 && i == 0 && this.f40505C != 4) {
                    setSecondPositionVisible();
                    this.f40506D = true;
                } else if (this.f40504B == 2 && this.f40506D) {
                    setSecondPositionVisible();
                }
            } else if (i == 0) {
                this.f40525m.setVisibility(0);
                int i4 = this.f40509G + this.f40535w;
                if (this.f40524l.getBottom() >= i4) {
                    m30447g();
                } else if (this.f40524l.getBottom() < i4) {
                    m30446f();
                }
            } else {
                m30445e();
            }
        }
        if (this.f40514b && this.f40515c && this.f40536x && i > 0 && i3 > 0 && i + i2 == i3) {
            onBottom();
        }
        AbsListView.OnScrollListener onScrollListener = this.f40533u;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f40513a) {
            this.f40504B = i;
            if (i == 0) {
                this.f40506D = false;
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.f40533u;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    /* renamed from: c */
    private void m30443c() {
        if (this.f40513a) {
            m30448h();
        }
    }

    public void onDropDown() {
        if (this.f40505C != 4 && this.f40513a && this.f40532t != null) {
            m30443c();
            this.f40532t.onDropDown();
        }
    }

    public void onDropDownComplete(CharSequence charSequence) {
        if (this.f40513a) {
            setHeaderSecondText(charSequence);
            onDropDownComplete();
        }
    }

    public void setHeaderSecondText(CharSequence charSequence) {
        if (!this.f40513a) {
            return;
        }
        if (charSequence == null) {
            this.f40528p.setVisibility(8);
            return;
        }
        this.f40528p.setVisibility(0);
        this.f40528p.setText(charSequence);
    }

    public void onDropDownComplete() {
        if (this.f40513a) {
            m30445e();
            if (this.f40524l.getBottom() > 0) {
                invalidateViews();
                setSecondPositionVisible();
            }
        }
    }

    /* renamed from: d */
    private void m30444d() {
        if (this.f40514b) {
            if (this.f40537y) {
                this.f40530r.setVisibility(0);
            }
            this.f40531s.setText(this.f40521i);
            this.f40531s.setEnabled(false);
        }
    }

    public void onBottom() {
        if (this.f40514b && !this.f40512J) {
            this.f40512J = true;
            m30444d();
            this.f40531s.performClick();
        }
    }

    public void onBottomComplete() {
        if (this.f40514b) {
            if (this.f40537y) {
                this.f40530r.setVisibility(8);
            }
            if (!this.f40536x) {
                this.f40531s.setText(this.f40522j);
                this.f40531s.setEnabled(false);
                if (!this.f40503A) {
                    removeFooterView(this.f40529q);
                }
            } else {
                this.f40531s.setText(this.f40520h);
                this.f40531s.setEnabled(true);
            }
            this.f40512J = false;
        }
    }

    public void setSecondPositionVisible() {
        if (getAdapter() != null && getAdapter().getCount() > 0 && getFirstVisiblePosition() == 0) {
            setSelection(1);
        }
    }

    public boolean isHasMore() {
        return this.f40536x;
    }

    public void setHasMore(boolean z) {
        this.f40536x = z;
    }

    public RelativeLayout getHeaderLayout() {
        return this.f40524l;
    }

    public RelativeLayout getFooterLayout() {
        return this.f40529q;
    }

    public float getHeaderPaddingTopRate() {
        return this.f40534v;
    }

    public void setHeaderPaddingTopRate(float f) {
        this.f40534v = f;
    }

    public int getHeaderReleaseMinDistance() {
        return this.f40535w;
    }

    public void setHeaderReleaseMinDistance(int i) {
        this.f40535w = i;
    }

    public String getHeaderDefaultText() {
        return this.f40516d;
    }

    public void setHeaderDefaultText(String str) {
        this.f40516d = str;
        TextView textView = this.f40527o;
        if (textView != null && this.f40505C == 1) {
            textView.setText(str);
        }
    }

    public String getHeaderPullText() {
        return this.f40517e;
    }

    public void setHeaderPullText(String str) {
        this.f40517e = str;
    }

    public String getHeaderReleaseText() {
        return this.f40518f;
    }

    public void setHeaderReleaseText(String str) {
        this.f40518f = str;
    }

    public String getHeaderLoadingText() {
        return this.f40519g;
    }

    public void setHeaderLoadingText(String str) {
        this.f40519g = str;
    }

    public String getFooterDefaultText() {
        return this.f40520h;
    }

    public void setFooterDefaultText(String str) {
        this.f40520h = str;
        Button button = this.f40531s;
        if (button != null && button.isEnabled()) {
            this.f40531s.setText(str);
        }
    }

    public String getFooterLoadingText() {
        return this.f40521i;
    }

    public void setFooterLoadingText(String str) {
        this.f40521i = str;
    }

    public String getFooterNoMoreText() {
        return this.f40522j;
    }

    public void setFooterNoMoreText(String str) {
        this.f40522j = str;
    }

    /* renamed from: e */
    private void m30445e() {
        if (this.f40505C != 1) {
            m30449i();
            this.f40525m.clearAnimation();
            this.f40525m.setVisibility(8);
            this.f40526n.setVisibility(8);
            this.f40527o.setText(this.f40516d);
            this.f40505C = 1;
        }
    }

    /* renamed from: f */
    private void m30446f() {
        if (this.f40505C != 2) {
            this.f40525m.setVisibility(0);
            if (this.f40505C != 1) {
                this.f40525m.clearAnimation();
                this.f40525m.startAnimation(this.f40508F);
            }
            this.f40526n.setVisibility(8);
            this.f40527o.setText(this.f40517e);
            if (isVerticalFadingEdgeEnabled()) {
                setVerticalScrollBarEnabled(false);
            }
            this.f40505C = 2;
        }
    }

    /* renamed from: g */
    private void m30447g() {
        if (this.f40505C != 3) {
            this.f40525m.setVisibility(0);
            this.f40525m.clearAnimation();
            this.f40525m.startAnimation(this.f40507E);
            this.f40526n.setVisibility(8);
            this.f40527o.setText(this.f40518f);
            this.f40505C = 3;
        }
    }

    /* renamed from: h */
    private void m30448h() {
        if (this.f40505C != 4) {
            m30449i();
            this.f40525m.setVisibility(8);
            this.f40525m.clearAnimation();
            this.f40526n.setVisibility(0);
            this.f40527o.setText(this.f40519g);
            this.f40505C = 4;
            setSelection(0);
        }
    }

    /* renamed from: a */
    private void m30440a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        if (isVerticalFadingEdgeEnabled()) {
            setVerticalScrollBarEnabled(false);
        }
        for (int i = 0; i < historySize; i++) {
            int i2 = this.f40505C;
            if (i2 == 2 || i2 == 3) {
                RelativeLayout relativeLayout = this.f40524l;
                relativeLayout.setPaddingRelative(relativeLayout.getPaddingLeft(), (int) (((motionEvent.getHistoricalY(i) - this.f40511I) - ((float) this.f40509G)) / this.f40534v), this.f40524l.getPaddingRight(), this.f40524l.getPaddingBottom());
            }
        }
    }

    /* renamed from: i */
    private void m30449i() {
        RelativeLayout relativeLayout = this.f40524l;
        relativeLayout.setPaddingRelative(relativeLayout.getPaddingLeft(), this.f40510H, this.f40524l.getPaddingRight(), this.f40524l.getPaddingBottom());
    }

    /* renamed from: a */
    private void m30441a(View view) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i);
    }

    /* renamed from: a */
    private void m30439a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.drop_down_list_attr);
        this.f40513a = obtainStyledAttributes.getBoolean(1, false);
        this.f40514b = obtainStyledAttributes.getBoolean(2, false);
        this.f40515c = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }
}
