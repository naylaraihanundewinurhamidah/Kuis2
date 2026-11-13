import java.util.Scanner;

public class Kuis27ney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Jumlah pelanggan hari ini: ");
        int n = sc.nextInt();
        double totalBerat = 0;
        int totalBiaya = 0;
        int nim2 = 41;
        int kapasitas = (nim2 % 10) + 10;

        for (int i = 0; i < n; i++) {
            System.out.print("Masukan nim terakhir pelanggan ke-" + (i + 1) + ": ");
            int nim = sc.nextInt();
            if (nim == nim2){
                kapasitas = (nim % 10) + 10;
            }

            System.out.println("Kapasitas cucian pelanggan ke-" + (i + 1) + " adalah " + kapasitas + " kg");

            System.out.print("Berat cucian pelanggan ke-" + (i + 1) + " (kg): ");
            int berat = sc.nextInt();

            if (berat > kapasitas) {
                System.out.println("Berat cucian melebihi kapasitas. Ulangi!");
                i--;
                continue;
            }

            // Tarif: sampai 3 kg Rp 15000 (flat), lebih dari 3 kg ditambah Rp 4000 per kg kelebihannya
            int biaya;
            if (berat <= 3) {
                biaya = 15000;
                if (berat < 1 || berat > 20) {
                    System.out.println("Input tidak valid. Ulangi!");
                    i--;
                    continue;
                    }
            } else {
                biaya = 15000 + (berat - 3) * 4000;
            }
            totalBiaya += biaya;
            totalBerat += berat;
            System.out.println("    Biaya: Rp " + biaya);
        }

        double rataBerat = totalBerat / n;
        System.out.println("=== REKAP HARIAN ===");
        System.out.println("Total pemasukan : Rp " + totalBiaya);
        System.out.println("Rata-rata berat : " + rataBerat + " kg");
        System.out.println("Biaya tertinggi : Rp " + (totalBiaya / n));
        System.out.println("Jumlah pelanggan yang terkena tarif lebih dari 3 kg: " + (int) (totalBerat / 3));

        sc.close();
    }
}
