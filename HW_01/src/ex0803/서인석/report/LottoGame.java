package ex0803.서인석.report;

import java.util.Arrays;

public class LottoGame {
    public static void main(String[] args) {
        /* 생성할 로또 숫자의 갯수 배열과 카운팅 변수 선언 */
        int [] lotto = new int[6];
        int count = 0;

        /* count로 몇 개 번호를 뽑을지 결정
        * Math.random으로 1 ~ 45를 만듬 (형변환으로 double -> int, 1을 안더하면 0 ~ 44 까지임)
        *  */
        while(count < 6) {
            int num = (int) (Math.random() * 45) + 1;

            if (!isDuplicate(lotto, count, num)) {
                lotto[count] = num;
                count++;
            }
        }
        sort(lotto);
        System.out.println("로또 번호 : " + Arrays.toString(lotto));

    }

    /* lotto 배열의 앞 count와 num이 겹치는지 검사하기
     * 인수로 lotto 배열, count 될 수,
     *
     */
    public static boolean isDuplicate(int[] lotto, int count, int num) {

    /*- public: 다른 클래스(여기선 LottoGame의 main)에서도 이 메서드를 호출할 수 있게 공개
    - boolean: 이 메서드는 결과로 true(중복이다) 또는 false(중복 아니다)를 돌려준다는 뜻
    - isDuplicate: 메서드 이름. "중복인가?"를 판단하는 메서드라는 의도
    - 매개변수 3개
    - int[] lotto: 지금까지 뽑힌 로또 번호들이 담긴 배열 (아직 안 뽑힌 칸은 기본값 0)
    - int count: 지금까지 몇 개를 뽑았는지 (배열에서 "유효한 값이 채워진 개수")
    - int num: 방금 새로 뽑은 숫자. 이게 기존 번호들과 겹치는지 검사할 대상
    */
        for(int i = 0; i < count; i++) {
            if (lotto[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static void sort(int[] lotto){
        /* Arrays.sort는 오름차순으로 배열 정렬하는 메서드 */
        Arrays.sort(lotto);
    }
}