package wwyg

class ConfigData {

    String type
    String name
    String description

    static constraints = {
        type nullable: false
        name nullable: true
        description nullable: false, maxSize: 500
    }
}
