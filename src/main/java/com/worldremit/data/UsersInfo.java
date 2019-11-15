package com.worldremit.data;

import com.worldremit.model.UserDataModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UsersInfo {
    RANDOM_USER(
            new UserDataModel("Polly", "Dolly", "test@test.com", 123456789)
    );

    private UserDataModel userDataModel;

    public String getFirstName() {
        return userDataModel.getFirstName();
    }

    public String getLastName() {
        return userDataModel.getLastName();
    }

    public String getEmail() {
        return userDataModel.getEmail();
    }

    public Integer getPhone() {
        return userDataModel.getPhone();
    }
}
