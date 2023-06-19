package org.example;

import jakarta.xml.ws.WebFault;

@WebFault
public class DeactivationEx extends Exception {
    public DeactivationEx(int index){
        super(" " + index + " ");
    }
}
