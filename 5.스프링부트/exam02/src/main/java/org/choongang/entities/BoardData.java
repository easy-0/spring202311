package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BoardData extends Base{
    @Id @GeneratedValue
    private Long seq;

    @Column(length = 100, nullable = false)
    public String subject;

    @Lob
    @Column(nullable = false)
    public String content;
}
