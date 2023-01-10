package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public interface SafeParcelable extends Parcelable {
    public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public @interface Class {
        String creator();

        boolean doNotParcelTypeDefaultValues() default false;

        boolean validate() default false;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public @interface Constructor {
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public @interface Field {
        String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

        String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        /* renamed from: id */
        int mo142423id();

        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public @interface Indicator {
        String getter() default "SAFE_PARCELABLE_NULL_STRING";
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public @interface Param {
        /* renamed from: id */
        int mo142426id();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public @interface RemovedParam {
        String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

        String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

        /* renamed from: id */
        int mo142429id();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public @interface Reserved {
        int[] value();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public @interface VersionField {
        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        /* renamed from: id */
        int mo142432id();

        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }
}
