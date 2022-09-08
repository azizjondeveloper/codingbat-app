package uz.pdp.codingbat.api;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import uz.pdp.codingbat.payload.AddLanguageDTO;
import uz.pdp.codingbat.utils.RestConstants;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class LanguageControllerAPITest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void addAPITest() throws Exception {
        AddLanguageDTO addLanguageDTO = new AddLanguageDTO("Python");

        ResultActions addLanguageActions = mockMvc
                .perform(post("/api/language")
                .contentType(MediaType.APPLICATION_JSON)
//                .header("Authorization", AuthControllerApiTest.tokenType + " " + AuthControllerApiTest.adminAccessToken)
                .content(Objects.requireNonNull(RestConstants.objectToJSON(addLanguageDTO))));

        addLanguageActions.andExpect(status().isOk());

    }


}
