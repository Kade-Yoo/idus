package kr.idus.homework.member.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
public class Member {

    @Id
    private Long id;
}
