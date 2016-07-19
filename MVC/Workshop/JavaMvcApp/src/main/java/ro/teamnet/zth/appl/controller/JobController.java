package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;

import ro.teamnet.zth.appl.dao.JobDao;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.service.impl.JobServiceImpl;

import java.util.List;


/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/jobs")
public class JobController {
    @MyRequestMethod(urlPath = "/one")
    public Job getOneJob(@MyRequestParam(name="id") String id) {
        JobDao job = new JobDao();

        return job.getJobById(id);
    }
    @MyRequestMethod(urlPath = "/all")
    public List<Job> getAllJobs() {

        return new JobServiceImpl().findAllJobs();
    }

    @MyRequestMethod(urlPath = "/one", methodType = "DELETE")
    public String deleteOneEmployee(@MyRequestParam(name="id") String id) {
        JobDao emp = new JobDao();
        emp.deleteJob(new JobDao().getJobById(id));
        return "Deleted";
    }
}
