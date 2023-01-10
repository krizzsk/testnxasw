package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

public class ReadKotlinClassHeaderAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {

    /* renamed from: a */
    private static final boolean f5385a = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* renamed from: b */
    private static final Map<ClassId, KotlinClassHeader.Kind> f5386b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int[] f5387c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f5388d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f5389e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f5390f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String[] f5391g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String[] f5392h = null;

    /* renamed from: i */
    private String[] f5393i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public KotlinClassHeader.Kind f5394j = null;

    /* renamed from: a */
    private static /* synthetic */ void m4934a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void visitEnd() {
    }

    static {
        HashMap hashMap = new HashMap();
        f5386b = hashMap;
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        f5386b.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        f5386b.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        f5386b.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        f5386b.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    public KotlinClassHeader createHeader() {
        int[] iArr;
        if (this.f5394j == null || (iArr = this.f5387c) == null) {
            return null;
        }
        JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(iArr, (this.f5389e & 8) != 0);
        if (!jvmMetadataVersion.isCompatible()) {
            this.f5393i = this.f5391g;
            this.f5391g = null;
        } else if (m4935a() && this.f5391g == null) {
            return null;
        }
        return new KotlinClassHeader(this.f5394j, jvmMetadataVersion, this.f5391g, this.f5393i, this.f5392h, this.f5388d, this.f5389e, this.f5390f);
    }

    /* renamed from: a */
    private boolean m4935a() {
        return this.f5394j == KotlinClassHeader.Kind.CLASS || this.f5394j == KotlinClassHeader.Kind.FILE_FACADE || this.f5394j == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
        KotlinClassHeader.Kind kind;
        if (classId == null) {
            m4934a(0);
        }
        if (sourceElement == null) {
            m4934a(1);
        }
        if (classId.asSingleFqName().equals(JvmAnnotationNames.METADATA_FQ_NAME)) {
            return new KotlinMetadataArgumentVisitor();
        }
        if (f5385a || this.f5394j != null || (kind = f5386b.get(classId)) == null) {
            return null;
        }
        this.f5394j = kind;
        return new OldDeprecatedAnnotationArgumentVisitor();
    }

    private class KotlinMetadataArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
            if (name == null) {
                $$$reportNull$$$0(6);
            }
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(7);
            return null;
        }

        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            if (name == null) {
                $$$reportNull$$$0(0);
            }
            if (classLiteralValue == null) {
                $$$reportNull$$$0(1);
            }
        }

        public void visitEnd() {
        }

        public void visitEnum(Name name, ClassId classId, Name name2) {
            if (name == null) {
                $$$reportNull$$$0(3);
            }
            if (classId == null) {
                $$$reportNull$$$0(4);
            }
            if (name2 == null) {
                $$$reportNull$$$0(5);
            }
        }

        private KotlinMetadataArgumentVisitor() {
        }

        public void visit(Name name, Object obj) {
            if (name != null) {
                String asString = name.asString();
                if ("k".equals(asString)) {
                    if (obj instanceof Integer) {
                        KotlinClassHeader.Kind unused = ReadKotlinClassHeaderAnnotationVisitor.this.f5394j = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                    }
                } else if ("mv".equals(asString)) {
                    if (obj instanceof int[]) {
                        int[] unused2 = ReadKotlinClassHeaderAnnotationVisitor.this.f5387c = (int[]) obj;
                    }
                } else if ("xs".equals(asString)) {
                    if (obj instanceof String) {
                        String unused3 = ReadKotlinClassHeaderAnnotationVisitor.this.f5388d = (String) obj;
                    }
                } else if ("xi".equals(asString)) {
                    if (obj instanceof Integer) {
                        int unused4 = ReadKotlinClassHeaderAnnotationVisitor.this.f5389e = ((Integer) obj).intValue();
                    }
                } else if ("pn".equals(asString) && (obj instanceof String)) {
                    String unused5 = ReadKotlinClassHeaderAnnotationVisitor.this.f5390f = (String) obj;
                }
            }
        }

        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name name) {
            if (name == null) {
                $$$reportNull$$$0(2);
            }
            String asString = name.asString();
            if ("d1".equals(asString)) {
                return dataArrayVisitor();
            }
            if ("d2".equals(asString)) {
                return stringsArrayVisitor();
            }
            return null;
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() {
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"}));
                }

                /* access modifiers changed from: protected */
                public void visitEnd(String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    String[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.f5391g = strArr;
                }
            };
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() {
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"}));
                }

                /* access modifiers changed from: protected */
                public void visitEnd(String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    String[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.f5392h = strArr;
                }
            };
        }
    }

    private class OldDeprecatedAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
            if (name == null) {
                $$$reportNull$$$0(6);
            }
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(7);
            return null;
        }

        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            if (name == null) {
                $$$reportNull$$$0(0);
            }
            if (classLiteralValue == null) {
                $$$reportNull$$$0(1);
            }
        }

        public void visitEnd() {
        }

        public void visitEnum(Name name, ClassId classId, Name name2) {
            if (name == null) {
                $$$reportNull$$$0(3);
            }
            if (classId == null) {
                $$$reportNull$$$0(4);
            }
            if (name2 == null) {
                $$$reportNull$$$0(5);
            }
        }

        private OldDeprecatedAnnotationArgumentVisitor() {
        }

        public void visit(Name name, Object obj) {
            if (name != null) {
                String asString = name.asString();
                if ("version".equals(asString)) {
                    if (obj instanceof int[]) {
                        int[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.f5387c = (int[]) obj;
                    }
                } else if ("multifileClassName".equals(asString)) {
                    String unused2 = ReadKotlinClassHeaderAnnotationVisitor.this.f5388d = obj instanceof String ? (String) obj : null;
                }
            }
        }

        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name name) {
            if (name == null) {
                $$$reportNull$$$0(2);
            }
            String asString = name.asString();
            if ("data".equals(asString) || "filePartClassNames".equals(asString)) {
                return dataArrayVisitor();
            }
            if ("strings".equals(asString)) {
                return stringsArrayVisitor();
            }
            return null;
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() {
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"}));
                }

                /* access modifiers changed from: protected */
                public void visitEnd(String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    String[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.f5391g = strArr;
                }
            };
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() {
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"}));
                }

                /* access modifiers changed from: protected */
                public void visitEnd(String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    String[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.f5392h = strArr;
                }
            };
        }
    }

    private static abstract class CollectStringArrayAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> strings = new ArrayList();

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "enumEntryName";
            } else if (i == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId) {
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(3);
            return null;
        }

        public void visitClassLiteral(ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(2);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void visitEnd(String[] strArr);

        public void visitEnum(ClassId classId, Name name) {
            if (classId == null) {
                $$$reportNull$$$0(0);
            }
            if (name == null) {
                $$$reportNull$$$0(1);
            }
        }

        public void visit(Object obj) {
            if (obj instanceof String) {
                this.strings.add((String) obj);
            }
        }

        public void visitEnd() {
            visitEnd((String[]) this.strings.toArray(new String[0]));
        }
    }
}
