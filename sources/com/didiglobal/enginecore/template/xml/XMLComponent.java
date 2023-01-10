package com.didiglobal.enginecore.template.xml;

import android.content.Context;
import com.android.didi.bfflib.utils.TrackUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import com.didiglobal.dittoview.mvvm.DittoData;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.constant.XEngineConst;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import com.didiglobal.enginecore.view.AsyncViewLoadListener;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

public class XMLComponent extends XEComponent {

    /* renamed from: a */
    private XMLCardData f52716a;

    /* renamed from: b */
    private String f52717b;

    /* renamed from: c */
    private AsyncViewLoadListener f52718c;

    public String getTemplateId() {
        return XEngineConst.XE_XML_TEMPLATE;
    }

    public XMLCardView getView(Context context) {
        XMLCardView xMLCardView = new XMLCardView(this.f52718c);
        XMLCardData xMLCardData = this.f52716a;
        if (xMLCardData != null) {
            xMLCardView.createView(context, xMLCardData);
        } else {
            SystemUtils.log(6, "XMLComponent", "data is null", (Throwable) null, "com.didiglobal.enginecore.template.xml.XMLComponent", 31);
        }
        return xMLCardView;
    }

    public XMLCardData getXMlCardData() {
        return this.f52716a;
    }

    public void createData(JsonObject jsonObject) {
        JSONObject optJSONObject;
        XMLCardData xMLCardData = new XMLCardData();
        new DittoData();
        try {
            JSONObject jSONObject = new JSONObject(jsonObject.toString());
            xMLCardData.setData(m39583a(jSONObject));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("normal");
            if (!(optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(XEParseConst.XE_JSON_KEY_UI_CONFIG)) == null)) {
                int optInt = optJSONObject.optInt("card_width");
                int optInt2 = optJSONObject.optInt("card_height");
                xMLCardData.setWidth(optInt);
                xMLCardData.setHeight(optInt2);
            }
            this.f52716a = xMLCardData;
        } catch (JSONException e) {
            TrackUtil.trackError(1, "", e, jsonObject.toString());
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private DittoData m39583a(JSONObject jSONObject) {
        DittoData dittoData = new DittoData();
        if (jSONObject == null) {
            return null;
        }
        dittoData.setId(jSONObject.optString("id"));
        dittoData.setTemplate(jSONObject.optString("template"));
        JSONObject optJSONObject = jSONObject.optJSONObject("normal");
        dittoData.setExtension(jSONObject.optJSONObject("extension"));
        if (optJSONObject != null) {
            dittoData.setCdn(optJSONObject.optString(ScreenAdNewModel.ScreenAdNewColumn.CDN));
            dittoData.setData(optJSONObject.optJSONObject("data"));
            if (dittoData.getExtension() == null && optJSONObject.has("extension")) {
                dittoData.setExtension(optJSONObject.optJSONObject("extension"));
            }
        }
        return dittoData;
    }

    public String getId() {
        return this.f52717b;
    }

    public void setId(String str) {
        this.f52717b = str;
    }

    public void setLoadListener(AsyncViewLoadListener asyncViewLoadListener) {
        this.f52718c = asyncViewLoadListener;
    }
}
