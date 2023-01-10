package com.didiglobal.scan.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, mo148868d2 = {"Lcom/didiglobal/scan/data/ScanResultModel;", "Ljava/io/Serializable;", "()V", "action_type", "", "getAction_type", "()Ljava/lang/String;", "setAction_type", "(Ljava/lang/String;)V", "scanAlertModel", "Lcom/didiglobal/scan/data/ScanAlertModel;", "getScanAlertModel", "()Lcom/didiglobal/scan/data/ScanAlertModel;", "setScanAlertModel", "(Lcom/didiglobal/scan/data/ScanAlertModel;)V", "schema", "getSchema", "setSchema", "showErrAlter", "", "getShowErrAlter", "()I", "setShowErrAlter", "(I)V", "source", "Lcom/google/gson/JsonObject;", "getSource", "()Lcom/google/gson/JsonObject;", "setSource", "(Lcom/google/gson/JsonObject;)V", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ScanResultModel.kt */
public final class ScanResultModel implements Serializable {
    @SerializedName("action_type")
    private String action_type = "";
    @SerializedName("err_alter_data")
    private ScanAlertModel scanAlertModel;
    @SerializedName("schema")
    private String schema = "";
    @SerializedName("show_err_alter")
    private int showErrAlter;
    @SerializedName("source")
    private JsonObject source = new JsonObject();

    public final String getAction_type() {
        return this.action_type;
    }

    public final void setAction_type(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.action_type = str;
    }

    public final JsonObject getSource() {
        return this.source;
    }

    public final void setSource(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "<set-?>");
        this.source = jsonObject;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setSchema(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.schema = str;
    }

    public final int getShowErrAlter() {
        return this.showErrAlter;
    }

    public final void setShowErrAlter(int i) {
        this.showErrAlter = i;
    }

    public final ScanAlertModel getScanAlertModel() {
        return this.scanAlertModel;
    }

    public final void setScanAlertModel(ScanAlertModel scanAlertModel2) {
        this.scanAlertModel = scanAlertModel2;
    }
}
