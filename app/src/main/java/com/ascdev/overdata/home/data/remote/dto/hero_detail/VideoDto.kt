package com.ascdev.overdata.home.data.remote.dto.hero_detail

import com.ascdev.overdata.home.domain.models.hero_detail.Video

data class VideoDto(
    val link: LinkDto,
    val thumbnail: String
)

fun VideoDto.toVideo(): Video {
    return Video(
        link = this.link.toLink(),
        thumbnail = this.thumbnail
    )
}