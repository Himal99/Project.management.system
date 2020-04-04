/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import com.cibt.app.Entity.Client;
import com.cibt.app.repository.Clientrepository;
import com.mysql.cj.jdbc.Blob;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/clients")
public class Clientcontroller extends Crudcontroller<Client, Integer> {

    @Autowired
    private Clientrepository clientrepository;

    public Clientcontroller() {
        pageTitle = "client";
        pageURI = viewpath = "clients";
    }

    private static Logger log = LoggerFactory.getLogger(Clientcontroller.class);
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/img";

    @PostMapping("/saveEmployee")
    @ResponseBody
    public String createEmployee(Client client,
            final @RequestParam("file") MultipartFile file) {
        try {
            HttpHeaders headers = new HttpHeaders();

            String fileName = file.getOriginalFilename();
            String filePath = Paths.get(uploadDirectory, fileName).toString();
            String fileType = file.getContentType();
            long size = file.getSize();
            String fileSize = String.valueOf(size);
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

            log.info("FileName: " + file.getOriginalFilename());
            log.info("FileType: " + file.getContentType());
            log.info("FileSize: " + file.getSize());

            // Save the file locally
            
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
           
            stream.write(file.getBytes());
            stream.close();

            client.setImage(fileName);

            clientrepository.save(client);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Exception: " + e);

        }
        return "success";
    }

}
