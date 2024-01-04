package gal.usc.grei.cn.precios.controlador;

import gal.usc.grei.cn.precios.modelo.Compra;
import gal.usc.grei.cn.precios.servicio.ServicioCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Servicios")

public class ServicioControlador {
    private final ServicioCompra servicioCompra;

    @Autowired
    public ServicioControlador(ServicioCompra servicioCompra) {
        this.servicioCompra = servicioCompra;
    }

    /**
     * Método: POST para las peticiones a servicio compra de realizar compra
     */
    @PostMapping("/realizarCompra")
    public Compra realizarCompra(@RequestBody Compra compra) {
        return servicioCompra.procesarTransaccion(compra);
    }



}
