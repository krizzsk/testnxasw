package kotlin.reflect.jvm.internal.impl.renderer;

import java.lang.reflect.Field;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;

/* compiled from: DescriptorRendererOptionsImpl.kt */
public final class DescriptorRendererOptionsImpl implements DescriptorRendererOptions {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f5504a;

    /* renamed from: A */
    private final ReadWriteProperty f5505A = m5092a(true);

    /* renamed from: B */
    private final ReadWriteProperty f5506B = m5092a(OverrideRenderingPolicy.RENDER_OPEN);

    /* renamed from: C */
    private final ReadWriteProperty f5507C = m5092a(DescriptorRenderer.ValueParametersHandler.DEFAULT.INSTANCE);

    /* renamed from: D */
    private final ReadWriteProperty f5508D = m5092a(RenderingFormat.PLAIN);

    /* renamed from: E */
    private final ReadWriteProperty f5509E = m5092a(ParameterNameRenderingPolicy.ALL);

    /* renamed from: F */
    private final ReadWriteProperty f5510F = m5092a(false);

    /* renamed from: G */
    private final ReadWriteProperty f5511G = m5092a(false);

    /* renamed from: H */
    private final ReadWriteProperty f5512H = m5092a(PropertyAccessorRenderingPolicy.DEBUG);

    /* renamed from: I */
    private final ReadWriteProperty f5513I = m5092a(false);

    /* renamed from: J */
    private final ReadWriteProperty f5514J = m5092a(false);

    /* renamed from: K */
    private final ReadWriteProperty f5515K = m5092a(SetsKt.emptySet());

    /* renamed from: L */
    private final ReadWriteProperty f5516L = m5092a(ExcludedTypeAnnotations.INSTANCE.getInternalAnnotationsForResolve());

    /* renamed from: M */
    private final ReadWriteProperty f5517M = m5092a((Object) null);

    /* renamed from: N */
    private final ReadWriteProperty f5518N = m5092a(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);

    /* renamed from: O */
    private final ReadWriteProperty f5519O = m5092a(false);

    /* renamed from: P */
    private final ReadWriteProperty f5520P = m5092a(true);

    /* renamed from: Q */
    private final ReadWriteProperty f5521Q = m5092a(true);

    /* renamed from: R */
    private final ReadWriteProperty f5522R = m5092a(false);

    /* renamed from: S */
    private final ReadWriteProperty f5523S = m5092a(true);

    /* renamed from: T */
    private final ReadWriteProperty f5524T = m5092a(true);

    /* renamed from: U */
    private final ReadWriteProperty f5525U = m5092a(false);

    /* renamed from: V */
    private final ReadWriteProperty f5526V = m5092a(false);

    /* renamed from: W */
    private final ReadWriteProperty f5527W = m5092a(false);

    /* renamed from: X */
    private final ReadWriteProperty f5528X = m5092a(true);

    /* renamed from: b */
    private boolean f5529b;

    /* renamed from: c */
    private final ReadWriteProperty f5530c = m5092a(ClassifierNamePolicy.SOURCE_CODE_QUALIFIED.INSTANCE);

    /* renamed from: d */
    private final ReadWriteProperty f5531d = m5092a(true);

    /* renamed from: e */
    private final ReadWriteProperty f5532e = m5092a(true);

    /* renamed from: f */
    private final ReadWriteProperty f5533f = m5092a(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);

    /* renamed from: g */
    private final ReadWriteProperty f5534g = m5092a(false);

    /* renamed from: h */
    private final ReadWriteProperty f5535h = m5092a(false);

    /* renamed from: i */
    private final ReadWriteProperty f5536i = m5092a(false);

    /* renamed from: j */
    private final ReadWriteProperty f5537j = m5092a(false);

    /* renamed from: k */
    private final ReadWriteProperty f5538k = m5092a(false);

    /* renamed from: l */
    private final ReadWriteProperty f5539l = m5092a(true);

    /* renamed from: m */
    private final ReadWriteProperty f5540m = m5092a(false);

