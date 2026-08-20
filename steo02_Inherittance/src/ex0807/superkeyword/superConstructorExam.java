package ex0807.superkeyword;

class Parent {
//    Parent() {
//        System.out.println(1);
//    }

    Parent(int i) {
        System.out.println(2);
    }

    Parent(String s) {
        System.out.println(3);
    }
}
/// //////////////////////////////
class Child extends Parent { // Child is a Parent 성립
    Child() {
        this(2);
        System.out.println(4);
    }
    Child(int i) {
        super(i);
        System.out.println(5);
    }
    Child(boolean b) {
        super("하이");
        System.out.println(6);
    }
}


public class superConstructorExam {
    public static void main(String[] args) {
        // new Child(); // 1, 4
        // new Child(10); // 1, 5

        //결론 : 자식생성자 구현부 첫번째 줄에 super() 생략되엉 있다.
        /// ////////////////////////////////////////////
        //만약 부모의 생성자가 한개도 없다면
        //new Child();
        //new Child(10);
        //new Child(true);

        //결론 : 생성자를 한개도 작성하지 않으면
        // 기본 생성자가 자동으로 삽입되어진다.

        /// ///////////////////////////////////////////
        //부모의 기본생성자는 없고, 인수 있는 생성자가 있는경우
        //=> 자식생성자 구현부 첫번째 줄에서 모두 에러발생
        //=> 반드시 자식색성자 구현부 첫번째 줄에서 super()아닌
        // 다른 생성자를 인위적으로 호춣해야한다.

        new Child();
    }
}
