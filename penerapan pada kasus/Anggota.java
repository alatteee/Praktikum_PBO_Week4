import java.math.BigDecimal;

public class Anggota extends Pelanggan {         
    private boolean aktif;
    private BigDecimal diskonPersen;             

    public Anggota(String id, String nama, boolean aktif, BigDecimal diskonPersen) {
        super(id, nama);                           
        this.aktif = aktif;
        this.diskonPersen = diskonPersen;
    }

    public boolean isAktif() { return aktif; }
    public void setAktif(boolean aktif) { this.aktif = aktif; }
    public BigDecimal getDiskonPersen() { return diskonPersen; }
    public void setDiskonPersen(BigDecimal p) { this.diskonPersen = p; }

    @Override
    public BigDecimal hitungDiskon(BigDecimal subtotal) { 
        if (!aktif || diskonPersen == null) return BigDecimal.ZERO;
        return subtotal.multiply(diskonPersen).divide(new BigDecimal("100"));
    }
}
