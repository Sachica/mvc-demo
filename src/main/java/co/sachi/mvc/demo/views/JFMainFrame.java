/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sachi.mvc.demo.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

/**
 *
 * @author Sachikia
 */
public class JFMainFrame {
    private JFrame frame;
    private JSplitPane splitPanel;
    private IPanel panelReceiver;
    private IPanel panelSender;

    public JFMainFrame(IPanel panelReceiver, IPanel panelSender) {
        this.frame = new JFrame("MVC Demo");
        
        this.splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        this.panelReceiver = panelReceiver;
        this.panelSender = panelSender;
        
        this.init();
    }
    
    private void init(){
        this.splitPanel.setResizeWeight(0.5);
        
        this.splitPanel.add(this.panelSender.getPanel());
        this.splitPanel.add(this.panelReceiver.getPanel());
        
        this.frame.add(this.splitPanel, BorderLayout.CENTER);
        this.frame.setPreferredSize(new Dimension(800, 200));
        this.frame.pack();
        
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }
}
