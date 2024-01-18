package gal.usc.grei.cn.serviciopago.servicio;

import gal.usc.grei.cn.serviciopago.modelo.Compra;


public interface ServicioPago {
    //servicio de realización de Pago
    Compra procesarPago(Compra compra) throws RuntimeException;
    boolean simularPago(Compra compra);
}

