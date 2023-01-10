package com.didi.payment.pix.contacts.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.p130ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.contacts.fragment.adapter.PhoneContactsAdapter;
import com.didi.payment.pix.contacts.p135vm.CustomContactsVM;
import com.didi.payment.pix.contacts.p135vm.model.PhoneContacts;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016J&\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u001fH\u0016J\u001a\u00101\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00062"}, mo148868d2 = {"Lcom/didi/payment/pix/contacts/fragment/CustomContactsFragment;", "Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "Lcom/didi/payment/pix/contacts/vm/CustomContactsVM;", "Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter$OnItemClickListener;", "()V", "adapter", "Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter;", "clearImg", "Landroid/view/View;", "contactLV", "Landroidx/recyclerview/widget/RecyclerView;", "getContactLV", "()Landroidx/recyclerview/widget/RecyclerView;", "setContactLV", "(Landroidx/recyclerview/widget/RecyclerView;)V", "logger", "Lcom/didi/sdk/logging/Logger;", "getLogger", "()Lcom/didi/sdk/logging/Logger;", "setLogger", "(Lcom/didi/sdk/logging/Logger;)V", "mTitleBar", "nameInputEt", "Landroid/widget/EditText;", "getNameInputEt", "()Landroid/widget/EditText;", "setNameInputEt", "(Landroid/widget/EditText;)V", "customErrorUI", "", "initCommonTitlebar", "", "commonTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initContentView", "view", "initViewModels", "onBackKeyPressed", "onContactClicked", "contacts", "Lcom/didi/payment/pix/contacts/vm/model/PhoneContacts;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomContactsFragment.kt */
public final class CustomContactsFragment extends AbsWBaseFragment<CustomContactsVM> implements PhoneContactsAdapter.OnItemClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f33564a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public PhoneContactsAdapter f33565b;

    /* renamed from: c */
    private View f33566c;
    public RecyclerView contactLV;

    /* renamed from: d */
    private Logger f33567d;
    public EditText nameInputEt;

    public CustomContactsFragment() {
        Logger logger = LoggerFactory.getLogger("CustomContactsFgm");
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(\"CustomContactsFgm\")");
        this.f33567d = logger;
    }

    public final EditText getNameInputEt() {
        EditText editText = this.nameInputEt;
        if (editText != null) {
            return editText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nameInputEt");
        return null;
    }

    public final void setNameInputEt(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<set-?>");
        this.nameInputEt = editText;
    }

    public final RecyclerView getContactLV() {
        RecyclerView recyclerView = this.contactLV;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contactLV");
        return null;
    }

    public final void setContactLV(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.contactLV = recyclerView;
    }

    public final Logger getLogger() {
        return this.f33567d;
    }

    public final void setLogger(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.f33567d = logger;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_custom_contacts, viewGroup, false);
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        commonTitleBar.setTitle(getString(R.string.CS_payment_Choose_friends_KwfK));
        commonTitleBar.setLeftBackListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomContactsFragment.m25484a(CustomContactsFragment.this, view);
            }
        });
        super.initCommonTitlebar(commonTitleBar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25484a(CustomContactsFragment customContactsFragment, View view) {
        Intrinsics.checkNotNullParameter(customContactsFragment, "this$0");
        customContactsFragment.backToPrePage();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_sw");
    }

    public void initViewModels() {
        ViewModel viewModel = new ViewModelProvider(this).get(CustomContactsVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…omContactsVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        ((CustomContactsVM) getVm()).getContactsLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                CustomContactsFragment.m25486a(CustomContactsFragment.this, (List) obj);
            }
        });
        ((CustomContactsVM) getVm()).getPhoneNumPixLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                CustomContactsFragment.m25485a(CustomContactsFragment.this, (PixKeyVerifyResp.PixKeyList) obj);
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.didi.payment.pix.contacts.fragment.adapter.PhoneContactsAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m25486a(com.didi.payment.pix.contacts.fragment.CustomContactsFragment r7, java.util.List r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            if (r8 != 0) goto L_0x0009
            goto L_0x0072
        L_0x0009:
            java.util.Collections.sort(r8)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r8 = r8.iterator()
            java.lang.String r1 = ""
            r2 = r1
        L_0x001a:
            boolean r3 = r8.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r8.next()
            com.didi.payment.pix.contacts.vm.model.PhoneContacts r3 = (com.didi.payment.pix.contacts.p135vm.model.PhoneContacts) r3
            boolean r5 = r3.isValid()
            if (r5 != 0) goto L_0x002e
            goto L_0x001a
        L_0x002e:
            java.lang.String r5 = r3.getName()
            r6 = 1
            if (r5 != 0) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r4 = 0
            java.lang.String r4 = r5.substring(r4, r6)
            java.lang.String r5 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        L_0x0040:
            if (r4 != 0) goto L_0x0043
            goto L_0x001a
        L_0x0043:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r5 != 0) goto L_0x0055
            com.didi.payment.pix.contacts.vm.model.PhoneContacts r2 = new com.didi.payment.pix.contacts.vm.model.PhoneContacts
            r2.<init>(r4, r1)
            r0.add(r2)
            r3.setFirstInGroup(r6)
            r2 = r4
        L_0x0055:
            r0.add(r3)
            goto L_0x001a
        L_0x0059:
            com.didi.payment.pix.contacts.fragment.adapter.PhoneContactsAdapter r8 = r7.f33565b
            java.lang.String r1 = "adapter"
            if (r8 != 0) goto L_0x0063
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r4
        L_0x0063:
            r8.setContactList(r0)
            com.didi.payment.pix.contacts.fragment.adapter.PhoneContactsAdapter r7 = r7.f33565b
            if (r7 != 0) goto L_0x006e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x006f
        L_0x006e:
            r4 = r7
        L_0x006f:
            r4.notifyDataSetChanged()
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.contacts.fragment.CustomContactsFragment.m25486a(com.didi.payment.pix.contacts.fragment.CustomContactsFragment, java.util.List):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25485a(CustomContactsFragment customContactsFragment, PixKeyVerifyResp.PixKeyList pixKeyList) {
        Context context;
        Intrinsics.checkNotNullParameter(customContactsFragment, "this$0");
        if (pixKeyList != null && (context = customContactsFragment.getContext()) != null) {
            if (!TextUtils.isEmpty(pixKeyList.getNotExistLabel())) {
                FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_choose_payee_fail_sw");
                WalletDialog createDrawer$default = WalletDialog.Companion.createDrawer$default(WalletDialog.Companion, context, false, false, 6, (Object) null);
                WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
                builder.setTitle(customContactsFragment.getString(R.string.GRider_payment_The_friend_HuMJ));
                builder.setContent(customContactsFragment.getString(R.string.GRider_payment_You_can_cGUL));
                builder.setFirstBtnText(customContactsFragment.getString(R.string.GRider_payment_I_see_YaKc));
                builder.setFirstClickListener(new CustomContactsFragment$initViewModels$2$content$1$1(createDrawer$default));
                createDrawer$default.setContentView((View) builder.build(context));
                SystemUtils.showDialog(createDrawer$default);
            } else if (!CollectionUtil.isEmpty((Collection<?>) pixKeyList.getKeyList())) {
                List<PixKeyVerifyResp.PixAccount> keyList = pixKeyList.getKeyList();
                String str = null;
                PixKeyVerifyResp.PixAccount pixAccount = keyList == null ? null : keyList.get(0);
                if (pixAccount != null) {
                    str = pixAccount.getKey();
                }
                FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_choose_payee_api_success_bt", "pix_payee_key", str);
                Bundle bundle = new Bundle();
                bundle.putSerializable("pix_account", pixAccount);
                bundle.putString("source_page", "contact_search");
                customContactsFragment.forwardNextPage(PixTransferAmountEditFragment.class, bundle);
            }
        }
    }

    public boolean customErrorUI() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            WalletToastNew.showFailedMsg(activity, "retry again");
        }
        return super.customErrorUI();
    }

    public void initContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.user_input_keyword_et);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.user_input_keyword_et)");
        setNameInputEt((EditText) findViewById);
        View findViewById2 = view.findViewById(R.id.clear_input);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.clear_input)");
        this.f33564a = findViewById2;
        getNameInputEt().addTextChangedListener(new CustomContactsFragment$initContentView$1(this));
        View view2 = this.f33564a;
        PhoneContactsAdapter phoneContactsAdapter = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearImg");
            view2 = null;
        }
        view2.setOnClickListener(new CustomContactsFragment$initContentView$2(this));
        View findViewById3 = view.findViewById(R.id.custom_contacts_recyclerview);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.c…om_contacts_recyclerview)");
        setContactLV((RecyclerView) findViewById3);
        getContactLV().setLayoutManager(new LinearLayoutManager(getActivity()));
        PhoneContactsAdapter phoneContactsAdapter2 = new PhoneContactsAdapter();
        this.f33565b = phoneContactsAdapter2;
        if (phoneContactsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            phoneContactsAdapter2 = null;
        }
        phoneContactsAdapter2.setOnItemClickListener(this);
        RecyclerView contactLV2 = getContactLV();
        PhoneContactsAdapter phoneContactsAdapter3 = this.f33565b;
        if (phoneContactsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            phoneContactsAdapter = phoneContactsAdapter3;
        }
        contactLV2.setAdapter(phoneContactsAdapter);
        View findViewById4 = view.findViewById(R.id.custom_contacts_titlebar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.custom_contacts_titlebar)");
        this.f33566c = findViewById4;
    }

    public void onContactClicked(PhoneContacts phoneContacts) {
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(phoneContacts, InvitationPageActivity.CONTACTS);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_choose_payee_ck");
        String phoneNum = phoneContacts.getPhoneNum();
        String str = "";
        if (!(phoneNum == null || (replace$default = StringsKt.replace$default(phoneNum, " ", "", false, 4, (Object) null)) == null || (replace$default2 = StringsKt.replace$default(replace$default, "-", "", false, 4, (Object) null)) == null)) {
            str = replace$default2;
        }
        if (StringsKt.indexOf$default((CharSequence) str, "+55", 0, false, 6, (Object) null) < 0) {
            str = Intrinsics.stringPlus("+55", str);
        }
        ((CustomContactsVM) getVm()).checkPhoneNum(str);
    }

    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            ((CustomContactsVM) getVm()).loadContacts(context);
        }
    }

    public boolean onBackKeyPressed() {
        return super.onBackKeyPressed();
    }
}
