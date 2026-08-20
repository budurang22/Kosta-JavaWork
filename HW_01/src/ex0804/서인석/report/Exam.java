package ex0804.서인석.report;

/* P200 ~ 201 4, 5, 6, 8번
* 4번 정답 : 2번
* 5번 정답 : 3번 -> boolean 초기값 false
* 6번 정답 :
* - 2차원 배열에서는 array.length는 행의 길이 3
* - array[2].length 은 3행의 열의 길이를 나타냄 5
* 8정 정답
* */

public class Exam {
    public static void main(String[] args) {
        int [][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };
        // 행의 길이 3
        System.out.print(array.length + "\t");
        // 3행의 열의 길이 5
        System.out.println(array[2].length);

        int count = 0;
        int sum = 0;
        double avg;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
                count++;
            }
        }

        avg = (double) sum / count;
        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);


        // 향상된 for문
        count = 0;
        sum = 0;

        for (int[] row : array) {
            for (int col : row) {
                sum += col;
                count++;
            }
        }
        avg = (double) sum / count;
        System.out.printf("총점 : %d, 평균 : %.2f ", sum, avg);


    }
}
