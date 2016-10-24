import Math.abs
//Author: Charlie R. Hicks
//Purpose: To Perform Linear Computations
//Date: October 24th, 2016
package object Matrix{
  //returns the solved values from the matrix.
  //Note we could assume T=Double but this is
  //just as efficient and more flexible for later modification
  def getValues[T](arr:Array[Array[T]]):Array[T] = {
    val m = arr.length
    val n = arr(1).length
    arr.map((x:Array[T]) => (x(n-1))).asInstanceOf[Array[T]]
  }
  def swap[T](arr:Array[T],r1:Int,r2:Int){
    val tmp = arr(r1)
    arr(r1) = arr(r2)
    arr(r2) = tmp
  }
  def min(a:Int, b:Int):Int = {
    if(a < b){
      a
    }
    else{
      b
    }
  }
  def gaussElim(b:Array[Array[Double]]):Array[Array[Double]] = {
    var a = b
    //MxN
    //rows
    var m = a.length
    //cols
    var n = a(1).length
    for(k <- 0 until min(m,n)){
      //find pivot
      //find max
      var max = 0.0
      var i_max = k
      for(i <- k until m){
        if(max < abs(a(i)(k))){
          max = abs(a(i)(k));
	  i_max = i;
        }
      }
      if(a(i_max)(k) == 0){
        throw new Exception("Zero Matrix")
      }
      swap(a,k,i_max)
      var div = a(k)(k)
      for(i<-k until n){
        a(k)(i) = a(k)(i)/div
      }
      for(i<- 0 until k){
        var f = a(i)(k) / a(k)(k)
        for(j<- k+1 until n){
          a(i)(j) = a(i)(j) - a(k)(j) * f
        }
        a(i)(k) = 0

      }

      //do for all rows below pivot
      for(i <- k+1 until m){
        var f = a(i)(k) / a(k)(k)
	//do for all remain elements in current row
        for(j <- k+1 until n){
          a(i)(j) = a(i)(j) - a(k)(j) * f
        }
        a(i)(k) = 0
      }

    }
    a
  }

}