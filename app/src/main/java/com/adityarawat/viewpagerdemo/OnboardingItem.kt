package com.adityarawat.viewpagerdemo

class OnboardingItem {

    var title: String = ""
        get() = field.toUpperCase()  // Custom getter
        set(value) {
            field = value.toLowerCase()  // Custom setter
        }

    var image: Int = 0
        get() {
            println("Getting age")
            return field
        }
        set(value) {
            println("Setting age")
            field = value
        }

    var description: String = ""
        get() = field
        set(value) {
            if (value.isNotBlank()) {
                field = value
            } else {
                println("Invalid email address")
            }
        }

}