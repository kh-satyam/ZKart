package zkart.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import zkart.entity.Item;
import zkart.exception.StorageException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {

    @Value("${upload.path}")
    private String path;

    public void uploadFile(MultipartFile file,String fileName) {

        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file");
        }

        try {
            InputStream is = file.getInputStream();
            Path dest=Paths.get(path+fileName);
            Files.copy(is, dest,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {

            String msg = String.format("Failed to store file", file.getName());

            throw new StorageException(msg, e);
        }

    }
}