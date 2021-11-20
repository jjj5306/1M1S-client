package db;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterSurvey {
    private Long id;
    private Interest interest;
    private Integer problemNumber;
    private String question;
    private String choices;
}
