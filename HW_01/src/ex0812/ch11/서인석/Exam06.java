package ex0812.ch11.서인석;

/*
 * 6. 다음 코드가 실행되었을 때 출력 결과를 작성해보세요
 *  10 -> 숫자로 변환할 수 없음-> 10 -> 인덱스를 초과했음 -> 10
 * */


public class Exam06 {
    public static void main(String[] args) {
        String[] strArray = {"10", "2a"};
        int value = 0;

        for(int i=0; i<=2 ;i++) {
            try {
                value = Integer.parseInt(strArray[i]);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("인덱스를 초과했음");
            } catch(NumberFormatException e) {
                System.out.println("숫자로 변환할 수 없음");
            } finally {
                System.out.println(value);
            }
        }
    }
}
