package br.com.giovanni.projeto.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path root = Paths.get("uploads");

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public String save(MultipartFile file) {
        try {
           String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

//            String filename = user.getUsername()+System.currentTimeMillis();
//
//            Path root = Paths.get("uploads");
//
//            Files.copy(file.getInputStream(), root);

            String originalFilename = file.getOriginalFilename();

            String fileExtension = "";

            if (originalFilename != null && originalFilename.contains(".")) {
                fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }

            String newFileName = user + UUID.randomUUID() + fileExtension;

            Path filePath = Paths.get("uploads", newFileName).toAbsolutePath();

            File dest = filePath.toFile();

            file.transferTo(dest);

            return newFileName;

        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }

            throw new RuntimeException(e.getMessage());
        }
    }

    public Resource load(String filename) {
        try {
            Path file = Paths.get("uploads", filename).toAbsolutePath();

            final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(file));

            if (inputStream.exists() || inputStream.isReadable()) {
                return inputStream;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
