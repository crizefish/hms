package com.hj.pers.resp;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface BaseRepository<M,I extends Serializable> extends JpaRepository<M, I>{
public Page<M> findAll(Specification<M> spec,Pageable pageable);
}
