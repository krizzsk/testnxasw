package com.didi.component.evaluate.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.widget.AbsRecyclerAdapter;
import com.didi.component.common.widget.AbsViewBinder;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class EvaluateTagListView extends RecyclerView {

    /* renamed from: a */
    private static final String f15290a = "EvaluateTag";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnTagSelectChangeListener f15291b;

    /* renamed from: c */
    private EvaluateTagListAdapter f15292c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f15293d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f15294e = false;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());

    public interface OnTagSelectChangeListener {
        void onTagSelectChange(View view, EvaluateTag evaluateTag, boolean z);
    }

    public EvaluateTagListView(Context context) {
        super(context);
        m12600a();
    }

    public EvaluateTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12600a();
    }

    public EvaluateTagListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12600a();
    }

    public void updateEvaluateTags(List<EvaluateTag> list) {
        this.f15292c.update(m12599a(list));
    }

    /* renamed from: a */
    private List<EvaluateTagWrapper> m12599a(List<EvaluateTag> list) {
        ArrayList arrayList = new ArrayList();
        for (EvaluateTag evaluateTagWrapper : list) {
            arrayList.add(new EvaluateTagWrapper(evaluateTagWrapper));
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m12600a() {
        setFlowStyle(false);
        EvaluateTagListAdapter evaluateTagListAdapter = new EvaluateTagListAdapter(getContext());
        this.f15292c = evaluateTagListAdapter;
        setAdapter(evaluateTagListAdapter);
        addItemDecoration(new SpaceItemDecoration(UiUtils.dip2px(getContext(), 10.0f)));
        setOverScrollMode(2);
    }

    public void setFlowStyle(boolean z) {
        if (this.f15294e != z) {
            this.f15294e = z;
            if (z) {
                C61931 r3 = new FlexboxLayoutManager(getContext()) {
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                r3.setFlexDirection(0);
                r3.setFlexWrap(1);
                r3.setJustifyContent(0);
                setLayoutManager(r3);
            } else {
                setLayoutManager(new LinearLayoutManager(getContext()) {
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
            }
            EvaluateTagListAdapter evaluateTagListAdapter = this.f15292c;
            if (evaluateTagListAdapter != null) {
                evaluateTagListAdapter.refresh();
            }
        }
    }

    public List<EvaluateTag> getSelectedTags() {
        List<EvaluateTagWrapper> data = this.f15292c.getData();
        ArrayList arrayList = new ArrayList();
        for (EvaluateTagWrapper evaluateTagWrapper : data) {
            if (evaluateTagWrapper.isSelected()) {
                arrayList.add(evaluateTagWrapper.mTag);
            }
        }
        return arrayList;
    }

    public void setTagSelectable(boolean z) {
        this.f15293d = z;
    }

    private class EvaluateTagListAdapter extends AbsRecyclerAdapter<EvaluateTagItemHolder, EvaluateTagWrapper> {
        public EvaluateTagListAdapter(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public EvaluateTagItemHolder createViewHolder(View view) {
            return new EvaluateTagItemHolder(view);
        }

        /* access modifiers changed from: protected */
        public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
            View view;
            if (EvaluateTagListView.this.f15293d) {
                view = layoutInflater.inflate(R.layout.global_evaluate_item_view, viewGroup, false);
            } else {
                view = layoutInflater.inflate(R.layout.global_evaluate_item_non_select_view, viewGroup, false);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = EvaluateTagListView.this.f15294e ? -2 : -1;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }

    private class EvaluateTagItemHolder extends AbsViewBinder<EvaluateTagWrapper> {
        private TextViewAccessibleForCheck mTextView;

        public EvaluateTagItemHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public void getViews() {
            this.mTextView = (TextViewAccessibleForCheck) getView(R.id.oc_evaluate_tag_text);
        }

        public void bind(EvaluateTagWrapper evaluateTagWrapper) {
            if (evaluateTagWrapper != null && evaluateTagWrapper.mTag != null && this.mTextView != null) {
                Logger logger = EvaluateTagListView.this.mLogger;
                logger.info("text : " + evaluateTagWrapper.getText(), new Object[0]);
                this.mTextView.setText(evaluateTagWrapper.getText());
                this.mTextView.setSelected(evaluateTagWrapper.isSelected());
            }
        }

        /* access modifiers changed from: protected */
        public void onViewClick(View view, EvaluateTagWrapper evaluateTagWrapper) {
            if (EvaluateTagListView.this.f15293d) {
                boolean z = !evaluateTagWrapper.isSelected();
                EvaluateTagListView.this.mLogger.info("set selected " + z, new Object[0]);
                evaluateTagWrapper.setSelected(z);
                this.mTextView.setSelected(z);
                if (EvaluateTagListView.this.f15291b != null) {
                    EvaluateTagListView.this.f15291b.onTagSelectChange(this.mTextView, evaluateTagWrapper.mTag, z);
                }
            }
        }
    }

    private class EvaluateTagWrapper {
        private boolean mSelected;
        /* access modifiers changed from: private */
        public EvaluateTag mTag;

        public EvaluateTagWrapper(EvaluateTag evaluateTag) {
            this.mTag = evaluateTag;
        }

        public String getText() {
            return this.mTag.getText();
        }

        public long getId() {
            return this.mTag.getId();
        }

        public void setSelected(boolean z) {
            this.mSelected = z;
            Logger logger = EvaluateTagListView.this.mLogger;
            logger.info("set selected " + z, new Object[0]);
        }

        public boolean isSelected() {
            return this.mSelected;
        }
    }

    public void clear() {
        this.f15292c.clear();
    }

    public void setOnTagSelectChangeListener(OnTagSelectChangeListener onTagSelectChangeListener) {
        this.f15291b = onTagSelectChangeListener;
    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int i = 0;
            rect.left = 0;
            rect.top = 0;
            if (EvaluateTagListView.this.f15294e) {
                i = this.mSpace;
            }
            rect.right = i;
            rect.bottom = this.mSpace;
        }

        public SpaceItemDecoration(int i) {
            this.mSpace = i;
        }
    }
}
