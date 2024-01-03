package objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Curator {
    private long curatorId;
    private String curatorFio;

    public Curator(long curatorId, String curatorFio) {
        this.curatorId = curatorId;
        this.curatorFio = curatorFio;
    }

    public long getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(long curatorId) {

        this.curatorId = curatorId;
    }

    public String getCuratorFio() {

        return curatorFio;
    }

    public void setCuratorFio(String curatorFio) {

        this.curatorFio = curatorFio;
    }
    public String toString() {
        return "Curator{" +  "curatorID = " + curatorId +
                " curatorFio " + curatorFio + '}';
    }
    private ArrayList<Curator> resultSetToArray(ResultSet rs){
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
