package gal.usc.grei.cn.precios.servicio;

import gal.usc.grei.cn.precios.modelo.Compra;
import org.springframework.stereotype.Service;

@Service
public class ServicioReservaImpl implements ServicioReserva{

    public boolean procesarReserva(Compra compra){
        return true;
    }
}
