package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.widget.loading.SodaLoadingView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001KB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\n\u00100\u001a\u0004\u0018\u00010/H\u0016J\b\u00101\u001a\u000202H\u0002J\u000e\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u000205J\u0018\u00106\u001a\u00020\u001a2\u0006\u00104\u001a\u0002052\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000202H\u0016J\b\u0010:\u001a\u000202H\u0016J\b\u0010;\u001a\u000202H\u0016J\u0010\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020>H\u0002J\u0018\u0010A\u001a\u0002022\b\u0010B\u001a\u0004\u0018\u00010\n2\u0006\u0010C\u001a\u00020>J\u0012\u0010D\u001a\u0002022\b\u0010B\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010E\u001a\u0002022\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020\nH\u0002J\u0010\u0010G\u001a\u0002022\u0006\u0010@\u001a\u00020>H\u0002J\u0010\u0010H\u001a\u0002022\u0006\u0010@\u001a\u00020>H\u0002J\b\u0010I\u001a\u000202H\u0002J\u0012\u0010J\u001a\u0002022\b\u0010)\u001a\u0004\u0018\u00010\nH\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#8B@BX\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R(\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010)\u001a\u0004\u0018\u00010\n8B@BX\u000e¢\u0006\f\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010-¨\u0006L"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/dialog/CustomerNumProtectDialog;", "Lcom/didi/app/nova/skeleton/dialog/Dialog;", "context", "Landroid/content/Context;", "numProtectModel", "Lcom/didi/soda/customer/widget/dialog/NumProtectModel;", "onNumProtectCallListener", "Lcom/didi/soda/customer/widget/dialog/CustomerNumProtectDialog$OnNumProtectCallListener;", "(Landroid/content/Context;Lcom/didi/soda/customer/widget/dialog/NumProtectModel;Lcom/didi/soda/customer/widget/dialog/CustomerNumProtectDialog$OnNumProtectCallListener;)V", "callingCode", "", "getCallingCode", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "mAction1", "Landroid/widget/TextView;", "mAction2", "mActionLoading", "Lcom/didi/soda/customer/widget/loading/SodaLoadingView;", "mActionParent", "Landroid/widget/LinearLayout;", "mContent", "mDelete", "Landroid/widget/ImageView;", "mDivider1", "Landroid/view/View;", "mDivider2", "mEditParent", "mLoading", "mPhoneNum", "Landroid/widget/EditText;", "mRoot", "mTvCode", "shown", "", "numPhoneDialogShown", "getNumPhoneDialogShown", "()Z", "setNumPhoneDialogShown", "(Z)V", "phone", "phoneNum", "getPhoneNum", "setPhoneNum", "(Ljava/lang/String;)V", "getEnterAnimation", "Lcom/didi/app/nova/skeleton/dialog/TransformAnimation;", "getExitAnimation", "init", "", "initRootView", "inflater", "Landroid/view/LayoutInflater;", "onCreate", "parent", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "onShow", "setAction2Text", "contentId", "", "setActionLoadingVisibility", "visibility", "setCallingCode", "calling", "country", "setCallingCodeText", "setContent", "content", "setLoadingVisibility", "setPhoneEditVisibility", "setPhoneInfo", "setPhoneNumText", "OnNumProtectCallListener", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerNumProtectDialog.kt */
public final class CustomerNumProtectDialog extends Dialog {

    /* renamed from: a */
    private final Context f44343a;

    /* renamed from: b */
    private final NumProtectModel f44344b;

    /* renamed from: c */
    private final OnNumProtectCallListener f44345c;

    /* renamed from: d */
    private View f44346d;

    /* renamed from: e */
    private ImageView f44347e;

    /* renamed from: f */
    private SodaLoadingView f44348f;

    /* renamed from: g */
    private TextView f44349g;

    /* renamed from: h */
    private LinearLayout f44350h;

    /* renamed from: i */
    private TextView f44351i;

    /* renamed from: j */
    private EditText f44352j;

    /* renamed from: k */
    private View f44353k;

    /* renamed from: l */
    private View f44354l;

    /* renamed from: m */
    private LinearLayout f44355m;

    /* renamed from: n */
    private TextView f44356n;

    /* renamed from: o */
    private TextView f44357o;

    /* renamed from: p */
    private SodaLoadingView f44358p;

    @Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/dialog/CustomerNumProtectDialog$OnNumProtectCallListener;", "", "confirm", "", "dialog", "Lcom/didi/app/nova/skeleton/dialog/Dialog;", "phone", "", "callingCode", "onCancel", "Lcom/didi/soda/customer/widget/dialog/CustomerNumProtectDialog;", "onChooseCountryList", "countryId", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomerNumProtectDialog.kt */
    public interface OnNumProtectCallListener {
        void confirm(Dialog dialog, String str, String str2);

