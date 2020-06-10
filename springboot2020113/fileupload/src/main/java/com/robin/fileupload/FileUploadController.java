package com.robin.fileupload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/6 0:09
 */
@RestController
public class FileUploadController {

    //SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping("/fileUpload")
    public String fileUpload(MultipartFile file, HttpServletRequest request){
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = sdf.format(new Date());

        String realPath = request.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()){
            folder.mkdirs();
        }

        String oldFile = file.getOriginalFilename();
        String newFile = UUID.randomUUID().toString() + oldFile.substring(oldFile.lastIndexOf("."));
        try {
            file.transferTo(new File(folder,newFile));
            String url = request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/img" + format + newFile;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

        @PostMapping("/filesUpload")
        public String filesUpload(MultipartFile[] files, HttpServletRequest request){
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = sdf.format(new Date());

        String realPath = request.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()){
            folder.mkdirs();
        }

        for (MultipartFile file : files){
            String oldFile = file.getOriginalFilename();
            String newFile = UUID.randomUUID().toString() + oldFile.substring(oldFile.lastIndexOf("."));
            try {
                file.transferTo(new File(folder,newFile));
                String url = request.getScheme() + "://" + request.getServerName() + ":"
                        + request.getServerPort() + "/img" + format + newFile;
//                return url;
                System.out.println(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "success";
    }


}
