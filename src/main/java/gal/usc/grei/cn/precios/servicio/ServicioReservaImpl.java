package gal.usc.grei.cn.precios.servicio;

import gal.usc.grei.cn.precios.modelo.Compra;
import gal.usc.grei.cn.precios.modelo.Precio;
import gal.usc.grei.cn.precios.repositorio.PrecioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioReservaImpl implements ServicioReserva{
    private final PrecioRepositorio precioRepositorio;
    @Autowired
    public ServicioReservaImpl (PrecioRepositorio precioRepositorio) {
        this.precioRepositorio = precioRepositorio;

    }
    @Override
    public boolean procesarReserva(Compra compra){
        Optional<Precio> precio = precioRepositorio.findPrecioBySymbolAndDate(compra.getSimbolo(),compra.getFecha());
        return precio.isPresent();
    }
}
