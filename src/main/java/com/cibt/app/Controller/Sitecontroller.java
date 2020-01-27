/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import java.util.Date;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author user
 */
public abstract class Sitecontroller {

    protected String pageURI, pageTitle, viewpath;
    Date date=new Date();
    int dateline=date.getYear();
  
    @ModelAttribute
    public void globalveriable(Model model) {
        model.addAttribute("pageURI", pageURI);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("viewpath", viewpath);
        model.addAttribute("dateline", dateline);

    }

}