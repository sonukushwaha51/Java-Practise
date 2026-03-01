package design.patterns.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UserRepository {

    String getUserName();

}

class LegacySystemUserSource implements UserRepository {

    @Override
    public String getUserName() {
        return "Sonu";
    }
}

class AdvancedSystemUserSource implements  UserRepository {

    @Override
    public String getUserName() {
        return "Sonu Kushwaha";
    }
}

class UserMain {

    private static final Set<UserRepository> userRepository = new HashSet<>();

    public static void main(String[] args) {
        userRepository.add(new LegacySystemUserSource());
        userRepository.add(new AdvancedSystemUserSource());
        List<String> userNames = new ArrayList<>();
        for (UserRepository repository : userRepository) {
            userNames.add(repository.getUserName());
        }

        System.out.println(userNames);
    }
}
