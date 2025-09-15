import java.math.BigDecimal;                           // Impor BigDecimal untuk harga (lebih presisi daripada double)

public class Barang {                                  // Deklarasi kelas publik Barang
    private final String kode;                         // Field kode barang, final (tidak bisa diubah setelah dibuat)
    private String nama;                               // Nama barang (bisa diubah)
    private BigDecimal harga;                          // Harga barang (pakai BigDecimal)
    private int stok;                                  // Stok barang dalam unit (int)

    public Barang(String kode, String nama, BigDecimal harga, int stok) {
        this.kode = kode;                              // Isi field kode dari parameter konstruktor
        this.nama = nama;                              // Isi field nama
        this.harga = harga;                            // Isi field harga
        this.stok = stok;                              // Isi field stok
    }

    public String getKode() { return kode; }           // Getter untuk kode (tidak ada setter karena final)
    public String getNama() { return nama; }           // Getter untuk nama
    public void setNama(String nama) { this.nama = nama; } // Setter untuk ubah nama
    public BigDecimal getHarga() { return harga; }     // Getter untuk harga
    public void setHarga(BigDecimal harga) { this.harga = harga; } // Setter untuk ubah harga
    public int getStok() { return stok; }              // Getter untuk stok
    public void setStok(int stok) { this.stok = stok; } // Setter untuk ubah stok secara langsung

    public void kurangiStok(int qty) {                 // Method untuk mengurangi stok saat barang terjual
        if (qty <= 0)                                  // Jika qty <= 0
            throw new IllegalArgumentException("Qty harus > 0"); // Lempar error karena tidak logis
        if (qty > stok)                                // Jika qty melebihi stok tersedia
            throw new IllegalStateException("Stok tidak cukup"); // Lempar error stok kurang
        stok -= qty;                                   // Jika valid, kurangi stok dengan qty
    }
}
