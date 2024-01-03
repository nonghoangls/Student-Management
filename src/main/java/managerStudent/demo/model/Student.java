package managerStudent.demo.model;



public class Student extends Person {

	private String studentCode;
    private String school;
    private int startYear;
    private double averageScore;
    private Rank rank;

    public Student() {
    }

//    public Student(String studentCode, String school, int startYear, double averageScore) {
//        this.studentCode = studentCode;
//        this.school = school;
//        this.startYear = startYear;
//        this.averageScore = averageScore;
//        this.rank = getRank();
//    }


    public Student(String name, String birthDate, String address, float height, float weight, String studentCode, String school, int startYear, double averageScore) {
        super(name, birthDate, address, height, weight);
        this.studentCode = studentCode;
        this.school = school;
        this.startYear = startYear;
        this.averageScore = averageScore;
        this.rank = getRank();
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public double getaverageScore() {
        return averageScore;
    }

    public void setaverageScore(double averageScore) {
        this.averageScore = averageScore;
    }


    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        if (getaverageScore() < 3) {
            this.rank = rank.KEM;
        } else if (getaverageScore() >= 3 && getaverageScore() < 5) {
            this.rank = rank.YEU;
        } else if (getaverageScore() >= 5 && getaverageScore() < 6.5) {
            this.rank = rank.TB;
        } else if (getaverageScore() >= 6.5 && getaverageScore() < 7.5) {
            this.rank = rank.KHA;
        } else if (getaverageScore() >= 7.5 && getaverageScore() < 9) {
            this.rank = rank.GIOI;
        } else if (getaverageScore() >= 9) {
            this.rank = rank.XUAT_SAC;
        }
        return rank;
    }

    @Override
    public String toString() {
        return
                "Id=" + getId() +
                        ", BirthDate=" + getBirthDate() +
                        ", Name=" + getName() +
                        ", Address=" + getAddress() +
                        ", Height=" + getHeight() +
                        ", Weight=" + getWeight() +
                        ", Student code=" + getStudentCode() +
                        ", School=" + school +
                        ", StartYear=" + startYear +
                        ", Average Score=" + averageScore +
                        ", Rank=" + rank;
    }
}
