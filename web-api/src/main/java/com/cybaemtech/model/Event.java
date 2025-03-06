package com.cybaemtech.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Timestamp;

@Entity
@Table(name = "events")
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_id_seq")
    @SequenceGenerator(name = "events_id_seq", sequenceName = "events_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "from_timestamp")
    private Timestamp fromTimestamp;

    @Column(name = "to_timestamp")
    private Timestamp toTimestamp;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "description")
    private String description;

    @Column(name = "snooze")
    private Boolean snooze;

    @Column(name = "color")
    private String color;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deletion_timestamp")
    private Timestamp deletionTimestamp;

    @Column(name = "creation_timestamp")
    private Timestamp creationTimestamp;

    @Column(name = "update_timestamp")
    private Timestamp updateTimestamp;

    @Transient
    private User user;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Timestamp getFromTimestamp()
    {
        return fromTimestamp;
    }

    public void setFromTimestamp(Timestamp fromTimestamp)
    {
        this.fromTimestamp = fromTimestamp;
    }

    public Timestamp getToTimestamp()
    {
        return toTimestamp;
    }

    public void setToTimestamp(Timestamp toTimestamp)
    {
        this.toTimestamp = toTimestamp;
    }

    public String getEventType()
    {
        return eventType;
    }

    public void setEventType(String eventType)
    {
        this.eventType = eventType;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Boolean getSnooze()
    {
        return snooze;
    }

    public void setSnooze(Boolean snooze)
    {
        this.snooze = snooze;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Boolean getActive()
    {
        return isActive;
    }

    public void setActive(Boolean active)
    {
        isActive = active;
    }

    public Timestamp getDeletionTimestamp()
    {
        return deletionTimestamp;
    }

    public void setDeletionTimestamp(Timestamp deletionTimestamp)
    {
        this.deletionTimestamp = deletionTimestamp;
    }

    public Timestamp getCreationTimestamp()
    {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Timestamp creationTimestamp)
    {
        this.creationTimestamp = creationTimestamp;
    }

    public Timestamp getUpdateTimestamp()
    {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp)
    {
        this.updateTimestamp = updateTimestamp;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fromTimestamp=" + fromTimestamp +
                ", toTimestamp=" + toTimestamp +
                ", eventType='" + eventType + '\'' +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", snooze=" + snooze +
                ", color='" + color + '\'' +
                ", isActive=" + isActive +
                ", deletionTimestamp=" + deletionTimestamp +
                ", creationTimestamp=" + creationTimestamp +
                ", updateTimestamp=" + updateTimestamp +
                '}';
    }
}
