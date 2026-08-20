package ex0813.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListExam03 extends ArrayList<Emp> {
    public ListExam03() {
        // 사원 저장
        super.add(new Emp(10, "이름1", 25, "서울"));
        super.add(new Emp(15, "이름2", 21, "성남"));
        super.add(new Emp(29, "이름3", 27, "광주"));
        super.add(new Emp(32, "이름4", 30, "부산"));
        super.add(new Emp(17, "이름5", 34, "서울"));
    }

    /*
    * 저장된 모든 사원의 정보 검색
    * */
    public List<Emp> selectAll() {
        return this;
    }


    /*
    * 사원의 사원번호에 해당하는 사원정보 검색
    * @return : 있으면 Emp객체, 없으면 null
    * */
    public Emp selectByEmpNo(int empno) {
        for(Emp e : this) {
            if (e.getEmpNo() == empno) {
                return e;
            }
        }
        return null;
    }

    /*
    * 주소를 인수로 전달받아 동일한 주소에 해당하는 사원정보 검색
    * */
    public List<Emp> selectByAddr(String addr) {
        List<Emp> findList = new ArrayList<>();
        for (Emp e : this) {
            if (e.getAddr().equals(addr)) {
                // 찾았을때
                findList.add(e);

            }
        }
        return findList;
    }

    /*
     * 사원번호를 기준으로 사원정보 정렬하기
     * */
    public List<Emp> sortByEmpno() {
        /*
        * All elements in
        * the list must implement the Comparable
        *
        * => Integer는 이미 Comparable 구현한 객체
        * sort를 하기 위한 객체는 반드시 Comparable을 구현한 객체여야한다.
        * */
        // Collections.sort(this); // 원본이 정렬되어서 등록된 순서를 이후로 알 수 없다.

        // 정렬을 해줄 새로운 List를 만들고 그 List를 정렬해서 리턴한다
        List<Emp> shallowCopy = new ArrayList<>(this);
        Collections.sort(shallowCopy);

        return shallowCopy;
    }


    /*
     * 나이를 기준으로 사원정보 정렬하기
     * */
    public List<Emp> sortByAge() {
        List<Emp> shallowCopy = new ArrayList<Emp>(this);
        // Collections.sort(shallowCopy, new Test());

        // 익명 이너타입으로 선언하기
        /*Collections.sort(shallowCopy, new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o2.getAge() - o1.getAge(); // 내림차순
            }
        });*/

        // 람다식으로 구현
        Collections.sort(shallowCopy, (o1, o2) -> o2.getAge() - o1.getAge());

        return shallowCopy;
    }


    public static void main(String[] args) {
        ListExam03 ex = new ListExam03();
        System.out.println("1. 저장된 모든 사원의 정보");
        List<Emp> list = ex.selectAll();
        for(Emp e : list){
            System.out.println(e);
        }
        System.out.println();


        System.out.println("\n2. 사원번호에 해당하는 사원정보");
        Emp emp = ex.selectByEmpNo(32);
        System.out.println(emp);
        /// ////////////////////////////
        /*for(int i = 0; i < list.size(); i++) {
            Emp e = list.get(i);
            System.out.println(e);
        }*/
        System.out.println("\n3. 주소에 해당하는 사원정보 검색");
        List<Emp> findList = ex.selectByAddr("서울");
        System.out.println(findList);

        System.out.println("\n4. 사원번호 기준으로 정렬");
        List<Emp> sortedList = ex.sortByEmpno();
        for(Emp e : sortedList) {
            System.out.println(e);
        }

        System.out.println("\n5. 정렬후 전체검색");
        list = ex.selectAll();
        for(Emp e : list) {
            System.out.println(e);
        }

        System.out.println("\n6. 나이로 정렬 전체 검색");
        sortedList = ex.sortByAge();
        for(Emp e : sortedList) {
            System.out.println(e);
        }

    }
}

/// ///////////////////////////////////////////////////////////////////
class Test implements Comparator<Emp> {

    @Override
    public int compare(Emp o1, Emp o2) {
        return o1.getAge() - o2.getAge(); // 음수 or 0 or 양수
    }
}
