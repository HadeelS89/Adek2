package com.qpros;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Test extends Base {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static void main(String[] args){

//        //Read from csv file
//        String[][] a = ReadWriteHelper.readCSVFile( "test",2,2);
//        System.out.println("Get record using csv reader: " + a[0][0]);
//
//        //Read from xml file
//        String username = ReadWriteHelper.readCredentialsXMLFile("applicantCredentials1","username");
//        System.out.println("Get record using xml reader: " + username);
//
//
//        //Read from xml file
//        String program = ReadWriteHelper.readProgramsXMLFile("program15","title");
//        System.out.println("Get record using xml reader: " + program);



        System.out.println(ActionsHelper.getFutureDate( 1,0,0 ));

    }



}
