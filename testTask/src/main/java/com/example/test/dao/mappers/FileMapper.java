package com.example.test.dao.mappers;

import com.example.test.models.File1;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class FileMapper implements RowMapper<File1> {
    @Override
    public File1 mapRow (ResultSet resultSet,int rowNum)throws SQLException {
        File1 file1 = new File1();
        file1.setAddress(resultSet.getString("file_path"));
        file1.setDate(resultSet.getDate("add_date").toLocalDate());
        return file1;
    }
}
