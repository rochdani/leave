package com.example.leavemanagement.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {


    private  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String username;

    private String password;

    private String name;

    private String company;

//    @OneToMany(targetEntity = Leave.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
     @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
     private List<Leave> leaves;

    public List<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private String position;

//    @OneToMany(mappedBy = "user")
//    private Set<Leave> leaves;

//    public Set<Leave> getLeaves() {
//        return leaves;
//    }
//
//    public void setLeaves(Set<Leave> leaves) {
//        this.leaves = leaves;
//    }

    public User(Long id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
