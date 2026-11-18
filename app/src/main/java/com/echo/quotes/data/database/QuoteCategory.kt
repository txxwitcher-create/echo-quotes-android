package com.echo.quotes.data.database

data class QuoteCategory(
    val name: String,
    val description: String,
    val targetCount: Int
)

object QuoteCategories {

    val all = listOf(
        QuoteCategory("Success & Ambition", "Dream bigger and achieve more.", 450),
        QuoteCategory("Discipline & Consistency", "Build habits that last.", 450),
        QuoteCategory("Money & Wealth", "Think about financial growth.", 400),
        QuoteCategory("Business & Entrepreneurship", "Build and lead.", 400),
        QuoteCategory("Self-Confidence", "Believe in your abilities.", 400),
        QuoteCategory("Life & Reality", "Understand life more deeply.", 400),
        QuoteCategory("Hard Work", "Earn progress through effort.", 350),
        QuoteCategory("Mental Strength", "Develop a resilient mind.", 350),
        QuoteCategory("Failure & Comebacks", "Rise stronger after setbacks.", 350),
        QuoteCategory("Happiness", "Find joy in everyday life.", 300),
        QuoteCategory("Focus & Productivity", "Make your time count.", 300),
        QuoteCategory("Wisdom", "Learn from experience.", 300),
        QuoteCategory("Leadership", "Inspire and guide others.", 250),
        QuoteCategory("Relationships", "Build meaningful connections.", 150),
        QuoteCategory("Never Give Up", "Keep going when life gets hard.", 200)
    )

    val totalTarget = all.sumOf { it.targetCount }
}
