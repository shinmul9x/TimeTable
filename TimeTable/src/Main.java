import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String user = "root";
        String pass = "1";
        String db = "TimeTable";
        String url = "jdbc:mysql://127.0.0.2:3306/";

        DbConnection con = new DbConnection(user, pass, db, url);
        ArrayList<Semester> semesters =  con.getSemesters();
        for(int i = 0; i < semesters.size(); ++i) {
            System.out.println(semesters.get(i).toString());
        }
        ArrayList<Subject> subjects = con.getSubjects(semesters.get(0).getName());
        for(int i = 0; i < subjects.size(); ++i) {
            System.out.println(subjects.get(i).toString());
        }
        con.DisconnectDb();
    }
}
