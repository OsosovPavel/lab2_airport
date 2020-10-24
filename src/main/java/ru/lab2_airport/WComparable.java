package ru.lab2_airport;

import org.apache.hadoop.io.WritableComparable;
import org.apache.yetus.audience.InterfaceAudience;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class WComparable implements WritableComparable{

    private int airportID;
    private int group;

    WComparable(int airportID, int group){
        this.airportID=airportID;
        this.group=group;
    }

    public int getKey(){
        return this.airportID;
    }

    public  int compare(Object o){
        WComparable wc1=(WComparable) o;
        return Integer.compare(this.airportID, wc1.airportID);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException{
        dataOutput.writeInt(airportID);
        dataOutput.writeInt(group);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException{
        this.airportID=dataInput.readInt();
        this.group=dataInput.readInt();
    }

    @Override
    public int compareTo(Object o){
        WComparable elem=(WComparable) o;
        return this.airportID - elem.airportID > 0 ? 1 :

    }

}
