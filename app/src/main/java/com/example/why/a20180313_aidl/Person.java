package com.example.why.a20180313_aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by WHY on 2018/3/13.
 */

public class Person implements Parcelable {
    private Integer id;
    private String name;
    private String pass;

    public Person(Integer id, String name, String pass){
        super();
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime*result + ((name==null)? 0 : name.hashCode());
        result = prime*result + ((pass==null)? 0 : pass.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
        Person other = (Person) obj;
        if(name==null){
            if(other.name!=null)
                return false;
        }
        else if(!name.equals(other.name))
            return false;
        if(pass==null){
            if(other.pass!=null)
                return false;
        }
        else if(!pass.equals(other.pass))
            return false;

        return true;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in.readInt(),in.readString(),in.readString());
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(pass);
    }
}
