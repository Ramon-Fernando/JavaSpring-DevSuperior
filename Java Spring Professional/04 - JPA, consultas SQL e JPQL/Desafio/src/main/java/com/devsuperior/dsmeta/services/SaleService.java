package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	private SaleRepository repository;

	public SaleService(SaleRepository repository) {
		this.repository = repository;
	}
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SalesReportDTO> showReport(String startDate, String endDate, String sellerName, Pageable pageable) {
		LocalDate end = endDate.isBlank() ? LocalDate.now() : LocalDate.parse(endDate);
		LocalDate start = startDate.isBlank() ? end.minusYears(1L) : LocalDate.parse(startDate);

		return repository.showReport(start, end, sellerName, pageable);
	}

	public Page<SalesSummaryDTO> showSummary(String startDate, String endDate, String sellerName, Pageable pageable) {
		LocalDate end = endDate.isBlank() ? LocalDate.now() : LocalDate.parse(endDate);
		LocalDate start = startDate.isBlank() ? end.minusYears(1L) : LocalDate.parse(startDate);

		return repository.showSummary(start, end, sellerName, pageable);
	}

}
