package com.example.xlbackend.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "webnovel_id")
//    private Webnovel webnovel;

    private Long webnovelId;
    private Long userId;
    private Boolean deleteFlag;



    @Builder
    public Bookmark(Long webnovelId, Long userId, Boolean deleteFlag) {
        this.webnovelId = webnovelId;
        this.userId = userId;
        this.deleteFlag = deleteFlag;
    }

    public void updateDeleteFlag(Boolean flag) {
        this.deleteFlag = flag;
    }
}
