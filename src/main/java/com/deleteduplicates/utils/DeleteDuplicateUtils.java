package com.deleteduplicates.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Seth on 12/26/2016.
 */
public class DeleteDuplicateUtils {

    public static Logger logger = LoggerFactory.getLogger(DeleteDuplicateUtils.class);

    public static Boolean isFileValid(File file) {
        return file.exists()
                && file.isFile()
                && !file.isDirectory();
    }
}
