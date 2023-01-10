package com.didi.component.substitute.call.addPassenger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.contacts.GCommonContactsModel;
import com.didi.component.common.contacts.GCommonGetContactsActivity;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.util.UIUtils;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.substitute.call.adapter.IntroducesAdapter;
import com.didi.component.substitute.call.model.ContactModel;
import com.didi.component.substitute.call.model.ErrorObject;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SPUtils;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.estimate.daijiao.AddPhoneModel;
import com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.flutter.LoginEventHandler;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0001gB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00103\u001a\u000204H\u0002J\u001a\u00105\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000201H\u0002J\u0018\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0002J\b\u0010<\u001a\u000201H\u0002J\u0006\u0010=\u001a\u000201J\u0010\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0002J\u001c\u0010D\u001a\u0002042\b\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020/2\b\u0010J\u001a\u0004\u0018\u00010KH\u0014J\b\u0010L\u001a\u000201H\u0016J\u0012\u0010M\u001a\u0002012\b\u0010;\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010N\u001a\u0002012\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\b\u0010Q\u001a\u000201H\u0014J\b\u0010R\u001a\u000201H\u0014J\b\u0010S\u001a\u000201H\u0002J\b\u0010T\u001a\u000201H\u0002J\b\u0010U\u001a\u000201H\u0002J\b\u0010V\u001a\u000201H\u0002J\b\u0010W\u001a\u000201H\u0002J\u001a\u0010X\u001a\u0002012\u0006\u0010Y\u001a\u00020\u00052\b\u0010Z\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010[\u001a\u0002012\u0006\u0010\\\u001a\u00020$H\u0007J\b\u0010]\u001a\u000201H\u0002J\b\u0010^\u001a\u000201H\u0002J\b\u0010_\u001a\u000201H\u0003J\u001c\u0010`\u001a\u0002012\b\u0010a\u001a\u0004\u0018\u00010\u00052\b\u0010b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/XD¢\u0006\u0002\n\u0000¨\u0006h"}, mo148868d2 = {"Lcom/didi/component/substitute/call/addPassenger/AddPassengerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "mAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "mBack", "Landroid/widget/ImageView;", "mBubble", "Lcom/didi/global/globaluikit/popup/LEGOBubble;", "mClickStation", "Landroid/widget/TextView;", "mConfirm", "mContacts", "mContactsImgTips", "mCountryCode", "mCountryCodeStr", "mCountryFlag", "mCountryOpen", "mFirstName", "mFirstNameInput", "Landroid/widget/EditText;", "mFirstNameStation", "mIntroductions", "Landroidx/recyclerview/widget/RecyclerView;", "mLegoDrawer", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "getMLegoDrawer", "()Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "setMLegoDrawer", "(Lcom/didi/global/globaluikit/drawer/LEGODrawer;)V", "mLoginEventHandler", "Lcom/didi/unifylogin/flutter/LoginEventHandler;", "mNameBottomLine", "Landroid/view/View;", "mPhoneBottomLine", "mPhoneNum", "mPhoneNumInput", "mPhoneNumStation", "mRefreshLis", "Lcom/didi/component/core/event/BaseEventPublisher$OnEventListener;", "Lcom/didi/component/substitute/call/model/ErrorObject;", "mTitle", "sContactsImgTipsHasShow", "sResultForGetContacts", "", "changeBottomLineColor", "", "bottomLine", "isChanged", "", "changeBottomLineHeight", "value", "", "clickConfirm", "clickTrackEvent", "eventId", "v", "closeContactsTipsBubble", "hideLoading", "hideSoftKeyboard", "activity", "Landroid/app/Activity;", "initDate", "initView", "inputListener", "isNoName", "phone", "name", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "openContacts", "openCountries", "pageShowTrackEvent", "popShowTrackEvent", "setConfirmEnable", "setHint", "hint", "editText", "setupUI", "view", "showBubble", "showLoading", "showPopRemindNoSeat", "updateCountryInfo", "url", "code", "updatePhoneNumAndFirstName", "result", "Ljava/util/ArrayList;", "Lcom/didi/component/common/contacts/GCommonContactsModel;", "Companion", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AddPassengerActivity.kt */
public final class AddPassengerActivity extends AppCompatActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: A */
    private LEGODrawer f17920A;

    /* renamed from: a */
    private final String f17921a = "AddPassengerActivity";

    /* renamed from: b */
    private EditText f17922b;

    /* renamed from: c */
    private EditText f17923c;

    /* renamed from: d */
    private TextView f17924d;

    /* renamed from: e */
    private TextView f17925e;

    /* renamed from: f */
    private TextView f17926f;

    /* renamed from: g */
    private TextView f17927g;

    /* renamed from: h */
    private TextView f17928h;

    /* renamed from: i */
    private TextView f17929i;

    /* renamed from: j */
    private ImageView f17930j;

    /* renamed from: k */
    private ImageView f17931k;

    /* renamed from: l */
    private ImageView f17932l;

    /* renamed from: m */
    private ImageView f17933m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f17934n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f17935o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View f17936p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public View f17937q;

    /* renamed from: r */
    private LoginEventHandler f17938r;

    /* renamed from: s */
    private final int f17939s = 1;

    /* renamed from: t */
    private RecyclerView f17940t;

    /* renamed from: u */
    private String f17941u;

    /* renamed from: v */
    private String f17942v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final String f17943w = "sContactsImgTipsHasShow";
    /* access modifiers changed from: private */

    /* renamed from: x */
    public LEGOBubble f17944x;

    /* renamed from: y */
    private LottieAnimationView f17945y;

    /* renamed from: z */
    private final BaseEventPublisher.OnEventListener<ErrorObject> f17946z = new AddPassengerActivity$mRefreshLis$1(this);

    public void _$_clearFindViewByIdCache() {
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/component/substitute/call/addPassenger/AddPassengerActivity$Companion;", "", "()V", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: AddPassengerActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, AddPassengerActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle != null) {
            GLog.m11357e(this.f17921a, "onCreate: savedInstanceState");
            finish();
        }
        setContentView((int) R.layout.activity_add_passenger);
        m15214a();
        m15221b();
        m15225d();
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Confirm.EVENT_SUBSTITUTE_CALL_REFRESH, this.f17946z, ErrorObject.class);
        View childAt = ((ViewGroup) findViewById(16908290)).getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "findViewById<ViewGroup>(…d.content)).getChildAt(0)");
        setupUI(childAt);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m15232k();
    }

    /* renamed from: a */
    private final void m15214a() {
        this.f17924d = (TextView) findViewById(R.id.tv_title);
        TextView textView = (TextView) findViewById(R.id.tv_country_code);
        this.f17925e = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.f17940t = (RecyclerView) findViewById(R.id.rv_introductions);
        this.f17926f = (TextView) findViewById(R.id.tv_phone_num_station);
        this.f17927g = (TextView) findViewById(R.id.tv_first_name_station);
        this.f17928h = (TextView) findViewById(R.id.tv_click_tips);
        TextView textView2 = (TextView) findViewById(R.id.tv_sc_confirm);
        this.f17929i = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(new AddPassengerActivity$initView$1(this));
        }
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        this.f17930j = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_country);
        this.f17931k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_drop_down);
        this.f17932l = imageView3;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        ImageView imageView4 = (ImageView) findViewById(R.id.iv_add_contacts);
        this.f17933m = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(this);
        }
        this.f17922b = (EditText) findViewById(R.id.et_phone);
        this.f17923c = (EditText) findViewById(R.id.et_name);
        this.f17936p = findViewById(R.id.phone_bottom_line);
        this.f17937q = findViewById(R.id.name_bottom_line);
        ImageView imageView5 = this.f17933m;
        if (imageView5 != null) {
            imageView5.post(new AddPassengerActivity$initView$2(this));
        }
        this.f17945y = (LottieAnimationView) findViewById(R.id.animation_view);
    }

    /* renamed from: b */
    private final void m15221b() {
        EditText editText = this.f17922b;
        if (editText != null) {
            editText.addTextChangedListener(new AddPassengerActivity$inputListener$1(this));
        }
        EditText editText2 = this.f17922b;
        if (editText2 != null) {
            editText2.setOnFocusChangeListener(new AddPassengerActivity$inputListener$2(this));
        }
        EditText editText3 = this.f17923c;
        if (editText3 != null) {
            editText3.addTextChangedListener(new AddPassengerActivity$inputListener$3(this));
        }
        EditText editText4 = this.f17923c;
        if (editText4 != null) {
            editText4.setOnFocusChangeListener(new AddPassengerActivity$inputListener$4(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15217a(View view, boolean z) {
        if (z) {
            if (view != null) {
                view.setBackgroundColor(getResources().getColor(R.color.cut_down_time_color));
            }
        } else if (view != null) {
            view.setBackgroundColor(getResources().getColor(R.color.g_color_ddd));
        }
        m15216a(view, 0.5f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15216a(View view, float f) {
        Context context = null;
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        if (layoutParams != null) {
            if (view != null) {
                context = view.getContext();
            }
            layoutParams.height = UIUtils.dip2pxInt(context, f);
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m15223c() {
        TextView textView = this.f17929i;
        if (textView != null) {
            textView.setEnabled(!TextUtils.isEmpty(this.f17935o) && !TextUtils.isEmpty(this.f17934n));
        }
    }

    /* renamed from: d */
    private final void m15225d() {
        AddPhoneModel addPhoneModel;
        TextView textView;
        TextView textView2;
        SubstituteCallModel substituteCallModel = FormStore.getInstance().getSubstituteCallModel();
        if (substituteCallModel != null && (addPhoneModel = substituteCallModel.getAddPhoneModel()) != null) {
            String title = addPhoneModel.getTitle();
            if (!(title == null || (textView2 = this.f17924d) == null)) {
                textView2.setText(title);
            }
            List<String> introductions = addPhoneModel.getIntroductions();
            if (introductions != null) {
                RecyclerView recyclerView = this.f17940t;
                if (recyclerView != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
                }
                RecyclerView recyclerView2 = this.f17940t;
                if (recyclerView2 != null) {
                    recyclerView2.setAdapter(new IntroducesAdapter(this, introductions));
                }
            }
            String confirmBtnText = addPhoneModel.getConfirmBtnText();
            if (!(confirmBtnText == null || (textView = this.f17929i) == null)) {
                textView.setText(confirmBtnText);
            }
            GlobalRichInfo phone_intro = addPhoneModel.getPhone_intro();
            if (phone_intro != null) {
                phone_intro.bindTextView(this.f17926f);
            }
            GlobalRichInfo nameIntro = addPhoneModel.getNameIntro();
            if (nameIntro != null) {
                nameIntro.bindTextView(this.f17927g);
            }
            GlobalRichInfo confirmIntro = addPhoneModel.getConfirmIntro();
            if (confirmIntro != null) {
                confirmIntro.bindTextView(this.f17928h);
            }
            String phoneNumHint = addPhoneModel.getPhoneNumHint();
            if (phoneNumHint != null) {
                m15218a(phoneNumHint, this.f17922b);
            }
            String nameHint = addPhoneModel.getNameHint();
            if (nameHint != null) {
                m15218a(nameHint, this.f17923c);
            }
            this.f17942v = addPhoneModel.getContactsImgTips();
            CountryManager ins = CountryManager.getIns();
            this.f17941u = ins.getCurrentCountryCode();
            m15219a(ins.getDefCountry().getNationalFlagUrl(), this.f17941u);
        }
    }

    /* renamed from: a */
    private final void m15218a(String str, EditText editText) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(24, true), 0, spannableString.length(), 33);
        if (editText != null) {
            editText.setHint(new SpannedString(spannableString));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15219a(String str, String str2) {
        ImageView imageView;
        if (!(str == null || (imageView = this.f17931k) == null)) {
            Glide.with((FragmentActivity) this).load(str).into(imageView);
        }
        if (str2 != null) {
            TextView textView = this.f17925e;
            if (textView != null) {
                textView.setText(str2);
            }
            this.f17941u = str2;
        }
    }

    /* renamed from: a */
    private final void m15220a(ArrayList<GCommonContactsModel> arrayList) {
        String str;
        GCommonContactsModel gCommonContactsModel = arrayList.get(0);
        if (gCommonContactsModel != null) {
            CharSequence charSequence = gCommonContactsModel.phone;
            if (charSequence == null || charSequence.length() == 0) {
                m15217a(this.f17936p, false);
                str = "";
            } else {
                str = gCommonContactsModel.phone;
                Intrinsics.checkNotNullExpressionValue(str, "it.phone");
                String str2 = this.f17941u;
                if (str2 != null && StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
                    str = str.substring(str2.length());
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                }
                EditText editText = this.f17922b;
                if (editText != null) {
                    editText.setText(StringUtil.getNum(str));
                }
                this.f17934n = str;
                EditText editText2 = this.f17922b;
                if (editText2 != null) {
                    editText2.clearFocus();
                }
                m15216a(this.f17936p, 1.5f);
                View view = this.f17936p;
                if (view != null) {
                    view.setBackgroundColor(getResources().getColor(R.color.cut_down_time_color));
                }
            }
            if (m15222b(str, gCommonContactsModel.name)) {
                EditText editText3 = this.f17923c;
                if (editText3 != null) {
                    editText3.setText("");
                }
                m15217a(this.f17937q, false);
                return;
            }
            EditText editText4 = this.f17923c;
            if (editText4 != null) {
                editText4.setText(gCommonContactsModel.name);
            }
            this.f17935o = gCommonContactsModel.name;
            EditText editText5 = this.f17923c;
            if (editText5 != null) {
                editText5.clearFocus();
            }
            m15216a(this.f17937q, 1.5f);
            View view2 = this.f17937q;
            if (view2 != null) {
                view2.setBackgroundColor(getResources().getColor(R.color.cut_down_time_color));
            }
        }
    }

    /* renamed from: b */
    private final boolean m15222b(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        CharSequence charSequence2 = str2;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (z) {
            return true;
        }
        return Intrinsics.areEqual((Object) new Regex("\\s").replace(charSequence, ""), (Object) new Regex("\\s").replace(charSequence2, ""));
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (Intrinsics.areEqual((Object) view, (Object) this.f17930j)) {
            m15224c("ibt_gp_write_rider_back_ck", WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME);
            onBackPressed();
        } else if (Intrinsics.areEqual((Object) view, (Object) this.f17932l)) {
            m15226e();
        } else if (Intrinsics.areEqual((Object) view, (Object) this.f17925e)) {
            m15226e();
        } else if (Intrinsics.areEqual((Object) view, (Object) this.f17933m)) {
            m15227f();
        }
    }

    /* renamed from: e */
    private final void m15226e() {
        Context context = this;
        DRouter.build("GuaranaOneTravel://one/country_code/calling_code").start(context);
        this.f17938r = new LoginEventHandler(context);
        LoginEventHandler.setCountryCodeSelectListener(new AddPassengerActivity$openCountries$1(this));
    }

    /* renamed from: f */
    private final void m15227f() {
        Context context = this;
        startActivityForResult(GCommonGetContactsActivity.getIntent(context, 1), this.f17939s);
        m15231j();
        SPUtils.put(context, this.f17943w, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void m15228g() {
        EditText editText = this.f17923c;
        if (editText != null) {
            editText.clearFocus();
        }
        m15234m();
        ContactModel contactModel = new ContactModel();
        contactModel.setName(this.f17935o);
        contactModel.setPhone(this.f17934n);
        contactModel.setType(1);
        String str = this.f17941u;
        if (str != null) {
            contactModel.setCountryCode(StringUtil.getNum(str));
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.EVENT_SIMPLE_REQUEST_SUBSTITUTE_CALL, contactModel);
        m15224c("ibt_gp_write_rider_confirm_ck", XPanelScene.SCENE_CONFIRM);
    }

    public void onBackPressed() {
        if (!TextUtils.isEmpty(this.f17935o) || !TextUtils.isEmpty(this.f17934n)) {
            m15229h();
            return;
        }
        FormStore.getInstance().setSkipEstimateGet(true);
        finish();
    }

    public final LEGODrawer getMLegoDrawer() {
        return this.f17920A;
    }

    public final void setMLegoDrawer(LEGODrawer lEGODrawer) {
        this.f17920A = lEGODrawer;
    }

    /* renamed from: h */
    private final void m15229h() {
        String string = getResources().getString(R.string.GRider_call_Cancel_adding_XgNS);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_call_Cancel_adding_XgNS)");
        String string2 = getResources().getString(R.string.GRider_call_Cancel_zEeS);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st….GRider_call_Cancel_zEeS)");
        String string3 = getResources().getString(R.string.GRider_call_Confirmation_NsHE);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…r_call_Confirmation_NsHE)");
        LEGOBaseDrawerModel lEGODrawerModel1 = new LEGODrawerModel1(string, new LEGOBtnTextAndCallback(string3, new AddPassengerActivity$showPopRemindNoSeat$model$1(this)));
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(string2, new AddPassengerActivity$showPopRemindNoSeat$butCancel$1(this)));
        lEGODrawerModel1.setSubTitle(getResources().getString(R.string.GRider_call_If_the_Krmm));
        this.f17920A = LEGOUICreator.showDrawerTemplate(this, lEGODrawerModel1);
        m15233l();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m15230i() {
        int i;
        int[] measureWidthAndHeight;
        int[] measureWidthAndHeight2;
        Context context = this;
        int i2 = 0;
        Object obj = SPUtils.get(context, this.f17943w, false);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } else if (!((Boolean) obj).booleanValue()) {
            LEGOBubble.Builder builder = new LEGOBubble.Builder(context);
            builder.setDirection("bottom_right");
            builder.setBgColor(ResourcesHelper.getColor(context, R.color.g_color_5C6166));
            String str = this.f17942v;
            if (str != null) {
                builder.setText(str);
            }
            builder.setCloseBtnVisible(false);
            builder.setTextProps(14, 1, 1);
            builder.setWidthAndHeight(-2, -2);
            LEGOBubble build = builder.build();
            this.f17944x = build;
            if (build == null || (measureWidthAndHeight2 = build.getMeasureWidthAndHeight()) == null) {
                i = 0;
            } else {
                i = measureWidthAndHeight2[1];
            }
            LEGOBubble lEGOBubble = this.f17944x;
            if (!(lEGOBubble == null || (measureWidthAndHeight = lEGOBubble.getMeasureWidthAndHeight()) == null)) {
                i2 = measureWidthAndHeight[0];
            }
            builder.setContentViewOnClick(new AddPassengerActivity$showBubble$2(this));
            try {
                int dimensionPixelSize = i + ResourcesHelper.getDimensionPixelSize(this, R.dimen.bubble_address_book_bottom);
                int dimensionPixelOffset = (-i2) + getResources().getDimensionPixelOffset(R.dimen.lego_bubble_default_offset) + UIUtils.dip2pxInt(this, 15.5f) + 20;
                LEGOBubble lEGOBubble2 = this.f17944x;
                if (lEGOBubble2 != null) {
                    lEGOBubble2.show(this.f17933m, dimensionPixelOffset, -dimensionPixelSize);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle bundleExtra;
        Serializable serializable;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == this.f17939s && intent != null && (bundleExtra = intent.getBundleExtra("data")) != null && (serializable = bundleExtra.getSerializable("list")) != null) {
            try {
                m15220a((ArrayList<GCommonContactsModel>) (ArrayList) serializable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m15231j();
        hideLoading();
        LoginEventHandler.setCountryCodeSelectListener((LoginEventHandler.CountryCodeSelectListener) null);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Confirm.EVENT_SUBSTITUTE_CALL_REFRESH, this.f17946z, ErrorObject.class);
    }

    /* renamed from: j */
    private final void m15231j() {
        LEGOBubble lEGOBubble = this.f17944x;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            LEGOBubble lEGOBubble2 = this.f17944x;
            if (lEGOBubble2 != null) {
                lEGOBubble2.dismiss();
            }
            this.f17944x = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m15224c(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, str2);
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "write_rider_page");
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: k */
    private final void m15232k() {
        Map hashMap = new HashMap();
        hashMap.put("k", "access");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "write_rider_page");
        GlobalOmegaUtils.trackEvent("ibt_gp_write_rider_page_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: l */
    private final void m15233l() {
        Map hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put(RavenKey.VERSION, "interpret_pop");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "write_rider_page");
        GlobalOmegaUtils.trackEvent("ibt_gp_interpret_pop_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: m */
    private final void m15234m() {
        LottieAnimationView lottieAnimationView = this.f17945y;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(-1);
        }
        LottieAnimationView lottieAnimationView2 = this.f17945y;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
        TextView textView = this.f17929i;
        if (textView != null) {
            textView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView3 = this.f17945y;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.playAnimation();
        }
    }

    public final void hideLoading() {
        LottieAnimationView lottieAnimationView = this.f17945y;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
            if (lottieAnimationView.isAnimating()) {
                lottieAnimationView.cancelAnimation();
            }
        }
        TextView textView = this.f17929i;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public final void setupUI(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new AddPassengerActivity$setupUI$1(this));
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                while (true) {
                    int i2 = i + 1;
                    View childAt = viewGroup.getChildAt(i);
                    Intrinsics.checkNotNullExpressionValue(childAt, "innerView");
                    setupUI(childAt);
                    if (i2 < childCount) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15215a(Activity activity) {
        Object systemService = activity.getSystemService("input_method");
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            EditText editText = this.f17923c;
            if (editText != null && editText.hasFocus()) {
                editText.clearFocus();
            }
            EditText editText2 = this.f17922b;
            if (editText2 != null && editText2.hasFocus()) {
                editText2.clearFocus();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
