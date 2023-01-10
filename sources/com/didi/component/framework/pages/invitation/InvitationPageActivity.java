package com.didi.component.framework.pages.invitation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.util.ApkUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.framework.pages.invitation.fragment.IInvitationListener;
import com.didi.component.framework.pages.invitation.fragment.InvitationBlankFragment;
import com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment;
import com.didi.component.framework.pages.invitation.fragment.InvitationNewPageFragment;
import com.didi.component.framework.pages.invitation.fragment.InvitationNoPermissonFragment;
import com.didi.component.framework.pages.invitation.fragment.InvitationPageFragment;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.component.framework.pages.invitation.helper.INoInvite;
import com.didi.component.framework.pages.invitation.helper.InvitePageController;
import com.didi.component.framework.pages.invitation.helper.InvitePageInterceptor;
import com.didi.component.framework.pages.invitation.model.InviteListModel;
import com.didi.component.framework.pages.invitation.model.InviteTheme;
import com.didi.component.framework.pages.invitation.model.PageData;
import com.didi.global.loading.app.AbsLoadingActivity;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.sdk.webview.WebTitleBar;
import com.didi.sharesdk.OneKeyShareModel;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0018H\u0002J\b\u00102\u001a\u00020\u0018H\u0016J\n\u00103\u001a\u0004\u0018\u000104H\u0016J\n\u00105\u001a\u0004\u0018\u00010!H\u0016J\n\u00106\u001a\u0004\u0018\u00010'H\u0016J\n\u00107\u001a\u0004\u0018\u00010*H\u0016J\n\u00108\u001a\u0004\u0018\u00010,H\u0016J\b\u00109\u001a\u00020\u0018H\u0016J\b\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u0005H\u0002J\b\u0010>\u001a\u00020;H\u0002J\b\u0010?\u001a\u00020;H\u0002J\b\u0010@\u001a\u00020\u0018H\u0016J\b\u0010A\u001a\u00020;H\u0016J\u0012\u0010B\u001a\u00020;2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J \u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0018H\u0002J\u0012\u0010I\u001a\u00020;2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010J\u001a\u00020;2\u0006\u0010K\u001a\u00020\tH\u0016J\u0018\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0016J\b\u0010N\u001a\u00020;H\u0002J\b\u0010O\u001a\u00020;H\u0016J\"\u0010P\u001a\u00020;2\u0006\u0010M\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020;H\u0002J\b\u0010T\u001a\u00020;H\u0002J\b\u0010U\u001a\u00020;H\u0002J\b\u0010V\u001a\u00020;H\u0002J\u0012\u0010W\u001a\u00020;2\b\b\u0002\u0010X\u001a\u00020\u0018H\u0002J\b\u0010Y\u001a\u00020;H\u0002J\u0010\u0010Z\u001a\u00020;2\u0006\u0010[\u001a\u00020\tH\u0016J\u0018\u0010\\\u001a\u00020;2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u0007H\u0002J \u0010_\u001a\u00020;2\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\n \n*\u0004\u0018\u00010\t0\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020$0#j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020$`%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, mo148868d2 = {"Lcom/didi/component/framework/pages/invitation/InvitationPageActivity;", "Lcom/didi/global/loading/app/AbsLoadingActivity;", "Lcom/didi/component/framework/pages/invitation/fragment/IInvitationListener;", "()V", "activityId", "", "channel", "", "cityName", "", "kotlin.jvm.PlatformType", "controller", "Lcom/didi/component/framework/pages/invitation/helper/InvitePageController;", "getController", "()Lcom/didi/component/framework/pages/invitation/helper/InvitePageController;", "controller$delegate", "Lkotlin/Lazy;", "country", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager$delegate", "hasReward", "", "isGlobalVersion", "()Z", "isGlobalVersion$delegate", "isLunbo", "isNewPage", "isShareContact", "lastTime", "listDatas", "Lcom/didi/component/framework/pages/invitation/model/InviteListModel;", "logParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pageDatas", "Lcom/didi/component/framework/pages/invitation/model/PageData;", "resourceId", "shareInfo", "Lcom/didi/sharesdk/OneKeyShareModel;", "themeDatas", "Lcom/didi/component/framework/pages/invitation/model/InviteTheme;", "title", "totalCount", "canLoadMore", "currentCount", "checkAvailable", "checkContactsPermission", "getFallbackView", "Landroid/view/View;", "getListInfo", "getPageInfo", "getSystemShareInfo", "getThemeInfo", "hasRewards", "hideLoadingView", "", "initRecommendInfo", "resourceChannel", "initTitleBar", "initTitleText", "isGlobal", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshAndGetList", "isTop", "currentPage", "isLoadingMore", "setSystemShareInfo", "setTitlteBar", "text", "showErrorDialog", "msg", "showErrorView", "showLoadingView", "showNoInvitationDialog", "listener", "Lcom/didi/component/framework/pages/invitation/helper/INoInvite;", "switchToContacts", "switchToContactsNoBack", "switchToInviteBlank", "switchToInviteHome", "switchToInviteTrack", "isTopPage", "switchToPermisson", "switchToTargetPage", "tag", "trackEvent", "coastTime", "pageNo", "updateContactsList", "Companion", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: InvitationPageActivity.kt */
public final class InvitationPageActivity extends AbsLoadingActivity implements IInvitationListener {
    public static final String ACTIVITY_ID = "activityId";
    public static final String BLANK = "blank";
    public static final String CHANNEL = "channel";
    public static final String CITY_NAME = "cityName";
    public static final String CONTACTS = "contacts";
    public static final String CONTACTS_NOBACK = "contactsNoBack";
    public static final String COUNTRY = "country";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HOME = "home";
    public static final String LOG_PARAMS = "logParams";
    public static final String PERMISSION = "permisson";
    public static final String RESOURCE_ID = "resourceId";
    public static final String SHOW_BANNER = "showBanner";
    public static final String SHOW_CONTACTS = "showContacts";
    public static final String SHOW_NEWPAGE = "showNewPage";
    public static final String TAG = "PromoCodeActivity";
    public static final String TRACK = "track";

