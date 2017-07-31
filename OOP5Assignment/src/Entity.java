

import java.util.Objects;


public class Entity extends Node {

    /**
     * The name.
     */
    private String name;

    /**
     * The email id.
     */
    private String emailId;

    /**
     * The number.
     */
    private String number;

    /**
     * Instantiates a new entity.
     *
     * @param name the name
     * @param emailId the email id
     * @param number the number
     */
    public Entity(String name, String emailId, String number) {
        this.name = name;
        this.emailId = emailId;
        this.number = number;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email id.
     *
     * @return the email id
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email id.
     *
     * @param emailId the new email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the number.
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the number.
     *
     * @param number the new number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**Get Record Method
     *
     * This method prints the information about Object
     */
    @Override
    public void getRecord() {
        System.out.print(this.name + "\t");
        System.out.print(this.emailId + "\t");
        System.out.print(this.number + "\t");
    }
    /**hashCode Method
     * 
     * @return hashCode of object
     */

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.emailId);
        hash = 41 * hash + Objects.hashCode(this.number);
        return hash;
    }

    /**
     * equals Method
     *
     * It is used to compare the object of Entity class
     *
     * @param obj
     * @return true if both the object are same else false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entity other = (Entity) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.emailId, other.emailId)) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }
}
