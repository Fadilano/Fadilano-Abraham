package myspend;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ModelSpending {
    @Id
    private int id;
    private String tanggal;
    private String deskripsi;
    private int jumlah;

    // Constructor
    public ModelSpending() {}
    public ModelSpending(String tanggal, String deskripsi, int jumlah) {
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.jumlah = jumlah;
    }

    // Getter and Setter methods
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
}
