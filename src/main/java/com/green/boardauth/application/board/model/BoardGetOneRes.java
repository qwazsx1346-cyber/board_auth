package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardGetOneRes {
    private long id;
    private String title;
    private String contents;
    private String createdAt;
    private String nm;
    private long userId;
}
