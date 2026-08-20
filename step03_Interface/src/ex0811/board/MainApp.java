package ex0811.board;

public class MainApp {
    // 1) 필드를 이용한 다형성
    Board board; // Free or Qa or Upload
    BoardService boardService; // FreeBoardServiceImpl or UploadBoardServiceImpl or QaBoardServiceImpl

    public MainApp() {
        board = new FreeBoard(1, "제목1", "작성자1", "내용1");
        boardService = new FreeBoardServiceImpl();
        this.test(boardService, board);

        board = new QaBoard(1, "제목1", "작성자1", "내용1", false);
        boardService = new QaBoardServiceImpl();
        this.test(boardService, board);

        board = new UploadBoard(1, "제목1", "작성자1", "내용1", "a.jpg");
        boardService = new UploadBoardImpl();
        this.test(boardService, board);

    }

    // 2) 매개변수를 이용한 다형성
    public void test(BoardService service, Board board) {
        service.insert(board);
        service.update(board);
        service.selectByNo(5);

        service.delete(100);
        BoardService.seleteAll();
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
