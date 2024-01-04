package gal.usc.grei.cn.precios.fachada;

import gal.usc.grei.cn.precios.modelo.Compra;
import gal.usc.grei.cn.precios.repositorio.CompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CompraFachada {

    private final CompraRepositorio compras;


    @Autowired
    private RestTemplate restTemplate;
    /*
     * Constructor de la clase
     * @param compras Referencia al CompraRepositorio
     */
    @Autowired
    public CompraFachada(CompraRepositorio compras) {
        this.compras = compras;
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
        if (!(compra.getId() == null || compra.getId().isEmpty())) return Optional.empty();
        //compra = servicioCompra.procesarTransaccion(compra);
        String servicioCompraUrl = "http://localhost:8081/Servicios/realizarCompra";
        compra = restTemplate.postForObject(servicioCompraUrl, compra, Compra.class);
        // Procesar la respuesta como sea necesario
        if (compra == null) return Optional.empty();
        if(compra.getEstado().equals("pagado")) return Optional.of(compras.insert(compra));
        return Optional.of(compra);

    }
}
