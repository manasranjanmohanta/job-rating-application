package com.example.job.jobs;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    List<Job> jobList = new ArrayList<>();
    private Long jobId = 1L;

    @Override
    public List<Job> getAllJobs() {
        return jobList;
    }

    @Override
    public String createJob(Job job) {
        job.setId(jobId++);
        jobList.add(job);
        return "Job added successfully";
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobList) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobList.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job job) {
        Iterator<Job> iterator = jobList.iterator();
        while (iterator.hasNext()) {
            Job existingJob = iterator.next();
            if (existingJob.getId().equals(id)) {
                existingJob.setTitle(job.getTitle());
                existingJob.setDescription(job.getDescription());
                existingJob.setMinSalary(job.getMinSalary());
                existingJob.setMaxSalary(job.getMaxSalary());
                existingJob.setLocation(job.getLocation());
                return true;
            }
        }
        return false;
    }
}
