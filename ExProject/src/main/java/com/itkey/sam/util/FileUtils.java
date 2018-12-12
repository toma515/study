package com.itkey.sam.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.itkey.sam.file.FileDTO;
 
@Repository("fileUtils")
public class FileUtils {
    private static final String filePath = "C:\\dev\\file\\";
     
    public List<FileDTO> parseInsertFileInfo(HttpServletRequest request) throws Exception{
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
         
        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String changedFileName = null;
         
        List<FileDTO> list = new ArrayList<FileDTO>();
        FileDTO fDTO = null;
         
         
        File file = new File(filePath);
        if(file.exists() == false){
            file.mkdirs();
        }
         
        while(iterator.hasNext()){
            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            if(multipartFile.isEmpty() == false){
                originalFileName = multipartFile.getOriginalFilename();
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                changedFileName = CommonUtils.getRandomString() + originalFileExtension;
                 
                file = new File(filePath + changedFileName);
                multipartFile.transferTo(file);
                 
                fDTO = new FileDTO();
                fDTO.setFileOriginalName(originalFileName);
                fDTO.setFileChangedName(changedFileName);
                fDTO.setFilePath(filePath);
                
               
                list.add(fDTO);
            }
        }
        return list;
    }
    
    public List<FileDTO> parseUpdateFileInfo(Map<String, Object> map , HttpServletRequest request) throws Exception{
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
         
        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String changedFileName = null;
         
        List<FileDTO> list = new ArrayList<FileDTO>();
        FileDTO fDTO = null;
         
        String requestName = null;
        String idx = null;
         
         
        while(iterator.hasNext()){
            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            if(multipartFile.isEmpty() == false){
                originalFileName = multipartFile.getOriginalFilename();
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                changedFileName = CommonUtils.getRandomString() + originalFileExtension;
                 
                multipartFile.transferTo(new File(filePath + changedFileName));
                            
                fDTO = new FileDTO();
                fDTO.setHandleFile("C");
                fDTO.setFileOriginalName(originalFileName);
                fDTO.setFilePath(filePath);
                fDTO.setFileChangedName(changedFileName);
                
                list.add(fDTO);
            }
            else{
                requestName = multipartFile.getName();
                idx = "IDX_"+requestName.substring(requestName.indexOf("_")+1);
                fDTO = new FileDTO();
                
                if(map.containsKey(idx) == true && map.get(idx) != null){
                    fDTO.setHandleFile("N");
                    fDTO.setFileIdx(map.get(idx).toString());
                }else {
                	fDTO.setHandleFile("D");
                	fDTO.setFileIdx(map.get(idx).toString());
                }
                
                list.add(fDTO);
            }
        }
        return list;
    }
    
}


