package db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartyMember {
    private Long id;
    private Party party;
    private Member member;
    private String authority;
}
