package objects;

public class Student {
    private long id, groupId;
    private String studentFio, sex;

    public Student(long id, String studentFio, String sex, long groupId) {
        this.id = id;
        this.studentFio = studentFio;
        this.sex = sex;
        this.groupId = groupId;
    }


//        public Student(String studentFio, String sex, long groupID) {
//        this.studentFio = studentFio;
//        this.sex = sex;
//        this. groupID = groupID;
//    }
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

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
    public String toString() {
        return "Student{" + "id = " + id + ", studentFio "
                + studentFio + '\'' + ", sex " + sex + '\''
                + ", groupId = " + groupId + '}';

        }

    }

