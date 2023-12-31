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
    private String Estado;
    private String metodoPago;
    private String numeroTarjeta;
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

    public String getEstado() {
        return Estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
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

    public Compra setEstado(String estado) {
        Estado = estado;
        return this;
    }

    public Compra setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
        return this;
    }

    public Compra setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
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
        if (!getTotal().equals(compra.getTotal())) return false;
        if (getEstado() != null ? !getEstado().equals(compra.getEstado()) : compra.getEstado() != null) return false;
        if (getMetodoPago() != null ? !getMetodoPago().equals(compra.getMetodoPago()) : compra.getMetodoPago() != null)
            return false;
        return getNumeroTarjeta() != null ? getNumeroTarjeta().equals(compra.getNumeroTarjeta()) : compra.getNumeroTarjeta() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getFecha() != null ? getFecha().hashCode() : 0);
        result = 31 * result + getSimbolo().hashCode();
        result = 31 * result + getVolumen().hashCode();
        result = 31 * result + getUnidad().hashCode();
        result = 31 * result + getTotal().hashCode();
        result = 31 * result + (getEstado() != null ? getEstado().hashCode() : 0);
        result = 31 * result + (getMetodoPago() != null ? getMetodoPago().hashCode() : 0);
        result = 31 * result + (getNumeroTarjeta() != null ? getNumeroTarjeta().hashCode() : 0);
        return result;
    }
}
