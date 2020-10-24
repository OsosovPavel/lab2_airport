package ru.lab2_airport;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.WritableComparable;

public class GComparator extends WritableComparable {
    protected GComparator(){
        super(WComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b){
        WComparable wc1 = (WComparable) a;
        WComparable wc2 = (WComparable) b;
        return wc1.compare(wc2);
    }
}
