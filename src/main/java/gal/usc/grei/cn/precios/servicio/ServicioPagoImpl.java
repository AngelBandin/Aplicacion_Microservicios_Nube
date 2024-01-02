package gal.usc.grei.cn.precios.servicio;

import gal.usc.grei.cn.precios.modelo.Compra;
import org.springframework.stereotype.Service;

@Service
public class ServicioPagoImpl implements ServicioPago {
    @Override
    public boolean procesarPago(Compra compra) {
        // Lógica para procesar el pago
        // Puedes implementar aquí tu lógica de pago y retornar true si es exitoso, false si falla.

        // Ejemplo: Simulamos un 80% de éxito y un 20% de fallo
        return Math.random() < 0.8;
    }
}
