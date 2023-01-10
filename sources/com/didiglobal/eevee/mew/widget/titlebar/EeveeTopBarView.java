package com.didiglobal.eevee.mew.widget.titlebar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.taxis99.R;

public class EeveeTopBarView implements EeveeIView<C17608a> {

    /* renamed from: a */
    private C17608a f52654a;

    /* renamed from: b */
    private ViewGroup f52655b;

    /* renamed from: c */
    private ImageView f52656c;

    public void setView() {
    }

    public View getView() {
        return this.f52655b;
    }

    public EeveeTopBarView(Context context) {
        m39532a(context);
    }

    public void setPresenter(C17608a aVar) {
        this.f52654a = aVar;
    }

    /* renamed from: a */
    private void m39532a(Context context) {
        ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.layout_top_bar, (ViewGroup) null);
        this.f52655b = viewGroup;
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.eevee_top_bar_back);
        this.f52656c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EeveeTopBarView.this.m39533a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39533a(View view) {
        this.f52654a.mo129010a();
    }
}
