package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/JumioGuideResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp$Data;", "getData", "()Lcom/didi/payment/kycservice/net/response/JumioGuideResp$Data;", "setData", "(Lcom/didi/payment/kycservice/net/response/JumioGuideResp$Data;)V", "Data", "HourData", "TimeData", "TimeSelectDetail", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: JumioGuideResp.kt */
public final class JumioGuideResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/JumioGuideResp$Data;", "Ljava/io/Serializable;", "()V", "imageLink", "", "getImageLink", "()Ljava/lang/String;", "setImageLink", "(Ljava/lang/String;)V", "subTitle", "getSubTitle", "setSubTitle", "timeSelectDetail", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp$TimeSelectDetail;", "getTimeSelectDetail", "()Lcom/didi/payment/kycservice/net/response/JumioGuideResp$TimeSelectDetail;", "setTimeSelectDetail", "(Lcom/didi/payment/kycservice/net/response/JumioGuideResp$TimeSelectDetail;)V", "title", "getTitle", "setTitle", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: JumioGuideResp.kt */
    public static final class Data implements Serializable {
        private String imageLink;
        private String subTitle;
        private TimeSelectDetail timeSelectDetail;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(String str) {
            this.subTitle = str;
        }

        public final String getImageLink() {
            return this.imageLink;
        }

        public final void setImageLink(String str) {
            this.imageLink = str;
        }

        public final TimeSelectDetail getTimeSelectDetail() {
            return this.timeSelectDetail;
        }

        public final void setTimeSelectDetail(TimeSelectDetail timeSelectDetail2) {
            this.timeSelectDetail = timeSelectDetail2;
        }
    }

    @Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/JumioGuideResp$TimeSelectDetail;", "Ljava/io/Serializable;", "()V", "canSetUp", "", "getCanSetUp", "()Ljava/lang/Boolean;", "setCanSetUp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "data", "", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp$TimeData;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "innerTitle", "", "getInnerTitle", "()Ljava/lang/String;", "setInnerTitle", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: JumioGuideResp.kt */
    public static final class TimeSelectDetail implements Serializable {
        private Boolean canSetUp;
        private List<TimeData> data;
        private String innerTitle;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getInnerTitle() {
            return this.innerTitle;
        }

        public final void setInnerTitle(String str) {
            this.innerTitle = str;
        }

        public final Boolean getCanSetUp() {
            return this.canSetUp;
        }

        public final void setCanSetUp(Boolean bool) {
            this.canSetUp = bool;
        }

        public final List<TimeData> getData() {
            return this.data;
        }

        public final void setData(List<TimeData> list) {
            this.data = list;
        }
    }

    @Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/JumioGuideResp$TimeData;", "Ljava/io/Serializable;", "()V", "display", "", "getDisplay", "()Ljava/lang/String;", "setDisplay", "(Ljava/lang/String;)V", "hour", "", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp$HourData;", "getHour", "()Ljava/util/List;", "setHour", "(Ljava/util/List;)V", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: JumioGuideResp.kt */
    public static final class TimeData implements Serializable {
        private String display;
        private List<HourData> hour;

        public final String getDisplay() {
            return this.display;
        }

        public final void setDisplay(String str) {
            this.display = str;
        }

        public final List<HourData> getHour() {
            return this.hour;
        }

        public final void setHour(List<HourData> list) {
            this.hour = list;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/JumioGuideResp$HourData;", "Ljava/io/Serializable;", "()V", "display", "", "getDisplay", "()Ljava/lang/String;", "setDisplay", "(Ljava/lang/String;)V", "time", "", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: JumioGuideResp.kt */
    public static final class HourData implements Serializable {
        private String display;
        private Long time;

        public final String getDisplay() {
            return this.display;
        }

        public final void setDisplay(String str) {
            this.display = str;
        }

        public final Long getTime() {
            return this.time;
        }

        public final void setTime(Long l) {
            this.time = l;
        }
    }
}
