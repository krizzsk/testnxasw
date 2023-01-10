package com.didi.soda.search.component.header;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class SearchView extends RelativeLayout {

    /* renamed from: a */
    private Context f46255a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AppCompatEditText f46256b;

    /* renamed from: c */
    private ImageView f46257c;

    /* renamed from: d */
    private View f46258d;

    /* renamed from: e */
    private RelativeLayout f46259e;

    /* renamed from: f */
    private RFIconView f46260f;

    /* renamed from: g */
    private LottieLoadingView f46261g;

    public SearchView(Context context) {
        super(context);
        this.f46255a = context;
        m34404a();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46255a = context;
        m34404a();
    }

    public EditText getEditView() {
        return this.f46256b;
    }

    public RFIconView getSearchButton() {
        return this.f46260f;
    }

    public void showOrHideLoading(boolean z) {
        if (z) {
            this.f46261g.setVisibility(0);
            if (!this.f46261g.isRunning()) {
                this.f46261g.start();
            }
            this.f46257c.setVisibility(8);
            this.f46258d.setVisibility(8);
            this.f46260f.setVisibility(8);
            this.f46259e.setSelected(false);
            return;
        }
        this.f46261g.stop();
        this.f46261g.setVisibility(8);
        this.f46259e.setSelected(true);
        if (TextUtils.isEmpty(this.f46256b.getText().toString())) {
            this.f46257c.setVisibility(8);
        } else {
            this.f46257c.setVisibility(0);
        }
        this.f46258d.setVisibility(0);
        this.f46260f.setVisibility(0);
    }

    public void goneAllRightView() {
        this.f46257c.setVisibility(8);
        this.f46258d.setVisibility(8);
        this.f46260f.setVisibility(8);
        this.f46259e.setSelected(false);
    }

    public void visibleAllRightView() {
        if (this.f46261g.getVisibility() != 0) {
            if (TextUtils.isEmpty(this.f46256b.getText().toString())) {
                this.f46257c.setVisibility(8);
            } else {
                this.f46257c.setVisibility(0);
            }
            this.f46258d.setVisibility(0);
            this.f46260f.setVisibility(0);
            this.f46259e.setSelected(true);
        }
    }

    /* renamed from: a */
    private void m34404a() {
        LayoutInflater.from(this.f46255a).inflate(R.layout.customer_view_search, this);
        this.f46256b = (AppCompatEditText) findViewById(R.id.customer_custom_address_search);
        this.f46257c = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f46258d = findViewById(R.id.v_line);
        this.f46259e = (RelativeLayout) findViewById(R.id.customer_rl_address_search);
        this.f46260f = (RFIconView) findViewById(R.id.customer_iv_search);
        LottieLoadingView lottieLoadingView = (LottieLoadingView) findViewById(R.id.customer_la_search_loading);
        this.f46261g = lottieLoadingView;
        lottieLoadingView.hide();
        this.f46257c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchView.this.f46256b.setText("");
            }
        });
    }
}
