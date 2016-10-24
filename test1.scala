import Matrix._
object Test1{


def main(args: Array[String]): Unit = {
         var v = Array(Array(3.0,0.0,-1.0,0.0,0.0),Array(8.0,0.0,0.0,-2.0,0.0),Array(0.0,2.0,-2.0,-1.0,0.0))
         //var v = Array(Array(1.0,2.0),Array(3.0,4.0))
         var p = gaussElim(v)
	 for(k<-0 until  p.length){
	   for(m<-0 until  p(1).length){
	     print(p(k)(m))
	     print(" ")
	   }
	   println(" ")
	 }       
       }

}