package com.didi.soda.customer.widget.abnormal.topgun;

import android.view.View;

public class TopGunAbnormalViewModel {
    public View.OnClickListener clickListener;
    public int resId;
    public String retryText;
    public String subTitle;
    public String title;

    public static class Builder {

        /* renamed from: t */
        private TopGunAbnormalViewModel f44252t = new TopGunAbnormalViewModel();

        public TopGunAbnormalViewModel build() {
            return this.f44252t;
        }

        public Builder setClickListener(View.OnClickListener onClickListener) {
            this.f44252t.clickListener = onClickListener;
            return this;
        }

        public Builder setResId(int i) {
            this.f44252t.resId = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.f44252t.title = str;
            return this;
        }

        public Builder setSubTitle(String str) {
            this.f44252t.subTitle = str;
            return this;
        }

        public Builder setRetryText(String str) {
            this.f44252t.retryText = str;
            return this;
        }
    }
}
