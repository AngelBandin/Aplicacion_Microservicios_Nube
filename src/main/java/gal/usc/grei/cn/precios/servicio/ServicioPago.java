package gal.usc.grei.cn.precios.servicio;

import gal.usc.grei.cn.precios.modelo.Compra;

public interface ServicioPago {
    boolean procesarPago(Compra compra);
}

