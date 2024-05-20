package com.example.yourgymtrainer

sealed interface FoodEvent {
    object SaveNewFood: FoodEvent
    data class SetSearchTerm(val searchTerm: String): FoodEvent
    data class SetFoodName(val foodName: String): FoodEvent
    data class SetFoodProtein(val foodProtein: Int): FoodEvent
    data class SetFoodFat(val foodFat: Int): FoodEvent
    data class SetFoodCalories(val foodCalories: Int): FoodEvent
    data class SetFoodCarbs(val foodCarbs: Int): FoodEvent
    data class SortFoods(val sortType: FoodSortType): FoodEvent
//    data class SortFoodsByProtein(val sortType: FoodSortType): FoodEvent
//    data class SortFoodsByFat(val sortType: FoodSortType): FoodEvent
//    data class SortFoodsByCalories(val sortType: FoodSortType): FoodEvent
//    data class SortFoodsByCarbs(val sortType: FoodSortType): FoodEvent
    data class DeleteFood(val food: Food): FoodEvent
    object ShowFoodAddDialog: FoodEvent
    object HideFoodAddDialog: FoodEvent
    object ShowFoodIntakeDialog: FoodEvent
    object HideFoodIntakeDialog: FoodEvent

    object ShowFoodFilterDialog: FoodEvent
    object HideFoodFilterDialog: FoodEvent

}