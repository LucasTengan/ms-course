package com.tengan.hrworker.application;

import com.tengan.hrworker.adapter.repository.WorkerRepository;
import com.tengan.hrworker.domain.entities.Worker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> findAll() {
        List<Worker> allWorkers = workerRepository.findAll();

        return allWorkers;
    }

    public Worker findByIdOrThrowException(Long id) {
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Worker nout found"));

        return worker;
    }
}
