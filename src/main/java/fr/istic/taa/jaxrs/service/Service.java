package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.service.dao.DAO;
import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.domain.Post;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Service {

    private DAO dao;

    public static Service instance = new Service();

    private Service() {
        dao = new DAO();
    }

    public Board getBoardFromId(long id){
        return dao.findBoardFromId(id);
    }

    public List<Long> getAllPostsIds() {
        List<Post> list = dao.getPosts();
        LinkedList<Long> result = new LinkedList<>();
        for (Post post : list) {
            result.addLast(post.getId());
        }

        return result;
    }

    public List<Long> getAllCategoryIds() {
        List<Post> list = dao.getPosts();
        LinkedList<Long> result = new LinkedList<>();
        for (Post post : list) {
            result.addLast(post.getId());
        }

        return result;
    }

    public void addPost(Long boardId,Post post) {
        Board board = dao.findBoardFromId(boardId);
        board.addPost(post);
        dao.addPost(post);
        dao.updateBoard(board);
    }

    public List<Long> getAllBoardIds() {
        List<Board> list = dao.getBoards();
        LinkedList<Long> result = new LinkedList<>();
        for (Board board : list) {
            result.addLast(board.getId());
        }

        return result;
    }

    public void createNewBoard(String title) {
        Board board = new Board();
        board.setTitle(title);
        dao.addBoard(board);

    }
}
