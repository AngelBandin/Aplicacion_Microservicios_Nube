package gal.usc.grei.cn.precios.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


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
    @NotEmpty(message = "El método de pago no puede estar Vacio")
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
        return Objects.equals(getId(), compra.getId()) && Objects.equals(getFecha(), compra.getFecha()) && Objects.equals(getSimbolo(), compra.getSimbolo()) && Objects.equals(getVolumen(), compra.getVolumen()) && Objects.equals(getUnidad(), compra.getUnidad()) && Objects.equals(getTotal(), compra.getTotal()) && Objects.equals(getEstado(), compra.getEstado()) && Objects.equals(getMetodoPago(), compra.getMetodoPago()) && Objects.equals(getNumeroTarjeta(), compra.getNumeroTarjeta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFecha(), getSimbolo(), getVolumen(), getUnidad(), getTotal(), getEstado(), getMetodoPago(), getNumeroTarjeta());
    }

}
