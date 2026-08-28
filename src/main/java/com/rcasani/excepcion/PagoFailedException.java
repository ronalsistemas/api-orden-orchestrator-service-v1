package com.rcasani.excepcion;

public class PagoFailedException extends RuntimeException {
    public PagoFailedException(String message, Exception ex) {
        super(message, ex);
    }
}
