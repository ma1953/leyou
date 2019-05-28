package com.leyou.service;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {
    private  static  final Logger logger= LoggerFactory.getLogger(UploadService.class);
    private  static  final List<String> suffixes= Arrays.asList("image/png", "image/jpeg","image/PNG");
    @Autowired
    private FastFileStorageClient storageClient;
    public String  upload(MultipartFile file){
        String type = file.getContentType();
        try {
         if(!suffixes.contains(type)){
             logger.info("上传失败，文件类型不匹配：{}", type);
              return null;
         }
            BufferedImage read = ImageIO.read(file.getInputStream());
                  if (read==null){
                      logger.info("上传失败，文件内容不符合要求");
                      return null;
                  }

            String afterLast = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), afterLast, null);
            return "http://image.leyou.com/"+storePath.getFullPath() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
