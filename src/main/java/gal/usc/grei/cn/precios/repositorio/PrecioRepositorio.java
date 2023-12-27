package gal.usc.grei.cn.precios.repositorio;

import gal.usc.grei.cn.precios.modelo.Precio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrecioRepositorio extends MongoRepository<Precio, String> {
    @Query(value = "{'symbol': '?0', 'date': '?1'}")
    public Optional<Precio> findPrecioBySymbolAndDate(String simbolo, String fecha);
}