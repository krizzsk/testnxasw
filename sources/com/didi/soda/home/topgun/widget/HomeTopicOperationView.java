package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.rpc.entity.TofuEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.support.CustomerAppCompatImageView;
import com.didi.soda.datasource.parser.FeedPayload;
import com.taxis99.R;

public class HomeTopicOperationView extends FrameLayout {

    /* renamed from: a */
    ImageView f45684a;

    /* renamed from: b */
    View f45685b;

    /* renamed from: c */
    private int f45686c;

    /* renamed from: d */
    private Drawable f45687d;

    public HomeTopicOperationView(Context context) {
        super(context);
        m33917a();
    }

    public HomeTopicOperationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33917a();
    }

    public HomeTopicOperationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33917a();
    }

    public void updateItemModel(TopicOperationItemModel topicOperationItemModel, View.OnClickListener onClickListener) {
        FlyImageLoader.loadImageUnspecified(getContext(), topicOperationItemModel.mTopicImageUrl).placeholder(this.f45687d).error(this.f45687d).diskCacheStrategy(FlyImageLoader.DATA).transform(new RoundedCornersTransformation(getContext(), this.f45686c, 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f45684a);
        if (TextUtils.isEmpty(topicOperationItemModel.mClickUrl)) {
            setClickable(false);
            return;
        }
        setClickable(true);
        this.f45685b.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    private void m33917a() {
        this.f45684a = new CustomerAppCompatImageView(getContext());
        View view = new View(getContext());
        this.f45685b = view;
        view.setBackgroundResource(R.drawable.customer_selector_trans_to_4cff);
        addView(this.f45684a, new FrameLayout.LayoutParams(-1, -1));
        addView(this.f45685b, new FrameLayout.LayoutParams(-1, -1));
        this.f45686c = DisplayUtils.dip2px(getContext(), 5.0f);
        this.f45687d = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_skin_img_topgun_placeholder_tofu, this.f45686c);
    }

    public static class TopicOperationItemModel extends ModuleModelV2 {
        public String mActId;
        public String mClickUrl;
        public String mTopicImageUrl;

        public static TopicOperationItemModel newInstance(ComponentEntity componentEntity, TofuEntity tofuEntity, FeedPayload feedPayload, int i) {
            TopicOperationItemModel topicOperationItemModel = new TopicOperationItemModel();
            topicOperationItemModel.mTopicImageUrl = tofuEntity.img;
            topicOperationItemModel.mClickUrl = tofuEntity.url;
            topicOperationItemModel.mActId = tofuEntity.f43634id;
            if (feedPayload != null) {
                topicOperationItemModel.mRecId = feedPayload.mRecId;
                topicOperationItemModel.mPageId = feedPayload.mPageId;
                topicOperationItemModel.mPageInModule = feedPayload.mPageIndex;
                topicOperationItemModel.mRowInModule = feedPayload.mComponentIndex;
                topicOperationItemModel.mColumnInModule = i;
                topicOperationItemModel.mAbsoluteIndex = feedPayload.mComponentIndex;
                topicOperationItemModel.mPageFilter = feedPayload.mPageFilter;
            }
            topicOperationItemModel.mComponentId = componentEntity.mComponentId;
            topicOperationItemModel.mComponentType = componentEntity.mType;
            topicOperationItemModel.mIndexInModule = componentEntity.mPosition;
            return topicOperationItemModel;
        }
    }
}
