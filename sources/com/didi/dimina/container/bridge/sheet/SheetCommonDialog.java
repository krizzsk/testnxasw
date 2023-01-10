package com.didi.dimina.container.bridge.sheet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public abstract class SheetCommonDialog implements View.OnClickListener, ISheetCommonDialog {

    /* renamed from: a */
    private Dialog f18651a;

    /* renamed from: b */
    private TextView f18652b;

    /* renamed from: c */
    private TextView f18653c;

    /* renamed from: d */
    private TextView f18654d;

    /* renamed from: e */
    private ISheetDialogItemClick f18655e;

    public SheetCommonDialog(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dimina_bottom_sheet_common, (ViewGroup) null);
        this.f18653c = (TextView) inflate.findViewById(R.id.dimina_bottom_sheet_item_one);
        if (!TextUtils.isEmpty(getItemOneText())) {
            this.f18653c.setText(getItemOneText());
        }
        this.f18652b = (TextView) inflate.findViewById(R.id.dimina_bottom_sheet_item_two);
        if (!TextUtils.isEmpty(getItemTwoText())) {
            this.f18652b.setText(getItemTwoText());
        }
        this.f18654d = (TextView) inflate.findViewById(R.id.dimina_bottom_sheet_item_cancel);
        this.f18652b.setOnClickListener(this);
        this.f18653c.setOnClickListener(this);
        this.f18654d.setOnClickListener(this);
        this.f18651a = new AlertDialog.Builder(context, R.style.DiminaPhotoDialog).setCancelable(false).setView(inflate).create();
    }

    public void show() {
        Dialog dialog = this.f18651a;
        if (dialog != null && !dialog.isShowing()) {
            SystemUtils.showDialog(this.f18651a);
            if (this.f18651a.getWindow() != null) {
                Window window = this.f18651a.getWindow();
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = -2;
                attributes.width = -1;
                attributes.gravity = 81;
                window.setAttributes(attributes);
            }
        }
    }

    public void setBottomDialogItemClick(ISheetDialogItemClick iSheetDialogItemClick) {
        this.f18655e = iSheetDialogItemClick;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f18654d) {
            this.f18651a.dismiss();
            ISheetDialogItemClick iSheetDialogItemClick = this.f18655e;
            if (iSheetDialogItemClick != null) {
                iSheetDialogItemClick.onCancel();
            }
        } else if (view == this.f18653c) {
            this.f18651a.dismiss();
            ISheetDialogItemClick iSheetDialogItemClick2 = this.f18655e;
            if (iSheetDialogItemClick2 != null) {
                iSheetDialogItemClick2.onClickItemOne();
            }
        } else if (view == this.f18652b) {
            this.f18651a.dismiss();
            ISheetDialogItemClick iSheetDialogItemClick3 = this.f18655e;
            if (iSheetDialogItemClick3 != null) {
                iSheetDialogItemClick3.onClickItemTwo();
            }
        }
    }
}
