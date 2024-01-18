package gal.usc.grei.cn.serviciopago.servicio;

import gal.usc.grei.cn.serviciopago.modelo.Compra;

public interface ServicioReserva {

    boolean procesarReserva(Compra compra); //función para comprobar si la accion comprada esta disponible
                                            //en la fecha y por la entidad indicada en la compra
}
