

public class Student {
    private String nameStudent ="";
    private int ID = -1;
    private float score1 = 0.0f;
    private float score2 = 0.0f;
    private float score3 = 0.0f;
    private float score4 = 0.0f;
    private float mediumScore;

    public Student() {
    }

    public Student(String nameStudent, int ID, float score1, float score2, float score3, float score4) {
        this.nameStudent = nameStudent;
        this.ID = ID;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        this.score1 = score1;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        this.score2 = score2;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore3(float score3) {
        this.score3 = score3;
    }

    public float getScore4() {
        return score4;
    }

    public void setScore4(float score4) {
        this.score4 = score4;
    }

    public float getMediumScore(){
        this.setMediumScore();
        return this.mediumScore;
    }

    public void setMediumScore(){
        this.mediumScore = (this.getScore1() + this.getScore2()
                + this.getScore3() * 2 + this.getScore4() * 3) / 7;
    }

    public String getAllInfo(){
        this.setMediumScore();
        return "" + this.getID() +"\t" + this.getNameStudent() + "\t\t "
                + this.getScore1() + "\t |\t" + this.getScore2() + "\t   | \t"
                + this.getScore3() + "\t  |\t" + this.getScore4() + "\t  |\t"
                + this.getMediumScore() + "\n";
    }
}
