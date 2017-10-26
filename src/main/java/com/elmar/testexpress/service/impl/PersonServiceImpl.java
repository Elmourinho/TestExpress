/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elmar.testexpress.service.impl;

import com.elmar.testexpress.dao.PersonDao;
import com.elmar.testexpress.dto.PersonDTO;
import com.elmar.testexpress.entity.Person;
import com.elmar.testexpress.service.PersonService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;

/**
 *
 * @author elmar.alizada
 */
@Named
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonDao personDao;

    @Resource
    private UserTransaction userTransaction;

    @Override
    public List<Person> getPersonList() throws Exception {
        return personDao.findAll();
    }

    @Override
    public String getFamilTreeModel() throws Exception {
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", "0");
        jsonObject.addProperty("parent", "#");
        jsonObject.addProperty("text", "Family Tree");
        jsonArray.add(jsonObject);

        for (Person person : personDao.findAll()) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("id", "" + person.getId());
            jsonObject.addProperty("parent", "" + (person.getParent() != null ? person.getParent().getId() : 0));
            jsonObject.addProperty("text", person.getPersonSurname() + " " + person.getPersonName() + " - " + person.getAge());
            jsonArray.add(jsonObject);
        }

        return jsonArray.toString();
    }

    @Override
    public void add(PersonDTO input) throws Exception {
        try {
            userTransaction.begin();
            Person person = new Person();
            person.setPersonSurname(input.getSurname());
            person.setPersonName(input.getGivenName());
            person.setAge(input.getAge());
            person.setParent(input.getParentId() != 0 ? personDao.find(input.getParentId()) : null);
            personDao.add(person);
            userTransaction.commit();
        } catch (Exception e) {
            userTransaction.rollback();
            throw e;
        }

    }

    @Override
    public void edit(PersonDTO input) throws Exception {
        try {
            userTransaction.begin();
            Person person = personDao.find(input.getId());
            person.setPersonSurname(input.getSurname());
            person.setPersonName(input.getGivenName());
            person.setAge(input.getAge());
            personDao.edit(person);
            userTransaction.commit();

        } catch (Exception e) {
            userTransaction.rollback();
            throw e;
        }
    }

    @Override
    public PersonDTO find(int id) throws Exception {
        Person person = personDao.find(id);
        PersonDTO pdto = new PersonDTO();
        pdto.setAge(person.getAge());
        pdto.setGivenName(person.getPersonName());
        pdto.setId(person.getId());
        pdto.setParentId(person.getParent() != null ? person.getParent().getId() : null);
        pdto.setSurname(person.getPersonSurname());
        return pdto;
    }

    @Override
    public boolean remove(PersonDTO input) throws Exception {
        boolean result = false;
        userTransaction.begin();
        Person person = personDao.find(input.getId());
        if (!personDao.hasChildren(person.getId())) {
            result = true;
            personDao.delete(person);
        }

        userTransaction.commit();
        
        return result;
    }

}
