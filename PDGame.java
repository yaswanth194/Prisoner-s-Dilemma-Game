/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.io.FileInputStream;
import java.util.Scanner;
import javax.swing.JTextArea;


/**
 *This class implements methods to take input from the user and to display output of each round.
 * This also implements playRound method which is Overrided by subclasses.
 * @author yaswanth reddy vayalpati
 * ZID:Z1805553
 */
public class PDGame {
    public char temp;
    /**
     * This method takes round number as argument and asks user for input.
     * @param j round number
     * @param area4
     * @return user's input
     */
     public void display(int j,JTextArea area4){
        area4.append("Round "+j+": will you stay silent(s) or betray(b)?\n");
    }
     /**
      * This method takes user's and opponent's responses and displays them
      * @param t1 user's response
      * @param t2 opponent's response
     * @param area2
      */
     public void displayRound(char t1,char t2,JTextArea area2){
        String you="silent";
        String comp="silent";
        if(t1=='b'){
            you="betrayed";
        }
        if(t2=='b'){
            comp="betrayed";
        }
        area2.append("\tYou selected: "+you+", opponent selected: "+comp+"\n");
        }
     
        
   
    public char playRound(char a){
        return ' ';
    }
    public char playRound(FileInputStream a){
        
        return ' ';
    }
    
}
