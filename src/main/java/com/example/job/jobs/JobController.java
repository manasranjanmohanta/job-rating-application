package com.example.job.jobs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // GET /jobs: Get all jobs
    // GET {base_url}/jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> allJobs = jobService.getAllJobs();
        if (!allJobs.isEmpty()) {
            return new ResponseEntity<>(allJobs, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // GET /jobs/{id}: Get a specific job by ID
    // GET {base_url}/jobs/1
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    // POST /jobs: Create a new job (request body should contain the job details)
    // POST {base_url}/jobs
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        String response = jobService.createJob(job);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // DELETE /jobs/{id}: Delete a specific job by ID
    // DELETE {base_url}/jobs/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted) {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT /jobs/{id}: Update a specific job by ID (request body should contain the updated job details)
    // PUT {base_url}/jobs/1
    @PutMapping("{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job) {
        boolean updated = jobService.updateJobById(id, job);
        if (updated) {
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // GET /jobs/{id}/company: Get the company associated with a specific job by ID
    // GET {base_url}/jobs/1/company
}
