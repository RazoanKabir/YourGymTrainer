package com.example.yourgymtrainer

data class FoodAddViewState(
    val foods: List<Food> = emptyList(),
    val foodName: String = "",
    val foodProtein: String = "",
    val foodFat: String = "",
    val foodCarbs: String = "",
    val foodCalories: String = "",
    val foodAmountInGrams: String = "",
    val isAddingFood: Boolean = false,
    val isHavingFood: Boolean = false,
    val isShowingFilter: Boolean = false,
    val sortType: FoodSortType = FoodSortType.GET_ALL
)
