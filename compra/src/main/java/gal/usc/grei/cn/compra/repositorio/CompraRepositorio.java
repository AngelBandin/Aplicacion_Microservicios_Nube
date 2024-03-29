package gal.usc.grei.cn.compra.repositorio;

import gal.usc.grei.cn.compra.modelo.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CompraRepositorio extends MongoRepository<Compra, String> {
    @Query(value = "{'symbol': '?0', 'date': '?1'}")
    Optional<Compra> findCompraBySymbolAndDate(String simbolo, String fecha);

}