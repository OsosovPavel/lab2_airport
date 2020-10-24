package ru.lab2_airport;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class NameMapper extends Mapper<LongWritable, Text, WComparable, Text> {

    @Override
    protected  void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        if(key.get()==0){
            String[] table = value.toString().split("/");
            int destAirportID = Integer.parseInt(table[0]);
            WComparable wComparable = new WComparable(destAirportID,0);
            context.write(wComparable,new Text(table[1]));
        }
    }

}
