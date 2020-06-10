package com.robin.fileupload;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/6 9:50
 */
@ControllerAdvice
public class MyCustomException {
/*
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void myException(MaxUploadSizeExceededException e, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("上传文件大小超过了1MB");
        out.flush();
        out.close();
    }
    */

    //直接体现在页面上面
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView myException(MaxUploadSizeExceededException e) throws IOException {
        ModelAndView modelAndView = new ModelAndView("myerror");
        modelAndView.addObject("error", "上传文件大小超出限制！");
        return modelAndView;

    }
}
