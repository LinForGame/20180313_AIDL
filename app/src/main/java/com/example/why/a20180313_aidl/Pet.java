package com.example.why.a20180313_aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by WHY on 2018/3/13.
 */

public class Pet implements Parcelable {
    private String name;
    private double weight;
    protected Pet(Parcel in) {
    }
    public Pet(String name, double weight)
    {
        super();
        this.name = name;
        this.weight = weight;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getWeight()
    {
        return weight;
    }
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    public static final Creator<Pet> CREATOR = new Creator<Pet>() {
        @Override
        public Pet createFromParcel(Parcel in) {
            return new Pet(in.readString()
                    , in.readDouble());
        }

        @Override
        public Pet[] newArray(int size) {
            return new Pet[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //把该对象所包含的数据写到Parcel
        dest.writeString(name);
        dest.writeDouble(weight);
    }
    @Override
    public String toString()
    {
        return "Pet [name=" + name + ", weight=" + weight + "]";
    }
}
