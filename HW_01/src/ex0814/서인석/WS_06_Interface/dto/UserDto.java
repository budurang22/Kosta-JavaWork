package ex0814.서인석.WS_06_Interface.dto;
/**
 *  고객의 정보를 관리할 객체 
 * */
public class UserDto {
    private int userSeq;
    private String name;
    private String email;
    private String phone;
    private boolean isSleep;

    public UserDto() {}

    public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
        this.userSeq = userSeq;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isSleep = isSleep;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSleep() {
        return isSleep;
    }

    public void setSleep(boolean sleep) {
        isSleep = sleep;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto ");
        sb.append("userSeq= ").append(userSeq);
        sb.append(", name= ").append(name);
        sb.append(", email= ").append(email);
        sb.append(", phone= ").append(phone);
        sb.append(", isSleep=").append(isSleep);
        return sb.toString();
    }
}
