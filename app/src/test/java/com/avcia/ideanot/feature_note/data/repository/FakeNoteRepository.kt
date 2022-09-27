package com.avcia.ideanot.feature_note.data.repository


import com.avcia.ideanot.feature_note.domain.model.Note
import com.avcia.ideanot.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Test

class FakeNoteRepository : NoteRepository {

    private val notes = mutableListOf<Note>()

    @Test
    override fun getNotes(): Flow<List<Note>> {
        return flow { emit(notes) }
    }

    @Test
    override suspend fun getNoteById(id: Int): Note? {
        return notes.find { it.id == id }
    }

    @Test
    override suspend fun insertNote(note: Note) {
        notes.add(note)
    }

    @Test
    override suspend fun deleteNote(note: Note) {
        notes.remove(note)
    }
}