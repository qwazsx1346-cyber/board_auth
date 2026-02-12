package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public long postBoard(BoardPostPutReq req) {
        boardMapper.save(req);
        return req.getId();
    }

    public List<BoardGetRes> getBoardList(BoardGetReq req) {
        return boardMapper.findAll(req);
    }

    public int getBoardMaxPage(BoardGetMaxPageReq req) {
        return boardMapper.findMaxPage(req);
    }

    public BoardGetOneRes getBoardDetail(long id) {
        return boardMapper.boardDetail(id);
    }

    public void putBoard(BoardPostPutReq req) {
        boardMapper.modify(req);
    }

    public int delList(BoardDelReq req) {
        return boardMapper.delList(req);
    }

    public List<String> searchText(String text) {
        return boardMapper.searchText(text);
    }
}
