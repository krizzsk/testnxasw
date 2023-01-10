package com.didi.globalsafetoolkit.business.contacts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.globalsafetoolkit.base.BaseSafeToolkitActivity;
import com.didi.globalsafetoolkit.business.share.SfContractOptIView;
import com.didi.globalsafetoolkit.business.share.controller.SfGetOptController;
import com.didi.globalsafetoolkit.util.SfInputMethodUtil;
import com.didi.globalsafetoolkit.util.SfViewUtils;
import com.didi.globalsafetoolkit.widget.SfCommonTitleBar;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0014J*\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u001fH\u0014J\u0012\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\u0017H\u0014J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\"\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\t2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, mo148868d2 = {"Lcom/didi/globalsafetoolkit/business/contacts/SfContactsManageOptActivity;", "Lcom/didi/globalsafetoolkit/base/BaseSafeToolkitActivity;", "Lcom/didi/globalsafetoolkit/business/share/SfContractOptIView;", "()V", "addButton", "Landroid/widget/Button;", "guideLayout", "Landroid/widget/FrameLayout;", "line1", "Landroid/view/View;", "line2", "nameClearIcon", "Landroid/widget/ImageView;", "nameInput", "Landroid/widget/EditText;", "phoneClearIcon", "phoneIcon", "phoneInput", "sfGetOptController", "Lcom/didi/globalsafetoolkit/business/share/controller/SfGetOptController;", "titleBar", "Lcom/didi/globalsafetoolkit/widget/SfCommonTitleBar;", "findViews", "", "getBasicContentLayoutResId", "", "getFallbackView", "hideGuide", "hideLoadingState", "initData", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "isFragmentSponsor", "parseBundle", "bundle", "Landroid/os/Bundle;", "setListener", "showGuide", "showLoadingState", "updateView", "view", "hasContent", "hasFocus", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: SfContactsManageOptActivity.kt */
public final class SfContactsManageOptActivity extends BaseSafeToolkitActivity implements SfContractOptIView {

    /* renamed from: a */
    private SfCommonTitleBar f24978a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f24979b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f24980c;

    /* renamed from: d */
    private ImageView f24981d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageView f24982e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ImageView f24983f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Button f24984g;

    /* renamed from: h */
    private FrameLayout f24985h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SfGetOptController f24986i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f24987j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f24988k;

