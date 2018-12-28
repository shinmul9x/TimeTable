import java.sql.*;
import java.util.ArrayList;

public class DbConnection {
    private String user;
    private String pass;
    private String db;
    private String url;
    private Connection connection;

    // index of table Semester
    public static final int semester_name = 2;

    // index of table Subject
    public static final int subject_name = 2;
    public static final int subject_day = 3;
    public static final int subject_lession = 4;

    public DbConnection(String user, String pass, String db, String url) throws SQLException, ClassNotFoundException {
        this.user = user;
        this.pass = pass;
        this.db = db;
        this.url = url;
        connectDb();
    }

    /**
     * Connect database
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void connectDb() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url + db, user, pass);
        System.out.println("Connected");
    }

    /**
     * Disconnect database
     * @throws SQLException
     */
    public void DisconnectDb() throws SQLException {
        if(connection.isClosed()) {
            connection.close();
        }
        System.out.println("Disconnected");
    }

    /**
     * Get list of semesters from database
     * @return list of objects semester
     */
    public ArrayList<Semester> getSemesters() {
        ArrayList<Semester> semesters = new ArrayList<Semester>();
        String query = "SELECT * FROM semester";
        try {
            ResultSet result = connection.prepareStatement(query).executeQuery();
            while (result.next()) {
                //int id = result.getInt(semester_id);
                String name = result.getString(semester_name);
                semesters.add(new Semester(name));
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("ERROR getSemesters");
        }
        return semesters;
    }

    /**
     * Insert semester into database
     * After calling insertSemester, need to call function getSemesters()
     * @param semesterName semester's name
     */
    public void insertSemester(String semesterName) {
        String query = "INSERT INTO semesmer(semester_name) VALUE(?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, semesterName);
            statement.execute();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("ERROR setSemester");
        }
    }

    /**
     * Update semester
     * @param semesterName
     * @param newName
     */
    public boolean updateSemester(String semesterName, String newName) {
        //TODO:
        return false;
    }

    /**
     * Delete semester
     * @param semesterName
     * @return
     */
    public boolean deleteSemester(int semesterName) {
        //TODO:
        return false;
    }

    /**
     * Get list of subjects from database
     * @return list of subject object(subject, day, lession)
     */
    public ArrayList<Subject> getSubjects(String semester) {
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        String query = "SELECT * FROM subject s JOIN semester se ON s.semester_id = se.semester_id WHERE se.semester_name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, semester);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString(subject_name);
                String room = "";
                int day = result.getInt(subject_day);
                int lession = result.getInt(subject_lession);
                boolean isExercise = false;

                boolean isExists = false;
                for (Subject subject : subjects) {
                    if (subject.getName().equals(name)) {
                        subject.setLession(lession);
                        isExists = true;
                        break;
                    }
                }
                if (!isExists) {
                    subjects.add(new Subject(name, room, day, lession, isExercise));
                }
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("ERROR getSubjects");
        }
        return subjects;
    }

    /**
     * Insert subject into database
     * After calling insertSubject, need to call getSubjects()
     * @param name
     * @param room
     * @param day
     * @param lession
     * @param isExercise
     */
    public void insertSubject(String name, String room, int day, ArrayList<Integer> lession, boolean isExercise) {
        //TODO:
    }

    /**
     * Update subject's name by day and lession
     * @param day
     * @param lession
     * @param newName
     * @return
     */
    public boolean updateSubject(int day, int lession, String newName) {
        //TODO:
        return false;
    }

    /**
     * Update subject's name by day and lession
     * @param day
     * @param lession
     * @param newName
     * @param isExercise
     * @return
     */
    public boolean updateSubject(int day, int lession, String newName, boolean isExercise) {
        //TODO:
        return false;
    }

    /**
     * Update subject's status by day and lession
     * @param day
     * @param lession
     * @param isExercise subject's status (theory or exercise
     * @return
     */
    public boolean updateSubject(int day, int lession, boolean isExercise) {
        //TODO:
        return false;
    }

    /**
     * Update subject by day and lession
     * @param day
     * @param lession
     * @param newName
     * @param newRoom
     * @param isExercise
     * @return
     */
    public boolean updateSubject(int day, int lession, String newName, String newRoom, boolean isExercise) {
        //TODO:
        return false;
    }

    /**
     * Update subject's room
     * @param name
     * @param newRoom
     * @return
     */
    public boolean updateSubject(String name, String newRoom) {
        //TODO:
        return false;
    }

    /**
     * Update subject's room
     * @param name
     * @param isExercise
     * @return
     */
    public boolean updateSubject(String name, boolean isExercise) {
        //TODO:
        return false;
    }

    /**
     * Delete subject by day and lession
     * @param day
     * @param lession
     * @return
     */
    public boolean deleteSubject(int day, int lession) {
        //TODO:
        return false;
    }

    /**
     * Delete subject by name
     * @param subjectName
     * @return
     */
    public boolean deleteSubject(String subjectName, boolean isExercise) {
        //TODO:
        return false;
    }
}
