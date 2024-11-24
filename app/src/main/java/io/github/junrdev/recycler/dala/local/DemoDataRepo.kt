package io.github.junrdev.recycler.dala.local


import io.github.junrdev.recycler.domain.model.BlogPostItem


object DemoDataRepo {

    private val _blogPosts = listOf(
        BlogPostItem(
            title = "The Importance of Recycling Plastic Waste",
            topic = "Plastic Recycling",
            content = """
                    Plastic waste contributes to massive environmental problems, filling landfills 
                    and polluting oceans. By recycling plastic, we reduce harmful waste, conserve 
                    resources, and prevent toxic materials from leaching into ecosystems. Effective 
                    systems and individual action can drive a sustainable future.
                """.trimIndent(),
            author = "John Doe"
        ),
        BlogPostItem(
            title = "How to Recycle E-Waste Properly",
            topic = "E-Waste Recycling",
            content = """
                    With technology advancing rapidly, e-waste recycling ensures precious metals 
                    like gold and copper are reclaimed. It also prevents toxins such as lead from 
                    harming the environment. Certified recycling centers and proper disposal habits 
                    are key.
                """.trimIndent(),
            author = "Jane Smith"
        ),
        BlogPostItem(
            title = "Composting Organic Waste at Home",
            topic = "Composting",
            content = """
                    Composting is a natural process of recycling food scraps and garden waste into 
                    rich soil. This method reduces landfill dependency and methane emissions while 
                    enriching soil for farming and gardening.
                """.trimIndent(),
            author = "Alice Johnson"
        ),
        BlogPostItem(
            title = "Creative Uses for Recycled Glass",
            topic = "Glass Recycling",
            content = """
                    Glass is endlessly recyclable and can be transformed into bottles, jars, and 
                    even construction materials. Supporting glass recycling reduces energy costs 
                    and minimizes waste in landfills.
                """.trimIndent(),
            author = "Emily Brown"
        ),
        BlogPostItem(
            title = "Reducing Metal Waste Through Recycling",
            topic = "Metal Recycling",
            content = """
                    Recycling metals like aluminum and steel saves energy and reduces the need for 
                    mining. Scrap metals can be reprocessed into new products, promoting a circular 
                    economy and reducing environmental impact.
                """.trimIndent(),
            author = "Chris Green"
        ),
        BlogPostItem(
            title = "Recycling Paper: A Simple Step Toward Sustainability",
            topic = "Paper Recycling",
            content = """
                    Recycling paper preserves forests, saves water, and reduces energy usage. By 
                    using recycled paper products and properly sorting paper waste, everyone can 
                    contribute to a sustainable planet.
                """.trimIndent(),
            author = "David Lee"
        ),
        BlogPostItem(
            title = "The Role of Communities in Recycling Initiatives",
            topic = "Community Recycling",
            content = """
                    Local recycling programs can significantly reduce waste. Communities that 
                    engage in recycling not only promote environmental health but also create 
                    economic opportunities through job creation in recycling industries.
                """.trimIndent(),
            author = "Sara White"
        ),
        BlogPostItem(
            title = "Recycling Construction Waste for a Greener Future",
            topic = "Construction Waste Recycling",
            content = """
                    Materials like concrete, wood, and metal from construction sites can be 
                    recycled into new building materials. Recycling construction waste reduces 
                    landfill use and saves natural resources.
                """.trimIndent(),
            author = "Tom Wilson"
        ),
        BlogPostItem(
            title = "How Schools Can Lead the Way in Recycling",
            topic = "School Recycling Programs",
            content = """
                    Schools play a vital role in teaching young generations about recycling. 
                    Implementing recycling programs in schools educates students while reducing 
                    waste. Such programs can inspire long-term environmentally friendly habits.
                """.trimIndent(),
            author = "Laura Adams"
        ),
        BlogPostItem(
            title = "Recycling Clothes: Reducing Textile Waste",
            topic = "Textile Recycling",
            content = """
                    Fast fashion generates significant textile waste. Recycling old clothes or 
                    donating them for reuse reduces landfill waste, saves resources, and promotes 
                    sustainable fashion practices.
                """.trimIndent(),
            author = "Michael Carter"
        )
    )

    val blogPosts: List<BlogPostItem>
        get() = _blogPosts


}