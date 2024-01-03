package tables;

import db.IDBConnector;
import db.MySQLConnector;
import objects.Curator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbsTable {
    protected String tableName;
    protected Map<String, String> columns;

    protected IDBConnector db = new MySQLConnector();
    public AbsTable(String tableName) {

        this.tableName = tableName;
    }

    public void create() {
        this.columns = columns;
        String sqlRequest = String.format("CREATE TABLE IF NOT EXISTS %s (%s)",
                this.tableName, convertMapColumnsToString());
        db = new MySQLConnector();
        db.executeRequest(sqlRequest);

    }

    private String convertMapColumnsToString() {
        String result = (String)this.columns.entrySet().stream().map((entry) -> {
            return String.format("%s %s", entry.getKey(), entry.getValue());
        }).collect(Collectors.joining(", "));
        return result;
    }

    protected ArrayList selectAll() {
        db = new MySQLConnector();
        String sqlRequest = String.format("SELECT * FROM %s", this.tableName);
        ResultSet rs = this.db.executeRequestWithAnswer(sqlRequest);

        try {
            int columns = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                for (int i = 1; 1<= columns; i++) {
                    System.out.println( rs.getString(i) + "\t");
                }
                System.out.println();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

        }
        return null;
    }
    public void select(String[] columns, String[] where) {
        db = new MySQLConnector();

        String columnStr = "*";
        if (columns.length > 0) {
            columnStr = String.join(",", columns);

            String whereStr = "*";
            if (columns.length > 0) {
                whereStr = String.join(",", where);

            }
            String sqlQuery = String.format("SELECT %s FROM %s%s", columnStr, tableName, whereStr);
            db.executeRequest(sqlQuery);
        }
    }



    public void delete(int id) {
        db = new MySQLConnector();
        String sqlQuery = String.format("DELETE FROM %s WHERE id = '%d'", tableName, id);
        db.executeRequest(sqlQuery);

    }
    // очистка всей таблицы
    public void delete2() {
        db = new MySQLConnector();
        String sqlQuery = String.format("DELETE FROM %s",tableName);
        db.executeRequest(sqlQuery);

    }

}
