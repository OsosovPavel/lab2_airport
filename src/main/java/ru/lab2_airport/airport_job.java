package ru.lab2_airport;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;








public class airport_job {
    public static void main(String[] args) throws Exception{
        if(args.length != 3){
            System.exit(-1);
        }
      Job job =Job.getIntances();
      job.setJarByClass(FlightJob.class)

    }





}
