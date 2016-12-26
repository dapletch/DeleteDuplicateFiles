package com.deleteduplicates.readfile;

import com.deleteduplicates.beans.DuplicateFiles;
import com.deleteduplicates.deletefiles.DeleteDuplicateFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seth on 12/26/2016.
 */
public class ReadFileCreateArrayList {

    private Logger logger = LoggerFactory.getLogger(ReadFileCreateArrayList.class);

    private List<DuplicateFiles> duplicateFilesToBeCompared = new ArrayList<DuplicateFiles>();

    private DeleteDuplicateFiles deleteDuplicateFiles = new DeleteDuplicateFiles();

    public void createArrayListDeleteDuplicates(File file) {
        duplicateFilesToBeCompared = readFileToArrayList(file);
        deleteDuplicateFiles.deleteDuplicateFiles(duplicateFilesToBeCompared);
    }

    private List<DuplicateFiles> readFileToArrayList(File file) {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                DuplicateFiles duplicateFiles = new DuplicateFiles();
                duplicateFiles = setDuplicateValuesFromLine(line);
                logger.info("Duplicate File: " + duplicateFiles.toString());
                duplicateFilesToBeCompared.add(duplicateFiles);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return duplicateFilesToBeCompared;
    }

    private DuplicateFiles setDuplicateValuesFromLine(String line) {
        return new DuplicateFiles(new File(line.trim()).getParent()
                , new File(line.trim()).getName()
                , new File(line.trim()));
    }
}
