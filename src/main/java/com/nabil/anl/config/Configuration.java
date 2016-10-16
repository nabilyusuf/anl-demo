package com.nabil.anl.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.nabil.anl.model.DatabaseInfo;

public class Configuration {
	
	
	public static void main(String[] args) {

		createSchema ();
//		
//		insertSampleData();
		
	//	setpropertyfile("dbpassword" ,"jdbc:h2:D:/Development/DataBase/DBFlie/test14");
		
	}
	
	
	
	
	
	
	
	public static void setpropertyfile(String key , String value){		
		
		
		 
		 try {
			 
		        Properties props = new Properties();
		             
		        
		        File f = new File(Thread.currentThread().getContextClassLoader().getResource("configurationFile.properties").getPath().substring(1));
		      
		        OutputStream out = new FileOutputStream( f ,true);
		        
		    
		        props.put(key, value);
		        props.store(out, "");
		    }
		    catch (Exception e ) {
		        e.printStackTrace();
		    }
	
	}
	
	
	
	
	public static Properties getpropertyfile(){
		Properties props = new Properties();
		try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("configurationFile.properties")) {
		    props.load(resourceStream);
		 
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	
	
	
	public static Properties getScriptfile(){
		Properties props = new Properties();
		try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("script.properties")) {
		    props.load(resourceStream);
		 
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	
	private static void insertSampleData () {
		Properties props=getpropertyfile();
		String dpPath = props.getProperty("dbfilepath");
		String user = props.getProperty("dbuser");
		String pwds = props.getProperty("dbpassword");
		
		String sql= getScriptfile().getProperty("sampledata");
		String url = dpPath+";INIT=SET SCHEMA NABIL";
		System.out.println("createSchema URL "+url);
		
		
    
        
    	try {
			Connection conn = DriverManager.
				    getConnection(url, user, pwds);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
	
	
	
	private static void createSchema () {
		Properties props=getpropertyfile();
		String dpPath = props.getProperty("dbfilepath");
		String user = props.getProperty("dbuser");
		String pwds = props.getProperty("dbpassword");
		String sql= getScriptfile().getProperty("createTableStucture");
		String url = dpPath+";INIT=CREATE SCHEMA IF NOT EXISTS NABIL\\;SET SCHEMA NABIL;\\MV_STORE=FALSE\\;MVCC=FALSE";

		System.out.println("createSchema URL "+url);
		
      
        
    	try {
			Connection conn = DriverManager.
				    getConnection(url, user, pwds);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }







	public static boolean setupDatabaseDatabaseInfo(DatabaseInfo dbinfo) {
		boolean status =false;
		setpropertyfile("dbfilepath" , dbinfo.getDbpath());
		setpropertyfile("dbuser" , dbinfo.getDbuser());
		setpropertyfile("dbpassword" , dbinfo.getDbPassword());
		createSchema();
		insertSampleData ();
		status =true;
		
		return status;
	}







	public static void setresetDatabaseFalse() {
		setpropertyfile("resetDatabase" , "false");
		
	}
	
	
	
}
