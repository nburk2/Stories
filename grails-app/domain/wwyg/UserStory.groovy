package wwyg

class UserStory {

    String title
    String author
    String story
    String contactEmail
    Date dateCreated
    Date lastUpdated
    String category

    static constraints = {
        title blank: false, nullable: false, maxSize: 255
        author blank: false, nullable: false, maxSize: 255
        contactEmail blank: false, nullable: false, maxSize: 255, email: true
        story blank: false, nullable: false, maxSize: 2000
        category blank: false, nullable: true, maxSize: 255
    }


}
