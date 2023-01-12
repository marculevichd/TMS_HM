package com.example.homework21_tms.data

import com.example.homework21_tms.R
import com.example.homework21_tms.domain.home.ItemRepository
import com.example.homework21_tms.domain.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(): ItemRepository {
    override suspend  fun getData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                ItemsModel(
                    "Изгой",
                    R.string.cast_away,
                    "",
                    R.drawable.castaway,
                    R.drawable.empty_star
                ),
                ItemsModel(
                    "Город в котором меня нет",
                    R.string.city,
                    "",
                    R.drawable.city,
                    R.drawable.empty_star
                ),
                ItemsModel(
                    "Игра престолов",
                    R.string.game_of_thrones,
                    "",
                    R.drawable.gameofthrones,
                    R.drawable.empty_star
                ),
                ItemsModel(
                    "Талантливый мистер Рипли",
                    R.string.the_talented_mr_ripley,
                    "",
                    R.drawable.mrripley,
                    R.drawable.empty_star
                ),
                ItemsModel(
                    "По ту сторону изгороди",
                    R.string.over_the_garden_wall,
                    "",
                    R.drawable.overthegardenwall,
                    R.drawable.empty_star
                )
            )
        }
    }
}