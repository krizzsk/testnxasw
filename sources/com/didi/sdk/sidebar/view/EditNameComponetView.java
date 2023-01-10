package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.p165h5.CustomerWebActivity;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;

public class EditNameComponetView extends ComponentView {

    /* renamed from: a */
    private TextView f40183a;

    /* renamed from: b */
    private EditText f40184b;

    public EditNameComponetView(Context context) {
        super(context);
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.v_edit_name_component_view, (ViewGroup) null);
        this.f40183a = (TextView) inflate.findViewById(R.id.name);
        this.f40184b = (EditText) inflate.findViewById(R.id.name_hint);
        setUnEditable();
        return inflate;
    }

    public void setMaxLength(int i) {
        EditText editText = this.f40184b;
        if (editText != null) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        }
    }

    public void setNameDes(String str) {
        this.f40183a.setText(str);
    }

    public void setHint(String str) {
        this.f40184b.setHint(str);
    }

    public void setName(String str) {
        this.f40184b.setText(str);
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f40184b.setOnFocusChangeListener(onFocusChangeListener);
    }

    public String getName() {
        String obj = this.f40184b.getText().toString();
        return !TextUtils.isEmpty(obj) ? obj.trim() : obj;
    }

    public void setUnEditable() {
        IToggle toggle = Apollo.getToggle("User_Edit_Name_Toggle");
        if (toggle.allow() && ((Integer) toggle.getExperiment().getParam(CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1) {
            this.f40184b.setFocusable(false);
            this.f40184b.setFocusableInTouchMode(false);
            this.f40184b.setClickable(true);
            this.f40184b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ToastHelper.showLongInfo(EditNameComponetView.this.context, ResourcesHelper.getString(EditNameComponetView.this.context, R.string.global_profile_name_uneditable_warning));
                }
            });
        }
    }
}
