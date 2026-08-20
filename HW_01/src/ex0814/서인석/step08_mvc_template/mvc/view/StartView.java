package ex0814.서인석.step08_mvc_template.mvc.view;
class StartView {
    
    public static void main(String []args) {
        System.out.println("===== 프로그램 시작합니다. =====");

        MenuView mv = new MenuView(); // 전역변수 초기화, 생성자 호출 
        mv.printMenu();

    }
    
}
