// IMyAidlInterface.aidl
package com.example.why.a20180313_aidl;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    String getString(String type,int count);
    List getList();
}
