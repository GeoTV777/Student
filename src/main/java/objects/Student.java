package objects;

public class Student {
    private long studentId, groupId;
    private String studentFio, sex;

    public Student(long studentId, String studentFio, String sex, long groupId) {
        this.studentId = studentId;
        this.studentFio = studentFio;
        this.sex = sex;
        this.groupId = groupId;
    }


//        public Student(String studentFio, String sex, long groupID) {
//        this.studentFio = studentFio;
//        this.sex = sex;
//        this. groupID = groupID;
//    }
    public long getStudentId() {

        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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
        return "Student{" + "studentId = " + studentId + ", studentFio "
                + studentFio + '\'' + ", sex " + sex + '\''
                + ", groupId = " + groupId + '}';

        }

    }

