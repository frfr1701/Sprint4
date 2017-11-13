package Domain;

import java.io.Serializable;


public class Session implements Serializable{
    
    protected State state;
    //Sätts initialt av servern
    protected String riddle;
    //SÄtts av klienten
    protected String answer = "";
    protected Boolean verdict;
    
    public Session (String r){
        riddle = r;
        verdict = null;
        state = State.WAITING;
    }
    
    public State getState(){
        return state;
    }
    
    public Boolean getVerdict(){
        return verdict;
    }
    
    public String getRiddle(){
        return riddle;
    }
    
    public String getAnswer(){
        return answer;
    }
    
    public void setState(State s){
        state = s;
    }
    
    public void setVerdict(Boolean b){
        verdict = b;
    }
    
    public void setRiddle(String s){
        riddle = s;
    }
    
    public void setAnswer(String s){
        answer = s;
    }
}