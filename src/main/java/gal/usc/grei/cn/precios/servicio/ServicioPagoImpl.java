package gal.usc.grei.cn.precios.servicio;

import gal.usc.grei.cn.precios.modelo.Compra;
import org.springframework.stereotype.Service;

@Service
public class ServicioPagoImpl implements ServicioPago {

    @Override
    public Compra procesarPago(Compra compra) throws RuntimeException{
        try {
            if (( !compra.getMetodoPago().equals("Tarjeta de credito")||
                    compra.getNumeroTarjeta().length()==19)){
                if(this.simularPago(compra)) {
                    compra.setEstado("pagado");
                } else {
                    compra.setEstado("fallido");
                }
            }
            else compra.setEstado("Bad Request");
            return compra;
        } catch (Exception e) {
            throw new RuntimeException("Error Interno al procesar la Compra", e);
        }
    }
    @Override
    public boolean simularPago(Compra compra){
        // Lógica para procesar el pago
        // Puedes implementar aquí tu lógica de pago y retornar true si es exitoso, false si falla.

        // Ejemplo: Simulamos un 80% de éxito y un 20% de fallo
        return Math.random() < 0.8;
    }
}
