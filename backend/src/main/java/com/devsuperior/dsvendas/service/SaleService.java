package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository; // OBS. Para essa situação - trazar os vendedores para ficar em cach, como são poucos não precisar ir buscar toda vez eles.
	
	// método Buscar todos
	@Transactional(readOnly = true)// não precisa fazer loc no banco por ser uma operação de escrita
	public Page<SaleDTO> findAll(Pageable pageable){ // busca página página
		sellerRepository.findAll(); // chamo os vendedores aqui. trago para a memória e a jpa vai armazenar em cache.
		Page<Sale> result = repository.findAll(pageable); 
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
	    return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successtGroupedBySelle(){
	    return repository.successtGroupedBySeller();
	}

}
