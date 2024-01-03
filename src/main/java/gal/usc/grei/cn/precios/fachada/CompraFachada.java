package gal.usc.grei.cn.precios.fachada;

import gal.usc.grei.cn.precios.modelo.Compra;
import gal.usc.grei.cn.precios.repositorio.CompraRepositorio;
import gal.usc.grei.cn.precios.repositorio.PrecioRepositorio;
import gal.usc.grei.cn.precios.servicio.ServicioCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompraFachada {

    private final CompraRepositorio compras;

    private final ServicioCompra servicioCompra;
    private final PrecioRepositorio precios;
    /*
     * Constructor de la clase
     * @param compras Referencia al CompraRepositorio
     */
    @Autowired
    public CompraFachada(CompraRepositorio compras, ServicioCompra servicioCompra, PrecioRepositorio precios) {
        this.compras = compras;
        this.servicioCompra = servicioCompra;
        this.precios = precios;
    }
    public Optional<Compra> get(String id) {
// Se recupera la compra por el id
        return compras.findById(id);
    }
    /*
     * Método que permite insertar una nueva compra en la base de datos.
     * @param compra Los datos de la compra a insertar.
     * @return Los datos de la compra una vez insertados, incluyendo el id.
     * @throws ResponseStatusException Excepción lanzada en caso de que se facilite alguna
    información incorrecta.
     */
    @Transactional
    public Optional<Compra> create(Compra compra) throws RuntimeException{

        compra = servicioCompra.procesarTransaccion(compra);
        if(!compra.getEstado().equals("Bad Request")) return Optional.of(compras.insert(compra));
        else return Optional.empty();

    }
}
