package daniel.lop.io.marvelappstarter.data.local

import androidx.room.*
import daniel.lop.io.marvelappstarter.data.model.character.CharacterModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insert(characterModel: CharacterModel) : Long

    @Query("SELECT * FROM characterModel ORDER BY id")
    fun getAll(): Flow<List<CharacterModel>>

    @Delete
    suspend fun delete(characterModel: CharacterModel)
}