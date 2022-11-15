class Board{
	public void insert() {
		System.out.println("B:게시물 첨부");
	}
	public void list() {
		System.out.println("B:게시물 목록 출력");
	}
	public void update() {
		System.out.println("B:게시물 수정");
	}
}
class ReplyBoard{
	Board board=new Board(); //기존 메소드 수정 없이 그대로 사용할 때는 객체 생성(포함)
	public void reply() {
		System.out.println("R:댓글 올리기");
	}
}
public class 포함 {

	public static void main(String[] args) {
		ReplyBoard rb=new ReplyBoard();
		rb.board.list();
		rb.board.insert();
		rb.board.update();
		rb.reply();

	}

}
