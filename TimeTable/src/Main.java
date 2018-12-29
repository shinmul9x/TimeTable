import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String user = "root";
        String pass = "1";
        String db = "TimeTable";
        String url = "jdbc:mysql://127.0.0.2:3306/";

        DbConnection con = new DbConnection(user, pass, db, url);
        //con.insertSemester("hkii 2017-2018");
        ArrayList<Semester> semesters =  con.getSemesters();
        for(Semester semester : semesters) {
            System.out.println(semester.toString());
        }
        ArrayList<Integer> lessions = new ArrayList<Integer>();
        lessions.add(8);
        lessions.add(9);
        lessions.add(10);
        con.insertSubject("the duc", "san bai", 2, lessions, false, semesters.get(0).getName());
        ArrayList<Subject> subjects = con.getSubjects(semesters.get(0).getName());
        for(Subject subject : subjects) {
            System.out.println(subject.toString());
        }
        con.DisconnectDb();
    }
}
