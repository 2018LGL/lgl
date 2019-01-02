package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.Bookfile;
import com.zking.ssm.service.IBookfileService;
import com.zking.ssm.vo.BookFileVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/bookFile")
public class BookFileController {

    @Autowired
    private IBookfileService bookfileService;

    @RequestMapping("/upload")
    public String upload(BookFileVo bookFileVo){
        //BookFile
        //1)File文件(文件名，文件类型，File)
        //2)bookId
        //3)使用UUID生成fileId
        MultipartFile img = bookFileVo.getImg();
        System.out.println(img.getContentType());
        System.out.println(img.getOriginalFilename());
        String fileId = UUID.randomUUID().toString().replace("-","");

        //文件路径：
        String filePath = "F:\\"+img.getOriginalFilename();

        //1,保存文件上传信息和修改书本图片信息
        try {
            Bookfile bookfile = new Bookfile();
            bookfile.setFileId(fileId);
            bookfile.setContentType(img.getContentType());
            bookfile.setRealName(img.getOriginalFilename());
            bookfile.setUrl(filePath);
            Book book = new Book();
            book.setId(bookFileVo.getBookId());
            book.setPhoto(fileId);
            System.out.println("book:"+book);
            bookfileService.insert(bookfile,book);


            //2，上传文件到指定目录
            img.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/book/bookList";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam String fileId){

        try {
            Bookfile bookFile = bookfileService.selectByPrimaryKey(fileId);
            String fileName = bookFile.getRealName();
            //下载关键代码
            File file=new File(bookFile.getUrl());
            HttpHeaders headers = new HttpHeaders();//http头信息
            String downloadFileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");//设置编码
            headers.setContentDispositionFormData("attachment", downloadFileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
