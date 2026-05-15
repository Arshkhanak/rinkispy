package com.mine.spy.ui.adapters.basedapter

import com.google.firebase.database.Query

/**
 * Minimal adapter options type used by [com.mine.spy.utils.ConstFun.firebaseOptions].
 * Full FirebaseRecyclerOptions integration can be restored when adapter sources exist.
 */
class FirebaseOptions<T> private constructor(
    val query: Query,
    val modelClass: Class<T>,
    val filter: String?,
    val childSegments: Array<out String?>
) {
    class Builder<T> {
        private lateinit var query: Query
        private lateinit var modelClass: Class<T>
        private var filter: String? = null
        private var childSegments: Array<out String?> = emptyArray()

        fun setQuery(
            query: Query,
            modelClass: Class<T>,
            filter: String?,
            vararg child: String?
        ): Builder<T> {
            this.query = query
            this.modelClass = modelClass
            this.filter = filter
            this.childSegments = child
            return this
        }

        fun build(): FirebaseOptions<T> = FirebaseOptions(query, modelClass, filter, childSegments)
    }
}
