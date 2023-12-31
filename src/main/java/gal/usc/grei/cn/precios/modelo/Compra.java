package gal.usc.grei.cn.precios.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "precios")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Compra {
    @Id
    private String id;
    private String fecha;
    @NotEmpty(message = "El símbolo no puede ser vacío")
    private String simbolo;
    @NotNull(message = "El volumen no puede ser vacío")
    private Long volumen;
    @NotNull(message = "El precio por unidad no puede ser vacío")
    private Float unidad;
    @NotNull(message = "El precio total no puede ser vacío")
    private Float total;

    public Compra() {
        // Constructor vacío necesario para Spring Data
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public Long getVolumen() {
        return volumen;
    }

    public Float getUnidad() {
        return unidad;
    }

    public Float getTotal() {
        return total;
    }

    public Compra setId(String id) {
        this.id = id;
        return this;
    }

    public Compra setFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public Compra setSimbolo(String simbolo) {
        this.simbolo = simbolo;
        return this;
    }

    public Compra setVolumen(Long volumen) {
        this.volumen = volumen;
        return this;
    }

    public Compra setUnidad(Float unidad) {
        this.unidad = unidad;
        return this;
    }

    public Compra setTotal(Float total) {
        this.total = total;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compra compra)) return false;

        if (!getId().equals(compra.getId())) return false;
        if (getFecha() != null ? !getFecha().equals(compra.getFecha()) : compra.getFecha() != null) return false;
        if (!getSimbolo().equals(compra.getSimbolo())) return false;
        if (!getVolumen().equals(compra.getVolumen())) return false;
        if (!getUnidad().equals(compra.getUnidad())) return false;
        return getTotal().equals(compra.getTotal());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getFecha() != null ? getFecha().hashCode() : 0);
        result = 31 * result + getSimbolo().hashCode();
        result = 31 * result + getVolumen().hashCode();
        result = 31 * result + getUnidad().hashCode();
        result = 31 * result + getTotal().hashCode();
        return result;
    }
}
