package ex0814.서인석.step08_mvc_template.mvc.service;

import java.util.*;

import ex0814.서인석.step08_mvc_template.mvc.dto.Electronics;
import ex0814.서인석.step08_mvc_template.mvc.exception.DuplicateModelNoException;
import ex0814.서인석.step08_mvc_template.mvc.exception.ElectronicsArrayBoundsException;
import ex0814.서인석.step08_mvc_template.mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE = 10;
    List<Electronics> list = new ArrayList<Electronics>();
    
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
        System.out.println("**private constructor init.....");
        ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//InitInfo.properties
        for(String key : rb.keySet()) {
            String value =  rb.getString(key); //100,\uC120\uD48D\uAE30,35000,\uC0BC\uC131 \uC120\uD48D\uAE30
            String data[] = value.split(",");
            System.out.println(key +" = " + value);

            list.add(new Electronics( Integer.parseInt(data[0]) ,data[1],
            Integer.parseInt( data[2]), data[3]) );
        }
        System.out.println(list);
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) throws ElectronicsArrayBoundsException, DuplicateModelNoException {
        if (list.size() >= MAX_SIZE) {
            throw new ElectronicsArrayBoundsException("배열의 길이를 벗어나 더이상 등록 할수 없습니다.");
        }

        for(Electronics e : list) {
            if (e.getModelNo() == electronics.getModelNo()) {
                throw new DuplicateModelNoException(electronics.getModelNo() + "모델은 이미 등록된 모델번호 입니다.");
            }
        }
        list.add(electronics);
	}

	@Override
	public List<Electronics> selectAll() {

        return list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
        for(Electronics searchModel : list) {
            if (searchModel.getModelNo() == modelNo) {
                return searchModel;
            }
        }
        throw new SearchNotFoundException(modelNo + "모델은 없는 모델번호 입니다.");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
        for(Electronics searchModel : list) {
            if(searchModel.getModelNo() == electronics.getModelNo()) {
                searchModel.setModelDetail(electronics.getModelDetail());
                return;
            }
        }
        throw new SearchNotFoundException(electronics.getModelNo() + "모델은 없는 모델번호 입니다.");
    }

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
        Iterator<Electronics> it = list.iterator();

        while(it.hasNext()) {
            Electronics electronics = it.next();
            if (electronics.getModelNo() == modelNo) {
                it.remove();
                return;
            }
        }
        throw new SearchNotFoundException(modelNo + "모델은 없는 모델번호 입니다.");
		
	}

	@Override
	public List<Electronics> selectSortByPrice() {
        List<Electronics> sortedList = new ArrayList<Electronics>(list);
        Collections.sort(sortedList, (e1, e2) -> {
            if (e1.getModelPrice() != e2.getModelPrice()) {
                return e1.getModelPrice() - e2.getModelPrice();
            }
            return e1.getModelNo() - e2.getModelNo();
        });
        return sortedList;
	}
    
} // 클래스 끝 