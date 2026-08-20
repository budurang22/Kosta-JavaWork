package ex0729.서인석.report;

public class Report {
    public static void main(String[] args) {
        String name = "학생";
        int eng = (int)(Math.random() * 56 + 45);
        int mat = (int)(Math.random() * 56 + 45);
        int kor = (int)(Math.random() * 56 + 45);
        int total = kor + eng + mat;
        double avg = Math.round(total / 3.0 * 10) / 10.0;

//        if(avg >= 90) grade = 'A';
//        else if (avg >= 80) grade = 'B';
//        else if (avg >= 70) grade = 'C';
//        else if (avg >= 60) grade = 'D';
//        else grade = 'F';

        char grade = switch((int)(avg / 10)) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };

        System.out.println("이름 " + name);
        System.out.println("국어 :" + kor + ", 영어 : " + eng + ", 수학 : " + mat);
        System.out.println("총점 : " + total + ", 평균 : " + avg + ", 학점 : " + grade);
    }
}

