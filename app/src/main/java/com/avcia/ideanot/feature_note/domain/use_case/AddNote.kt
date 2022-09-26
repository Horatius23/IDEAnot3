package com.avcia.ideanot.feature_note.domain.use_case

import com.avcia.ideanot.feature_note.domain.model.InvalidNoteException
import com.avcia.ideanot.feature_note.domain.model.Note
import com.avcia.ideanot.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("Başlık Boş Bırakılamaz")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("İçerik Boş Bırakılamaz")
        }
        repository.insertNote(note)
    }
}