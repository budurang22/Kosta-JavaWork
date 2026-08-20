package ex0807.overridingExam.goods;

public enum InsertResult2 {
    INSERT_DUPLICATE(0, "상품 코드가 중복입니다."),
    INSERT_OUTINDEX(-1, "더 이상 등록할 수 없습니다."),
    INSERT_SUCCESS(1, "상품을 등록했습니다.");

    private final int code;
    private final String message;

    InsertResult2(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