    /* renamed from: a */
    private final Lazy f15626a = LazyKt.lazy(new InvitationPageActivity$fragmentManager$2(this));

    /* renamed from: b */
    private final Lazy f15627b = LazyKt.lazy(new InvitationPageActivity$controller$2(this));

    /* renamed from: c */
    private final Lazy f15628c = LazyKt.lazy(new InvitationPageActivity$isGlobalVersion$2(this));
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f15629d = NationTypeUtil.getNationComponentData().getLocCountry();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f15630e = NationTypeUtil.getNationComponentData().getCityId();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f15631f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PageData f15632g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public InviteTheme f15633h;

    /* renamed from: i */
    private long f15634i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f15635j;

    /* renamed from: k */
    private int f15636k = 2;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f15637l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f15638m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public HashMap<String, Object> f15639n = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f15640o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f15641p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f15642q;

    /* renamed from: r */
    private OneKeyShareModel f15643r;

    /* renamed from: s */
    private String f15644s = "";
    /* access modifiers changed from: private */

    /* renamed from: t */
    public InviteListModel f15645t;

    public void _$_clearFindViewByIdCache() {
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/component/framework/pages/invitation/InvitationPageActivity$Companion;", "", "()V", "ACTIVITY_ID", "", "BLANK", "CHANNEL", "CITY_NAME", "CONTACTS", "CONTACTS_NOBACK", "COUNTRY", "HOME", "LOG_PARAMS", "PERMISSION", "RESOURCE_ID", "SHOW_BANNER", "SHOW_CONTACTS", "SHOW_NEWPAGE", "TAG", "TRACK", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: InvitationPageActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final FragmentManager m12950a() {
        return (FragmentManager) this.f15626a.getValue();
    }

    /* renamed from: b */
    private final InvitePageController m12957b() {
        return (InvitePageController) this.f15627b.getValue();
    }

