package com.briup.web.controller.part4;

import com.briup.util.Result;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传和下载
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(@RequestParam("username") String username, @RequestParam("file") MultipartFile files) throws Exception {
        String filename = null;
        Map result = new HashMap();
        if(! files.isEmpty()){//当上传文件不为空时，保存文件到服务器目录
            //1.获取文件名称
            filename = files.getOriginalFilename();
            //2.指定文件保存位置: D:/server/位置必须存在
            File file = new File("D:/server/", filename);
            //3.保存文件
            files.transferTo(file);
            //返回上传成功的json字符串
            result.put("code","200");
            result.put("msg",username+"上传文件"+filename+"成功");
            return result;
        }
        result.put("code","400");
        result.put("msg","未指定上传文件");
        return result;
    }
    @RequestMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName) throws Exception {
        //1.设置响应头
        HttpHeaders headers = new HttpHeaders();
        //设置响应体内容要下载方式 :Content-Disposition: form-data; name="attachment"; filename="a.png"
        String downFile = new String(fileName.getBytes("utf-8"), "iso-8859-1");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",downFile);
        //2.设置响应体
        //读取文件获取文件的字节信息
        byte[] data = FileUtils.readFileToByteArray(new File("D:/server/", fileName));

        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(data,headers, HttpStatus.OK);

        return entity;
    }
}
