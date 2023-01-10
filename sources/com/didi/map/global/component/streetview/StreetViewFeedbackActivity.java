package com.didi.map.global.component.streetview;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.global.component.streetview.StreetViewFeedbackActivity;
import com.didi.map.global.component.streetview.utils.StreetOmegaUtils;
import com.didi.map.global.component.streetview.utils.ToastUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreetViewFeedbackActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_ORDER_ID = "order_id";
    public static final String KEY_UID = "uid";

    /* renamed from: a */
    private TextView f28488a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<FeedbackItem> f28489b = new ArrayList();

    /* renamed from: c */
    private String f28490c;

    /* renamed from: d */
    private String f28491d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.map_comp_activity_street_view_feedback);
        this.f28490c = getIntent().getStringExtra("order_id");
        this.f28491d = getIntent().getStringExtra("uid");
        ImageView imageView = (ImageView) findViewById(R.id.backArrow);
        Drawable drawable = getResources().getDrawable(R.drawable.map_comp_ic_street_feedback_back);
        drawable.setAutoMirrored(true);
        imageView.setImageDrawable(drawable);
        imageView.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.feedbackBtn);
        this.f28488a = textView;
        textView.setOnClickListener(this);
        this.f28488a.setEnabled(false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f28489b.add(new FeedbackItem("1", R.string.GRider_view2_Image_error_KIgy));
        this.f28489b.add(new FeedbackItem("2", R.string.GRider_view2_Image_loading_Okvl));
        this.f28489b.add(new FeedbackItem("3", R.string.GRider_view2_Image_content_jXVz));
        recyclerView.setAdapter(new FeedbackAdapter());
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.backArrow) {
            onBackPressed();
        } else if (id == R.id.feedbackBtn) {
            try {
                StringBuilder sb = new StringBuilder();
                for (FeedbackItem next : this.f28489b) {
                    if (next.isChecked) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(next.f28492id);
                    }
                }
                StreetOmegaUtils.onStreetViewFeedConfirmClick(sb.toString(), this.f28490c);
                ToastUtils.showToast((Context) this, (int) R.string.GRider_view2_Feedback_successful_wTaz);
            } catch (Exception unused) {
            }
            Intent intent = new Intent();
            intent.setAction(StreetViewComp.ACTION_CLOSE_BIG_STREET);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22253a() {
        boolean z;
        Iterator<FeedbackItem> it = this.f28489b.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().isChecked) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        this.f28488a.setEnabled(z);
    }

    private class FeedbackItem {
        /* access modifiers changed from: private */

        /* renamed from: id */
        public String f28492id;
        /* access modifiers changed from: private */
        public boolean isChecked = false;
        /* access modifiers changed from: private */
        public int textId;

        public FeedbackItem(String str, int i) {
            this.f28492id = str;
            this.textId = i;
        }
    }

    private class FeedbackAdapter extends RecyclerView.Adapter<C10383VH> {
        public FeedbackAdapter() {
        }

        public C10383VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C10383VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.map_comp_item_street_view_feedback, viewGroup, false));
        }

        public void onBindViewHolder(C10383VH vh, int i) {
            FeedbackItem feedbackItem = (FeedbackItem) StreetViewFeedbackActivity.this.f28489b.get(i);
            if (feedbackItem != null) {
                vh.mTitle.setText(feedbackItem.textId);
                vh.mCheckImg.setSelected(feedbackItem.isChecked);
                vh.itemView.setOnClickListener(new View.OnClickListener(feedbackItem, vh) {
                    public final /* synthetic */ StreetViewFeedbackActivity.FeedbackItem f$1;
                    public final /* synthetic */ StreetViewFeedbackActivity.FeedbackAdapter.C10383VH f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        StreetViewFeedbackActivity.FeedbackAdapter.this.mo80015x584b9610(this.f$1, this.f$2, view);
                    }
                });
            }
        }

        /* renamed from: lambda$onBindViewHolder$0$StreetViewFeedbackActivity$FeedbackAdapter */
        public /* synthetic */ void mo80015x584b9610(FeedbackItem feedbackItem, C10383VH vh, View view) {
            boolean unused = feedbackItem.isChecked = !feedbackItem.isChecked;
            vh.mCheckImg.setSelected(feedbackItem.isChecked);
            StreetViewFeedbackActivity.this.m22253a();
        }

        public int getItemCount() {
            if (StreetViewFeedbackActivity.this.f28489b != null) {
                return StreetViewFeedbackActivity.this.f28489b.size();
            }
            return 0;
        }

        /* renamed from: com.didi.map.global.component.streetview.StreetViewFeedbackActivity$FeedbackAdapter$VH */
        private class C10383VH extends RecyclerView.ViewHolder {
            /* access modifiers changed from: private */
            public ImageView mCheckImg;
            /* access modifiers changed from: private */
            public TextView mTitle;

            public C10383VH(View view) {
                super(view);
                this.mTitle = (TextView) view.findViewById(R.id.titleTv);
                this.mCheckImg = (ImageView) view.findViewById(R.id.checkImg);
            }
        }
    }
}
