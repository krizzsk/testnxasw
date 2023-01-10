package com.didi.soda.customer.widget.abnormal;

import android.view.View;

public class AbnormalViewModel {
    public int backgroundResId;
    public View.OnClickListener clickListener;
    public int resId;
    public String title;
    public int titleId;

    public static class Builder {

        /* renamed from: t */
        private AbnormalViewModel f44232t = new AbnormalViewModel();

        public AbnormalViewModel build() {
            return this.f44232t;
        }

        public Builder setClickListener(View.OnClickListener onClickListener) {
            this.f44232t.clickListener = onClickListener;
            return this;
        }

        public Builder setResId(int i) {
            this.f44232t.resId = i;
            return this;
        }

        public Builder setResTitle(int i) {
            this.f44232t.titleId = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.f44232t.title = str;
            return this;
        }

        public Builder setBackgroundResId(int i) {
            this.f44232t.backgroundResId = i;
            return this;
        }
    }
}
