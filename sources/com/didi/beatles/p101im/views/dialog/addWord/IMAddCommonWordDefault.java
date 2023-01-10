package com.didi.beatles.p101im.views.dialog.addWord;

import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.didi.beatles.p101im.common.IMInputFilter;
import com.didi.beatles.p101im.event.IMAddCustomWordEvent;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.views.dialog.IMAddCommonWordDialog;
import com.taxis99.R;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.dialog.addWord.IMAddCommonWordDefault */
public class IMAddCommonWordDefault implements IMAddCommonWord {

    /* renamed from: a */
    private View.OnClickListener f12024a;

    /* renamed from: b */
    private TextView f12025b;

    /* renamed from: c */
    private TextView f12026c;

    /* renamed from: d */
    private EditText f12027d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f12028e;

    /* renamed from: f */
    private View f12029f;

    /* renamed from: g */
    private EditText f12030g;

    /* renamed from: h */
    private View f12031h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IMAddCommonWordDialog f12032i;

    public int layoutRes() {
        return R.layout.im_add_common_word_view;
    }

    public void release() {
    }

    public void bind(IMAddCommonWordDialog iMAddCommonWordDialog) {
        this.f12032i = iMAddCommonWordDialog;
        m10335a();
    }

    /* renamed from: a */
    private void m10335a() {
        this.f12027d = (EditText) this.f12032i.findViewById(R.id.im_add_common_word_et);
        TextView textView = (TextView) this.f12032i.findViewById(R.id.im_word_count);
        this.f12028e = textView;
        textView.setText(String.format(this.f12032i.getString(R.string.im_word_count_string), new Object[]{0}));
        IMInputFilter iMInputFilter = new IMInputFilter(60);
        this.f12027d.setFilters(new InputFilter[]{iMInputFilter});
        this.f12025b = (TextView) this.f12032i.findViewById(R.id.im_add_common_word_cancel_btn);
        this.f12026c = (TextView) this.f12032i.findViewById(R.id.im_add_common_word_confirm_btn);
        this.f12029f = this.f12032i.findViewById(R.id.im_add_word_view);
        if (this.f12032i.mCommondWordType == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12032i.getString(R.string.im_custom_word));
            String str = "";
            if (this.f12032i.mCustomWordNum != -1) {
                StringBuilder sb2 = new StringBuilder();
                IMAddCommonWordDialog iMAddCommonWordDialog = this.f12032i;
                int i = iMAddCommonWordDialog.mCustomWordNum + 1;
                iMAddCommonWordDialog.mCustomWordNum = i;
                sb2.append(i);
                sb2.append(str);
                str = sb2.toString();
            }
            sb.append(str);
            String sb3 = sb.toString();
            EditText editText = (EditText) this.f12032i.findViewById(R.id.im_add_common_word_title_et);
            this.f12030g = editText;
            editText.setText(sb3);
            EditText editText2 = this.f12030g;
            int i2 = 10;
            if (sb3.length() <= 10) {
                i2 = sb3.length();
            }
            editText2.setSelection(i2);
            this.f12031h = this.f12032i.findViewById(R.id.im_add_word_title_icon);
            this.f12029f.setVisibility(0);
        } else {
            this.f12029f.setVisibility(8);
        }
        m10339b();
        m10340c();
        if (!TextUtils.isEmpty(this.f12032i.mContentText)) {
            this.f12027d.setText(this.f12032i.mContentText);
            this.f12027d.setSelection(this.f12027d.getText().toString().length());
        }
    }

    /* renamed from: b */
    private void m10339b() {
        this.f12027d.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int textNum = !TextUtils.isEmpty(charSequence) ? IMTextUtil.getTextNum(charSequence.toString()) : 0;
                if (textNum >= 60) {
                    SpannableString spannableString = new SpannableString(String.format(IMAddCommonWordDefault.this.f12032i.getString(R.string.im_word_count_string), new Object[]{60}));
                    spannableString.setSpan(new ForegroundColorSpan(IMResource.getColor(R.color.im_nomix_orange)), 0, 2, 18);
                    IMAddCommonWordDefault.this.f12028e.setText(spannableString);
                    return;
                }
                IMAddCommonWordDefault.this.f12028e.setTextColor(IMResource.getColor(R.color.im_add_word_count_color));
                IMAddCommonWordDefault.this.f12028e.setText(String.format(IMAddCommonWordDefault.this.f12032i.getString(R.string.im_word_count_string), new Object[]{Integer.valueOf(textNum)}));
            }
        });
    }

    /* renamed from: a */
    private String m10334a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        if (TextUtils.isEmpty(trim)) {
            return null;
        }
        return Pattern.compile("\\s*\n|\r").matcher(trim).replaceAll("");
    }

    /* renamed from: c */
    private void m10340c() {
        C48862 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMAddCommonWordDefault.this.m10336a(view.getId());
            }
        };
        this.f12024a = r0;
        this.f12025b.setOnClickListener(r0);
        this.f12026c.setOnClickListener(this.f12024a);
        if (this.f12032i.mCommondWordType == 2) {
            this.f12031h.setOnClickListener(this.f12024a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10336a(int i) {
        if (i == R.id.im_add_common_word_cancel_btn) {
            HashMap hashMap = new HashMap();
            hashMap.put("source", Integer.valueOf(this.f12032i.mResource));
            IMMsgOmega.getInstance().track("ddim_dy_all_cancel_ck", hashMap);
            this.f12032i.dismiss();
        } else if (i == R.id.im_add_common_word_confirm_btn) {
            if (m10342e()) {
                EventBus.getDefault().post(new IMAddCustomWordEvent(new IMAddCommonWordDialog.CustomWord(m10341d(), this.f12032i.mResource)));
                this.f12032i.dismiss();
            }
        } else if (i == R.id.im_add_word_title_icon) {
            this.f12030g.setText("");
        }
    }

    /* renamed from: d */
    private String m10341d() {
        if (this.f12032i.mCommondWordType == 1) {
            return m10334a(this.f12027d.getText().toString());
        }
        String obj = this.f12030g.getText().toString();
        String obj2 = this.f12027d.getText().toString();
        return obj + IMTextUtils.DEVIDER_TAG + m10334a(obj2);
    }

    /* renamed from: e */
    private boolean m10342e() {
        if (this.f12032i.mCommondWordType == 2) {
            String obj = this.f12030g.getText().toString();
            if (TextUtils.isEmpty(obj) || TextUtils.getTrimmedLength(obj) < 1) {
                this.f12032i.showToast(IMResource.getString(R.string.im_title_cant_null));
                return false;
            }
        }
        String obj2 = this.f12027d.getText().toString();
        if (!TextUtils.isEmpty(obj2) && TextUtils.getTrimmedLength(obj2) >= 1) {
            return true;
        }
        this.f12032i.showToast(IMResource.getString(R.string.im_content_cant_null));
        return false;
    }
}
