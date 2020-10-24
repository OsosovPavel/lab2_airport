package ru.lab2_airport;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;


public class airport_job {
    public static void main(String[] args) throws Exception{
        if(args.length != 3){
            System.exit(-1);
        }
      Job job =Job.getInstance();
      job.setJarByClass(FlightJob.class);
      job.setJobName("JoinJob");
      MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
      MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, NametMapper.class);
    }





}
