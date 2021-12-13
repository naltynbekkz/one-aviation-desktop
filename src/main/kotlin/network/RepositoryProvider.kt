package network

interface RepositoryProvider {
    val repositories: List<BaseRepository>
}

inline fun <reified T> RepositoryProvider.get(): T {
    return repositories.filterIsInstance<T>().firstOrNull()!!
}