package com.didi.dimina.p109v8.debug;

import com.didi.dimina.p109v8.C8369V8;
import com.didi.dimina.p109v8.JavaVoidCallback;
import com.didi.dimina.p109v8.Releasable;
import com.didi.dimina.p109v8.V8Array;
import com.didi.dimina.p109v8.V8Function;
import com.didi.dimina.p109v8.V8Object;
import com.didi.dimina.p109v8.V8Value;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.didi.dimina.v8.debug.V8DebugServer */
public class V8DebugServer {
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String HEADER_EMBEDDING_HOST = "Embedding-Host: ";
    private static final String HEADER_PROTOCOL_VERSION = "Protocol-Version: ";
    private static final String HEADER_TYPE = "Type: ";
    private static final String HEADER_V8_VERSION = "V8-Version: ";
    private static final String J2V8_VERSION = "4.0.0";
    private static final String MAKE_BREAK_EVENT = "__j2v8_MakeBreakEvent";
    private static final String MAKE_COMPILE_EVENT = "__j2v8_MakeCompileEvent";
    private static final int PROTOCOL_BUFFER_SIZE = 4096;
    /* access modifiers changed from: private */
    public static final Charset PROTOCOL_CHARSET;
    /* access modifiers changed from: private */
    public static final byte[] PROTOCOL_CONTENT_LENGTH_BYTES = PROTOCOL_CONTENT_LENGTH_HEADER.getBytes(PROTOCOL_CHARSET);
    private static final String PROTOCOL_CONTENT_LENGTH_HEADER = "Content-Length:";
    private static final String PROTOCOL_EOL = "\r\n";
    /* access modifiers changed from: private */
    public static final byte[] PROTOCOL_EOL_BYTES;
    private static final String PROTOCOL_VERSION = "1";
    private static final String SET_LISTENER = "setListener";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private static final String V8_VERSION = "4.10.253";
    /* access modifiers changed from: private */
    public Socket client;
    /* access modifiers changed from: private */
    public Object clientLock = new Object();
    private V8Object debugObject;
    /* access modifiers changed from: private */
    public List<String> requests = new LinkedList();
    private V8Object runningStateDcp;
    private C8369V8 runtime;
    /* access modifiers changed from: private */
    public ServerSocket server;
    private V8Object stoppedStateDcp;
    /* access modifiers changed from: private */
    public boolean traceCommunication = false;
    /* access modifiers changed from: private */
    public boolean waitForConnection;

    static {
        Charset forName = Charset.forName("UTF-8");
        PROTOCOL_CHARSET = forName;
        PROTOCOL_EOL_BYTES = "\r\n".getBytes(forName);
    }

