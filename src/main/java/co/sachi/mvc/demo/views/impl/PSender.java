/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sachi.mvc.demo.views.impl;

import co.sachi.mvc.demo.views.IPanel;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import co.sachi.mvc.demo.controllers.IControllerSender;
import co.sachi.mvc.demo.util.ViewTool;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;

/**
 *
 * @author Sachikia
 */
public class PSender implements IPanel, Observer{
    private JPanel panel;
    private JTextArea txtInput;
    private JButton btnSend;

    public PSender(IControllerSender controller) throws Exception {
        this.panel = new JPanel(new GridBagLayout());
        
        this.txtInput = new JTextArea();
        this.btnSend = new JButton("Send");
        
        this.init(controller);
    }
    
    private void init(IControllerSender controller) throws Exception{
        
        ViewTool.insert(this.panel, this.txtInput,    0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, null, 0, 0);
        ViewTool.insert(this.panel, this.btnSend,     0, 1, 1, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.PAGE_END, null, 0, 0);
        
        this.btnSend.addActionListener(e -> {
            controller.sendMessage(this.txtInput.getText());
        });
    }
    
    @Override
    public void update(Observable o, Object arg) {
        //no es necesario, almenos no por ahora
    }
    
    @Override
    public JPanel getPanel() {
        return this.panel;
    }
}
