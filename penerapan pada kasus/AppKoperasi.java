import java.math.BigDecimal;                                          // Import BigDecimal untuk representasi uang presisi
import java.util.Scanner;                                             // Import Scanner untuk input dari keyboard (CLI)
import java.util.Date;                                                // Import java.util.Date untuk tanggal transaksi (akan dikonversi di Transaksi)

public class AppKoperasi {                                            // Deklarasi kelas utama aplikasi

    private static String uang(BigDecimal v) {                        // Util format uang sederhana (Rupiah manual)
        return "Rp" + v.setScale(2, java.math.RoundingMode.HALF_UP)   // Set 2 desimal dengan pembulatan HALF_UP (standar akuntansi)
                         .toPlainString();                            // Tanpa notasi ilmiah (mis. 1E6), tampilkan angka biasa
    }                                                                 // Tutup method util uang()

    public static void main(String[] args) {                          // Titik masuk program (entry point)
        Scanner in = new Scanner(System.in);                          // Siapkan scanner untuk baca input pengguna
        Koperasi store = seedData();                                  // Inisialisasi storage in-memory + data contoh (anggota & barang)
        System.out.println("Selamat datang di " + Koperasi.NAMA);     // Sapaan awal memakai konstanta nama koperasi

        while (true) {                                                // Loop menu utama (akan break saat pilih "0")
            System.out.println("\n=== MENU KOPERASI ===");            // Header menu (dengan baris kosong untuk rapi)
            System.out.println("1. Lihat daftar anggota");            // Opsi 1: tampilkan seluruh anggota
            System.out.println("2. Lihat daftar barang");             // Opsi 2: tampilkan seluruh barang
            System.out.println("3. Buat transaksi penjualan");        // Opsi 3: mulai proses transaksi
            System.out.println("0. Keluar");                          // Opsi 0: keluar program
            System.out.print("Pilih: ");                              // Prompt input pilihan (tanpa newline)
            String pilih = in.nextLine().trim();                      // Baca satu baris input & trim spasi di kiri/kanan

            switch (pilih) {                                          // Pilih aksi berdasarkan input
                case "1" -> tampilkanAnggota(store);                  // Jika "1": panggil fungsi untuk cetak daftar anggota
                case "2" -> tampilkanBarang(store);                   // Jika "2": panggil fungsi untuk cetak daftar barang
                case "3" -> buatTransaksiInteraktif(store, in);       // Jika "3": jalankan alur transaksi interaktif
                case "0" -> { System.out.println("Bye!"); return; }   // Jika "0": ucapkan selamat tinggal lalu keluar dari main
                default -> System.out.println("Menu tidak dikenali."); // Selain itu: beritahu bahwa menu tidak valid
            }                                                         // Tutup switch
        }                                                             // Tutup while (kembali ke menu)
    }                                                                 // Tutup main()

    private static Koperasi seedData() {                              // Buat data awal agar aplikasi siap demo
        Koperasi store = new Koperasi();                              // Instance penyimpanan sederhana (Map Anggota & Barang)
        store.tambahAnggota(new Anggota("A001", "Ali",  true, new BigDecimal("10")));  // Tambah anggota A001 (aktif, diskon 10%)
        store.tambahAnggota(new Anggota("A002", "Budi", true, new BigDecimal("5")));   // Tambah anggota A002 (aktif, diskon 5%)
        store.tambahBarang(new Barang("P01", "Gula 1kg",   new BigDecimal("15000"), 20));  // Tambah barang P01 stok 20
        store.tambahBarang(new Barang("P02", "Minyak 1L",  new BigDecimal("18000"), 15));  // Tambah barang P02 stok 15
        store.tambahBarang(new Barang("P03", "Mie Instan", new BigDecimal("3500"), 100));  // Tambah barang P03 stok 100
        return store;                                                 // Kembalikan store berisi data awal
    }                                                                 // Tutup seedData()

    private static void tampilkanAnggota(Koperasi store) {            // Cetak daftar seluruh anggota
        System.out.println("=== DAFTAR ANGGOTA ===");                 // Header daftar anggota
        for (Anggota a : store.semuaAnggota()) {                      // Iterasi semua objek Anggota dari Map.values()
            System.out.println(a.getId() + " - " + a.getNama()        // Tampilkan ID dan nama anggota
                    + " (Aktif: " + a.isAktif()                       // Tampilkan status aktif (true/false)
                    + ", Diskon " + a.getDiskonPersen() + "%)");      // Tampilkan diskon persen (dari BigDecimal, tampil apa adanya)
        }                                                             // Tutup for-each
    }                                                                 // Tutup tampilkanAnggota()

