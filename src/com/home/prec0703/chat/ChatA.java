package com.home.prec0703.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;
	JButton bt;
	
	ChatB chatB;
	ChatC chatC;
	
	public ChatA() {
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p=new JPanel();
		t=new JTextField(15);
		bt=new JButton("start!");
		
		add(scroll);
		add(p, BorderLayout.SOUTH);
		p.add(t);
		p.add(bt);
		bt.setBackground(Color.CYAN);
		area.setBackground(Color.CYAN);
		
		setBounds(200, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this); //ChatA is a ActionListener
		t.addKeyListener(this); //ChatA is a KeyListener
		
	}
	
	public void actionPerformed(ActionEvent e) {
		chatB=new ChatB(); //chatB : B의 레퍼런스변수
		chatB.setChatA(this); 
		
		chatC=new ChatC(); //chatC : C의 레퍼런스변수
		chatC.setChatA(this);
		
	}

	public void keyTyped(KeyEvent e) {		
	}
	public void keyPressed(KeyEvent e) {	
	}
	public void keyReleased(KeyEvent e) {
		System.out.println("A가 입력중");
		
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_ENTER) { //엔터키를 쳤을 때
			//1) 나의 area에 입력값을 출력
			String msg=t.getText();
			area.append(msg+"\n");
			t.setText(""); //입력 후 텍스트필드 초기화
			//2) B의 area에 입력값을 출력
			chatB.area.append(msg+"\n");
			//3) C의 area에 입력값을 출력
			chatC.area.append(msg+"\n");
		}
		
	}

	
	public static void main(String[] args) {
		new ChatA();
	}

}
