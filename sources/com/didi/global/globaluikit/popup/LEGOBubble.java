package com.didi.global.globaluikit.popup;

import android.content.Context;
import android.view.View;
import androidx.core.widget.PopupWindowCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.popup.model.LEGOBubbleBaseModel;

public class LEGOBubble {

    /* renamed from: a */
    private C9259a f24509a;

    public LEGOBubble(Context context) {
        this.f24509a = new C9259a(context);
    }

    public void setBubbleContent(String str, int i, String str2, int i2, boolean z, BubbleCloseListener bubbleCloseListener) {
        m19666a(str, i, str2, i2, "", -1, (View) null, 0, 0, z, bubbleCloseListener);
    }

    /* renamed from: a */
    private void m19666a(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, BubbleCloseListener bubbleCloseListener) {
        final BubbleCloseListener bubbleCloseListener2 = bubbleCloseListener;
        this.f24509a.mo72288a(str, i, str2, i2, str3, i3, view, i4, i5, z, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BubbleCloseListener bubbleCloseListener = bubbleCloseListener2;
                if (bubbleCloseListener != null) {
                    bubbleCloseListener.onClick(LEGOBubble.this);
                } else {
                    LEGOBubble.this.dismiss();
                }
            }
        });
    }

    public boolean isShowing() {
        return this.f24509a.isShowing();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72211a(int i) {
        this.f24509a.mo72279a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72217a(String str) {
        this.f24509a.mo72286a(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72220b(int i) {
        this.f24509a.mo72292b(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72212a(int i, int i2, int i3) {
        this.f24509a.mo72281a(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72221b(String str) {
        this.f24509a.mo72287a(str, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72218a(String str, int i) {
        this.f24509a.mo72287a(str, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo72224c(String str) {
        this.f24509a.mo72294b(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo72223c(int i) {
        this.f24509a.mo72297c(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72214a(View view) {
        this.f24509a.mo72283a(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72210a() {
        this.f24509a.mo72300d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72215a(View view, int i, int i2) {
        this.f24509a.mo72284a(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72219a(boolean z) {
        this.f24509a.mo72290a(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72216a(final BubbleCloseListener bubbleCloseListener) {
        this.f24509a.mo72282a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BubbleCloseListener bubbleCloseListener = bubbleCloseListener;
                if (bubbleCloseListener != null) {
                    bubbleCloseListener.onClick(LEGOBubble.this);
                } else {
                    LEGOBubble.this.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72222b(boolean z) {
        this.f24509a.mo72295b(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo72225d(int i) {
        this.f24509a.mo72301d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72213a(View.OnClickListener onClickListener) {
        this.f24509a.mo72293b(onClickListener);
    }

    public void setBubbleContent(final LEGOBubbleBaseModel lEGOBubbleBaseModel) {
        this.f24509a.mo72285a(new C9260b(lEGOBubbleBaseModel, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (lEGOBubbleBaseModel.closeListener != null) {
                    lEGOBubbleBaseModel.closeListener.onClick(LEGOBubble.this);
                } else {
                    LEGOBubble.this.dismiss();
                }
            }
        }));
    }

    public View getView() {
        this.f24509a.getContentView().measure(0, 0);
        return this.f24509a.getContentView();
    }

    public void show(View view) {
        show(view, 0, 0);
    }

    public void show(View view, int i, int i2) {
        show(view, i, i2, 1000);
    }

    public void show(View view, int i, int i2, int i3) {
        PopupWindowCompat.setWindowLayoutType(this.f24509a, i3);
        this.f24509a.mo72296b(view, i, i2);
    }

    public void dismiss() {
        this.f24509a.dismiss();
    }

    public int getPopupWidth() {
        return this.f24509a.mo72278a();
    }

    public int[] getMeasureWidthAndHeight() {
        return this.f24509a.mo72299c();
    }

    public void setWidthAndHeight(int i, int i2) {
        this.f24509a.mo72280a(i, i2);
    }

    public int getPopupHeight() {
        return this.f24509a.mo72291b();
    }

    public static class Builder {
        private LEGOBubble bubble;

        public Builder(Context context) {
            this.bubble = new LEGOBubble(context);
        }

        public LEGOBubble build() {
            this.bubble.mo72210a();
            return this.bubble;
        }

        public Builder setBgColor(int i) {
            this.bubble.mo72211a(i);
            return this;
        }

        public Builder setText(String str) {
            this.bubble.mo72217a(str);
            return this;
        }

        public Builder setTextTypeface(int i) {
            this.bubble.mo72220b(i);
            return this;
        }

        public Builder setTextProps(int i, int i2, int i3) {
            this.bubble.mo72212a(i, i2, i3);
            return this;
        }

        public Builder setLeftDrawable(String str) {
            this.bubble.mo72224c(str);
            return this;
        }

        public Builder setLeftDrawable(int i) {
            this.bubble.mo72223c(i);
            return this;
        }

        public Builder setLeftView(View view) {
            this.bubble.mo72214a(view);
            return this;
        }

        public Builder setLeftView(View view, int i, int i2) {
            this.bubble.mo72215a(view, i, i2);
            return this;
        }

        public Builder setCloseBtnVisible(boolean z) {
            this.bubble.mo72219a(z);
            return this;
        }

        public Builder setCloseBtnListener(BubbleCloseListener bubbleCloseListener) {
            this.bubble.mo72216a(bubbleCloseListener);
            return this;
        }

        public Builder setDirection(String str) {
            this.bubble.mo72218a(str, 0);
            return this;
        }

        public Builder setDirection(String str, int i) {
            this.bubble.mo72218a(str, i);
            return this;
        }

        public Builder setOutSideTouch(boolean z) {
            this.bubble.mo72222b(z);
            return this;
        }

        public Builder setMaxLines(int i) {
            this.bubble.mo72225d(i);
            return this;
        }

        public Builder setContentViewOnClick(View.OnClickListener onClickListener) {
            this.bubble.mo72213a(onClickListener);
            return this;
        }

        public Builder setWidthAndHeight(int i, int i2) {
            this.bubble.setWidthAndHeight(i, i2);
            return this;
        }
    }
}
