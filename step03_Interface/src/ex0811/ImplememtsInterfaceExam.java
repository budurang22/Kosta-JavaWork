package ex0811;

//이 소스를 컴파일이 되도록 수정/추가/주석처리 하세요.
interface InterfaceExam00 { // 생성 x, 상속 x, implements 이요해서 사용
    abstract void interfaceExam00();
}


interface InterfaceExam01 extends InterfaceExam00 {
    final int i = 767;
    /*protected*/public int k = 999;

    void interfaceExam01(int i, int k);
}


interface InterfaceExam02 {
    int j = 747;
    public int privateInt = 8;

    // public abstract 자동으로 붙어서 private는 없어야함
    void interfaceExam02(int j);
}



class SuperClassExam {
	String superString = "Super";

	String superMethod(){
		System.out.println("SuperClassExam.SuperMethod()가 호출되었습니다.");
		return "returnString";
	}
}

/*abstract*/ class SubClassExam01 extends SuperClassExam implements InterfaceExam01 {// 중복상속 안됨
    // 클래스 사용하려면 상속받은 SuperClassExam InterfaceExam01 메서드 구현
    @Override
    public void interfaceExam01(int i, int k) {

    }

    @Override
    public void interfaceExam00() {

    }
}


// 메소드 재정의 해야함
class SubClassExam02 extends SuperClassExam
				implements InterfaceExam01, InterfaceExam02 {
     @Override
     public void interfaceExam00() {

     }

     @Override
     public void interfaceExam01(int i, int k) {

     }

     @Override
     public void interfaceExam02(int j) {

     }
 }

// superClassExam은 클래스이다 extends 로 상속, 재정의는 클래스 앞에 abstract가 붙어있어서 안해도됨
abstract class SubClassExam03 extends SuperClassExam
			implements InterfaceExam01, InterfaceExam02{}
			

class SubClassExam04 extends SubClassExam02{
	//여기에 필요한 것들을 추가하여 문제를 해결하세요..
	public void interfaceExam00(){}
	public void interfaceExam01(int i, int k){}
	public void interfaceExam02(int j){}

	SubClassExam04(){
		System.out.println("subClassExam04() 객체 생성");
		System.out.println(" i = "+i);
		System.out.println(" j = "+j);
	}
	SubClassExam04(String s1, String s2){
		System.out.println(s1+" 타입 "+"subClassExam04("+s2+") 객체 생성");
		
	}
	void printSuperString(){
        // 인터페이스는 타입으로는 사용가능, 생성은 불가능
		InterfaceExam01 ie01; /*= new InterfaceExam01();*/
		

		System.out.println(" superString = "+superString);
	}
}

//여기서부터는 하나도 고치지 마시고 그대로 쓰면 됩니다.
public class ImplememtsInterfaceExam{ 
	public static void main(String args[]){		
		SubClassExam02 sub02sub04 = new SubClassExam04("SubClassExam02", "sub02sub04");
        SuperClassExam superSub04 = new SubClassExam04("SuperClassExam", "superSub04");
		InterfaceExam01 ifc01Sub04 = new SubClassExam04("InterfaceExam01", "ifc01Sub04");
		SubClassExam04 sub04 = new SubClassExam04();
		sub04.interfaceExam00();
		sub04.interfaceExam01(1,7);
		sub04.superMethod();
	}
}

