package com.example.leavemanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
//@NamedQuery(name = "Leave.findTopByOrderByUserIdDesc", query = "SELECT id FROM leave l WHERE l.id = 1")
@Table(name = "leaves")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;


    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "type")
    private String type;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "reason")
    private String reason;

    @Column(name = "annual_count")
    private Integer annual;

    @Column(name = "sick_count")
    private String sick;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }

    public String getSick() {
        return sick;
    }

    public void setSick(String sick) {
        this.sick = sick;
    }

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "user_id")
//    private User user;

//    @ManyToOne
//    @JoinColumn(name = "user_id",nullable = false)
//    private User user;


    public Leave() {
    }

    public Leave(Long id, LocalDate fromDate, String type, LocalDate toDate, Integer duration, String reason) {
        this.id = id;
        this.fromDate = fromDate;
        this.type = type;
        this.toDate = toDate;
        this.duration = duration;
        this.reason = reason;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Leave))
            return false;
        Leave that = (Leave) obj;
        return fromDate.equals(that.fromDate) && type.equals(that.type) && toDate.equals(that.toDate) && duration.equals(that.duration) && reason.equals(that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromDate, type, toDate,duration,reason);
    }



}
