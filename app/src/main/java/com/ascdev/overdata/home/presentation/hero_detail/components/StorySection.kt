package com.ascdev.overdata.home.presentation.hero_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ascdev.overdata.home.domain.models.hero_detail.Story

@Composable
fun StorySection(story: Story) {
    Column {
        story.chapters.forEach { chapter ->
            ChapterItem(chapter = chapter)
        }
    }
}