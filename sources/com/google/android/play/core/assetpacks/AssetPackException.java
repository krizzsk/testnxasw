package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.C20003a;
import com.google.android.play.core.tasks.C20238j;

public class AssetPackException extends C20238j {

    /* renamed from: a */
    private final int f55627a;

    AssetPackException(int i) {
        super(String.format("Asset Pack Download Error(%d): %s", new Object[]{Integer.valueOf(i), C20003a.m42081a(i)}));
        if (i != 0) {
            this.f55627a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public int getErrorCode() {
        return this.f55627a;
    }
}
