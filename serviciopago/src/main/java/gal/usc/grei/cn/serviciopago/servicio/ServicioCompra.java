package gal.usc.grei.cn.serviciopago.servicio;


import gal.usc.grei.cn.serviciopago.modelo.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ServicioCompra {

    private final ServicioReserva servicioReserva;
    private final ServicioPago servicioPago;

@Autowired
    public ServicioCompra(ServicioReserva servicioReserva, ServicioPago servicioPago) {
        this.servicioReserva = servicioReserva;
        this.servicioPago = servicioPago;
    }
    @Transactional
    public Compra procesarTransaccion(Compra compra) throws RuntimeException{
        // Llamada a métodos de ServicioReserva
        if(!servicioReserva.procesarReserva(compra)){
            compra.setEstado("no disponible");
            return compra;
        }
        // Llamada a métodos de ServicioPago
        return servicioPago.procesarPago(compra);
    }
}


