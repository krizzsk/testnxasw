package rui.widget.popup.type.input;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import rui.base.BaseViews;
import rui.util.RuiSoftInputUtils;
import rui.util.ViewUtils;
import rui.widget.popup.PopupView;
import rui.widget.popup.base.IPopupFactory;
import rui.widget.popup.base.PopupViews;

public class FactoryPopupInput implements IPopupFactory<PopupInput> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Button f8665a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f8666b;

    public void create(PopupView popupView, final PopupInput popupInput) {
        Context context = popupView.getContext();
        if (!TextUtils.isEmpty(popupInput.title)) {
            popupView.addView(PopupViews.createTitle(context, popupInput.title));
        }
        if (!TextUtils.isEmpty(popupInput.subtitle)) {
            popupView.addView(PopupViews.createSubtitle(context, popupInput.subtitle));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = (int) ViewUtils.m7249dp(context, 20.0f);
        layoutParams.rightMargin = (int) ViewUtils.m7249dp(context, 20.0f);
        EditText editText = new EditText(context);
        this.f8666b = editText;
        ViewUtils.setTextColor(editText, R.color.rui_color_grey_1);
        popupView.addView(this.f8666b, layoutParams);
        if (popupInput.defaultText != null) {
            this.f8666b.setText(popupInput.defaultText);
        }
        if (popupInput.filters != null) {
            this.f8666b.setFilters(popupInput.filters);
        }
        if (popupInput.watcher != null) {
            this.f8666b.addTextChangedListener(popupInput.watcher);
        }
        if (popupInput.keyListener != null) {
            this.f8666b.setKeyListener(popupInput.keyListener);
        }
        LinearLayout createButtonContainer = PopupViews.createButtonContainer(context);
        if (popupInput.button != null) {
            this.f8665a = BaseViews.createButton(context, popupInput.button.title, popupInput.button.style, popupInput.button.customColor, popupInput.button.onClick);
        } else {
            this.f8665a = new Button(context);
        }
        this.f8665a.setEnabled(popupInput.defaultEnable);
        this.f8665a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                RuiSoftInputUtils.hideSoftInput((View) FactoryPopupInput.this.f8666b);
                if (popupInput.button.onClick != null) {
                    popupInput.button.onClick.onClick(FactoryPopupInput.this.f8665a);
                }
            }
        });
        createButtonContainer.addView(this.f8665a);
        popupView.addView(createButtonContainer);
    }

    public EditText getEditText() {
        return this.f8666b;
    }

    public void enableButton(boolean z) {
        Button button = this.f8665a;
        if (button != null) {
            button.setEnabled(z);
        }
    }
}
