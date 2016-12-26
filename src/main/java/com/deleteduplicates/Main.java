package com.deleteduplicates;

import com.deleteduplicates.readfile.ReadFileCreateArrayList;
import com.deleteduplicates.utils.DeleteDuplicateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main {

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        File file = new File(args[0]);
        // Need to validate the input for the file containing the list of duplicate files.
        if (!DeleteDuplicateUtils.isFileValid(file)) {
            logger.error("The file that inputted was not valid: ", file);
        }
        ReadFileCreateArrayList readFileCreateArrayList = new ReadFileCreateArrayList();
        readFileCreateArrayList.createArrayListDeleteDuplicates(file);
    }
}
