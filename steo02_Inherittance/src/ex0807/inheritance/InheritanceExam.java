package ex0807.inheritance;

class Car{// Object상 속
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}

//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성
//각 클래스에 인수를 받지않는 생성자 작성
//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당

class Efsonata extends Car {
    int i = 10;

    Efsonata() {
        this.carname = "Efsonata";
        this.cost = 1000000;
    }
}
class Excel extends Car {
    Excel() {
        this.carname = "Excel";
        this.cost = 2000000;
    }
}
class Carnival extends Car {
    Carnival() {
        this.carname = "Carnival";
        this.cost = 2500000;
    }
}
	

public class InheritanceExam{
    //메인메소드에서
    //Car, EfSonata, Excel, Carnival 네개의 객체를 생성
    //각 클래스에서 Car class에있는 printAttributes()메소드를 호출할수있다.
    public static void main(String[] args) {
        Car car = new Car();
        Efsonata efsonata = new Efsonata();
        Excel excel = new Excel();
        Carnival carnival = new Carnival();

        car.printAttributes();
        efsonata.printAttributes();
        excel.printAttributes();
        carnival.printAttributes();

    }
}

