package ex0814.서인석.step08_mvc_template.mvc.exception;

/**
 * 모델번호가 중복되었을때 발생한 예외..
 * */
public class DuplicateModelNoException extends Exception{

	public DuplicateModelNoException() {}
	public DuplicateModelNoException(String message) {
		super(message);
	}
}
