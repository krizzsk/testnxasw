package com.didi.component.operationpanel.impl.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.widget.AbsRecyclerAdapter;
import com.didi.component.common.widget.AbsViewBinder;
import com.didi.component.operationpanel.OperationPanelItemModel;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class OperationPanelMoreDialog extends Dialog implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, View.OnClickListener {

    /* renamed from: a */
    private Activity f16662a;

    /* renamed from: b */
    private ImageView f16663b;

    /* renamed from: c */
    private RecyclerView f16664c;

    /* renamed from: d */
    private TextView f16665d;

    /* renamed from: e */
    private OperationPanelMoreDialogListener f16666e;

    interface OperationPanelMoreDialogListener {
        void onOperationPanelMoreClosed();

        void onOperationPanelMoreItemClicked(OperationPanelItemModel operationPanelItemModel);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
    }

    public OperationPanelMoreDialog(Activity activity) {
        super(activity, R.style.operation_panel_more_dialog);
        this.f16662a = activity;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m14008b();
        m14007a();
    }

    /* renamed from: a */
    private void m14007a() {
        Window window = getWindow();
        window.setWindowAnimations(R.style.operation_panel_window_anim);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -1;
        attributes.width = -1;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setOnCancelListener(this);
        setOnDismissListener(this);
    }

    /* renamed from: b */
    private void m14008b() {
        setContentView(getLayoutInflater().inflate(R.layout.global_operation_panel_more_layout, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        ImageView imageView = (ImageView) findViewById(R.id.iv_global_operation_panel_more_close);
        this.f16663b = imageView;
        imageView.setOnClickListener(this);
        this.f16665d = (TextView) findViewById(R.id.tv_global_operation_panel_more_title);
        this.f16664c = (RecyclerView) findViewById(R.id.rv_global_operation_panel_more_content);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f16662a, 1);
        gridLayoutManager.setAutoMeasureEnabled(true);
        this.f16664c.setLayoutManager(gridLayoutManager);
    }

    public void show(List<OperationPanelItemModel> list) {
        SystemUtils.showDialog(this);
        OperationPanelMoreAdapter operationPanelMoreAdapter = new OperationPanelMoreAdapter(this.f16662a);
        this.f16664c.setAdapter(operationPanelMoreAdapter);
        operationPanelMoreAdapter.update(list);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        dismiss();
    }

    private class OperationPanelMoreAdapter extends AbsRecyclerAdapter<AbsViewBinder, OperationPanelItemModel> {
        public OperationPanelMoreAdapter(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public AbsViewBinder createViewHolder(View view) {
            return new OperationPanelMoreViewHolder(view);
        }

        /* access modifiers changed from: protected */
        public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
            return layoutInflater.inflate(R.layout.global_operation_panel_more_item_view, viewGroup, false);
        }
    }

    private class OperationPanelMoreViewHolder extends AbsViewBinder<OperationPanelItemModel> {
        private TextView mNameView;

        /* access modifiers changed from: protected */
        public void onViewClick(View view, OperationPanelItemModel operationPanelItemModel) {
        }

        public OperationPanelMoreViewHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public void getViews() {
            this.mNameView = (TextView) getView(R.id.tv_operationpanel_more_item_name);
        }

        public void bind(OperationPanelItemModel operationPanelItemModel) {
            if (!TextUtils.isEmpty(operationPanelItemModel.operationName)) {
                this.mNameView.setText(operationPanelItemModel.operationName);
            } else if (operationPanelItemModel.operationNameId != 0) {
                this.mNameView.setText(operationPanelItemModel.operationNameId);
            }
        }
    }

    public void setListener(OperationPanelMoreDialogListener operationPanelMoreDialogListener) {
        this.f16666e = operationPanelMoreDialogListener;
    }
}
