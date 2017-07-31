

import java.util.*;


public class Graph {

    /**
     * The exist node.
     */
    public static Set<Entity> existNode = new HashSet<>();

    /**
     * Adds the node.
     *
     * @param node the node
     * @return true, if successful
     */
    public boolean addNode(Node node) {
        boolean add = true;
        try {
            /**
             * Converts the object of type node to entity
             */
            Entity entity = (Entity) node;

            /**
             * Makes an Iterator over that
             */
            Iterator<Entity> existNodeIterator = existNode.iterator();

            /**
             * Check If the Node is Already Exist
             */
            while (existNodeIterator.hasNext()) {
                if (existNodeIterator.next().getEmailId().equals(entity.getEmailId())) {
                    /**
                     * If the node is exist than break the loop and return false
                     */
                    add = false;
                    break;
                }
            }
            /**
             * else
             */
            if (entity instanceof Person) {
                /**
                 * If the object is type of Person than add that object to
                 * person List
                 */
                SocialNetwork.personSet.add((Person) entity);
            } else {
                /**
                 * If the object is type of organization than add that object to
                 * organization List
                 */
                SocialNetwork.organizationSet.add((Organization) entity);
            }

            /**
             * Also add that object to exist node list*
             */
            existNode.add(entity);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return add;
    }

    /**
     * Adds the friend.
     *
     * @param name1 the name 1
     * @param name2 the name 2
     * @return true, if successful
     */
    public boolean addFriend(String name1, String name2) {

        /**
         * Object of entity to make friend*
         */
        Entity entity1 = null;
        Entity entity2 = null;

        /**
         * flag to check weather the nae are there or not*
         */
        boolean firstPersonNameExist = false;
        boolean secondPersonNameExist = false;

        /**
         * Flag to check if they are already a friend*
         */
        boolean checkForFriend = false;

        /**
         * Result flag*
         */
        boolean addFriend = false;
        try {
            Iterator<Entity> iteratorexistNode = existNode.iterator();
            /**
             * First checks If both the name exist on network*
             */
            while (iteratorexistNode.hasNext()) {

                Entity entityTemp = iteratorexistNode.next();
                if (entityTemp.getName().equalsIgnoreCase(name1)) {
                    /**
                     * If name of first Person found*
                     */
                    entity1 = (Entity) entityTemp;
                    firstPersonNameExist = true;
                }
                if (entityTemp.getName().equalsIgnoreCase(name2)) {
                    /**
                     * If name of Second Person found*
                     */
                    entity2 = (Entity) entityTemp;
                    secondPersonNameExist = true;
                }
                if (firstPersonNameExist && secondPersonNameExist) {
                    /**
                     * If both of the Person found*
                     */
                    break;
                }
            }

            /**
             * If both the name exist on network than proceed further*
             */
            if (firstPersonNameExist && secondPersonNameExist) {
                /**
                 * Make an iterator to iterate over friends list*
                 */
                Iterator<Entity> itr = entity1.friends.iterator();
                while (itr.hasNext()) {
                    if (itr.next().getEmailId().equalsIgnoreCase(entity2.getEmailId())) {
                        /**
                         * If both the person are already friend*
                         */
                        checkForFriend = true;
                    }
                }
                if (!checkForFriend) {
                    /**
                     * If both the person are not friend of each other* Make
                     * them friend*
                     */
                    entity1.friends.add(entity2);
                    entity2.friends.add(entity1);
                    addFriend = true;
                } else {
                    /**
                     * In case if they are already a friend*
                     */
                    System.out.println("Already Friend");
                }
            } else {
                /**
                 * If one of the name not exist on network*
                 */
                String s = (!firstPersonNameExist) ? name1 : name2;
                System.out.println(s + " Not Found in network");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /**
         * Result*
         */
        return addFriend;
    }

    /**
     * Find node in entity set by name
     *
     * @param name is name of organization or person
     * @return object for which user was looking null if user is not in network
     */
    public Entity nodeFinderByName(String name) {
        Entity entity1 = null;
        /**
         * Make an iterator over Exist Node List*
         */
        Iterator<Entity> iteratorexistNode = existNode.iterator();

        while (iteratorexistNode.hasNext()) {
            Entity entityTemp = iteratorexistNode.next();
            if (entityTemp.getName().equals(name)) {
                /**
                 * If get the entity than set it to entity1 and return the
                 * object*
                 */
                entity1 = (Entity) entityTemp;
                break;
            }
        }
        /**
         * Result Object*
         */
        return entity1;
    }

    /**
     * It shows the search result
     *
     * @param name
     */
    public void searchDisplay(String name) {
        Entity entity = null;
        try {
            /**
             * First search entity by its name*
             */
            entity = nodeFinderByName(name);
            /**
             * If entity found than proceed further*
             */
            if (entity != null) {
                /**
                 * prints the information of entity*
                 */
                entity.getRecord();
                System.out.println("Friend List");
                /**
                 * Loop to iterate over friend list of entity*
                 */
                for (Entity en : entity.friends) {
                    /**
                     * Prints the name of friend of entity*
                     */
                    System.out.println(en.getName());
                }
            } else {
                /**
                 * If entity is not in network than print the message*
                 */
                System.out.println("No record found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Remove node from network by name
     *
     * @param nameToRemove
     */
    public void removeNode(String nameToRemove) {
        try {
            /**
             * First Search node by its name*
             */
            Entity entityToRemove = nodeFinderByName(nameToRemove);

            if (entityToRemove != null) {
                /**
                 * If node found than remove it from the list of all the nodes
                 * over network*
                 */
                removeFriendsFromAll(entityToRemove);
                /**
                 * remove from exist node over network
                 */
                existNode.remove(entityToRemove);

                if (entityToRemove instanceof Person) {
                    /**
                     * If the node is of type person remove it from person list*
                     */
                    SocialNetwork.personSet.remove((Person) entityToRemove);
                } else {
                    /**
                     * else remove it from organization list*
                     */
                    SocialNetwork.organizationSet.remove((Organization) entityToRemove);
                }
            } else {
                System.out.println("Person not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to remove a friend from friend list
     *
     * @param name1 is the node1
     * @param name2 is the node2
     */
    public void removeFriend(String name1, String name2) {
        try {
            /**
             * First create Object by finding name of person*
             */
            Entity entity1 = nodeFinderByName(name1);
            Entity entity2 = nodeFinderByName(name2);

            /**
             * Iterate over one's friend list*
             */
            Iterator<Entity> iteratorFriends = entity1.friends.iterator();
            while (iteratorFriends.hasNext()) {
                if (iteratorFriends.next().getEmailId().equalsIgnoreCase(entity2.getEmailId())) {
                    /**
                     * If entity is found than remove it from friend List*
                     */
                    entity1.friends.remove(entity2);
                }
            }
            /**
             * Iterate over another object's friend list*
             */
            iteratorFriends = entity2.friends.iterator();
            while (iteratorFriends.hasNext()) {
                if (iteratorFriends.next().getEmailId().equalsIgnoreCase(entity1.getEmailId())) {
                    /**
                     * If entity is found than remove it from friend List*
                     */
                    entity2.friends.remove(entity1);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Removes the friends from all entities.
     *
     * @param entity the entity
     */
    public void removeFriendsFromAll(Entity entity) {
        try {
            /**
             * Make an iterator to iterate over exist node*
             */
            Iterator<Entity> iteratorexistNode = existNode.iterator();

            while (iteratorexistNode.hasNext()) {
                Entity entityTemp = iteratorexistNode.next();
                /**
                 * Make an iterator to iterate over exist node*
                 */
                Iterator<Entity> itrFriends = entityTemp.friends.iterator();
                while (itrFriends.hasNext()) {
                    if (itrFriends.next().getEmailId().equalsIgnoreCase(entity.getEmailId())) {
                        /**
                         * If entity found than remove It*
                         */
                        entityTemp.friends.remove(entity);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
