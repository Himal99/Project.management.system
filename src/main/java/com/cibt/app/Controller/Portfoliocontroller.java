/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import com.cibt.app.Entity.Porfolio;
import com.cibt.app.repository.PortfolioRepository;
import com.jayway.jsonpath.internal.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/portfolio")
public class Portfoliocontroller extends Sitecontroller {

    public Portfoliocontroller() {
        viewpath = "portfolio";
        pageURI = "portfolio";
        pageTitle = "portfolio";

    }

    @Autowired
    private PortfolioRepository repository;

    @GetMapping

    public String index(Model model) {
        model.addAttribute("records", repository.findAll());
        return viewpath + "/index";
    }

    @PostMapping
    public String save(Porfolio model) {
        repository.save(model);
        return "redirect:/" + pageURI;
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("records", repository.findAll());
        return viewpath + "/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("records", repository.findById(id).get());
        return viewpath + "/edit";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return "redirect:/" + pageURI;

    }

    @GetMapping(value = "/json")

    public List<Porfolio> json() {
        return repository.findAll();

    }

    @GetMapping(value = "/json/{id}")

    public Porfolio getjson(@PathVariable("id") Integer id) {
        return repository.findById(id).get();
    }
    
    
    
    
}
