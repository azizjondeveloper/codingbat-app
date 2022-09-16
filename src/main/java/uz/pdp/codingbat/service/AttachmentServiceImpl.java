package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.codingbat.entity.Attachment;
import uz.pdp.codingbat.entity.AttachmentContent;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.repository.AttachmentContentRepository;
import uz.pdp.codingbat.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService{


    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;



    @SneakyThrows
    public ApiResult uploadFileToDB(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();

        while (fileNames.hasNext()) {
            List<MultipartFile> files = request.getFiles(fileNames.next());
            for (MultipartFile file : files) {

                Attachment attachment = new Attachment();
                attachment.setName(file.getOriginalFilename());
                attachment.setSize(file.getSize());
                attachment.setContentType(file.getContentType());
                attachment = attachmentRepository.save(attachment);

                AttachmentContent attachmentContent = new AttachmentContent();
                attachmentContent.setContent(file.getBytes());
                attachmentContent.setAttachment(attachment);
                attachmentContentRepository.save(attachmentContent);
            }
        }

        return null;
    }

    @SneakyThrows
    public ResponseEntity<?> loadById(UUID id, HttpServletResponse response) {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(RuntimeException::new);


        AttachmentContent attachmentContent =
                attachmentContentRepository.findByAttachmentId(attachment.getId()).orElseThrow(RuntimeException::new);


        return ResponseEntity
                .ok()
                .contentType(
                        MediaType.parseMediaType(
                                attachment.getContentType()))
                .contentLength(attachment.getSize())
                .header("Content-disposition","inline; filename=\""+attachment.getName()+"\"")
                .body(attachmentContent.getContent());

    }


    @SneakyThrows
    public ApiResult uploadFileToFS(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();

        while (fileNames.hasNext()) {
            List<MultipartFile> files = request.getFiles(fileNames.next());
            for (MultipartFile file : files) {

                Attachment attachment = new Attachment();
                attachment.setName(file.getOriginalFilename());
                attachment.setSize(file.getSize());
                attachment.setContentType(file.getContentType());
                attachment = attachmentRepository.save(attachment);

                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(
                        "D:\\G8\\"+attachment.getId()+
                                (attachment.getName().substring(attachment.getName().lastIndexOf(".")))
                ));
            }
        }

        return null;
    }

    @SneakyThrows
    public void loadByIdFS(UUID id, HttpServletResponse response) {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(RuntimeException::new);

        response.setContentType(attachment.getContentType());
        response.setContentLength(attachment.getSize().intValue());
        response.setHeader("Content-disposition","inline; filename=\""+attachment.getName()+"\"");

        FileCopyUtils.copy(new FileInputStream("D:\\G8\\"+attachment.getId()+
                        (attachment.getName().substring(attachment.getName().lastIndexOf(".")))),
                response.getOutputStream());
    }

}
