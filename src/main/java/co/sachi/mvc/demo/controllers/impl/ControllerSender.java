/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sachi.mvc.demo.controllers.impl;

import co.sachi.mvc.demo.models.Message;
import co.sachi.mvc.demo.controllers.IControllerSender;

/**
 *
 * @author Sachikia
 */
public class ControllerSender implements IControllerSender{
    private Message model;

    public ControllerSender(Message message) {
        this.model = message;
    }
    
    @Override
    public void sendMessage(String message) {
        this.model.pushMessages(message);
    }
}
