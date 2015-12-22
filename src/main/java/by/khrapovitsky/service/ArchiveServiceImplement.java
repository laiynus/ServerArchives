package by.khrapovitsky.service;

import by.khrapovitsky.dao.ArchivesDAO;
import by.khrapovitsky.model.Archive;
import by.khrapovitsky.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArchiveServiceImplement implements ArchiveService{

    @Autowired
    private ArchivesDAO archivesDAO;

    private final static String PATH = "D:/Test/Upload/";

    @Override
    public void createArchive(CommonsMultipartFile tmp, String textNote) {
        Long date = new Date().getTime();
        Util util = new Util();
        File img = null;
        if(!tmp.getOriginalFilename().equals("")) {
            img = new File(PATH +  date + ".jpg");
            try {
                tmp.transferTo(img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File txt = null;
        if(!StringUtils.isBlank(textNote)){
            txt = Util.createTxt(PATH + date + ".txt",textNote);
        }
        String path = PATH + date + ".zip";
        String name = Util.addToZip(img,txt,new File(path));
        Archive archive = new Archive(path,name,new Timestamp(new Date().getTime()));
        archivesDAO.create(archive);
    }

    @Override
    public List getArchivesOfCurrentDay() {
        return archivesDAO.getArchivesOfCurrentDay(Util.getDateWithoutTime(new Date()),Util.getTomorrowDate(new Date()));
    }

    @Override
    public File getArchive(String name) {
        File file = null;
        Archive archive = archivesDAO.getArchive(name + ".zip");
        if(archive == null){
            return null;
        }else{
            file = new File(archive.getPath());
            if(!file.exists()){
                return null;
            }
        }
        return file;
    }

}
