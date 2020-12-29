package com.workshop.rest.user;

import java.util.ArrayList;
import java.util.List;

public class UserListResponse {
    private List<UserResponse> users = new ArrayList<>();

    public UserListResponse() {
    }

    public UserListResponse(UserResponse... users) {
        for (UserResponse user : users) {
            this.users.add(user);
        }
    }

    public void add(UserResponse userResponse) {
        users.add(userResponse);
    }

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }
}
