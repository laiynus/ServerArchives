package by.khrapovitsky.dao;

import by.khrapovitsky.model.Archive;

import java.util.Date;
import java.util.List;

public interface ArchivesDAO {
    void create(Archive archive);
    Archive getArchive(String name);
    List getAllArchives();
    List getArchivesOfCurrentDay(Date fromDate,Date toDate);
}
