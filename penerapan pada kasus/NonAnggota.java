import java.math.BigDecimal;

public class NonAnggota extends Pelanggan {
    public NonAnggota(String id, String nama) {
        super(id, nama);
    }

    @Override
    public BigDecimal hitungDiskon(BigDecimal subtotal) {
        return BigDecimal.ZERO;  
    }
}
