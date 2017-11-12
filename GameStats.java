/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;
import java.util.*;
import javax.swing.JTextArea;

/**
 * @author Yaswanth Reddy vayalpati
 * ZID:Z1805553
 * This class keeps track of user ,opponent  scores and summary of all games
 */
public class GameStats {
    /**
     * @field oscore user's score
     * @field cscore opponent's score
     */
    public int oscore=0;
    public int cscore=0;
    /**
     * This method calculates prison time based on user's and opponent's move. 
     * @param t1 user's move
     * @param t2 opponent's move
     * @param area3
     */
   
    public void totalScore(char t1,char t2,JTextArea area3){
        int oscore1=0;
        int cscore1=0;
        if(t1=='s'&&t2=='b'){
            oscore1+=3;
            
        }
        else if(t1=='s'&&t2=='s'){
            oscore1+=1;
            cscore1+=1;
        }
        else if(t1=='b'&&t2=='b'){
            oscore1+=2;
            cscore1+=2;
        }
        else if(t1=='b'&&t2=='s'){
            cscore1+=3;
        }
        
        oscore+=oscore1;
        cscore+=cscore1;
        area3.append("\tPrison Sentence: You get: "+oscore1+",opponent gets "+cscore1+"years\n");
    }
    /**
     * This method tracks the Summary of all the games played.
     * @param s Opponent's strategy as string
     * @param arr Arraylist with Summary for each time user plays the game
     */
     public void calSummary(String s,ArrayList<String> arr,ArrayList<String>strat,ArrayList<Integer>o,ArrayList<Integer>c,ArrayList<String>win){
        Calendar cal= Calendar.getInstance();
        Date date = cal.getTime();
        arr.add(date.toString());
        strat.add(s);
        o.add((this.oscore));
        c.add((this.cscore));
        if(this.oscore<this.cscore){
         win.add("You Won");
        }
        else if(this.oscore==this.cscore){
             win.add("Tie: No Winner");
        }
        else{
             win.add("You Lost");
        }
    }
    
}
