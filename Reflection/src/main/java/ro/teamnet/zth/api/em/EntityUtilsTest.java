package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.api.annotations.Id;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/7/2016.
 */
public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "DEPARTMENTS", tableName);
    }
    @Test
    public void testGetColumns () {
        List<ColumnInfo> list = EntityUtils.getColumns(Department.class);
        assertEquals("Not string expected",3,list.size());
    }
    @Test
    public void testCasts () {
        assertEquals("Cast wrong",Integer.class,EntityUtils.castFromSqlType(new BigDecimal(30), Integer.class).getClass());
    }
    @Test
    public void testGetFields () {
        assertEquals("Eroare",1,EntityUtils.getFieldsByAnnotations(Department.class, Id.class).size());
    }
    @Test
    public void testgetSqlValue() {
        assertEquals("Eroare",2,EntityUtils.getFieldsByAnnotations(Department.class, Column.class).size());
    }

}
