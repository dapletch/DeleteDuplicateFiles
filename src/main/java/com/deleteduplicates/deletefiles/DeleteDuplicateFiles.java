package com.deleteduplicates.deletefiles;

import com.deleteduplicates.beans.DuplicateFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Seth on 12/26/2016.
 */
public class DeleteDuplicateFiles {

    private Logger logger = LoggerFactory.getLogger(DeleteDuplicateFiles.class);

    public void deleteDuplicateFiles(List<DuplicateFiles> duplicateFilesList) {

        Boolean fileDeleted;

        for (Integer i = 0; i < duplicateFilesList.size(); i++) {
            // Need to add one to the index each time the loop iterates through to prevent
            // an index out of bounds exception
            if (duplicateFilesList.size() > (i + 1)) {
                if (duplicateFilesList.get(i).getFileName().equals(duplicateFilesList.get(i + 1).getFileName())) {
                    // Delete the duplicate file
                    fileDeleted = duplicateFilesList.get(i + 1).getDuplicateFile().delete();
                    logger.info("File Deleted: " + duplicateFilesList.get(i + 1).getDuplicateFile() + " " + fileDeleted);
                }
            }
        }
    }
}
