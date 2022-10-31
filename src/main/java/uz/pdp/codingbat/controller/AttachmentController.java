package uz.pdp.codingbat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.codingbat.payload.ApiResult;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@RequestMapping("/api/attachment")
public interface AttachmentController {


    @PostMapping("/upload")
    ApiResult uploadFileToDB(MultipartHttpServletRequest request);


    @GetMapping("/load/{id}")
    ResponseEntity<?> loadById(UUID id, HttpServletResponse response);


    @PostMapping("/upload-fs")
    ApiResult uploadFileToFS(MultipartHttpServletRequest request);


    @GetMapping("/load-fs/{id}")
    void loadByIdFS(UUID id, HttpServletResponse response);
}
