package com.ascdev.overdata.home.data.remote.dto.hero_detail

import com.ascdev.overdata.home.domain.models.hero_detail.Story

data class StoryDto(
    val chapters: List<ChapterDto>,
    val summary: String
)

fun StoryDto.toStory(): Story {
    val chapters = this.chapters.map { it.toChapter() }
    return Story(
        chapters = chapters,
        summary = this.summary
    )
}