package com.roudeen.smt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Document(collection="Daftar_Tugas")
public class Tugas {
    @Id
    private String id;

    private String MataKuliah;
    private String Deskripsi;
    private Status Status;
    private KategoriPelaksanaan KategoriPelaksanaan;
    private String TanggalMasuk;
    private String Tanggal;

}
