package com.tengan.hrworker.adapter.resources;

import com.tengan.hrworker.adapter.repository.WorkerRepository;
import com.tengan.hrworker.application.WorkerService;
import com.tengan.hrworker.domain.entities.Worker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    private final WorkerService workerService;

    public WorkerResource(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> allWorkers = workerService.findAll();

        return new ResponseEntity<>(allWorkers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findAll(@PathVariable Long id) {
        Worker worker = workerService.findByIdOrThrowException(id);

        return new ResponseEntity<>(worker, HttpStatus.OK);
    }
}
