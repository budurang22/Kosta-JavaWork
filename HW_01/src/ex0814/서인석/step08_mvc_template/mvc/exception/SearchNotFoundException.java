package ex0814.서인석.step08_mvc_template.mvc.exception;

/**
 * 검색 결과가 존재하지 않을때 처리 할 예외 클래스 
 * */
public class SearchNotFoundException extends Exception {
	public SearchNotFoundException() {}
	public SearchNotFoundException(String message) {
		super(message);
	}

}
