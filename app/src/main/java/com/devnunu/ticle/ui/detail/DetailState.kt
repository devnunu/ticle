package com.devnunu.ticle.ui.detail

sealed class DetailSideEffect {

}

data class DetailState(
    val budget: Long? = null
) {
}