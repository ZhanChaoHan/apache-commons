package com.jachs.commons.vo;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Human {
    private String h_name;
    private int h_age;
    
    public Human () {
        super ();
    }
    public Human ( String h_name, int h_age ) {
        super ();
        this.h_name = h_name;
        this.h_age = h_age;
    }
    public String getH_name () {
        return h_name;
    }
    public void setH_name ( String h_name ) {
        this.h_name = h_name;
    }
    public int getH_age () {
        return h_age;
    }
    public void setH_age ( int h_age ) {
        this.h_age = h_age;
    }
    
}
