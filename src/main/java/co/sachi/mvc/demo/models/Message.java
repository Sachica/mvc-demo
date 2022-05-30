/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sachi.mvc.demo.models;

import java.util.Observable;
import java.util.Stack;

/**
 *
 * @author Sachikia
 */
public class Message extends Observable{
    private Stack<String> messages;

    public Message() {
        this.messages = new Stack<>();
    }

    public Stack<String> getMessages() {
        return messages;
    }

    public void pushMessages(String message){
        this.messages.push(message);
        super.setChanged();
        super.notifyObservers(this.messages.peek());
    }
    
    public void popMessages() {
        String message = "No messages";
        if (!this.messages.isEmpty()){
            this.messages.pop();
        }
        
        if(!this.messages.isEmpty()){
            message = this.messages.peek();
        }
        
        super.setChanged();
        super.notifyObservers(message);
    }
}