    /* renamed from: n */
    private final ReadWriteProperty f5541n = m5092a(false);

    /* renamed from: o */
    private final ReadWriteProperty f5542o = m5092a(false);

    /* renamed from: p */
    private final ReadWriteProperty f5543p = m5092a(true);

    /* renamed from: q */
    private final ReadWriteProperty f5544q = m5092a(true);

    /* renamed from: r */
    private final ReadWriteProperty f5545r = m5092a(false);

    /* renamed from: s */
    private final ReadWriteProperty f5546s = m5092a(false);

    /* renamed from: t */
    private final ReadWriteProperty f5547t = m5092a(false);

    /* renamed from: u */
    private final ReadWriteProperty f5548u = m5092a(false);

    /* renamed from: v */
    private final ReadWriteProperty f5549v = m5092a(false);

    /* renamed from: w */
    private final ReadWriteProperty f5550w = m5092a(false);

    /* renamed from: x */
    private final ReadWriteProperty f5551x = m5092a(false);

    /* renamed from: y */
    private final ReadWriteProperty f5552y = m5092a(DescriptorRendererOptionsImpl$typeNormalizer$2.INSTANCE);

    /* renamed from: z */
    private final ReadWriteProperty f5553z = m5092a(DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2.INSTANCE);

    public boolean getIncludeAnnotationArguments() {
        return DescriptorRendererOptions.DefaultImpls.getIncludeAnnotationArguments(this);
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return DescriptorRendererOptions.DefaultImpls.getIncludeEmptyAnnotationArguments(this);
    }

    public final boolean isLocked() {
        return this.f5529b;
    }

