package com.didi.addressnew.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.PreferenceUtil;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.widget.EditTextErasable;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.DisplayUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.view.tips.TipsContainer;
import com.didi.sdk.view.tips.TipsView;
import com.sdk.poibase.model.AddressParam;
import com.taxis99.R;

public class SugSearchView extends LinearLayout {
    public static final int TYPE_END = 2;
    public static final int TYPE_START = 1;

    /* renamed from: v */
    private static final String f9376v = "show_global_sug_way_point_tips";

    /* renamed from: A */
    private TextWatcher f9377A = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f9381c);
            if (SugSearchView.this.f9391m != null) {
                SugSearchView.this.f9391m.afterTextChanged(SugSearchView.this.f9381c, 5, editable);
            }
        }
    };

    /* renamed from: B */
    private OnClickSearchButtonListener f9378B;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditTextErasable f9379a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditTextErasable f9380b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditTextErasable f9381c;

    /* renamed from: d */
    private TextView f9382d;

    /* renamed from: e */
    private TextView f9383e;

    /* renamed from: f */
    private TextView f9384f;

    /* renamed from: g */
    private TextView f9385g;

    /* renamed from: h */
    private ViewGroup f9386h;

    /* renamed from: i */
    private ViewGroup f9387i;
    public boolean isStartTextNeedScrollToBottomWhenFocused = false;
    public boolean isStartTextRedColor = false;

    /* renamed from: j */
    private ViewGroup f9388j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ImageView f9389k;

    /* renamed from: l */
    private int f9390l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ISearchViewCallback f9391m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public AddressParam f9392n;

    /* renamed from: o */
    private boolean f9393o;

    /* renamed from: p */
    private boolean f9394p;

    /* renamed from: q */
    private FromType f9395q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View f9396r;

    /* renamed from: s */
    private TextView f9397s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f9398t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public TipsContainer f9399u;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public TextWatcher f9400w = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f9379a);
            if (SugSearchView.this.f9391m != null) {
                SugSearchView.this.f9391m.afterTextChanged(SugSearchView.this.f9379a, 1, editable);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: x */
    public TextWatcher f9401x = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f9380b);
            if (SugSearchView.this.f9391m != null) {
                SugSearchView.this.f9391m.afterTextChanged(SugSearchView.this.f9380b, 2, editable);
            }
        }
    };

    /* renamed from: y */
    private TextWatcher f9402y = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f9381c);
            if (SugSearchView.this.f9391m != null) {
                SugSearchView.this.f9391m.afterTextChanged(SugSearchView.this.f9381c, 3, editable);
            }
        }
    };

    /* renamed from: z */
    private TextWatcher f9403z = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f9381c);
            if (SugSearchView.this.f9391m != null) {
                SugSearchView.this.f9391m.afterTextChanged(SugSearchView.this.f9381c, 4, editable);
            }
        }
    };

    public interface OnClickSearchButtonListener {
        void onClickSearchButton(int i, String str);
    }

    /* access modifiers changed from: private */
    public void setInputtingTextColor(EditTextErasable editTextErasable) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setSearchViewCallback(ISearchViewCallback iSearchViewCallback) {
        this.f9391m = iSearchViewCallback;
    }

    public SugSearchView(Context context) {
        super(context);
        m8147a();
    }

    public SugSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8147a();
    }

    /* renamed from: a */
    private void m8147a() {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_search_view, this);
        this.f9379a = (EditTextErasable) inflate.findViewById(R.id.et_start);
        this.f9380b = (EditTextErasable) inflate.findViewById(R.id.et_end);
        this.f9381c = (EditTextErasable) inflate.findViewById(R.id.et_common);
        this.f9382d = (TextView) inflate.findViewById(R.id.set_common_title);
        this.f9383e = (TextView) inflate.findViewById(R.id.input_cancel);
        this.f9384f = (TextView) inflate.findViewById(R.id.start_cancel);
        this.f9385g = (TextView) inflate.findViewById(R.id.end_cancel);
        this.f9386h = (ViewGroup) inflate.findViewById(R.id.end_layout);
        this.f9387i = (ViewGroup) inflate.findViewById(R.id.start_layout);
        this.f9388j = (ViewGroup) inflate.findViewById(R.id.common_layout);
        this.f9389k = (ImageView) inflate.findViewById(R.id.enter_way_point);
    }

    public boolean initSugSearchView(SugParams sugParams) {
        if (sugParams == null) {
            return false;
        }
        this.f9392n = sugParams.addressParam;
        this.f9393o = sugParams.enable_way_point;
        this.f9394p = sugParams.is_start_address_new_select;
        FromType fromType = sugParams.fromType;
        this.f9395q = fromType;
        m8148a(fromType, this.f9392n.addressType);
        m8179k();
        m8149a(this.f9395q, this.f9392n.targetAddress, sugParams.endAddress);
        return setStartText(this.f9392n);
    }

    /* renamed from: a */
    private void m8149a(FromType fromType, Address address, Address address2) {
        if (fromType != null) {
            if ((CommonUtils.isFromConfirmPage(fromType) || CommonUtils.isFromGetOnPage(fromType)) && address != null) {
                String str = address.displayName;
                this.f9380b.setText(str);
                if (!TextUtils.isEmpty(str)) {
                    this.f9380b.setSelection(0, str.length());
                }
            }
            if (CommonUtils.isFromNewConfirmPage(fromType) && address2 != null) {
                this.f9380b.setText(address2.displayName);
            }
        }
    }

    /* renamed from: com.didi.addressnew.view.SugSearchView$25 */
    static /* synthetic */ class C391425 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$address$FromType;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.address.FromType[] r0 = com.didi.address.FromType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$address$FromType = r0
                com.didi.address.FromType r1 = com.didi.address.FromType.HOME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM_NEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.address.FromType r1 = com.didi.address.FromType.OPEN_RIDE_CONFIRM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.address.FromType r1 = com.didi.address.FromType.GET_ON     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.address.FromType r1 = com.didi.address.FromType.DRIVING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.address.FromType r1 = com.didi.address.FromType.WAITRSP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.address.FromType r1 = com.didi.address.FromType.ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.address.FromType r1 = com.didi.address.FromType.FROM_CONFIRM_ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.address.FromType r1 = com.didi.address.FromType.FROM_HOME_ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.address.FromType r1 = com.didi.address.FromType.MAP_POINT_SELECT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.address.FromType r1 = com.didi.address.FromType.SETTING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.view.SugSearchView.C391425.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m8148a(FromType fromType, int i) {
        if (fromType != null) {
            boolean z = true;
            int i2 = 0;
            switch (C391425.$SwitchMap$com$didi$address$FromType[fromType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (!(i == 3 || i == 4)) {
                        z = false;
                    }
                    setCommonVisibility(z ? 0 : 8);
                    this.f9387i.setVisibility(z ? 8 : 0);
                    ViewGroup viewGroup = this.f9386h;
                    if (z) {
                        i2 = 8;
                    }
                    viewGroup.setVisibility(i2);
                    if (z) {
                        setCommonHint(i);
                    }
                    showEnterWayPointView();
                    return;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    setCommonVisibility(8);
                    if (i == 2) {
                        this.f9387i.setVisibility(8);
                        this.f9389k.setVisibility(8);
                        this.f9386h.setVisibility(0);
                        this.f9385g.setVisibility(0);
                        return;
                    } else if (i == 1) {
                        this.f9387i.setVisibility(0);
                        this.f9386h.setVisibility(8);
                        this.f9384f.setVisibility(0);
                        return;
                    } else {
                        this.f9387i.setVisibility(8);
                        this.f9386h.setVisibility(8);
                        setCommonVisibility(0);
                        this.f9381c.setHint(i == 4 ? R.string.global_sug_add_company : R.string.global_sug_input_home);
                        return;
                    }
                case 12:
                    this.f9379a.setVisibility(8);
                    this.f9386h.setVisibility(8);
                    setCommonVisibility(0);
                    setCommonHint(i);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (com.didi.addressnew.util.CommonUtils.isFromConfirmPage(r0) != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showEnterWayPointView() {
        /*
            r3 = this;
            android.view.ViewGroup r0 = r3.f9386h
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            com.didi.address.FromType r0 = r3.f9395q
            r1 = 0
            if (r0 == 0) goto L_0x0016
            boolean r2 = r3.f9393o
            boolean r0 = com.didi.addressnew.util.CommonUtils.isFromConfirmPage(r0)
            if (r0 == 0) goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            if (r2 != 0) goto L_0x001a
            return
        L_0x001a:
            android.content.Context r0 = r3.getContext()
            r2 = 1113587712(0x42600000, float:56.0)
            int r0 = com.didi.addressnew.util.ViewUtils.dip2px(r0, r2)
            android.widget.ImageView r2 = r3.f9389k
            r2.setVisibility(r1)
            android.view.ViewGroup r1 = r3.f9387i
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            r1.setMarginEnd(r0)
            android.view.ViewGroup r0 = r3.f9387i
            r0.setLayoutParams(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.view.SugSearchView.showEnterWayPointView():void");
    }

    /* renamed from: b */
    private void m8158b() {
        if (PreferenceUtil.getInstance(getContext().getApplicationContext()).getBoolean(f9376v, true)) {
            if (this.f9399u == null) {
                this.f9399u = new TipsContainer((Activity) getContext());
            }
            this.f9399u.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            final TipsView tipsView = new TipsView(getContext());
            tipsView.setTips(getContext().getResources().getString(R.string.global_sug_way_point_tips));
            tipsView.setId(this.f9389k.hashCode());
            tipsView.setCloseListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    PreferenceUtil.getInstance(SugSearchView.this.getContext().getApplicationContext()).put(SugSearchView.f9376v, false);
                    AddressTrack.trackClickWayPointTips();
                }
            });
            this.f9389k.post(new Runnable() {
                public void run() {
                    AddressTrack.trackShowWayPointTips();
                    SugSearchView.this.f9399u.show(tipsView, SugSearchView.this.f9389k, 2, 1, ViewUtils.dip2px(SugSearchView.this.getContext(), 36.0f), ViewUtils.dip2px(SugSearchView.this.getContext(), 10.0f), false);
                }
            });
        }
    }

    public void dismissPopupTips() {
        TipsContainer tipsContainer = this.f9399u;
        if (tipsContainer != null) {
            tipsContainer.clearAllTips();
            this.f9399u.setOnTouchListener((View.OnTouchListener) null);
        }
    }

    public void setOnEnterWayPointViewClickListener(View.OnClickListener onClickListener) {
        this.f9389k.setOnClickListener(onClickListener);
    }

    private void setCommonHint(int i) {
        this.f9381c.setHint(i == 4 ? R.string.GRider_Sug_2020_placeholder_work : i == 3 ? R.string.GRider_Sug_2020_placeholder_home : (i == 6 || i == 101 || i == 102) ? R.string.global_sug_input_stop_hint : i == 5 ? R.string.GRider_Sug_2020_placeholder_favorite : i == 1 ? R.string.GRider_Sug_2020_currentLoc : i == 2 ? R.string.GRider_Sug_2020_placeholder_whereTo : R.string.global_sug_input_home);
    }

    public void addStatusBarHeightView() {
        View view = new View(getContext());
        this.f9390l = ViewUtils.getStatusBarHeight(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f9390l));
        view.setBackgroundColor(-1);
        addView(view, 0);
    }

    public void onStartPoiInfoFetchBefore() {
        this.f9379a.setTextColor(getContext().getResources().getColor(R.color.poi_one_address_hint));
    }

    public void onStartPoiInfoFetchAfter() {
        if (CommonUtils.isFromHomePage(this.f9395q)) {
            getStartEditText().setHighlightColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_normal_hint));
        } else {
            this.f9379a.setTextColor(-16777216);
        }
    }

    public void onEndPoiInfoFetchBefore() {
        this.f9380b.setTextColor(getContext().getResources().getColor(R.color.poi_one_address_hint));
    }

    public void onEndPoiInfoFetchAfter() {
        this.f9380b.setTextColor(-16777216);
    }

    public void makeStartTextFocusedWhenIsRed() {
        EditTextErasable editTextErasable;
        if (CommonUtils.isFromHomePage(this.f9395q) && this.isStartTextRedColor && (editTextErasable = this.f9379a) != null && !TextUtils.isEmpty(editTextErasable.getHint()) && this.f9379a.getHint().toString().equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
            this.f9379a.setHintTextColor(getContext().getResources().getColor(R.color.poi_one_address_hint));
            this.isStartTextNeedScrollToBottomWhenFocused = false;
            this.f9379a.requestFocus();
        }
    }

    public boolean setStartText(AddressParam addressParam) {
        boolean z;
        String str = "";
        if (this.f9392n == null || !this.f9394p) {
            if (CommonUtils.isValidLocation(addressParam.currentAddress) || CommonUtils.isValidLocation(addressParam.targetAddress)) {
                z = this.f9395q == FromType.HOME || this.f9395q == FromType.CONFIRM || CommonUtils.isGetOnFromType(this.f9395q);
                if (addressParam.targetAddress != null) {
                    str = addressParam.targetAddress.displayName;
                }
                if (TextUtils.isEmpty(str)) {
                    str = getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                    if (this.f9395q == FromType.CONFIRM_NEW) {
                        str = getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                    }
                }
                if (addressParam.targetAddress != null) {
                    addressParam.targetAddress.displayName = str;
                }
            } else {
                this.isStartTextRedColor = true;
                this.f9379a.setHint(getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc));
                this.f9379a.setHintTextColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_nogps_hint));
                z = false;
            }
            this.f9379a.setText(str);
            if (CommonUtils.isFromGetOnPage(this.f9395q) && !TextUtils.isEmpty(str)) {
                this.f9379a.setSelection(0, str.length());
            }
            this.f9379a.setTextColor(-16777216);
            if (this.f9392n.addressType == 1 && !TextUtils.isEmpty(str)) {
                this.f9379a.setClearIconVisible(true);
            }
            return z;
        }
        this.f9379a.setText(str);
        return false;
    }

    public EditTextErasable getCommonEditText() {
        return this.f9381c;
    }

    public EditTextErasable getStartEditText() {
        return this.f9379a;
    }

    public EditTextErasable getEndEditText() {
        return this.f9380b;
    }

    /* renamed from: c */
    private void m8162c() {
        if (CommonUtils.isFromHomePage(this.f9395q) || CommonUtils.isFromNewConfirmPage(this.f9395q)) {
            m8165d();
        }
        EditTextErasable editTextErasable = this.f9379a;
        if (editTextErasable != null) {
            editTextErasable.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SugSearchView.this.f9379a.setClearIconVisible(!(SugSearchView.this.f9379a.getText() == null || SugSearchView.this.f9379a.getText().length() == 0));
                    if (SugSearchView.this.f9391m != null) {
                        SugSearchView.this.f9391m.onClick(1);
                    }
                }
            });
            this.f9379a.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f9391m != null) {
                        SugSearchView.this.f9391m.onClearClick(1, str);
                    }
                }
            });
        }
        EditTextErasable editTextErasable2 = this.f9380b;
        if (editTextErasable2 != null) {
            editTextErasable2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SugSearchView.this.f9380b.setClearIconVisible(!(SugSearchView.this.f9380b.getText() == null || SugSearchView.this.f9380b.getText().length() == 0));
                    if (SugSearchView.this.f9391m != null) {
                        SugSearchView.this.f9391m.onClick(2);
                    }
                }
            });
            this.f9380b.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f9391m != null) {
                        SugSearchView.this.f9391m.onClearClick(2, str);
                    }
                }
            });
        }
        this.f9379a.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    boolean unused = SugSearchView.this.f9398t = true;
                }
                return SugSearchView.super.onTouchEvent(motionEvent);
            }
        });
        this.f9380b.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    boolean unused = SugSearchView.this.f9398t = true;
                }
                return SugSearchView.super.onTouchEvent(motionEvent);
            }
        });
    }

    /* renamed from: d */
    private void m8165d() {
        EditTextErasable editTextErasable = this.f9379a;
        if (editTextErasable != null) {
            editTextErasable.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    boolean z2 = true;
                    if (SugSearchView.this.f9391m != null && SugSearchView.this.f9398t) {
                        SugSearchView.this.f9391m.focusChanged(1, z);
                        boolean unused = SugSearchView.this.f9398t = !z;
                    }
                    if (SugSearchView.this.f9379a != null) {
                        boolean z3 = SugSearchView.this.f9379a.getText() == null || SugSearchView.this.f9379a.getText().length() == 0;
                        EditTextErasable c = SugSearchView.this.f9379a;
                        if (!z || z3) {
                            z2 = false;
                        }
                        c.setClearIconVisible(z2);
                        if (z) {
                            SugSearchView sugSearchView = SugSearchView.this;
                            sugSearchView.resetShadow(sugSearchView.f9379a);
                            return;
                        }
                        SugSearchView.this.f9379a.removeTextChangedListener(SugSearchView.this.f9400w);
                    }
                }
            });
        }
        EditTextErasable editTextErasable2 = this.f9380b;
        if (editTextErasable2 != null) {
            editTextErasable2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (SugSearchView.this.f9391m != null && SugSearchView.this.f9398t) {
                        SugSearchView.this.f9391m.focusChanged(2, z);
                        boolean unused = SugSearchView.this.f9398t = !z;
                    }
                    if (SugSearchView.this.f9380b != null) {
                        boolean z2 = false;
                        boolean z3 = SugSearchView.this.f9380b.getText() == null || SugSearchView.this.f9380b.getText().length() == 0;
                        EditTextErasable e = SugSearchView.this.f9380b;
                        if (z && !z3) {
                            z2 = true;
                        }
                        e.setClearIconVisible(z2);
                        if (z) {
                            SugSearchView sugSearchView = SugSearchView.this;
                            sugSearchView.resetShadow(sugSearchView.f9380b);
                            SugSearchView.this.f9380b.addTextChangedListener(SugSearchView.this.f9401x);
                            return;
                        }
                        SugSearchView.this.f9380b.removeTextChangedListener(SugSearchView.this.f9401x);
                    }
                }
            });
        }
    }

    public void setPressedState(boolean z) {
        this.f9398t = z;
    }

    public void addWatcherForStart() {
        EditTextErasable editTextErasable = this.f9379a;
        if (editTextErasable != null) {
            editTextErasable.addTextChangedListener(this.f9400w);
        }
    }

    public void removeWatcherForStart() {
        EditTextErasable editTextErasable = this.f9379a;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f9400w);
        }
    }

    public void setListener(AddressParam addressParam) {
        m8162c();
        m8151a(addressParam);
    }

    /* renamed from: e */
    private void m8167e() {
        EditTextErasable editTextErasable = this.f9381c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f9403z);
            this.f9381c.removeTextChangedListener(this.f9377A);
            this.f9381c.addTextChangedListener(this.f9402y);
            this.f9381c.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f9391m != null) {
                        SugSearchView.this.f9391m.onClearClick(3, str);
                    }
                }
            });
        }
    }

    /* renamed from: f */
    private void m8168f() {
        EditTextErasable editTextErasable = this.f9381c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f9402y);
            this.f9381c.removeTextChangedListener(this.f9377A);
            this.f9381c.addTextChangedListener(this.f9403z);
            this.f9381c.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f9391m != null) {
                        SugSearchView.this.f9391m.onClearClick(4, str);
                    }
                }
            });
        }
    }

    /* renamed from: g */
    private void m8171g() {
        EditTextErasable editTextErasable = this.f9381c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f9403z);
            this.f9381c.removeTextChangedListener(this.f9402y);
            this.f9381c.addTextChangedListener(this.f9377A);
            this.f9381c.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f9391m != null) {
                        SugSearchView.this.f9391m.onClearClick(SugSearchView.this.f9392n != null ? SugSearchView.this.f9392n.addressType : 5, str);
                    }
                }
            });
        }
    }

    public void removeCommonWatcher(AddressParam addressParam) {
        if (addressParam.addressType == 4) {
            m8173h();
        } else if (addressParam.addressType == 3) {
            m8175i();
        } else {
            m8177j();
        }
    }

    /* renamed from: h */
    private void m8173h() {
        EditTextErasable editTextErasable = this.f9381c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f9403z);
        }
    }

    /* renamed from: i */
    private void m8175i() {
        EditTextErasable editTextErasable = this.f9381c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f9402y);
        }
    }

    /* renamed from: j */
    private void m8177j() {
        EditTextErasable editTextErasable = this.f9381c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f9377A);
        }
    }

    /* renamed from: a */
    private void m8151a(AddressParam addressParam) {
        EditTextErasable editTextErasable = this.f9380b;
        if (editTextErasable != null) {
            editTextErasable.addTextChangedListener(this.f9401x);
        }
        if (addressParam.addressType == 4) {
            m8168f();
        } else if (addressParam.addressType == 3) {
            m8167e();
        } else {
            m8171g();
        }
    }

    public void removeEndTextWatcher() {
        EditTextErasable editTextErasable = this.f9380b;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f9401x);
        }
    }

    public void addEndTextWatcher() {
        EditTextErasable editTextErasable = this.f9380b;
        if (editTextErasable != null) {
            editTextErasable.addTextChangedListener(this.f9401x);
        }
    }

    /* renamed from: k */
    private void m8179k() {
        EditTextErasable editTextErasable = this.f9379a;
        if (editTextErasable != null) {
            editTextErasable.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SugSearchView.this.m8152a(textView, i, 1);
                }
            });
        }
        EditTextErasable editTextErasable2 = this.f9380b;
        if (editTextErasable2 != null) {
            editTextErasable2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SugSearchView.this.m8152a(textView, i, 2);
                }
            });
        }
        EditTextErasable editTextErasable3 = this.f9381c;
        if (editTextErasable3 != null) {
            editTextErasable3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    SugSearchView sugSearchView = SugSearchView.this;
                    return sugSearchView.m8152a(textView, i, sugSearchView.f9392n.addressType);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m8152a(TextView textView, int i, int i2) {
        if (i != 3) {
            return false;
        }
        String trim = textView.getText().toString().trim();
        OnClickSearchButtonListener onClickSearchButtonListener = this.f9378B;
        if (onClickSearchButtonListener == null) {
            return true;
        }
        onClickSearchButtonListener.onClickSearchButton(i2, trim);
        return true;
    }

    public void setOnClickSearchButtonListener(OnClickSearchButtonListener onClickSearchButtonListener) {
        this.f9378B = onClickSearchButtonListener;
    }

    /* renamed from: a */
    private int m8145a(View view) {
        if (view.getParent() == getParent()) {
            return view.getTop();
        }
        return view.getTop() + m8145a((View) view.getParent());
    }

    /* renamed from: b */
    private int m8156b(View view) {
        if (view.getParent() == getParent()) {
            return view.getLeft();
        }
        return view.getLeft() + m8156b((View) view.getParent());
    }

    /* renamed from: c */
    private int m8160c(View view) {
        if (view.getParent() == getParent()) {
            return view.getRight();
        }
        return view.getRight() + m8156b(view);
    }

    /* renamed from: d */
    private int m8163d(View view) {
        if (view.getParent() == getParent()) {
            return view.getBottom();
        }
        return view.getBottom() + m8163d((View) view.getParent());
    }

    public void setmShadowView(View view) {
        this.f9396r = view;
    }

    public void resetShadow(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (this.f9396r != null) {
            int height = view.getHeight();
            int dp2px = DisplayUtils.dp2px(getContext(), 40.0f) + height;
            int width = view.getWidth() + DisplayUtils.dp2px(getContext(), 40.0f);
            if (this.f9396r.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f9396r.getLayoutParams();
                layoutParams2.topMargin = m8145a(view) - ((dp2px - height) / 2);
                setShadowViewPosition(view);
                layoutParams = layoutParams2;
            } else if (this.f9396r.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f9396r.getLayoutParams();
                layoutParams3.topMargin = m8145a(view) - ((dp2px - height) / 2);
                setShadowViewPosition(view);
                layoutParams = layoutParams3;
            } else if (this.f9396r.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f9396r.getLayoutParams();
                layoutParams4.topMargin = m8145a(view) - ((dp2px - height) / 2);
                setShadowViewPosition(view);
                layoutParams = layoutParams4;
            } else {
                layoutParams = this.f9396r.getLayoutParams();
            }
            layoutParams.width = width;
            layoutParams.height = dp2px;
            this.f9396r.setLayoutParams(layoutParams);
            this.f9396r.setVisibility(0);
        }
    }

    private void setShadowViewPosition(View view) {
        this.f9396r.setLeft(m8156b(view) - DisplayUtils.dp2px(getContext(), 30.0f));
        this.f9396r.setRight(m8160c(view) + DisplayUtils.dp2px(getContext(), 10.0f));
    }

    public void onResume() {
        postDelayed(new Runnable() {
            public void run() {
                if (SugSearchView.this.f9379a != null && SugSearchView.this.f9379a.isFocused()) {
                    SugSearchView sugSearchView = SugSearchView.this;
                    sugSearchView.resetShadow(sugSearchView.f9379a);
                } else if (SugSearchView.this.f9380b != null && SugSearchView.this.f9380b.isFocused()) {
                    SugSearchView sugSearchView2 = SugSearchView.this;
                    sugSearchView2.resetShadow(sugSearchView2.f9380b);
                } else if (SugSearchView.this.f9381c == null || !SugSearchView.this.f9381c.isFocused()) {
                    SugSearchView.this.f9396r.setVisibility(4);
                } else {
                    SugSearchView sugSearchView3 = SugSearchView.this;
                    sugSearchView3.resetShadow(sugSearchView3.f9381c);
                }
            }
        }, 75);
    }

    public void onSingle(AddressParam addressParam, IAddressResult iAddressResult) {
        if (addressParam != null) {
            int i = addressParam.addressType;
            if (i == 3) {
                setCommonVisibility(0);
                this.f9379a.setVisibility(8);
                this.f9386h.setVisibility(8);
                setCommonHint(addressParam.addressType);
                if (ViewUtils.isRTL()) {
                    this.f9381c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.sug_icon_home), (Drawable) null);
                } else {
                    this.f9381c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.sug_icon_home), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else if (i == 4) {
                setCommonVisibility(0);
                this.f9379a.setVisibility(8);
                this.f9386h.setVisibility(8);
                setCommonHint(addressParam.addressType);
                if (ViewUtils.isRTL()) {
                    this.f9381c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.sug_icon_work), (Drawable) null);
                } else {
                    this.f9381c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.sug_icon_work), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else if (i == 5) {
                setCommonVisibility(0);
                this.f9379a.setVisibility(8);
                this.f9386h.setVisibility(8);
                setCommonHint(addressParam.addressType);
                if (ViewUtils.isRTL()) {
                    this.f9381c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.sug_icon_favorite), (Drawable) null);
                } else {
                    this.f9381c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.sug_icon_favorite), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else if (i == 6 || i == 101 || i == 102) {
                setCommonVisibility(0);
                this.f9379a.setVisibility(8);
                this.f9386h.setVisibility(8);
                setCommonHint(addressParam.addressType);
                if (ViewUtils.isRTL()) {
                    this.f9381c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.waypoint_icon_stop), (Drawable) null);
                } else {
                    this.f9381c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.waypoint_icon_stop), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
            int i2 = C391425.$SwitchMap$com$didi$address$FromType[this.f9395q.ordinal()];
            if (i2 == 1 || i2 == 11) {
                this.f9383e.setVisibility(0);
            } else if (i2 == 12) {
                this.f9383e.setVisibility(8);
            }
            EditTextErasable editTextErasable = this.f9381c;
            if (editTextErasable != null) {
                editTextErasable.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View view, boolean z) {
                        if (z) {
                            SugSearchView sugSearchView = SugSearchView.this;
                            sugSearchView.resetShadow(sugSearchView.f9381c);
                            if (SugSearchView.this.f9391m != null && SugSearchView.this.f9392n != null) {
                                SugSearchView.this.f9391m.focusChanged(SugSearchView.this.f9392n.addressType, z);
                            }
                        }
                    }
                });
            }
            resetShadow(this.f9381c);
        }
    }

    private void setCommonVisibility(int i) {
        ViewGroup viewGroup = this.f9388j;
        if (viewGroup != null && this.f9381c != null) {
            viewGroup.setVisibility(i);
            this.f9381c.setVisibility(i);
        }
    }

    public View getCancel(int i) {
        if (i == 1) {
            return this.f9384f;
        }
        if (i == 2) {
            return this.f9385g;
        }
        return this.f9383e;
    }

    public void setStartAddressDrawableLeftGrey() {
        EditTextErasable editTextErasable = this.f9379a;
        if (editTextErasable != null) {
            editTextErasable.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.waypoint_icon_pick_up_dis), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void addCommonTextWatcher(AddressParam addressParam) {
        if (addressParam.addressType == 4) {
            m8168f();
        } else if (addressParam.addressType == 3) {
            m8167e();
        } else {
            m8171g();
        }
    }

    public int getStartwithEndFullSize() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9379a.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f9379a.getLayoutParams();
        return layoutParams.bottomMargin + layoutParams.topMargin + layoutParams2.bottomMargin + layoutParams2.topMargin + 12 + 48 + 12 + 48 + 10 + 5;
    }

    public void hideShadow() {
        View view = this.f9396r;
        if (view != null) {
            view.setVisibility(4);
        }
    }
}
