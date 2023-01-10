package com.didi.beatles.p101im.views.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.activity.IMBaseActivity;
import com.didi.beatles.p101im.event.IMMessageUnlockRecyclerViewEvent;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.beatles.p101im.views.dialog.addWord.IMAddCommonWord;
import com.didi.beatles.p101im.views.dialog.addWord.IMAddCommonWordDefault;
import com.didi.beatles.p101im.views.dialog.addWord.IMAddCommonWordGlobalPsg;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.dialog.IMAddCommonWordDialog */
public class IMAddCommonWordDialog extends IMBaseActivity {
    public static final int MAX_LENGTH = 60;
    public static final int MAX_TITLE_LENGTH = 10;
    public static final int MAX_WORD_NUM = 60;
    public static final int RESOUCE_HAND = 1;
    public static final int RESOUCE_LONG_PRESSED = 3;
    public static final int RESOUCE_RECOMMOND = 2;

    /* renamed from: a */
    private static final String f11996a = "custom_word";

    /* renamed from: b */
    private static final String f11997b = "resource";

    /* renamed from: c */
    private static final String f11998c = "word_type";

    /* renamed from: d */
    private static final String f11999d = "word_num";

    /* renamed from: e */
    private static final String f12000e = "bussiness_id";

    /* renamed from: f */
    private IMAddCommonWord f12001f;
    public int mBussinessId;
    public int mCommondWordType;
    public String mContentText;
    public int mCustomWordNum;
    public int mResource = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.dialog.IMAddCommonWordDialog$CommonWordResouce */
    public @interface CommonWordResouce {
    }

    /* access modifiers changed from: protected */
    public boolean isUseTheme() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        m10316a();
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            this.f12001f = new IMAddCommonWordGlobalPsg();
        } else {
            this.f12001f = new IMAddCommonWordDefault();
        }
        setContentView(this.f12001f.layoutRes());
        this.f12001f.bind(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        super.onActivityDestroy();
        IMAddCommonWord iMAddCommonWord = this.f12001f;
        if (iMAddCommonWord != null) {
            iMAddCommonWord.release();
        }
    }

    public static void show(Context context, int i, String str, int i2, int i3, int i4) {
        Intent intent = new Intent(context, IMAddCommonWordDialog.class);
        intent.putExtra(f11996a, str);
        intent.putExtra("resource", i2);
        intent.putExtra("word_type", i3);
        intent.putExtra(f11999d, i4);
        intent.putExtra(f12000e, i);
        context.startActivity(intent);
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i2));
        IMMsgOmega.getInstance().track("ddim_dy_all_add_sw", hashMap);
    }

    /* renamed from: a */
    private void m10316a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mResource = intent.getIntExtra("resource", 1);
            this.mContentText = intent.getStringExtra(f11996a);
            this.mCommondWordType = intent.getIntExtra("word_type", 1);
            this.mCustomWordNum = intent.getIntExtra(f11999d, -1);
            this.mBussinessId = intent.getIntExtra(f12000e, -1);
        }
    }

    public void showToast(String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) "", 0);
        if (Build.VERSION.SDK_INT < 14) {
            makeText.cancel();
        }
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, IMResource.getDrawableID(R.drawable.im_toast_warm));
        IMTipsToast.setText(makeText, str);
    }

    public void dismiss() {
        closeSoftInput();
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                IMAddCommonWordDialog.this.finish();
                EventBus.getDefault().post(new IMMessageUnlockRecyclerViewEvent(0));
            }
        }, 300);
    }

    public void closeSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), 2);
        }
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAddCommonWordDialog$CustomWord */
    public static class CustomWord {
        public int resource;
        public String text;

        public CustomWord(String str, int i) {
            this.text = str;
            this.resource = i;
        }
    }
}
