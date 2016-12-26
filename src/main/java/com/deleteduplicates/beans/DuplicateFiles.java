package com.deleteduplicates.beans;

import java.io.File;

/**
 * Created by Seth on 12/26/2016.
 */
public class DuplicateFiles {

    private String directory;
    private String fileName;
    private File duplicateFile;

    public DuplicateFiles() {
        super();
    }

    public DuplicateFiles(String directory, String fileName, File duplicateFile) {
        this.directory = directory;
        this.fileName = fileName;
        this.duplicateFile = duplicateFile;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getDuplicateFile() {
        return duplicateFile;
    }

    public void setDuplicateFile(File duplicateFile) {
        this.duplicateFile = duplicateFile;
    }

    @Override
    public String toString() {
        return "DuplicateFiles{" +
                "directory='" + directory + '\'' +
                ", fileName='" + fileName + '\'' +
                ", duplicateFile=" + duplicateFile +
                '}';
    }
}
