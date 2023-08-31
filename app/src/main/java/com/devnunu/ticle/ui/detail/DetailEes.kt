package com.devnunu.ticle.ui.detail

sealed class DetailSideEffect {

}

sealed class DetailViewEvent {

}

data class DetailState(
    val budget: Long? = null
) {
}