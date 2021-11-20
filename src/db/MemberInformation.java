package db;


import lombok.Getter;
import lombok.Setter;
import signUpPage.signUpPage;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberInformation {
    private Long id;
    private Member member;
    private String name;
    private String nickname;
    private String gender;
    private String email;
    private LocalDateTime registerDate;
    public MemberInformation(String name, String nickname, String email, boolean man, String username, String password){
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        if(man) this.gender = "man";
        else this.gender = "woman";
        member = new Member(username, password);
    }
}
