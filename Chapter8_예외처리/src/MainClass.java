import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass extends JFrame implements ActionListener {
							  //클래스			//인터페이스(다중상속 가능)
	private JTextArea ta;
	private JTextField tf;
	private JButton b1, b2;
	private int[] com=new int[3];
	private int[] user=new int[3];
	private int s,b;
	public MainClass(){
		ta=new JTextArea();
		JScrollPane js=new JScrollPane(ta);
		tf=new JTextField(10);
		b1=new JButton("Start");
		b2=new JButton("Exit");
		add("Center", js);
		JPanel p=new JPanel();
		p.add(tf);
		p.add(b1);
		p.add(b2);
		add("South",p);
		
		//크기 설정
		setSize(450,420);
		setVisible(true);
		
		//이벤트 등록
		b1.addActionListener(this); //클릭
		tf.addActionListener(this); //엔터
	}
	public void getRand() {
		for(int i=0;i<=3;i++) {
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++) {
				if(com[j]==com[i]) {
					i--;
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		new MainClass();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			getRand();
			JOptionPane.showMessageDialog(this,"게임을 시작합니다.");
		} else if(e.getSource()==tf) {
			String input=tf.getText();
			try {
				int m=Integer.parseInt(input.trim());
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "세자리 정수를 입력하세요.");
				tf.setText("");
				tf.requestFocus();
				return;
			}
		}
		
	}

}
