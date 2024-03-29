package gal.usc.grei.cn.serviciopago.repositorio;

import gal.usc.grei.cn.serviciopago.modelo.Precio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;


public interface ServicioRepositorio extends MongoRepository<Precio, String> {
    @Query(value = "{'symbol': '?0', 'date': '?1'}")
    public Optional<Precio> findPrecioBySymbolAndDate(String simbolo, String fecha);
}