package tables;

import db.IDBConnector;
import db.MySQLConnector;
import objects.GroupStudent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class AbsTable {
    protected String tableName;
    protected Map<String, String> columns;
    IDBConnector db;

    public AbsTable(String tableName) {

        this.tableName = tableName;
    }

    public void create() {
        this.columns = columns;
        String sqlRequest = String.format("CREATE TABLE IF NOT EXISTS %S (%S)",
                this.tableName, convertMapColumnsToString());
        db = new MySQLConnector();
        db.executeRequest(sqlRequest);
        db.close();
    }

    private String convertMapColumnsToString() {
        String result = (String)this.columns.entrySet().stream().map((entry) -> {
            return String.format("%s %s", entry.getKey(), entry.getValue());
        }).collect(Collectors.joining(", "));
        return result;
    }

    public ArrayList<GroupStudent> selectAll() {
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
            db.close();
        }
        return null;
    }

    public void delete(int id) {
        db = new MySQLConnector();
        String sqlQuery = String.format("DELETE FROM %s WHERE id = '%d'", tableName, id);
        db.executeRequest(sqlQuery);
        db.close();
    }
    // очистка всей таблицы
    public void delete2() {
        db = new MySQLConnector();
        String sqlQuery = String.format("DELETE FROM %s",tableName);
        db.executeRequest(sqlQuery);
        db.close();
    }
}
