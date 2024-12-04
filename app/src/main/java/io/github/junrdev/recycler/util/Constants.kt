package io.github.junrdev.recycler.util

object Constants {

    const val usersCollection = "recycler-users-v1"
    const val wasteMetadataCollection = "recycler-waste-v1"
    const val blogsCollection = "recycler-blogs-v1"
    const val appPrefs = "appsettings"
    const val userInfo = "user"



    val IMAGE_PROMPT = """
        Given an image like this categorize the content in terms of waste for categories like plastic, 
        glass and other types of waste, provide your response in json in the following format : { major_content : "the major contents of the waste", "quantity":"an estimation of the quantity(usea unit you find fit", "contents":"the rest of the contents comprising the waste minus the major one" } ensure the contents in the major_content and contents are completely visible from the waste picture ,
         also for the contents make it a list
    """.trimIndent()

}