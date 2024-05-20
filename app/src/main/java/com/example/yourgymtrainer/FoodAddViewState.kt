package com.example.yourgymtrainer

data class FoodAddViewState(
    val foods: List<Food> = emptyList(),
    val foodName: String = "",
    val foodProtein: Int = 0,
    val foodFat: Int = 0,
    val foodCarbs: Int = 0,
    val foodCalories: Int = 0,
    val foodAmountInGrams: Int = 0,
    val isAddingFood: Boolean = false,
    val isHavingFood: Boolean = false,
    val isShowingFilter: Boolean = false,
    val sortType: FoodSortType = FoodSortType.GET_ALL
)
