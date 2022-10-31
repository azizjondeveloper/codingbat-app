package uz.pdp.codingbat.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.codingbat.entity.Problem;

@Getter
@Setter
@NoArgsConstructor
public class CaseDTO {

    private Long id;


    private String args;


    private String expected;


    private Problem problem;
}