    public static void configureV8ForDebugging() {
        try {
            C8369V8.setFlags("-expose-debug-as=" + DEBUG_OBJECT_NAME);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: finally extract failed */
    public V8DebugServer(C8369V8 v8, int i, boolean z) {
        this.runtime = v8;
        this.waitForConnection = z;
        V8Object object = v8.getObject(DEBUG_OBJECT_NAME);
        if (object == null) {
            System.err.println("Cannot initialize debugger server - global debug object not found.");
            return;
        }
        try {
            this.debugObject = object.getObject(V8_DEBUG_OBJECT);
            object.close();
            v8.executeVoidScript("(function() {\n " + DEBUG_OBJECT_NAME + ".Debug. " + MAKE_BREAK_EVENT + " = function (break_id,breakpoints_hit) {\n  return new " + DEBUG_OBJECT_NAME + ".BreakEvent(break_id,breakpoints_hit);\n }\n " + DEBUG_OBJECT_NAME + ".Debug. " + MAKE_COMPILE_EVENT + " = function(script,type) {\n  var scripts = " + DEBUG_OBJECT_NAME + ".Debug.scripts()\n  for (var i in scripts) {\n   if (scripts[i].id == script.id()) {\n     return new " + DEBUG_OBJECT_NAME + ".CompileEvent(scripts[i], type);\n   }\n  }\n  return {toJSONProtocol: function() {return ''}}\n }\n})()");
            try {
                this.server = new ServerSocket(i);
            } catch (Exception e) {
                logError(e);
            }
        } catch (Throwable th) {
            object.close();
            throw th;
        }
    }

    public int getPort() {
        ServerSocket serverSocket = this.server;
        if (serverSocket == null || !serverSocket.isBound()) {
            return -1;
        }
        return this.server.getLocalPort();
    }

    public void setTraceCommunication(boolean z) {
        this.traceCommunication = z;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0043 A[LOOP:0: B:7:0x0043->B:22:0x0043, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r4 = this;
            java.net.ServerSocket r0 = r4.server
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r4.waitForConnection
            java.lang.Thread r1 = new java.lang.Thread
            com.didi.dimina.v8.debug.V8DebugServer$ClientLoop r2 = new com.didi.dimina.v8.debug.V8DebugServer$ClientLoop
            r3 = 0
            r2.<init>()
            java.lang.String r3 = "J2V8 Debugger Server"
            r1.<init>(r2, r3)
            r2 = 1
            r1.setDaemon(r2)
            r1.start()
            r4.setupEventHandler()
            com.didi.dimina.v8.V8 r1 = r4.runtime
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "(function() {return new "
            r2.append(r3)
            java.lang.String r3 = DEBUG_OBJECT_NAME
            r2.append(r3)
            java.lang.String r3 = ".DebugCommandProcessor(null, true)})()"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.didi.dimina.v8.V8Object r1 = r1.executeObjectScript(r2)
            r4.runningStateDcp = r1
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r4.clientLock
            monitor-enter(r0)
        L_0x0043:
            boolean r1 = r4.waitForConnection     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x004d
            java.lang.Object r1 = r4.clientLock     // Catch:{ InterruptedException -> 0x0043 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0043 }
            goto L_0x0043
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            r0 = 100
            r4.processRequests(r0)     // Catch:{ InterruptedException -> 0x0057 }
            goto L_0x0057
        L_0x0054:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r1
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.p109v8.debug.V8DebugServer.start():void");
    }

    public void stop() {
        try {
            this.server.close();
            synchronized (this.clientLock) {
                if (this.client != null) {
                    this.client.close();
                    this.client = null;
                }
            }
        } catch (IOException e) {
            logError(e);
        }
        V8Object v8Object = this.runningStateDcp;
        if (v8Object != null) {
            v8Object.close();
            this.runningStateDcp = null;
        }
        V8Object v8Object2 = this.debugObject;
        if (v8Object2 != null) {
            v8Object2.close();
            this.debugObject = null;
        }
        V8Object v8Object3 = this.stoppedStateDcp;
        if (v8Object3 != null) {
            v8Object3.close();
            this.stoppedStateDcp = null;
        }
    }

    private void sendJson(String str) throws IOException {
        sendMessage("", str.replace("\\/", "/"));
    }

    /* access modifiers changed from: protected */
    public void logError(Throwable th) {
        th.printStackTrace();
    }

    /* access modifiers changed from: private */
    public void sendMessage(String str, String str2) throws IOException {
        synchronized (this.clientLock) {
            if (isConnected()) {
                byte[] bytes = str2.getBytes(PROTOCOL_CHARSET);
                this.client.getOutputStream().write((str + PROTOCOL_CONTENT_LENGTH_HEADER + Integer.toString(bytes.length) + "\r\n" + "\r\n").getBytes(PROTOCOL_CHARSET));
                if (bytes.length > 0) {
                    this.client.getOutputStream().write(bytes);
                }
            } else {
                throw new IOException("There is no connected client.");
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean isConnected() {
        boolean z;
        synchronized (this.clientLock) {
            z = (this.server == null || this.client == null || !this.client.isConnected()) ? false : true;
        }
        return z;
    }

    public void processRequests(long j) throws InterruptedException {
        String[] strArr;
        if (this.server != null) {
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                synchronized (this.requests) {
                    strArr = (String[]) this.requests.toArray(new String[this.requests.size()]);
                    this.requests.clear();
                }
                for (String processRequest : strArr) {
                    try {
                        processRequest(processRequest);
                    } catch (Exception e) {
                        logError(e);
                    }
                }
                if (strArr.length <= 0) {
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i > 0) {
                        Thread.sleep(10);
                    }
                    if (i <= 0 || currentTimeMillis + j <= System.currentTimeMillis()) {
                        return;
                    }
                }
            }
            while (true) {
            }
        }
    }

    private void processRequest(String str) throws IOException {
        if (this.traceCommunication) {
            PrintStream printStream = System.out;
            printStream.println("Got message: \n" + str.substring(0, Math.min(str.length(), 1000)));
        }
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        V8Object v8Object = this.stoppedStateDcp;
        if (v8Object == null) {
            v8Object = this.runningStateDcp;
        }
        String obj = v8Object.executeFunction("processDebugJSONRequest", v8Array).toString();
        if (this.stoppedStateDcp == null && obj.contains("\"running\":false")) {
            obj = obj.replace("\"running\":false", "\"running\":true").replace("\"success\":true", "\"success\":false").replace("{\"", "{\"message\":\"Client requested suspension is not supported on J2V8.\",\"");
            v8Object.add("running_", true);
        }
        if (this.traceCommunication) {
            PrintStream printStream2 = System.out;
            printStream2.println("Returning response: \n" + obj.substring(0, Math.min(obj.length(), 1000)));
        }
        sendJson(obj);
    }

    private void setupEventHandler() {
        V8Array v8Array;
        Throwable th;
        V8Function v8Function;
        this.debugObject.registerJavaMethod((JavaVoidCallback) new EventHandler(), DEBUG_BREAK_HANDLER);
        try {
            v8Function = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
            try {
                v8Array = new V8Array(this.runtime);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                v8Array = null;
                th = th3;
                v8Function.close();
                v8Array.close();
                throw th;
            }
            try {
                v8Array.push((V8Value) v8Function);
                this.debugObject.executeFunction(SET_LISTENER, v8Array);
                if (v8Function != null && !v8Function.isReleased()) {
                    v8Function.close();
                }
                if (!v8Array.isReleased()) {
                    v8Array.close();
                }
            } catch (Throwable th4) {
                th = th4;
                v8Function.close();
                v8Array.close();
                throw th;
            }
        } catch (Throwable th5) {
            v8Array = null;
            th = th5;
            v8Function = null;
            if (v8Function != null && !v8Function.isReleased()) {
                v8Function.close();
            }
            if (v8Array != null && !v8Array.isReleased()) {
                v8Array.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0091 A[Catch:{ all -> 0x0095, all -> 0x009a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enterBreakLoop(com.didi.dimina.p109v8.V8Object r7, com.didi.dimina.p109v8.V8Object r8) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            com.didi.dimina.v8.V8Array r1 = new com.didi.dimina.v8.V8Array     // Catch:{ all -> 0x009a }
            com.didi.dimina.v8.V8 r2 = r6.runtime     // Catch:{ all -> 0x009a }
            r1.<init>(r2)     // Catch:{ all -> 0x009a }
            r2 = 0
            r1.push((boolean) r2)     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = "debugCommandProcessor"
            com.didi.dimina.v8.V8Object r2 = r7.executeObjectFunction(r2, r1)     // Catch:{ all -> 0x0095 }
            r6.stoppedStateDcp = r2     // Catch:{ all -> 0x0095 }
            r1.close()     // Catch:{ all -> 0x009a }
            java.lang.String r1 = "break_id"
            int r7 = r7.getInteger(r1)     // Catch:{ all -> 0x009a }
            java.lang.String r1 = "break_points_hit_"
            com.didi.dimina.v8.V8Array r8 = r8.getArray(r1)     // Catch:{ all -> 0x009a }
            com.didi.dimina.v8.V8Array r1 = new com.didi.dimina.v8.V8Array     // Catch:{ all -> 0x009a }
            com.didi.dimina.v8.V8 r2 = r6.runtime     // Catch:{ all -> 0x009a }
            r1.<init>(r2)     // Catch:{ all -> 0x009a }
            r1.push((int) r7)     // Catch:{ all -> 0x0087 }
            r1.push((com.didi.dimina.p109v8.V8Value) r8)     // Catch:{ all -> 0x0087 }
            com.didi.dimina.v8.V8Object r7 = r6.debugObject     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "__j2v8_MakeBreakEvent"
            com.didi.dimina.v8.V8Object r7 = r7.executeObjectFunction(r2, r1)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "toJSONProtocol"
            java.lang.String r2 = r7.executeStringFunction(r2, r0)     // Catch:{ all -> 0x0085 }
            boolean r3 = r6.traceCommunication     // Catch:{ all -> 0x0085 }
            if (r3 == 0) goto L_0x0059
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r4.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r5 = "Sending event (Break):\n"
            r4.append(r5)     // Catch:{ all -> 0x0085 }
            r4.append(r2)     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0085 }
            r3.println(r4)     // Catch:{ all -> 0x0085 }
        L_0x0059:
            r6.sendJson(r2)     // Catch:{ all -> 0x0085 }
            r1.close()     // Catch:{ all -> 0x009a }
            r8.close()     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x0067
            r7.close()     // Catch:{ all -> 0x009a }
        L_0x0067:
            boolean r7 = r6.isConnected()     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x007d
            com.didi.dimina.v8.V8Object r7 = r6.stoppedStateDcp     // Catch:{ all -> 0x009a }
            java.lang.String r8 = "isRunning"
            boolean r7 = r7.executeBooleanFunction(r8, r0)     // Catch:{ all -> 0x009a }
            if (r7 != 0) goto L_0x007d
            r7 = 10
            r6.processRequests(r7)     // Catch:{ InterruptedException -> 0x0067 }
            goto L_0x0067
        L_0x007d:
            com.didi.dimina.v8.V8Object r7 = r6.stoppedStateDcp
            r7.close()
            r6.stoppedStateDcp = r0
            return
        L_0x0085:
            r2 = move-exception
            goto L_0x0089
        L_0x0087:
            r2 = move-exception
            r7 = r0
        L_0x0089:
            r1.close()     // Catch:{ all -> 0x009a }
            r8.close()     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x0094
            r7.close()     // Catch:{ all -> 0x009a }
        L_0x0094:
            throw r2     // Catch:{ all -> 0x009a }
        L_0x0095:
            r7 = move-exception
            r1.close()     // Catch:{ all -> 0x009a }
            throw r7     // Catch:{ all -> 0x009a }
        L_0x009a:
            r7 = move-exception
            com.didi.dimina.v8.V8Object r8 = r6.stoppedStateDcp
            r8.close()
            r6.stoppedStateDcp = r0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.p109v8.debug.V8DebugServer.enterBreakLoop(com.didi.dimina.v8.V8Object, com.didi.dimina.v8.V8Object):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendCompileEvent(com.didi.dimina.p109v8.V8Object r10) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r9.isConnected()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = "type_"
            int r0 = r10.getInteger(r0)
            java.lang.String r1 = "script_"
            com.didi.dimina.v8.V8Object r10 = r10.getObject(r1)
            com.didi.dimina.v8.V8Array r1 = new com.didi.dimina.v8.V8Array
            com.didi.dimina.v8.V8 r2 = r9.runtime
            r1.<init>(r2)
            r2 = 0
            r1.push((com.didi.dimina.p109v8.V8Value) r10)     // Catch:{ all -> 0x0072 }
            r1.push((int) r0)     // Catch:{ all -> 0x0072 }
            com.didi.dimina.v8.V8Object r0 = r9.debugObject     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "__j2v8_MakeCompileEvent"
            com.didi.dimina.v8.V8Object r0 = r0.executeObjectFunction(r3, r1)     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "toJSONProtocol"
            java.lang.String r2 = r0.executeStringFunction(r3, r2)     // Catch:{ all -> 0x0070 }
            boolean r3 = r9.traceCommunication     // Catch:{ all -> 0x0070 }
            if (r3 == 0) goto L_0x005b
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r4.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r5 = "Sending event (CompileEvent):\n"
            r4.append(r5)     // Catch:{ all -> 0x0070 }
            r5 = 0
            int r6 = r2.length()     // Catch:{ all -> 0x0070 }
            r7 = 1000(0x3e8, float:1.401E-42)
            int r6 = java.lang.Math.min(r6, r7)     // Catch:{ all -> 0x0070 }
            java.lang.String r5 = r2.substring(r5, r6)     // Catch:{ all -> 0x0070 }
            r4.append(r5)     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0070 }
            r3.println(r4)     // Catch:{ all -> 0x0070 }
        L_0x005b:
            int r3 = r2.length()     // Catch:{ all -> 0x0070 }
            if (r3 <= 0) goto L_0x0064
            r9.sendJson(r2)     // Catch:{ all -> 0x0070 }
        L_0x0064:
            r1.close()
            r10.close()
            if (r0 == 0) goto L_0x006f
            r0.close()
        L_0x006f:
            return
        L_0x0070:
            r2 = move-exception
            goto L_0x0076
        L_0x0072:
            r0 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
        L_0x0076:
            r1.close()
            r10.close()
            if (r0 == 0) goto L_0x0081
            r0.close()
        L_0x0081:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.p109v8.debug.V8DebugServer.sendCompileEvent(com.didi.dimina.v8.V8Object):void");
    }

    /* renamed from: com.didi.dimina.v8.debug.V8DebugServer$EventHandler */
    private class EventHandler implements JavaVoidCallback {
        private EventHandler() {
        }

        public void invoke(V8Object v8Object, V8Array v8Array) {
            V8Object v8Object2;
            if (v8Array != null && !v8Array.isUndefined()) {
                V8Object v8Object3 = null;
                try {
                    int integer = v8Array.getInteger(0);
                    V8Object object = v8Array.getObject(1);
                    try {
                        v8Object3 = v8Array.getObject(2);
                        if (V8DebugServer.this.traceCommunication) {
                            String str = "unknown";
                            switch (integer) {
                                case 1:
                                    str = "Break";
                                    break;
                                case 2:
                                    str = "Exception";
                                    break;
                                case 3:
                                    str = "NewFunction";
                                    break;
                                case 4:
                                    str = "BeforeCompile";
                                    break;
                                case 5:
                                    str = "AfterCompile";
                                    break;
                                case 6:
                                    str = "CompileError";
                                    break;
                                case 7:
                                    str = "PromiseEvent";
                                    break;
                                case 8:
                                    str = "AsyncTaskEvent";
                                    break;
                            }
                            System.out.println("V8 has emmitted an event of type " + str);
                        }
                        if (!V8DebugServer.this.isConnected()) {
                            safeRelease(object);
                            safeRelease(v8Object3);
                            return;
                        }
                        if (integer == 1) {
                            V8DebugServer.this.enterBreakLoop(object, v8Object3);
                        } else if (integer == 5 || integer == 6) {
                            V8DebugServer.this.sendCompileEvent(v8Object3);
                        }
                        safeRelease(object);
                        safeRelease(v8Object3);
                    } catch (Exception e) {
                        e = e;
                        v8Object2 = v8Object3;
                        v8Object3 = object;
                        try {
                            V8DebugServer.this.logError(e);
                            safeRelease(v8Object3);
                            safeRelease(v8Object2);
                        } catch (Throwable th) {
                            th = th;
                            safeRelease(v8Object3);
                            safeRelease(v8Object2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        v8Object2 = v8Object3;
                        v8Object3 = object;
                        safeRelease(v8Object3);
                        safeRelease(v8Object2);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    v8Object2 = null;
                    V8DebugServer.this.logError(e);
                    safeRelease(v8Object3);
                    safeRelease(v8Object2);
                } catch (Throwable th3) {
                    th = th3;
                    v8Object2 = null;
                    safeRelease(v8Object3);
                    safeRelease(v8Object2);
                    throw th;
                }
            }
        }

        private void safeRelease(Releasable releasable) {
            if (releasable != null) {
                releasable.release();
            }
        }
    }

    /* renamed from: com.didi.dimina.v8.debug.V8DebugServer$ClientLoop */
    private class ClientLoop implements Runnable {
        private int from;

        private ClientLoop() {
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            	at java.base/java.util.Objects.checkIndex(Objects.java:372)
            	at java.base/java.util.ArrayList.get(ArrayList.java:458)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void run() {
            /*
                r4 = this;
            L_0x0000:
                com.didi.dimina.v8.debug.V8DebugServer r0 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ Exception -> 0x0034 }
                java.net.ServerSocket r0 = r0.server     // Catch:{ Exception -> 0x0034 }
                java.net.Socket r0 = r0.accept()     // Catch:{ Exception -> 0x0034 }
                r1 = 1
                r0.setTcpNoDelay(r1)     // Catch:{ Exception -> 0x0034 }
                com.didi.dimina.v8.debug.V8DebugServer r1 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ Exception -> 0x0034 }
                java.lang.Object r1 = r1.clientLock     // Catch:{ Exception -> 0x0034 }
                monitor-enter(r1)     // Catch:{ Exception -> 0x0034 }
                com.didi.dimina.v8.debug.V8DebugServer r2 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ all -> 0x0031 }
                java.net.Socket unused = r2.client = r0     // Catch:{ all -> 0x0031 }
                com.didi.dimina.v8.debug.V8DebugServer r0 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ all -> 0x0031 }
                r2 = 0
                boolean unused = r0.waitForConnection = r2     // Catch:{ all -> 0x0031 }
                com.didi.dimina.v8.debug.V8DebugServer r0 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ all -> 0x0031 }
                java.lang.Object r0 = r0.clientLock     // Catch:{ all -> 0x0031 }
                r0.notifyAll()     // Catch:{ all -> 0x0031 }
                monitor-exit(r1)     // Catch:{ all -> 0x0031 }
                r4.startHandshake()     // Catch:{ Exception -> 0x0034 }
                r4.processClientRequests()     // Catch:{ Exception -> 0x0034 }
                goto L_0x0000
            L_0x0031:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0031 }
                throw r0     // Catch:{ Exception -> 0x0034 }
            L_0x0034:
                r0 = move-exception
                com.didi.dimina.v8.debug.V8DebugServer r1 = com.didi.dimina.p109v8.debug.V8DebugServer.this
                java.lang.Object r1 = r1.clientLock
                monitor-enter(r1)
                com.didi.dimina.v8.debug.V8DebugServer r2 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ all -> 0x005a }
                java.net.Socket r2 = r2.client     // Catch:{ all -> 0x005a }
                if (r2 == 0) goto L_0x0053
                com.didi.dimina.v8.debug.V8DebugServer r2 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ IOException -> 0x004d }
                java.net.Socket r2 = r2.client     // Catch:{ IOException -> 0x004d }
                r2.close()     // Catch:{ IOException -> 0x004d }
            L_0x004d:
                com.didi.dimina.v8.debug.V8DebugServer r2 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ all -> 0x005a }
                r3 = 0
                java.net.Socket unused = r2.client = r3     // Catch:{ all -> 0x005a }
            L_0x0053:
                monitor-exit(r1)     // Catch:{ all -> 0x005a }
                com.didi.dimina.v8.debug.V8DebugServer r1 = com.didi.dimina.p109v8.debug.V8DebugServer.this
                r1.logError(r0)
                goto L_0x0000
            L_0x005a:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x005a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.p109v8.debug.V8DebugServer.ClientLoop.run():void");
        }

        private void startHandshake() throws IOException {
            V8DebugServer.this.sendMessage(V8DebugServer.HEADER_V8_VERSION + V8DebugServer.V8_VERSION + "\r\n" + V8DebugServer.HEADER_PROTOCOL_VERSION + "1" + "\r\n" + V8DebugServer.HEADER_EMBEDDING_HOST + "j2v8 " + V8DebugServer.J2V8_VERSION + "\r\n" + V8DebugServer.HEADER_TYPE + "connect" + "\r\n", "");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
            r6 = skipToolInfo(r2, r9);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void processClientRequests() throws java.io.IOException {
            /*
                r11 = this;
                r0 = 0
                byte[] r1 = new byte[r0]
                r2 = 4096(0x1000, float:5.74E-42)
                byte[] r2 = new byte[r2]
                com.didi.dimina.v8.debug.V8DebugServer r3 = com.didi.dimina.p109v8.debug.V8DebugServer.this
                java.lang.Object r3 = r3.clientLock
                monitor-enter(r3)
                com.didi.dimina.v8.debug.V8DebugServer r4 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ all -> 0x008a }
                java.net.Socket r4 = r4.client     // Catch:{ all -> 0x008a }
                java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x008a }
                monitor-exit(r3)     // Catch:{ all -> 0x008a }
                r3 = -1
                r7 = r1
                r5 = 0
                r6 = 0
                r8 = -1
            L_0x001e:
                int r9 = 4096 - r5
                int r9 = r4.read(r2, r5, r9)
                if (r9 <= 0) goto L_0x0089
                int r9 = r9 + r5
                r11.from = r0
            L_0x0029:
                if (r8 >= 0) goto L_0x0032
                int r8 = r11.readContentLength(r2, r9)
                if (r8 >= 0) goto L_0x0032
                goto L_0x0079
            L_0x0032:
                if (r6 != 0) goto L_0x003b
                boolean r6 = r11.skipToolInfo(r2, r9)
                if (r6 != 0) goto L_0x003b
                goto L_0x0079
            L_0x003b:
                int r5 = r7.length
                int r5 = r8 - r5
                int r10 = r11.from
                int r10 = r9 - r10
                int r5 = java.lang.Math.min(r5, r10)
                int r10 = r11.from
                byte[] r7 = r11.join(r7, r2, r10, r5)
                int r10 = r11.from
                int r10 = r10 + r5
                r11.from = r10
                int r5 = r7.length
                if (r5 != r8) goto L_0x0075
                java.lang.String r5 = new java.lang.String
                java.nio.charset.Charset r6 = com.didi.dimina.p109v8.debug.V8DebugServer.PROTOCOL_CHARSET
                r5.<init>(r7, r6)
                com.didi.dimina.v8.debug.V8DebugServer r6 = com.didi.dimina.p109v8.debug.V8DebugServer.this
                java.util.List r10 = r6.requests
                monitor-enter(r10)
                com.didi.dimina.v8.debug.V8DebugServer r6 = com.didi.dimina.p109v8.debug.V8DebugServer.this     // Catch:{ all -> 0x0072 }
                java.util.List r6 = r6.requests     // Catch:{ all -> 0x0072 }
                r6.add(r5)     // Catch:{ all -> 0x0072 }
                monitor-exit(r10)     // Catch:{ all -> 0x0072 }
                r7 = r1
                r6 = 0
                r8 = -1
                goto L_0x0075
            L_0x0072:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x0072 }
                throw r0
            L_0x0075:
                int r5 = r11.from
                if (r5 < r9) goto L_0x0029
            L_0x0079:
                int r5 = r11.from
                if (r5 >= r9) goto L_0x0087
                int r10 = r9 - r5
                java.lang.System.arraycopy(r2, r5, r2, r0, r10)
                int r5 = r11.from
                int r5 = r9 - r5
                goto L_0x001e
            L_0x0087:
                r5 = 0
                goto L_0x001e
            L_0x0089:
                return
            L_0x008a:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x008a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.p109v8.debug.V8DebugServer.ClientLoop.processClientRequests():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
            r0 = r0 + com.didi.dimina.p109v8.debug.V8DebugServer.access$1300().length;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int readContentLength(byte[] r5, int r6) throws java.io.IOException {
            /*
                r4 = this;
                byte[] r0 = com.didi.dimina.p109v8.debug.V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES
                int r1 = r4.from
                int r0 = r4.indexOf(r0, r5, r1, r6)
                r1 = -1
                if (r0 >= 0) goto L_0x000e
                return r1
            L_0x000e:
                byte[] r2 = com.didi.dimina.p109v8.debug.V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES
                int r2 = r2.length
                int r0 = r0 + r2
                byte[] r2 = com.didi.dimina.p109v8.debug.V8DebugServer.PROTOCOL_EOL_BYTES
                int r6 = r4.indexOf(r2, r5, r0, r6)
                if (r6 >= 0) goto L_0x001f
                return r1
            L_0x001f:
                java.lang.String r1 = new java.lang.String
                int r2 = r6 - r0
                java.nio.charset.Charset r3 = com.didi.dimina.p109v8.debug.V8DebugServer.PROTOCOL_CHARSET
                r1.<init>(r5, r0, r2, r3)
                java.lang.String r0 = r1.trim()     // Catch:{ Exception -> 0x003b }
                int r5 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x003b }
                byte[] r0 = com.didi.dimina.p109v8.debug.V8DebugServer.PROTOCOL_EOL_BYTES
                int r0 = r0.length
                int r6 = r6 + r0
                r4.from = r6
                return r5
            L_0x003b:
                java.io.IOException r6 = new java.io.IOException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid content length header: '"
                r0.append(r2)
                r0.append(r1)
                java.lang.String r1 = "' in message"
                r0.append(r1)
                java.lang.String r1 = new java.lang.String
                java.nio.charset.Charset r2 = com.didi.dimina.p109v8.debug.V8DebugServer.PROTOCOL_CHARSET
                r1.<init>(r5, r2)
                r0.append(r1)
                java.lang.String r5 = r0.toString()
                r6.<init>(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.p109v8.debug.V8DebugServer.ClientLoop.readContentLength(byte[], int):int");
        }

        private boolean skipToolInfo(byte[] bArr, int i) {
            int indexOf = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, bArr, this.from, i);
            if (indexOf < 0) {
                return false;
            }
            this.from = indexOf + V8DebugServer.PROTOCOL_EOL_BYTES.length;
            return true;
        }

        private int indexOf(byte[] bArr, byte[] bArr2, int i, int i2) {
            int length = bArr.length;
            while (i < i2) {
                int i3 = 0;
                while (i3 <= length) {
                    if (i3 != length) {
                        int i4 = i + i3;
                        if (i4 >= i2 || bArr2[i4] != bArr[i3]) {
                            break;
                        }
                        i3++;
                    } else {
                        return i;
                    }
                }
                i++;
            }
            return -1;
        }

        private byte[] join(byte[] bArr, byte[] bArr2, int i, int i2) {
            byte[] bArr3 = new byte[(bArr.length + i2)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, i, bArr3, bArr.length, i2);
            return bArr3;
        }
    }
}
