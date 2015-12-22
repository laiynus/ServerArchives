package by.khrapovitsky.controller;

import by.khrapovitsky.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    private ArchiveService archiveService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("Upload");
        return model;
    }

    @RequestMapping(value = "/uploadFile.do" , method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
                archiveService.createArchive(aFile,request.getParameter("textNote"));
            }
        }
        return "Upload";
    }

}
