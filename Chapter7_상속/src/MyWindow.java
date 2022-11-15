import javax.swing.*;

public class MyWindow extends JFrame{ //기존 클래스의 기능을 수정하여 사용하고 싶을 때는 상속으로 받아서 사용
	public MyWindow() {
		setSize(640, 480);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyWindow();
		
	}

}
