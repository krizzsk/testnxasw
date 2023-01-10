package com.koushikdutta.async;

import android.os.Looper;
import com.koushikdutta.async.util.ArrayDeque;
import com.koushikdutta.async.util.Charsets;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class ByteBufferList {
    public static final ByteBuffer EMPTY_BYTEBUFFER = ByteBuffer.allocate(0);
    public static int MAX_ITEM_SIZE = 262144;

    /* renamed from: c */
    static PriorityQueue<ByteBuffer> f58043c = new PriorityQueue<>(8, new Reclaimer());

    /* renamed from: d */
    static int f58044d = 0;

    /* renamed from: e */
    static int f58045e = 0;

    /* renamed from: f */
    static final /* synthetic */ boolean f58046f = (!ByteBufferList.class.desiredAssertionStatus());

    /* renamed from: h */
    private static int f58047h = 1048576;

    /* renamed from: i */
    private static final Object f58048i = new Object();

    /* renamed from: a */
    ArrayDeque<ByteBuffer> f58049a = new ArrayDeque<>();

    /* renamed from: b */
    ByteOrder f58050b = ByteOrder.BIG_ENDIAN;

    /* renamed from: g */
    private int f58051g = 0;

    public ByteOrder order() {
        return this.f58050b;
    }

    public ByteBufferList order(ByteOrder byteOrder) {
        this.f58050b = byteOrder;
        return this;
    }

    public ByteBufferList() {
    }

    public ByteBufferList(ByteBuffer... byteBufferArr) {
        addAll(byteBufferArr);
    }

    public ByteBufferList(byte[] bArr) {
        add(ByteBuffer.wrap(bArr));
    }

    public ByteBufferList addAll(ByteBuffer... byteBufferArr) {
        for (ByteBuffer add : byteBufferArr) {
            add(add);
        }
        return this;
    }

    public ByteBufferList addAll(ByteBufferList... byteBufferListArr) {
        for (ByteBufferList byteBufferList : byteBufferListArr) {
            byteBufferList.get(this);
        }
        return this;
    }

    public byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        get(bArr);
        return bArr;
    }

    public byte[] getAllByteArray() {
        byte[] bArr = new byte[remaining()];
        get(bArr);
        return bArr;
    }

    public ByteBuffer[] getAllArray() {
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) this.f58049a.toArray(new ByteBuffer[this.f58049a.size()]);
        this.f58049a.clear();
        this.f58051g = 0;
        return byteBufferArr;
    }

    public boolean isEmpty() {
        return this.f58051g == 0;
    }

    public int remaining() {
        return this.f58051g;
    }

    public boolean hasRemaining() {
        return remaining() > 0;
    }

    public short peekShort() {
        return m43916a(2).getShort(this.f58049a.peekFirst().position());
    }

    public byte peek() {
        return m43916a(1).get(this.f58049a.peekFirst().position());
    }

    public int peekInt() {
        return m43916a(4).getInt(this.f58049a.peekFirst().position());
    }

    public long peekLong() {
        return m43916a(8).getLong(this.f58049a.peekFirst().position());
    }

    public byte[] peekBytes(int i) {
        byte[] bArr = new byte[i];
        m43916a(i).get(bArr, this.f58049a.peekFirst().position(), i);
        return bArr;
    }

    public ByteBufferList skip(int i) {
        get((byte[]) null, 0, i);
        return this;
    }

    public int getInt() {
        int i = m43916a(4).getInt();
        this.f58051g -= 4;
        return i;
    }

    public char getByteChar() {
        char c = (char) m43916a(1).get();
        this.f58051g--;
        return c;
    }

    public short getShort() {
        short s = m43916a(2).getShort();
        this.f58051g -= 2;
        return s;
    }

    public byte get() {
        byte b = m43916a(1).get();
        this.f58051g--;
        return b;
    }

    public long getLong() {
        long j = m43916a(8).getLong();
        this.f58051g -= 8;
        return j;
    }

    public void get(byte[] bArr) {
        get(bArr, 0, bArr.length);
    }

    public void get(byte[] bArr, int i, int i2) {
        if (remaining() >= i2) {
            int i3 = i2;
            while (i3 > 0) {
                ByteBuffer peek = this.f58049a.peek();
                int min = Math.min(peek.remaining(), i3);
                if (bArr != null) {
                    peek.get(bArr, i, min);
                } else {
                    peek.position(peek.position() + min);
                }
                i3 -= min;
                i += min;
                if (peek.remaining() == 0) {
                    ByteBuffer remove = this.f58049a.remove();
                    if (f58046f || peek == remove) {
                        reclaim(peek);
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            this.f58051g -= i2;
            return;
        }
        throw new IllegalArgumentException("length");
    }

    public void get(ByteBufferList byteBufferList, int i) {
        if (remaining() >= i) {
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                ByteBuffer remove = this.f58049a.remove();
                int remaining = remove.remaining();
                if (remaining == 0) {
                    reclaim(remove);
                } else {
                    int i3 = remaining + i2;
                    if (i3 > i) {
                        int i4 = i - i2;
                        ByteBuffer obtain = obtain(i4);
                        obtain.limit(i4);
                        remove.get(obtain.array(), 0, i4);
                        byteBufferList.add(obtain);
                        this.f58049a.addFirst(remove);
                        if (!f58046f && obtain.capacity() < i4) {
                            throw new AssertionError();
                        } else if (!f58046f && obtain.position() != 0) {
                            throw new AssertionError();
                        }
                    } else {
                        byteBufferList.add(remove);
                        i2 = i3;
                    }
                }
            }
            this.f58051g -= i;
            return;
        }
        throw new IllegalArgumentException("length");
    }

    public void get(ByteBufferList byteBufferList) {
        get(byteBufferList, remaining());
    }

    public ByteBufferList get(int i) {
        ByteBufferList byteBufferList = new ByteBufferList();
        get(byteBufferList, i);
        return byteBufferList.order(this.f58050b);
    }

    public ByteBuffer getAll() {
        if (remaining() == 0) {
            return EMPTY_BYTEBUFFER;
        }
        m43916a(remaining());
        return remove();
    }

    /* renamed from: a */
    private ByteBuffer m43916a(int i) {
        ByteBuffer byteBuffer;
        if (remaining() >= i) {
            ByteBuffer peek = this.f58049a.peek();
            while (peek != null && !peek.hasRemaining()) {
                reclaim(this.f58049a.remove());
                peek = this.f58049a.peek();
            }
            if (peek == null) {
                return EMPTY_BYTEBUFFER;
            }
            if (peek.remaining() >= i) {
                return peek.order(this.f58050b);
            }
            ByteBuffer obtain = obtain(i);
            obtain.limit(i);
            byte[] array = obtain.array();
            int i2 = 0;
            loop1:
            while (true) {
                byteBuffer = null;
                while (i2 < i) {
                    byteBuffer = this.f58049a.remove();
                    int min = Math.min(i - i2, byteBuffer.remaining());
                    byteBuffer.get(array, i2, min);
                    i2 += min;
                    if (byteBuffer.remaining() == 0) {
                        reclaim(byteBuffer);
                    }
                }
                break loop1;
            }
            if (byteBuffer != null && byteBuffer.remaining() > 0) {
                this.f58049a.addFirst(byteBuffer);
            }
            this.f58049a.addFirst(obtain);
            return obtain.order(this.f58050b);
        }
        throw new IllegalArgumentException("count : " + remaining() + "/" + i);
    }

    public void trim() {
        m43916a(0);
    }

    public ByteBufferList add(ByteBufferList byteBufferList) {
        byteBufferList.get(this);
        return this;
    }

    public ByteBufferList add(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            reclaim(byteBuffer);
            return this;
        }
        m43919b(byteBuffer.remaining());
        if (this.f58049a.size() > 0) {
            ByteBuffer last = this.f58049a.getLast();
            if (last.capacity() - last.limit() >= byteBuffer.remaining()) {
                last.mark();
                last.position(last.limit());
                last.limit(last.capacity());
                last.put(byteBuffer);
                last.limit(last.position());
                last.reset();
                reclaim(byteBuffer);
                trim();
                return this;
            }
        }
        this.f58049a.add(byteBuffer);
        trim();
        return this;
    }

    public void addFirst(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            reclaim(byteBuffer);
            return;
        }
        m43919b(byteBuffer.remaining());
        if (this.f58049a.size() > 0) {
            ByteBuffer first = this.f58049a.getFirst();
            if (first.position() >= byteBuffer.remaining()) {
                first.position(first.position() - byteBuffer.remaining());
                first.mark();
                first.put(byteBuffer);
                first.reset();
                reclaim(byteBuffer);
                return;
            }
        }
        this.f58049a.addFirst(byteBuffer);
    }

    /* renamed from: b */
    private void m43919b(int i) {
        if (remaining() >= 0) {
            this.f58051g += i;
        }
    }

    public void recycle() {
        while (this.f58049a.size() > 0) {
            reclaim(this.f58049a.remove());
        }
        if (f58046f || this.f58049a.size() == 0) {
            this.f58051g = 0;
            return;
        }
        throw new AssertionError();
    }

    public ByteBuffer remove() {
        ByteBuffer remove = this.f58049a.remove();
        this.f58051g -= remove.remaining();
        return remove;
    }

    public int size() {
        return this.f58049a.size();
    }

    public void spewString() {
        System.out.println(peekString());
    }

    public String peekString() {
        return peekString((Charset) null);
    }

    public String peekString(Charset charset) {
        int i;
        int i2;
        byte[] bArr;
        if (charset == null) {
            charset = Charsets.UTF_8;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<ByteBuffer> it = this.f58049a.iterator();
        while (it.hasNext()) {
            ByteBuffer next = it.next();
            if (next.isDirect()) {
                bArr = new byte[next.remaining()];
                i2 = 0;
                i = next.remaining();
                next.get(bArr);
            } else {
                bArr = next.array();
                i2 = next.arrayOffset() + next.position();
                i = next.remaining();
            }
            sb.append(new String(bArr, i2, i, charset));
        }
        return sb.toString();
    }

    public String readString() {
        return readString((Charset) null);
    }

    public String readString(Charset charset) {
        String peekString = peekString(charset);
        recycle();
        return peekString;
    }

    static class Reclaimer implements Comparator<ByteBuffer> {
        Reclaimer() {
        }

        public int compare(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            if (byteBuffer.capacity() == byteBuffer2.capacity()) {
                return 0;
            }
            return byteBuffer.capacity() > byteBuffer2.capacity() ? 1 : -1;
        }
    }

    /* renamed from: a */
    private static PriorityQueue<ByteBuffer> m43917a() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null || Thread.currentThread() != mainLooper.getThread()) {
            return f58043c;
        }
        return null;
    }

    public static void setMaxPoolSize(int i) {
        f58047h = i;
    }

    public static void setMaxItemSize(int i) {
        MAX_ITEM_SIZE = i;
    }

    /* renamed from: a */
    private static boolean m43918a(ByteBuffer byteBuffer) {
        Iterator<ByteBuffer> it = f58043c.iterator();
        while (it.hasNext()) {
            if (it.next() == byteBuffer) {
                return true;
            }
        }
        return false;
    }

    public static void reclaim(ByteBuffer byteBuffer) {
        PriorityQueue<ByteBuffer> a;
        if (byteBuffer != null && !byteBuffer.isDirect() && byteBuffer.arrayOffset() == 0 && byteBuffer.array().length == byteBuffer.capacity() && byteBuffer.capacity() >= 8192 && byteBuffer.capacity() <= MAX_ITEM_SIZE && (a = m43917a()) != null) {
            synchronized (f58048i) {
                while (f58044d > f58047h && a.size() > 0 && a.peek().capacity() < byteBuffer.capacity()) {
                    f58044d -= ((ByteBuffer) a.remove()).capacity();
                }
                if (f58044d <= f58047h) {
                    if (!f58046f) {
                        if (m43918a(byteBuffer)) {
                            throw new AssertionError();
                        }
                    }
                    boolean z = false;
                    byteBuffer.position(0);
                    byteBuffer.limit(byteBuffer.capacity());
                    f58044d += byteBuffer.capacity();
                    a.add(byteBuffer);
                    if (!f58046f) {
                        boolean z2 = a.size() != 0;
                        if (f58044d == 0) {
                            z = true;
                        }
                        if (!(z2 ^ z)) {
                            throw new AssertionError();
                        }
                    }
                    f58045e = Math.max(f58045e, byteBuffer.capacity());
                }
            }
        }
    }

    public static ByteBuffer obtain(int i) {
        PriorityQueue<ByteBuffer> a;
        ByteBuffer byteBuffer;
        if (i <= f58045e && (a = m43917a()) != null) {
            synchronized (f58048i) {
                do {
                    if (a.size() > 0) {
                        byteBuffer = (ByteBuffer) a.remove();
                        boolean z = false;
                        if (a.size() == 0) {
                            f58045e = 0;
                        }
                        f58044d -= byteBuffer.capacity();
                        if (!f58046f) {
                            boolean z2 = a.size() != 0;
                            if (f58044d == 0) {
                                z = true;
                            }
                            if (!(z2 ^ z)) {
                                throw new AssertionError();
                            }
                        }
                    }
                } while (byteBuffer.capacity() < i);
                return byteBuffer;
            }
        }
        return ByteBuffer.allocate(Math.max(8192, i));
    }

    public static void obtainArray(ByteBuffer[] byteBufferArr, int i) {
        int i2;
        int i3;
        PriorityQueue<ByteBuffer> a = m43917a();
        int i4 = 0;
        if (a != null) {
            synchronized (f58048i) {
                i3 = 0;
                i2 = 0;
                while (a.size() > 0 && i3 < i) {
                    boolean z = true;
                    if (i2 >= byteBufferArr.length - 1) {
                        break;
                    }
                    ByteBuffer byteBuffer = (ByteBuffer) a.remove();
                    f58044d -= byteBuffer.capacity();
                    if (!f58046f) {
                        boolean z2 = a.size() != 0;
                        if (f58044d != 0) {
                            z = false;
                        }
                        if (!(z ^ z2)) {
                            throw new AssertionError();
                        }
                    }
                    i3 += Math.min(i - i3, byteBuffer.capacity());
                    byteBufferArr[i2] = byteBuffer;
                    i2++;
                }
            }
            i4 = i3;
        } else {
            i2 = 0;
        }
        if (i4 < i) {
            byteBufferArr[i2] = ByteBuffer.allocate(Math.max(8192, i - i4));
            i2++;
        }
        while (i2 < byteBufferArr.length) {
            byteBufferArr[i2] = EMPTY_BYTEBUFFER;
            i2++;
        }
    }

    public static ByteBuffer deepCopy(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        return (ByteBuffer) obtain(byteBuffer.remaining()).put(byteBuffer.duplicate()).flip();
    }

    public static void writeOutputStream(OutputStream outputStream, ByteBuffer byteBuffer) throws IOException {
        int i;
        int i2;
        byte[] bArr;
        if (byteBuffer.isDirect()) {
            bArr = new byte[byteBuffer.remaining()];
            i2 = 0;
            i = byteBuffer.remaining();
            byteBuffer.get(bArr);
        } else {
            bArr = byteBuffer.array();
            i2 = byteBuffer.arrayOffset() + byteBuffer.position();
            i = byteBuffer.remaining();
        }
        outputStream.write(bArr, i2, i);
    }
}
