package lib

import java.util.concurrent.atomic.AtomicInteger

class IdFactory {
    private val currentId = AtomicInteger(0)

    fun generateId(): Int {
        return currentId.getAndIncrement();
    }
}