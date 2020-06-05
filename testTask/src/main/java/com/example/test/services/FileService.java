package com.example.test.services;

import com.example.test.dao.interfaces.FileRepository;

import com.example.test.models.File1;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Service
@Slf4j
public class FileService {
    private FileRepository fileRepository;

    @Autowired
    public FileService( FileRepository fileRepository){
        this.fileRepository=fileRepository;
        }

    public void  addFile (Path path ){
        File1 file1 = new File1();
        file1.setAddress(path.toString());
        file1.setDate(LocalDate.now());
        fileRepository.saveFile(file1);
    }

    public Iterable<File1> getAllFiles(){
        return fileRepository.getAllFiles();
    }

}
