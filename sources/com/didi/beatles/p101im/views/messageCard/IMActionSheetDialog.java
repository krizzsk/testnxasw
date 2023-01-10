package com.didi.beatles.p101im.views.messageCard;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.messageCard.IMActionSheetDialog */
public class IMActionSheetDialog {

    /* renamed from: a */
    private Context f12131a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Dialog f12132b;

    /* renamed from: c */
    private TextView f12133c;

    /* renamed from: d */
    private TextView f12134d;

    /* renamed from: e */
    private LinearLayout f12135e;

    /* renamed from: f */
    private ScrollView f12136f;

    /* renamed from: g */
    private boolean f12137g = false;

    /* renamed from: h */
    private List<SheetItem> f12138h;

    /* renamed from: i */
    private Display f12139i;

    /* renamed from: com.didi.beatles.im.views.messageCard.IMActionSheetDialog$OnSheetItemClickListener */
    public interface OnSheetItemClickListener {
        void onClick(int i);
    }

    public IMActionSheetDialog(Context context) {
        this.f12131a = context;
        this.f12139i = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public IMActionSheetDialog builder() {
        View inflate = LayoutInflater.from(this.f12131a).inflate(R.layout.bts_im_view_actionsheet, (ViewGroup) null);
        inflate.setMinimumWidth(this.f12139i.getWidth());
        this.f12136f = (ScrollView) inflate.findViewById(R.id.sLayout_content);
        this.f12135e = (LinearLayout) inflate.findViewById(R.id.lLayout_content);
        this.f12133c = (TextView) inflate.findViewById(R.id.txt_title);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_cancel);
        this.f12134d = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMActionSheetDialog.this.f12132b.dismiss();
            }
        });
        Dialog dialog = new Dialog(this.f12131a, R.style.IMActionSheetDialogStyle);
        this.f12132b = dialog;
        dialog.setContentView(inflate);
        Window window = this.f12132b.getWindow();
        window.setGravity(83);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        return this;
    }

    public IMActionSheetDialog setTitle(String str) {
        this.f12137g = true;
        this.f12133c.setVisibility(0);
        this.f12133c.setText(str);
        return this;
    }

    public IMActionSheetDialog setCancelable(boolean z) {
        this.f12132b.setCancelable(z);
        return this;
    }

    public IMActionSheetDialog setCanceledOnTouchOutside(boolean z) {
        this.f12132b.setCanceledOnTouchOutside(z);
        return this;
    }

    public IMActionSheetDialog addSheetItem(String str, SheetItemColor sheetItemColor, OnSheetItemClickListener onSheetItemClickListener) {
        if (this.f12138h == null) {
            this.f12138h = new ArrayList();
        }
        this.f12138h.add(new SheetItem(str, sheetItemColor, onSheetItemClickListener));
        return this;
    }

    public IMActionSheetDialog addSheetItem(String[] strArr, SheetItemColor sheetItemColor, OnSheetItemClickListener onSheetItemClickListener) {
        if (this.f12138h == null) {
            this.f12138h = new ArrayList();
        }
        if (strArr != null && strArr.length > 0) {
            for (String sheetItem : strArr) {
                this.f12138h.add(new SheetItem(sheetItem, sheetItemColor, onSheetItemClickListener));
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m10412a() {
        List<SheetItem> list = this.f12138h;
        if (list != null && list.size() > 0) {
            final int size = this.f12138h.size();
            if (size >= 7) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12136f.getLayoutParams();
                layoutParams.height = this.f12139i.getHeight() / 2;
                this.f12136f.setLayoutParams(layoutParams);
            }
            for (final int i = 1; i <= size; i++) {
                SheetItem sheetItem = this.f12138h.get(i - 1);
                String str = sheetItem.name;
                SheetItemColor sheetItemColor = sheetItem.color;
                final OnSheetItemClickListener onSheetItemClickListener = sheetItem.itemClickListener;
                TextView textView = new TextView(this.f12131a);
                textView.setText(str);
                textView.setTextSize(16.0f);
                textView.setGravity(17);
                if (size == 1) {
                    if (this.f12137g) {
                        textView.setBackgroundResource(R.drawable.im_actionsheet_bottom_selector);
                    } else {
                        textView.setBackgroundResource(R.drawable.im_actionsheet_single_selector);
                    }
                } else if (this.f12137g) {
                    if (i < 1 || i >= size) {
                        textView.setBackgroundResource(R.drawable.im_actionsheet_bottom_selector);
                    } else {
                        textView.setBackgroundResource(R.drawable.im_actionsheet_middle_selector);
                    }
                } else if (i == 1) {
                    textView.setBackgroundResource(R.drawable.im_actionsheet_top_selector);
                } else if (i < size) {
                    textView.setBackgroundResource(R.drawable.im_actionsheet_middle_selector);
                } else {
                    textView.setBackgroundResource(R.drawable.im_actionsheet_bottom_selector);
                }
                if (sheetItemColor == null) {
                    textView.setTextColor(Color.parseColor(SheetItemColor.Blue.getName()));
                } else {
                    textView.setTextColor(Color.parseColor(sheetItemColor.getName()));
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams(-1, IMViewUtil.dp2px(this.f12131a, 45.0f)));
                textView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        onSheetItemClickListener.onClick(size - i);
                        IMActionSheetDialog.this.f12132b.dismiss();
                    }
                });
                this.f12135e.addView(textView);
            }
        }
    }

    public void show() {
        m10412a();
        Context context = this.f12131a;
        if (context == null || !(context instanceof FragmentActivity)) {
            SystemUtils.showDialog(this.f12132b);
        } else if (!((FragmentActivity) context).isFinishing()) {
            SystemUtils.showDialog(this.f12132b);
        }
    }

    /* renamed from: com.didi.beatles.im.views.messageCard.IMActionSheetDialog$SheetItem */
    public class SheetItem {
        SheetItemColor color;
        OnSheetItemClickListener itemClickListener;
        String name;

        public SheetItem(String str, SheetItemColor sheetItemColor, OnSheetItemClickListener onSheetItemClickListener) {
            this.name = str;
            this.color = sheetItemColor;
            this.itemClickListener = onSheetItemClickListener;
        }
    }

    /* renamed from: com.didi.beatles.im.views.messageCard.IMActionSheetDialog$SheetItemColor */
    public enum SheetItemColor {
        Blue("#333333"),
        Red("#FD4A2E");
        
        private String name;

        private SheetItemColor(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }
    }
}
