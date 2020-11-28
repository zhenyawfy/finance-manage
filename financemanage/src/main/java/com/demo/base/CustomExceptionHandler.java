package com.demo.base;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {
        resp.setContentType(ConstantUtils.APPLICATION_TEXT_CONTENTTYPE);
        PrintWriter out = resp.getWriter();
        out.write(ConstantUtils.MAX_UPLOAD_SIZE_EXCEPTION_MSG);
        out.flush();
        out.close();
    }
}
