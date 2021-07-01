package com.testfw.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.testfw.utils.*;
import com.testfw.basesetup.*;



public class EmployeeAPITest {
	
	String empdetailssheetName = "empdetailssheetName";
	String empsheetName = "EmpInfo";	
	String empdeletesheetName = "empdeletesheetName";
	
	
	 @DataProvider
		public Object[][] getEmployeeTestData(){
		 
			Object data[][] = UtilityHelper.getTestData(empsheetName);
			return data;
		}
	 
 @Test(priority=1, dataProvider="getEmployeeTestData")
 public void getEmployeeDetails(String URL ,String methodName){
 	
 	 System.out.println(URL);
 	 System.out.println(methodName);
       given().
           get(URL + "/+methodName+").
       then().
           statusCode(200);
 }
	
    
    @DataProvider
	public Object[][] getEmployeeDetailsTestData(){    	
		Object data[][] = UtilityHelper.getTestData(empdetailssheetName);
		return data;
	}

    @Test(priority=2, dataProvider="getEmployeeDetailsTestData")
    public void getEmployeeDetailsById(String URL ,String methodName,String empID ){
     System.out.println(URL);
   	 System.out.println(methodName);
   	 
        given().
                get(URL + "/+methodName+/+empID+").
                then().
                statusCode(200).
                body("message", equalTo("Successfully! Record has been fetched."));
    }
    
    @DataProvider
   	public Object[][] getDeleteEmployeeTestData(){
   		Object data[][] = UtilityHelper.getTestData(empdeletesheetName);
   		return data;
   	}

    @Test(priority=3, dataProvider="getDeleteEmployeeTestData")
    public void deleteEmployee(String URL ,String methodName,String empID ){
        given().
                delete(URL + "/+methodName+/+empID+").
                then().
                    statusCode(200).
                    body("message", equalTo("Successfully! Record has been deleted"));

    }

}
