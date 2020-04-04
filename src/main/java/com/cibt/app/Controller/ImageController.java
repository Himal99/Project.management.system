/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.transaction.Transactional;
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
@RequestMapping(value = "/image")
public class ImageController extends Sitecontroller{

    public ImageController() {
        pageURI="image";
    }
    
    @GetMapping
    public String index(){
        return pageURI+"/index";
    }
    
     public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/img";

     @RequestMapping( "/uploads")
     @ResponseBody
   
    public String upload(Model model,@RequestParam("images") MultipartFile[] images){
         StringBuilder fileNames=new StringBuilder();
         for(MultipartFile file:images){
             Path fileNameAndPath=Paths.get(uploadDirectory,
                     file.getOriginalFilename());
             try {
                 Files.write(fileNameAndPath,file.getBytes());
             } catch (IOException e) {
                 e.printStackTrace();
           
             }
            
         }
          return "success";
    }
     

}
