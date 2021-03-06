/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Controller;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Paulo
 */
@Service
public class FileService {

    //@Value("${app.upload.dir:${user.home}}")
    @Value("${app.upload.dir:/Users/Paulo/NetBeansProjects/FotosSpring/fotos}")
    public String uploadDir;

    public void uploadFile(MultipartFile file, int id) {

        //CRIAR DIRETORIO
        File destFile = new File(uploadDir + File.separator + String.valueOf(id));

        if (!destFile.exists()) {
            if (destFile.mkdir()) {
                System.out.println("Diretório criado no caminho " + String.valueOf(destFile));
            } else {
                System.out.println("Falha ao criar o diretório " + String.valueOf(destFile));
            }
        }

        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + String.valueOf(id) + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }
    }

}
