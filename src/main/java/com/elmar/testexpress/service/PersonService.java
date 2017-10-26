/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elmar.testexpress.service;

import com.elmar.testexpress.dto.PersonDTO;
import com.elmar.testexpress.entity.Person;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author elmar.alizada
 */
public interface PersonService extends Serializable{
    public List<Person> getPersonList() throws Exception;
    public String getFamilTreeModel()  throws Exception;
    public void add(PersonDTO input) throws Exception;
    public void edit(PersonDTO input) throws Exception;
    public boolean remove(PersonDTO input) throws Exception;
    public PersonDTO find (int id) throws Exception;
    
}
