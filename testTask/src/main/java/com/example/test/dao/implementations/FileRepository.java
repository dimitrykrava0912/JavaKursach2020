package com.example.test.dao.implementations;


import com.example.test.dao.mappers.FileMapper;
import com.example.test.models.File1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@PropertySource("classpath:queries/files.properties")
@Repository
@Slf4j
public class FileRepository implements com.example.test.dao.interfaces.FileRepository {
    private final NamedParameterJdbcTemplate namedJdbcTemplate;
    @Autowired
    public FileRepository(DataSource dataSource) {
        this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Value("${getAllFiles}")
    private String getAllFiles;

    @Value("${addFileUUID}")
    private  String addFileUUID;

    @Override
    public void saveFile (File1 fl){
        Map<String, Object> namedParams = new HashMap<>();
        namedParams.put("file_path",fl.getAddress());
        namedParams.put("add_date",fl.getDate());
        namedJdbcTemplate.update(addFileUUID, namedParams);
    }

    @Override
    public Iterable<File1> getAllFiles (){
        return namedJdbcTemplate.query(getAllFiles, new FileMapper());
    }


}
