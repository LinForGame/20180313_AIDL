// IPet.aidl
package com.example.why.a20180313_aidl;
import com.example.why.a20180313_aidl.Pet;
import com.example.why.a20180313_aidl.Person;
// Declare any non-default types here with import statements

interface IPet {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    	// 定义一个Person对象作为传入参数
    	List<Pet> getPets(in Person owner);
}
