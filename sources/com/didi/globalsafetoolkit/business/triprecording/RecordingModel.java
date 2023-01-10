package com.didi.globalsafetoolkit.business.triprecording;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\bHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/globalsafetoolkit/business/triprecording/RecordingModel;", "", "oid", "", "(Ljava/lang/String;)V", "getOid", "()Ljava/lang/String;", "recordLength", "", "getRecordLength", "()I", "setRecordLength", "(I)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: GlobalTripRecordingManagerNew.kt */
public final class RecordingModel {

    /* renamed from: a */
    private int f25131a;

    /* renamed from: b */
    private final String f25132b;

    public static /* synthetic */ RecordingModel copy$default(RecordingModel recordingModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordingModel.f25132b;
        }
        return recordingModel.copy(str);
    }

    public final String component1() {
        return this.f25132b;
    }

    public final RecordingModel copy(String str) {
        Intrinsics.checkParameterIsNotNull(str, "oid");
        return new RecordingModel(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RecordingModel) && Intrinsics.areEqual((Object) this.f25132b, (Object) ((RecordingModel) obj).f25132b);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f25132b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RecordingModel(oid=" + this.f25132b + ")";
    }

    public RecordingModel(String str) {
        Intrinsics.checkParameterIsNotNull(str, "oid");
        this.f25132b = str;
    }

    public final String getOid() {
        return this.f25132b;
    }

    public final int getRecordLength() {
        return this.f25131a;
    }

    public final void setRecordLength(int i) {
        this.f25131a = i;
    }
}
