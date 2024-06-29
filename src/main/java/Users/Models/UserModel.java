package Users.Models;

import Users.Models.Enum.UserBankTypeEnum;
import Users.Models.Enum.UserTypeEnum;
import jakarta.persistence.*;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;

    public String name;
    public String email;
    public String phone;
    public String bankType;


    @Enumerated(EnumType.STRING)
    private UserTypeEnum userTypeEnum;
    private UserBankTypeEnum userBankTypeEnum;

    //GETTERS
    public Long getId(){
        return id;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String findByName(){
        return name;
    }

    public String findByEmail(){
        return email;
    }

    public String findByPhone(){
        return phone;
    }

    public UserTypeEnum getUserTypeEnum(){
        return userTypeEnum;
    }

    //SETTERS
    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum){
        this.userTypeEnum = userTypeEnum;
    }

    public void setUserBankTypeEnum(UserBankTypeEnum userBankTypeEnum){
        this.userBankTypeEnum = userBankTypeEnum;
    }



}
