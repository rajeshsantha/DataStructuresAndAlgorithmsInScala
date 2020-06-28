package com.concept.scala.leetcode_30days_challenge_June2020

import java.util.concurrent.ConcurrentHashMap

import scala.collection.mutable

/** **
  * Day 28
  *
  * @todo Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
  *
  *       Note:
  *
  *       1.If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
  *       2.All airports are represented by three capital letters (IATA code).
  *       3.You may assume all tickets form at least one valid itinerary.
  *       4.One must use all the tickets once and only once.
  * @example Example 1:
  *
  *          Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
  *          Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
  *          Example 2:
  *
  *          Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
  *          Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
  *          Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
  *          But it is larger in lexical order.
  * @see https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/
  *      OR
  *      https://leetcode.com/problems/reconstruct-itinerary/
  *
  *
  */
object ReconstructItinerary {
  def main(args: Array[String]): Unit = {
    val tickets: List[List[String]] = List(List("MUC", "LHR"), List("JFK", "MUC"), List("SFO", "SJC"), List("LHR", "SFO"))
    val tickets2: List[List[String]] = List(List("JFK", "SFO"), List("JFK", "ATL"), List("SFO", "ATL"), List("ATL", "JFK"), List("ATL", "SFO"))

    println(findItineraryByDFSTest(tickets).mkString("[", ",", "]"))
    println(findItineraryByDFSTest(tickets2).mkString("[", ",", "]"))

    //final solution
    println(findItineraryByDFS(tickets).mkString("[", ",", "]"))
    println(findItineraryByDFS(tickets2).mkString("[", ",", "]"))
  }

  def findItineraryByDFSTest(tickets: List[List[String]]): List[String] = {
    val hashmap = scala.collection.mutable.HashMap[String, String]()
    val result = mutable.ListBuffer[String]()

    tickets.foreach { x =>
      if (hashmap.contains(x.head)) {
        if (x.last < x.head) hashmap.update(x.head, x.last)
      } else hashmap.put(x.head, x.last)
    }
    /*
     JFK already present with ATL
     ATL already present with SFO
    [JFK,SFO,ATL,JFK,SFO,ATL]
    ["JFK","ATL","JFK","SFO","ATL","SFO"]
     */
    val ticketsnew = tickets.map(_.head).sorted
    var current = "JFK"
    result.append(current)
    for (i <- ticketsnew.indices) {
      current = hashmap(current)
      result.append(current)
    }
    result.toList
  }
  def helper(graph: Map[String, List[String]], startingAirport: String): (Map[String, List[String]], List[String]) = {
    graph.get(startingAirport) match {
      case None => (graph, List(startingAirport))
      case Some(airport1 :: airport2) => {
        val (newGraph, previousList) = helper(if (airport2.isEmpty) graph - (startingAirport) else graph + (startingAirport -> airport2), airport1)
        val (enrichedGraph, restOfList) = helper(newGraph, startingAirport)
        (enrichedGraph, (restOfList ++ previousList))
      }
      case Some(Nil) => throw new IllegalArgumentException("No element to process")

    }
  }
  //final solution
  def findItineraryByDFS(tickets: List[List[String]]): List[String] =
    helper(tickets.groupBy(_.head).mapValues(t => t.map(_ (1))).map({ case ((key, values)) => (key, values.sorted) }).toMap[String, List[String]], "JFK")._2

}
