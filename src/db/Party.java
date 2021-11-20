package db;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Party {


    private Long id;


    private String name;


    private Interest interest;


    private String goal;


    private Integer maximumNumberOfPeople;


    private Boolean recruit;
}
