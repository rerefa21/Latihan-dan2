/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum4;

/**
 *
 * @author anindya
 */

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
    class Akun {
        private String nama;
        private double saldo;

        public Akun(String nama, double saldo) {
            this.nama  = nama;
            this.saldo = saldo;
        }

        public void bayar(double jumlah) throws InsufficientBalanceException {
            if (jumlah <= 0) {
                throw new IllegalArgumentException("Jumlah harus lebih dari 0");
            }
            if (jumlah > saldo) {
                throw new InsufficientBalanceException(
                    "Saldo tidak cukup! Saldo: Rp" + saldo +
                    ", Tagihan: Rp" + jumlah
                );
            }
            saldo -= jumlah;
            System.out.println("Pembayaran Rp" + jumlah +
                " berhasil. Sisa saldo: Rp" + saldo);
        }

        public String getNama() { return nama; }
    }

    public class AplikasiPembayaran {

        static void prosesTransaksi(Akun akun, String inputJumlah) {
            try {
                double jumlah = Double.parseDouble(inputJumlah); 
                akun.bayar(jumlah);                               
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid: '" + inputJumlah +
                    "' bukan angka.");
            } catch (InsufficientBalanceException e) {
                System.out.println("Transaksi gagal: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("--- Proses transaksi selesai ---");
            }
        }

        public static void main(String[] args) {
            Akun akun = new Akun("Rere", 500000);

            System.out.println("=== Aplikasi Pembayaran ===");
            System.out.println("Akun: " + akun.getNama());

            System.out.println("\n[1] Bayar Rp150000");
            prosesTransaksi(akun, "150000");

            System.out.println("\n[2] Bayar Rp400000");
            prosesTransaksi(akun, "400000");

            System.out.println("\n[3] Bayar 'seratus'");
            prosesTransaksi(akun, "seratus");
        }
    }

