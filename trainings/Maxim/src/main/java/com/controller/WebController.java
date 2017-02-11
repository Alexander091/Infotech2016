package com.controller;

import com.DAO.DAO;
import com.zoo.Animal;
import com.zoo.Cat;
import com.zoo.Entity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class WebController{

    private DAO dao = new DAO();
    private static Logger LOGGER = Logger.getLogger(WebController.class);

    @RequestMapping(value = "/")
    public ModelAndView getListObject(ModelAndView model){
        List<Entity> listObjects = dao.getListObjects();
        model.addObject("listObjects",listObjects);
        model.setViewName("homepage");
        return model;
    }

    @RequestMapping(value = "/params")
    public ModelAndView getListParams(ModelAndView model) throws SQLException {
        List<Entity> listAnimal = dao.getListParams();
        model.addObject("listParams", listAnimal);
        model.setViewName("params");
        return model;
    }

    @RequestMapping(value = "/newEntity", method = RequestMethod.GET)
    public ModelAndView newEntity(ModelAndView model){
        Animal animal = new Cat();
        model.addObject("entity", animal);
        model.setViewName("create");
        return model;
    }

    @RequestMapping(value = "/saveEntity", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Cat entity) throws IllegalAccessException {
        dao.saveEntityInDatabase(entity);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest httpServletRequest){
        long objectId = Long.parseLong(httpServletRequest.getParameter("id"));
        dao.deleteEntityFromDatabase(objectId);
        return new ModelAndView("redirect:/");
    }
}
