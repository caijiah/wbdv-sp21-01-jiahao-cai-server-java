package com.example.wbdvsp2103jiahaocaiserverjava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="widgets")
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topicId;
    private String name;
    private String type;
//    private Integer widgetOrder;
    private String text;
    private String src;
    private Integer size;
    private Integer width;
    private Integer height;
    private Boolean ordered;

    public Widget() {
    }

    public Widget(Widget other) {
        this.id = other.id;
        this.topicId = other.topicId;
        this.name = other.name;
        this.type = other.type;
        this.text = other.text;
        this.src = other.src;
        this.size = other.size;
        this.width = other.width;
        this.height = other.height;
        this.ordered = other.ordered;
    }

    public void copyWidget(Widget other) {
        this.id = other.id;
        this.topicId = other.topicId;
        this.name = other.name;
        this.type = other.type;
        this.text = other.text;
        this.src = other.src;
        this.size = other.size;
        this.width = other.width;
        this.height = other.height;
        this.ordered = other.ordered;
    }


    public Widget(Long id, String topicId, String name, String type,
                  String text, String src, Integer size,
                  Integer width, Integer height, Boolean ordered) {
        this.id = id;
        this.topicId = topicId;
        this.name = name;
        this.type = type;
        this.text = text;
        this.src = src;
        this.size = size;
        this.width = width;
        this.height = height;
        this.ordered = ordered;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

}

/*

    create table widgets (
       id bigint not null auto_increment,
        height integer,
        size integer,
        text varchar(255),
        topic_id varchar(255),
        type varchar(255),
        width integer,
        primary key (id)
    ) engine=InnoDB

    alter table widgets
       add column name varchar(255)

    create table widget (
       id bigint not null,
        height integer,
        size integer,
        text varchar(255),
        topic_id varchar(255),
        type varchar(255),
        width integer,
        primary key (id)
    ) engine=InnoDB
 */