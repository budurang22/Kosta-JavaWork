package ex0807.overridingExam.goods;

/**
  요청 결과를 출력할 view
*/
public class EndView{
    /**
     성공여부 메시지를 출력하는 메소드
    */
    public static void printMessage(String message){
      System.out.println(message+"\n");
    }

    /**
     전체검색 결과를 출력하는 메소드
    */
    public static void printSelectAll(Goods[] arr){//service에 있는 주소가 전달되었다.
        System.out.println("*** 상품 리스트 (" + GoodsService.count + ") 개 ***");
        for (int i = 0; i < GoodsService.count; i++) {
            System.out.println(arr[i]);
//            System.out.printf("code %s | 상품명 %s | 가격 %d | 설명 %s \n",
//            arr[i].getCode(),
//            arr[i].getName(),
//            arr[i].getPrice(),
//            arr[i].getExplain()
//            );
        }
    }

    /**
     상품코드에 해당하는 상세정보 출력하는 메소드
    */
    public static void printSelectByCode(Goods goods){
        System.out.printf("%s의 상품코드 \n", goods.getCode());
        System.out.println(goods);
//        System.out.printf("%s의 상품이름 \n", goods.getName());
//        System.out.printf("%s의 상품가격 \n", goods.getPrice());
//        System.out.printf("%s의 상품설명 \n", goods.getExplain());
    }


}