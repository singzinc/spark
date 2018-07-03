package com.singoplayground.application;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructType;

import scala.Tuple2;

import org.apache.spark.api.java.JavaRDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;
import static org.apache.spark.sql.functions.col;
public class DatasetApplication {

	public static void main(String[] args) {

		// config the dpark session
		SparkSession spark = SparkSession
				  .builder()
				  .master("local")
				  .appName("Java Spark SQL basic example")
				  //.config("spark.some.config.option", "some-value")
				  .getOrCreate();
		
		//example1ReadTxtFile(spark);
		example1ReadJson(spark);

	}
		
	public static void example1ReadTxtFile(SparkSession spark){
		
	    Dataset<String> logData = spark.read().textFile("src/main/resources/data/text.txt").cache();

	    long numAs = logData.filter(s -> s.contains("a")).count();
	    long numBs = logData.filter(s -> s.contains("b")).count();
	    long numIs = logData.filter(s -> s.contains("i")).count();
	    System.out.println("this is string : " + logData.toString());
	    System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
	    System.out.println("Lines with i: " + numIs);
	    logData.show();
	    String[] columnsName =  logData.columns();
	   
	    System.out.println("columns Name : " + columnsName[0] ) ; 
	    logData.toString();
	    
	    
	    
	    spark.stop();
	
    
	    System.out.println("end of the application ");
		
	}

	public static void example1ReadJson(SparkSession spark){
		
		Dataset<Row> df = spark.read().json("src/main/resources/data/people.json");

		df.show();
		
		df.printSchema();

		df.select("name").show();
		df.select(col("name"), col("age").plus(1)).show();
	    
		
	    spark.stop();
	
    
	    System.out.println("end of the application ");
		
	}

	
}
