/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *This class extends PDGame and overrides playRound with strategy
 * same as Tit-For-Tat, but occasionally stays silent when it would normally betray
 * @author yaswanth reddy vayalpati
 * ZID:Z1805553
 */
public class TitForTatForgiv extends PDGame{
     public int count=0;
    public char last, temp;
    /**
     * This method overrides playRound from super class
     * @param a user's move
     * @return opponent's move
     */
    @Override
    public char playRound(char a){
        if (count==0){
            temp='s';
            last=a;
        }
        else{
            if(last=='b'){
                if(Math.random()<0.3){
                    temp='s';
                }
            
            else{
            temp =last;
            }
            }
            last=a;
        }
        count++;
        return temp;
        
    }
    
}
