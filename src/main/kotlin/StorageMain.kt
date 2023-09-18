class StorageMain {
    private val checkText = CheckText()
    private val storage = mutableMapOf<Int, Archive>() // хранилище
    var currentArchive  = 0 // выбранный элемент

    fun createArchive(){
        println("Введите название архива:")
        val nameArchive = checkText.getTextUser()
        storage.put(storage.size + 1, Archive(nameArchive))
        println("Архив '$nameArchive' создан!")
    }

    fun createNotes(){
        println("Введите имя заметки:")
        val nameNotes = checkText.getTextUser()
        println("Введите описание заметки:")
        val descriptionNotes = checkText.getTextUser()
        storage[currentArchive]!!.content.put(storage[currentArchive]!!.content.size + 1, Note(nameNotes, descriptionNotes))

    }
    //содержание хранилища
    fun readStorage(){
        storage.forEach{ (key, values) ->
            println("$key. ${values.name}")}

    }
    //заметки архива
    fun readArchive(){
        if(storage[currentArchive]!!.content.isEmpty()){
            return
        }else{
            storage[currentArchive]!!.content.forEach{ (key, value) -> println("$key. ${value.name}") }
        }
    }

    fun menuMain(){
        val menuBoolean = true
        while (menuBoolean){
            println("Введите команду:")
            println("0 - создать архив\n1 - открыть архив\n2 - выход")
            when(checkText.commandCheck(2)){
                0 -> createArchive()
                1 -> if (storage.isEmpty()) println("Список архивов пуст") else menuArchive()
                2 -> break
            }
        }


    }
    fun menuArchive(){
        if (storage.size == 1){
            currentArchive = 1
        }else{
            println("Выберите архив:")
            readStorage()
            currentArchive = checkText.commandCheck(storage.size)

        }
        val menuBoolean = true
        while (menuBoolean){
            println("Введите команду:")
            println("0 - создать заметку\n1 - открыть заметку\n2 - выход")
            when(checkText.commandCheck(2)){
                0 -> createNotes()
                1 -> if (storage[currentArchive]!!.content.isEmpty()) println("Заметки не найдены") else menuNotes()
                2 -> {currentArchive = 0
                    return}

            }
        }
    }
    fun menuNotes(){
        if (storage[currentArchive]!!.content.size == 1){
            println(storage[currentArchive]!!.content[1].toString())
        }else{
            println("Выберите заметку")
            storage[currentArchive]!!.content.forEach{ (key, values) -> println("$key. ${values.name}") }
            val nums = checkText.commandCheck(storage[currentArchive]!!.content.size)
            println(storage[currentArchive]!!.content[nums].toString())
        }
    }
}