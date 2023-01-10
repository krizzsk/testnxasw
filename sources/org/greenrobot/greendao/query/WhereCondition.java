package org.greenrobot.greendao.query;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;

public interface WhereCondition {
    void appendTo(StringBuilder sb, String str);

    void appendValuesTo(List<Object> list);

    public static abstract class AbstractCondition implements WhereCondition {
        protected final boolean hasSingleValue;
        protected final Object value;
        protected final Object[] values;

        public AbstractCondition() {
            this.hasSingleValue = false;
            this.value = null;
            this.values = null;
        }

        public AbstractCondition(Object obj) {
            this.value = obj;
            this.hasSingleValue = true;
            this.values = null;
        }

        public AbstractCondition(Object[] objArr) {
            this.value = null;
            this.hasSingleValue = false;
            this.values = objArr;
        }

        public void appendValuesTo(List<Object> list) {
            if (this.hasSingleValue) {
                list.add(this.value);
                return;
            }
            Object[] objArr = this.values;
            if (objArr != null) {
                for (Object add : objArr) {
                    list.add(add);
                }
            }
        }
    }

    public static class PropertyCondition extends AbstractCondition {

        /* renamed from: op */
        public final String f8428op;
        public final Property property;

        private static Object checkValueForType(Property property2, Object obj) {
            if (obj != null && obj.getClass().isArray()) {
                throw new DaoException("Illegal value: found array, but simple object required");
            } else if (property2.type != Date.class) {
                if (property2.type == Boolean.TYPE || property2.type == Boolean.class) {
                    if (obj instanceof Boolean) {
                        return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                    }
                    if (obj instanceof Number) {
                        int intValue = ((Number) obj).intValue();
                        if (!(intValue == 0 || intValue == 1)) {
                            throw new DaoException("Illegal boolean value: numbers must be 0 or 1, but was " + obj);
                        }
                    } else if (obj instanceof String) {
                        String str = (String) obj;
                        if ("TRUE".equalsIgnoreCase(str)) {
                            return 1;
                        }
                        if ("FALSE".equalsIgnoreCase(str)) {
                            return 0;
                        }
                        throw new DaoException("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was " + obj);
                    }
                }
                return obj;
            } else if (obj instanceof Date) {
                return Long.valueOf(((Date) obj).getTime());
            } else {
                if (obj instanceof Long) {
                    return obj;
                }
                throw new DaoException("Illegal date value: expected java.util.Date or Long for value " + obj);
            }
        }

        private static Object[] checkValuesForType(Property property2, Object[] objArr) {
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = checkValueForType(property2, objArr[i]);
            }
            return objArr;
        }

        public PropertyCondition(Property property2, String str) {
            this.property = property2;
            this.f8428op = str;
        }

        public PropertyCondition(Property property2, String str, Object obj) {
            super(checkValueForType(property2, obj));
            this.property = property2;
            this.f8428op = str;
        }

        public PropertyCondition(Property property2, String str, Object[] objArr) {
            super(checkValuesForType(property2, objArr));
            this.property = property2;
            this.f8428op = str;
        }

        public void appendTo(StringBuilder sb, String str) {
            SqlUtils.appendProperty(sb, str, this.property).append(this.f8428op);
        }
    }

    public static class StringCondition extends AbstractCondition {
        protected final String string;

        public StringCondition(String str) {
            this.string = str;
        }

        public StringCondition(String str, Object obj) {
            super(obj);
            this.string = str;
        }

        public StringCondition(String str, Object... objArr) {
            super(objArr);
            this.string = str;
        }

        public void appendTo(StringBuilder sb, String str) {
            sb.append(this.string);
        }
    }
}
