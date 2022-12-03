package com.sist.object;

class Card{
	private int number;
	private String type;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
public class GetClass {

	public static void main(String[] args) {
		Card card1=new Card();
		card1.setNumber(1);
		card1.setType("◆");
		
		System.out.println("Card1.number:"+card1.getNumber());
		System.out.println("Card1.type:"+card1.getType());
		
		try{
			Class clsName=Class.forName("com.sist.object.Card");
				//클래스 이름(경로)으로 클래스객체 참조(메모리 할당)
			Object obj=clsName.getDeclaredConstructor().newInstance();
			
			Card c2=(Card)obj;
		    c2.setNumber(2);
		    c2.setType("♠");
		     
		    System.out.println(c2.getNumber());
		    System.out.println(c2.getType());
		}catch(Exception ex) {}
		
	}

}
