package ro.teamnet.zth.api.em;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 7/7/2016.
 */
public class QueryBuilder {

    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public String getValueForQuery(Object value) {
        if(value.getClass() == String.class) {
            return '\''+(String) value+'\'';
        }
        else if (value.getClass() == Date.class) {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'";

        }
        return null;
    }
    public QueryBuilder addCondition (Condition condition) {
        conditions.add(condition);
        return this;
    }
    public QueryBuilder setTableName (Object tableName) {
        this.tableName = tableName;
        return this;
    }
    public QueryBuilder addQueryColumns (List<ColumnInfo> queryColumns) {
        this.queryColumns.addAll(queryColumns);
        return this;
    }
    public QueryBuilder setQueryType (QueryType queryType) {
        this.queryType = queryType;
        return this;
    }
    private String createSelectQuery () {
        StringBuilder string = new StringBuilder();
        string.append("SELECT");
        int i=0;
        if(queryColumns.size()!=0) {
            for (i = 0; i < queryColumns.size() - 1; i++) {
                string.append(" ");
                string.append(queryColumns.get(i));
                string.append(',');
            }
            string.append(" ");
            string.append(queryColumns.get(i));
        }
        string.append(" FROM ");
        string.append(tableName);
        if(conditions.size()!=0) {
            string.append(" WHERE ");
            for (i = 0; i < conditions.size() - 1; i++) {
                string.append(conditions.get(i));
                string.append(" AND ");
            }
            string.append(conditions.get(i));
        }
        string.append(";");

        return string.toString();
    }

    private String createDeleteQuery () {
        StringBuilder string = new StringBuilder();
        string.append("DELETE ");
        int i=0;
        string.append("FROM ");
        string.append(tableName);
        if(conditions.size()!=0) {
            string.append(" WHERE ");
            for (i = 0; i < conditions.size() - 1; i++) {
                string.append(conditions.get(i));
                string.append(" AND ");
            }
            string.append(conditions.get(i));
        }
        string.append(";");

        return string.toString();
    }

    private String createUpdateQuery () {
        StringBuilder string = new StringBuilder();
        string.append("UPDATE ");
        string.append(tableName);

        int i=0;
        if(queryColumns.size()!=0) {
            string.append(" SET");
            for (i = 0; i < queryColumns.size() - 1; i++) {
                string.append(" ");
                string.append(queryColumns.get(i));
                string.append(',');
            }
            string.append(" ");
            string.append(queryColumns.get(i));

        }


        if(conditions.size()!=0) {
            string.append(" WHERE ");
            for (i = 0; i < conditions.size() - 1; i++) {
                string.append(conditions.get(i));
                string.append(" AND ");
            }
            string.append(conditions.get(i));
        }
        string.append(";");

        return string.toString();
    }


    private String createInsertQuery () {
        StringBuilder string = new StringBuilder();
        string.append("INSERT INTO ");
        string.append(tableName);
        string.append(" VALUES (");
        int i=0;
        if(queryColumns.size()!=0) {
            for (i = 0; i < queryColumns.size() - 1; i++) {

                string.append(queryColumns.get(i));
                string.append(',');
            }

            string.append(queryColumns.get(i));

        }

        string.append(");");


        return string.toString();
    }
    public String CreateQuery() {
        String s = null;
        if(queryType.equals("SELECT"))
            s = createSelectQuery();
        else if(queryType.equals("DELETE"))
            s = createDeleteQuery();
        else if(queryType.equals("INSERT"))
            s= createInsertQuery();
        else if(queryType.equals("UPDATE"))
            s = createUpdateQuery();
            return s;
    }
}
