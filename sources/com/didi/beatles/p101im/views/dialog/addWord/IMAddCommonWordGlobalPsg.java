package com.didi.beatles.p101im.views.dialog.addWord;

import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.event.IMAddCustomWordEvent;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.views.dialog.IMAddCommonWordDialog;
import com.taxis99.R;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.dialog.addWord.IMAddCommonWordGlobalPsg */
public class IMAddCommonWordGlobalPsg implements IMAddCommonWord {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IMAddCommonWordDialog f12033a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f12034b;

    /* renamed from: c */
    private EditText f12035c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f12036d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f12037e;

    /* renamed from: f */
    private View f12038f;

    /* renamed from: g */
    private View f12039g;

    /* renamed from: h */
    private View f12040h;

    public int layoutRes() {
        return R.layout.im_add_common_word_view_global_psg;
    }

    public void release() {
    }

    public void bind(IMAddCommonWordDialog iMAddCommonWordDialog) {
        this.f12033a = iMAddCommonWordDialog;
        m10345a();
        m10346b();
        this.f12035c.requestFocus();
    }

    /* renamed from: a */
    private void m10345a() {
        Window window = this.f12033a.getWindow();
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
    }

    /* renamed from: b */
    private void m10346b() {
        this.f12039g = this.f12033a.findViewById(R.id.im_add_common_word_parent);
        this.f12040h = this.f12033a.findViewById(R.id.im_add_common_word_layout);
        this.f12037e = this.f12033a.findViewById(R.id.im_add_common_word_confirm_line);
        this.f12038f = this.f12033a.findViewById(R.id.im_add_common_word_confirm_close);
        this.f12035c = (EditText) this.f12033a.findViewById(R.id.im_add_common_word_et);
        TextView textView = (TextView) this.f12033a.findViewById(R.id.im_word_count);
        this.f12036d = textView;
        textView.setText(String.format(this.f12033a.getString(R.string.im_word_count_string), new Object[]{0}));
        this.f12034b = (TextView) this.f12033a.findViewById(R.id.im_add_common_word_confirm_btn);
        m10349c();
        if (!TextUtils.isEmpty(this.f12033a.mContentText)) {
            this.f12035c.setText(this.f12033a.mContentText);
            this.f12035c.setSelection(this.f12035c.getText().toString().length());
        }
        this.f12039g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMAddCommonWordGlobalPsg.this.f12033a.closeSoftInput();
            }
        });
        this.f12040h.setClickable(true);
        this.f12034b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMAddCommonWordGlobalPsg.this.m10353e()) {
                    EventBus.getDefault().post(new IMAddCustomWordEvent(new IMAddCommonWordDialog.CustomWord(IMAddCommonWordGlobalPsg.this.m10351d(), IMAddCommonWordGlobalPsg.this.f12033a.mResource)));
                    IMAddCommonWordGlobalPsg.this.f12033a.dismiss();
                }
            }
        });
        this.f12038f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMAddCommonWordGlobalPsg.this.f12033a.dismiss();
            }
        });
    }

    /* renamed from: c */
    private void m10349c() {
        this.f12035c.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                boolean z = false;
                int textNum = !TextUtils.isEmpty(charSequence) ? IMTextUtil.getTextNum(charSequence.toString()) : 0;
                IMAddCommonWordGlobalPsg.this.f12036d.setText(String.format(IMAddCommonWordGlobalPsg.this.f12033a.getString(R.string.im_word_count_string), new Object[]{Integer.valueOf(textNum)}));
                IMAddCommonWordGlobalPsg.this.f12036d.setSelected(textNum > 60);
                IMAddCommonWordGlobalPsg.this.f12037e.setSelected(textNum > 60);
                TextView f = IMAddCommonWordGlobalPsg.this.f12034b;
                if (textNum > 0 && textNum <= 60) {
                    z = true;
                }
                f.setEnabled(z);
            }
        });
    }

    /* renamed from: a */
    private String m10344a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        if (TextUtils.isEmpty(trim)) {
            return null;
        }
        return Pattern.compile("\\s*\n|\r").matcher(trim).replaceAll("");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m10351d() {
        return m10344a(this.f12035c.getText().toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m10353e() {
        String obj = this.f12035c.getText().toString();
        if (!TextUtils.isEmpty(obj) && TextUtils.getTrimmedLength(obj) >= 1) {
            return true;
        }
        this.f12033a.showToast(IMResource.getString(R.string.im_content_cant_null));
        return false;
    }
}
