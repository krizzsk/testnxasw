package com.didichuxing.omega.sdk.corelink.node;

public class EventUploadNode {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081 A[Catch:{ FileDisableException -> 0x0079, all -> 0x0076, all -> 0x009c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String sendRecord(com.didichuxing.omega.sdk.common.record.Record r8, java.util.List<java.util.Map.Entry<java.lang.String, byte[]>> r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            java.lang.String r10 = com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector.getOmegaId()
            r0 = 0
            r1 = 1
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ FileDisableException -> 0x0079, all -> 0x0076 }
            r2.<init>()     // Catch:{ FileDisableException -> 0x0079, all -> 0x0076 }
            com.didichuxing.omega.sdk.common.utils.ZipUtil.writeZipOutputStream(r9, r2)     // Catch:{ FileDisableException -> 0x0072, all -> 0x006e }
            byte[] r9 = r2.toByteArray()     // Catch:{ FileDisableException -> 0x0072, all -> 0x006e }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ FileDisableException -> 0x0072, all -> 0x006e }
            r3.<init>(r9)     // Catch:{ FileDisableException -> 0x0072, all -> 0x006e }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            r0.<init>()     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            java.lang.String r4 = "msgid"
            java.lang.String r5 = r8.getRecordId()     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            r0.put(r4, r5)     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            java.lang.String r4 = "oid"
            r0.put(r4, r10)     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            java.lang.String r4 = "seq"
            java.lang.Long r8 = r8.getSeq()     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            r0.put(r4, r8)     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            java.lang.String r8 = "cts"
            java.lang.String r4 = "%s"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            r7 = 0
            r5[r7] = r6     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            r0.put(r8, r4)     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            com.didichuxing.omega.sdk.analysis.Security.setHeaderCityIdEncrypt(r0, r10)     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            java.lang.String r8 = com.didichuxing.omega.sdk.common.backend.UploadStrategy.getUploadEventsUrl()     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            int r9 = r9.length     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            r4 = 1048576(0x100000, float:1.469368E-39)
            if (r9 <= r4) goto L_0x005d
            r7 = 1
        L_0x005d:
            int r9 = com.didichuxing.omega.sdk.common.OmegaConfig.HTTP_SENDER_RETRY_TIMES     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            java.lang.String r8 = com.didichuxing.omega.sdk.common.transport.HttpSender.post(r8, r3, r0, r7, r9)     // Catch:{ FileDisableException -> 0x006c, all -> 0x006a }
            r2.close()     // Catch:{ IOException -> 0x0069 }
            r3.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            return r8
        L_0x006a:
            r8 = move-exception
            goto L_0x0070
        L_0x006c:
            r8 = move-exception
            goto L_0x0074
        L_0x006e:
            r8 = move-exception
            r3 = r0
        L_0x0070:
            r0 = r2
            goto L_0x0078
        L_0x0072:
            r8 = move-exception
            r3 = r0
        L_0x0074:
            r0 = r2
            goto L_0x007b
        L_0x0076:
            r8 = move-exception
            r3 = r0
        L_0x0078:
            throw r8     // Catch:{ all -> 0x009c }
        L_0x0079:
            r8 = move-exception
            r3 = r0
        L_0x007b:
            int r9 = r8.getType()     // Catch:{ all -> 0x009c }
            if (r9 != r1) goto L_0x009b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            r9.<init>()     // Catch:{ all -> 0x009c }
            java.lang.String r1 = "type: e  oid:"
            r9.append(r1)     // Catch:{ all -> 0x009c }
            r9.append(r10)     // Catch:{ all -> 0x009c }
            java.lang.String r10 = ": upload file too large"
            r9.append(r10)     // Catch:{ all -> 0x009c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x009c }
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r9, r8)     // Catch:{ all -> 0x009c }
        L_0x009b:
            throw r8     // Catch:{ all -> 0x009c }
        L_0x009c:
            r8 = move-exception
            if (r0 == 0) goto L_0x00a2
            r0.close()     // Catch:{ IOException -> 0x00a7 }
        L_0x00a2:
            if (r3 == 0) goto L_0x00a7
            r3.close()     // Catch:{ IOException -> 0x00a7 }
        L_0x00a7:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.corelink.node.EventUploadNode.sendRecord(com.didichuxing.omega.sdk.common.record.Record, java.util.List, java.lang.String):java.lang.String");
    }
}
