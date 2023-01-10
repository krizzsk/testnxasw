package net.lingala.zip4j.p070io.inputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: net.lingala.zip4j.io.inputstream.ZipStandardSplitInputStream */
public class ZipStandardSplitInputStream extends SplitInputStream {

    /* renamed from: a */
    private int f6712a;

    public ZipStandardSplitInputStream(File file, boolean z, int i) throws FileNotFoundException {
        super(file, z, i);
        this.f6712a = i;
    }

    /* access modifiers changed from: protected */
    public File getNextSplitFile(int i) throws IOException {
        if (i == this.f6712a) {
            return this.zipFile;
        }
        String canonicalPath = this.zipFile.getCanonicalPath();
        String str = i >= 9 ? ".z" : ".z0";
        return new File(canonicalPath.substring(0, canonicalPath.lastIndexOf(".")) + str + (i + 1));
    }
}
