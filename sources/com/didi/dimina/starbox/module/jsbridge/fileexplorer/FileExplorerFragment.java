package com.didi.dimina.starbox.module.jsbridge.fileexplorer;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.dimina.starbox.module.jsbridge.fileexplorer.FileInfoAdapter;
import com.didi.dimina.starbox.p108ui.base.BaseFragment;
import com.didi.dimina.starbox.p108ui.widget.TitleView;
import com.didi.dimina.starbox.util.FileUtil;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileExplorerFragment extends BaseFragment {

    /* renamed from: a */
    private FileInfoAdapter f19927a;

    /* renamed from: b */
    private RecyclerView f19928b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public File f19929c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TitleView f19930d;

    /* access modifiers changed from: protected */
    public int onRequestLayout() {
        return R.layout.dimina_starbox_fragment_file_explorer;
    }

    /* renamed from: a */
    private void m16914a() {
        this.f19930d = (TitleView) findViewById(R.id.title_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.file_list);
        this.f19928b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FileInfoAdapter fileInfoAdapter = new FileInfoAdapter(getContext());
        this.f19927a = fileInfoAdapter;
        fileInfoAdapter.setOnViewClickListener(new FileInfoAdapter.OnViewClickListener() {
            public void onViewClick(View view, FileInfo fileInfo) {
                if (fileInfo.file.isFile()) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(BundleKey.FILE_KEY, fileInfo.file);
                    if (FileUtil.isImage(fileInfo.file)) {
                        FileExplorerFragment.this.showContent(ImageDetailFragment.class, bundle);
                    } else {
                        FileExplorerFragment.this.showContent(TextDetailFragment.class, bundle);
                    }
                } else {
                    File unused = FileExplorerFragment.this.f19929c = fileInfo.file;
                    FileExplorerFragment.this.f19930d.setTitle(FileExplorerFragment.this.f19929c.getName());
                    FileExplorerFragment fileExplorerFragment = FileExplorerFragment.this;
                    fileExplorerFragment.m16916a((List<FileInfo>) fileExplorerFragment.m16913a(fileExplorerFragment.f19929c));
                }
            }
        });
        this.f19927a.setOnViewLongClickListener(new FileInfoAdapter.OnViewLongClickListener() {
            public boolean onViewLongClick(View view, FileInfo fileInfo) {
                if (!fileInfo.file.isFile()) {
                    return false;
                }
                FileUtil.systemShare(FileExplorerFragment.this.getContext(), fileInfo.file);
                return true;
            }
        });
        m16916a(m16912a(getContext()));
        this.f19928b.setAdapter(this.f19927a);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f19929c = null;
        m16914a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<FileInfo> m16913a(File file) {
        ArrayList arrayList = new ArrayList();
        for (File fileInfo : file.listFiles()) {
            arrayList.add(new FileInfo(fileInfo));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed() {
        if (this.f19929c == null) {
            getActivity().finish();
            return true;
        } else if (m16917a(getContext(), this.f19929c)) {
            this.f19930d.setTitle((int) R.string.dm_kit_file_explorer);
            m16916a(m16912a(getContext()));
            this.f19929c = null;
            return true;
        } else {
            File parentFile = this.f19929c.getParentFile();
            this.f19929c = parentFile;
            this.f19930d.setTitle(parentFile.getName());
            m16916a(m16913a(this.f19929c));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16916a(List<FileInfo> list) {
        if (list.isEmpty()) {
            this.f19927a.clear();
        } else {
            this.f19927a.setData(list);
        }
    }

    /* renamed from: a */
    private List<FileInfo> m16912a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FileInfo(context.getFilesDir().getParentFile()));
        arrayList.add(new FileInfo(context.getExternalCacheDir()));
        arrayList.add(new FileInfo(context.getExternalFilesDir((String) null)));
        return arrayList;
    }

    /* renamed from: a */
    private boolean m16917a(Context context, File file) {
        if (file == null) {
            return false;
        }
        if (file.equals(context.getExternalCacheDir()) || file.equals(context.getExternalFilesDir((String) null)) || file.equals(context.getFilesDir().getParentFile())) {
            return true;
        }
        return false;
    }
}
