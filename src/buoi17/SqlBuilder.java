package buoi17;

import java.util.List;
import java.util.Map;

public class SqlBuilder {
    private QueryPractice queryPractice;

    public SqlBuilder(QueryPractice queryPractice) {
        this.queryPractice = queryPractice;
    }

    public String queryPractice(String rootQuery) {
        StringBuilder sqlBuilder = new StringBuilder(rootQuery);

        if (queryPractice.conditon() != null && !queryPractice.conditon().isEmpty()) {
            sqlBuilder.append(" WHERE ");
            sqlBuilder.append(queryPractice.conditon());
        }

        List<String> attributes = queryPractice.attributes();
        Map<String, Object> map = queryPractice.values();
        String sql = sqlBuilder.toString();

        if (map != null && !map.isEmpty()) {
            if (attributes != null && !attributes.isEmpty()) {
                for (String attribute : attributes) {
                    Object value = map.get(attribute);
                    if (value != null) {
                        sql = sql.replace(":" + attribute, String.valueOf(value));
                    }
                }
            }
        }

        return sql;
    }
}
