package db;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberCounselResult {
    private Long id;
    private Member member;
    private CounselSolution counselSolution;
    private LocalDateTime counselTime;
}
