package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.al */
final class C19900al extends C19899ak<ParcelFileDescriptor> {
    C19900al(C19906ar arVar, C20237i<ParcelFileDescriptor> iVar) {
        super(arVar, iVar);
    }

    /* renamed from: b */
    public final void mo164070b(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.mo164070b(bundle, bundle2);
        this.f55676a.mo164557b((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
