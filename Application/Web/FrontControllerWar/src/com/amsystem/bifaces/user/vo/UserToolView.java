package com.amsystem.bifaces.user.vo;

import com.amsystem.bifaces.user.UserOperation;
import com.amsystem.bifaces.user.bean.UserBean;
import com.amsystem.bifaces.user.model.User;
import com.amsystem.bifaces.user.model.UserProfile;
import com.amsystem.bifaces.util.ComponentOperation;
import com.amsystem.bifaces.util.MessageUtil;
import com.amsystem.bifaces.util.OperationType;
import com.amsystem.bifaces.util.SymbolType;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Title: UserSection.java <br>
 *
 * @author Jaime Aguilar (JAR)
 *         File Creation on 31/12/2016.
 */

@ViewScoped
@ManagedBean(name = "userToolView")
public class UserToolView implements Serializable {

    private List<User> allUsers;

    private User selectedUser;

    private OperationType operation;

    @ManagedProperty("#{userOperation}")
    private UserOperation userOperation;

    /**
     * Carga todos los roles y usuarios registrados en el sistema
     */
    @PostConstruct
    public void init() {
        allUsers = userOperation.loadAllUsers();
    }


    public void deleteUser() {
        userOperation.deleteUser(selectedUser);
        allUsers = userOperation.loadAllUsers();
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public UserOperation getUserOperation() {
        return userOperation;
    }

    public void setUserOperation(UserOperation userOperation) {
        this.userOperation = userOperation;
    }


    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }


}
