package com.didi.component.payentrance.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.component.payentrance.model.OrderRecord;
import com.taxis99.R;

public class OrderRecordView extends FrameLayout {

    /* renamed from: a */
    private Context f16847a;

    /* renamed from: b */
    private TextView f16848b;

    /* renamed from: c */
    private TextView f16849c;

    /* renamed from: d */
    private TextView f16850d;

    /* renamed from: e */
    private TextView f16851e;

    /* renamed from: f */
    private TextView f16852f;

    /* renamed from: g */
    private TextView f16853g;

    /* renamed from: h */
    private TextView f16854h;

    /* renamed from: i */
    private DriverIconImageView f16855i;

    /* renamed from: j */
    private TextView f16856j;

    /* renamed from: k */
    private TextView f16857k;

    /* renamed from: l */
    private TextView f16858l;

    /* renamed from: m */
    private OrderRecord f16859m;

    public OrderRecordView(Context context) {
        super(context);
        m14173a(context);
    }

    public OrderRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14173a(context);
    }

    public OrderRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14173a(context);
    }

    /* renamed from: a */
    private void m14173a(Context context) {
        this.f16847a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f16847a, R.layout.global_pe_pay_order_record_view_layout, this);
        this.f16848b = (TextView) findViewById(R.id.business_name_tv);
        this.f16849c = (TextView) findViewById(R.id.price_unit_tv);
        this.f16850d = (TextView) findViewById(R.id.price_tv);
        this.f16851e = (TextView) findViewById(R.id.date_tv);
        this.f16852f = (TextView) findViewById(R.id.time_tv);
        this.f16853g = (TextView) findViewById(R.id.start_tv);
        this.f16854h = (TextView) findViewById(R.id.end_tv);
        this.f16855i = (DriverIconImageView) findViewById(R.id.driver_bar_circle_image);
        this.f16856j = (TextView) findViewById(R.id.diver_name_tv);
        this.f16857k = (TextView) findViewById(R.id.car_info_tv);
        this.f16858l = (TextView) findViewById(R.id.plate_data_tv);
    }

    public void show(OrderRecord orderRecord) {
        this.f16859m = orderRecord;
        if (orderRecord != null) {
            this.f16848b.setText(orderRecord.getBusinessName());
            this.f16849c.setText(this.f16859m.getPriceUnit());
            this.f16850d.setText(this.f16859m.getPrice());
            this.f16851e.setText(this.f16859m.getDate());
            this.f16852f.setText(this.f16859m.getTime());
            this.f16853g.setText(this.f16859m.getStart());
            this.f16854h.setText(this.f16859m.getEnd());
            this.f16856j.setText(this.f16859m.getDriverName());
            if (this.f16859m.getDriverIcon() != null) {
                this.f16855i.setImageBitmap(this.f16859m.getDriverIcon());
            } else {
                this.f16855i.setImageResource(R.drawable.global_pe_order_record_view_driver_head);
            }
            this.f16857k.setText(this.f16859m.getCarInfo());
            this.f16858l.setText(this.f16859m.getPlate());
            return;
        }
        this.f16848b.setText((CharSequence) null);
        this.f16849c.setText((CharSequence) null);
        this.f16850d.setText((CharSequence) null);
        this.f16851e.setText((CharSequence) null);
        this.f16852f.setText((CharSequence) null);
        this.f16853g.setText((CharSequence) null);
        this.f16854h.setText((CharSequence) null);
        this.f16856j.setText((CharSequence) null);
        this.f16855i.setImageResource(R.drawable.global_pe_order_record_view_driver_head);
        this.f16857k.setText((CharSequence) null);
        this.f16858l.setText((CharSequence) null);
    }
}
