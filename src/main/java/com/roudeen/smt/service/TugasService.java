package com.roudeen.smt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roudeen.smt.model.Tugas;
import com.roudeen.smt.repository.TugasRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TugasService {
    private final TugasRepository tugasRepository;

    public void addTugas(Tugas tugas) {
        tugasRepository.insert(tugas);
    }

    public void updateTugas(Tugas tugas) {
      Tugas savedtugas = tugasRepository.findById(tugas.getId()).orElseThrow(
              () -> new RuntimeException(String.format("Cannot Find tugas by ID %s", tugas.getId())));
      savedtugas.setMataKuliah(tugas.getMataKuliah());
      savedtugas.setDeskripsi(tugas.getDeskripsi());
      savedtugas.setStatus(tugas.getStatus());
      savedtugas.setKategoriPelaksanaan(tugas.getKategoriPelaksanaan());
      savedtugas.setTanggalMasuk(tugas.getTanggalMasuk());
      savedtugas.setTanggal(tugas.getTanggal());

      tugasRepository.save(tugas);
  }

    public List<Tugas>getAllTugas() {
		  return tugasRepository.findAll();
	  }

    public Tugas getTugasById(String id) {
      return tugasRepository.findById(id).get();
    }

    public void deleteTugasById(String id) {
      tugasRepository.deleteById(id);	
    }
}
