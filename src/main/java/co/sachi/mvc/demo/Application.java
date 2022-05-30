/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sachi.mvc.demo;

import co.sachi.mvc.demo.controllers.impl.ControllerReceiver;
import co.sachi.mvc.demo.controllers.impl.ControllerSender;
import co.sachi.mvc.demo.models.Message;
import co.sachi.mvc.demo.views.JFMainFrame;
import co.sachi.mvc.demo.views.impl.PReceiver;
import co.sachi.mvc.demo.views.impl.PSender;

/**
 *
 * @author Sachikia
 */
public class Application {
    /**
     * Implementación del patron arquitectonico MVC
     * https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller#mediaviewer/File:MVC-Process.svg
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        //Inicializar modelos
        Message model = new Message();
        
        /*
            Inicializar controladores con sus respectivos modelos.
            El controlador ahora podra manipular el modelo
        */
        ControllerSender controllerSender = new ControllerSender(model);
        ControllerReceiver controllerReceiver = new ControllerReceiver(model);
        
        /* 
            Inicializar vistas con sus respectivos controlladores.
            Se le pasa la interfaz del controlador para evitar acoplamiento.
            Esta interfaz contiene los metodos que la vista necesitaria llamar para un evento dado.
             
            Si nota extraño que se pase el controlador a la vista puede ver este articulo de donde
            se tomaron algunas cosas para realizar esta demo:
            https://www.oracle.com/technical-resources/articles/java/java-se-app-design-with-mvc.html
        */
        PSender panelSender = new PSender(controllerSender);
        PReceiver panelReceiver = new PReceiver(controllerReceiver);
        
        /*
            Añadir la vista como oyente al modelo.
            Ahora la vista estara pendiente de los cambios del modelo.
            Como podemos ver un modelo puede servir/notificar para varias vistas
            lo cual esta totalmente permitido.
        */
        model.addObserver(panelSender);
        model.addObserver(panelReceiver);
        
        /*
            La ventana principal no necesita conocer los componentes que contiene,
            solo deberia saber que tendra paneles, esto evita el acoplamiento con el fin
            de que en el momento que se desee cambiar un panel solamente cambiaria la
            implementacion del mismo
        */
        JFMainFrame mainFrame = new JFMainFrame(panelReceiver, panelSender);
    }
}
