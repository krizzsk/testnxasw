package com.didi.beatles.p101im.access.exportUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.core.IMMessageListener;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.manager.IMMessageListenerManager;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* renamed from: com.didi.beatles.im.access.exportUI.MessageEnterView */
public class MessageEnterView extends RelativeLayout implements IMMessageListener {

    /* renamed from: a */
    private static final int f10595a = 99;

    /* renamed from: b */
    private View f10596b = null;

    /* renamed from: c */
    private TextView f10597c = null;

    /* renamed from: d */
    private IMSessionUnreadCallback f10598d = null;

    /* renamed from: e */
    private int f10599e = 0;

    /* renamed from: f */
    private boolean f10600f = false;

    public MessageEnterView(Context context) {
        super(context);
    }

    public MessageEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f10596b = findViewById(R.id.message_redpoint);
        this.f10597c = (TextView) findViewById(R.id.message_numv);
    }

    public void refresh() {
        if (this.f10598d == null) {
            this.f10598d = new IMSessionUnreadCallback() {
                public void unReadCount(final int i) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            MessageEnterView.this.m9218a(i);
                        }
                    });
                }
            };
        }
        IMManager.getInstance().getAllUnreadMessageCount(this.f10598d);
    }

    public void onClick() {
        IMTraceUtil.addBusinessEvent("ddim_home_icon_ck").add("redpoint", Integer.valueOf(IMManager.getInstance().isIMHaveRedDot() ? 1 : 0)).add("number", Integer.valueOf(this.f10599e > 0 ? 1 : 0)).add("log_status", 1).report();
        IMManager.getInstance().reInitIM(2);
        IMEngine.startChatListActivity(getContext());
        IMManager.getInstance().clearIMRedDot();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9218a(int i) {
        this.f10599e = i;
        this.f10600f = false;
        if (i > 0) {
            TextView textView = this.f10597c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f10596b.setVisibility(4);
                if (i > 99) {
                    this.f10597c.setText("···");
                } else {
                    TextView textView2 = this.f10597c;
                    textView2.setText(i + "");
                }
                try {
                    this.f10597c.setBackgroundResource(R.drawable.im_dots_with_number);
                } catch (Exception e) {
                    IMLog.m10020d("im_sdk", e.getMessage());
                }
            }
        } else {
            boolean isIMHaveRedDot = IMManager.getInstance().isIMHaveRedDot();
            this.f10600f = isIMHaveRedDot;
            if (isIMHaveRedDot) {
                this.f10597c.setVisibility(4);
                this.f10596b.setVisibility(0);
                return;
            }
            this.f10597c.setVisibility(4);
            this.f10596b.setVisibility(4);
        }
    }

    public Map<String, Object> getStateMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("number", Integer.valueOf(this.f10599e > 0 ? 1 : 0));
        hashMap.put("redpoint", Integer.valueOf(this.f10600f ? 1 : 0));
        return hashMap;
    }

    public void resetState() {
        TextView textView = this.f10597c;
        if (textView != null) {
            textView.setVisibility(4);
        }
        View view = this.f10596b;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IMMessageListenerManager.getInstance().addMessageListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IMMessageListenerManager.getInstance().removeMessageListener(this);
    }

    public void onDestory() {
        IMEngine.getInstance(getContext().getApplicationContext()).removeMessageListener(this);
    }

    public void onMessageArrive() {
        if (isShown()) {
            refresh();
        }
    }
}
