package uz.pdp.codingbat.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.codingbat.payload.ApiResult;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public interface AttachmentService {

    ApiResult uploadFileToDB(MultipartHttpServletRequest request);



    ResponseEntity<?> loadById(UUID id, HttpServletResponse response);


    ApiResult uploadFileToFS(MultipartHttpServletRequest request);


    void loadByIdFS(UUID id, HttpServletResponse response);

}
