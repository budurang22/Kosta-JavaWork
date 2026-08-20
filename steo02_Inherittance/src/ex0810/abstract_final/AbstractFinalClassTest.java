package ex0810.abstract_final;//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam { // 상속불가, 생성가능
    final int i = -999999; // 값 변경 불가
}


abstract class AbstractClassExam { // 상속가능, 생성불가
    abstract String abstractMethodExam(int i, String s); // body가 없다. 재정의를 위해 만든다.
    final int finalMethodExam(int i, int j) { // 재정의 불가
        return i + j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
        System.out.println("return " + s + i);
        return s + i;
	}

    // 부모쪽의 final 메소드는 재정의 불가
	/*int finalMethodExam(int i, int j){
		return i*j;
	};*/
}

// final class 상속 불가
/*class Sample02 extends FinalClassExam{  }*/


 
 abstract class Sample03 extends AbstractClassExam{
	 String abstractMethodExam(int i,String s){
         return s + i;
	 }
    // 재정의를 했지만 메소드이름이 같음
	abstract String abstractMethodExam(String s, int i);

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
		// 객체 생성 불가 abstract
        /*AbstractClassExam ace = new AbstractClassExam();*/
		FinalClassExam fce = new FinalClassExam();
		// final 값변경 불가
        /*fce.i = 100000;*/
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
