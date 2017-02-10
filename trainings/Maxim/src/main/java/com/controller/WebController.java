package com.controller;

import com.DAO.DAO;
import com.zoo.Animal;
import com.zoo.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class WebController{

    private DAO dao = new DAO();

    @RequestMapping(value = "/params")
    public ModelAndView listParams(ModelAndView model) throws SQLException {
        List<Entity> listAnimal = dao.getListParams();
        model.addObject("listParams", listAnimal);
        model.setViewName("params");
        return model;
    }

    @RequestMapping(value = "/newEntity", method = RequestMethod.GET)
    public ModelAndView newEntity(ModelAndView model){
        Animal animal = new Animal();
        model.addObject("entity", animal);
        model.setViewName("create");
        return model;
    }

    @RequestMapping(value = "/saveEntity", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Animal entity) throws IllegalAccessException {
        dao.saveEntityInDatabase(entity);
        return new ModelAndView("redirect:params");
    }
}