    private static void tampilkanBarang(Koperasi store) {             // Cetak daftar seluruh barang
        System.out.println("=== DAFTAR BARANG ===");                  // Header daftar barang
        for (Barang b : store.semuaBarang()) {                        // Iterasi semua objek Barang dari Map.values()
            System.out.println(b.getKode() + " - " + b.getNama()      // Tampilkan kode dan nama barang
                    + " @ " + uang(b.getHarga())                      // Tampilkan harga satuan dalam format "Rp..."
                    + " | Stok: " + b.getStok());                    // Tampilkan stok saat ini
        }                                                             // Tutup for-each
    }                                                                 // Tutup tampilkanBarang()

    private static void buatTransaksiInteraktif(Koperasi store, Scanner in) { // Alur input transaksi via CLI
        System.out.print("ID Anggota (kosong jika non-anggota): ");   // Minta ID anggota (boleh kosong)
        String idA = in.nextLine().trim();                            // Baca input ID dan trim spasi
        Anggota pembeli = idA.isEmpty() ? null : store.cariAnggota(idA); // Jika kosong → non-anggota (null), jika isi → cari di store
        if (!idA.isEmpty() && pembeli == null) {                      // Jika user mengetik ID tapi tidak ditemukan di store
            System.out.println("Anggota tidak ditemukan. Transaksi sebagai non-anggota."); // Info: lanjut sebagai non-anggota
        }                                                             // Tutup if

        Transaksi trx = new Transaksi(                                // Buat objek transaksi baru
                "TRX-" + System.currentTimeMillis(),                  // ID unik berbasis timestamp saat ini
                new Date(),                                           // Tanggal sekarang (java.util.Date)
                pembeli                                               // Referensi anggota (bisa null)
        );                                                            // Tutup pembuatan Transaksi
                                                                       // CATATAN: di konstruktor Transaksi, konversi ke java.sql.Date
                                                                       // sebaiknya: new java.sql.Date(tanggal.getTime()); (jangan cast langsung)

        while (true) {                                                // Loop input item sampai user selesai
            System.out.print("Kode barang (atau 'selesai'): ");       // Prompt kode barang (atau ketik 'selesai')
            String kode = in.nextLine().trim();                       // Baca kode barang
            if (kode.equalsIgnoreCase("selesai")) break;              // Jika 'selesai' → keluar dari loop item

            Barang b = store.cariBarang(kode);                        // Cari barang di store berdasarkan kode
            if (b == null) {                                          // Jika barang tidak ditemukan
                System.out.println("Barang tidak ditemukan.");         // Beri tahu pengguna
                continue;                                             // Lanjut ke iterasi berikutnya (minta kode lagi)
            }                                                         // Tutup if barang null

            System.out.print("Qty: ");                                // Prompt jumlah (kuantitas) yang dibeli
            int qty = Integer.parseInt(in.nextLine().trim());         // Parse input qty menjadi int (bisa lempar NumberFormatException)

            try {                                                     // Blok coba untuk tambah item
                trx.tambahItem(b, qty);                               // Kurangi stok + tambah ItemTransaksi (validasi stok & qty di dalam)
                System.out.println("Ditambahkan: " + b.getNama()      // Konfirmasi berhasil menambah item
                        + " x" + qty);
            } catch (Exception ex) {                                  // Tangkap error (qty <= 0, stok kurang, dsb.)
                System.out.println("Gagal tambah item: "              // Tampilkan pesan kegagalan beserta alasan
                        + ex.getMessage());
            }                                                         // Tutup try-catch
        }                                                             // Tutup loop item

        System.out.println();                                         // Cetak baris kosong untuk kerapian
        System.out.println(trx.cetakStruk());                         // Cetak struk transaksi (item, subtotal, diskon, total)
        tampilkanBarang(store);                                       // Tampilkan stok barang terkini setelah transaksi
    }                                                                 // Tutup buatTransaksiInteraktif()
}                                                                     // Tutup kelas AppKoperasi
