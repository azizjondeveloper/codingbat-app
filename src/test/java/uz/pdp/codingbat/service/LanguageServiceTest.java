package uz.pdp.codingbat.service;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.AddLanguageDTO;
import uz.pdp.codingbat.payload.ApiResult;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LanguageServiceTest {


    @Autowired
    private LanguageService languageService;

    @Test
    public void b() {
        AddLanguageDTO addLanguageDTO = new AddLanguageDTO("JAVA xonim");

        assertThrows(InputDataExistsException.class,
                () -> languageService.add(addLanguageDTO));
    }

    @Test
    public void a() {
        AddLanguageDTO addLanguageDTO = new AddLanguageDTO("JAVA xonim");

        ApiResult apiResult = languageService.add(addLanguageDTO);

        assertTrue(apiResult.isSuccess());
    }


}
