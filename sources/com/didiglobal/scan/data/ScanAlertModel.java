package com.didiglobal.scan.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, mo148868d2 = {"Lcom/didiglobal/scan/data/ScanAlertModel;", "Ljava/io/Serializable;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "errBtnTitle", "getErrBtnTitle", "setErrBtnTitle", "errContent", "getErrContent", "setErrContent", "errJumpUrl", "getErrJumpUrl", "setErrJumpUrl", "errTitle", "getErrTitle", "setErrTitle", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ScanAlertModel.kt */
public final class ScanAlertModel implements Serializable {
    @SerializedName("action_type")
    private String actionType = "";
    @SerializedName("err_btn_title")
    private String errBtnTitle = "";
    @SerializedName("err_content")
    private String errContent = "";
    @SerializedName("err_jump_url")
    private String errJumpUrl = "";
    @SerializedName("err_title")
    private String errTitle = "";

    public final String getActionType() {
        return this.actionType;
    }

    public final void setActionType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.actionType = str;
    }

    public final String getErrTitle() {
        return this.errTitle;
    }

    public final void setErrTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errTitle = str;
    }

    public final String getErrContent() {
        return this.errContent;
    }

    public final void setErrContent(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errContent = str;
    }

    public final String getErrBtnTitle() {
        return this.errBtnTitle;
    }

    public final void setErrBtnTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errBtnTitle = str;
    }

    public final String getErrJumpUrl() {
        return this.errJumpUrl;
    }

    public final void setErrJumpUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errJumpUrl = str;
    }
}
