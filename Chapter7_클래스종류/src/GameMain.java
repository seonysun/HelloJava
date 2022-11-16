import java.awt.*;
import javax.swing.*;

public class GameMain extends JFrame{
	private GameView gv=new GameView();
	public GameMain() {
		add("Center",gv);
		setSize(1024,900);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GameMain();
		
	}

}