    public final void lock() {
        boolean z = !this.f5529b;
        if (!_Assertions.ENABLED || z) {
            this.f5529b = true;
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public final DescriptorRendererOptionsImpl copy() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
        Field[] declaredFields = getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                ObservableProperty observableProperty = obj instanceof ObservableProperty ? (ObservableProperty) obj : null;
                if (observableProperty == null) {
                    continue;
                } else {
                    String name = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "field.name");
                    boolean z = !StringsKt.startsWith$default(name, "is", false, 2, (Object) null);
                    if (!_Assertions.ENABLED || z) {
                        KDeclarationContainer orCreateKotlinClass = C2404Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class);
                        String name2 = field.getName();
                        String name3 = field.getName();
                        Intrinsics.checkNotNullExpressionValue(name3, "field.name");
                        if (name3.length() > 0) {
                            char upperCase = Character.toUpperCase(name3.charAt(0));
                            String substring = name3.substring(1);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                            name3 = String.valueOf(upperCase) + substring;
                        }
                        field.set(descriptorRendererOptionsImpl, descriptorRendererOptionsImpl.m5092a(observableProperty.getValue(this, new PropertyReference1Impl(orCreateKotlinClass, name2, Intrinsics.stringPlus("get", name3)))));
                    } else {
                        throw new AssertionError("Fields named is* are not supported here yet");
                    }
                }
            }
        }
        return descriptorRendererOptionsImpl;
    }

    /* renamed from: a */
    private final <T> ReadWriteProperty<DescriptorRendererOptionsImpl, T> m5092a(T t) {
        Delegates delegates = Delegates.INSTANCE;
        return new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(t, t, this);
    }

    static {
        Class<DescriptorRendererOptionsImpl> cls = DescriptorRendererOptionsImpl.class;
        f5504a = new KProperty[]{C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "withDefinedIn", "getWithDefinedIn()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "modifiers", "getModifiers()Ljava/util/Set;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "startFromName", "getStartFromName()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "debugMode", "getDebugMode()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "verbose", "getVerbose()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "unitReturnType", "getUnitReturnType()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "withoutReturnType", "getWithoutReturnType()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "enhancedTypes", "getEnhancedTypes()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "normalizedVisibilities", "getNormalizedVisibilities()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderDefaultModality", "getRenderDefaultModality()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "includePropertyConstant", "getIncludePropertyConstant()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "withoutTypeParameters", "getWithoutTypeParameters()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "withoutSuperTypes", "getWithoutSuperTypes()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "receiverAfterName", "getReceiverAfterName()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderTypeExpansions", "getRenderTypeExpansions()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "renderFunctionContracts", "getRenderFunctionContracts()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "informativeErrorType", "getInformativeErrorType()Z"))};
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return (ClassifierNamePolicy) this.f5530c.getValue(this, f5504a[0]);
    }

    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.f5530c.setValue(this, f5504a[0], classifierNamePolicy);
    }

    public boolean getWithDefinedIn() {
        return ((Boolean) this.f5531d.getValue(this, f5504a[1])).booleanValue();
    }

    public void setWithDefinedIn(boolean z) {
        this.f5531d.setValue(this, f5504a[1], Boolean.valueOf(z));
    }

    public boolean getWithSourceFileForTopLevel() {
        return ((Boolean) this.f5532e.getValue(this, f5504a[2])).booleanValue();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return (Set) this.f5533f.getValue(this, f5504a[3]);
    }

    public void setModifiers(Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.f5533f.setValue(this, f5504a[3], set);
    }

    public boolean getStartFromName() {
        return ((Boolean) this.f5534g.getValue(this, f5504a[4])).booleanValue();
    }

    public void setStartFromName(boolean z) {
        this.f5534g.setValue(this, f5504a[4], Boolean.valueOf(z));
    }

    public boolean getStartFromDeclarationKeyword() {
        return ((Boolean) this.f5535h.getValue(this, f5504a[5])).booleanValue();
    }

    public boolean getDebugMode() {
        return ((Boolean) this.f5536i.getValue(this, f5504a[6])).booleanValue();
    }

    public void setDebugMode(boolean z) {
        this.f5536i.setValue(this, f5504a[6], Boolean.valueOf(z));
    }

    public boolean getClassWithPrimaryConstructor() {
        return ((Boolean) this.f5537j.getValue(this, f5504a[7])).booleanValue();
    }

    public boolean getVerbose() {
        return ((Boolean) this.f5538k.getValue(this, f5504a[8])).booleanValue();
    }

    public void setVerbose(boolean z) {
        this.f5538k.setValue(this, f5504a[8], Boolean.valueOf(z));
    }

    public boolean getUnitReturnType() {
        return ((Boolean) this.f5539l.getValue(this, f5504a[9])).booleanValue();
    }

    public boolean getWithoutReturnType() {
        return ((Boolean) this.f5540m.getValue(this, f5504a[10])).booleanValue();
    }

    public boolean getEnhancedTypes() {
        return ((Boolean) this.f5541n.getValue(this, f5504a[11])).booleanValue();
    }

    public boolean getNormalizedVisibilities() {
        return ((Boolean) this.f5542o.getValue(this, f5504a[12])).booleanValue();
    }

    public boolean getRenderDefaultVisibility() {
        return ((Boolean) this.f5543p.getValue(this, f5504a[13])).booleanValue();
    }

    public boolean getRenderDefaultModality() {
        return ((Boolean) this.f5544q.getValue(this, f5504a[14])).booleanValue();
    }

    public boolean getRenderConstructorDelegation() {
        return ((Boolean) this.f5545r.getValue(this, f5504a[15])).booleanValue();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return ((Boolean) this.f5546s.getValue(this, f5504a[16])).booleanValue();
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return ((Boolean) this.f5547t.getValue(this, f5504a[17])).booleanValue();
    }

    public boolean getUninferredTypeParameterAsName() {
        return ((Boolean) this.f5548u.getValue(this, f5504a[18])).booleanValue();
    }

    public boolean getIncludePropertyConstant() {
        return ((Boolean) this.f5549v.getValue(this, f5504a[19])).booleanValue();
    }

    public boolean getWithoutTypeParameters() {
        return ((Boolean) this.f5550w.getValue(this, f5504a[20])).booleanValue();
    }

    public void setWithoutTypeParameters(boolean z) {
        this.f5550w.setValue(this, f5504a[20], Boolean.valueOf(z));
    }

    public boolean getWithoutSuperTypes() {
        return ((Boolean) this.f5551x.getValue(this, f5504a[21])).booleanValue();
    }

    public void setWithoutSuperTypes(boolean z) {
        this.f5551x.setValue(this, f5504a[21], Boolean.valueOf(z));
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return (Function1) this.f5552y.getValue(this, f5504a[22]);
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return (Function1) this.f5553z.getValue(this, f5504a[23]);
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return ((Boolean) this.f5505A.getValue(this, f5504a[24])).booleanValue();
    }

    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return (OverrideRenderingPolicy) this.f5506B.getValue(this, f5504a[25]);
    }

    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return (DescriptorRenderer.ValueParametersHandler) this.f5507C.getValue(this, f5504a[26]);
    }

    public RenderingFormat getTextFormat() {
        return (RenderingFormat) this.f5508D.getValue(this, f5504a[27]);
    }

    public void setTextFormat(RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.f5508D.setValue(this, f5504a[27], renderingFormat);
    }

    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return (ParameterNameRenderingPolicy) this.f5509E.getValue(this, f5504a[28]);
    }

    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.f5509E.setValue(this, f5504a[28], parameterNameRenderingPolicy);
    }

    public boolean getReceiverAfterName() {
        return ((Boolean) this.f5510F.getValue(this, f5504a[29])).booleanValue();
    }

    public void setReceiverAfterName(boolean z) {
        this.f5510F.setValue(this, f5504a[29], Boolean.valueOf(z));
    }

    public boolean getRenderCompanionObjectName() {
        return ((Boolean) this.f5511G.getValue(this, f5504a[30])).booleanValue();
    }

    public void setRenderCompanionObjectName(boolean z) {
        this.f5511G.setValue(this, f5504a[30], Boolean.valueOf(z));
    }

    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return (PropertyAccessorRenderingPolicy) this.f5512H.getValue(this, f5504a[31]);
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return ((Boolean) this.f5513I.getValue(this, f5504a[32])).booleanValue();
    }

    public boolean getEachAnnotationOnNewLine() {
        return ((Boolean) this.f5514J.getValue(this, f5504a[33])).booleanValue();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return (Set) this.f5515K.getValue(this, f5504a[34]);
    }

    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return (Set) this.f5516L.getValue(this, f5504a[35]);
    }

    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.f5516L.setValue(this, f5504a[35], set);
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return (Function1) this.f5517M.getValue(this, f5504a[36]);
    }

    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return (AnnotationArgumentsRenderingPolicy) this.f5518N.getValue(this, f5504a[37]);
    }

    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.f5518N.setValue(this, f5504a[37], annotationArgumentsRenderingPolicy);
    }

    public boolean getAlwaysRenderModifiers() {
        return ((Boolean) this.f5519O.getValue(this, f5504a[38])).booleanValue();
    }

    public boolean getRenderConstructorKeyword() {
        return ((Boolean) this.f5520P.getValue(this, f5504a[39])).booleanValue();
    }

    public boolean getRenderUnabbreviatedType() {
        return ((Boolean) this.f5521Q.getValue(this, f5504a[40])).booleanValue();
    }

    public boolean getRenderTypeExpansions() {
        return ((Boolean) this.f5522R.getValue(this, f5504a[41])).booleanValue();
    }

    public boolean getIncludeAdditionalModifiers() {
        return ((Boolean) this.f5523S.getValue(this, f5504a[42])).booleanValue();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return ((Boolean) this.f5524T.getValue(this, f5504a[43])).booleanValue();
    }

    public boolean getPresentableUnresolvedTypes() {
        return ((Boolean) this.f5526V.getValue(this, f5504a[45])).booleanValue();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return ((Boolean) this.f5527W.getValue(this, f5504a[46])).booleanValue();
    }

    public boolean getInformativeErrorType() {
        return ((Boolean) this.f5528X.getValue(this, f5504a[47])).booleanValue();
    }
}
