package com.example.ourfridgeapp.util

enum class SpaceType(
    val id: Int,
    val title: String
) {
    FRIDGE(0, "냉장실"),
    FREEZER(1, "냉동실"),
    KIMCHI(2, "김치냉장고"),
    PANTRY(3, "팬트리");

    companion object {
        fun fromValueByString(value: String): SpaceType {
            return SpaceType.entries.find { it.title == value } ?: FRIDGE
        }

        fun fromValueById(id: Int): SpaceType {
            return SpaceType.entries.find { it.id == id } ?: FRIDGE
        }
    }
}