package com.didi.dvm.patch.dvm_patch;

import android.text.TextUtils;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PatchElement implements Serializable {
    public static int ACTION_ADD_AND_UPDATE = 1;
    public static int ACTION_ROLLBACK = 2;

    /* renamed from: SP */
    public static final String f21170SP = "___";
    private static Logger logger = LoggerFactory.getLogger("DVMPatchElement");
    public int action;
    public String[] appVersion = new String[0];
    public String bin;
    String file;

    /* renamed from: id */
    public String f21171id;
    JSONObject patches;
    public String signature;
    private File tmpFile;
    public long version;

    public static PatchElement fromControlFile(JSONObject jSONObject) {
        PatchElement patchElement = new PatchElement();
        patchElement.f21171id = jSONObject.optString("id");
        JSONArray optJSONArray = jSONObject.optJSONArray("appVersion");
        if (optJSONArray != null) {
            patchElement.appVersion = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                patchElement.appVersion[i] = optJSONArray.optString(i);
            }
        } else {
            patchElement.appVersion = new String[0];
        }
        patchElement.patches = jSONObject.optJSONObject("patches");
        return patchElement;
    }

    public boolean isVersionMatch() {
        boolean z;
        if (this.appVersion != null) {
            int i = 0;
            z = false;
            while (true) {
                String[] strArr = this.appVersion;
                if (i >= strArr.length) {
                    break;
                }
                String[] split = strArr[i].split("@");
                if (split[0].equals(DVMPatchManager.f21159g)) {
                    z = split.length == 2 ? split[1].equals(DVMPatchManager.f21158f) : true;
                    if (z) {
                        break;
                    }
                }
                i++;
            }
        } else {
            z = false;
        }
        Logger logger2 = logger;
        logger2.debug("isVersionMatch：" + z, new Object[0]);
        return z;
    }

    public boolean isDownloaded() {
        File patchDir = getPatchDir();
        if (patchDir.exists() && new File(patchDir, "data.bin").exists() && new File(patchDir, "patch.json").exists()) {
            return true;
        }
        return false;
    }

    public File createDownloadTempFile() throws IOException {
        File file2 = new File(DVMPatchManager.tempDir, this.f21171id);
        this.tmpFile = file2;
        if (file2.exists()) {
            this.tmpFile.delete();
        } else {
            this.tmpFile.getParentFile().mkdirs();
        }
        this.tmpFile.createNewFile();
        return this.tmpFile;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean verify() {
        /*
            r6 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.File r1 = r6.tmpFile
            r2 = 0
            if (r1 == 0) goto L_0x005c
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x005c
            java.io.File r1 = r6.tmpFile
            java.lang.String r1 = com.didi.sdk.util.FileUtil.getFileMD5(r1)
            java.lang.String r3 = r6.signature     // Catch:{ Exception -> 0x0042 }
            boolean r1 = com.didi.dvm.patch.dvm_patch.Validator.verify(r1, r3)     // Catch:{ Exception -> 0x0042 }
            com.didi.sdk.logging.Logger r3 = logger     // Catch:{ Exception -> 0x0040 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0040 }
            r4.<init>()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r5 = "verify patch ["
            r4.append(r5)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r5 = r6.f21171id     // Catch:{ Exception -> 0x0040 }
            r4.append(r5)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r5 = "]"
            r4.append(r5)     // Catch:{ Exception -> 0x0040 }
            r4.append(r1)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0040 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0040 }
            r3.info((java.lang.String) r4, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0040 }
            goto L_0x005b
        L_0x0040:
            r2 = move-exception
            goto L_0x0045
        L_0x0042:
            r1 = move-exception
            r2 = r1
            r1 = 0
        L_0x0045:
            r2.printStackTrace()
            java.lang.String r3 = r2.toString()
            java.lang.String r4 = "e"
            r0.put(r4, r3)
            java.lang.String r2 = com.didi.dvm.patch.dvm_patch.EventTracker.getStackTrace(r2)
            java.lang.String r3 = "s"
            r0.put(r3, r2)
        L_0x005b:
            r2 = r1
        L_0x005c:
            java.lang.String r1 = r6.f21171id
            java.lang.String r3 = "id"
            r0.put(r3, r1)
            java.lang.String r1 = r6.bin
            java.lang.String r3 = "bin"
            r0.put(r3, r1)
            long r3 = r6.version
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "v"
            r0.put(r3, r1)
            if (r2 != 0) goto L_0x0080
            com.didi.dvm.patch.dvm_patch.EventTracker r1 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f21155c
            java.lang.String r3 = "tech_dvm_patch_verify_error"
            r1.mo63966a(r3, r0)
        L_0x0080:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.PatchElement.verify():boolean");
    }

    public void takeEffect() throws IOException {
        try {
            File patchDir = getPatchDir();
            if (patchDir.exists()) {
                patchDir.delete();
            }
            patchDir.mkdirs();
            if (unzip(this.tmpFile, patchDir)) {
                Logger logger2 = logger;
                logger2.debug("unzip [" + this.f21171id + "] to [" + patchDir.getAbsolutePath() + "] success", new Object[0]);
                loadPatchInfo();
                DVMPatchManager.takeEffect(true);
            }
            this.tmpFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("id", this.f21171id);
            hashMap.put("bin", this.bin);
            hashMap.put("e", e.toString());
            hashMap.put(RavenKey.STACK, EventTracker.getStackTrace(e));
            hashMap.put(RavenKey.VERSION, Long.valueOf(this.version));
            DVMPatchManager.f21155c.mo63966a("tech_dvm_patch_take_effect_error", hashMap);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076 A[SYNTHETIC, Splitter:B:38:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0080 A[SYNTHETIC, Splitter:B:43:0x0080] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unzip(java.io.File r5, java.io.File r6) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0072 }
            r1.<init>(r5)     // Catch:{ all -> 0x0072 }
            java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x006e }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ all -> 0x006e }
            r2.<init>(r1)     // Catch:{ all -> 0x006e }
            r5.<init>(r2)     // Catch:{ all -> 0x006e }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x006c }
            boolean r2 = r6.exists()     // Catch:{ all -> 0x006c }
            if (r2 != 0) goto L_0x001d
            r6.mkdirs()     // Catch:{ all -> 0x006c }
        L_0x001d:
            java.util.zip.ZipEntry r2 = r5.getNextEntry()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x005a
            java.lang.String r3 = r2.getName()     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "../"
            boolean r4 = r3.contains(r4)     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x0030
            goto L_0x001d
        L_0x0030:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x006c }
            r4.<init>(r6, r3)     // Catch:{ all -> 0x006c }
            boolean r2 = r2.isDirectory()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x003f
            r4.mkdirs()     // Catch:{ all -> 0x006c }
            goto L_0x001d
        L_0x003f:
            r4.createNewFile()     // Catch:{ all -> 0x006c }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x006c }
            r2.<init>(r4)     // Catch:{ all -> 0x006c }
        L_0x0047:
            int r3 = r5.read(r0)     // Catch:{ all -> 0x006c }
            r4 = -1
            if (r3 == r4) goto L_0x0053
            r4 = 0
            r2.write(r0, r4, r3)     // Catch:{ all -> 0x006c }
            goto L_0x0047
        L_0x0053:
            r2.close()     // Catch:{ all -> 0x006c }
            r5.closeEntry()     // Catch:{ all -> 0x006c }
            goto L_0x001d
        L_0x005a:
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0062:
            r5.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r5 = move-exception
            r5.printStackTrace()
        L_0x006a:
            r5 = 1
            return r5
        L_0x006c:
            r6 = move-exception
            goto L_0x0070
        L_0x006e:
            r6 = move-exception
            r5 = r0
        L_0x0070:
            r0 = r1
            goto L_0x0074
        L_0x0072:
            r6 = move-exception
            r5 = r0
        L_0x0074:
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007e:
            if (r5 == 0) goto L_0x0088
            r5.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0088:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.PatchElement.unzip(java.io.File, java.io.File):boolean");
    }

    public void rollback() {
        try {
            Logger logger2 = logger;
            logger2.info("try rollback dvm patch:" + this.f21171id, new Object[0]);
            File patchDir = getPatchDir();
            if (patchDir.exists()) {
                patchDir.delete();
            }
            Logger logger3 = logger;
            logger3.info("rollback dvm patch " + this.f21171id + " done", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("id", this.f21171id);
            hashMap.put("e", e.toString());
            hashMap.put(RavenKey.STACK, EventTracker.getStackTrace(e));
            DVMPatchManager.f21155c.mo63966a("tech_dvm_patch_rollback_error", hashMap);
        }
    }

    public File getPatchDir() {
        String[] split = this.f21171id.split(f21170SP);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i != 0) {
                sb.append(File.separator);
            }
            sb.append(split[i]);
        }
        return new File(DVMPatchManager.f21154b, sb.toString());
    }

    public SelfCheckResult selfChecking() {
        SelfCheckResult selfCheckResult = new SelfCheckResult();
        if (this.f21171id == null) {
            selfCheckResult.f21172ok = false;
            selfCheckResult.msg.add("id is null");
            logger.debug("selfChecking id is null", new Object[0]);
            return selfCheckResult;
        } else if (DVMPatchManager.f21161i != null && !DVMPatchManager.f21161i.contains(this.f21171id)) {
            Logger logger2 = logger;
            logger2.info("not in validPatches，ignore this patch:" + this.f21171id, new Object[0]);
            selfCheckResult.f21172ok = false;
            List<String> list = selfCheckResult.msg;
            list.add("not in validPatches，ignore this patch:" + this.f21171id);
            Logger logger3 = logger;
            logger3.debug("not in validPatches，ignore this patch:" + this.f21171id, new Object[0]);
            return selfCheckResult;
        } else if (!isVersionMatch()) {
            selfCheckResult.f21172ok = false;
            selfCheckResult.msg.add("version not match");
            logger.debug("version not match", new Object[0]);
            return selfCheckResult;
        } else {
            File patchDir = getPatchDir();
            if (!patchDir.exists()) {
                selfCheckResult.f21172ok = false;
                selfCheckResult.msg.add("path dir not exists");
                logger.debug("selfChecking path dir not exists", new Object[0]);
                return selfCheckResult;
            }
            File file2 = new File(patchDir, "patch.json");
            if (!file2.exists()) {
                selfCheckResult.f21172ok = false;
                logger.debug("remove patch because of patch.json not exists", new Object[0]);
                List<String> list2 = selfCheckResult.msg;
                list2.add(file2 + " not exists");
            }
            File file3 = new File(patchDir, "data.bin");
            this.file = file3.getAbsolutePath();
            if (!file3.exists()) {
                selfCheckResult.f21172ok = false;
                List<String> list3 = selfCheckResult.msg;
                list3.add(this.file + " not exists");
                logger.debug("selfChecking dataFile not exists", new Object[0]);
            }
            return selfCheckResult;
        }
    }

    public JSONObject getPatchInfo() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("file", new File(getPatchDir(), "data.bin").getAbsolutePath());
        jSONObject.put("patches", this.patches);
        return jSONObject;
    }

    public String getPackageName() {
        String str = this.f21171id;
        return str.substring(0, str.lastIndexOf(f21170SP));
    }

    public JSONObject loadPatchInfo() {
        JSONObject optJSONObject;
        JSONObject readFile2JSON = DVMPatchManager.readFile2JSON(new File(getPatchDir(), "patch.json"));
        if (!(readFile2JSON == null || (optJSONObject = readFile2JSON.optJSONObject(getNameSpace())) == null)) {
            this.patches = optJSONObject.optJSONObject("patches");
        }
        return this.patches;
    }

    public String getNameSpace() {
        String str = this.f21171id;
        return str.substring(0, str.indexOf(f21170SP));
    }

    public JSONObject getControlInfo() {
        loadPatchInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (String put : this.appVersion) {
                jSONArray.put(put);
            }
            jSONObject.put("version", this.version);
            jSONObject.put("appVersion", jSONArray);
            jSONObject.put("patches", this.patches);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean isIdAvailable() {
        String str = this.f21171id;
        if ((str == null && !str.contains(f21170SP)) || TextUtils.isEmpty(getNameSpace())) {
            return false;
        }
        String str2 = this.f21171id;
        String substring = str2.substring(str2.lastIndexOf(f21170SP) + 3);
        if (!("" + this.version).equals(substring)) {
            return false;
        }
        return true;
    }

    static class SelfCheckResult {
        List<String> msg = new ArrayList();

        /* renamed from: ok */
        public boolean f21172ok = true;

        SelfCheckResult() {
        }
    }
}
