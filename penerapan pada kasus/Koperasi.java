import java.util.Collection;                       
import java.util.HashMap;                         
import java.util.Map;                           

public class Koperasi {                            
    public static final String NAMA = "Koperasi Sejahtera";   
    private final Map<String, Anggota> anggotaMap = new HashMap<>(); // Map idAnggota -> Anggota, final = referensi Map tak berubah
    private final Map<String, Barang> barangMap  = new HashMap<>();  // Map kodeBarang -> Barang, final = referensi Map tak berubah

    public void tambahAnggota(Anggota a) { anggotaMap.put(a.getId(), a); } // Simpan/replace anggota berdasarkan id sebagai key
    public Anggota cariAnggota(String id) { return anggotaMap.get(id); }   // Ambil anggota by id (null jika tidak ada)
    public Collection<Anggota> semuaAnggota() { return anggotaMap.values(); } // Kembalikan view semua objek Anggota

    public void tambahBarang(Barang b) { barangMap.put(b.getKode(), b); }  // Simpan/replace barang berdasarkan kode sebagai key
    public Barang cariBarang(String kode) { return barangMap.get(kode); }  // Ambil barang by kode (null jika tidak ada)
    public Collection<Barang> semuaBarang() { return barangMap.values(); } // Kembalikan view semua objek Barang
}
