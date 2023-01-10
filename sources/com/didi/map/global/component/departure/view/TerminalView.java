package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.model.SpecialPois;
import com.didi.map.global.component.departure.view.ITerminalView;
import com.didi.map.global.component.departure.wheel.WheelView;
import com.didiglobal.font.DIDIFontUtils;
import com.sdk.poibase.model.RpcPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TerminalView extends LinearLayout implements ITerminalView {

    /* renamed from: a */
    private TextView f27622a;

    /* renamed from: b */
    private TextView f27623b;

    /* renamed from: c */
    private View f27624c;

    /* renamed from: d */
    private TextView f27625d;

    /* renamed from: e */
    private TextView f27626e;

    /* renamed from: f */
    private WheelView<C10224a> f27627f;

    /* renamed from: g */
    private TextView f27628g;

    /* renamed from: h */
    private TextView f27629h;

    /* renamed from: i */
    private SpecialPois f27630i;

    /* renamed from: j */
    private List<SPoi> f27631j;

    /* renamed from: k */
    private List<C10224a> f27632k;

    /* renamed from: l */
    private SPoi f27633l;

    /* renamed from: m */
    private boolean f27634m;

    /* renamed from: n */
    private boolean f27635n;

    /* renamed from: o */
    private ITerminalView.Callback f27636o;

    /* renamed from: p */
    private boolean f27637p;

    /* renamed from: q */
    private int f27638q;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m21846a(View view, MotionEvent motionEvent) {
        return true;
    }

    public TerminalView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TerminalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TerminalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27638q = 0;
        m21843a(context);
    }

    /* renamed from: a */
    private void m21843a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_map_departure_terminal, this);
        this.f27622a = (TextView) inflate.findViewById(R.id.terminal_title);
        this.f27623b = (TextView) inflate.findViewById(R.id.warning_text);
        this.f27624c = inflate.findViewById(R.id.terminal_area);
        this.f27625d = (TextView) inflate.findViewById(R.id.terminal_area_name);
        this.f27626e = (TextView) inflate.findViewById(R.id.change_terminal_area);
        this.f27627f = (WheelView) inflate.findViewById(R.id.wheelView);
        this.f27628g = (TextView) inflate.findViewById(R.id.confirm_pickup);
        this.f27629h = (TextView) inflate.findViewById(R.id.select_other_area);
        Drawable drawable = inflate.getResources().getDrawable(R.drawable.map_departure_right_arrow);
        drawable.setAutoMirrored(true);
        this.f27629h.setCompoundDrawablePadding(DisplayUtils.dp2px(inflate.getContext(), 4.0f));
        this.f27629h.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        DIDIFontUtils.Companion.setTypeface(context, this.f27622a);
        DIDIFontUtils.Companion.setTypeface(context, this.f27623b);
        DIDIFontUtils.Companion.setTypeface(context, this.f27625d);
        DIDIFontUtils.Companion.setTypeface(context, this.f27626e);
        DIDIFontUtils.Companion.setTypeface(context, this.f27628g);
        DIDIFontUtils.Companion.setTypeface(context, this.f27629h);
        m21841a();
        inflate.setOnTouchListener($$Lambda$TerminalView$CXB_dQoIeNY_ipBmMDXYbRDPQXg.INSTANCE);
        try {
            this.f27628g.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f27628g.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f27626e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalView.this.m21851c(view);
            }
        });
        this.f27628g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalView.this.m21850b(view);
            }
        });
        this.f27629h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalView.this.m21844a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m21851c(View view) {
        this.f27635n = true;
        ITerminalView.Callback callback = this.f27636o;
        if (callback != null) {
            callback.onClickChange(this.f27630i);
        }
        m21849b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21850b(View view) {
        if (this.f27635n) {
            SPoi a = m21839a(this.f27627f.getSelection());
            if (a != null) {
                this.f27635n = false;
                this.f27633l = a;
                ITerminalView.Callback callback = this.f27636o;
                if (callback != null) {
                    callback.onClickNext(a);
                }
                setSelectedArea(a);
                return;
            }
            return;
        }
        ITerminalView.Callback callback2 = this.f27636o;
        if (callback2 != null) {
            callback2.onClickConfirmPickup(m21848b(this.f27627f.getSelection()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21844a(View view) {
        ITerminalView.Callback callback = this.f27636o;
        if (callback != null) {
            callback.onClickBroadOther();
        }
    }

    /* renamed from: a */
    private void m21841a() {
        this.f27627f.setWheelAdapter(new TerminalWheelAdapter(getContext()));
        this.f27627f.setWheelSize(3);
        this.f27627f.setWheelClickable(false);
        WheelView.WheelViewStyle wheelViewStyle = new WheelView.WheelViewStyle();
        wheelViewStyle.backgroundColor = -1;
        wheelViewStyle.textColor = Color.parseColor("#303030");
        wheelViewStyle.selectedTextColor = Color.parseColor("#000000");
        wheelViewStyle.selectedTextBold = false;
        wheelViewStyle.selectedTextSize = getResources().getInteger(R.integer.i_16);
        wheelViewStyle.textSize = getResources().getInteger(R.integer.i_14);
        wheelViewStyle.holoBorderColor = Color.parseColor("#1A000000");
        wheelViewStyle.holoBorderWidth = 1;
        wheelViewStyle.textAlpha = 0.3f;
        this.f27627f.setStyle(wheelViewStyle);
        this.f27627f.setClickToPosition(true);
        this.f27627f.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
            public final void onItemSelected(int i, Object obj, int i2) {
                TerminalView.this.m21842a(i, (C10224a) obj, i2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21842a(int i, C10224a aVar, int i2) {
        ITerminalView.Callback callback = this.f27636o;
        if (callback == null) {
            return;
        }
        if (this.f27635n) {
            SPoi a = m21839a(i);
            this.f27633l = a;
            this.f27636o.onTerminalAreaSelected(a, i2);
            return;
        }
        callback.onDepartureSelected(m21848b(i), i2);
    }

    public void setCardStyle(int i) {
        this.f27638q = i;
    }

    public void setShowBroadOtherInAreaCard(boolean z) {
        this.f27637p = z;
        this.f27629h.setVisibility(z ? 0 : 8);
    }

    public void setCallback(ITerminalView.Callback callback) {
        this.f27636o = callback;
    }

    public void setData(SpecialPois specialPois) {
        if (specialPois == null || specialPois.area == null || CollectionUtil.isEmpty((Collection<?>) specialPois.pois)) {
            this.f27634m = false;
            return;
        }
        m21845a(specialPois);
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27631j) || !CollectionUtil.isEmpty((Collection<?>) this.f27632k) || this.f27633l != null) {
            this.f27634m = true;
            SPoi sPoi = this.f27633l;
            if (sPoi != null) {
                this.f27635n = false;
                setSelectedArea(sPoi);
                return;
            }
            this.f27635n = true;
            m21849b();
            return;
        }
        this.f27634m = false;
    }

    public void setPickupPoiNotice(String str) {
        if (!TextUtils.isEmpty(str)) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(str);
            richTextInfo.bindTo(this.f27623b);
            this.f27623b.setVisibility(0);
            return;
        }
        this.f27623b.setText("");
        this.f27623b.setVisibility(8);
    }

    public View getView() {
        if (isValid()) {
            return this;
        }
        return null;
    }

    public boolean isValid() {
        return this.f27634m;
    }

    public boolean isTerminal() {
        return this.f27635n;
    }

    public void setSelectedTerminalArea(SPoi sPoi) {
        if (isValid() && sPoi != null && sPoi.area != null) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 < this.f27630i.pois.size()) {
                    SPoi sPoi2 = this.f27630i.pois.get(i2);
                    if (sPoi2 != null && sPoi2.area != null && sPoi2.area.f27471id != null && sPoi2.area.f27471id.equals(sPoi.area.f27471id)) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            this.f27627f.setSelection(i);
            setPickupPoiNotice("");
        }
    }

    public void performSelectedArea(SPoi sPoi, RpcPoi rpcPoi) {
        if (sPoi != null) {
            this.f27633l = sPoi;
            setSelectedArea(sPoi);
            this.f27627f.setSelection(m21838a(sPoi, rpcPoi));
        }
    }

    public SPoi getSelectedTerminalArea() {
        return m21839a(m21847b(this.f27633l));
    }

    public void setSelectedDeparture(RpcPoi rpcPoi) {
        SPoi sPoi;
        if (isValid() && rpcPoi != null) {
            int i = 0;
            if (rpcPoi.base_info != null && !TextUtils.isEmpty(rpcPoi.base_info.poi_id) && (sPoi = this.f27633l) != null && sPoi.list != null) {
                int i2 = 0;
                while (true) {
                    if (i2 < this.f27633l.list.size()) {
                        RpcPoi rpcPoi2 = this.f27633l.list.get(i2);
                        if (rpcPoi2 != null && rpcPoi2.base_info != null && rpcPoi.base_info.poi_id.equals(rpcPoi2.base_info.poi_id)) {
                            i = i2;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            this.f27627f.setSelection(i);
        }
    }

    public RpcPoi getSelectedDeparture() {
        return m21848b(this.f27627f.getSelection());
    }

    /* renamed from: b */
    private void m21849b() {
        this.f27629h.setVisibility(this.f27637p ? 0 : 8);
        this.f27624c.setVisibility(8);
        this.f27622a.setText(R.string.GRider_Homepage0714_Get_in_rhbS);
        this.f27628g.setText(R.string.GRider_Homepage0714_Next_step_vpJv);
        this.f27627f.setWheelData(this.f27632k);
        this.f27627f.setSelection(m21847b(this.f27633l));
        setPickupPoiNotice("");
    }

    private void setSelectedArea(SPoi sPoi) {
        this.f27629h.setVisibility(8);
        int i = 0;
        this.f27624c.setVisibility(0);
        this.f27625d.setText(sPoi.area.name);
        if (this.f27638q == 1) {
            this.f27622a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_pickup));
            this.f27628g.setText(getResources().getString(R.string.GRider_page_Order_tfYG));
        } else {
            this.f27622a.setText(R.string.GRider_Homepage0714_Go_to_cqWv);
            this.f27628g.setText(R.string.GRider_Homepage0714_Get_on_TWaG);
        }
        List<C10224a> a = m21840a(sPoi);
        if (!CollectionUtil.isEmpty((Collection<?>) a)) {
            this.f27627f.setWheelData(a);
            int i2 = 0;
            while (true) {
                if (i2 < a.size()) {
                    C10224a aVar = a.get(i2);
                    if (aVar != null && aVar.f27654d) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            this.f27627f.setSelection(i);
        }
    }

    /* renamed from: a */
    private SPoi m21839a(int i) {
        List<C10224a> list = this.f27632k;
        if (list == null || i >= list.size() || this.f27632k.get(i) == null) {
            return null;
        }
        String str = this.f27632k.get(i).f27653c;
        for (SPoi next : this.f27631j) {
            if (!TextUtils.isEmpty(str) && str.equals(next.area.f27471id)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    private RpcPoi m21848b(int i) {
        SPoi sPoi = this.f27633l;
        if (sPoi == null || sPoi.list == null || i >= this.f27633l.list.size()) {
            return null;
        }
        return this.f27633l.list.get(i);
    }

    /* renamed from: a */
    private void m21845a(SpecialPois specialPois) {
        this.f27630i = specialPois;
        if (specialPois != null) {
            this.f27633l = null;
            List<SPoi> list = this.f27631j;
            if (list == null) {
                this.f27631j = new ArrayList();
            } else {
                list.clear();
            }
            List<C10224a> list2 = this.f27632k;
            if (list2 == null) {
                this.f27632k = new ArrayList();
            } else {
                list2.clear();
            }
            for (SPoi next : this.f27630i.pois) {
                if (next != null && next.area != null && !TextUtils.isEmpty(next.area.name) && !TextUtils.isEmpty(next.area.f27471id) && !CollectionUtil.isEmpty((Collection<?>) next.list)) {
                    this.f27631j.add(next);
                    this.f27632k.add(new C10224a(next.area.name, next.area.f27471id, false, false));
                    if (this.f27633l == null && specialPois.area != null && specialPois.area.point_first == 1 && next != null && next.area != null && next.area.is_nearest == 1) {
                        this.f27633l = next;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private List<C10224a> m21840a(SPoi sPoi) {
        ArrayList arrayList = new ArrayList();
        for (RpcPoi next : sPoi.list) {
            if (!(next == null || next.base_info == null || TextUtils.isEmpty(next.base_info.poi_id))) {
                String str = next.base_info.displayname;
                String str2 = next.base_info.poi_id;
                boolean z = false;
                boolean z2 = next.base_info.is_nearest == 1;
                if (next.base_info.is_recommend_absorb == 1) {
                    z = true;
                }
                arrayList.add(new C10224a(str, str2, z2, z));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m21847b(SPoi sPoi) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27631j)) {
            int i = 0;
            for (SPoi next : this.f27631j) {
                if (sPoi != null && sPoi.area != null && sPoi.area.f27471id != null && next != null && next.area != null && sPoi.area.f27471id.equals(next.area.f27471id)) {
                    return i;
                }
                i++;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private int m21838a(SPoi sPoi, RpcPoi rpcPoi) {
        if (!(sPoi == null || sPoi.area == null || rpcPoi == null || rpcPoi.base_info == null || CollectionUtil.isEmpty((Collection<?>) sPoi.list))) {
            int i = 0;
            for (RpcPoi next : sPoi.list) {
                if (next != null && next.base_info != null && next.base_info.lat == rpcPoi.base_info.lat && next.base_info.lng == rpcPoi.base_info.lng) {
                    return i;
                }
                i++;
            }
        }
        return 0;
    }
}
