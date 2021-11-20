package db;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ranking {
    private Long id;

    private Member member;


    private Interest interest;


    private int score;
}
