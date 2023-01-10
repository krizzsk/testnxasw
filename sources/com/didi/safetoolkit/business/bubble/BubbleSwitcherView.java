package com.didi.safetoolkit.business.bubble;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.util.SfOnAntiShakeClickListener;
import com.didi.safetoolkit.util.SfViewUtils;
import com.google.gson.JsonObject;
import com.taxis99.R;

public class BubbleSwitcherView extends LinearLayout {

    /* renamed from: a */
    private TextView f37007a;

    /* renamed from: b */
    private TextView f37008b;

    /* renamed from: c */
    private TextView f37009c;

    /* renamed from: d */
    private TextView f37010d;

    /* renamed from: e */
    private LinearLayout f37011e;

    /* renamed from: f */
    private FrameLayout f37012f;

    /* renamed from: g */
    private ImageView f37013g;

    /* renamed from: h */
    private Context f37014h;

    public interface ClickListener {
        void onActionClick(String str);
    }

    public BubbleSwitcherView(Context context) {
        super(context);
        this.f37014h = context;
        m27950a(context);
    }

    /* renamed from: a */
    private void m27950a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.sf_jarvis_switcher_layout, this, true);
        this.f37007a = (TextView) findViewById(R.id.sf_safe_toolkit_bubble_msg);
        this.f37008b = (TextView) findViewById(R.id.sf_safe_toolkit_bubble_action);
        this.f37009c = (TextView) findViewById(R.id.sf_safe_toolkit_bubble_action_left);
        this.f37010d = (TextView) findViewById(R.id.sf_safe_toolkit_bubble_action_right);
        this.f37011e = (LinearLayout) findViewById(R.id.sf_safe_toolkit_bubble_action_two);
        this.f37012f = (FrameLayout) findViewById(R.id.sf_right_of_msg_layout);
        this.f37013g = (ImageView) findViewById(R.id.sf_link_arrow);
    }

    public void setSize(int i) {
        View findViewById;
        if (i > 0 && (findViewById = findViewById(R.id.tips_container)) != null && findViewById.getLayoutParams() != null) {
            findViewById.getLayoutParams().height = i;
        }
    }

    public void updateSwitcherView(final SfBubbleData sfBubbleData, final ClickListener clickListener) {
        if (sfBubbleData == null || clickListener == null) {
            setMsg((String) null, (String) null);
            setActionTwoVisibility(false);
            setRightOfMsgLayoutVisible(false);
            return;
        }
        setMsg(sfBubbleData.text, sfBubbleData.textColor);
        if (sfBubbleData.btns == null) {
            setActionTwoVisibility(false);
            setRightOfMsgLayoutVisible(false);
        } else if (sfBubbleData.btns.size() == 2) {
            setActionTwoVisibility(true);
            setRightOfMsgLayoutVisible(false);
            if (sfBubbleData.btns.get(0) != null) {
                setActionLeft(true, sfBubbleData.btns.get(0).bgColor, sfBubbleData.btns.get(0).text, sfBubbleData.btns.get(0).textColor, new SfOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        clickListener.onActionClick(sfBubbleData.btns.get(0).action);
                        BubbleSwitcherView.this.m27953a(sfBubbleData.btns.get(0).track);
                    }
                });
                if (sfBubbleData.btns.get(1) != null) {
                    setActionRight(true, sfBubbleData.btns.get(0).bgColor, sfBubbleData.btns.get(1).text, sfBubbleData.btns.get(0).textColor, new SfOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            clickListener.onActionClick(sfBubbleData.btns.get(1).action);
                            BubbleSwitcherView.this.m27953a(sfBubbleData.btns.get(1).track);
                        }
                    });
                }
            }
        } else if (sfBubbleData.btns.size() == 1) {
            setRightOfMsgLayoutVisible(true);
            setActionTwoVisibility(false);
            if (sfBubbleData.btns.get(0) != null) {
                setActionTv(true, sfBubbleData.btns.get(0).bgColor, sfBubbleData.btns.get(0).text, sfBubbleData.btns.get(0).textColor, new SfOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        clickListener.onActionClick(sfBubbleData.btns.get(0).action);
                        BubbleSwitcherView.this.m27953a(sfBubbleData.btns.get(0).track);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27953a(JsonObject jsonObject) {
        SfOmegaUtil.addEventId("ibt_gp_safetyicon_bubble_btn_ck").addKeyValue(SfOmegaUtil.getJsonObjectMap(jsonObject)).report();
    }

    public void setLinkArrowVisible(boolean z) {
        if (this.f37013g != null) {
            setRightOfMsgLayoutVisible(z);
            if (z) {
                this.f37013g.setVisibility(0);
            } else {
                this.f37013g.setVisibility(8);
            }
        }
    }

    public void setRightOfMsgLayoutVisible(boolean z) {
        FrameLayout frameLayout = this.f37012f;
        if (frameLayout != null) {
            if (z) {
                frameLayout.setVisibility(0);
            } else {
                frameLayout.setVisibility(8);
            }
        }
    }

    public void setActionTwoVisibility(boolean z) {
        LinearLayout linearLayout = this.f37011e;
        if (linearLayout != null) {
            if (z) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void setActionTv(boolean z, String str, String str2, String str3, View.OnClickListener onClickListener) {
        m27951a(this.f37008b, z, str, str2, str3, SfViewUtils.dp2px(this.f37014h, 15.0f), onClickListener);
    }

    public void setActionLeft(boolean z, String str, String str2, String str3, View.OnClickListener onClickListener) {
        m27951a(this.f37009c, z, str, str2, str3, SfViewUtils.dp2px(this.f37014h, 12.5f), onClickListener);
    }

    public void setActionRight(boolean z, String str, String str2, String str3, View.OnClickListener onClickListener) {
        m27951a(this.f37010d, z, str, str2, str3, SfViewUtils.dp2px(this.f37014h, 12.5f), onClickListener);
    }

    /* renamed from: a */
    private void m27951a(TextView textView, boolean z, String str, String str2, String str3, int i, View.OnClickListener onClickListener) {
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setVisibility(0);
            textView.setText(str2);
            if (!TextUtils.isEmpty(str3)) {
                textView.setTextColor(Color.parseColor(str3));
            }
            textView.setBackground(createBgDrawable(str, i));
            textView.setOnClickListener(onClickListener);
            return;
        }
        textView.setVisibility(8);
    }

    public void setMsg(String str, String str2) {
        TextView textView;
        if (!TextUtils.isEmpty(str) || (textView = this.f37007a) == null) {
            TextView textView2 = this.f37007a;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.f37007a.setText(str);
                if (!TextUtils.isEmpty(str2)) {
                    this.f37007a.setTextColor(Color.parseColor(str2));
                    return;
                }
                return;
            }
            return;
        }
        textView.setVisibility(8);
    }

    public GradientDrawable createBgDrawable(String str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (TextUtils.isEmpty(str) || str.length() < 1) {
            str = "#00000000";
        }
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) i);
        return gradientDrawable;
    }
}
