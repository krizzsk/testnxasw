package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerVerticalDialog extends Dialog {

    /* renamed from: a */
    private FrameLayout f44381a;

    /* renamed from: b */
    private LinearLayout f44382b;

    /* renamed from: c */
    private TextView f44383c;

    /* renamed from: d */
    private TextView f44384d;

    /* renamed from: e */
    private ImageView f44385e;

    /* renamed from: f */
    private String f44386f;

    /* renamed from: g */
    private String f44387g;

    /* renamed from: h */
    private int f44388h;

    /* renamed from: i */
    private View f44389i;

    /* renamed from: j */
    private LifecycleListener f44390j;

    /* renamed from: k */
    private List<Action> f44391k = new ArrayList();

    /* renamed from: l */
    private boolean f44392l = false;

    public interface LifecycleListener {
        void onDismiss(CustomerVerticalDialog customerVerticalDialog);

        void onShow(CustomerVerticalDialog customerVerticalDialog);
    }

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f44392l = true;
        View inflate = layoutInflater.inflate(R.layout.customer_dialog_vertical, viewGroup, false);
        m32993a(inflate);
        return inflate;
    }

    public void onShow() {
        LifecycleListener lifecycleListener = this.f44390j;
        if (lifecycleListener != null) {
            lifecycleListener.onShow(this);
        }
    }

    public void onDismiss() {
        LifecycleListener lifecycleListener = this.f44390j;
        if (lifecycleListener != null) {
            lifecycleListener.onDismiss(this);
        }
    }

    public void setTitle(String str) {
        this.f44386f = str;
        if (this.f44392l) {
            this.f44383c.setText(str);
        }
    }

    public void setMessage(String str) {
        this.f44387g = str;
        if (this.f44392l) {
            this.f44384d.setText(str);
        }
    }

    public void setIcon(int i) {
        this.f44388h = i;
        if (this.f44392l) {
            this.f44385e.setImageResource(i);
        }
    }

    public void setContentView(View view) {
        this.f44389i = view;
        if (this.f44392l) {
            this.f44381a.addView(view);
        }
    }

    public void setLifecycleListener(LifecycleListener lifecycleListener) {
        this.f44390j = lifecycleListener;
    }

    public void addAction(String str) {
        addAction(str, (View.OnClickListener) null);
    }

    public void addAction(String str, View.OnClickListener onClickListener) {
        addAction(str, onClickListener, true);
    }

    public void addAction(String str, final View.OnClickListener onClickListener, final boolean z) {
        boolean z2;
        int i = 0;
        if (this.f44391k.isEmpty()) {
            i = SkinUtil.getDialogMainActionTextColor();
            z2 = true;
        } else {
            z2 = false;
        }
        Action action = new Action(new View.OnClickListener() {
            public void onClick(View view) {
                if (onClickListener == null || z) {
                    CustomerVerticalDialog.this.dismiss();
                }
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }, str, i);
        boolean unused = action.bold = z2;
        this.f44391k.add(action);
        if (this.f44392l) {
            m32994a(action);
        }
    }

    /* renamed from: a */
    private void m32993a(View view) {
        this.f44383c = (TextView) view.findViewById(R.id.tv_vertical_dialog_title);
        this.f44384d = (TextView) view.findViewById(R.id.tv_vertical_dialog_message);
        this.f44385e = (ImageView) view.findViewById(R.id.iv_vertical_dialog_icon);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ll_dialog_content);
        this.f44381a = frameLayout;
        View view2 = this.f44389i;
        if (view2 != null) {
            frameLayout.addView(view2);
        } else {
            if (this.f44387g != null) {
                this.f44384d.setVisibility(0);
                this.f44384d.setText(this.f44387g);
            }
            if (this.f44386f != null) {
                this.f44383c.setVisibility(0);
                this.f44383c.setText(this.f44386f);
            }
            if (this.f44388h > 0) {
                this.f44385e.setVisibility(0);
                this.f44385e.setImageResource(this.f44388h);
            }
        }
        this.f44382b = (LinearLayout) view.findViewById(R.id.ll_action_container);
        if (this.f44391k.size() > 0) {
            for (Action a : this.f44391k) {
                m32994a(a);
            }
        }
    }

    /* renamed from: a */
    private void m32994a(Action action) {
        Context context = this.f44382b.getContext();
        ActionLayout actionLayout = new ActionLayout(context, action);
        actionLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(context, 50.0f)));
        this.f44382b.addView(m32992a(context));
        this.f44382b.addView(actionLayout);
    }

    /* renamed from: a */
    private View m32992a(Context context) {
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(context, 0.5f)));
        view.setBackgroundResource(R.color.rf_color_gery_5_90_E5E5E5);
        return view;
    }

    private static class ActionLayout extends LinearLayout {
        public ActionLayout(Context context, Action action) {
            super(context);
            init(action);
            setGravity(17);
        }

        private void init(Action action) {
            LayoutInflater.from(getContext()).inflate(R.layout.customer_dialog_action_item, this);
            TextView textView = (TextView) findViewById(R.id.tv_action);
            if (!TextUtils.isEmpty(action.text)) {
                textView.setText(action.text);
            }
            if (action.color != 0) {
                textView.setTextColor(action.color);
            }
            if (action.bold) {
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(textView, IToolsService.FontType.BOLD);
            }
            setOnClickListener(action.onClickListener);
        }
    }

    private static class Action {
        /* access modifiers changed from: private */
        public boolean bold;
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public View.OnClickListener onClickListener;
        /* access modifiers changed from: private */
        public String text;

        public Action(View.OnClickListener onClickListener2, String str, int i) {
            this.onClickListener = onClickListener2;
            this.text = str;
            this.color = i;
        }
    }
}
