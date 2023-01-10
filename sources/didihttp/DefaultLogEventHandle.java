package didihttp;

import android.os.SystemClock;
import com.didi.sdk.audiorecorder.utils.TimeUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import didihttp.LogEventListener;
import didihttp.internal.C21750Util;
import didihttp.internal.trace.LogStrategy;
import didihttpdns.p233db.DnsConstants;
import didinet.ConnectCallback;
import didinet.DnsCallback;
import didinet.NetEngine;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultLogEventHandle implements LogEventListener {

    /* renamed from: a */
    private static Logger f59142a = null;

    /* renamed from: b */
    private static final String f59143b = "HttpTracker";

    /* renamed from: c */
    private boolean f59144c;

    /* renamed from: d */
    private long f59145d;

    /* renamed from: e */
    private long f59146e;

    /* renamed from: f */
    private final int f59147f;

    /* renamed from: g */
    private final boolean f59148g;

    /* renamed from: h */
    private final SimpleDateFormat f59149h = new SimpleDateFormat(TimeUtil.YMD_HMSS);

    static {
        try {
            f59142a = LoggerFactory.getLogger("didi_http", f59143b);
        } catch (Throwable unused) {
        }
    }

    public DefaultLogEventHandle(Call call, int i) {
        this.f59147f = i;
        String httpUrl = call.request().f59254a.toString();
        if (f59142a != null) {
            this.f59148g = LogStrategy.getStrategy().isLogOpen(httpUrl);
        } else {
            this.f59148g = false;
        }
    }

    public void callStart(Call call, int i) {
        if (this.f59148g) {
            String httpUrl = call.request().f59254a.toString();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "callStart");
            linkedHashMap.put("threadId", Integer.valueOf(i));
            linkedHashMap.put("url", httpUrl);
            m44702a(linkedHashMap);
        }
    }

    public void enqueue(Call call) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "enqueue");
            m44702a(linkedHashMap);
        }
    }

    public void interceptorStart(Call call, Object obj) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", C21750Util.fixClassName(obj.toString()) + " start");
            m44702a(linkedHashMap);
        }
    }

    public void interceptorEnd(Call call, Object obj) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", C21750Util.fixClassName(obj.toString()) + " end");
            m44702a(linkedHashMap);
        }
    }

    public void useHttpDns(Call call, boolean z) {
        this.f59144c = z;
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("useHttpDns", Boolean.valueOf(z));
            m44702a(linkedHashMap);
        }
    }

    public void dnsStart(Call call, String str) {
        this.f59145d = SystemClock.uptimeMillis();
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "dnsStart");
            linkedHashMap.put("host", str);
            m44702a(linkedHashMap);
        }
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        m44703a(true, (int) (SystemClock.uptimeMillis() - this.f59145d));
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "dnsEnd");
            linkedHashMap.put("host", str);
            if (list != null) {
                StringBuilder sb = new StringBuilder();
                for (InetAddress hostAddress : list) {
                    sb.append(hostAddress.getHostAddress());
                    sb.append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                linkedHashMap.put(DnsConstants.IPS, sb.toString());
            }
            m44702a(linkedHashMap);
        }
    }

    public void dnsFailed(Call call, String str, IOException iOException) {
        m44703a(false, (int) (SystemClock.uptimeMillis() - this.f59145d));
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "dnsFailed");
            linkedHashMap.put("host", str);
            linkedHashMap.put("reason", iOException.getMessage());
            m44702a(linkedHashMap);
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.f59146e = SystemClock.uptimeMillis();
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectStart");
            m44702a(linkedHashMap);
        }
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        m44704b(true, (int) (SystemClock.uptimeMillis() - this.f59146e));
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectEnd");
            m44702a(linkedHashMap);
        }
    }

    public void connectFail(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        m44704b(false, (int) (SystemClock.uptimeMillis() - this.f59146e));
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectFail");
            linkedHashMap.put("reason", iOException.getMessage());
            if (inetSocketAddress != null) {
                linkedHashMap.put("address", inetSocketAddress.getHostString());
            }
            if (proxy != null) {
                linkedHashMap.put("proxy", proxy.toString());
            }
            if (protocol != null) {
                linkedHashMap.put("protocol", protocol.toString());
            }
            m44702a(linkedHashMap);
        }
    }

    public void tlsConnectStart(Call call) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "tlsStart");
            m44702a(linkedHashMap);
        }
    }

    public void tlsConnectEnd(Call call, Handshake handshake) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "tlsEnd");
            m44702a(linkedHashMap);
        }
    }

    public void connectionAcquired(Call call) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectionAcquired");
            m44702a(linkedHashMap);
        }
    }

    public void connectionReleased(Call call) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectionReleased");
            m44702a(linkedHashMap);
        }
    }

    public void transStart(Call call) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "transStart");
            m44702a(linkedHashMap);
        }
    }

    public void transEnd(Call call) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "transEnd");
            m44702a(linkedHashMap);
        }
    }

    public void transFail(Call call, Throwable th) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "transEnd");
            linkedHashMap.put("reason", th.getMessage());
            m44702a(linkedHashMap);
        }
    }

    public void receiveResponse(Call call) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "rcvRes");
            m44702a(linkedHashMap);
        }
    }

    public void callFailed(Call call, Throwable th) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "callFailed");
            linkedHashMap.put("reason", th.getMessage());
            m44702a(linkedHashMap);
        }
    }

    public void callEnd(Call call) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "callEnd");
            m44702a(linkedHashMap);
        }
    }

    public void retry(Call call, Throwable th) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "retry");
            linkedHashMap.put("reason", th.getMessage());
            m44702a(linkedHashMap);
        }
    }

    public void redirect(Call call) {
        if (this.f59148g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "redirect");
            m44702a(linkedHashMap);
        }
    }

    /* renamed from: a */
    private void m44702a(Map<String, Object> map) {
        f59142a.infoEvent(String.format("%s %s id=%d", new Object[]{f59143b, this.f59149h.format(new Date()), Integer.valueOf(this.f59147f)}), (Map<?, ?>) map);
    }

    public static class FACTORY implements LogEventListener.Factory {
        AtomicInteger idGenerator = new AtomicInteger(0);

        public LogEventListener create(Call call) {
            return new DefaultLogEventHandle(call, this.idGenerator.getAndIncrement());
        }
    }

    public int getIdentity() {
        return this.f59147f;
    }

    /* renamed from: a */
    private void m44703a(boolean z, int i) {
        if (!this.f59144c) {
            NetEngine.getInstance().notifyDnsCallback(new DnsCallback.DnsContext(z, i));
        }
    }

    /* renamed from: b */
    private void m44704b(boolean z, int i) {
        NetEngine.getInstance().notifyConnectCallback(new ConnectCallback.ConnectContext(z, i));
    }
}
