package ru.lab2_airport;

import org.appache.hadoop.io.IntWritable;
import org.appache.hadoop.io.LongWritable;
import org.appache.hadoop.io.Text;
import org.appache.hadoop.mapreduce.Mapper;

import java.io.IOException;






public class FlightMapper extends Mapper<LongWritable, Text, WComparable, Text> {

    private static String SEPARATOR = ",";
    private static int DEST_AIRPORT_ID = 14;

@Override
protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    if(key.get() !=0){
        String[] table = value.toString().split(SEPARATOR);
    }
}


}
