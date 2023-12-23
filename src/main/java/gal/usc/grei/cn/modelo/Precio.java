package gal.usc.grei.cn.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio precio = (Precio) o;
        return Objects.equals(id, precio.id) && Objects.equals(date, precio.date) && Objects.equals(symbol, precio.symbol) && Objects.equals(open, precio.open) && Objects.equals(close, precio.close) && Objects.equals(low, precio.low) && Objects.equals(high, precio.high) && Objects.equals(volume, precio.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, symbol, open, close, low, high, volume);
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
