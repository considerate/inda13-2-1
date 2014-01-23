public class Person {
    // the person's full name
    private String name;
    // the ID
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Return the full name of this person.
     */
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getInfo() {
        return this.name + " id: " + this.id;
    }

    /**
     * Set a new name for this person.
     */
    public void changeName(String replacementName) {
        name = replacementName;
    }

    /**
     * Return the login name of this person. The login name is a combination
     * of the first four characters of the person's name and the first three
     * characters of the person's ID number.
     */
    public String getLoginName() {
        return name.substring(0, 4) + id.substring(0, 3);
    }

}