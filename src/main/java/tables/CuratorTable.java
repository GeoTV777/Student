package tables;

import objects.Curator;
import objects.GroupStudent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CuratorTable extends AbsTable {
    private final static String Table_NAME = "curator";
    public CuratorTable() {
        super(Table_NAME);
        columns = new HashMap<>();
        columns.put("curatorId", "bigint");
        columns.put("curatorFio", "varchar(50)");
        create();
    }

    public ArrayList<Curator> selectAll() {
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }

    private ArrayList<Curator> selectByQuery(String sqlQuery) {
        ArrayList<Curator> curators = new ArrayList<>();
         ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                curators.add(new Curator(
                        rs.getLong("curatorId"),
                        rs.getString("curatorFio")
                ));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return curators;
    }

    public void insertCurator (Curator curator) {
              String sqlQuery = String.format("INSERT INTO %s (curatorId, curatorFio) VALUES ('%d', '%s')",
                tableName, curator.getCuratorID(),curator.getCuratorFio());
        db.executeRequest(sqlQuery);
    }


    public void update(Curator curator) {
             String sqlQuery = String.format("UPDATE %s SET '%d', WHERE curatorId = '%d'",
                tableName, curator.getCuratorID());
        db.executeRequest(sqlQuery);

    }

        public ArrayList<Curator> resultSetToArray(ResultSet rs){
        ArrayList<objects.Curator> result = new ArrayList<>();
            try {
                    while (rs.next()) {

                        result.add(
                        new objects.Curator(
                            rs.getLong("curatorId"),
                            rs.getString("curatorFio")

                        ));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
    }
    return result;

}
    }

