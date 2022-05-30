/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sachi.mvc.demo.controllers.impl;

import co.sachi.mvc.demo.controllers.IControllerReceiver;
import co.sachi.mvc.demo.models.Message;

/**
 *
 * @author Sachikia
 */
public class ControllerReceiver implements IControllerReceiver{
    private Message model;

    public ControllerReceiver(Message model) {
        this.model = model;
    }
    
    @Override
    public void popMessage() {
        this.model.popMessages();
    }
}
