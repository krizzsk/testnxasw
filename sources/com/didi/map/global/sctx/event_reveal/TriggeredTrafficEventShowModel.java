package com.didi.map.global.sctx.event_reveal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/TriggeredTrafficEventShowModel;", "", "event", "Lcom/didi/map/global/sctx/event_reveal/TrafficEventModel;", "message", "", "countDownTime", "", "btnList", "", "Lcom/didi/map/global/sctx/event_reveal/VerifyBtnModel;", "(Lcom/didi/map/global/sctx/event_reveal/TrafficEventModel;Ljava/lang/String;ILjava/util/List;)V", "getBtnList", "()Ljava/util/List;", "getCountDownTime", "()I", "getEvent", "()Lcom/didi/map/global/sctx/event_reveal/TrafficEventModel;", "getMessage", "()Ljava/lang/String;", "isValid", "", "Builder", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TriggeredTrafficEventShowModel.kt */
public final class TriggeredTrafficEventShowModel {

    /* renamed from: a */
    private final TrafficEventModel f30075a;

    /* renamed from: b */
    private final String f30076b;

    /* renamed from: c */
    private final int f30077c;

    /* renamed from: d */
    private final List<VerifyBtnModel> f30078d;

    public TriggeredTrafficEventShowModel(TrafficEventModel trafficEventModel, String str, int i, List<VerifyBtnModel> list) {
        this.f30075a = trafficEventModel;
        this.f30076b = str;
        this.f30077c = i;
        this.f30078d = list;
    }

    public final TrafficEventModel getEvent() {
        return this.f30075a;
    }

    public final String getMessage() {
        return this.f30076b;
    }

    public final int getCountDownTime() {
        return this.f30077c;
    }

    public final List<VerifyBtnModel> getBtnList() {
        return this.f30078d;
    }

    public final boolean isValid() {
        Boolean bool;
        TrafficEventModel trafficEventModel = this.f30075a;
        Boolean bool2 = null;
        if (Intrinsics.areEqual((Object) trafficEventModel == null ? null : Boolean.valueOf(trafficEventModel.isValid()), (Object) true)) {
            String str = this.f30076b;
            if (str == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(str.length() > 0);
            }
            if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                List<VerifyBtnModel> list = this.f30078d;
                if (list != null) {
                    bool2 = Boolean.valueOf(!list.isEmpty());
                }
                if (Intrinsics.areEqual((Object) bool2, (Object) true)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/TriggeredTrafficEventShowModel$Builder;", "", "()V", "btnList", "", "Lcom/didi/map/global/sctx/event_reveal/VerifyBtnModel;", "countDownTime", "", "event", "Lcom/didi/map/global/sctx/event_reveal/TrafficEventModel;", "message", "", "build", "Lcom/didi/map/global/sctx/event_reveal/TriggeredTrafficEventShowModel;", "setBtnList", "list", "setCountDownTime", "time", "setEvent", "e", "setMessage", "m", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TriggeredTrafficEventShowModel.kt */
    public static final class Builder {
        private List<VerifyBtnModel> btnList;
        private int countDownTime;
        private TrafficEventModel event;
        private String message;

        public final Builder setEvent(TrafficEventModel trafficEventModel) {
            this.event = trafficEventModel;
            return this;
        }

        public final Builder setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "m");
            this.message = str;
            return this;
        }

        public final Builder setCountDownTime(int i) {
            this.countDownTime = i;
            return this;
        }

        public final Builder setBtnList(List<VerifyBtnModel> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.btnList = list;
            return this;
        }

        public final TriggeredTrafficEventShowModel build() {
            return new TriggeredTrafficEventShowModel(this.event, this.message, this.countDownTime, this.btnList);
        }
    }
}
