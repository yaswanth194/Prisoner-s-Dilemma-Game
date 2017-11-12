/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *This class extends PDGame class and overrides playRound method with it's strategy
 * @author yaswanth reddy vayalpati
 * ZID:Z1805553
 */
public class TitForTat extends PDGame{
    public int count=0;
    public char last, temp;
    /**
     * 
     * @param a This is user's move
     * @return opponent's move
     */
    @Override
    public char playRound(char a){
        if (count==0){
            temp='s';
            last=a;
        }
        else{
            temp =last;
            last=a;
        }
        count++;
        return temp;
        
    }
    
}
