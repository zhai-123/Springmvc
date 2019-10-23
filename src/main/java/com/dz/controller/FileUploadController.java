package com.dz.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/file/")
public class FileUploadController {

    @RequestMapping("file")
    public String file(){
        Logger logger = Logger.getLogger(FileUploadController.class);
        //logger.debug("debug message");
        logger.fatal("fatal message");
        return "file/file";
    }

@RequestMapping("upload")
    public String upload(MultipartFile file,String desc){

        System.out.println(file.getContentType());//文件类型
        System.out.println(file.getSize());//文件大小
        System.out.println(file.getName());//input中file的name
        System.out.println(file.getOriginalFilename());//文件本身的名字
        System.out.println(file.getResource());
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            InputStream is = file.getInputStream();
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(new FileOutputStream(new File("d:/ddd/"+file.getOriginalFilename())));
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        bos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            bos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "file/success";

    }
    @RequestMapping("void")
    public String show(String name, HttpServletResponse response) throws Exception {
        System.out.println(name);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("d:/ddd/"+name)));
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

        int len = -1;
        while((len = bis.read())!= -1){
            bos.write(len);
        }

        bis.close();
        bos.flush();
        bos.close();

        return null;

    }
}
