/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elmar.testexpress.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elmar.alizada
 * @param <T>
 */
@XmlRootElement
public class Status<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;
    private T data;

    public Status() {
    }

    public Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Status(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}