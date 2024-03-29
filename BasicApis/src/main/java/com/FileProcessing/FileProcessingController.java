package com.FileProcessing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        file.transferTo(new File(upload_dir + file.getOriginalFilename()));
        log.info("File Uploaded Successfully");
        return new ResponseEntity<>("File Uploaded Successfully", HttpStatus.OK);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable("fileName") String fileName) throws IOException {
        byte[] fileData = Files.readAllBytes(new File(upload_dir + fileName).toPath());
        Files.write(new File(download_dir, fileName).toPath(), fileData);
        log.info("file downloaded");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }

    @GetMapping("/downloadtxt/{fileName}")
    public ResponseEntity<String> downloadText(@PathVariable("fileName") String fileName){
        try {
            byte[] fileData = Files.readAllBytes(new File(upload_dir + fileName).toPath());
            Files.write(new File(download_dir, fileName).toPath(), fileData);
            log.info("file downloaded");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_PLAIN);
            return new ResponseEntity<>("file downloaded Successfully ", headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Try Again !! ", HttpStatus.BAD_REQUEST);

    }

    @GetMapping(value = "/downloadpdf/{fileName}")
    public ResponseEntity<InputStreamResource> getTermsConditions(@PathVariable("fileName") String fileName) {
        try {
            String ExtractingOriginalName = fileName.toLowerCase().replaceAll("\\s+","");
            File file = new File(upload_dir + ExtractingOriginalName);
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-disposition", "inline;filename=" + ExtractingOriginalName);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/pdf"))
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

}
