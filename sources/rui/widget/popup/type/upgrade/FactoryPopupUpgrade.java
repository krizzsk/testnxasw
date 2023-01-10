package rui.widget.popup.type.upgrade;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import rui.util.ViewUtils;
import rui.widget.popup.PopupView;
import rui.widget.popup.base.IPopupFactory;
import rui.widget.popup.base.PopupViews;

public class FactoryPopupUpgrade implements IPopupFactory<PopupUpgrade>, IPopupUpgrade {

    /* renamed from: a */
    private static final int f8681a = Integer.MIN_VALUE;

    /* renamed from: b */
    private TextView f8682b;

    /* renamed from: c */
    private TextView f8683c;

    /* renamed from: d */
    private LinearLayout f8684d;

    /* renamed from: e */
    private LinearLayout f8685e;

    /* renamed from: f */
    private FrameLayout f8686f;

    public void create(PopupView popupView, PopupUpgrade popupUpgrade) {
        Context context = popupView.getContext();
        TextView createTitle = PopupViews.createTitle(context, popupUpgrade.title);
        this.f8682b = createTitle;
        popupView.addView(createTitle);
        TextView createUpgradeContent = PopupViews.createUpgradeContent(context, popupUpgrade.content);
        this.f8683c = createUpgradeContent;
        popupView.addView(createUpgradeContent);
        this.f8684d = PopupViews.createButtonContainer(context);
        this.f8685e = PopupViews.createButtonContainer(context);
        PopupViews.fillButtonContainer(context, this.f8684d, popupUpgrade.getConfirmButtons());
        PopupViews.fillButtonContainer(context, this.f8685e, popupUpgrade.getFinishButtons());
        this.f8686f = PopupViews.createProgressBar(context, popupUpgrade.progressDrawable);
        if (popupUpgrade.progressOnClick != null) {
            this.f8686f.setOnClickListener(popupUpgrade.progressOnClick);
        }
        showConfirm();
        popupView.addView(this.f8686f);
        popupView.addView(this.f8685e);
        popupView.addView(this.f8684d);
    }

    public void updateTitle(String str) {
        TextView textView = this.f8682b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void updateContent(String str) {
        TextView textView = this.f8683c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void showConfirm() {
        ViewUtils.gone(this.f8686f);
        ViewUtils.gone(this.f8685e);
        ViewUtils.visible(this.f8684d);
    }

    public void showProgress(String str) {
        showProgress(Integer.MIN_VALUE, str);
    }

    public void showProgress(int i, String str) {
        if (i != Integer.MIN_VALUE) {
            ((ProgressBar) this.f8686f.findViewWithTag("progress")).setProgress(i);
        }
        ((TextView) this.f8686f.findViewWithTag("title")).setText(str);
        ViewUtils.gone(this.f8684d);
        ViewUtils.gone(this.f8685e);
        ViewUtils.visible(this.f8686f);
    }

    public void showFinish() {
        ViewUtils.gone(this.f8684d);
        ViewUtils.gone(this.f8686f);
        ViewUtils.visible(this.f8685e);
    }
}
