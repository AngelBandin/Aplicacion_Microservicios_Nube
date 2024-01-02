package gal.usc.grei.cn.precios.fachada;

import gal.usc.grei.cn.precios.modelo.Compra;
import gal.usc.grei.cn.precios.repositorio.CompraRepositorio;
import gal.usc.grei.cn.precios.servicio.ServicioPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompraFachada {

    private final CompraRepositorio compras;
    private final ServicioPago servicioPago;
    /*
     * Constructor de la clase
     * @param compras Referencia al CompraRepositorio
     */
    @Autowired
    public CompraFachada(CompraRepositorio compras, ServicioPago servicioPago) {
        this.compras = compras;
        this.servicioPago = servicioPago;
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
    public Optional<Compra> create(Compra compra) {

        try {
            // Intentar procesar el pago
            //Comprobamos que la película haya llegado sin un id:
            if ((compra.getId() == null || compra.getId().isEmpty()) && compra.getNumeroTarjeta().length()==19){
                if(servicioPago.procesarPago(compra)) {
                    compra.setEstado("pagado");
                    return Optional.of(compras.insert(compra));
                } else {
                    compra.setEstado("fallido");
                    return Optional.of(compras.insert(compra));
                }
            }
            else {
                return Optional.empty();
            }

        } catch (Exception e) {
            // Manejar excepciones y establecer el estado de la orden en caso de error
            compra.setEstado("error_procesamiento");
            return Optional.of(compras.insert(compra));
            // Puedes registrar la excepción o realizar otras acciones necesarias.
            //throw new RuntimeException("Error al procesar la compra", e);
        }
    }
}
