package ex0807.overridingExam.goods;

/**
  각 요청에 대한 로직(기능)을 담당할 클래스
  (등록 , 전체검색, 부분검색, 수정, 삭제 등등.....)
*/
public class GoodsService{

	//상품을 관리할 배열 선언
	private Goods[] goodsArr = new Goods[10];
	public static int count; //0 배열방에 저장 객체의 개수

    public GoodsService(String[][] data) {
        for (int i = 0; i < data.length; i++) {
            goodsArr[count++] = create(data[i]);
        }
    }
   /**
      초기치 데이터를 세팅하는 메소드
	  String [][] data = new String [][]{
			 {"A01" , "새우깡" , "2500" , "짜고 맛나다."},  //---> Goods 
			 {"A02" , "고구마깡" , "3500" , "고구맛이고 달다."},  //---> Goods 
			 {"A03" , "감자깡" , "5000" , "감자맛에 고소한맛."}, // ---> Goods 
			 {"A04" , "허니버터칩" , "2200" , "달콤 하다."},
			 {"A05" , "콘칩" , "3000" , "고소하다."}
			 
		};
   */
//   public void init(String [][] data) {
//       for (int i = 0; i < data.length; i++) {
//           goodsArr[count++] = create(data[i]);
//       }
//   }//메소드끝


   /**
      Goods를 생성해서 값을 설정하고 생성된 Goos를 리턴하는 메소드 
   */
   private Goods create(String [] row){//{"A01" , "새우깡" , "2500" , "짜고 맛나다."}
       Goods goods = new Goods(row[0], row[1], Integer.parseInt(row[2]), row[3]);
       return goods;
   }

   /**
     등록(등록실패 - 중복인경우, 배열의 길이 벗어난경우)
	 @return : 
     INSERT_DUPLICATE 상품코드 중복 ,
     INSERT_SUCCESS 등록성공,
     INSERT_OUTINDEX 배열의 길이 벗어남
   */
    public InsertResult insert(Goods goods){
        // 배열의 길이 체크
        if (count == goodsArr.length) return InsertResult.INSERT_OUTINDEX;
        // 중복체크
        Goods searchGoods = this.selectByCode(goods.getCode());
        if (searchGoods != null) return InsertResult.INSERT_DUPLICATE;
        // 등록성공
        goodsArr[count++] = goods;

        return InsertResult.INSERT_SUCCESS; // 성공
    }
    public InsertResult insert2(Goods goods){
        // 배열의 길이 체크
        if (count == goodsArr.length) return InsertResult.INSERT_OUTINDEX;
        // 중복체크
        Goods searchGoods = this.selectByCode(goods.getCode());
        if (searchGoods != null) return InsertResult.INSERT_DUPLICATE;
        // 등록성공
        goodsArr[count++] = goods;

        return InsertResult.INSERT_SUCCESS; // 성공
    }

   /**
     전체검색
   */
   public Goods[] selectAll( ) {
      return goodsArr; // Goods 데이터를 전체 반환
   }

   /**
     상품코드에 해당하는 상품 검색
	 @return : 만약 code에 해당하는 값이 있으면 Goods를 리턴하고
	           없으면 null 리턴
   */
   public Goods selectByCode(String code){
       // Goods에서 해당하는 값 찾기
       for(int i = 0; i < count; i++) {
           if (goodsArr[i].getCode().toUpperCase().equals(code.toUpperCase())) {
               return goodsArr[i];
           }
       }
       // Goods에서 해당하는 값 못찾을 경우 null 리턴
       return null;
   }


   /**
    상품코드에 해당하는 가격, 설명 수정하기 
	@return : true이면 수정완료, false이면 수정실패
   */
    public boolean update(Goods goods){ //수정하려는 코드, 변경값 - 가격, 설명
        Goods searchGoods = this.selectByCode(goods.getCode());

        if (searchGoods == null) return true;

        searchGoods.setPrice(goods.getPrice());
        searchGoods.setExplain(goods.getExplain());

        return false;
   }

    /**
     * 삭제하려는 상품코드에 해당하는 배열의 위치(index) 찾기
     * @param code
     * @return
     */
    public int findLocate(String code) {
        for (int i = 0; i < count ; i++) {
            if(goodsArr[i].getCode().equals(code) ) {
                return i;
            }
        }
        return -1; //못찾았다!
    }

    /**
     * 삭제하려는 상품코드를 입력 받아
     *  - 상품코드에 해당하는 정보를 찾고 있으면 index(번지수)를 받는다.
     *  - index에 해당하는 상품을 배열에서 null바꾼다.
     *  - index 이후부터 앞으로 하나씩 옮긴다.
     *  - count변수의 위치의 배열공간 null 변경하다
     *  - count 감소한다.
     * */
    public int delete(String code) {
        int locate = this.findLocate(code);

        if(locate == -1)return -1;

        goodsArr[locate]=null; //위치를 null로 초기화

        for (int i = locate; i < count-1; i++) { //count = 5  -1 = 4
            goodsArr[i] = goodsArr[i+1];
        }

        goodsArr[--count]=null;

        return 1;
    }


}