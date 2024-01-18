package gal.usc.grei.cn.serviciopago.servicio;

import gal.usc.grei.cn.serviciopago.modelo.Compra;
import gal.usc.grei.cn.serviciopago.modelo.Precio;
import gal.usc.grei.cn.serviciopago.repositorio.ServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ServicioReservaImpl implements ServicioReserva{
    private final ServicioRepositorio servicioRepositorio;
    @Autowired
    public ServicioReservaImpl (ServicioRepositorio servicioRepositorio) {
        this.servicioRepositorio = servicioRepositorio;

    }
    @Override
    public boolean procesarReserva(Compra compra){
        Optional<Precio> precio = servicioRepositorio.findPrecioBySymbolAndDate(compra.getSimbolo(),compra.getFecha());
        return precio.isPresent();
    }
}
