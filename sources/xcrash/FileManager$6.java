package xcrash;

import java.io.File;
import java.util.Comparator;

class FileManager$6 implements Comparator<File> {
    final /* synthetic */ C3717c this$0;

    FileManager$6(C3717c cVar) {
        this.this$0 = cVar;
    }

    public int compare(File file, File file2) {
        return file.getName().compareTo(file2.getName());
    }
}
