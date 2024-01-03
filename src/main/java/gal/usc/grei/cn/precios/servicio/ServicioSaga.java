package gal.usc.grei.cn.precios.servicio;


import gal.usc.grei.cn.precios.modelo.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ServicioSaga {

    private final ServicioReserva servicioReserva;
    private final ServicioPago servicioPago;

@Autowired
    public ServicioSaga(ServicioReserva servicioReserva, ServicioPago servicioPago) {
        this.servicioReserva = servicioReserva;
        this.servicioPago = servicioPago;
    }

    public Compra procesarTransaccion(Compra compra) throws RuntimeException{
        // Llamada a métodos de ServicioReserva
        servicioReserva.procesarReserva(compra);

        // Llamada a métodos de ServicioPago
        return servicioPago.procesarPago(compra);
    }

    // Otros métodos...
}


