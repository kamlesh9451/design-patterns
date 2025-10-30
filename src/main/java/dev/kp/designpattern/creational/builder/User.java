public class User {
    // Required parameters
    private final String firstName;
    private final String lastName;

    // Optional parameters
    private final int age;
    private final String email;
    private final String address;
    private final boolean isSubscribed;

    // Private constructor - only Builder can create a User
    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;
        this.isSubscribed = builder.isSubscribed;
    }

    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private final String firstName;
        private final String lastName;

        // Optional parameters - initialize with defaults
        private int age = 0;
        private String email = "";
        private String address = "";
        private boolean isSubscribed = false;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // Chained setter methods
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder isSubscribed(boolean isSubscribed) {
            this.isSubscribed = isSubscribed;
            return this;
        }

        // Build method to create the final object
        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", isSubscribed=" + isSubscribed +
                '}';
    }
}