    /* renamed from: l */
    private HashMap f24989l;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f24989l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f24989l == null) {
            this.f24989l = new HashMap();
        }
        View view = (View) this.f24989l.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f24989l.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_contacts_manage_opt;
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20031a(View view, boolean z, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (!z) {
            if (layoutParams != null) {
                layoutParams.height = SfViewUtils.dp2px(this, 0.5f);
            }
            if (z2) {
                if (view != null) {
                    view.setBackgroundColor(Color.parseColor("#FF8040"));
                }
            } else if (view != null) {
                view.setBackgroundColor(Color.parseColor("#DDDDDD"));
            }
        } else if (layoutParams != null) {
            layoutParams.height = SfViewUtils.dp2px(this, 1.5f);
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f24978a = (SfCommonTitleBar) findViewById(R.id.titleBar);
        this.f24979b = (EditText) findViewById(R.id.nameInput);
        this.f24980c = (EditText) findViewById(R.id.phoneInput);
        this.f24981d = (ImageView) findViewById(R.id.phoneIcon);
        this.f24982e = (ImageView) findViewById(R.id.nameClearIcon);
        this.f24983f = (ImageView) findViewById(R.id.phoneClearIcon);
        this.f24984g = (Button) findViewById(R.id.addButton);
        this.f24985h = (FrameLayout) findViewById(R.id.guideLayout);
        this.f24987j = findViewById(R.id.line1);
        this.f24988k = findViewById(R.id.line2);
        Button button = this.f24984g;
        if (button != null) {
            button.setEnabled(false);
        }
        Button button2 = this.f24984g;
        if (button2 != null) {
            button2.setTextColor(Color.parseColor("#D4D7D9"));
        }
        EditText editText = this.f24980c;
        if (editText != null) {
            editText.requestFocus();
        }
        SfInputMethodUtil sfInputMethodUtil = SfInputMethodUtil.INSTANCE;
        Context context = this;
        EditText editText2 = this.f24980c;
        if (editText2 == null) {
            Intrinsics.throwNpe();
        }
        sfInputMethodUtil.showInputMethod(context, editText2);
        m20031a(this.f24987j, false, true);
        m20031a(this.f24988k, false, false);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        SfGetOptController sfGetOptController;
        Integer num;
        ImageView imageView;
        SfCommonTitleBar sfCommonTitleBar = this.f24978a;
        if (sfCommonTitleBar != null) {
            sfCommonTitleBar.setTitleText("");
        }
        SfGetOptController sfGetOptController2 = new SfGetOptController(this);
        this.f24986i = sfGetOptController2;
        if (sfGetOptController2 != null) {
            Intent intent = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
            sfGetOptController2.parseBundle(intent.getExtras());
        }
        IToggle toggle = Apollo.getToggle("passenger_trusted_contact_display");
        if (!(toggle == null || !toggle.allow() || (num = (Integer) toggle.getExperiment().getParam("hidden", 0)) == null || num.intValue() != 1 || (imageView = this.f24981d) == null)) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.f24981d;
        if (imageView2 != null && imageView2.getVisibility() == 0 && (sfGetOptController = this.f24986i) != null) {
            sfGetOptController.showGuide();
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        ImageView imageView = this.f24982e;
        if (imageView != null) {
            imageView.setOnClickListener(new SfContactsManageOptActivity$setListener$1(this));
        }
        ImageView imageView2 = this.f24983f;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new SfContactsManageOptActivity$setListener$2(this));
        }
        ImageView imageView3 = this.f24981d;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new SfContactsManageOptActivity$setListener$3(this));
        }
        EditText editText = this.f24980c;
        if (editText != null) {
            editText.setOnFocusChangeListener(new SfContactsManageOptActivity$setListener$4(this));
        }
        EditText editText2 = this.f24979b;
        if (editText2 != null) {
            editText2.setOnFocusChangeListener(new SfContactsManageOptActivity$setListener$5(this));
        }
        EditText editText3 = this.f24979b;
        if (editText3 != null) {
            editText3.addTextChangedListener(new SfContactsManageOptActivity$setListener$6(this));
        }
        EditText editText4 = this.f24980c;
        if (editText4 != null) {
            editText4.addTextChangedListener(new SfContactsManageOptActivity$setListener$7(this));
        }
        SfCommonTitleBar sfCommonTitleBar = this.f24978a;
        if (sfCommonTitleBar != null) {
            sfCommonTitleBar.setLeftBtnClickListener(new SfContactsManageOptActivity$setListener$8(this));
        }
        Button button = this.f24984g;
        if (button != null) {
            button.setOnClickListener(new SfContactsManageOptActivity$setListener$9(this));
        }
    }

    public View getFallbackView() {
        SfCommonTitleBar sfCommonTitleBar = this.f24978a;
        return sfCommonTitleBar != null ? sfCommonTitleBar.getLoadingFallback() : null;
    }

    public void showLoadingState() {
        showPDialog();
    }

    public void hideLoadingState() {
        closePDialog();
    }

    public void hideGuide() {
        FrameLayout frameLayout = this.f24985h;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public void showGuide() {
        try {
            View view = null;
            LEGOBubble build = new LEGOBubble.Builder(this).setText(ResourcesHelper.getString(this, R.string.GDriver_Contacts_Contacts_qCeS)).setCloseBtnListener((BubbleCloseListener) null).setCloseBtnVisible(false).setTextTypeface(3).setBgColor(Color.parseColor("#5C6166")).setContentViewOnClick(new SfContactsManageOptActivity$showGuide$guide$1(this)).setDirection("bottom_right").build();
            Intrinsics.checkExpressionValueIsNotNull(build, "LEGOBubble.Builder(this)…                 .build()");
            FrameLayout frameLayout = this.f24985h;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            FrameLayout frameLayout2 = this.f24985h;
            if (frameLayout2 != null) {
                if (build != null) {
                    view = build.getView();
                }
                frameLayout2.addView(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent, boolean z) {
        SfGetOptController sfGetOptController = this.f24986i;
        if (sfGetOptController != null) {
            sfGetOptController.onActivityResult(i, i2, intent);
        }
        return super.onActivityResult(i, i2, intent, z);
    }
}
