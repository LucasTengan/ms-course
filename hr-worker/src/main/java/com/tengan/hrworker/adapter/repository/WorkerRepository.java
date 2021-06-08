package com.tengan.hrworker.adapter.repository;

import com.tengan.hrworker.domain.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
