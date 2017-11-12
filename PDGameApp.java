/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author yaswanth reddy vayalpati.ZID:Z1805553
 * PDGame App class implemets Java swing to create GUI for Prisoner's dilemma Game.
 */
public class PDGameApp extends JFrame {
    
        //below ArrayLists store all necessary summary information of each game
        public ArrayList<String> al=new ArrayList<>();
     public ArrayList<String> strategy=new ArrayList<>();
      public ArrayList<Integer> omap=new ArrayList<>();
       public ArrayList<Integer> cmap=new ArrayList<>();
       public ArrayList<Integer> rounds=new ArrayList<>();
        public ArrayList<String> winner=new ArrayList<>();
/**
 * constructor creates a frame with given name.
 * sets it to some size.
 * @param name 
 */
    PDGameApp(String name) {
        super(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        addBody();
    }
    /**
     * Main functions creates an instance of the PDGame App class and sets the frame visible.
     * @param args 
     */

    public static void main(String[] args) {
        PDGameApp main = new PDGameApp("Prisoner's Dilemma");
        main.setVisible(true);

    }
    /**
     * This function add all kinds of components to the Frame created initially.
     */

    public void addBody() {
        JTabbedPane pane = new JTabbedPane();// Adding tabbed pane to the frame.
        JPanel panel1 = new JPanel(true);
        JPanel panel5 = new JPanel(true);
        pane.addTab("Game Play", panel1); //Adding panel "Game Play" to tabbed pane
        pane.addTab("Game List", panel5);  //Adding panel "Game List" to tabbed pane
        add(pane);
        panel1.setLayout(new BorderLayout());
        String a[] = {"From File", "Tit-For-Tat", "Tit-for-Two-Tats", "Tit-for-Tat with forgiveness", "Random"};
        JLabel label1 = new JLabel("Computer Strategy");
        JLabel label2 = new JLabel("Your decision this round?");
        JComboBox comb = new JComboBox(a);     //Adding combo box to select strategies
        JPanel panel2 = new JPanel(true);
        JPanel panel23 = new JPanel(true);
        panel23.setLayout(new BorderLayout());
        panel2.add(label1);
        panel2.add(comb);
        JButton button1 = new JButton("Start New Game");  //Adding button
        panel2.add(button1);
        panel23.add(panel2, BorderLayout.NORTH);
        JPanel panel3 = new JPanel(true);
        panel3.add(label2);
        JButton button2 = new JButton("Stay Silent");  //Adding option buttons
        JButton button3 = new JButton("Betray");
        button2.setEnabled(false);
        button3.setEnabled(false);
        panel3.add(button2);
        panel3.add(button3);
        panel23.add(panel3, BorderLayout.CENTER);
        panel1.add(panel23, BorderLayout.NORTH);
        //JPanel panel4=new JPanel(true);

        JTextArea text = new JTextArea(100, 300);  //Adding a text area
        JScrollPane spane = new JScrollPane(text); //Adding scroll pane to text area
        text.setEditable(true);
        panel1.add(spane, BorderLayout.CENTER);
        //Second Tab is panel 5
        panel5.setLayout(new BorderLayout());
        JList list1 = new JList();   //Adding list to the panel for summary
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel5.add(list1, BorderLayout.LINE_START);


        JPanel panel6 = new JPanel(true);

        JPanel flowPanel=new JPanel();
         flowPanel.setLayout(new BoxLayout(flowPanel,BoxLayout.PAGE_AXIS));
        JLabel label3 = new JLabel("Rounds Played:"); //Adding label for rounds played
        JTextField text1 = new JTextField(10);    // Adding text area for rounds played
        JLabel label4 = new JLabel("Opponent's Strategy:");  //Adding label for opponent's strategy
        JLabel label5 = new JLabel("Your Sentence:");  //Adding label for your sentence
        JLabel label6 = new JLabel("Opponent's Sentence:"); //Adding label for opponent's sentence
        JLabel label7 = new JLabel("Winner:");  //Adding label for winner
        JTextField text2 = new JTextField(10);// Adding text field
        JTextField text3 = new JTextField(10); //Adding text field
        JTextField text4 = new JTextField(10);// Adding text field
        JTextField text5 = new JTextField(10); //Adding text field
//        
        JPanel panelx=new JPanel(true);
        JPanel panely=new JPanel(true);
        JPanel panelz=new JPanel(true);
        JPanel panela=new JPanel(true);
        JPanel panelb=new JPanel(true);
//        flowPanel.add(label3);
//        flowPanel.add(text1);
        panelx.add(label3);
        panelx.add(text1);// Adding a label and text area to each panel
        panely.add(label4);
        panely.add(text2);
        panelz.add(label5);
        panelz.add(text3);
        panela.add(label6);
        panela.add(text4);
        panelb.add(label7);
        panelb.add(text5);
        flowPanel.add(panelx); // Adding all panels to a panel with Box Layout
        flowPanel.add(panely);
        flowPanel.add(panelz);
        flowPanel.add(panela);
        flowPanel.add(panelb);


        
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("src/assignment4/dilemma.png"));
        } catch (IOException e) {
            System.out.println("Image not found");
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

       flowPanel.add(picLabel);  //Adding picture to Game list tab
       panel5.add(flowPanel, BorderLayout.LINE_END);
           /**
            * Listener for Start new game button
            */
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(true);
                  Linking link = new Linking(); //creating an object for linking class
                 text.setText(" ");
               
                link.mainFunction(comb.getSelectedIndex(), text, button2, button3,pane,list1,al,strategy,omap,cmap,winner,rounds,button1);

            }

        });
        /**
         * Listener for List that displays summary of games.
         */
                        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
                if (e.getClickCount() == 2) {
                    text1.setText(rounds.get(list1.getSelectedIndex()).toString());
                    String s = strategy.get(list1.getSelectedIndex());
                    text2.setText(s);
                    text3.setText(omap.get(list1.getSelectedIndex()).toString());
                    text4.setText(cmap.get(list1.getSelectedIndex()).toString());
                    text5.setText(winner.get(list1.getSelectedIndex()));

                }

            }
        });
         

       

    }
}
