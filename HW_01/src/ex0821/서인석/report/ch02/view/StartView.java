package ex0821.서인석.report.ch02.view;

public class StartView {

    public static void main(String[] args) {
        System.out.println("*** 프로그램을 시작합니다. ***");

        MenuView menuview = new MenuView();
        menuview.printmenu();
    }
}
