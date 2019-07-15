/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt1;

/**
 *
 * @author max
 */
public class ScoreObserver implements Observer{
    Score score;
    public ScoreObserver(Score score){
        this.score=score;
    };
    
    @Override
    public void notify(String param) {
        if (param.equals("score+1")) {
            score.incScoreValue(1);
        };        
    }
    
}
