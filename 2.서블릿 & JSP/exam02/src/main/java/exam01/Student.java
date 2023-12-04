package exam01;


public class Student {
    private int id;         // 학번
    private String name;    // 학생명
    private String subject; // 전공명

    @Override
    public boolean equals(Object obj) {
        Student s2 = (Student)obj;
        if (id == s2.id && name.equals(s2.name) && subject.equals(s2.subject)){
            return true;
        }

        return false;
    }

/*    public int hashCode() {
        return Object.hash(id, name, subject);
    }*/

    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }
}
