package com.didi.global.fintech.cashier.p118ui.widget.popup;

import android.content.Context;
import android.view.View;
import androidx.core.widget.PopupWindowCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.fintech.cashier.p118ui.widget.popup.model.CashierBubbleBaseModel;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.CashierBubble */
public class CashierBubble {

    /* renamed from: a */
    private C9111a f23839a;

    public CashierBubble(Context context) {
        this.f23839a = new C9111a(context);
    }

    public void setBubbleContent(String str, int i, String str2, int i2, boolean z, BubbleCloseListener bubbleCloseListener) {
        m19282a(str, i, str2, i2, "", -1, (View) null, 0, 0, z, bubbleCloseListener);
    }

    /* renamed from: a */
    private void m19282a(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, BubbleCloseListener bubbleCloseListener) {
        final BubbleCloseListener bubbleCloseListener2 = bubbleCloseListener;
        this.f23839a.mo71401a(str, i, str2, i2, str3, i3, view, i4, i5, z, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BubbleCloseListener bubbleCloseListener = bubbleCloseListener2;
                if (bubbleCloseListener != null) {
                    bubbleCloseListener.onClick(CashierBubble.this);
                } else {
                    CashierBubble.this.dismiss();
                }
            }
        });
    }

    public boolean isShowing() {
        return this.f23839a.isShowing();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71324a(int i) {
        this.f23839a.mo71392a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71330a(String str) {
        this.f23839a.mo71399a(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71333b(int i) {
        this.f23839a.mo71405b(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71325a(int i, int i2, int i3) {
        this.f23839a.mo71394a(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71334b(String str) {
        this.f23839a.mo71400a(str, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71331a(String str, int i) {
        this.f23839a.mo71400a(str, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo71337c(String str) {
        this.f23839a.mo71407b(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo71336c(int i) {
        this.f23839a.mo71410c(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71327a(View view) {
        this.f23839a.mo71396a(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71323a() {
        this.f23839a.mo71413d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71328a(View view, int i, int i2) {
        this.f23839a.mo71397a(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71332a(boolean z) {
        this.f23839a.mo71403a(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71329a(final BubbleCloseListener bubbleCloseListener) {
        this.f23839a.mo71395a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BubbleCloseListener bubbleCloseListener = bubbleCloseListener;
                if (bubbleCloseListener != null) {
                    bubbleCloseListener.onClick(CashierBubble.this);
                } else {
                    CashierBubble.this.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71335b(boolean z) {
        this.f23839a.mo71408b(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo71338d(int i) {
        this.f23839a.mo71414d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71326a(View.OnClickListener onClickListener) {
        this.f23839a.mo71406b(onClickListener);
    }

    public void setBubbleContent(final CashierBubbleBaseModel cashierBubbleBaseModel) {
        this.f23839a.mo71398a(new C9112b(cashierBubbleBaseModel, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (cashierBubbleBaseModel.closeListener != null) {
                    cashierBubbleBaseModel.closeListener.onClick(CashierBubble.this);
                } else {
                    CashierBubble.this.dismiss();
                }
            }
        }));
    }

    public View getView() {
        this.f23839a.getContentView().measure(0, 0);
        return this.f23839a.getContentView();
    }

    public void show(View view) {
        show(view, 0, 0);
    }

    public void show(View view, int i, int i2) {
        show(view, i, i2, 1050);
    }

    public void show(View view, int i, int i2, int i3) {
        PopupWindowCompat.setWindowLayoutType(this.f23839a, i3);
        this.f23839a.mo71409b(view, i, i2);
    }

    public void dismiss() {
        this.f23839a.dismiss();
    }

    public int getPopupWidth() {
        return this.f23839a.mo71391a();
    }

    public int[] getMeasureWidthAndHeight() {
        return this.f23839a.mo71412c();
    }

    public void setWidthAndHeight(int i, int i2) {
        this.f23839a.mo71393a(i, i2);
    }

    public int getPopupHeight() {
        return this.f23839a.mo71404b();
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.CashierBubble$Builder */
    public static class Builder {
        private CashierBubble bubble;

        public Builder(Context context) {
            this.bubble = new CashierBubble(context);
        }

        public CashierBubble build() {
            this.bubble.mo71323a();
            return this.bubble;
        }

        public Builder setBgColor(int i) {
            this.bubble.mo71324a(i);
            return this;
        }

        public Builder setText(String str) {
            this.bubble.mo71330a(str);
            return this;
        }

        public Builder setTextTypeface(int i) {
            this.bubble.mo71333b(i);
            return this;
        }

        public Builder setTextProps(int i, int i2, int i3) {
            this.bubble.mo71325a(i, i2, i3);
            return this;
        }

        public Builder setLeftDrawable(String str) {
            this.bubble.mo71337c(str);
            return this;
        }

        public Builder setLeftDrawable(int i) {
            this.bubble.mo71336c(i);
            return this;
        }

        public Builder setLeftView(View view) {
            this.bubble.mo71327a(view);
            return this;
        }

        public Builder setLeftView(View view, int i, int i2) {
            this.bubble.mo71328a(view, i, i2);
            return this;
        }

        public Builder setCloseBtnVisible(boolean z) {
            this.bubble.mo71332a(z);
            return this;
        }

        public Builder setCloseBtnListener(BubbleCloseListener bubbleCloseListener) {
            this.bubble.mo71329a(bubbleCloseListener);
            return this;
        }

        public Builder setDirection(String str) {
            this.bubble.mo71331a(str, 0);
            return this;
        }

        public Builder setDirection(String str, int i) {
            this.bubble.mo71331a(str, i);
            return this;
        }

        public Builder setOutSideTouch(boolean z) {
            this.bubble.mo71335b(z);
            return this;
        }

        public Builder setMaxLines(int i) {
            this.bubble.mo71338d(i);
            return this;
        }

        public Builder setContentViewOnClick(View.OnClickListener onClickListener) {
            this.bubble.mo71326a(onClickListener);
            return this;
        }

        public Builder setWidthAndHeight(int i, int i2) {
            this.bubble.setWidthAndHeight(i, i2);
            return this;
        }
    }
}
