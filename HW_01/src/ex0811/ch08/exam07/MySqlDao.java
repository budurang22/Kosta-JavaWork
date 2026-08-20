package ex0811.ch08.exam07;

public class MySqlDao implements DataAccessObject { // implements된 메서드를 오버라이딩으로 구현
    @Override
    public void select() {
        System.out.println("MySql DB에서 검색");
    }

    @Override
    public void insert() {
        System.out.println("MySql DB에 삽입");
    }

    @Override
    public void update() {
        System.out.println("MySql DB에 수정");
    }

    @Override
    public void delete() {
        System.out.println("MySql DB에 삭제");
    }
}
