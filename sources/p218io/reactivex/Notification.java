package p218io.reactivex;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.Notification */
public final class Notification<T> {

    /* renamed from: b */
    static final Notification<Object> f60788b = new Notification<>((Object) null);

    /* renamed from: a */
    final Object f60789a;

    private Notification(Object obj) {
        this.f60789a = obj;
    }

    public boolean isOnComplete() {
        return this.f60789a == null;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.f60789a);
    }

    public boolean isOnNext() {
        Object obj = this.f60789a;
        return obj != null && !NotificationLite.isError(obj);
    }

    public T getValue() {
        Object obj = this.f60789a;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return this.f60789a;
    }

    public Throwable getError() {
        Object obj = this.f60789a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.equals(this.f60789a, ((Notification) obj).f60789a);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f60789a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f60789a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + Const.jaRight;
        }
        return "OnNextNotification[" + this.f60789a + Const.jaRight;
    }

    public static <T> Notification<T> createOnNext(T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return new Notification<>(t);
    }

    public static <T> Notification<T> createOnError(Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return new Notification<>(NotificationLite.error(th));
    }

    public static <T> Notification<T> createOnComplete() {
        return f60788b;
    }
}
