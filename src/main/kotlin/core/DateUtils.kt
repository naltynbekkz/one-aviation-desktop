package core

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun getMilitaryTime(time: Long): String {
        val calendar = getCalendar(time)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        dateFormat.timeZone = calendar.timeZone
        return dateFormat.format(calendar.time)
    }

    fun getCalendarFromDate(dateString: String): Calendar {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return getCalendar().apply {
            time = dateFormat.parse(dateString)!!
        }
    }

    fun calendarToDate(calendar: Calendar): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
    fun Calendar.toDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(time)
    }


    fun areSameDates(first: Calendar?, second: Calendar?): Boolean {
        if (first == null && second == null) return true
        if (first == null || second == null) return false
        return first.get(Calendar.YEAR) == second.get(Calendar.YEAR) &&
                first.get(Calendar.DAY_OF_YEAR) == second.get(Calendar.DAY_OF_YEAR)
    }

    fun getCalendar(timeInMillis: Long? = null): Calendar {
        val calendar = Calendar.getInstance()
        calendar.timeZone = TimeZone.getTimeZone("Asia/Almaty")
        timeInMillis?.let { calendar.timeInMillis = it }
        return calendar
    }

    fun Calendar.added(
        days: Int = 0,
        hours: Int = 0,
        minutes: Int = 0,
        seconds: Int = 0,
    ): Calendar {
        val date = getCalendar(this.timeInMillis)
        date.add(Calendar.DATE, days)
        date.add(Calendar.HOUR_OF_DAY, hours)
        date.add(Calendar.MINUTE, minutes)
        date.add(Calendar.SECOND, seconds)
        return date
    }

    fun getMidnight(deltaInDays: Int = 0): Calendar {
        val date = getCalendar()
        date[Calendar.HOUR_OF_DAY] = 0
        date[Calendar.MINUTE] = 0
        date[Calendar.SECOND] = 0
        date[Calendar.MILLISECOND] = 0
        date.add(Calendar.DATE, deltaInDays)
        return date
    }

    fun Calendar.setMidnight(): Calendar {
        this[Calendar.HOUR_OF_DAY] = 0
        this[Calendar.MINUTE] = 0
        this[Calendar.SECOND] = 0
        this[Calendar.MILLISECOND] = 0
        return this
    }

    fun getFirstDayOfMonth(timeInMillis: Long? = null): Calendar {
        val date = getCalendar(timeInMillis)
        date[Calendar.DAY_OF_MONTH] = 1
        date[Calendar.HOUR_OF_DAY] = 0
        date[Calendar.MINUTE] = 0
        date[Calendar.SECOND] = 0
        date[Calendar.MILLISECOND] = 0
        return date
    }

    fun getLastDayOfMonth(timeInMillis: Long? = null): Calendar {
        val date = getCalendar(timeInMillis)
        date[Calendar.DAY_OF_MONTH] = 1
        date[Calendar.HOUR_OF_DAY] = 0
        date[Calendar.MINUTE] = 0
        date[Calendar.SECOND] = 0
        date[Calendar.MILLISECOND] = 0
        date.add(Calendar.MONTH, 1)
        date.add(Calendar.DAY_OF_MONTH, -1)
        return date
    }

    fun Calendar.getWeekStart(): Calendar {
        val date = getCalendar(timeInMillis)
        val dayOfWeek = (date.get(Calendar.DAY_OF_WEEK) + 5) % 7
        date.add(Calendar.DAY_OF_MONTH, dayOfWeek.unaryMinus())
        return date
    }

    fun Calendar.getWeekEnd(): Calendar {
        val date = getCalendar(timeInMillis)
        val dayOfWeek = (date.get(Calendar.DAY_OF_WEEK) + 5) % 7
        date.add(Calendar.DAY_OF_MONTH, 6 - dayOfWeek)
        return date
    }

}