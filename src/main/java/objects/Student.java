package objects;

public class Student {
    private long id, groupID;
    private String studentFio, sex;

    public Student(long id, String studentFio, String sex, long groupID) {
        this.id = id;
        this.studentFio = studentFio;
        this.sex = sex;
        this. groupID = groupID;
    }
    public Student(String studentFio, String sex, long groupID) {
        this.id = id;
        this.studentFio = studentFio;
        this.sex = sex;
        this. groupID = groupID;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return studentFio;
    }

    public void setFio(String fio) {
        this.studentFio = fio;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }
    public String toString() {
        return "Student{" + "id =" + id + ", studentFio"
                + studentFio + '\'' + ", sex" + sex + '\''
                + ", groupID =" + groupID + '}';

        }

    }

