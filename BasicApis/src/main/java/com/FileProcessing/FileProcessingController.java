package com.FileProcessing;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@Slf4j
public class FileProcessingController {
    @Value("${upload_dir}")
    private String upload_dir;
    @Value("${download_dir}")
    private String download_dir;

    @PostMapping("/upload")
    public boolean upload(@RequestParam("file") MultipartFile file) throws IOException {
        file.transferTo(new File(upload_dir + file.getOriginalFilename()));
        log.info("File Uploaded Successfully");
        return true;
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable("fileName") String fileName) throws IOException {
        byte[] fileData = Files.readAllBytes(new File(upload_dir + fileName).toPath());
        Files.write(new File(download_dir, fileName).toPath(), fileData);
        log.info("file downloaded");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(fileData, headers, HttpStatus.OK);
    }

}
