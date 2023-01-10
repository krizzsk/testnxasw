package com.didi.beatles.p101im.picture.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.entity.IMLocalMediaFolder */
public class IMLocalMediaFolder implements Parcelable {
    public static final Parcelable.Creator<IMLocalMediaFolder> CREATOR = new Parcelable.Creator<IMLocalMediaFolder>() {
        public IMLocalMediaFolder createFromParcel(Parcel parcel) {
            return new IMLocalMediaFolder(parcel);
        }

        public IMLocalMediaFolder[] newArray(int i) {
            return new IMLocalMediaFolder[i];
        }
    };

    /* renamed from: a */
    private String f11233a;

    /* renamed from: b */
    private String f11234b;

    /* renamed from: c */
    private String f11235c;

    /* renamed from: d */
    private int f11236d;

    /* renamed from: e */
    private int f11237e;

    /* renamed from: f */
    private boolean f11238f;

    /* renamed from: g */
    private List<IMLocalMedia> f11239g = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public boolean isChecked() {
        return this.f11238f;
    }

    public void setChecked(boolean z) {
        this.f11238f = z;
    }

    public String getName() {
        return this.f11233a;
    }

    public void setName(String str) {
        this.f11233a = str;
    }

    public String getPath() {
        return this.f11234b;
    }

    public void setPath(String str) {
        this.f11234b = str;
    }

    public String getFirstImagePath() {
        return this.f11235c;
    }

    public void setFirstImagePath(String str) {
        this.f11235c = str;
    }

    public int getImageNum() {
        return this.f11236d;
    }

    public void setImageNum(int i) {
        this.f11236d = i;
    }

    public List<IMLocalMedia> getImages() {
        if (this.f11239g == null) {
            this.f11239g = new ArrayList();
        }
        return this.f11239g;
    }

    public void setImages(List<IMLocalMedia> list) {
        this.f11239g = list;
    }

    public int getCheckedNum() {
        return this.f11237e;
    }

    public void setCheckedNum(int i) {
        this.f11237e = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11233a);
        parcel.writeString(this.f11234b);
        parcel.writeString(this.f11235c);
        parcel.writeInt(this.f11236d);
        parcel.writeInt(this.f11237e);
        parcel.writeByte(this.f11238f ? (byte) 1 : 0);
        parcel.writeTypedList(this.f11239g);
    }

    public IMLocalMediaFolder() {
    }

    protected IMLocalMediaFolder(Parcel parcel) {
        this.f11233a = parcel.readString();
        this.f11234b = parcel.readString();
        this.f11235c = parcel.readString();
        this.f11236d = parcel.readInt();
        this.f11237e = parcel.readInt();
        this.f11238f = parcel.readByte() != 0;
        this.f11239g = parcel.createTypedArrayList(IMLocalMedia.CREATOR);
    }
}
