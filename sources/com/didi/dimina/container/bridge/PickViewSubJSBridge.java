package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p065ui.pickerview.builder.OptionsPickerBuilder;
import com.didi.dimina.container.p065ui.pickerview.builder.TimePickerBuilder;
import com.didi.dimina.container.p065ui.pickerview.listener.OnOptionsSelectListener;
import com.didi.dimina.container.p065ui.pickerview.listener.OnTimeSelectListener;
import com.didi.dimina.container.p065ui.pickerview.view.OptionsPickerView;
import com.didi.dimina.container.p065ui.wheelview.interfaces.IPickerViewData;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.DateUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.facebook.GraphRequest;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PickViewSubJSBridge {

    /* renamed from: a */
    private static final String f18516a = "PickViewSubJSBridge";

    /* renamed from: b */
    private static final String f18517b = "date";

    /* renamed from: c */
    private static final String f18518c = "time";

    /* renamed from: d */
    private static final String f18519d = "region";

    /* renamed from: e */
    private static final String f18520e = "selector";

    /* renamed from: f */
    private static final String f18521f = "year";

    /* renamed from: g */
    private static final String f18522g = "month";

    /* renamed from: h */
    private static final String f18523h = "day";

    /* renamed from: i */
    private List<AreaBean> f18524i = new ArrayList();

    /* renamed from: j */
    private final List<ArrayList<String>> f18525j = new ArrayList();

    /* renamed from: k */
    private final List<ArrayList<ArrayList<String>>> f18526k = new ArrayList();

    /* renamed from: l */
    private final Context f18527l;

    /* renamed from: m */
    private int f18528m = 0;

    /* renamed from: n */
    private int f18529n = 0;

    /* renamed from: o */
    private int f18530o = 0;

    public PickViewSubJSBridge(Activity activity) {
        this.f18527l = activity;
    }

    public void showPickerView(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            LogUtil.m16837d("showPickerView object " + jSONObject.toString());
            String optString = jSONObject.optString(ParamKeys.PARAM_MODE);
            JSONObject jSONObject2 = jSONObject.getJSONObject("state");
            if (!TextUtils.equals(optString, "date")) {
                if (!TextUtils.equals(optString, "time")) {
                    if (TextUtils.equals(optString, f18519d)) {
                        m15708a(jSONObject2);
                        m15710b(this.f18527l, jSONObject2, callbackFunction);
                        return;
                    } else if (TextUtils.equals(optString, f18520e)) {
                        m15704a(this.f18527l, jSONObject2, callbackFunction);
                        return;
                    } else {
                        return;
                    }
                }
            }
            m15705a(this.f18527l, TextUtils.equals(optString, "time"), jSONObject2, callbackFunction);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m15705a(Context context, boolean z, JSONObject jSONObject, CallbackFunction callbackFunction) {
        Calendar calendar;
        Date date;
        Date date2;
        Date date3;
        Context context2 = context;
        JSONObject jSONObject2 = jSONObject;
        String optString = jSONObject2.optString("value");
        LogUtil.m16837d("time value " + optString);
        String optString2 = jSONObject2.optString("start");
        String optString3 = jSONObject2.optString("end");
        String optString4 = jSONObject2.optString(GraphRequest.FIELDS_PARAM, "");
        boolean equals = TextUtils.equals(optString4, f18522g);
        boolean equals2 = TextUtils.equals(optString4, f18523h);
        boolean z2 = equals2 ? true : equals;
        boolean[] zArr = {true, z2, equals2, false, false, false};
        if (z) {
            zArr = new boolean[]{false, false, false, true, true, false};
        }
        $$Lambda$PickViewSubJSBridge$uM8qqx1La94ONf6vgHwKASToKc r13 = r1;
        $$Lambda$PickViewSubJSBridge$uM8qqx1La94ONf6vgHwKASToKc r1 = new OnTimeSelectListener(z, z2, equals2, callbackFunction) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ boolean f$2;
            public final /* synthetic */ boolean f$3;
            public final /* synthetic */ CallbackFunction f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void onTimeSelect(Date date, View view) {
                PickViewSubJSBridge.this.m15709a(this.f$1, this.f$2, this.f$3, this.f$4, date, view);
            }
        };
        TimePickerBuilder isAlphaGradient = new TimePickerBuilder(context2, r13).addOnCancelClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CallBackUtil.onFail("cancel", CallbackFunction.this);
            }
        }).setLabel(context2.getString(R.string.dimina_pickerview_year), context2.getString(R.string.dimina_pickerview_month), context2.getString(R.string.dimina_pickerview_day), "", "", "").setCancelColor(ContextCompat.getColor(context2, R.color.color_gray_99)).setSubmitColor(ContextCompat.getColor(context2, R.color.color_orange)).setType(zArr).isDialog(true).setItemVisibleCount(5).setLineSpacingMultiplier(3.0f).isAlphaGradient(true);
        Calendar calendar2 = null;
        if (!TextUtils.isEmpty(optString2)) {
            if (z) {
                date3 = DateUtil.INSTANCE.parseTime(optString2);
            } else {
                date3 = DateUtil.INSTANCE.parseDate(optString2);
            }
            calendar = Calendar.getInstance();
            calendar.setTime(date3);
        } else {
            calendar = null;
        }
        if (!TextUtils.isEmpty(optString3)) {
            if (z) {
                date2 = DateUtil.INSTANCE.parseTime(optString3);
            } else {
                date2 = DateUtil.INSTANCE.parseDate(optString3);
            }
            calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
        }
        isAlphaGradient.setRangDate(calendar, calendar2);
        if (z) {
            if (TextUtils.isEmpty(optString)) {
                optString = DateUtil.INSTANCE.parseTime(System.currentTimeMillis());
            }
            date = DateUtil.INSTANCE.parseTime(optString);
        } else {
            if (TextUtils.isEmpty(optString)) {
                optString = DateUtil.INSTANCE.parseDate(System.currentTimeMillis());
            }
            if (TextUtils.equals(optString4, f18521f)) {
                date = DateUtil.INSTANCE.parseYearDate(optString);
            } else if (TextUtils.equals(optString4, f18522g)) {
                date = DateUtil.INSTANCE.parseMonthDate(optString);
            } else {
                date = DateUtil.INSTANCE.parseDate(optString);
            }
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        isAlphaGradient.setDate(instance);
        isAlphaGradient.build().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15709a(boolean z, boolean z2, boolean z3, CallbackFunction callbackFunction, Date date, View view) {
        String a = m15703a(date, z, z2, z3);
        LogUtil.m16841i("onTimeSelect " + a);
        HashMap hashMap = new HashMap();
        hashMap.put("value", a);
        CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
    }

    /* renamed from: a */
    private void m15704a(Context context, JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONArray optJSONArray = jSONObject.optJSONArray("range");
        String optString = jSONObject.optString("range-key");
        int optInt = jSONObject.optInt("value", -1);
        LogUtil.m16837d(" value " + optJSONArray.toString() + "  rangeKey:" + optString);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (TextUtils.isEmpty(optString)) {
                arrayList.add(optJSONArray.opt(i));
            } else {
                arrayList.add(optJSONArray.optJSONObject(i).opt(optString));
            }
        }
        OptionsPickerView build = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            public final void onOptionsSelect(int i, int i2, int i3, View view) {
                PickViewSubJSBridge.m15711b(CallbackFunction.this, i, i2, i3, view);
            }
        }).addOnCancelClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CallBackUtil.onFail("cancel", CallbackFunction.this);
            }
        }).setCancelColor(ContextCompat.getColor(context, R.color.color_gray)).setSubmitColor(ContextCompat.getColor(context, R.color.color_orange)).setDividerColor(ContextCompat.getColor(context, R.color.color_gray_99)).setTextColorCenter(-16777216).setContentTextSize(20).isDialog(true).build();
        build.setPicker(arrayList);
        if (optInt != -1) {
            build.setSelectOptions(optInt);
        }
        build.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m15711b(CallbackFunction callbackFunction, int i, int i2, int i3, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", Integer.valueOf(i));
        CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
    }

    /* renamed from: b */
    private void m15710b(Context context, JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONArray optJSONArray = jSONObject.optJSONArray("value");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("valueData");
        OptionsPickerView build = new OptionsPickerBuilder(context, new OnOptionsSelectListener(callbackFunction) {
            public final /* synthetic */ CallbackFunction f$1;

            {
                this.f$1 = r2;
            }

            public final void onOptionsSelect(int i, int i2, int i3, View view) {
                PickViewSubJSBridge.this.m15706a(this.f$1, i, i2, i3, view);
            }
        }).addOnCancelClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CallBackUtil.onFail("cancel", CallbackFunction.this);
            }
        }).setCancelColor(ContextCompat.getColor(context, R.color.color_gray)).setSubmitColor(ContextCompat.getColor(context, R.color.color_orange)).setDividerColor(ContextCompat.getColor(context, R.color.color_gray_99)).setTextColorCenter(-16777216).setContentTextSize(20).isDialog(true).build();
        build.setPicker(this.f18524i, this.f18525j, this.f18526k);
        if (optJSONArray != null) {
            LogUtil.iRelease(f18516a, "area value " + optJSONArray.toString());
            build.setSelectOptions(optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
        } else if (optJSONArray2 != null) {
            build.setSelectOptions(this.f18528m, this.f18529n, this.f18530o);
        }
        build.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15706a(CallbackFunction callbackFunction, int i, int i2, int i3, View view) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i3));
        hashMap.put("value", arrayList);
        ArrayList arrayList2 = new ArrayList();
        AreaBean areaBean = this.f18524i.get(i);
        AreaBean.CityBean cityBean = areaBean.getCityList().get(i2);
        arrayList2.add(areaBean.getName());
        arrayList2.add(cityBean.getName());
        arrayList2.add(cityBean.getArea().get(i3));
        hashMap.put("valueData", arrayList2);
        CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
    }

    /* renamed from: a */
    private void m15708a(JSONObject jSONObject) {
        String str;
        String str2;
        JSONArray optJSONArray = jSONObject.optJSONArray("valueData");
        String str3 = "";
        if (optJSONArray != null) {
            LogUtil.iRelease(f18516a, "area valueData " + optJSONArray.toString());
            str3 = optJSONArray.optString(0);
            str2 = optJSONArray.optString(1);
            str = optJSONArray.optString(2);
        } else {
            str = str3;
            str2 = str;
        }
        ArrayList<AreaBean> jsonToList = JSONUtil.jsonToList(Dimina.getConfig().getAdapterConfig().getCityDataService().getCityData(), AreaBean.class);
        this.f18524i = jsonToList;
        for (int i = 0; i < jsonToList.size(); i++) {
            AreaBean areaBean = jsonToList.get(i);
            if (TextUtils.equals(areaBean.getName(), str3)) {
                this.f18528m = i;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < areaBean.getCityList().size(); i2++) {
                if (TextUtils.equals(areaBean.getCityList().get(i2).getName(), str2)) {
                    this.f18529n = i2;
                }
                arrayList.add(areaBean.getCityList().get(i2).getName());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(areaBean.getCityList().get(i2).getArea());
                for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                    if (TextUtils.equals((String) arrayList3.get(i3), str)) {
                        this.f18530o = i3;
                    }
                }
                arrayList2.add(arrayList3);
            }
            this.f18525j.add(arrayList);
            this.f18526k.add(arrayList2);
        }
    }

    /* renamed from: a */
    private String m15703a(Date date, boolean z, boolean z2, boolean z3) {
        LogUtil.m16841i("getTime : " + date.getTime());
        String parseDate = DateUtil.INSTANCE.parseDate(date);
        if (z) {
            return DateUtil.INSTANCE.parseTime(date);
        }
        if (!z2) {
            return DateUtil.INSTANCE.parseYearDate(date);
        }
        if (!z3) {
            return DateUtil.INSTANCE.parseMonthDate(date);
        }
        return parseDate;
    }

    public static class AreaBean implements IPickerViewData, Serializable {
        private List<CityBean> city;
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public List<CityBean> getCityList() {
            return this.city;
        }

        public void setCityList(List<CityBean> list) {
            this.city = list;
        }

        public String getPickerViewText() {
            return this.name;
        }

        public static class CityBean implements Serializable {
            private List<String> area;
            private String name;

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public List<String> getArea() {
                return this.area;
            }

            public void setArea(List<String> list) {
                this.area = list;
            }
        }
    }
}
