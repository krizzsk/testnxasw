package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C20237i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.aq */
final class C19905aq extends C19899ak<AssetPackStates> {

    /* renamed from: c */
    private final List<String> f55686c;

    /* renamed from: d */
    private final C19941bz f55687d;

    C19905aq(C19906ar arVar, C20237i<AssetPackStates> iVar, C19941bz bzVar, List<String> list) {
        super(arVar, iVar);
        this.f55687d = bzVar;
        this.f55686c = list;
    }

    /* renamed from: a */
    public final void mo164063a(int i, Bundle bundle) {
        super.mo164063a(i, bundle);
        this.f55676a.mo164557b(AssetPackStates.m41807a(bundle, this.f55687d, this.f55686c));
    }
}
