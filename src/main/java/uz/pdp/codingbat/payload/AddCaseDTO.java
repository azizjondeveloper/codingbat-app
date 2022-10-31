package uz.pdp.codingbat.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddCaseDTO {


    private String args;


    private String expected;


    private Integer problemId;
}
