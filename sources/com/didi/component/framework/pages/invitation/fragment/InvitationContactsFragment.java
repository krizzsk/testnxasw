package com.didi.component.framework.pages.invitation.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.framework.pages.invitation.helper.INoInvite;
import com.didi.component.framework.pages.invitation.model.InviteContactInfo;
import com.didi.component.framework.pages.invitation.presenter.InvitationContactsAdapter;
import com.didi.component.framework.pages.invitation.presenter.InvitationContactsPresenter;
import com.didi.component.framework.pages.invitation.view.IInvitationContactsView;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.callback.intercept.IShareDialogIntercept;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sharesdk.OneKeyShareModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J&\u0010$\u001a\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0016\u0010+\u001a\u00020\u001d2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0016J\u0018\u0010/\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u00100\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u00102\u001a\u00020\u001dH\u0016J\u0018\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u0018H\u0016J\b\u00106\u001a\u00020\u001dH\u0016J\b\u00107\u001a\u00020\u001dH\u0016J\"\u00108\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u00182\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010;\u001a\u00020\u001d2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, mo148868d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationContactsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/didi/component/framework/pages/invitation/view/IInvitationContactsView;", "()V", "activityId", "", "contentTv", "Landroid/widget/TextView;", "editTv", "Landroid/widget/EditText;", "mAdapter", "Lcom/didi/component/framework/pages/invitation/presenter/InvitationContactsAdapter;", "mListener", "Lcom/didi/component/framework/pages/invitation/fragment/IInvitationListener;", "mPresenter", "Lcom/didi/component/framework/pages/invitation/presenter/InvitationContactsPresenter;", "mRootView", "Landroid/view/View;", "recView", "Landroidx/recyclerview/widget/RecyclerView;", "titleTv", "createContentSpanner", "Landroid/text/SpannableString;", "text", "", "count", "createTitleSpnner", "maxReward", "hideLoadingView", "", "init", "initEditText", "initHeadView", "", "validFriends", "initRecView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "refreRecView", "data", "", "Lcom/didi/component/framework/pages/invitation/model/InviteContactInfo;", "setMaxRewardAndValidFriend", "setPresenter", "p0", "showDefalutView", "showErrorDialog", "msg", "title", "showLoadingTips", "showLoadingView", "showNoInvitationDialog", "listener", "Lcom/didi/component/framework/pages/invitation/helper/INoInvite;", "showShareDialog", "smsChannel", "Lcom/didi/sharesdk/OneKeyShareModel;", "trackItemClicked", "phoneNum", "Companion", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: InvitationContactsFragment.kt */
public final class InvitationContactsFragment extends Fragment implements IInvitationContactsView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private View f15647a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IInvitationListener f15648b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public InvitationContactsPresenter f15649c;

    /* renamed from: d */
    private InvitationContactsAdapter f15650d;

    /* renamed from: e */
    private TextView f15651e;

    /* renamed from: f */
    private TextView f15652f;

    /* renamed from: g */
    private EditText f15653g;

    /* renamed from: h */
    private RecyclerView f15654h;

    /* renamed from: i */
    private long f15655i;

    public void _$_clearFindViewByIdCache() {
    }

    public void setPresenter(InvitationContactsPresenter invitationContactsPresenter) {
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationContactsFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: InvitationContactsFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(Bundle bundle) {
            InvitationContactsFragment invitationContactsFragment = new InvitationContactsFragment();
            invitationContactsFragment.setArguments(bundle);
            return invitationContactsFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.f15647a = layoutInflater.inflate(R.layout.global_fragment_invite_contacts_new, viewGroup, false);
        m12970a();
        return this.f15647a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: androidx.appcompat.widget.AppCompatTextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: androidx.appcompat.widget.AppCompatTextView} */
    /* JADX WARNING: type inference failed for: r0v15, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m12970a() {
        /*
            r3 = this;
            com.didi.component.framework.pages.invitation.presenter.InvitationContactsPresenter r0 = new com.didi.component.framework.pages.invitation.presenter.InvitationContactsPresenter
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r2 = "activity!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.Context r1 = (android.content.Context) r1
            r0.<init>(r1)
            r3.f15649c = r0
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 == 0) goto L_0x0092
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r0 = (com.didi.component.framework.pages.invitation.fragment.IInvitationListener) r0
            r3.f15648b = r0
            android.os.Bundle r0 = r3.getArguments()
            if (r0 != 0) goto L_0x0028
            r0 = 0
            goto L_0x002e
        L_0x0028:
            java.lang.String r1 = "activityId"
            long r0 = r0.getLong(r1)
        L_0x002e:
            r3.f15655i = r0
            com.didi.component.framework.pages.invitation.presenter.InvitationContactsPresenter r0 = r3.f15649c
            if (r0 != 0) goto L_0x0035
            goto L_0x003b
        L_0x0035:
            r1 = r3
            com.didi.component.core.IView r1 = (com.didi.component.core.IView) r1
            r0.setIView(r1)
        L_0x003b:
            android.view.View r0 = r3.f15647a
            r1 = 0
            if (r0 != 0) goto L_0x0042
            r0 = r1
            goto L_0x004b
        L_0x0042:
            r2 = 2131431639(0x7f0b10d7, float:1.8485013E38)
            android.view.View r0 = r0.findViewById(r2)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
        L_0x004b:
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3.f15651e = r0
            android.view.View r0 = r3.f15647a
            if (r0 != 0) goto L_0x0055
            r0 = r1
            goto L_0x005e
        L_0x0055:
            r2 = 2131431627(0x7f0b10cb, float:1.8484989E38)
            android.view.View r0 = r0.findViewById(r2)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
        L_0x005e:
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3.f15652f = r0
            android.view.View r0 = r3.f15647a
            if (r0 != 0) goto L_0x0067
            goto L_0x0071
        L_0x0067:
            r1 = 2131431629(0x7f0b10cd, float:1.8484993E38)
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.EditText r1 = (android.widget.EditText) r1
        L_0x0071:
            r3.f15653g = r1
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r0 = r3.f15648b
            if (r0 != 0) goto L_0x0078
            goto L_0x008b
        L_0x0078:
            android.content.Context r1 = r3.getContext()
            r2 = 2131953207(0x7f130637, float:1.9542878E38)
            java.lang.String r1 = com.didi.sdk.util.ResourcesHelper.getString(r1, r2)
            java.lang.String r2 = "getString(\n             …person_hBMs\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.setTitlteBar(r1)
        L_0x008b:
            r3.m12978c()
            r3.m12977b()
            return
        L_0x0092:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type com.didi.component.framework.pages.invitation.fragment.IInvitationListener"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment.m12970a():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r0 = (r0 = (r0 = r0.getPageInfo()).getRewardModel()).getCurrencyFirst();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m12971a(int r7, int r8) {
        /*
            r6 = this;
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r0 = r6.f15648b
            r1 = 0
            if (r0 != 0) goto L_0x0007
        L_0x0005:
            r0 = 0
            goto L_0x0020
        L_0x0007:
            com.didi.component.framework.pages.invitation.model.PageData r0 = r0.getPageInfo()
            if (r0 != 0) goto L_0x000e
            goto L_0x0005
        L_0x000e:
            com.didi.component.framework.pages.invitation.model.RewardModel r0 = r0.getRewardModel()
            if (r0 != 0) goto L_0x0015
            goto L_0x0005
        L_0x0015:
            java.lang.Boolean r0 = r0.getCurrencyFirst()
            if (r0 != 0) goto L_0x001c
            goto L_0x0005
        L_0x001c:
            boolean r0 = r0.booleanValue()
        L_0x0020:
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r2 = r6.f15648b
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0028
        L_0x0026:
            r2 = r3
            goto L_0x003d
        L_0x0028:
            com.didi.component.framework.pages.invitation.model.PageData r2 = r2.getPageInfo()
            if (r2 != 0) goto L_0x002f
            goto L_0x0026
        L_0x002f:
            com.didi.component.framework.pages.invitation.model.RedirectModel r2 = r2.getRedirectModel()
            if (r2 != 0) goto L_0x0036
            goto L_0x0026
        L_0x0036:
            java.lang.String r2 = r2.getCurrencySymbol()
            if (r2 != 0) goto L_0x003d
            goto L_0x0026
        L_0x003d:
            if (r0 != 0) goto L_0x0048
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r7)
            goto L_0x0057
        L_0x0048:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r2)
            java.lang.String r7 = r0.toString()
        L_0x0057:
            android.content.Context r0 = r6.getContext()
            r2 = 1
            if (r0 != 0) goto L_0x0060
        L_0x005e:
            r0 = r3
            goto L_0x0075
        L_0x0060:
            android.content.res.Resources r0 = r0.getResources()
            if (r0 != 0) goto L_0x0067
            goto L_0x005e
        L_0x0067:
            r4 = 2131953239(0x7f130657, float:1.9542943E38)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r7
            java.lang.String r0 = r0.getString(r4, r5)
            if (r0 != 0) goto L_0x0075
            goto L_0x005e
        L_0x0075:
            android.widget.TextView r4 = r6.f15651e
            if (r4 != 0) goto L_0x007a
            goto L_0x0083
        L_0x007a:
            android.text.SpannableString r7 = r6.m12969a((java.lang.String) r0, (java.lang.String) r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r4.setText(r7)
        L_0x0083:
            android.content.Context r7 = r6.getContext()
            if (r7 != 0) goto L_0x008a
            goto L_0x00a4
        L_0x008a:
            android.content.res.Resources r7 = r7.getResources()
            if (r7 != 0) goto L_0x0091
            goto L_0x00a4
        L_0x0091:
            r0 = 2131953245(0x7f13065d, float:1.9542956E38)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = java.lang.String.valueOf(r8)
            r2[r1] = r4
            java.lang.String r7 = r7.getString(r0, r2)
            if (r7 != 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r3 = r7
        L_0x00a4:
            android.widget.TextView r7 = r6.f15652f
            if (r7 != 0) goto L_0x00a9
            goto L_0x00b6
        L_0x00a9:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            android.text.SpannableString r8 = r6.m12976b(r3, r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment.m12971a(int, int):void");
    }

    /* renamed from: a */
    private final SpannableString m12969a(String str, String str2) {
        CharSequence charSequence = str;
        SpannableString spannableString = new SpannableString(charSequence);
        int indexOf$default = StringsKt.indexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFE7F3F")), indexOf$default, str2.length() + indexOf$default, 34);
        spannableString.setSpan(new AbsoluteSizeSpan(26, true), indexOf$default, str2.length() + indexOf$default, 34);
        return spannableString;
    }

    /* renamed from: b */
    private final SpannableString m12976b(String str, String str2) {
        CharSequence charSequence = str;
        SpannableString spannableString = new SpannableString(charSequence);
        int indexOf$default = StringsKt.indexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF333333")), indexOf$default, str2.length() + indexOf$default, 34);
        spannableString.setSpan(new AbsoluteSizeSpan(16, true), indexOf$default, str2.length() + indexOf$default, 34);
        return spannableString;
    }

    /* renamed from: b */
    private final void m12977b() {
        EditText editText = this.f15653g;
        if (editText != null) {
            editText.setVisibility(0);
        }
        EditText editText2 = this.f15653g;
        if (editText2 != null) {
            editText2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    InvitationContactsFragment.m12972a(InvitationContactsFragment.this, view);
                }
            });
        }
        EditText editText3 = this.f15653g;
        if (editText3 != null) {
            editText3.addTextChangedListener(new InvitationContactsFragment$initEditText$2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m12972a(InvitationContactsFragment invitationContactsFragment, View view) {
        Intrinsics.checkNotNullParameter(invitationContactsFragment, "this$0");
        GlobalOmegaUtils.trackEvent("gp_PromoCode_Concats_search_ck", "activity_id", String.valueOf(invitationContactsFragment.f15655i));
    }

    /* renamed from: c */
    private final void m12978c() {
        View view = this.f15647a;
        this.f15654h = view == null ? null : (RecyclerView) view.findViewById(R.id.invite_contacts_rec);
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        InvitationContactsAdapter invitationContactsAdapter = new InvitationContactsAdapter(context);
        this.f15650d = invitationContactsAdapter;
        if (invitationContactsAdapter != null) {
            invitationContactsAdapter.setInviteBtnClickedListener(new InvitationContactsFragment$initRecView$1(this));
        }
        InvitationContactsAdapter invitationContactsAdapter2 = this.f15650d;
        if (invitationContactsAdapter2 != null) {
            invitationContactsAdapter2.setMData(new ArrayList());
        }
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context2, 1, false);
        RecyclerView recyclerView = this.f15654h;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f15650d);
        }
        RecyclerView recyclerView2 = this.f15654h;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12975a(String str, String str2, INoInvite iNoInvite) {
        IInvitationListener iInvitationListener = this.f15648b;
        if (iInvitationListener != null) {
            iInvitationListener.showNoInvitationDialog(str, str2, iNoInvite);
        }
    }

    public void showDefalutView() {
        TextView textView = this.f15651e;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f15652f;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        EditText editText = this.f15653g;
        if (editText != null) {
            editText.setVisibility(8);
        }
        View view = this.f15647a;
        ImageView imageView = null;
        View findViewById = view == null ? null : view.findViewById(R.id.invite_contacts_defaulte_layout);
        View view2 = this.f15647a;
        AppCompatTextView appCompatTextView = view2 == null ? null : (AppCompatTextView) view2.findViewById(R.id.invite_no_invitations_title);
        View view3 = this.f15647a;
        if (view3 != null) {
            imageView = (ImageView) view3.findViewById(R.id.invite_no_invitations_icon);
        }
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        if (imageView != null) {
            imageView.setImageResource(R.drawable.global_invite_no_contacts);
        }
        if (appCompatTextView != null) {
            appCompatTextView.setText(ResourcesHelper.getString(getContext(), R.string.Global_Rider_MgM_new_campaign_page_Contacts_FJCU));
        }
    }

    public void setMaxRewardAndValidFriend(int i, int i2) {
        if (i == 0 || i2 == 0) {
            TextView textView = this.f15651e;
            if (textView != null) {
                textView.setVisibility(8);
            }
            EditText editText = this.f15653g;
            if (editText != null) {
                editText.setVisibility(0);
            }
            TextView textView2 = this.f15652f;
            ViewGroup.LayoutParams layoutParams = textView2 == null ? null : textView2.getLayoutParams();
            if (layoutParams != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = UiUtils.dip2px(getContext(), 20.0f);
                TextView textView3 = this.f15652f;
                if (textView3 != null) {
                    textView3.setLayoutParams(layoutParams2);
                }
                TextView textView4 = this.f15652f;
                if (textView4 != null) {
                    textView4.setText(ResourcesHelper.getString(getContext(), R.string.Global_Rider_MgM_new_campaign_page_Contact_social_pdoj));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        m12971a(i, i2);
    }

    public void showLoadingTips() {
        TextView textView = this.f15651e;
        if (textView != null) {
            textView.setText(ResourcesHelper.getString(getContext(), R.string.Global_Rider_MgM_new_campaign_page_contacts_Wait_load_mRNK));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12973a(OneKeyShareModel oneKeyShareModel) {
        String str;
        String str2;
        String str3;
        ShareInfo shareInfo = new ShareInfo();
        if (oneKeyShareModel == null) {
            str = null;
        } else {
            str = oneKeyShareModel.title;
        }
        shareInfo.title = str;
        if (oneKeyShareModel == null) {
            str2 = null;
        } else {
            str2 = oneKeyShareModel.content;
        }
        shareInfo.content = str2;
        shareInfo.type = IShareDialogIntercept.SYSTEM_SHARE_DIALOG;
        if (oneKeyShareModel == null) {
            str3 = null;
        } else {
            str3 = oneKeyShareModel.url;
        }
        shareInfo.url = str3;
        shareInfo.platforms = CollectionsKt.mutableListOf(SharePlatform.SYSTEM_MESSAGE);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ShareBuilder.buildShare(activity, shareInfo, (ICallback.IPlatformShareCallback) null);
    }

    public void refreRecView(List<InviteContactInfo> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        InvitationContactsAdapter invitationContactsAdapter = this.f15650d;
        if (invitationContactsAdapter != null) {
            invitationContactsAdapter.updateListData(list);
        }
    }

    public void showLoadingView() {
        IInvitationListener iInvitationListener = this.f15648b;
        if (iInvitationListener != null) {
            iInvitationListener.showLoadingView();
        }
    }

    public void hideLoadingView() {
        IInvitationListener iInvitationListener = this.f15648b;
        if (iInvitationListener != null) {
            iInvitationListener.hideLoadingView();
        }
    }

    public void showErrorDialog(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(str2, "title");
        IInvitationListener iInvitationListener = this.f15648b;
        if (iInvitationListener != null) {
            iInvitationListener.showErrorDialog(str, str2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12974a(String str) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("activity_id", Long.valueOf(this.f15655i));
        if (str.length() > 4) {
            str = str.substring(str.length() - 4, str.length());
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        linkedHashMap.put("phone", str);
        GlobalOmegaUtils.trackEvent("gp_PromoCode_Concats_invite_ck", (Map<String, Object>) linkedHashMap);
    }
}
