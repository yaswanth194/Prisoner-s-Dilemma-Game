/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *This class extends PDGame and overrides playRound with strategy
 * stays silent or betrays randomly, with equal probability.
 * @author yaswanth reddy vayalpati
 * ZID:Z1805553
 */
public class RandStrategy extends PDGame{
    /**
     * @param a user's move
     * @return opponent's move
     */
    @Override
    public char playRound(char a){
        if(Math.random()<0.5){
            return 's';
        }
        return 'b';
        
    }
    
}
