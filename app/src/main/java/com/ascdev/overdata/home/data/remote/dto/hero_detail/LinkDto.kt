package com.ascdev.overdata.home.data.remote.dto.hero_detail

import com.ascdev.overdata.home.domain.models.hero_detail.Link

data class LinkDto(
    val mp4: String,
    val webm: String
)

fun LinkDto.toLink(): Link {
    return Link(
        mp4 = this.mp4,
        webm = this.webm
    )
}