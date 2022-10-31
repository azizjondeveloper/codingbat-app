package uz.pdp.codingbat.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.service.AttachmentService;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AttachmentControllerImpl implements AttachmentController {

    private final AttachmentService attachmentService;


    @Override
    public ApiResult uploadFileToDB(MultipartHttpServletRequest request) {
       return attachmentService.uploadFileToDB(request);
    }


    @Override
    public ResponseEntity<?> loadById(UUID id, HttpServletResponse response) {
        return attachmentService.loadById(id, response);
    }



    @Override
    public ApiResult uploadFileToFS(MultipartHttpServletRequest request) {
        return attachmentService.uploadFileToFS(request);
    }


    @Override
    public void loadByIdFS(@PathVariable UUID id, HttpServletResponse response) {
        attachmentService.loadByIdFS(id, response);
    }

}
