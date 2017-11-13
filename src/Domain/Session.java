package Domain;

import java.io.Serializable;


public class Session implements Serializable{
    
    protected State state;
    protected String question;
    protected String answer = "";
    protected Boolean verdict;
    protected int scoreRond = 0;
    protected int scoreTotal = 0;
    protected String whatCategory = "";
    
    public Session (String r){
        question = r;
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
    public String getwhatCategory(){
        return whatCategory;
    }
    
    public void setWhatCategory(String subject){
        whatCategory = subject;
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