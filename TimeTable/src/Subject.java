public class Subject {
    private String name; //subject
    private String room;
    private int day; // 1 -> 7 <=> sunday -> saturday
    private int firstlession; // 1 -> 12
    private int lastlession; // 1 -> 12
    private boolean isExercise; // true is exercise, false is theory

    public Subject(String name, String room, int day, int lession, boolean isExercise) {
        this.name = name;
        this.room = room;
        this.day = day;
        this.firstlession = lession;
        this.lastlession = lession;
        this.isExercise = isExercise;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public String getRoom() {
        return room;
    }

    public int getFirstlession() {
        return firstlession;
    }

    public int getLastlession() {
        return lastlession;
    }

    public boolean isExercise() {
        return isExercise;
    }

    public void setLession(int lession) {
        if(lession > lastlession) {
            lastlession = lession;
        } else if(lession < firstlession) {
            firstlession = lession;
        }
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setExercise(boolean exercise) {
        isExercise = exercise;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return name + " " + room + " " + day + " " + firstlession + " " + lastlession + " " + isExercise;
    }
}
