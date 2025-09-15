import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Transaksi {
    private final String id;
    private final Date tanggal;
    private final Pelanggan pembeli;    
    private final List<ItemTransaksi> items;

    public Transaksi(String id, java.util.Date tanggal, Pelanggan pembeli) {
        this.id = id;
        this.tanggal = new Date(tanggal.getTime());
        this.pembeli = pembeli;
        this.items = new ArrayList<>();
    }

    public void tambahItem(Barang barang, int qty) {
        barang.kurangiStok(qty);
        items.add(new ItemTransaksi(barang, qty));
    }

    public BigDecimal getSubtotal() {
        BigDecimal sum = BigDecimal.ZERO;
        for (ItemTransaksi it : items) {
            sum = sum.add(it.getSubtotal());
        }
        return sum;
    }

    public BigDecimal getDiskon() {
        if (pembeli == null) return BigDecimal.ZERO;      
        return pembeli.hitungDiskon(getSubtotal());       
    }

    public BigDecimal getTotal() {
        return getSubtotal()
                .subtract(getDiskon())
                .setScale(0, RoundingMode.HALF_UP);       // pembulatan ke rupiah
    }

    private String uang(BigDecimal x) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id","ID"));
        return nf.format(x);
    }

    public String cetakStruk() {
        StringBuilder sb = new StringBuilder();
        sb.append("====== STRUK ======\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Tanggal: ").append(tanggal).append("\n");
        sb.append("Pelanggan: ").append(pembeli != null ? pembeli.getNama() : "-").append("\n\n");

        for (ItemTransaksi item : items) {
            sb.append(item.getBarang().getNama())
              .append(" x ").append(item.getQty())
              .append(" = ").append(uang(item.getSubtotal()))
              .append("\n");
        }

        sb.append("\nSubtotal: ").append(uang(getSubtotal())).append("\n");
        sb.append("Diskon  : ").append(uang(getDiskon())).append("\n");
        sb.append("TOTAL   : ").append(uang(getTotal())).append("\n");
        sb.append("========================");
        return sb.toString();
    }
}
