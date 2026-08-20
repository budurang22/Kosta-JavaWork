package ex0803.서인석.report;

class ArrayExam {

    //각 int,double,char,boolean,String type별로 총 5개씩 저장하는 배열을 생성하세요
    int [] intArr = new int[5]; // 0
    double [] doubleArr = new double[5]; // 0.0
    char [] charArr = new char[5]; // \u0000
    boolean [] booleanArr = new boolean[5]; // false
    String [] strArr = new String[5]; // null

    //메소드 : printArrayValue01
    //위의 배열들에 자동으로 초기화 된값을 출력하세요
    public void printArrayValue01() {
        for(int i = 0; i < intArr.length; i++) {
            System.out.println("int [" + i + "] = " + intArr[i]);
        }
        for(int i = 0; i < doubleArr.length; i++) {
            System.out.println("double [" + i + "] = " + doubleArr[i]);
        }
        for(int i = 0; i < charArr.length; i++) {
            System.out.println("char [" + i + "] = " + charArr[i]);
        }
        for(int i = 0; i < booleanArr.length; i++) {
            System.out.println("boolean [" + i + "] = " + booleanArr[i]);
        }
        for(int i = 0; i < strArr.length; i++) {
            System.out.println("String [" + i + "] = " + strArr[i]);
        }
    }

    //메소드 : printArrayValue02
    //위의 5개의 배열에서 각각 적당한 값으로 data를 할당하세요.
    public void printArrayValue02() {
        for (int i = 0; i < this.intArr.length; i++) {
            intArr[i] = (i + 10);
            doubleArr[i] = i * 0.5;
            charArr[i] = (char)('A' + i);
            if(i % 2 == 0) booleanArr[i] = true;
            strArr[i] = "A" + i;
        }

        System.out.println("값 변경 완료하였습니다");
    }

    //메소드 : printArrayValue03
    //새롭게 할당된값을 출력하세요
    public void printArrayValue03() {
        System.out.println("*******변경된 값 확인********");
        this.printArrayValue01();
    }

    //메인메소드에서
    //ArrayExam의 메소드들을 순서대로 호출하세요.
    public static void main(String[] args) {
        ArrayExam arr = new ArrayExam(); // 맴버필드 초기화
        arr.printArrayValue01();
        arr.printArrayValue02();
        System.out.println();
        arr.printArrayValue03();
    }
}