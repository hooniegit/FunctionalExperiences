package com.hooniegit.FunctionalJava.Introduction.Interface;

@FunctionalInterface
public interface GenericToBoolean<T> {
    
    boolean function(T data);

}
