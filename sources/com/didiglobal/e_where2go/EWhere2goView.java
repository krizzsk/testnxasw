package com.didiglobal.e_where2go;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.didiglobal.common.common.spi.AddressParamsGetter;
import com.didiglobal.common.common.util.EeveeRichTextUtil;
import com.didiglobal.e_where2go.model.Where2GoModel;
import com.taxis99.R;

public class EWhere2goView implements EeveeIView<EWhere2goPresenter> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EWhere2goPresenter f52617a;

    /* renamed from: b */
    private ViewGroup f52618b;

    /* renamed from: c */
    private LinearLayout f52619c;

    /* renamed from: d */
    private ImageView f52620d;

    /* renamed from: e */
    private TextView f52621e;

    /* renamed from: f */
    private RelativeLayout f52622f;

    /* renamed from: g */
    private TextView f52623g;

    /* renamed from: h */
    private ImageView f52624h;

    /* renamed from: i */
    private LinearLayout f52625i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Context f52626j;

    /* renamed from: k */
    private AddressParamsGetter f52627k;

    public View getView() {
        return this.f52618b;
    }

    public EWhere2goView(Context context) {
        this.f52626j = context;
        m39505a(context);
    }

    public void setPresenter(EWhere2goPresenter eWhere2goPresenter) {
        this.f52617a = eWhere2goPresenter;
    }

    /* renamed from: a */
    private void m39505a(Context context) {
        ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.layout_common_where2go, (ViewGroup) null);
        this.f52618b = viewGroup;
        this.f52619c = (LinearLayout) viewGroup.findViewById(R.id.where2go_view);
        this.f52621e = (TextView) this.f52618b.findViewById(R.id.where2go_text);
        this.f52620d = (ImageView) this.f52618b.findViewById(R.id.where2go_icon);
        this.f52622f = (RelativeLayout) this.f52618b.findViewById(R.id.where2_top_bar);
        this.f52623g = (TextView) this.f52618b.findViewById(R.id.top_bar_text);
        this.f52624h = (ImageView) this.f52618b.findViewById(R.id.top_bar_left_icon);
        this.f52625i = (LinearLayout) this.f52618b.findViewById(R.id.where_2_main_layout);
    }

    public void setView() {
        final Where2GoModel model = this.f52617a.getModel();
        EeveeRichTextUtil.setText(this.f52621e, model.title);
        Glide.with(this.f52626j).asBitmap().load(model.icon).into(this.f52620d);
        if (model.top_banner == null || model.top_banner.title == null) {
            this.f52622f.setVisibility(8);
        } else {
            this.f52622f.setVisibility(0);
            if (model.top_banner.link != null) {
                this.f52622f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DRouter.build(model.top_banner.link).start(EWhere2goView.this.f52626j);
                    }
                });
            }
            EeveeRichTextUtil.setText(this.f52623g, model.top_banner.title);
            if (!TextUtils.isEmpty(model.top_banner.left_icon)) {
                if (model.top_banner.background_color != null) {
                    model.top_banner.background_color.bindView(this.f52623g, 20);
                }
                this.f52624h.setVisibility(0);
                Glide.with(this.f52626j).asBitmap().load(model.top_banner.left_icon).into(this.f52624h);
            } else {
                this.f52624h.setVisibility(8);
            }
        }
        this.f52625i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DRouter.build(model.link).start(EWhere2goView.this.f52626j);
                EWhere2goView.this.f52617a.omegaTrack(EWhere2goPresenter.WHERE_TO_GO_CK);
            }
        });
    }
}
