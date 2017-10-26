/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elmar.testexpress.dao.impl;

import com.elmar.testexpress.dao.PersonDao;
import com.elmar.testexpress.entity.Person;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author elmar.alizada
 */
@Named
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> findAll() throws Exception {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Person.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void add(Person person) {
        em.persist(person);
        em.flush();
    }

    @Override
    public Person find(int id) throws Exception {
        return em.find(Person.class, id);
    }

    @Override
    public void edit(Person person) {
        Person editPerson = em.find(Person.class, person.getId());
        em.persist(editPerson);
    }

    @Override
    public void delete(Person person) {
        em.remove(person);

    }

    @Override
    public boolean hasChildren(int parentId) throws Exception {
        boolean result = false;
        TypedQuery<Person> typed = em.createQuery("SELECT p from Person p WHERE p.parent.id=:parent", Person.class);
        typed.setParameter("parent", parentId);
        List<Person> listChildren = typed.getResultList();
        if (listChildren.size()!=0) {
            result = true;
        }
        return result;
    }

}
