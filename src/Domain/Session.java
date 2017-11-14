package Domain;

import java.io.Serializable;


public class Session implements Serializable{
   static final long serialVersionUID = -7588980448693010399L;
    protected State state;
    protected String question;
    protected String [] subjectChoices;
    protected String answer = "";
    protected Boolean verdict;
    protected int scoreRond = 0;
    protected int scoreTotal = 0;
    protected String whatSubject = "";
    
    
    public Session (String [] subjectChoices){
        
        this.subjectChoices = subjectChoices;
        verdict = null;
        state = State.WAITING;
        
    }
    
    public State getState(){
        return state;
    }
    
    public Boolean getVerdict(){
        return verdict;
    }
    
    public String getQuestion(){
        return question;
    }
    
    public String getAnswer(){
        return answer;
    }
    public String getwhatSubject(){
        return whatSubject;
    }
    
    public String [] getsubjectChoices(){
        return subjectChoices;
    }
    
    
    
    public void setSubjectChoices(String [] categoryChoies) {
        this.subjectChoices= subjectChoices;
    }
    
    public void setWhatSubject(String subject){
        whatSubject = subject;
    }
    
    public void setState(State s){
        state = s;
    }
    
    public void setVerdict(Boolean b){
        verdict = b;
    }
    
    public void setQuestion(String s){
        question = s;
    }
    
    public void setAnswer(String s){
        answer = s;
    }
    
    public void addScoreRond(){
        scoreRond++;
    }
    public void addScoreTotal(){
        scoreTotal++;
    }
    public void resetScoreRond(){
        scoreRond=0;
    }
}