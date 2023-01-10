package xcrash;

import java.io.File;
import java.io.FilenameFilter;

class FileManager$8 implements FilenameFilter {
    final /* synthetic */ C3717c this$0;

    FileManager$8(C3717c cVar) {
        this.this$0 = cVar;
    }

    public boolean accept(File file, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.this$0.f8908a);
        sb.append("_");
        return str.startsWith(sb.toString()) && str.endsWith(this.this$0.f8910c);
    }
}
