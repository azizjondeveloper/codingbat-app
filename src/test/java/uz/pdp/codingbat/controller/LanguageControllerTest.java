package uz.pdp.codingbat.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uz.pdp.codingbat.payload.AddLanguageDTO;
import uz.pdp.codingbat.payload.ApiResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LanguageControllerTest {
    @Autowired
    private LanguageController languageController;

    @Test
    public void addSuccessTest(){
        AddLanguageDTO addLanguageDTO = new AddLanguageDTO("JAVA");

        ApiResult apiResult = languageController.add(addLanguageDTO);
        assertTrue(apiResult.isSuccess());
    }
}
