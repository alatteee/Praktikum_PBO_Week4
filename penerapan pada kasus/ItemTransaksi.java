import java.math.BigDecimal;                           // Impor BigDecimal untuk hitung subtotal dengan presisi

public class ItemTransaksi {                           // Deklarasi kelas publik ItemTransaksi
    private final Barang barang;                       // Field barang (referensi ke objek Barang), final = tidak bisa diganti
    private final int qty;                             // Field qty (jumlah barang), final = tetap setelah dibuat

    public ItemTransaksi(Barang barang, int qty) {     // Konstruktor untuk membuat item transaksi
        this.barang = barang;                          // Isi field barang dengan parameter konstruktor
        this.qty = qty;                                // Isi field qty dengan parameter konstruktor
    }

    public Barang getBarang() { return barang; }       // Getter untuk mengambil objek barang
    public int getQty() { return qty; }                // Getter untuk jumlah barang

    public BigDecimal getSubtotal() {                  // Method untuk menghitung subtotal
        return barang.getHarga().multiply(             // Ambil harga barang lalu dikali dengan qty
                new BigDecimal(qty));                  // Konversi qty (int) jadi BigDecimal untuk operasi aritmetika
    }
}
