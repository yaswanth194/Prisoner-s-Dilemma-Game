 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * Linking is the class with  method where objects for different strategy classes
 * are created.
 *This acts as controller class.
 * @author yaswanth reddy vayalpati ZID:Z1805553
 */
public class Linking {

    /**
     * This the main method where objects for different classes are created.
     *
     * This method based on the selected index from the combo box initiates a game with a strategy
     */
    public ArrayList<String> al=new ArrayList<>();
     public ArrayList<String> strategy=new ArrayList<>();
      public ArrayList<Integer> omap=new ArrayList<>();
       public ArrayList<Integer> cmap=new ArrayList<>();
        public ArrayList<String> winner=new ArrayList<>();
    public void mainFunction(int x, JTextArea area, JButton button2, JButton button3,JTabbedPane pane,JList list,ArrayList<String>al1,ArrayList<String>strategy1,ArrayList<Integer>omap1,ArrayList<Integer>cmap1,ArrayList<String>winner1,ArrayList<Integer>round,JButton button1) {
        
        int min = 5;
        int max = 10;
        int n = min + (int) (Math.random() * ((max - min) + 1)); //generating random numbers
        round.add(n);
        b = 1;
        switch (x) {
            //Case for strategy with file
            case 0:
                FileClass f1 = new FileClass();
                GameStats g1 = new GameStats();
                area.append("Starting Game with strategy: From File\n");
                JFileChooser fileChooser = new JFileChooser(); //File chooser dialog box
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(area);
                if (result == JFileChooser.APPROVE_OPTION) {    //checks if afile is chosen or not
                    File selectedFile = fileChooser.getSelectedFile();
                      FileInputStream in = null;
                try {
                    in = new FileInputStream(fileChooser.getSelectedFile()); //Checks which file exists 
                } catch (FileNotFoundException g) {
                    System.out.println("File Doesn't Exist");
                    break;
                }
                
                    
                     f1.readFile(in);
                     
                area.append("Round :" + b + "  will you stay silent(s) or betray(b)?\n");

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            char temp = f1.playRound('s'); //call for play round function
                            f1.displayRound('s',temp,area); //call for display round function
                            g1.totalScore('s', temp, area);

                            incrementNum();
                            if(b<=n){
                            f1.display(b, area);
                            }
                            else{
                                area.append("\tGame Over:  You got "+g1.oscore+", your opponent got "+g1.cscore+" years in prison\n");
                                g1.calSummary("From File", al,strategy,omap,cmap,winner);  //Call for calSummary function
                                al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                            }
                        }
                    }
                });
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            
                            char temp = f1.playRound('b');
                            f1.displayRound('b',temp,area);
                            g1.totalScore('b', temp, area);
                            incrementNum();
                            if(b<=n){
                            f1.display(b, area);
                            }
                            else{
                               area.append("\tGame Over:  You got "+g1.oscore+", your opponent got "+g1.cscore+" years in prison\n");
                                g1.calSummary("From File", al,strategy,omap,cmap,winner);
                               al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                               
                            }
                        }
                    }
                });
              
                }
                break;
                
            case 1:
                // case for strategy Tit for Tat
                TitForTat obj = new TitForTat();
                GameStats obj1 = new GameStats();

                area.append("Starting Game with strategy: Tit-For-Tat\n");

                area.append("Round :" + b + "  will you stay silent(s) or betray(b)?\n");
                
                //Listener for Stay silent button

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            char temp = obj.playRound('s');
                            obj.displayRound('s',temp,area);
                            obj1.totalScore('s', temp, area);

                            incrementNum();
                            if(b<=n){
                            obj.display(b, area);
                            }
                            else{
                                area.append("\tGame Over:  You got "+obj1.oscore+", your opponent got "+obj1.cscore+" years in prison\n");
                                obj1.calSummary("Tit-For-Tat", al,strategy,omap,cmap,winner);
                                al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                            }
                        }
                    }
                });
                //Listener for betray button
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            
                            char temp = obj.playRound('b');
                            obj.displayRound('b',temp,area);
                            obj1.totalScore('b', temp, area);
                            incrementNum();
                            if(b<=n){
                            obj.display(b, area);
                            }
                            else{
                               area.append("\tGame Over:  You got "+obj1.oscore+", your opponent got "+obj1.cscore+" years in prison\n");
                               obj1.calSummary("Tit-For-Tat", al,strategy,omap,cmap,winner);
                               al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                            }
                        }
                    }
                });

                break;
            case 2:
                //Case for strategy tit for two tats
                      TitForTwoTat case21 = new TitForTwoTat();
                GameStats case22 = new GameStats();

                area.append("Starting Game with strategy: Tit-For-Two-Tat\n");

                area.append("Round :" + b + "  will you stay silent(s) or betray(b)?\n");
                
                //Listener for Stay silent

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            char temp = case21.playRound('s');
                            case21.displayRound('s',temp,area);
                            case22.totalScore('s', temp, area);

                            incrementNum();
                            if(b<=n){
                            case21.display(b, area);
                            }
                            else{
                                area.append("\tGame Over:  You got "+case22.oscore+", your opponent got "+case22.cscore+" years in prison\n");
                                case22.calSummary("Tit-For-Two-Tats", al,strategy,omap,cmap,winner);
                                al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                            }
                        }
                    }
                });
                //Listener for betray button
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            char temp = case21.playRound('b');
                            case21.displayRound('b',temp,area);
                            case22.totalScore('b', temp, area);
                            incrementNum();
                            if(b<=n){
                            case21.display(b, area);
                            }
                            else{
                               area.append("\tGame Over:  You got "+case22.oscore+", your opponent got "+case22.cscore+" years in prison\n");
                               case22.calSummary("Tit-For-Two-Tats", al,strategy,omap,cmap,winner);
                               al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                            }
                        }
                    }
                });
         
                break;
               
            case 3:
                //Case for strategy Tit for Tat with forgiveness
                TitForTatForgiv case31 = new TitForTatForgiv();
                GameStats case32 = new GameStats();
                        area.append("Starting Game with strategy: Tit-For-Tat-With Forgiveness\n");

                area.append("Round :" + b + "  will you stay silent(s) or betray(b)?\n");
                
                //Listener for Stay silent button

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            char temp = case31.playRound('s');
                            case31.displayRound('s',temp,area);
                            case32.totalScore('s', temp, area);

                            incrementNum();
                            if(b<=n){
                            case31.display(b, area);
                            }
                            else{
                                area.append("\tGame Over:  You got "+case32.oscore+", your opponent got "+case32.cscore+" years in prison\n");
                                case32.calSummary("Tit-For-Tat-With Forgiveness", al,strategy,omap,cmap,winner);
                                al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                            }
                        }
                    }
                });
                //Listener for betray button
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            
                            char temp = case31.playRound('b');
                            case31.displayRound('b',temp,area);
                            case32.totalScore('b', temp, area);
                            incrementNum();
                            if(b<=n){
                            case31.display(b, area);
                            }
                            else{
                               area.append("\tGame Over:  You got "+case32.oscore+", your opponent got "+case32.cscore+" years in prison\n");
                               case32.calSummary("Tit-For-Tat-With Forgiveness", al,strategy,omap,cmap,winner);
                               al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                            }
                        }
                    }
                });
             
                 break;
                 
           case 4:
               //Case for strategy Random
               RandStrategy case41=new RandStrategy();
               GameStats case42=new GameStats();
                  area.append("Starting Game with strategy: Random\n");

                area.append("Round :" + b + "  will you stay silent(s) or betray(b)?\n");
                
                //Listener for stay silent button

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            char temp = case41.playRound('s');
                            case41.displayRound('s',temp,area);
                            case42.totalScore('s', temp, area);

                            incrementNum();
                            if(b<=n){
                            case41.display(b, area);
                            }
                            else{
                                area.append("\tGame Over:  You got "+case42.oscore+", your opponent got "+case42.cscore+" years in prison\n");
                                case42.calSummary("Random", al,strategy,omap,cmap,winner);
                                al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                            }
                        }
                    }
                });
                //Listener for betray button
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b <= n) {
                            
                            char temp = case41.playRound('b');
                            case41.displayRound('b',temp,area);
                            case42.totalScore('b', temp, area);
                            incrementNum();
                            if(b<=n){
                            case41.display(b, area);
                            }
                            else{
                               area.append("\tGame Over:  You got "+case42.oscore+", your opponent got "+case42.cscore+" years in prison\n");
                               case42.calSummary("Random", al,strategy,omap,cmap,winner);
                               al1.addAll(al);
                               strategy1.addAll(strategy);
                               omap1.addAll(omap);
                               cmap1.addAll(cmap);
                               winner1.addAll(winner);
                               list.setListData(al1.toArray());
                               button1.setEnabled(true);
                               button2.setEnabled(false);
                               button3.setEnabled(false);
                            }
                        }
                    }
                });
             
        break;      
                

        }
        
       

    }
     

    public void incrementNum() {
        this.b += 1;
    }
    public List<String> sendList(){
        return al;
    }
    public ArrayList<String> sendStrategy(){
        return strategy;
    }
    public List<Integer> sendOscore(){
        return omap;
    }
    public List<Integer> sendCmap(){
        return cmap;
    }
    public List<String> sendWinner(){
        return winner;
    }
    int b = 1;
}
