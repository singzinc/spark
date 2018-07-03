package com.singoplayground.application;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

import scala.Tuple2;

import org.apache.spark.api.java.JavaRDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;

public class RDDApplication {

	public static void main(String[] args) {

		System.out.println("this is my first app");
		// Create a SparkContext to initialize
		// Create a SparkContext to initialize
		SparkConf conf = new SparkConf().setMaster("local").setAppName("Word Count");

		// Create a Java version of the Spark Context
		JavaSparkContext sc = new JavaSparkContext(conf);

		// Load the text into a Spark RDD, which is a distributed representation
		// of each line of text
		JavaRDD<String> textFile = sc.textFile("src/main/resources/data/text.txt");
		
		
		wordCountMethod1(textFile);
		
		wordCountMethod2(textFile);
	    
		System.out.println("end of the application ");

	}
	
	
	public static void wordCountMethod1(JavaRDD<String> textFile){
		

		JavaRDD<String> obj1 = textFile.flatMap(l -> {
			ArrayList<String> al = new ArrayList();
			String[] str = l.split(" ");
			for (int i = 0; i < str.length; i++) {
				al.add(str[i]);
			}
			return al.iterator();
		});
		System.out.println(obj1.count());

		obj1.foreach(p -> System.out.println(p));
		
		obj1.saveAsTextFile("src/main/resources/counts.txt");
	
		
	}

	
	
	public static void wordCountMethod2(JavaRDD<String> textFile){
		
		System.out.println("this is method 2");
		// convert each line into a collection of words
	    JavaRDD<String> words = textFile.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
		
	    System.out.println("total number of word : " + words.count());
	    words.foreach(x -> System.out.println(x));
	    
	    
	    JavaPairRDD<String, Integer> wordCounts = words.mapToPair(s -> new Tuple2<>(s, 1))
	    	    .reduceByKey((i1, i2) -> i1 + i2);
	    
	    // sort by key 
	    
	    
	   
		wordCounts.sortByKey(true).saveAsTextFile("src/main/resources/counts2.txt");
	}
	
	

	
}
