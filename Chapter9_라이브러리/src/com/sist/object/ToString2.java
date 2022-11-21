package com.sist.object;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ToString2 extends JFrame implements ItemListener{
	JComboBox box=new JComboBox();
	JLabel la=new JLabel();
	public ToString2() {
		box.addItem("my_00.png");
		box.addItem("my_01.png");
		box.addItem("my_02.png");
		box.addItem("my_03.png");
		box.addItem("my_04.png");
		box.addItem("my_05.png");
		
		add("North",box);
		add("Center",la);
		setSize(350,450);
		setVisible(true);

		box.addItemListener(this);
	}
	public static void main(String[] args) {
		new ToString2();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==box) {
			String image=box.getSelectedItem().toString();
			la.setIcon(new ImageIcon("c:\\javadev\\image"+image));
		}

	}

}	