        void onCancel(CustomerNumProtectDialog customerNumProtectDialog);

        void onChooseCountryList(CustomerNumProtectDialog customerNumProtectDialog, int i);
    }

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    public final Context getContext() {
        return this.f44343a;
    }

    public CustomerNumProtectDialog(Context context, NumProtectModel numProtectModel, OnNumProtectCallListener onNumProtectCallListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(numProtectModel, "numProtectModel");
        this.f44343a = context;
        this.f44344b = numProtectModel;
        this.f44345c = onNumProtectCallListener;
    }

    /* renamed from: e */
    private final String m32978e() {
        EditText editText = this.f44352j;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
            editText = null;
        }
        return editText.getText().toString();
    }

    /* renamed from: a */
    private final void m32967a(String str) {
        this.f44344b.setPhoneNum(str);
        m32974c(m32978e());
    }

    /* renamed from: f */
    private final String m32980f() {
        return this.f44344b.getCallingCode();
    }

    /* renamed from: g */
    private final boolean m32981g() {
        return ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mNumProtectShown;
    }

    /* renamed from: a */
    private final void m32968a(boolean z) {
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        AppConfig data = appConfigStorage.getData();
        data.mNumProtectShown = z;
        appConfigStorage.setData(data);
    }

    public final void setCallingCode(String str, int i) {
        this.f44344b.setCallingCode(str);
        this.f44344b.setCountryId(i);
        m32982h();
    }

    public final View initRootView(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.customer_dialog_num_protect, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…dialog_num_protect, null)");
        this.f44346d = inflate;
        m32983i();
        View view = this.f44346d;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        return null;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_dialog_num_protect, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…m_protect, parent, false)");
        this.f44346d = inflate;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = DisplayUtils.dip2px(this.f44343a, 50.0f);
        layoutParams.rightMargin = DisplayUtils.dip2px(this.f44343a, 50.0f);
        layoutParams.gravity = 17;
        View view = this.f44346d;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view = null;
        }
        view.setLayoutParams(layoutParams);
        m32983i();
        View view2 = this.f44346d;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        return null;
    }

    public void onDismiss() {
        Context context = this.f44343a;
        EditText editText = this.f44352j;
        SodaLoadingView sodaLoadingView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
            editText = null;
        }
        KeyboardUtils.hideSoftInput(context, editText);
        SodaLoadingView sodaLoadingView2 = this.f44358p;
        if (sodaLoadingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
            sodaLoadingView2 = null;
        }
        sodaLoadingView2.stop();
        SodaLoadingView sodaLoadingView3 = this.f44348f;
        if (sodaLoadingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoading");
        } else {
            sodaLoadingView = sodaLoadingView3;
        }
        sodaLoadingView.stop();
    }

    public void onShow() {
        m32982h();
        if (!m32981g()) {
            m32975d((int) R.string.customer_phone_dismiss);
            m32964a(8);
            m32979e(R.string.customer_dialog_confirm);
        } else {
            m32975d((int) R.string.FoodC_phonenumber_Please_confirm_UNcQ);
            m32964a(0);
            m32979e(R.string.customer_call_this_phone);
        }
        m32969b(4);
    }

    /* renamed from: a */
    private final void m32964a(int i) {
        LinearLayout linearLayout = this.f44350h;
        View view = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditParent");
            linearLayout = null;
        }
        linearLayout.setVisibility(i);
        View view2 = this.f44353k;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDivider1");
        } else {
            view = view2;
        }
        view.setVisibility(i);
    }

    /* renamed from: b */
    private final void m32969b(int i) {
        SodaLoadingView sodaLoadingView = this.f44348f;
        SodaLoadingView sodaLoadingView2 = null;
        if (sodaLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoading");
            sodaLoadingView = null;
        }
        sodaLoadingView.setVisibility(i);
        if (i == 4 || i == 8) {
            TextView textView = this.f44349g;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContent");
                textView = null;
            }
            textView.setVisibility(0);
            LinearLayout linearLayout = this.f44355m;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionParent");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            View view = this.f44354l;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDivider2");
                view = null;
            }
            view.setVisibility(0);
            SodaLoadingView sodaLoadingView3 = this.f44348f;
            if (sodaLoadingView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoading");
            } else {
                sodaLoadingView2 = sodaLoadingView3;
            }
            sodaLoadingView2.stop();
            return;
        }
        TextView textView2 = this.f44349g;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            textView2 = null;
        }
        textView2.setVisibility(8);
        LinearLayout linearLayout2 = this.f44355m;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionParent");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(8);
        View view2 = this.f44354l;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDivider2");
            view2 = null;
        }
        view2.setVisibility(8);
        LinearLayout linearLayout3 = this.f44350h;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditParent");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(8);
        View view3 = this.f44353k;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDivider1");
            view3 = null;
        }
        view3.setVisibility(8);
        SodaLoadingView sodaLoadingView4 = this.f44348f;
        if (sodaLoadingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoading");
        } else {
            sodaLoadingView2 = sodaLoadingView4;
        }
        sodaLoadingView2.start();
    }

    /* renamed from: c */
    private final void m32972c(int i) {
        SodaLoadingView sodaLoadingView = null;
        if (i == 4 || i == 8) {
            SodaLoadingView sodaLoadingView2 = this.f44358p;
            if (sodaLoadingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
                sodaLoadingView2 = null;
            }
            sodaLoadingView2.stop();
            LinearLayout linearLayout = this.f44355m;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionParent");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
        } else {
            LinearLayout linearLayout2 = this.f44355m;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionParent");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
            SodaLoadingView sodaLoadingView3 = this.f44358p;
            if (sodaLoadingView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
                sodaLoadingView3 = null;
            }
            if (!sodaLoadingView3.isRunning()) {
                SodaLoadingView sodaLoadingView4 = this.f44358p;
                if (sodaLoadingView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
                    sodaLoadingView4 = null;
                }
                sodaLoadingView4.start();
            }
        }
        SodaLoadingView sodaLoadingView5 = this.f44358p;
        if (sodaLoadingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
        } else {
            sodaLoadingView = sodaLoadingView5;
        }
        sodaLoadingView.setVisibility(i);
    }

    /* renamed from: b */
    private final void m32971b(String str) {
        TextView textView = this.f44349g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            textView = null;
        }
        textView.setText(str);
    }

    /* renamed from: d */
    private final void m32975d(int i) {
        TextView textView = this.f44349g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            textView = null;
        }
        textView.setText(ResourceHelper.getString(i));
    }

    /* renamed from: e */
    private final void m32979e(int i) {
        TextView textView = this.f44357o;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction2");
            textView = null;
        }
        textView.setText(ResourceHelper.getString(i));
    }

    /* renamed from: c */
    private final void m32974c(String str) {
        EditText editText = this.f44352j;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
            editText = null;
        }
        editText.setText(str);
    }

    /* renamed from: d */
    private final void m32977d(String str) {
        TextView textView = this.f44351i;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvCode");
            textView = null;
        }
        textView.setText(str);
    }

    /* renamed from: h */
    private final void m32982h() {
        m32974c(this.f44344b.getPhoneNum());
        m32977d(this.f44344b.getCallingCode());
    }

    /* renamed from: i */
    private final void m32983i() {
        View view = this.f44346d;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view = null;
        }
        View findViewById = view.findViewById(R.id.customer_custom_loading_dot_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRoot.findViewById(R.id.…_custom_loading_dot_view)");
        this.f44348f = (SodaLoadingView) findViewById;
        View view2 = this.f44346d;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.customer_tv_dialog_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRoot.findViewById(R.id.…stomer_tv_dialog_content)");
        this.f44349g = (TextView) findViewById2;
        View view3 = this.f44346d;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.customer_ll_dialog_edit);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRoot.findViewById(R.id.customer_ll_dialog_edit)");
        this.f44350h = (LinearLayout) findViewById3;
        View view4 = this.f44346d;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.customer_tv_calling_code);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRoot.findViewById(R.id.customer_tv_calling_code)");
        this.f44351i = (TextView) findViewById4;
        View view5 = this.f44346d;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.customer_et_phone_num);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRoot.findViewById(R.id.customer_et_phone_num)");
        this.f44352j = (EditText) findViewById5;
        View view6 = this.f44346d;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.customer_iv_num_protect_dialog_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRoot.findViewById(R.id.…um_protect_dialog_delete)");
        this.f44347e = (ImageView) findViewById6;
        View view7 = this.f44346d;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view7 = null;
        }
        View findViewById7 = view7.findViewById(R.id.customer_view_dialog_divider1);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRoot.findViewById(R.id.…mer_view_dialog_divider1)");
        this.f44353k = findViewById7;
        View view8 = this.f44346d;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view8 = null;
        }
        View findViewById8 = view8.findViewById(R.id.customer_view_dialog_divider2);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRoot.findViewById(R.id.…mer_view_dialog_divider2)");
        this.f44354l = findViewById8;
        View view9 = this.f44346d;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view9 = null;
        }
        View findViewById9 = view9.findViewById(R.id.customer_ll_num_protect_dialog_action);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRoot.findViewById(R.id.…um_protect_dialog_action)");
        this.f44355m = (LinearLayout) findViewById9;
        View view10 = this.f44346d;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view10 = null;
        }
        View findViewById10 = view10.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRoot.findViewById(R.id.…ommon_dialog_sub_action1)");
        this.f44356n = (TextView) findViewById10;
        View view11 = this.f44346d;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view11 = null;
        }
        View findViewById11 = view11.findViewById(R.id.customer_tv_common_dialog_sub_action2);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRoot.findViewById(R.id.…ommon_dialog_sub_action2)");
        this.f44357o = (TextView) findViewById11;
        View view12 = this.f44346d;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view12 = null;
        }
        View findViewById12 = view12.findViewById(R.id.customer_custom_action_loading_dot_view);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRoot.findViewById(R.id.…_action_loading_dot_view)");
        this.f44358p = (SodaLoadingView) findViewById12;
        ImageView imageView = this.f44347e;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDelete");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerNumProtectDialog.m32966a(CustomerNumProtectDialog.this, view);
            }
        });
        TextView textView2 = this.f44356n;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction1");
            textView2 = null;
        }
        textView2.setText(ResourceHelper.getString(R.string.customer_dialog_cancel));
        TextView textView3 = this.f44357o;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction2");
            textView3 = null;
        }
        textView3.setText(ResourceHelper.getString(R.string.customer_dialog_confirm));
        TextView textView4 = this.f44356n;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction1");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerNumProtectDialog.m32970b(CustomerNumProtectDialog.this, view);
            }
        });
        TextView textView5 = this.f44357o;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction2");
            textView5 = null;
        }
        textView5.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerNumProtectDialog.m32973c(CustomerNumProtectDialog.this, view);
            }
        });
        TextView textView6 = this.f44351i;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvCode");
        } else {
            textView = textView6;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerNumProtectDialog.m32976d(CustomerNumProtectDialog.this, view);
            }
        });
        setCancelable(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32966a(CustomerNumProtectDialog customerNumProtectDialog, View view) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        EditText editText = customerNumProtectDialog.f44352j;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
            editText = null;
        }
        editText.setText((CharSequence) null);
        customerNumProtectDialog.f44344b.setPhoneNum((String) null);
        Context context = customerNumProtectDialog.getContext();
        EditText editText3 = customerNumProtectDialog.f44352j;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
        } else {
            editText2 = editText3;
        }
        KeyboardUtils.showSoftInput(context, editText2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m32970b(CustomerNumProtectDialog customerNumProtectDialog, View view) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        OnNumProtectCallListener onNumProtectCallListener = customerNumProtectDialog.f44345c;
        if (onNumProtectCallListener != null) {
            onNumProtectCallListener.onCancel(customerNumProtectDialog);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m32973c(CustomerNumProtectDialog customerNumProtectDialog, View view) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        boolean z = true;
        if (!customerNumProtectDialog.m32981g()) {
            customerNumProtectDialog.m32969b(0);
            UiHandlerUtil.postDelayed(new Runnable() {
                public final void run() {
                    CustomerNumProtectDialog.m32965a(CustomerNumProtectDialog.this);
                }
            }, 2000);
            customerNumProtectDialog.m32968a(true);
        } else if (customerNumProtectDialog.f44345c != null) {
            customerNumProtectDialog.f44344b.setPhoneNum(customerNumProtectDialog.m32978e());
            CharSequence e = customerNumProtectDialog.m32978e();
            if (!(e == null || e.length() == 0)) {
                z = false;
            }
            if (!z) {
                customerNumProtectDialog.m32972c(0);
                customerNumProtectDialog.f44345c.confirm(customerNumProtectDialog, customerNumProtectDialog.m32978e(), customerNumProtectDialog.m32980f());
            } else {
                customerNumProtectDialog.f44345c.onCancel(customerNumProtectDialog);
            }
            Context context = customerNumProtectDialog.getContext();
            EditText editText = customerNumProtectDialog.f44352j;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
                editText = null;
            }
            KeyboardUtils.hideSoftInput(context, editText);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32965a(CustomerNumProtectDialog customerNumProtectDialog) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        customerNumProtectDialog.onShow();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m32976d(CustomerNumProtectDialog customerNumProtectDialog, View view) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        OnNumProtectCallListener onNumProtectCallListener = customerNumProtectDialog.f44345c;
        if (onNumProtectCallListener != null) {
            onNumProtectCallListener.onChooseCountryList(customerNumProtectDialog, customerNumProtectDialog.f44344b.getCountryId());
        }
    }
}
