package db;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class MemberSchedule {


    private Long id;

    private Member member;


    private String content;


    private LocalDateTime startTime;


    private LocalDateTime endTime;


    private Boolean finish;


    private Interest interest;

    int calScore(String score_per_minute) {
        return Integer.parseInt(Long.toString(ChronoUnit.MINUTES.between(startTime, endTime))) * Integer.parseInt(score_per_minute);
    }
}
