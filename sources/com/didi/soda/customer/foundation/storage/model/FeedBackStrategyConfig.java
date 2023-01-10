package com.didi.soda.customer.foundation.storage.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/storage/model/FeedBackStrategyConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "lastRemoveTime", "", "getLastRemoveTime", "()J", "setLastRemoveTime", "(J)V", "sceneId", "", "getSceneId", "()Ljava/lang/String;", "setSceneId", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FeedBackStrategyConfig.kt */
public final class FeedBackStrategyConfig implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f43668a;

    /* renamed from: b */
    private long f43669b;

    public int describeContents() {
        return 0;
    }

    public FeedBackStrategyConfig() {
    }

    public final String getSceneId() {
        return this.f43668a;
    }

    public final void setSceneId(String str) {
        this.f43668a = str;
    }

    public final long getLastRemoveTime() {
        return this.f43669b;
    }

    public final void setLastRemoveTime(long j) {
        this.f43669b = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedBackStrategyConfig(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f43668a = parcel.readString();
        this.f43669b = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.f43668a);
        parcel.writeLong(this.f43669b);
    }

    @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/storage/model/FeedBackStrategyConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/soda/customer/foundation/storage/model/FeedBackStrategyConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/soda/customer/foundation/storage/model/FeedBackStrategyConfig;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FeedBackStrategyConfig.kt */
    public static final class CREATOR implements Parcelable.Creator<FeedBackStrategyConfig> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public FeedBackStrategyConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FeedBackStrategyConfig(parcel);
        }

        public FeedBackStrategyConfig[] newArray(int i) {
            return new FeedBackStrategyConfig[i];
        }
    }
}
