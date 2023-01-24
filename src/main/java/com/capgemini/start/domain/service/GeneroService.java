package com.capgemini.start.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.capgemini.start.domain.entity.Genero;
import com.capgemini.start.domain.repository.GeneroRepository;
import com.capgemini.start.domain.service.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

import com.capgemini.start.domain.service.exceptions.ObjectAlreadyExistsException;

@RequiredArgsConstructor
@Service
public class GeneroService extends AbstractService<Genero, Long>{
	
private final GeneroRepository repository;
	
	@Override
	protected JpaRepository<Genero, Long> getRepository() {
		return this.repository;
	}
	
	@Override
	public List<Genero> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Genero findById(Long id){
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Gênero não encontrado"));
	}
	
	@Override
	public Genero insert(Genero Genero) {
		if (this.repository.existsByDescricaoIgnoreCase(Genero.getDescricao())){
			throw new ObjectAlreadyExistsException("Já existe um gênero com esta descrição.");
		}
		Genero.setDataInclusao(new Date());
		return this.repository.save(Genero);
	}
	
	@Override
	public Genero update(Genero Genero) {
		if (this.repository.existsByIdNotAndDescricaoIgnoreCase(Genero.getId(), Genero.getDescricao())) {
			throw new ObjectAlreadyExistsException("Já existe outro gênero com esta descrição.");
		}
		Genero.setDataAlteracao(new Date());
		return this.repository.save(Genero);
	}
	
}



