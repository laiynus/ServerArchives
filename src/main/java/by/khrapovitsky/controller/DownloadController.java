package by.khrapovitsky.controller;

import by.khrapovitsky.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping(value = "/download")
public class DownloadController {

    @Autowired
    ArchiveService archiveService;

    @RequestMapping(value="/file/{name}", method = RequestMethod.GET)
    public void downloadArchive(HttpServletResponse response, @PathVariable("name") String name){
        File archive = archiveService.getArchive(name);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(archive);
            response.setHeader("Content-Disposition", "attachment; filename=\"" + archive.getName() + "\"");
            FileCopyUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
                if (null != inputStream)
                    response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
