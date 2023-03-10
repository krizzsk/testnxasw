package net.sourceforge.zbar;

import java.util.AbstractCollection;
import java.util.Iterator;

public class SymbolSet extends AbstractCollection<Symbol> {
    private long peer;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    SymbolSet(long j) {
        this.peer = j;
    }

    private native void destroy(long j);

    private native long firstSymbol(long j);

    private static native void init();

    public synchronized void destroy() {
        if (this.peer != 0) {
            destroy(this.peer);
            this.peer = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        destroy();
    }

    public Iterator<Symbol> iterator() {
        long firstSymbol = firstSymbol(this.peer);
        return firstSymbol == 0 ? new SymbolIterator((Symbol) null) : new SymbolIterator(new Symbol(firstSymbol));
    }

    public native int size();
}
