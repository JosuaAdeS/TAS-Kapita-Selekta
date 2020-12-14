/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.repositories;
import com.metrodata.tas.entities.Laporan;
import com.metrodata.tas.entities.Divisi;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface LaporanRespository extends JpaRepository<Laporan, Integer> {
    List<Laporan> findByDivisi_Id(int id);
    List<Laporan> findByUser_Id(String id);
    List<Laporan> findByDivisi_IdAndCurrentStatus_Id(int id, int status);
}
