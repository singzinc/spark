package com.singoplayground.application;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SqlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		// config the dpark session
		SparkSession spark = SparkSession
				  .builder()
				  .master("local")
				  .appName("Java Spark SQL basic example")
				  //.config("spark.some.config.option", "some-value")
				  .getOrCreate();
		
		
		System.out.println("------ start -------");
		Dataset<Row> result1 = spark.read().text("src/main/resources/data/compare/a.txt");
		Dataset<Row> result2 = spark.read().text("src/main/resources/data/compare/b.txt");

		System.out.println("------ start -------2");
		
		
		result1 = result1.withColumn("test",result1.col("value").substr(0, 5));
		result1 = result1.withColumn("test2",result1.col("value").substr(5, 5)); 
		
		result2 = result2.withColumn("test",result2.col("value").substr(0, 5));
		result2 = result2.withColumn("test2",result2.col("value").substr(5, 5)); 
		
		result1.show();
		result2.show();
		try{
			result1.createTempView("result1_view");
			result2.createTempView("result2_view");
			
			Dataset<Row> sqlDF = spark.sql("SELECT * FROM result1_view v1 full outer join result2_view v2 on v1.test = v2.test" );
			sqlDF.show();
			
			
		}catch(Exception e){
			
		}
		
		System.out.println("------ End ---------");
		spark.close();

	}

}
