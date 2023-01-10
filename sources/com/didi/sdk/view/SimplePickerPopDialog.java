package com.didi.sdk.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.List;

public class SimplePickerPopDialog extends BaseDialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f40578a;

    /* renamed from: b */
    private TextView f40579b;

    /* renamed from: c */
    private TextView f40580c;

    /* renamed from: d */
    private TextView f40581d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Wheel f40582e;

    /* renamed from: f */
    private List<String> f40583f;

    /* renamed from: g */
    private String f40584g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnItemSelectListener f40585h;

    /* renamed from: i */
    private int f40586i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public onViewShowListener f40587j;

    /* renamed from: k */
    private View.OnClickListener f40588k = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SimplePickerPopDialog.this.dismiss();
            if (SimplePickerPopDialog.this.f40585h != null) {
                SimplePickerPopDialog.this.f40585h.onConfirmed(SimplePickerPopDialog.this.f40582e.getSelectedIndex());
            }
        }
    };

    /* renamed from: l */
    private View.OnClickListener f40589l = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SimplePickerPopDialog.this.dismiss();
            if (SimplePickerPopDialog.this.f40585h != null) {
                SimplePickerPopDialog.this.f40585h.onCanceled();
            }
        }
    };

    public interface OnChildItemSelectListener extends OnItemSelectListener {
        void onItemSelected(View view, int i);
    }

    public interface OnItemSelectListener {
        void onCanceled();

        void onConfirmed(int i);

        void onItemSelected(int i);
    }

    public interface onViewShowListener {
        void showComplete(View view);
    }

    public static SimplePickerPopDialog newInstance(List<String> list, OnItemSelectListener onItemSelectListener) {
        return newInstance(list, "", onItemSelectListener);
    }

    public static SimplePickerPopDialog newInstance(List<String> list, String str, OnItemSelectListener onItemSelectListener) {
        SimplePickerPopDialog simplePickerPopDialog = new SimplePickerPopDialog();
        simplePickerPopDialog.f40583f = list;
        simplePickerPopDialog.f40585h = onItemSelectListener;
        simplePickerPopDialog.f40584g = str;
        return simplePickerPopDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.simple_picker_pop, (ViewGroup) null);
        m30474a(inflate);
        m30473a();
        return inflate;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.PopDialog);
    }

    public Wheel getPicker() {
        return this.f40582e;
    }

    public void setSelectedIndex(int i) {
        this.f40586i = i;
        Wheel wheel = this.f40582e;
        if (wheel != null) {
            wheel.setSelectedIndex(i);
        }
    }

    /* renamed from: a */
    private void m30474a(View view) {
        this.f40579b = (TextView) view.findViewById(R.id.yes);
        this.f40580c = (TextView) view.findViewById(R.id.cancel);
        this.f40581d = (TextView) view.findViewById(R.id.title);
        this.f40582e = (Wheel) view.findViewById(R.id.simple_picker);
        this.f40579b.setOnClickListener(this.f40588k);
        this.f40580c.setOnClickListener(this.f40589l);
        this.f40582e.setData(this.f40583f);
        this.f40582e.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (SimplePickerPopDialog.this.f40585h == null) {
                    return;
                }
                if (SimplePickerPopDialog.this.f40585h instanceof OnChildItemSelectListener) {
                    ((OnChildItemSelectListener) SimplePickerPopDialog.this.f40585h).onItemSelected(SimplePickerPopDialog.this.f40582e, i);
                } else if (SimplePickerPopDialog.this.f40585h instanceof OnChildItemSelectListener) {
                    SimplePickerPopDialog.this.f40585h.onItemSelected(i);
                }
            }
        });
        this.f40581d.setText(this.f40584g);
        this.f40582e.setSelectedIndex(this.f40586i);
        this.f40582e.post(new Runnable() {
            public void run() {
                if (SimplePickerPopDialog.this.f40587j != null) {
                    SimplePickerPopDialog.this.f40587j.showComplete(SimplePickerPopDialog.this.f40582e);
                }
            }
        });
    }

    /* renamed from: a */
    private void m30473a() {
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                if (!SimplePickerPopDialog.this.f40578a) {
                    return true;
                }
                SimplePickerPopDialog.this.dismiss();
                return true;
            }
        });
    }

    public void setCanCancel(boolean z) {
        this.f40578a = z;
    }

    public void setShowCompleteListener(onViewShowListener onviewshowlistener) {
        this.f40587j = onviewshowlistener;
    }
}
