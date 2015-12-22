package by.khrapovitsky.service;

import by.khrapovitsky.model.Archive;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.List;

public interface ArchiveService {
    void createArchive(CommonsMultipartFile file,String textNote);
    List getArchivesOfCurrentDay();
    File getArchive(String name);
}
