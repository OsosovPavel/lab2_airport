package ru.lab2_airport;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import java.io.IOException;
import java.util.Iterator;

public class FlightReduce extends Reducer<WComparable,Text, Text, Text> {

    private Text getReduceText(double min, double max, double average) {
        return new Text("Min Delay - " + min + ";Max Delay - " + max + "; Average delay - " + average + ";");
    }

    @Override
    protected void reduce(WComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        int SUM = 0;
        int COUNT = 0;

        Iterator<Text> itr = values.iterator();
        Text name = new Text(itr.next());
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        while (itr.hasNext()) {
            double currentValue = Double.parseDouble(itr.next().toString());
            min = Double.min(min, currentValue);
            max = Double.max(max, currentValue);
            SUM+= currentValue;
            COUNT++;
        }
        if(COUNT>0){
            context.write(name, getReduceText(min,max,SUM/COUNT));
        }
    }
}
