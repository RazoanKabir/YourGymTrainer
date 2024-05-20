package com.example.yourgymtrainer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class FoodViewModel(private val dao: FoodDao) : ViewModel() {
    private val _sortType = MutableStateFlow(FoodSortType.GET_ALL)
    private val _foods = _sortType.flatMapLatest { sortType ->
        when(sortType) {
            FoodSortType.GET_ALL -> dao.getAllFoodByAlphabet()
            FoodSortType.BY_PROTEIN -> dao.getFoodByProtein()
            FoodSortType.BY_CALORIE -> dao.getFoodByCalorie()
            FoodSortType.BY_FAT -> dao.getFoodByFat()
            FoodSortType.BY_CARBS -> dao.getFoodByCarb()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(FoodAddViewState())
    val state = combine(_state, _foods, _sortType) { state, foods, sortType ->
        state.copy(
            foods = foods,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), FoodAddViewState())

    fun onEvent(event: FoodEvent) {
        when(event) {
            is FoodEvent.DeleteFood -> {
                viewModelScope.launch {
                    dao.deleteFood(event.food)
                }
            }
            is FoodEvent.SetFoodCalories -> {
                _state.update {it.copy(
                    foodCalories = event.foodCalories
                )}
            }
            is FoodEvent.SetFoodCarbs -> {
                _state.update {it.copy(
                    foodCarbs = event.foodCarbs
                )}
            }
            is FoodEvent.SetFoodFat -> {
                _state.update {it.copy(
                    foodFat = event.foodFat
                )}
            }
            is FoodEvent.SetFoodName -> {
                _state.update {it.copy(
                    foodName = event.foodName
                )}
            }
            is FoodEvent.SetFoodProtein -> {
                _state.update {it.copy(
                    foodProtein = event.foodProtein
                )}
            }

            is FoodEvent.SortFoods -> {
                _sortType.value = event.sortType
            }

            FoodEvent.ShowFoodAddDialog -> {
                _state.update {it.copy(
                  isAddingFood = true
                )}
            }
            FoodEvent.HideFoodAddDialog -> {
                _state.update {it.copy(
                    isAddingFood = false
                )}
            }
            FoodEvent.SaveNewFood -> {
                val foodName = state.value.foodName
                val foodProtein = state.value.foodProtein
                val foodFat = state.value.foodFat
                val foodCarbs = state.value.foodCarbs
                val foodCalories = state.value.foodCalories
                val fodAmountInGrams = state.value.foodAmountInGrams

                if(foodName == null || foodProtein == null || foodFat == null || foodCarbs == null || foodCalories == null) {
                    return
                }

                val food = Food(
                    foodName = foodName,
                    foodAmountInGrams = fodAmountInGrams,
                    fatAmount = foodFat,
                    carbsAmount = foodCarbs,
                    proteinAmount = foodCalories,
                    caloriesAmount = foodCalories
                )
                viewModelScope.launch {
                    dao.addFood(food)
                }
                _state.update {it.copy(
                    isAddingFood = false,
                    foodName = "",
                    foodProtein = 0,
                    foodFat = 0,
                    foodCarbs = 0,
                    foodCalories = 0,
                    foodAmountInGrams = 0
                )}
            }

            FoodEvent.HideFoodIntakeDialog -> {
                _state.update {it.copy(
                    isHavingFood = false
                )}
            }
            FoodEvent.ShowFoodIntakeDialog -> {
                _state.update {it.copy(
                    isHavingFood = true
                )}
            }

            FoodEvent.HideFoodFilterDialog -> {
                _state.update {it.copy(
                    isShowingFilter = false
                )}
            }
            FoodEvent.ShowFoodFilterDialog -> {
                _state.update {it.copy(
                    isShowingFilter = true
                )}
            }

            is FoodEvent.SetSearchTerm -> TODO()
        }
    }
}