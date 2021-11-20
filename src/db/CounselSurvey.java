package db;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CounselSurvey {
    private Long id;
    private Integer problemNumber;
    private String question;
    private String choices;
}
