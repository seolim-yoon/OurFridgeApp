package com.example.ourfridgeapp.util

import androidx.annotation.DrawableRes
import com.example.ourfridgeapp.R

enum class CategoryType(
    val id: Int,
    val title: String,
    @DrawableRes val imageRes: Int
) {
    DEFAULT(0, "", R.drawable.category),
    VEGETABLE(1, "야채", R.drawable.vegetable),
    FRUIT(2, "과일", R.drawable.fruits),
    MEAT(3, "고기", R.drawable.meat),
    SEAFOOD(4, "해산물", R.drawable.seafood),
    DIARY_PRODUCT(5, "유제품", R.drawable.diary_food),
    EGG(6, "계란", R.drawable.egg),
    SOURCE(7, "소스류", R.drawable.source),
    KIMCHI(8, "김치", R.drawable.kimchi),
    SIDE_DISH(9, "반찬", R.drawable.banchan),
    MEAL_KIT(10, "밀키트", R.drawable.ingredient),
    FROZEN_FOOD(11, "냉동식품", R.drawable.frozen_food),
    BREAD(12, "빵", R.drawable.bread),
    RICE_CAKE(13, "떡", R.drawable.dango),
    BEAN(14, "콩/두류", R.drawable.tofu),
    HAM(15, "햄", R.drawable.sausages),
    PROCESSED(16, "가공식품", R.drawable.processed),
    DRINK(17, "음료수", R.drawable.drink),
    NOODLE(18, "면류", R.drawable.noodles),
    GRAVY(19, "육수", R.drawable.gravy),
    JAM(20, "잼", R.drawable.jam),
    SNACK(21, "과자", R.drawable.snack),
    ICE_CREAM(22, "아이스크림", R.drawable.ice_cream),
    POWDER(23, "가루", R.drawable.flour),
    SUPPLEMENT(24, "영양제", R.drawable.vitamins),
    CAN(25, "통조림", R.drawable.canned),
    MSG(26, "조미료", R.drawable.msg),
    INSTANT(27, "즉석식품", R.drawable.burger),
    ETC(28, "기타", R.drawable.more),
    PLUS(29, "",  R.drawable.add);

    companion object {
        fun fromValueByString(value: String): CategoryType {
            return entries.find { it.title == value } ?: VEGETABLE
        }
    }

}