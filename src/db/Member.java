package db;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private String username;
    private String password;
    public Member(String username, String password){
        this.username = username;
        this.password = password;
    }
}