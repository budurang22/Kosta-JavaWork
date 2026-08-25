package mvc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

import mvc.dto.Electronics;
import mvc.exception.DuplicateModelNoException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {

    private static ElectronicsService instance = new ElectronicsServiceImpl();
    private static final int MAX_SIZE = 10;
    List<Electronics> list = new ArrayList<>();

    private File file;

    /**
     * 외부에서 객체 생성안됨.
     * InitInfo.properties 파일을 로딩하여
     * List에 추가하여 초기치 데이터를 만든다.
     */
    private ElectronicsServiceImpl() {
        System.out.println("user.dir = " + System.getProperty("user.dir"));
        System.out.println("user.home = " + System.getProperty("user.home"));

        String path = System.getProperty("user.dir") + "/save.txt";
        file = new File(path);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.txt"))) {
                this.list = (List<Electronics>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//InitInfo.properties
            for (String key : rb.keySet()) {
                String value = rb.getString(key);
                String data[] = value.split(",");
                System.out.println(key + " = " + value);

                list.add(new Electronics(Integer.parseInt(data[0]), data[1],
                        Integer.parseInt(data[2]), data[3]));
            }
            System.out.println(list);
        }
    }

    public static ElectronicsService getInstance() {
        return instance;
    }

    @Override
    public void insert(Electronics electronics) throws ElectronicsArrayBoundsException, DuplicateModelNoException {
        if (list.size() >= MAX_SIZE) {
            throw new ElectronicsArrayBoundsException("더 이상 등록 할수 없습니다.");
        }

        try {
            // 모델번호 중복여부 체크
            this.searchByModelNo(electronics.getModelNo());

            throw new DuplicateModelNoException(electronics.getModelNo() + "중복이므로 등록 할 수 없습니다.");
        } catch (SearchNotFoundException e) {
            //예외가 발생했다는 것은 중복이 아니다.
            list.add(electronics);
        }

        /*for(Electronics e : list) {
            if (e.getModelNo() == electronics.getModelNo()) {
                throw new DuplicateModelNoException(electronics.getModelNo() + "모델은 이미 등록된 모델번호 입니다.");
            }
        }
        list.add(electronics);*/
    }

    @Override
    public List<Electronics> selectAll() {

        return list;
    }

    @Override
    public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
        for (Electronics searchModel : list) {
            if (searchModel.getModelNo() == modelNo) {
                return searchModel;
            }
        }
        throw new SearchNotFoundException(modelNo + "모델은 없는 모델번호 입니다.");
    }

    @Override
    public void update(Electronics electronics) throws SearchNotFoundException {
        for (Electronics searchModel : list) {
            if (searchModel.getModelNo() == electronics.getModelNo()) {
                searchModel.setModelDetail(electronics.getModelDetail());
                return;
            }
        }
        throw new SearchNotFoundException(electronics.getModelNo() + "모델은 없는 모델번호 입니다.");
    }

    @Override
    public void delete(int modelNo) throws SearchNotFoundException {
        Iterator<Electronics> it = list.iterator();

        while (it.hasNext()) {
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
        List<Electronics> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList, (a, b) ->
                a.getModelPrice() == b.getModelPrice() ? b.getModelNo() - a.getModelNo() : a.getModelPrice() - b.getModelPrice());

        /*Collections.sort(sortedList, (e1, e2) -> {
            if (e1.getModelPrice() != e2.getModelPrice()) {
                return e1.getModelPrice() - e2.getModelPrice();
            }
            return e1.getModelNo() - e2.getModelNo();
        });*/
        return sortedList;
    }

} // 클래스 끝 