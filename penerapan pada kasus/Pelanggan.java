import java.math.BigDecimal;

public abstract class Pelanggan {
    private final String id;
    private String nama;

    protected Pelanggan(String id, String nama) {
        this.id = id;            
        this.nama = nama;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    /** Kontrak umum: berapa besar diskon untuk subtotal tertentu */
    public abstract BigDecimal hitungDiskon(BigDecimal subtotal);
}
