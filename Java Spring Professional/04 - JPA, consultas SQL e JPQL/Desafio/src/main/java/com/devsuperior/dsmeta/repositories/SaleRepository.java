package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsmeta.dto.SalesReportDTO(obj.id, obj.date, obj.amount, obj.seller.name) "
            + "FROM Sale obj "
            + "WHERE obj.date BETWEEN :startDate AND :endDate "
            + "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :sellerName,'%'))")
    Page<SalesReportDTO> showReport (LocalDate startDate, LocalDate endDate, String sellerName, Pageable pageable);

    @Query("SELECT new com.devsuperior.dsmeta.dto.SalesSummaryDTO(obj.seller.name, SUM(obj.amount)) "
            + "FROM Sale obj "
            + "WHERE obj.date BETWEEN :startDate AND :endDate "
            + "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :sellerName,'%')) "
            + "GROUP BY obj.seller.name")
    Page<SalesSummaryDTO> showSummary (LocalDate startDate, LocalDate endDate, String sellerName, Pageable pageable);
}
