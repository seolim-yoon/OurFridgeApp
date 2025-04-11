package com.example.ourfridgeapp.util

import android.content.Context

enum class CategoryType(
    val id: Int,
    val title: String
) {
    DEFAULT(0, ""),
    VEGETABLE(1, "야채"),
    FRUIT(2, "과일"),
    MEET(3, "고기"),
    SEAFOOD(4, "해산물"),
    DIARY_PRODUCT(5, "유제품"),
    EGG(6, "계란"),
    SOURCE(7, "소스류"),
    KIMCHI(8, "김치"),
    SIDE_DISH(9, "반찬"),
    MEAL_KIT(10, "밀키트"),
    FROZEN_FOOD(11, "냉동식품"),
    BREAD(12, "빵"),
    RICE_CAKE(13, "떡"),
    BEAN(14, "콩/두류"),
    HAM(15, "햄"),
    PROCESSED(16, "가공식품"),
    DRINK(17, "음료수"),
    NOODLE(18, "면류"),
    GRAVY(19, "육수"),
    JAM(20, "잼"),
    SNACK(21, "과자"),
    ICE_CREAM(22, "아이스크림"),
    POWDER(23, "가루"),
    SUPPLEMENT(24, "영양제"),
    CAN(25, "통조림"),
    MSG(26, "조미료"),
    INSTANT(27, "즉석식품"),
    ETC(28, "기타"),
    PLUS(29, "");

    companion object {
        fun fromValueByString(value: String): CategoryType {
            return entries.find { it.title == value } ?: VEGETABLE
        }
    }

}