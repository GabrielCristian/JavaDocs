package ro.teamnet.zth.appl.service.impl;

import ro.teamnet.zth.api.annotations.MyService;
import ro.teamnet.zth.appl.dao.JobDao;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.service.JobService;

import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
@MyService
public class JobServiceImpl implements JobService {
    JobDao jobs = new JobDao();
    @Override
    public List<Job> findAllJobs () {

        return jobs.getAllJobs();
    }
    @Override
    public Job findOneJob(String id) {
        return jobs.getJobById(id);
    }

    @Override
    public void deleteOneJob(String id) {
        jobs.deleteJob(jobs.getJobById(id));
    }
}
