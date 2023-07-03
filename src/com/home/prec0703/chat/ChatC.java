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

public class ChatC extends JFrame implements KeyListener {
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;

	ChatA chatA;

	public ChatC() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p = new JPanel();
		t = new JTextField(15);

		add(scroll);
		add(p, BorderLayout.SOUTH);
		p.add(t);
		area.setBackground(Color.MAGENTA);

		setBounds(800, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		t.addKeyListener(this); // ChatC is a KeyListener

	}

	public void setChatA(ChatA chatA) {
		this.chatA = chatA;
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("C가 입력중");

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ENTER) { // 엔터키를 쳤을 때
			// 1) 나의 area에 입력값을 출력
			String msg = t.getText();
			area.append(msg + "\n");
			// 2) A의 area에 입력값을 출력
			chatA.area.append(msg + "\n");
			// 3) B의 area에 입력값을 출력
			chatA.chatB.area.append(msg + "\n");
		}

	}

	public static void main(String[] args) {
		new ChatC();
	}

}
