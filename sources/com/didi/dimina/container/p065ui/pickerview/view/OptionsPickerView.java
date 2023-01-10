package com.didi.dimina.container.p065ui.pickerview.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.p065ui.pickerview.configure.PickerOptions;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.pickerview.view.OptionsPickerView */
public class OptionsPickerView<T> extends BasePickerView implements View.OnClickListener {

    /* renamed from: b */
    private static final String f19497b = "submit";

    /* renamed from: c */
    private static final String f19498c = "cancel";

    /* renamed from: a */
    private WheelOptions<T> f19499a;

    public OptionsPickerView(PickerOptions pickerOptions) {
        super(pickerOptions.context);
        this.mPickerOptions = pickerOptions;
        m16546a(pickerOptions.context);
    }

    /* renamed from: a */
    private void m16546a(Context context) {
        setDialogOutSideCancelable();
        initViews();
        initAnim();
        initEvents();
        if (this.mPickerOptions.customListener == null) {
            LayoutInflater.from(context).inflate(this.mPickerOptions.layoutRes, this.contentContainer);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.mPickerOptions.textContentConfirm) ? context.getResources().getString(R.string.dimina_pickerview_submit) : this.mPickerOptions.textContentConfirm);
            button2.setText(TextUtils.isEmpty(this.mPickerOptions.textContentCancel) ? context.getResources().getString(R.string.dimina_pickerview_cancel) : this.mPickerOptions.textContentCancel);
            textView.setText(TextUtils.isEmpty(this.mPickerOptions.textContentTitle) ? "" : this.mPickerOptions.textContentTitle);
            button.setTextColor(this.mPickerOptions.textColorConfirm);
            button2.setTextColor(this.mPickerOptions.textColorCancel);
            textView.setTextColor(this.mPickerOptions.textColorTitle);
            relativeLayout.setBackgroundColor(this.mPickerOptions.bgColorTitle);
            button.setTextSize((float) this.mPickerOptions.textSizeSubmitCancel);
            button2.setTextSize((float) this.mPickerOptions.textSizeSubmitCancel);
            textView.setTextSize((float) this.mPickerOptions.textSizeTitle);
        } else {
            this.mPickerOptions.customListener.customLayout(LayoutInflater.from(context).inflate(this.mPickerOptions.layoutRes, this.contentContainer));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.optionspicker);
        linearLayout.setBackgroundColor(this.mPickerOptions.bgColorWheel);
        this.f19499a = new WheelOptions<>(linearLayout, this.mPickerOptions.isRestoreItem);
        if (this.mPickerOptions.optionsSelectChangeListener != null) {
            this.f19499a.setOptionsSelectChangeListener(this.mPickerOptions.optionsSelectChangeListener);
        }
        this.f19499a.setTextContentSize(this.mPickerOptions.textSizeContent);
        this.f19499a.setItemsVisible(this.mPickerOptions.itemsVisibleCount);
        this.f19499a.setAlphaGradient(this.mPickerOptions.isAlphaGradient);
        this.f19499a.setLabels(this.mPickerOptions.label1, this.mPickerOptions.label2, this.mPickerOptions.label3);
        this.f19499a.setTextXOffset(this.mPickerOptions.x_offset_one, this.mPickerOptions.x_offset_two, this.mPickerOptions.x_offset_three);
        this.f19499a.setCyclic(this.mPickerOptions.cyclic1, this.mPickerOptions.cyclic2, this.mPickerOptions.cyclic3);
        this.f19499a.setTypeface(this.mPickerOptions.font);
        setOutSideCancelable(this.mPickerOptions.cancelable);
        this.f19499a.setDividerColor(this.mPickerOptions.dividerColor);
        this.f19499a.setDividerType(this.mPickerOptions.dividerType);
        this.f19499a.setLineSpacingMultiplier(this.mPickerOptions.lineSpacingMultiplier);
        this.f19499a.setTextColorOut(this.mPickerOptions.textColorOut);
        this.f19499a.setTextColorCenter(this.mPickerOptions.textColorCenter);
        this.f19499a.isCenterLabel(this.mPickerOptions.isCenterLabel);
    }

    public void setTitleText(String str) {
        TextView textView = (TextView) findViewById(R.id.tvTitle);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSelectOptions(int i) {
        this.mPickerOptions.option1 = i;
        m16545a();
    }

    public void setSelectOptions(int i, int i2) {
        this.mPickerOptions.option1 = i;
        this.mPickerOptions.option2 = i2;
        m16545a();
    }

    public void setSelectOptions(int i, int i2, int i3) {
        this.mPickerOptions.option1 = i;
        this.mPickerOptions.option2 = i2;
        this.mPickerOptions.option3 = i3;
        m16545a();
    }

    /* renamed from: a */
    private void m16545a() {
        WheelOptions<T> wheelOptions = this.f19499a;
        if (wheelOptions != null) {
            wheelOptions.setCurrentItems(this.mPickerOptions.option1, this.mPickerOptions.option2, this.mPickerOptions.option3);
        }
    }

    public void setPicker(List<T> list) {
        setPicker(list, (List) null, (List) null);
    }

    public void setPicker(List<T> list, List<List<T>> list2) {
        setPicker(list, list2, (List) null);
    }

    public void setPicker(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f19499a.setPicker(list, list2, list3);
        m16545a();
    }

    public void setNPicker(List<T> list, List<T> list2, List<T> list3) {
        this.f19499a.setLinkage(false);
        this.f19499a.setNPicker(list, list2, list3);
        m16545a();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        String str = (String) view.getTag();
        if (str.equals("submit")) {
            returnData();
        } else if (str.equals("cancel") && this.mPickerOptions.cancelListener != null) {
            this.mPickerOptions.cancelListener.onClick(view);
        }
        dismiss();
    }

    public void returnData() {
        if (this.mPickerOptions.optionsSelectListener != null) {
            int[] currentItems = this.f19499a.getCurrentItems();
            this.mPickerOptions.optionsSelectListener.onOptionsSelect(currentItems[0], currentItems[1], currentItems[2], this.clickView);
        }
    }

    public boolean isDialog() {
        return this.mPickerOptions.isDialog;
    }
}
