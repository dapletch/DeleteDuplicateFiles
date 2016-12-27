package com.deleteduplicates.dao;

import com.deleteduplicates.beans.DuplicateFiles;
import com.deleteduplicates.deletefiles.DeleteDuplicateFiles;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seth on 12/27/2016.
 */
public class InsertReadFromH2Database {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(InsertReadFromH2Database.class);

    private List<DuplicateFiles> duplicateFilesListOrdered = new ArrayList<>();

    private String insertIntoDuplicateFilesQuery = "insert into duplicate_files (directory, filename, duplicate_file) " +
            "values (?, ?, ?);";

    public List<DuplicateFiles> createInsertReadFromDb(List<DuplicateFiles> duplicateFilesList) {

        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:~/duplicate_files", "root", "Crazie4you!");
            Statement statement = connection.createStatement();

            statement.executeUpdate("drop table if exists duplicate_files;");

            statement.executeUpdate("create table duplicate_files (\n" +
                    "directory varchar(1000)\n" +
                    ", filename varchar(200)\n" +
                    ", duplicate_file varchar(1500)\n" +
                    ");");

            // Inserting the duplicate file records so that they can be ordered accordingly
            PreparedStatement preparedStatement = connection.prepareStatement(insertIntoDuplicateFilesQuery);

            for (DuplicateFiles duplicateFiles : duplicateFilesList) {
                preparedStatement.clearParameters();
                preparedStatement.setString(1, duplicateFiles.getDirectory());
                preparedStatement.setString(2, duplicateFiles.getFileName());
                preparedStatement.setString(3, String.valueOf(duplicateFiles.getDuplicateFile()));
                preparedStatement.executeUpdate();
            }

            ResultSet rs = statement.executeQuery("select directory\n" +
                    ", filename\n" +
                    ", duplicate_file\n" +
                    "from duplicate_files \n" +
                    "order by duplicate_file;");

            while (rs.next()) {
                DuplicateFiles duplicateFiles = new DuplicateFiles(rs.getString(1)
                        , rs.getString(2)
                        , new File(rs.getString(3)));
                duplicateFilesListOrdered.add(duplicateFiles);
            }

        } catch (Exception e) {
            logger.error("There was an error accessing h2 embedded database: ", e);
        }
        return duplicateFilesListOrdered;
    }
}
