package ex0730.서인석.ch02;

public class StarExam {
    public static void main(String[] args) {
        for(int a=0; a<=5; a++) {
            for(int b=1; b<=a; b++) {
                System.out.print("");
            }
            System.out.println();
        }
        System.out.println("***********************");
        for(int a=5; a>=1; a--) {
            for(int b=0; b<a; b++) {
                System.out.print("⭐");
            }
            System.out.println();
        }
        System.out.println("***********************");
        for(int a=1; a<=5; a++) {
            for(int b=0; b<5-a; b++){
                System.out.print(" ");
            }
            for(int c=0; c<a; c++){
                System.out.print("⭐️");
            }
            System.out.println();
        }
        System.out.println("***********************");
        for(int a=5; a>=1; a--) {
            for(int b=0; b<5-a; b++){
                System.out.print(" ");
            }
            for(int c=0; c<a; c++){
                System.out.print("⭐️");
            }
            System.out.println();
        }
    }
}
