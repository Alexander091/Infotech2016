package zooshop.controller;
import zooshop.dao.EntityDAO;

import zooshop.model.Animal;
import zooshop.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private EntityDAO entityDAO;

    @RequestMapping(value = "/")
    public ModelAndView listAnimal(ModelAndView model) throws IOException {

        List<Animal> listAnimal = entityDAO.listAnimal();
        model.addObject("listAnimal", listAnimal);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/newAnimal", method = RequestMethod.GET)
    public ModelAndView newAnimal(ModelAndView model) {
        Animal newAnimal = new Animal();
        model.addObject("animal", newAnimal);
        model.setViewName("NewAnimalForm");
        return model;
    }

    @RequestMapping(value = "/saveAnimal", method = RequestMethod.POST)
    public ModelAndView saveCat(@ModelAttribute Cat animal) throws IllegalAccessException {
        entityDAO.save(animal);
        return new ModelAndView("redirect:/");
    }


    @RequestMapping(value = "/showParams")
    public ModelAndView listParams(HttpServletRequest request, ModelAndView model) {
        int object_id = Integer.parseInt(request.getParameter("objectId"));
        List<Animal> listAnimal = entityDAO.list(object_id);
        model.addObject("listParams", listAnimal);
        model.setViewName("showParams");
        return model;
    }

    @RequestMapping(value = "/deleteAnimal", method = RequestMethod.GET)
    public ModelAndView deleteAnimal(HttpServletRequest request) {
        int objectId = Integer.parseInt(request.getParameter("objectId"));
        entityDAO.delete(objectId);
        return new ModelAndView("redirect:/");
    }



}