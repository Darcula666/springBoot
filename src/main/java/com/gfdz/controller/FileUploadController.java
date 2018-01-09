package com.gfdz.controller;


import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by Administrator on 2017/4/14.
 */
@RequestMapping("/fileUpload")
@RestController
public class FileUploadController {
    /**
     * 文件上传初始页面
     *
     * @param
     * @return
     * @Valid:验证
     */
    @GetMapping("/file")
    public ModelAndView index() {
        return new ModelAndView("file");
    }
    //处理文件上传
    @RequestMapping(value="/testuploadimg")
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String chunk; // 当前第几个分片
        String chunks;// 总分片个数
        String size;// 单个文件的总大小
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            uploadFile(file.getBytes(), filePath, fileName);
            //randomAccessFile(filePath, (File) file);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return "uploadimg success";
    }
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
    /**
     * 指定位置开始写入文件
     * @param tempFile  输入文件
     * @param outPath  输出文件的路径(路径+文件名)
     * @throws IOException
     */
    public static void randomAccessFile( String outPath,File tempFile) throws IOException {
        RandomAccessFile raFile = null;
        BufferedInputStream inputStream=null;
        try{
            File dirFile = new File(outPath);
            //以读写的方式打开目标文件
            raFile = new RandomAccessFile(dirFile, "rw");
            raFile.seek(raFile.length());
            inputStream = new BufferedInputStream(new FileInputStream(tempFile));
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buf)) != -1) {
                raFile.write(buf, 0, length);
            }
        }catch(Exception e){
            throw new IOException(e.getMessage());
        }finally{
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (raFile != null) {
                    raFile.close();
                }
            }catch(Exception e){
                throw new IOException(e.getMessage());
            }
        }
    }
}
