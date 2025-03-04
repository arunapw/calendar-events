package com.cybaemtech.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "events")
public class Events
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_id_seq")
    @SequenceGenerator(name = "events_id_seq", sequenceName = "events_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "from_timestamp")
    private Timestamp fromTimestamp;

    @Column(name = "to_timestamp")
    private Timestamp toTimestamp;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deletion_timestamp")
    private Timestamp deletionTimestamp;

    @Column(name = "creation_timestamp")
    private Timestamp creationTimestamp;

    @Column(name = "update_timestamp")
    private Timestamp updateTimestamp;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
}
