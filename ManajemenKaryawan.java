/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum4;

/**
 *
 * @author anindya
 */

 import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Tambahkan class ini dulu sebelum ManajemenKaryawan
class Karyawan {
    private String id;
    private String nama;
    private String posisi;

    public Karyawan(String id, String nama, String posisi) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
    }

    public String getId()     { return id; }
    public String getNama()   { return nama; }
    public String getPosisi() { return posisi; }

    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Posisi: " + posisi;
    }
}

public class ManajemenKaryawan {
    public static void main(String[] args) {

       
        ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
        daftarKaryawan.add(new Karyawan("K001", "Andi",  "Manager"));
        daftarKaryawan.add(new Karyawan("K002", "Budi",  "Staff"));
        daftarKaryawan.add(new Karyawan("K003", "Citra", "HR"));

        
        System.out.println("Daftar Karyawan:");
        Iterator<Karyawan> it = daftarKaryawan.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        
        HashMap<String, Karyawan> mapKaryawan = new HashMap<>();
        for (Karyawan k : daftarKaryawan) {
            mapKaryawan.put(k.getId(), k);
        }

        
        System.out.println("\nMencari Karyawan dengan ID 'K002':");
        Karyawan found = mapKaryawan.get("K002");
        System.out.println(found);

        
        System.out.println("\nDaftar Karyawan dari HashMap:");
        for (String idKey : mapKaryawan.keySet()) {
            System.out.println(mapKaryawan.get(idKey));
        }
    }
}
