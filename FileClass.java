/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *This class extends PDGame class.This class has two methods. One take a file object as
 * parameter and returns an array list with file content. Another one is playRound method.
 * @author yaswanth reddy vayalpati
 * ZID:Z1805553
 */
public class FileClass extends PDGame {
    List<Character> fal=new ArrayList<>();
    public int count=0;
    /**
     * This method take a file object and put contents of the file in a array list.
     * @param temp FileStreamInput object
     */
    public void readFile(FileInputStream temp){
        char c=' ';
        try{
        while(temp.available()>0){
            c=(char)temp.read();
            if(c!=' ')
            {
            if(c!='s'&&c!='b'){
                if(Math.random()<0.5){
            c='s';
                }
                else{
                    c='b';
                }
            }
            fal.add(c);
            }
            
       
        
        }
        }
    
     catch(IOException e) {
         System.out.println(e.getMessage());
     } 
    }
    /**
     * This method implements random strategy
     * @param a user's move
     * @return opponent's move
     */
    @Override
    public char playRound(char a){
        Character res;
        res=fal.get(count);
        count++;
        
        return res ;
    }
        
    
    
}
