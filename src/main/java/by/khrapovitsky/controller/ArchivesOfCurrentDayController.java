package by.khrapovitsky.controller;

import by.khrapovitsky.model.Archive;
import by.khrapovitsky.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/archives", "/"})
public class ArchivesOfCurrentDayController {

    @Autowired
    ArchiveService archiveService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("Index");
        List archivesList = archiveService.getArchivesOfCurrentDay();
        model.addObject("archivesList", archivesList);
        return model;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/currentday"})
    public @ResponseBody List<Archive> getArchivesOfCurrentDay() {
        return archiveService.getArchivesOfCurrentDay();
    }
}
