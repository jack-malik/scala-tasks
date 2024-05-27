package com.primechannel.scala.tasks.inheritance

/**
 *
 * @project scala-tasks
 * @autor Jack Malik - Primechannel Corporation Ltd.
 *        Date: 5/25/2024
 *        Time: 8:27 PM    
 *
 * */

trait T1
trait T2
class P1
class P2

class C1 extends T1
class C2 extends T1 with T2
class C3 extends T2 with T1
class C4 extends P1 with T1
// class Mixer extends P2 with P1 <---- two classes extending
// class Mixer extends T1 with P2 <----- trait followed by class
