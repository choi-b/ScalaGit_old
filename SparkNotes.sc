object SparkNotes {
println("Welcome to the 'SparkNotes' worksheet :)")
                                                  //> Welcome to the 'SparkNotes' worksheet :)
// What is Spark??

// A fast and general engine for large-scale data processing
// Run programs up to 100x faster than Hadoop MapReduce in memory, or 10x faster on disk.
// Spark uses the DAG Engine (directed acyclic graph) optimizes workflows.

// Examples of companies that use spark.
// Amazon, Ebay, NASA JPL, Groupon, TripAdviser, Yahoo, etc..

// Code in Python, Java, or Scala.
// Built around one main concept: the Resilient Distributed Dataset (RDD) - abstraction over a large set of data.

// Components of Spark
// - Spark Core
// - Spark Streaming - can run forever, update data as it comes.
// - Spark SQL - run SQL-like queries.
// - MLLib - machine learning operations (a little limited today, but getting better)
// - GraphX - graph theory, graph networks.

// Why Scala?
// - Spark itself is written in Scala
// - Scala's functional programming model is a good fit for distributed processing.
// - Gives you fast performance (Scala compiles to Java bytecode)
// - Less code & boilerplate stuff than Java
// - Python is slow in comparison.
// - Scala code in Spark looks a LOT like Python code.
 
// The RDD's (Resilient Distributed Dataset)
// - The Sparkcontext, '.sc', create the RDD for you.
// - Once you have an RDD, you can TRANSFORM, or APPLY AN ACTION to it.
// 				1) Transformation (map, flatmap, filter, distinct, sample, set operations, etc.)
// 	 			2) Actions (collect, count, countByValue, take, top, reduce, etc.)


                             
}