package com.csulb.board;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class GameBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
            GameBoard gb= new GameBoard();
            
           // TODO Auto-generated method stub
        }
        private JPanel panelPlayer1 = new JPanel();
        private String globalSelectedRoom= "";
        private JButton moveButton = new JButton("Move");
        public GameBoard()    
        {	JFrame frame = new JFrame();
		
        
        JPanel panelPlayer2 = new JPanel();
        JPanel panelPlayer3 = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel upperPanel = new JPanel();
        JPanel bottomPanel= new JPanel();
        JPanel panelCard = new JPanel();
        JLabel cardsCount = new JLabel("Cards in Deck: ");
        JLabel cardsCountValue = new JLabel("35");
        JLabel discardsCount = new JLabel("Discards out of play: ");
        JLabel discardsCountValue = new JLabel("0");
        JLabel currentState = new JLabel("You are PD and you are in ECS 308");
        
        JTextField notes= new JTextField("PD is human player",6); 
        
        JButton cardButton = new JButton("Draw Card");
        
        JButton playButton = new JButton("Play Card");
        
        JLabel playerOneLabel = new JLabel("PD");
        playerOneLabel.setForeground(Color.red);
        Font f = new Font("arial", Font.BOLD, 50);
        playerOneLabel.setFont(f);
        
        JLabel playerTwoLabel = new JLabel("Rohit");
        playerTwoLabel.setForeground(Color.blue);
        playerTwoLabel.setFont(f);
        
        JLabel playerThreeLabel = new JLabel("Parin");
        playerThreeLabel.setForeground(Color.yellow);
        playerThreeLabel.setFont(f);
        
        ImageIcon mapImage = new ImageIcon("D:\\piyush code\\Software Engineering\\src\\CSULBMap3.png");
        JLabel mapLabel = new JLabel(mapImage);
        
        List movesList = new List();
        movesList.add("Brautman Hall");
        movesList.add("ECS 302");
        movesList.addActionListener(new SelectMoveListner());
        ImageIcon bottomImage = new ImageIcon("D:\\piyush code\\Software Engineering\\src\\Background.png");
        JLabel bottomLabel = new JLabel(bottomImage);
        
        ImageIcon imageCard = new ImageIcon("D:\\piyush code\\Software Engineering\\src\\Dummy_Card.png");
        JLabel labelCard = new JLabel(imageCard);
        
        JTable scoreTable= new JTable(4, 5);
       // mapLabel.setLocation(0, 0);
        frame.add(upperPanel);
        frame.add(bottomPanel);
        //buttonPanel.setLocation(0, 500);
        
        //buttonPanel.repaint();
        //frame.add(buttonPanel);
        //buttonPanel.setBounds(0, 500, 100, 600);
        
        
        cardButton.setOpaque(false);
        cardButton.setBounds(10, 10, 110, 33);
        bottomLabel.add(cardButton);
        
        moveButton.setOpaque(false);
        moveButton.setBounds(10, 47, 110, 33);
        moveButton.setEnabled(false);
        moveButton.addActionListener(new MoveButtonListner());
        bottomLabel.add(moveButton);
        
        playButton.setOpaque(false);
        playButton.setBounds(10, 85, 110, 33);
        bottomLabel.add(playButton);
        
        labelCard.setOpaque(false);
        labelCard.setBounds(190,10,320,280);
        bottomLabel.add(labelCard);
        
        movesList.setBounds(10, 130, 170, 100);
        bottomLabel.add(movesList);
        
        //scoreTable.setOpaque(false);
        scoreTable.setBounds(500, 10, 500, 500);
        scoreTable.setOpaque(false);
        scoreTable.setGridColor(Color.black);
        scoreTable.setBackground(Color.gray);
        bottomLabel.add(scoreTable);
        
        cardsCount.setOpaque(false);
        cardsCount.setBounds(500, 100, 100, 10);
        bottomLabel.add(cardsCount);
        cardsCountValue.setOpaque(false);
        cardsCountValue.setBounds(590, 100, 40, 10);
        bottomLabel.add(cardsCountValue);
        
        discardsCount.setOpaque(false);
        discardsCount.setBounds(700, 100, 120, 10);
        bottomLabel.add(discardsCount);
        discardsCountValue.setOpaque(false);
        discardsCountValue.setBounds(820, 100, 40, 10);
        bottomLabel.add(discardsCountValue);
        
        currentState.setOpaque(false);
        currentState.setBounds(500, 120, 500, 10);
        bottomLabel.add(currentState);
        
        notes.setOpaque(false);
        notes.setBounds(500, 150, 500, 50);
        bottomLabel.add(notes);
        
        upperPanel.add(mapLabel);
        bottomPanel.add(bottomLabel);
        mapLabel.add(panelPlayer1);
        
        panelPlayer1.setOpaque(false);
        panelPlayer1.setBounds(300,1800,1900, 1320);
        panelPlayer1.add(playerOneLabel);
        
        mapLabel.add(panelPlayer2);
        panelPlayer2.setOpaque(false);
        panelPlayer2.setBounds(0,1370,1750, 1370);
        panelPlayer2.add(playerTwoLabel);
       
        mapLabel.add(panelPlayer3);
        panelPlayer3.setOpaque(false);
        panelPlayer3.setBounds(0,1420,1750, 1420);
        panelPlayer3.add(playerThreeLabel);
        
        JScrollPane scrollPane = new JScrollPane(upperPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 1360, 500);
        
        JScrollPane scrollPane2 = new JScrollPane(bottomPanel);
        scrollPane2.setBounds(0, 500, 1360, 800);
        
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1900, 1080));
        contentPane.add(scrollPane);
        contentPane.add(scrollPane2);
        
        
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        
	}
        class SelectMoveListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           globalSelectedRoom=e.getActionCommand().toString();
            System.out.println("Selcted room: "+globalSelectedRoom); 
           
            moveButton.setEnabled(true);
        }
         
        
            
        }
        
        class MoveButtonListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) { 
           
           if(globalSelectedRoom.equalsIgnoreCase("ECS 302")){
            System.out.println("inside ECS 302 room");
               panelPlayer1.setBounds(0,1000,1750,1000);
               panelPlayer1.repaint();
           }
           moveButton.setEnabled(false);
        }
         
        
            
        }
}
