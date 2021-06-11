package com.tengan.hrworker.adapter.resources;

import com.tengan.hrworker.application.WorkerService;
import com.tengan.hrworker.domain.entities.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
@RefreshScope
public class WorkerResource {

    private static final Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    private final Environment environment;
    private final WorkerService workerService;

    public WorkerResource(Environment environment, WorkerService workerService) {
        this.environment = environment;
        this.workerService = workerService;
    }

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG = " + testConfig);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> allWorkers = workerService.findAll();

        return new ResponseEntity<>(allWorkers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = " + environment.getProperty("local.server.port"));

        Worker worker = workerService.findByIdOrThrowException(id);

        return new ResponseEntity<>(worker, HttpStatus.OK);
    }
}
