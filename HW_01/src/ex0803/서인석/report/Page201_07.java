package ex0803.서인석.report;

public class Page201_07 {
    // 7. 주어진 배열 항목에서 최대값을 출력하는 코드를 작성해 보세요
    public static void main(String[] args) {
        /* array의 최대 값 구하기 */
        int [] array = {1, 3, 5, 8, 2 };
        int maxValue = Integer.MIN_VALUE;
        
        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        System.out.println("maxValue = " + maxValue);
    }
}
