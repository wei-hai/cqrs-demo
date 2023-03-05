package main.java.com.cqrs.Services;

import main.java.com.cqrs.Aggregators.UserAggregator;
import main.java.com.cqrs.Commands.CreateUserCommand;
import main.java.com.cqrs.Commands.UpdateUserCommand;
import main.java.com.cqrs.Models.Write.Address;
import main.java.com.cqrs.Models.Write.Contact;
import main.java.com.cqrs.Projectors.UserProjector;
import main.java.com.cqrs.Queries.UserAddressByRegionQuery;
import main.java.com.cqrs.Queries.UserContactByTypeQuery;

import java.util.Set;

public class UserService {
    private UserAggregator userAggregator;
    private UserProjector userProjector;

    public UserService(UserAggregator userAggregator, UserProjector userProjector) {
        this.userAggregator = userAggregator;
        this.userProjector = userProjector;
    }

    public void createUser(String userId, String firstName, String lastName) {
        this.userAggregator.handleCreateUserCommand(new CreateUserCommand(userId, firstName, lastName));
    }

    public void updateUser(String userId, Set<Contact> contacts, Set<Address> addresses) {
        this.userAggregator.handleUpdateUserCommand(new UpdateUserCommand(userId, contacts, addresses));
    }

    public Set<Contact> getContactByType(String userId, String contactType) {
        return this.userProjector.handleUserContactByTypeQuery(new UserContactByTypeQuery(userId, contactType));
    }

    public Set<Address> getAddressByRegion(String userId, String state) {
        return this.userProjector.handleUserAddressByRegionQuery(new UserAddressByRegionQuery(userId, state));
    }
}
