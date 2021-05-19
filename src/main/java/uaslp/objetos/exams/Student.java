package uaslp.objetos.exams;

import java.util.LinkedList;

public class Student {

    public class Score {
        int partial;
        int grade;

        public Score(int partial,int grade){
            this.partial = partial;
            this.grade = grade;
        }

        public int getGrade(){
            return grade;
        }

        public int getPartial(){
            return partial;
        }
    }

    private String name;
    private int code;
    private LinkedList<Score> score;

    public Student(String name, int id){
        this.name = name;
        this.code = id;
        score = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public void setScore(int partial, int grade)  throws InvalidPartialException{

        if(partial == 0 || partial > 3){
            throw new InvalidPartialException();
        }
        score.add(new Score(partial, grade));
    }

    public double getAverage() throws MissingScoreException{
        double average;
        int sum=0;

        for(int i=0; i < score.size(); i++){

            if(score.get(i).getPartial() == i + 1 ){
                sum += score.get(i).getGrade();
            }else{
                throw new MissingScoreException(score.get(i).getPartial());
            }

        }

        average = sum/score.size();
        return average;
    }
}
