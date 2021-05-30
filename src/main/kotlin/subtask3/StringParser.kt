package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var arr: Array<String> = arrayOf()
        var counter = 0
        var firstLetterIndex = 0
        var duplicateCount = 0
        var char: CharSequence

        for (y in firstLetterIndex until inputString.length) {
            char = inputString.subSequence(y, y + 1)

            if (inputString.subSequence(y, y + 1) == "<") {
                firstLetterIndex = counter + 1
                for (i in firstLetterIndex until inputString.length) {
                    char = inputString.subSequence(i, i + 1)
                    if (inputString.subSequence(i, i + 1) == "<") {
                        duplicateCount += 1
                    }
                    if (inputString.subSequence(i, i + 1) == ">") {
                        if (duplicateCount == 0) {
                            arr += inputString.substring(firstLetterIndex, i)
                            counter = y
                            duplicateCount = 0
                            break
                        } else duplicateCount -= 1
                    }
                    counter += 1
                }
            } else if (inputString.subSequence(y, y + 1) == "[") {
                firstLetterIndex = counter + 1
                for (i in firstLetterIndex until inputString.length) {
                    if (inputString.subSequence(i, i + 1) == "[") {
                        duplicateCount += 1
                    }
                    if (inputString.subSequence(i, i + 1) == "]") {
                        if (duplicateCount == 0) {
                            arr += inputString.substring(firstLetterIndex, i)
                            counter = y
                            duplicateCount = 0
                            break
                        } else duplicateCount -= 1
                    }
                    counter += 1
                }
            } else if (inputString.subSequence(y, y + 1) == "(") {
                firstLetterIndex = counter + 1
                for (i in firstLetterIndex until inputString.length) {
                    if (inputString.subSequence(i, i + 1) == "(") {
                        duplicateCount += 1
                    }
                    if (inputString.subSequence(i, i + 1) == ")") {
                        if (duplicateCount == 0) {
                            arr += inputString.substring(firstLetterIndex, i)
                            counter = y
                            break
                        } else duplicateCount -= 1
                    }
                    counter += 1
                }
            }
            counter += 1
        }
        println(arr.contentToString())
        return arr
    }
}