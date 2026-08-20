package ex0806.서인석.ch03;

public class ShopService {
    private static ShopService singleton = new ShopService();
    private ShopService() {}
    static ShopService getInstance() {
        return singleton;
    }
}