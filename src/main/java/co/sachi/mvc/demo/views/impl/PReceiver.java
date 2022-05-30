/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sachi.mvc.demo.views.impl;

import co.sachi.mvc.demo.controllers.IControllerReceiver;
import co.sachi.mvc.demo.util.ViewTool;
import co.sachi.mvc.demo.views.IPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Sachikia
 */
public class PReceiver implements IPanel, Observer{
    private JPanel panel;
    private JTextArea txtMessage;
    private JButton btnDelete;

    public PReceiver(IControllerReceiver controller) throws Exception {
        this.panel = new JPanel(new GridBagLayout());
        
        this.txtMessage = new JTextArea();
        this.btnDelete = new JButton("Pop message");
        
        this.init(controller);
    }
    
    private void init(IControllerReceiver controller) throws Exception{
        this.txtMessage.setEditable(false);
        
        ViewTool.insert(this.panel, this.txtMessage,    0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, null, 0, 0);
        ViewTool.insert(this.panel, this.btnDelete,     0, 1, 1, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.PAGE_END, null, 0, 0);
        
        this.btnDelete.addActionListener(e -> {
            controller.popMessage();
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        this.txtMessage.setText(arg.toString());
    }
    
    @Override
    public JPanel getPanel() {
        return this.panel;
    }
}
