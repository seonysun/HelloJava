package com.sist.game;
import java.awt.*;
import javax.swing.*;

public class GameView extends JPanel{
	private Image back;
	private Image avata;
	public GameView() {
		back=Toolkit.getDefaultToolkit().getImage("c:\\javadev\\back.gif");
		avata=Toolkit.getDefaultToolkit().getImage("c:\\javadev\\avata.gif");
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(avata, 5, 10, this);
	}
}
