/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.Controller;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user
 */
public abstract class Crudcontroller<T, Id> extends Sitecontroller {

    @Autowired
    protected JpaRepository<T, Id> repository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("records", repository.findAll());
        return viewpath + "/index";
    }
//    to call table in ajax

    @GetMapping(value = "/table")
    public String table(Model model) {
        model.addAttribute("records", repository.findAll());
        return viewpath + "/table";
    }

    @GetMapping(value = "/create")
    public String create() {
        return viewpath + "/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Id id, Model model) {
        model.addAttribute("records", repository.findById(id).get());
        return viewpath + "/edit";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Id id) {
        repository.deleteById(id);
        return "redirect:/"+pageURI+"?success";
       

    }

    @PostMapping
    public String save(T model) {
        repository.save(model);
        return "redirect:/" + pageURI;

    }

    @PostMapping(value = "/json")
    @ResponseBody
    public String savejson(T model) {
        repository.save(model);
        return "success";

    }

    @GetMapping(value = "/json")
    @ResponseBody
    public List<T> json() {
        return repository.findAll();
    }

    @GetMapping(value = "/json/{id}")
    @ResponseBody
    public T getjson(@PathVariable("id") Id id) {
        return repository.findById(id).get();

    }
    
    @GetMapping(value = "/edit")
    String edit(){
        return viewpath+"/edit";
    }

}
