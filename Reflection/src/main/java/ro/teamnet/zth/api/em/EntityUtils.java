package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Table;
import ro.teamnet.zth.api.annotations.Id;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

import static sun.security.krb5.Confounder.intValue;

/**
 * Created by user on 7/7/2016.
 */
public class EntityUtils {
    private EntityUtils() throws UnsupportedOperationException {}
    public static String getTableName (Class entity) {
        Table annotation = (Table) entity.getAnnotation(Table.class);
        if(annotation != null)
            return annotation.name();
        else
            return entity.getName();
    }
    public static List<ColumnInfo> getColumns (Class entity) {
        List<ColumnInfo> list = new ArrayList<ColumnInfo>();
        for(Field f : entity.getDeclaredFields()) {
            ColumnInfo elem = new ColumnInfo();
            elem.setColumnName(f.getName());
            elem.setColumnType(f.getType());

            Id idAnnotation = (Id) entity.getAnnotation(Id.class);
            if(idAnnotation != null) {
                elem.setDbName(idAnnotation.name());
                elem.setId(true);
            }
            else {
                elem.setId(false);
                Column column = (Column) entity.getAnnotation(Column.class);
                if(column != null)
                elem.setValue(column.name());
            }

            list.add(elem);
        }

        return list;
    }
    public static Object castFromSqlType(Object value, Class wantedType) {
        if(value.getClass() == BigDecimal.class && wantedType == Integer.class) {
            return ((BigDecimal) value).intValue();
        }
        else if(value.getClass() == BigDecimal.class && wantedType == Long.class) {
            return ((BigDecimal) value).longValue();
        }
        else if(value.getClass() == BigDecimal.class && wantedType == Double.class) {
            return ((BigDecimal) value).doubleValue();
        }
        else if(value.getClass() == BigDecimal.class && wantedType == Float.class) {
            return ((BigDecimal) value).floatValue();
        }
        else if(value.getClass() == BigDecimal.class) {
            return ((BigDecimal) value);
        }
        return value.getClass().cast(wantedType);
    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        List<Field> list = new ArrayList<Field>();

        for(Field f : clazz.getDeclaredFields()) {
            if(f.isAnnotationPresent(annotation)) {
                list.add(f);
            }
        }

        return list;
    }

    public static Object getSqlValue(Object object) {
        if(object.getClass().isAnnotationPresent(Table.class)) {
            Field[] list = object.getClass().getDeclaredFields();
            for(Field f : list) {
                if(f.getClass().isAnnotationPresent(Id.class))
                    f.setAccessible(true);


            }
        }
            return object;
    }


}

