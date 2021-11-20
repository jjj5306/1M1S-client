package db;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCurriculum {
    private Long id;
    private Member member;
    private Curriculum curriculum;
}
