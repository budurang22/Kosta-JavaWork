package ex0807.inheritance;

class CarCenter{
	public void engineer(Car cd){
        System.out.println("cd = " + cd);

        // System.out.println(cd.i); // 부모타입으로는 자식부분 접근 불가
        // 부모타입을 자식타입 변수에 담는다.
        // Efsonata e = cd; // 에러(개념적으로 부모 > 자식)

        // 부모타입을 자식타입으로 ObjectDownCasting
        if (cd instanceof Efsonata) {
            System.out.println("-----------");
            Efsonata e = (Efsonata) cd;
            System.out.println("e = " + e);
            System.out.println("-----------");

            System.out.println(e.i);
        }

		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc = new CarCenter();

        Efsonata ef = new Efsonata();
		Carnival ca = new Carnival();
		Excel ex = new Excel();
		Car c = new Car();


        System.out.println("ef.i = " + ef.i);
		cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		cc.engineer(ex);//
		
		
	
	}
}
