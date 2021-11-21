package db;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Interest {
    private Long id;
    private String subject;
    public Interest(){};
    public Interest(Long id){
        this.id = id;
    }
}