    /* renamed from: c */
    private final boolean m12959c() {
        return ((Boolean) this.f15628c.getValue()).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.global_activity_invite);
        try {
            StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        } catch (Exception e) {
            GLog.m11358e(TAG, "StatusBarLightingCompat.setStatusBarBgLightning", e);
        }
        m12960d();
        if (m12967k()) {
            m12951a(this.f15634i);
        }
    }

    /* renamed from: d */
    private final void m12960d() {
        String str;
        String stringExtra;
        Intent intent = getIntent();
        long j = -1;
        if (intent != null) {
            j = intent.getLongExtra(InvitePageInterceptor.RESOURCE_ID, -1);
        }
        this.f15634i = j;
        Intent intent2 = getIntent();
        String str2 = "";
        if (!(intent2 == null || (stringExtra = intent2.getStringExtra("title")) == null)) {
            str2 = stringExtra;
        }
        this.f15644s = str2;
        CharSequence charSequence = str2;
        boolean z = true;
        this.f15636k = !(charSequence == null || charSequence.length() == 0) ? 1 : 2;
        WebTitleBar webTitleBar = (WebTitleBar) findViewById(R.id.invite_page_title);
        if (webTitleBar != null) {
            CharSequence charSequence2 = this.f15644s;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (!z) {
                str = this.f15644s;
            } else {
                str = ResourcesHelper.getString(this, R.string.global_invite_free_ride);
            }
            webTitleBar.setTitle(str);
        }
        WebTitleBar webTitleBar2 = (WebTitleBar) findViewById(R.id.invite_page_title);
        TextView textView = null;
        TextView middleTv = webTitleBar2 == null ? null : webTitleBar2.getMiddleTv();
        if (middleTv != null) {
            middleTv.setTypeface(Typeface.DEFAULT_BOLD);
        }
        WebTitleBar webTitleBar3 = (WebTitleBar) findViewById(R.id.invite_page_title);
        if (webTitleBar3 != null) {
            textView = webTitleBar3.getMiddleTv();
        }
        if (textView != null) {
            textView.setTextSize(21.0f);
        }
        WebTitleBar webTitleBar4 = (WebTitleBar) findViewById(R.id.invite_page_title);
        if (webTitleBar4 != null) {
            webTitleBar4.setCloseBtnVisibility(8);
        }
        WebTitleBar webTitleBar5 = (WebTitleBar) findViewById(R.id.invite_page_title);
        if (webTitleBar5 != null) {
            webTitleBar5.setMoreBtnVisibility(8);
        }
        WebTitleBar webTitleBar6 = (WebTitleBar) findViewById(R.id.invite_page_title);
        if (webTitleBar6 != null) {
            webTitleBar6.setBackBtnVisibility(0);
        }
        WebTitleBar webTitleBar7 = (WebTitleBar) findViewById(R.id.invite_page_title);
        if (webTitleBar7 != null) {
            webTitleBar7.setOnBackClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    InvitationPageActivity.m12953a(InvitationPageActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m12953a(InvitationPageActivity invitationPageActivity, View view) {
        Intrinsics.checkNotNullParameter(invitationPageActivity, "this$0");
        super.onBackPressed();
        invitationPageActivity.m12961e();
    }

    public void onBackPressed() {
        super.onBackPressed();
        m12961e();
    }

    /* renamed from: e */
    private final void m12961e() {
        String str;
        WebTitleBar webTitleBar = (WebTitleBar) findViewById(R.id.invite_page_title);
        if (webTitleBar != null) {
            CharSequence charSequence = this.f15644s;
            if (!(charSequence == null || charSequence.length() == 0)) {
                str = this.f15644s;
            } else {
                str = ResourcesHelper.getString(this, R.string.global_invite_free_ride);
            }
            webTitleBar.setTitle(str);
        }
    }

    public void switchToTargetPage(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        if (m12950a().findFragmentByTag(str) == null) {
            switch (str.hashCode()) {
                case -794804101:
                    if (str.equals(CONTACTS_NOBACK)) {
                        m12963g();
                        return;
                    }
                    break;
                case -567451565:
                    if (str.equals(CONTACTS)) {
                        m12962f();
                        return;
                    }
                    break;
                case 3208415:
                    if (str.equals("home")) {
                        m12965i();
                        return;
                    }
                    break;
                case 93819220:
                    if (str.equals(BLANK)) {
                        m12966j();
                        return;
                    }
                    break;
                case 676039480:
                    if (str.equals(PERMISSION)) {
                        m12964h();
                        return;
                    }
                    break;
            }
            m12954a(this, false, 1, (Object) null);
        }
    }

    /* renamed from: f */
    private final void m12962f() {
        hideLoadingView();
        if (m12950a().findFragmentByTag(CONTACTS) == null) {
            Bundle bundle = new Bundle();
            bundle.putLong("activityId", this.f15635j);
            m12950a().beginTransaction().replace(R.id.invite_container, InvitationContactsFragment.Companion.newInstance(bundle), CONTACTS).addToBackStack((String) null).commit();
        }
    }

    /* renamed from: g */
    private final void m12963g() {
        if (m12950a().findFragmentByTag(CONTACTS_NOBACK) == null) {
            Bundle bundle = new Bundle();
            bundle.putLong("activityId", this.f15635j);
            m12950a().beginTransaction().replace(R.id.invite_container, InvitationContactsFragment.Companion.newInstance(bundle), CONTACTS_NOBACK).commit();
        }
    }

    /* renamed from: h */
    private final void m12964h() {
        if (m12950a().findFragmentByTag(PERMISSION) == null) {
            Bundle bundle = new Bundle();
            bundle.putLong("activityId", this.f15635j);
            m12950a().beginTransaction().replace(R.id.invite_container, InvitationNoPermissonFragment.Companion.newInstance(bundle), PERMISSION).addToBackStack((String) null).commit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m12965i() {
        Fragment fragment;
        hideLoadingView();
        if (m12950a().findFragmentByTag("home") == null) {
            Bundle bundle = new Bundle();
            bundle.putString("country", this.f15629d);
            bundle.putLong(RESOURCE_ID, this.f15634i);
            bundle.putLong("activityId", this.f15635j);
            bundle.putInt("channel", this.f15636k);
            bundle.putString(CITY_NAME, this.f15630e);
            bundle.putSerializable(LOG_PARAMS, this.f15639n);
            if (this.f15640o) {
                bundle.putBoolean(SHOW_BANNER, this.f15641p);
                bundle.putBoolean(SHOW_CONTACTS, this.f15642q);
                fragment = InvitationNewPageFragment.Companion.newInstance(bundle);
            } else {
                fragment = InvitationPageFragment.Companion.newInstance(bundle);
            }
            m12950a().beginTransaction().add(R.id.invite_container, fragment, "home").commitAllowingStateLoss();
        }
    }

    /* renamed from: j */
    private final void m12966j() {
        hideLoadingView();
        if (m12950a().findFragmentByTag(BLANK) == null) {
            m12950a().beginTransaction().add(R.id.invite_container, InvitationBlankFragment.Companion.newInstance((Bundle) null), BLANK).commit();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m12954a(InvitationPageActivity invitationPageActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        invitationPageActivity.m12955a(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12955a(boolean z) {
        hideLoadingView();
        if (m12950a().findFragmentByTag(TRACK) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(InvitationTrackFragment.isTop, z);
            bundle.putString("country", this.f15629d);
            bundle.putLong(RESOURCE_ID, this.f15634i);
            bundle.putLong("activityId", this.f15635j);
            bundle.putInt("channel", this.f15636k);
            bundle.putString(CITY_NAME, this.f15630e);
            bundle.putBoolean(SHOW_NEWPAGE, this.f15640o);
            Fragment newInstance = InvitationTrackFragment.Companion.newInstance(bundle);
            if (z) {
                m12950a().beginTransaction().add(R.id.invite_container, newInstance, TRACK).commit();
            } else {
                m12950a().beginTransaction().replace(R.id.invite_container, newInstance, TRACK).addToBackStack((String) null).commit();
            }
        }
    }

    /* renamed from: a */
    private final void m12951a(long j) {
        showLoadingView();
        this.f15638m = SystemClock.elapsedRealtime();
        m12957b().refreshInvitePage(new InvitationPageActivity$initRecommendInfo$1(this), j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12956a(boolean z, long j, boolean z2) {
        long j2 = j;
        m12957b().refreshInviteList(new InvitationPageActivity$refreshAndGetList$1(this, z, z2, SystemClock.elapsedRealtime()), j2, GlobalApolloUtil.getInvitePageTrackNumber());
    }

    /* renamed from: k */
    private final boolean m12967k() {
        if (!NationComponentDataUtil.isLoginNow()) {
            String string = ResourcesHelper.getString(this, R.string.global_invite_code_un_login);
            Intrinsics.checkNotNullExpressionValue(string, "getString(this, R.string…bal_invite_code_un_login)");
            IInvitationListener.DefaultImpls.showErrorDialog$default(this, string, (String) null, 2, (Object) null);
            return false;
        } else if (NationComponentDataUtil.getLastKnownLocation() != null) {
            return true;
        } else {
            Context context = this;
            String string2 = ResourcesHelper.getString(context, R.string.global_invite_code_service, ApkUtils.getAppName(context));
            Intrinsics.checkNotNullExpressionValue(string2, "msg");
            String string3 = ResourcesHelper.getString(context, R.string.global_unknown_location);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(this, R.string.global_unknown_location)");
            showErrorDialog(string2, string3);
            return false;
        }
    }

    public boolean checkContactsPermission() {
        return ContextCompat.checkSelfPermission(this, Permission.READ_CONTACTS) == 0;
    }

    public void showErrorDialog(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(str2, "title");
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this);
        builder.setCancelable(false);
        CharSequence charSequence = str2;
        if (charSequence.length() > 0) {
            builder.setTitle(charSequence);
        }
        builder.setCloseVisible(false);
        builder.setSupprtMullineTitle(true);
        builder.setIcon(AlertController.IconType.INFO);
        builder.setMessage(str);
        builder.setPositiveButton((int) R.string.fine);
        builder.setPositiveButtonDefault();
        AlertDialogFragment create = builder.create();
        if (create != null) {
            create.show(m12950a(), (String) null);
        }
    }

    public void showNoInvitationDialog(String str, String str2, INoInvite iNoInvite) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(str2, "title");
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this);
        CharSequence charSequence = str2;
        if (charSequence.length() > 0) {
            builder.setTitle(charSequence);
        }
        builder.setCloseVisible(false);
        builder.setSupprtMullineTitle(true);
        builder.setIcon(AlertController.IconType.INFO);
        builder.setMessage(str);
        builder.setNeutralButton((int) R.string.global_waypoint_alert_confirm, (AlertDialogFragment.OnClickListener) new InvitationPageActivity$showNoInvitationDialog$1(iNoInvite));
        AlertDialogFragment create = builder.create();
        if (create != null) {
            create.show(m12950a(), (String) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m12968l() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.invite_page_error_view);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = (TextView) findViewById(R.id.invite_page_reload);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    InvitationPageActivity.m12958b(InvitationPageActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m12958b(InvitationPageActivity invitationPageActivity, View view) {
        Intrinsics.checkNotNullParameter(invitationPageActivity, "this$0");
        invitationPageActivity.m12951a(invitationPageActivity.f15634i);
        LinearLayout linearLayout = (LinearLayout) invitationPageActivity.findViewById(R.id.invite_page_error_view);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12952a(long j, int i) {
        Map hashMap = new HashMap();
        hashMap.put("load_time", Long.valueOf(j));
        hashMap.put("pageNo", Integer.valueOf(i));
        GlobalOmegaUtils.trackEvent("gp_invitepage_time", (Map<String, Object>) hashMap);
    }

    public void setSystemShareInfo(OneKeyShareModel oneKeyShareModel) {
        this.f15643r = oneKeyShareModel;
    }

    public OneKeyShareModel getSystemShareInfo() {
        return this.f15643r;
    }

    public boolean canLoadMore(long j) {
        return j < this.f15631f;
    }

    public void updateContactsList(boolean z, long j, boolean z2) {
        m12956a(z, j, z2);
    }

    public void showLoadingView() {
        showLoading();
    }

    public void hideLoadingView() {
        hideLoading();
    }

    public View getFallbackView() {
        return (WebTitleBar) findViewById(R.id.invite_page_title);
    }

    public boolean isGlobal() {
        return m12959c();
    }

    public PageData getPageInfo() {
        return this.f15632g;
    }

    public InviteTheme getThemeInfo() {
        return this.f15633h;
    }

    public InviteListModel getListInfo() {
        return this.f15645t;
    }

    public boolean hasRewards() {
        return this.f15637l;
    }

    public void setTitlteBar(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        WebTitleBar webTitleBar = (WebTitleBar) findViewById(R.id.invite_page_title);
        if (webTitleBar != null) {
            webTitleBar.setTitle(str);
        }
    }
}
