package com.didi.addressnew.framework.fragmentmarket.map.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.address.model.WayPoint;
import com.didi.addressnew.framework.fragmentmarket.map.presenter.SugMapWayPointPagePresenter;
import com.didi.addressnew.util.ViewFastDoubleClickInterceptor;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class SugWayPointEditView extends FrameLayout {

    /* renamed from: a */
    private Context f9027a;

    /* renamed from: b */
    private boolean f9028b;

    /* renamed from: c */
    private WayPoint f9029c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnActionListener f9030d;

    /* renamed from: e */
    private ImageView f9031e;

    /* renamed from: f */
    private View f9032f;

    /* renamed from: g */
    private TextView f9033g;

    /* renamed from: h */
    private ImageView f9034h;

    /* renamed from: i */
    private View f9035i;

    /* renamed from: j */
    private View f9036j;

    /* renamed from: k */
    private ImageView f9037k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SugMapWayPointPagePresenter f9038l;

    /* renamed from: m */
    private View f9039m;

    /* renamed from: n */
    private boolean f9040n = false;

    /* renamed from: o */
    private int f9041o = 1;

    /* renamed from: p */
    private int f9042p;

    public interface OnActionListener {
        void addToChangedWayPoints(WayPoint wayPoint);

        void onSelectAddress(WayPoint wayPoint, int i);
    }

    public SugWayPointEditView(Context context) {
        super(context);
        init(context);
    }

    public SugWayPointEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SugWayPointEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public WayPoint getWayPoint() {
        return this.f9029c;
    }

    public void setPresenter(SugMapWayPointPagePresenter sugMapWayPointPagePresenter) {
        this.f9038l = sugMapWayPointPagePresenter;
    }

    public void init(Context context) {
        this.f9027a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.map_waypoint_edit_view_layout, this);
        this.f9036j = inflate;
        this.f9039m = inflate.findViewById(R.id.rlBgLayer);
        this.f9033g = (TextView) this.f9036j.findViewById(R.id.tvEditAddress);
        this.f9031e = (ImageView) this.f9036j.findViewById(R.id.imgWayPointAction);
        this.f9032f = this.f9036j.findViewById(R.id.wayPointActionContainer);
        this.f9034h = (ImageView) this.f9036j.findViewById(R.id.imgWayPointDrag);
        this.f9035i = this.f9036j.findViewById(R.id.wayPointDragContainer);
        this.f9037k = (ImageView) this.f9036j.findViewById(R.id.global_waypoint_point);
        this.f9033g.setText("");
    }

    public void setActionListener(OnActionListener onActionListener) {
        this.f9030d = onActionListener;
    }

    public void setDragTouchListener(View.OnTouchListener onTouchListener) {
        View view = this.f9035i;
        if (view != null && onTouchListener != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7750a(View view) {
        SugMapWayPointPagePresenter sugMapWayPointPagePresenter = this.f9038l;
        if (sugMapWayPointPagePresenter != null) {
            sugMapWayPointPagePresenter.deleteWayPoint(this.f9029c);
        }
    }

    /* renamed from: a */
    private void m7749a(int i, int i2, boolean z) {
        if (i == 1) {
            this.f9032f.setVisibility(4);
            this.f9035i.setVisibility(8);
            this.f9033g.setHint(R.string.GRider_Sug_2020_currentLoc);
            if (this.f9029c.isArrived() || !z || !this.f9029c.isEditable()) {
                this.f9037k.setImageResource(R.drawable.waypoint_icon_pick_up_dis);
            } else {
                this.f9037k.setImageResource(R.drawable.waypoint_icon_pickup);
            }
        } else if (i == 2) {
            this.f9031e.setImageResource(R.drawable.waypoint_action_icon_close_selector);
            int i3 = R.string.global_sug_input_stop_hint;
            if (i2 == 1) {
                i3 = R.string.GRider_Sug_2020_stop1;
            } else if (i2 == 2) {
                i3 = R.string.GRider_Sug_2020_stop2;
            }
            this.f9033g.setHint(i3);
            if (this.f9028b) {
                this.f9032f.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        SugWayPointEditView.this.m7750a(view);
                    }
                });
            } else {
                this.f9032f.setOnClickListener((View.OnClickListener) null);
            }
            if (this.f9029c.isArrived()) {
                this.f9037k.setImageResource(R.drawable.waypoint_icon_stop_dis);
                this.f9035i.setVisibility(8);
                this.f9032f.setVisibility(8);
            } else {
                this.f9037k.setImageResource(R.drawable.waypoint_icon_stop);
                this.f9035i.setVisibility(0);
                this.f9032f.setVisibility(0);
            }
        } else if (i == 3) {
            this.f9032f.setVisibility(0);
            this.f9031e.setImageResource(R.drawable.waypoint_action_icon_add_selector);
            this.f9032f.setContentDescription(getContext() == null ? "" : getContext().getString(R.string.GRider_0111_Add_Trip_KZdE));
            this.f9037k.setImageResource(R.drawable.waypoint_icon_point_destination);
            this.f9033g.setHint(R.string.GRider_Sug_2020_stopLast);
        }
        if (!this.f9029c.isEditable() || !z) {
            this.f9033g.setTextColor(getContext().getResources().getColor(R.color.waypoint_textview_disnabled_color));
        } else {
            this.f9033g.setTextColor(getContext().getResources().getColor(R.color.waypoint_textview_enabled_color));
        }
    }

    public void update(final WayPoint wayPoint, int i) {
        if (wayPoint != null) {
            this.f9029c = wayPoint;
            this.f9041o = i;
            this.f9033g.setVisibility(0);
            this.f9032f.setVisibility(0);
            this.f9028b = wayPoint.isEditable();
            m7749a(wayPoint.getWayPointType(), i, wayPoint.isUIEnable());
            Address address = wayPoint.getAddress();
            if (address == null) {
                this.f9033g.setText("");
            } else if (!TextUtils.isEmpty(address.getDisplayName())) {
                this.f9033g.setText(address.getDisplayName());
            } else if (!TextUtils.isEmpty(address.getName())) {
                this.f9033g.setText(address.getName());
            } else if (!TextUtils.isEmpty(address.getAddress())) {
                this.f9033g.setText(address.getAddress());
            } else {
                this.f9033g.setText("");
            }
            this.f9033g.setEnabled(this.f9028b);
            int wayPointType = wayPoint.getWayPointType();
            if (wayPointType == 2) {
                this.f9031e.setEnabled(this.f9028b);
                this.f9032f.setEnabled(this.f9028b);
                if (this.f9028b) {
                    this.f9035i.setVisibility(0);
                } else {
                    this.f9032f.setVisibility(4);
                    this.f9035i.setVisibility(4);
                }
            } else if (wayPointType == 3) {
                if (this.f9038l.hasEditableStopPoint()) {
                    this.f9035i.setVisibility(0);
                    if (this.f9038l.canAddStop()) {
                        this.f9031e.setImageResource(R.drawable.waypoint_action_icon_add_selector);
                    } else {
                        this.f9031e.setImageResource(R.drawable.waypoint_action_icon_close_selector);
                    }
                } else {
                    this.f9035i.setVisibility(4);
                    if (this.f9038l.canAddStop()) {
                        this.f9031e.setImageResource(R.drawable.waypoint_action_icon_add_selector);
                        this.f9032f.setVisibility(0);
                    } else {
                        this.f9032f.setVisibility(4);
                    }
                }
                this.f9032f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SugWayPointEditView.this.f9030d == null) {
                            return;
                        }
                        if (wayPoint.isCanAdd()) {
                            SugWayPointEditView.this.m7753a("addStop start...");
                            SugWayPointEditView.this.f9038l.createStop();
                            return;
                        }
                        SugWayPointEditView.this.m7753a("deleteWayPoint start...");
                        SugWayPointEditView.this.f9038l.deleteWayPoint(wayPoint);
                    }
                });
            }
            this.f9033g.setOnClickListener(new View.OnClickListener(wayPoint, i) {
                public final /* synthetic */ WayPoint f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    SugWayPointEditView.this.m7751a(this.f$1, this.f$2, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7751a(WayPoint wayPoint, int i, View view) {
        OnActionListener onActionListener;
        m7753a("addressText onclicklistener");
        if (!ViewFastDoubleClickInterceptor.isFastClick() && (onActionListener = this.f9030d) != null) {
            onActionListener.onSelectAddress(wayPoint, i);
        }
    }

    public void onStartDrag() {
        this.f9042p = this.f9032f.getVisibility();
        this.f9032f.setVisibility(4);
    }

    public void onEndDrag() {
        this.f9032f.setVisibility(this.f9042p);
        if (this.f9040n) {
            onSelfEndDrag();
        }
    }

    public void onSelfStartDrag() {
        this.f9040n = true;
    }

    public void onSelfEndDrag() {
        this.f9040n = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7753a(String str) {
        SystemUtils.log(4, "wayPointDebug", str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.view.SugWayPointEditView", 300);
    }
}
