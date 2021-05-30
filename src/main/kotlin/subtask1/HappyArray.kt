package subtask1

import java.util.*

class HappyArray {


    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {


        val happyArray = arrayListOf<Int>()

        for (value in sadArray) {
            happyArray.add(value)
        }

        var isArrayHappy = true

        var index: Int


        while (isArrayHappy) {
            isArrayHappy = false
            index = 0
            for (value in happyArray) {

                if (index - 1 >= 0 && index + 1 < happyArray.size) {
                    if (value > happyArray[index - 1] + happyArray[index + 1]) {
                        happyArray[index] = 0
                        isArrayHappy = true
                        index -= 1
                    }
                }
                index += 1
            }
            happyArray.removeIf{it == 0}
        }
        println(happyArray.toString())


        return happyArray.toIntArray()
    }
}