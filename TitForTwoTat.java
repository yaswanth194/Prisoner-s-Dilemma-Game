/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *This class extends PDGame and overrides playRound with 
 * strategy stays silent on the first 2 moves, then betrays if the user's last 2 moves were betrayals.
 * @author Yaswanth Reddy Vayalpati
 * ZID:Z1805553
 */
public class TitForTwoTat extends PDGame {
        public int count=0;
        char[] moves=new char[10];
        /**
         * 
         * @param a user's move
         * @return opponent's move
         */
        
         
    @Override
    public char playRound(char a){
       
        char temp;
       
       if((count==0)||(count==1)){
        temp= 's';
    }
       else{
           int last1,last2;
           int tempcount=count;
           last1=tempcount-1;
           last2=tempcount-2;
           if((moves[last2]=='b')&&(moves[last1]=='b')){
               temp= 'b';
           }
           else{
               temp= 's';
           }
       }
       moves[count]=a;
       count++;
       return temp;
    }
    
}
