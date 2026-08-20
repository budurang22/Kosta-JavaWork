package ex0811.ch08.exam07;

/*
* DaoExample 클래스의 main() 메소드에서 dbWork 메소드를 호출할 때 OracleDao, MySqlDao
* 객체를 매개값으로 주고 호출 했습니다. dbWork() 메소드는 두 객체를 모두 매개값으로 받기 위해
* DataAccessObject 타입의 매개변수를 가지고 있습니다. 실행 결과를 보고 DataAccessObject
* 인터페이스와 OracleDao, MySqlDao 구현 클래스를 각각 작성해 보세요.
* */
public class DaoExample {
    public static void dbWork(DataAccessObject dao) { // implements 된 2개의 클래스와 다형성이 이루어짐
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }

    public static void main(String[] args) {
        dbWork(new OracleDao()); // 오버라이딩으로 구현한 메서드 호출
        dbWork(new MySqlDao());
    }
}
