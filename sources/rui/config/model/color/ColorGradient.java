package rui.config.model.color;

import java.util.Objects;
import rui.config.RConfigEngine;

public class ColorGradient implements IRModelColor<ColorGradient> {

    /* renamed from: a */
    private static final int f8591a = 3;

    /* renamed from: b */
    private String f8592b;

    /* renamed from: c */
    private String f8593c;

    public ColorGradient(String str) throws RConfigEngine.ConfigParseException {
        String[] split = str.split(":");
        if (split.length == 3) {
            this.f8592b = split[1];
            this.f8593c = split[2];
            return;
        }
        throw new RConfigEngine.ConfigParseException("gradient syntax error: " + str);
    }

    public String getGradientStart() {
        return this.f8592b;
    }

    public String getGradientEnd() {
        return this.f8593c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorGradient colorGradient = (ColorGradient) obj;
        if (!this.f8592b.equals(colorGradient.f8592b) || !this.f8593c.equals(colorGradient.f8593c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f8592b, this.f8593c});
    }
}
