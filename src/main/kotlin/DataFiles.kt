data class Note(val name: String, val description: String) {
    override fun toString(): String {
        return "Имя заметки: $name\nСодержание заметки: $description\n"
    }
}

data class Archive(val name: String) {
    val content = mutableMapOf<Int, Note>()
}