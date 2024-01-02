package gal.usc.grei.cn.precios.controlador;

import gal.usc.grei.cn.precios.fachada.CompraFachada;
import gal.usc.grei.cn.precios.modelo.Compra;
import gal.usc.grei.cn.precios.modelo.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequestMapping("/compras")

public class CompraControlador {

    private final CompraFachada compras;

    @Autowired
    public CompraControlador(CompraFachada compras) {
        this.compras = compras;
    }

    /**
     * Método: POST
     * Url para llegar: /compras
     * Objetivo: insertar la compra que se facilita como parámetro.
     *
     * @param compra los datos de la compra a insertar
     * @return Si la inserción se ha podido hacer, la nueva compra y la URL para acceder a ella.
     */


    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> create(@Valid @RequestBody Compra compra) {
        try {
            Optional<Compra> inserted = compras.create(compra);

            // Manejo explícito para el caso de Optional.empty()
            if (inserted.isPresent()) {
                return ResponseEntity.created(URI.create(
                                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() +
                                        "/compras/" + inserted.get().getId()))
                        .body(inserted.get());
            } else {
                // Manejo explícito para el caso de Optional.empty()
                ErrorResponse errorResponse = new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        "Error en la solicitud de compra.",
                        "/compras"
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
        } catch (Exception e) {
            // Manejar otras excepciones si es necesario
            ErrorResponse errorResponse = new ErrorResponse(
                    LocalDateTime.now(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    "Error interno al procesar la compra.",
                    "/compras"
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);

        }
    }



}
