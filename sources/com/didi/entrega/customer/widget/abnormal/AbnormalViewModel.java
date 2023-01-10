package com.didi.entrega.customer.widget.abnormal;

import android.view.View;

public class AbnormalViewModel {
    public View.OnClickListener clickListener;
    public int resId;
    public String retryText;
    public String subTitle;
    public String title;

    public static class Builder {

        /* renamed from: t */
        private AbnormalViewModel f22221t = new AbnormalViewModel();

        public AbnormalViewModel build() {
            return this.f22221t;
        }

        public Builder setClickListener(View.OnClickListener onClickListener) {
            this.f22221t.clickListener = onClickListener;
            return this;
        }

        public Builder setResId(int i) {
            this.f22221t.resId = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.f22221t.title = str;
            return this;
        }

        public Builder setSubTitle(String str) {
            this.f22221t.subTitle = str;
            return this;
        }

        public Builder setRetryText(String str) {
            this.f22221t.retryText = str;
            return this;
        }
    }
}
