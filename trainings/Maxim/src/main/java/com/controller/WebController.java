package com.controller;

import com.DAO.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController{

    @Autowired
    DAO getDAO;

    @RequestMapping(value = "/addEntity", method = RequestMethod.GET)


}
