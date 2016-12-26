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
            if (duplicateFilesList.get(i).getFileName().equals(duplicateFilesList.get(i + 1).getFileName())) {
                // Delete the duplicate file
                if (i >= duplicateFilesList.size()) {
                    fileDeleted = duplicateFilesList.get(i + 1).getDuplicateFile().delete();
                    logger.info("File Deleted: " + duplicateFilesList.get(i + 1).getDuplicateFile() + " " + fileDeleted);
                }
            }
        }
    }
}
