package rui.config.model.color;

import android.graphics.Color;
import java.util.Objects;

public class ColorFill implements IRModelColor<ColorFill> {

    /* renamed from: a */
    private String f8590a;

    public ColorFill(String str) {
        this.f8590a = str;
    }

    public int getColorValue() {
        return Color.parseColor(this.f8590a);
    }

    public String getColor() {
        return this.f8590a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f8590a.equals(((ColorFill) obj).f8590a);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f8590a});
    }
}
