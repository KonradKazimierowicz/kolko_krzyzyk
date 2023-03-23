import kotlin.random.Random

fun main(args: Array<String>) {

   val board = Array(9){0}
   var champ:String? = null
   chceckRows(board)
   checkColumns(board)
   chceckDiagonal(board)


   while(!gameover(board)){

      drawBoard(board)
      getUserMove(board)
      drawBoard(board)
      getCompMove(board)
      drawBoard(board)
      champ = iswinner(board)
   }
   println("\n*********************************\n ${champ}\n*********************************")
}

fun iswinner(board: Array<Int>):String? {
   if(gameover(board) == true){
      if (chceckRows(board) == 3 || checkColumns(board) == 3 || chceckDiagonal(board) == 3) return ("Koniec gry wygrales! :)")
      else if (chceckRows(board) == -3 || checkColumns(board) == -3 || chceckDiagonal(board) == -3) return("Koniec gry przegrales! :(")
      else return("Nikt nie wygral O_O - remis")
   }
   return null
}

fun gameover(board: Array<Int>):Boolean {
   if(0 !in board ||
      chceckRows(board) != null ||
      chceckDiagonal(board) != null ||
      checkColumns(board) != null)
      return true
   return false


}

fun chceckDiagonal(board: Array<Int>):Int? {
   val diagoal1 = board[0] + board[4] + board[8]
   val diagoal2 = board[2] + board[4] + board[6]
   if(diagoal1 == 3 || diagoal1 == -3) return diagoal1
   if(diagoal2 == 3 || diagoal2 == -3) return diagoal2

   return null
}

fun checkColumns(board: Array<Int>):Int? {
   for(i in 0..2){
      val sum = board[0+i] + board[3+i] + board[6+i]
      if(sum == 3 || sum == -3) return sum
   }
   return null
}

fun chceckRows(board: Array<Int>):Int? {
   var sum = 0
   for(i in 0..8){
      if(i % 3 == 0 && i != 0){
         sum = 0
      }
      sum += board[i]

      if (sum == 3 || sum == -3){
         return sum
      }
   }
   return null
}


fun drawBoard(board: Array<Int>){
   for(i in 0 until 9) {
      if (i % 3 == 0) println()
      print("${board[i]} ")
   }
   println()
   print("------")

}

fun getUserMove(board: Array<Int>){
   // 1 2 3
   // 4 5 6
   // 7 8 9
   while (true) {
      print("\n\nPodaj nr pola: ")
      val userNumber = readln().toInt()

      if (userNumber !in 0..8) {
         println("Nie prawidlowa wartosc")
         continue
      }
      else if (board[userNumber] != 0) {
         println("To pole jest zajete")
         continue
      }
      else{
         board[userNumber] = 1
         break
      }
   }

}
fun getCompMove(board: Array<Int>) {
   while(true) {
      val compMove = Random.nextInt(0, 9)
      if (board[compMove] == 0)
         board[compMove] = -1

      else
         continue
      break
   }

}
