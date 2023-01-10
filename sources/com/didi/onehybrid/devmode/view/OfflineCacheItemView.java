package com.didi.onehybrid.devmode.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class OfflineCacheItemView {

    /* renamed from: a */
    private TextView f32039a;

    /* renamed from: b */
    private TextView f32040b;

    /* renamed from: c */
    private TextView f32041c;

    /* renamed from: d */
    private TextView f32042d;

    /* renamed from: e */
    private TextView f32043e;

    /* renamed from: f */
    private View f32044f;

    public OfflineCacheItemView(Context context) {
        m24409a(context);
    }

    /* renamed from: a */
    private void m24409a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.offline_cache_item_view, (ViewGroup) null);
        this.f32044f = inflate;
        this.f32039a = (TextView) inflate.findViewById(R.id.tv_file_name);
        this.f32040b = (TextView) this.f32044f.findViewById(R.id.tv_file_modify_time);
        this.f32041c = (TextView) this.f32044f.findViewById(R.id.tv_file_size);
        this.f32042d = (TextView) this.f32044f.findViewById(R.id.tv_file_url);
        this.f32043e = (TextView) this.f32044f.findViewById(R.id.tv_file_path);
    }

    public View getRoot() {
        return this.f32044f;
    }

    public void setFileName(String str) {
        this.f32039a.setText(str);
    }

    public void setModifyTime(String str) {
        this.f32040b.setText(str);
    }

    public void setFileSize(String str) {
        this.f32041c.setText(str);
    }

    public void setFileUrl(String str) {
        this.f32042d.setText(str);
    }

    public void setFilePath(String str) {
        this.f32043e.setText(str);
    }
}
