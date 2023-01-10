package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.w */
interface C20013w {
    /* renamed from: a */
    Task<AssetPackStates> mo164074a(List<String> list, C19914az azVar, Map<String, Long> map);

    /* renamed from: a */
    Task<AssetPackStates> mo164075a(List<String> list, List<String> list2, Map<String, Long> map);

    /* renamed from: a */
    Task<List<String>> mo164076a(Map<String, Long> map);

    /* renamed from: a */
    void mo164077a();

    /* renamed from: a */
    void mo164078a(int i);

    /* renamed from: a */
    void mo164079a(int i, String str);

    /* renamed from: a */
    void mo164080a(int i, String str, String str2, int i2);

    /* renamed from: a */
    void mo164081a(String str);

    /* renamed from: a */
    void mo164082a(List<String> list);

    /* renamed from: b */
    Task<ParcelFileDescriptor> mo164083b(int i, String str, String str2, int i2);
}
