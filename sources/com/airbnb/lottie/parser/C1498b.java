package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* renamed from: com.airbnb.lottie.parser.b */
/* compiled from: ContentModelParser */
class C1498b {

    /* renamed from: a */
    private static JsonReader.Options f1601a = JsonReader.Options.m1436of("ty", "d");

    private C1498b() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009a, code lost:
        if (r2.equals("gs") != false) goto L_0x00c6;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ContentModel m1407a(com.airbnb.lottie.parser.moshi.JsonReader r7, com.airbnb.lottie.LottieComposition r8) throws java.io.IOException {
        /*
            r7.beginObject()
            r0 = 2
            r1 = 2
        L_0x0005:
            boolean r2 = r7.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0028
            com.airbnb.lottie.parser.moshi.JsonReader$Options r2 = f1601a
            int r2 = r7.selectName(r2)
            if (r2 == 0) goto L_0x0023
            if (r2 == r3) goto L_0x001e
            r7.skipName()
            r7.skipValue()
            goto L_0x0005
        L_0x001e:
            int r1 = r7.nextInt()
            goto L_0x0005
        L_0x0023:
            java.lang.String r2 = r7.nextString()
            goto L_0x0029
        L_0x0028:
            r2 = r4
        L_0x0029:
            if (r2 != 0) goto L_0x002c
            return r4
        L_0x002c:
            r5 = -1
            int r6 = r2.hashCode()
            switch(r6) {
                case 3239: goto L_0x00bb;
                case 3270: goto L_0x00b1;
                case 3295: goto L_0x00a7;
                case 3307: goto L_0x009d;
                case 3308: goto L_0x0094;
                case 3488: goto L_0x0089;
                case 3633: goto L_0x007e;
                case 3646: goto L_0x0072;
                case 3669: goto L_0x0067;
                case 3679: goto L_0x005b;
                case 3681: goto L_0x004f;
                case 3705: goto L_0x0042;
                case 3710: goto L_0x0036;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x00c5
        L_0x0036:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 5
            goto L_0x00c6
        L_0x0042:
            java.lang.String r0 = "tm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 9
            goto L_0x00c6
        L_0x004f:
            java.lang.String r0 = "st"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 1
            goto L_0x00c6
        L_0x005b:
            java.lang.String r0 = "sr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 10
            goto L_0x00c6
        L_0x0067:
            java.lang.String r0 = "sh"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 6
            goto L_0x00c6
        L_0x0072:
            java.lang.String r0 = "rp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 12
            goto L_0x00c6
        L_0x007e:
            java.lang.String r0 = "rc"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 8
            goto L_0x00c6
        L_0x0089:
            java.lang.String r0 = "mm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 11
            goto L_0x00c6
        L_0x0094:
            java.lang.String r3 = "gs"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00c5
            goto L_0x00c6
        L_0x009d:
            java.lang.String r0 = "gr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 0
            goto L_0x00c6
        L_0x00a7:
            java.lang.String r0 = "gf"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 4
            goto L_0x00c6
        L_0x00b1:
            java.lang.String r0 = "fl"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 3
            goto L_0x00c6
        L_0x00bb:
            java.lang.String r0 = "el"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c5
            r0 = 7
            goto L_0x00c6
        L_0x00c5:
            r0 = -1
        L_0x00c6:
            switch(r0) {
                case 0: goto L_0x011f;
                case 1: goto L_0x011a;
                case 2: goto L_0x0115;
                case 3: goto L_0x0110;
                case 4: goto L_0x010b;
                case 5: goto L_0x0106;
                case 6: goto L_0x0101;
                case 7: goto L_0x00fc;
                case 8: goto L_0x00f7;
                case 9: goto L_0x00f2;
                case 10: goto L_0x00ed;
                case 11: goto L_0x00e3;
                case 12: goto L_0x00de;
                default: goto L_0x00c9;
            }
        L_0x00c9:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unknown shape type "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.airbnb.lottie.utils.Logger.warning(r8)
            goto L_0x0123
        L_0x00de:
            com.airbnb.lottie.model.content.Repeater r4 = com.airbnb.lottie.parser.C1517o.m1454a(r7, r8)
            goto L_0x0123
        L_0x00e3:
            com.airbnb.lottie.model.content.MergePaths r4 = com.airbnb.lottie.parser.C1507k.m1428a(r7)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r8.addWarning(r0)
            goto L_0x0123
        L_0x00ed:
            com.airbnb.lottie.model.content.PolystarShape r4 = com.airbnb.lottie.parser.C1509m.m1430a(r7, r8)
            goto L_0x0123
        L_0x00f2:
            com.airbnb.lottie.model.content.ShapeTrimPath r4 = com.airbnb.lottie.parser.C1522t.m1459a(r7, r8)
            goto L_0x0123
        L_0x00f7:
            com.airbnb.lottie.model.content.RectangleShape r4 = com.airbnb.lottie.parser.C1516n.m1453a(r7, r8)
            goto L_0x0123
        L_0x00fc:
            com.airbnb.lottie.model.content.CircleShape r4 = com.airbnb.lottie.parser.C1497a.m1406a(r7, r8, r1)
            goto L_0x0123
        L_0x0101:
            com.airbnb.lottie.model.content.ShapePath r4 = com.airbnb.lottie.parser.C1520r.m1457a(r7, r8)
            goto L_0x0123
        L_0x0106:
            com.airbnb.lottie.model.animatable.AnimatableTransform r4 = com.airbnb.lottie.parser.AnimatableTransformParser.parse(r7, r8)
            goto L_0x0123
        L_0x010b:
            com.airbnb.lottie.model.content.GradientFill r4 = com.airbnb.lottie.parser.C1501e.m1410a(r7, r8)
            goto L_0x0123
        L_0x0110:
            com.airbnb.lottie.model.content.ShapeFill r4 = com.airbnb.lottie.parser.C1518p.m1455a(r7, r8)
            goto L_0x0123
        L_0x0115:
            com.airbnb.lottie.model.content.GradientStroke r4 = com.airbnb.lottie.parser.C1502f.m1411a(r7, r8)
            goto L_0x0123
        L_0x011a:
            com.airbnb.lottie.model.content.ShapeStroke r4 = com.airbnb.lottie.parser.C1521s.m1458a(r7, r8)
            goto L_0x0123
        L_0x011f:
            com.airbnb.lottie.model.content.ShapeGroup r4 = com.airbnb.lottie.parser.C1519q.m1456a(r7, r8)
        L_0x0123:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x012d
            r7.skipValue()
            goto L_0x0123
        L_0x012d:
            r7.endObject()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.C1498b.m1407a(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ContentModel");
    }
}
