package gal.usc.grei.cn.precios.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "precios")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Precio {
    @Id
    private String id;
    private String date;
    private String symbol;
    private Float open;
    private Float close;
    private Float low;
    private Float high;
    private Long volume;

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getSymbol() {
        return symbol;
    }

    public Float getOpen() {
        return open;
    }

    public Float getClose() {
        return close;
    }

    public Float getLow() {
        return low;
    }

    public Float getHigh() {
        return high;
    }

    public Long getVolume() {
        return volume;
    }

    public Precio setId(String id) {
        this.id = id;
        return this;
    }

    public Precio setDate(String date) {
        this.date = date;
        return this;
    }

    public Precio setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public Precio setOpen(Float open) {
        this.open = open;
        return this;
    }

    public Precio setClose(Float close) {
        this.close = close;
        return this;
    }

    public Precio setLow(Float low) {
        this.low = low;
        return this;
    }

    public Precio setHigh(Float high) {
        this.high = high;
        return this;
    }

    public Precio setVolume(Long volume) {
        this.volume = volume;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Precio precio)) return false;

        if (!getId().equals(precio.getId())) return false;
        if (!getDate().equals(precio.getDate())) return false;
        if (!getSymbol().equals(precio.getSymbol())) return false;
        if (!getOpen().equals(precio.getOpen())) return false;
        if (!getClose().equals(precio.getClose())) return false;
        if (!getLow().equals(precio.getLow())) return false;
        if (!getHigh().equals(precio.getHigh())) return false;
        return getVolume().equals(precio.getVolume());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getSymbol().hashCode();
        result = 31 * result + getOpen().hashCode();
        result = 31 * result + getClose().hashCode();
        result = 31 * result + getLow().hashCode();
        result = 31 * result + getHigh().hashCode();
        result = 31 * result + getVolume().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Precio{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", symbol='" + symbol + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", low=" + low +
                ", high=" + high +
                ", volume=" + volume +
                '}';
    }
}
