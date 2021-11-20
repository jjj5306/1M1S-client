package db;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInterest {
    private Long id;
    private Member member;
    private Interest interest;
    private Integer level;
}
