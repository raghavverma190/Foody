package com.example.foody.data

import com.example.foody.data.database.RecipesDao
import com.example.foody.data.database.entities.FavouritesEntity
import com.example.foody.data.database.entities.FoodJokeEntity
import com.example.foody.data.database.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
) {

    fun readRecipes(): Flow<List<RecipesEntity>> {
        return recipesDao.readRecipes()
    }

    fun readFavouriteRecipes(): Flow<List<FavouritesEntity>> {
        return recipesDao.readFavouriteRecipes()
    }

    fun readFoodJoke(): Flow<List<FoodJokeEntity>> {
        return recipesDao.readFoodJoke()
    }

    suspend fun insertFavouriteRecipes(favouritesEntity: FavouritesEntity) {
        recipesDao.insertFavouriteRecipe(favouritesEntity)
    }

    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity) {
        recipesDao.insertFoodJoke(foodJokeEntity)
    }

    suspend fun deleteFavouriteRecipe(favouritesEntity: FavouritesEntity) {
        recipesDao.deleteFavouriteRecipe(favouritesEntity)
    }

    suspend fun deleteAllFavouriteRecipes() {
        recipesDao.deleteAllFavouriteRecipes()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity) {
        recipesDao.insertRecipes(recipesEntity)
    }
}