package com.didiglobal.p205sa.biz.component.activity.viewhold;

import android.view.View;
import android.widget.TextView;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;
import com.google.gson.Gson;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.ActivityRecentlyTitleVH */
public class ActivityRecentlyTitleVH extends BaseRecVH {

    /* renamed from: a */
    private final TextView f53325a;

    /* renamed from: b */
    private Gson f53326b = new Gson();

    public ActivityRecentlyTitleVH(View view) {
        super(view);
        this.f53325a = (TextView) view.findViewById(R.id.title);
    }

    public void bindView(ActivityCardModel activityCardModel) {
        if (activityCardModel != null && activityCardModel.getTitle() != null) {
            activityCardModel.getTitle().bindTextView(this.f53325a);
        }
    }
}
