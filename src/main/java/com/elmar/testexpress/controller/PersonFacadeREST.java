/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elmar.testexpress.controller;

import com.elmar.testexpress.dto.PersonDTO;
import com.elmar.testexpress.dto.Status;
import com.elmar.testexpress.service.PersonService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author elmar.alizada
 */
@Path("/person")
@RequestScoped
public class PersonFacadeREST  {
    
    @Inject
    private PersonService ps;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Status create(PersonDTO input) {
        Status status = new Status();
        try {
            ps.add(input);
            status.setCode(1);
        } catch (Exception ex) {
            status.setCode(0);
            Logger.getLogger(PersonFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Status edit(PersonDTO input) {
        Status status = new Status();
        try {
            ps.edit(input);
            status.setCode(1);
        } catch (Exception ex) {
            status.setCode(0);
            Logger.getLogger(PersonFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @POST
    @Path("/remove")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
       public Status remove(PersonDTO input) {
        Status status = new Status();
        try {
            if (ps.remove(input)){
                status.setCode(1);
            }else{
                status.setCode(0);
            }
        } catch (Exception ex) {
            status.setCode(0);
            Logger.getLogger(PersonFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @POST
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Status find(PersonDTO input) {
        Status status = new Status();
        try {
            status.setCode(1);
            status.setData(ps.find(input.getId()));
        } catch (Exception ex) {
            status.setCode(0);
            Logger.getLogger(PersonFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
 
    @GET
    @Path("/familyTree")
    public String getFamilyTreeModel() {
        try {
            return ps.getFamilTreeModel();
        } catch (Exception ex) {
            Logger.getLogger(PersonFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    
}
