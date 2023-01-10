package rui.config.model.color;

import rui.config.RConfigEngine;
import rui.config.model.IRModel;

public class ColorName implements IRModelColor<ColorName> {

    /* renamed from: a */
    private static final String f8594a = "color name not found: ";

    /* renamed from: b */
    private static final String f8595b = "parent name type is not color: ";

    /* renamed from: c */
    private IRModelColor f8596c;

    public ColorName(String str) throws RConfigEngine.ConfigParseException {
        try {
            IRModel iRModel = RConfigEngine.get(str);
            if (iRModel instanceof IRModelColor) {
                this.f8596c = (IRModelColor) iRModel;
                return;
            }
            throw new RConfigEngine.ConfigParseException(f8595b + str);
        } catch (RConfigEngine.ConfigParseException unused) {
            throw new RConfigEngine.ConfigParseException(f8594a + str);
        }
    }

    public IRModelColor getParent() {
        return this.f8596c;
    }
}
