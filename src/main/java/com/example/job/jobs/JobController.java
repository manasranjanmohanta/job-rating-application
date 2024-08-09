package com.example.job.jobs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // GET /jobs: Get all jobs
    // GET {base_url}/jobs
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }
    // GET /jobs/{id}: Get a specific job by ID
    // GET {base_url}/jobs/1
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }
    // POST /jobs: Create a new job (request body should contain the job details)
    // POST {base_url}/jobs
    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.createJob(job), HttpStatus.CREATED);
    }
    // DELETE /jobs/{id}: Delete a specific job by ID
    // DELETE {base_url}/jobs/1
    // PUT /jobs/{id}: Update a specific job by ID (request body should contain the updated job details)
    // PUT {base_url}/jobs/1
    // GET /jobs/{id}/company: Get the company associated with a specific job by ID
    // GET {base_url}/jobs/1/company
}
