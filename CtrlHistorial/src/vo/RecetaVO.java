package vo;

import java.util.Date;

/**
 * @author Alex
 */
public class RecetaVO {
    private int id;
    private int edad;
    private float peso;
    private float talla;
    private String temp;
    private String fc;
    private String rf;
    private String ta;
    private String rx;
    private Date fecha;

    /**
     * not args
     */
    public RecetaVO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        this.talla = talla;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getRf() {
        return rf;
    }

    public void setRf(String rf) {
        this.rf = rf;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public String getRx() {
        return rx;
    }

    public void setRx(String rx) {
        this.rx = rx;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "RecetaVO{" +
                "id=" + id +
                ", edad=" + edad +
                ", peso=" + peso +
                ", talla=" + talla +
                ", temp='" + temp + '\'' +
                ", fc='" + fc + '\'' +
                ", rf='" + rf + '\'' +
                ", ta='" + ta + '\'' +
                ", rx='" + rx + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
