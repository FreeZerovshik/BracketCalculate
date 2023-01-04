import java.util.Scanner

fun main(args: Array<String>) {

    val sc = Scanner(System.`in`)
    val inputText = sc.nextLine()

    var tmpStr = ""
    var openBracketsCnt = 0

    var resultCntBrackets = 0
    var resultStr = ""

    inputText.forEach {
        if (it == '(' ) {
            openBracketsCnt +=1
            tmpStr += it
        } else if (it == ')' && openBracketsCnt == 1) {
            resultCntBrackets +=1
            resultStr += "$tmpStr)"

            tmpStr = ""
            openBracketsCnt = 0
        } else if (it == ')' && openBracketsCnt > 1) {
            openBracketsCnt -= 1
            tmpStr += it
            resultCntBrackets +=1
        }
    }

    if (tmpStr.isNotBlank() && openBracketsCnt > 0)  {
        tmpStr = tmpStr.substring(openBracketsCnt)
        resultStr += tmpStr
    }

    if (resultCntBrackets > 0) println("${resultCntBrackets*2} - $resultStr")
    else println(resultCntBrackets)

}