package com.devnunu.ticle.presentation.detail

sealed class DetailSideEffect {

}

sealed class DetailViewEvent {

}

data class DetailState(
    val budget: Long? = null
) {
}