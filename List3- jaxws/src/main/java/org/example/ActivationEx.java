package org.example;

import jakarta.xml.ws.WebFault;

@WebFault
public class ActivationEx extends Exception {
    public ActivationEx(int index){
        super(" " + index + " ");
    }
}
