package com.skoryk.testmanager.domain.answer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answers")
public class Answer
    implements Serializable
{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //Object

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Answer))
            return false;

        Answer that = (Answer) obj;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
            return false;

        return true;
    }
}
