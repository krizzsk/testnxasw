package com.threatmetrix.TrustDefender;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.annotation.Nonnull;

public class tqtqqt {
    @Nonnull
    public final Context bll006C006C006C006C;

    public tqtqqt(@Nonnull Context context) {
        this.bll006C006C006C006C = context;
    }

    public String b0079y00790079yy() {
        return this.bll006C006C006C006C.getPackageName();
    }

    public FileOutputStream by007900790079yy(@Nonnull String str) throws FileNotFoundException {
        return this.bll006C006C006C006C.openFileOutput(str, 0);
    }
}
