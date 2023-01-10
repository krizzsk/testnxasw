package com.didichuxing.xpanel.global.models.taskoperation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.xpanel.models.AbsXPanelAgentModelView;
import com.taxis99.R;

public class TaskOperationView extends AbsXPanelAgentModelView<TaskOperationData> {

    /* renamed from: a */
    private TextView f52095a;

    /* renamed from: b */
    private TaskContentView f52096b;

    /* renamed from: c */
    private LinearLayout f52097c;

    /* renamed from: d */
    private TextView f52098d;

    /* renamed from: e */
    private TextView f52099e;

    /* renamed from: f */
    private TaskBottomView f52100f;

    /* renamed from: g */
    private ResourceGetter f52101g;

    public boolean contain(float f, float f2) {
        return false;
    }

    public int getMarginLeft() {
        return 0;
    }

    public int getMarginRight() {
        return 0;
    }

    public void initView() {
        this.f52101g = new ResourceGetter(TaskParseHelper.isGlobal(this.mContext));
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.f52097c = linearLayout;
        linearLayout.setOrientation(1);
        this.f52097c.setBackgroundColor(this.mContext.getResources().getColor(R.color.oc_color_FFFFFF));
        ViewGroup.LayoutParams layoutParams = this.f52097c.getLayoutParams();
        if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            this.f52097c.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        } else if (layoutParams.width != -1) {
            layoutParams.width = -1;
            this.f52097c.setLayoutParams(layoutParams);
        }
        LayoutInflater.from(this.mContext).inflate(R.layout.oc_x_panel_task_view, this.f52097c);
        this.f52095a = (TextView) this.f52097c.findViewById(R.id.oc_x_panel_title_txt);
        this.f52096b = (TaskContentView) this.f52097c.findViewById(R.id.oc_x_pane_task_content);
        this.f52100f = (TaskBottomView) this.f52097c.findViewById(R.id.oc_x_pane_task_bottom);
        TextView textView = (TextView) this.f52097c.findViewById(R.id.oc_x_panel_task_detail_btn);
        this.f52098d = textView;
        textView.setBackgroundResource(this.f52101g.mo128151a());
        this.f52098d.setTextColor(ContextCompat.getColor(this.mContext, this.f52101g.mo128152b()));
        this.f52099e = (TextView) this.f52097c.findViewById(R.id.oc_x_panel_task_description);
    }

    public View getView() {
        return createBgContainer(this.f52097c);
    }

    public int halfHeight() {
        return this.f52097c.getMeasuredHeight() / 2;
    }

    public void bind(final TaskOperationData taskOperationData) {
        if (!TextUtils.isEmpty(taskOperationData.mainTitle)) {
            this.f52095a.setText(taskOperationData.mainTitle);
        } else {
            this.f52095a.setText("");
        }
        if (TextUtils.isEmpty(taskOperationData.linkTitle) || TextUtils.isEmpty(taskOperationData.link)) {
            this.f52098d.setVisibility(8);
        } else {
            this.f52098d.setText(taskOperationData.linkTitle);
            this.f52098d.setVisibility(0);
        }
        if (!TextUtils.isEmpty(taskOperationData.title)) {
            this.f52099e.setText(taskOperationData.title);
            this.f52099e.setVisibility(0);
        } else {
            this.f52099e.setVisibility(8);
        }
        this.f52098d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TaskOperationView.this.mListener != null && !TextUtils.isEmpty(taskOperationData.link) && !TaskOperationView.this.mListener.dispatchClickUri(taskOperationData.link, TaskOperationView.this.mCardData, "button_0")) {
                    TaskOperationView.this.mListener.clickUri(taskOperationData.link, TaskOperationView.this.mCardData);
                }
                TaskOperationView.this.clickButtonOmega();
            }
        });
        this.f52097c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TaskOperationView.this.mListener != null && !TaskOperationView.this.mListener.dispatchClickUri("", TaskOperationView.this.mCardData, "card")) {
                    TaskOperationView.this.mListener.clickUri("", TaskOperationView.this.mCardData);
                }
                TaskOperationView.this.clickCardOmega();
            }
        });
        this.f52096b.mo128161a(this.f52101g, taskOperationData);
        this.f52100f.mo128158a(this.f52101g, taskOperationData);
    }

    public void destroy() {
        super.destroy();
    }
}
