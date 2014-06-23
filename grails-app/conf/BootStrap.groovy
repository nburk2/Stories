import grails.plugins.rest.client.RestBuilder
import wwyg.*
import wwyg.authentication.*


class BootStrap {

    def words = new File("/usr/share/dict/words").readLines()
    def names = new File("/usr/share/dict/propernames").readLines()
    def categoryService
    Random num = new Random()
    def static id = 1;

    def init = { servletContext ->
        checkForCategories()

        def adminRole = Role.findOrSaveWhere(authority: "ROLE_ADMIN").save(flush: true)
        def userRole = Role.findOrSaveWhere(authority: 'ROLE_USER').save(flush: true)

        def user1 = User.findOrSaveWhere(username: "admin", password:'password', fName: "John", lName: "Jackson", email: "John@example.com")
        user1.save(flush: true)
        def user2 = User.findOrSaveWhere(username: "user", password: 'password', fName: "mike", lName: "Louis", email:"mike@example.com")
        user2.save(flush:true)

        //not sure what this line does
        if( !user1.authorities.contains(adminRole)){
            UserRole.create(user1, adminRole, true)
        }
        UserRole.create(user2, userRole, true)

        //UserStory story1= new UserStory(title: randomSentence(), author: randomName(), contactEmail: randomEmail(), story:randomParagraph(), category: tagItem()).save()
        //println story1

        //creates 5 stories for a user
        5.times{user1.addToStories(new UserStory(user:user1, title: randomSentence(), author: randomName(), contactEmail: randomEmail(), story:randomParagraph(), category: tagItem()).save())}
        user1.save(flush:true)

    }

    def destroy = {
    }

    def createTag(String newTag){
        RestBuilder rest = new RestBuilder()
        def resp = rest.post("http://ctacdev.com:8090/TagCloud/tags/createTag"){
            contentType "application/x-www-form-urlencoded"

            tagName = newTag
            tagTypeId = "1"
            languageId = "1"

        }
        resp.json
    }

    def checkForCategories(){
        try {
            RestBuilder rest = new RestBuilder()
            categoryService.category.each {
                def resp = rest.get("http://ctacdev.com:8090/TagCloud/tags/findTagsByTagName?tagName=${it}").json
                if (!resp) {
                    createTag(it)
                }
            }
        }catch(Exception e) {println "could not make rest call to find tags by name"}
    }


    def tagItem(){
        try {
            RestBuilder rest = new RestBuilder()
            String tag = rest.get("http://ctacdev.com:8090/TagCloud/tags/findTagsByTagName?tagName=Other").json.id[0]
            String newUrl = "http://wwyg.com:8080/WWyg/userStory/details/${id++}"
            rest.post("http://ctacdev.com:8090/TagCloud/tags/tagItemByTagId") {

                contentType "application/x-www-form-urlencoded"

                url = newUrl
                tagId = tag
            }
        }catch(Exception){println "Could not access Tag"}
        "Other"
    }
    def randomName(){
        "${names[num.nextInt(names.size())]} ${names[num.nextInt(names.size())]}"
    }

    def randomEmail(){

        "${names[num.nextInt(names.size())]}@example.com"
    }

    def randomDate(){
        new Date() - num.nextInt(365)
    }

    def randomWord(){
        words[num.nextInt(words.size())]
    }

    def randomSentence(){
        def sentence = ""
        (num.nextInt(10)+3).times{
            sentence += randomWord() +" "
        }
        sentence.capitalize()[0..-2] + "."
    }

    def randomParagraph(){
        def paragraph = ""
        (num.nextInt(8)+3).times{
            paragraph += randomSentence() +" "
        }
        paragraph

    }

}
