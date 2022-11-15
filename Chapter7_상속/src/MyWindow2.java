import javax.swing.*;

public class MyWindow2 {
	JFrame f=new JFrame(); //기존 클래스 자체를 그대로 불러와서 사용하고 싶거나, 기능을 추가하고 싶을 때는 객체를 생성하면 됨
	public MyWindow2() {
		f.setSize(640, 480);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new MyWindow2();

	}

}
