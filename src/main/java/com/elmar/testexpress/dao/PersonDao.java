/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elmar.testexpress.dao;

import com.elmar.testexpress.entity.Person;
import java.util.List;

/**
 *
 * @author elmar.alizada
 */
public interface PersonDao {

    public List<Person> findAll() throws Exception;
    public void add(Person person);
    public Person find(int id) throws Exception;
    public boolean hasChildren (int parentId) throws Exception;
    public void edit(Person person);
    public void delete(Person person);
    
}
