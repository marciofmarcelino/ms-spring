package com.marciofm.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciofm.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}