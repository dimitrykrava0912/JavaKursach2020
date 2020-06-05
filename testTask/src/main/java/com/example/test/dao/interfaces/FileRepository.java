package com.example.test.dao.interfaces;

import com.example.test.models.File1;

public interface FileRepository {
    void saveFile (File1 fl);
    Iterable<File1> getAllFiles ();
}
