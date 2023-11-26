package com.ascdev.overdata.home.data.remote.dto.hero_detail

import com.ascdev.overdata.home.domain.models.hero_detail.Chapter

data class ChapterDto(
    val content: String,
    val picture: String,
    val title: String
)

fun ChapterDto.toChapter(): Chapter {
    return Chapter(
        title = this.title,
        content = this.content,
        picture = this.picture
    )
}