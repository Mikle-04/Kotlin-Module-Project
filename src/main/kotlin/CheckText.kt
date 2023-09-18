import java.util.*

class CheckText {
    fun commandCheck(x: Int): Int { //получать команду
        var check = true
        var command = ""
        while (check) {
            println("Введите цифру от 0 до $x")
            command = Scanner(System.`in`).nextLine()
            if (command.find { !it.isDigit() } != null) {
                println("Не верный символ")
            } else if (command.isEmpty()) {
                println("Вы ввели пустую строку")
            } else if (command.toInt() <= x) {
                check = false
            }
        }
        return command.toInt()
    }

    fun getTextUser(): String {
        var str: String = ""
        while (str == "") {
            str = Scanner(System.`in`).nextLine()
            if (str.isEmpty()){
                println("Пожалуйста, введите текст!")
            }
        }
        return str
    }
}