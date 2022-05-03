package com.zpmk.thinten.util

import com.zpmk.thinten.model.CourseItem

object CourseGenerator {
    fun genereate() = arrayListOf<CourseItem>(
        CourseItem(
            title = "Google Sheet Class",
            posterUrl = "https://drive.google.com/uc?id=1okgV2jpGLwiYUtHr520mo0sPDqzdJq7P",
            durationString = "2 months",
            type = "IT",
            status = "Completed"
        ),
        CourseItem(
            title = "Shell-Script Basic",
            posterUrl = "https://drive.google.com/uc?id=1Ce-1WpXe4Vw9JThF3TUMiRHkIeZkT14h",
            durationString = "4 weeks",
            type = "IT",
            status = "On-going"
        ),
        CourseItem(
            title = "English 4 Skills (Intermediate)",
            posterUrl = "https://www.englishexplorer.com.sg/wp-content/uploads/2017/02/english-course.jpg",
            durationString = "6 weeks",
            type = "Language",
            status = "Buy now"
        ),
    )
}