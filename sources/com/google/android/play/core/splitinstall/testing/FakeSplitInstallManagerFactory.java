package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.C20201k;
import com.google.android.play.core.splitinstall.C20207p;
import java.io.File;

public class FakeSplitInstallManagerFactory {

    /* renamed from: a */
    private static FakeSplitInstallManager f56299a;

    public static FakeSplitInstallManager create(Context context) {
        try {
            File b = C20201k.m42530a(context).mo164507b();
            if (b == null) {
                throw new LocalTestingException("Failed to retrieve local testing directory path");
            } else if (b.exists()) {
                return create(context, b);
            } else {
                throw new LocalTestingException(String.format("Local testing directory not found: %s", new Object[]{b}));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized FakeSplitInstallManager create(Context context, File file) {
        FakeSplitInstallManager fakeSplitInstallManager;
        synchronized (FakeSplitInstallManagerFactory.class) {
            if (f56299a == null) {
                f56299a = createNewInstance(context, file);
            } else if (!f56299a.mo164520a().getAbsolutePath().equals(file.getAbsolutePath())) {
                throw new RuntimeException(String.format("Different module directories used to initialize FakeSplitInstallManager: '%s' and '%s'", new Object[]{f56299a.mo164520a().getAbsolutePath(), file.getAbsolutePath()}));
            }
            fakeSplitInstallManager = f56299a;
        }
        return fakeSplitInstallManager;
    }

    public static FakeSplitInstallManager createNewInstance(Context context, File file) {
        SplitCompat.install(context);
        return new FakeSplitInstallManager(context, file, new C20207p(context, context.getPackageName()));
    }
}
