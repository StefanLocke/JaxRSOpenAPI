package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.rest.BoardResource;
import fr.istic.taa.jaxrs.service.dao.*;
import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.domain.Category;
import fr.istic.taa.jaxrs.service.domain.Post;
import fr.istic.taa.jaxrs.service.domain.Tag;
import fr.istic.taa.jaxrs.service.dto.BoardDTO;
import fr.istic.taa.jaxrs.service.dto.CategoryDTO;
import fr.istic.taa.jaxrs.service.dto.PostDTO;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Service {


    private PostDAO postDAO;
    private BoardDAO boardDAO;
    private TagDAO tagDAO;
    private CategoryDAO categoryDAO;

    public static Service instance = new Service();

    public Service() {
        this.postDAO = new PostDAO();
        postDAO.setClazz(Post.class);
        this.boardDAO = new BoardDAO();
        boardDAO.setClazz(Board.class);
        this.tagDAO = new TagDAO();
        tagDAO.setClazz(Tag.class);
        this.categoryDAO = new CategoryDAO();
        categoryDAO.setClazz(Category.class);
    }




    /*** BOARDS ***/

    public BoardDTO getBoardFromId(long id){
        return boardDAO.findOne(id).toDTO();
    }

    public List<Long> getAllBoardsIds() {
        List<Board> list = boardDAO.findAll();
        LinkedList<Long> result = new LinkedList<>();
        for (Board board : list) {
            result.addLast(board.getId());
        }
        return result;
    }


    public List<BoardDTO> getAllBoards() {
        List<BoardDTO> list = new LinkedList<>();
        for (Board board : boardDAO.findAll()) {
            list.add(board.toDTO());
        }
        return list;
    }

    public void createNewBoard(String title) {
        Board board = new Board();
        board.setTitle(title);
        boardDAO.save(board);

    }
    public void removeBoard(Long id) {

        boardDAO.delete(boardDAO.findOne(id));
    }

    /*** POSTS***/

    public PostDTO getPostFromId(long id){
        return postDAO.findOne(id).toDTO();
    }

    public List<Long> getAllPostsIds() {
        List<Post> list = postDAO.findAll();
        LinkedList<Long> result = new LinkedList<>();
        for (Post post : list) {
            result.addLast(post.getId());
        }

        return result;
    }
    public List<PostDTO> getAllPosts() {
        List<PostDTO> list = new LinkedList<>();
        for (Post post : postDAO.findAll()) {
            list.add(post.toDTO());
        }
        return list;
    }

    public void addPost(Long categoryId,Post post) {
        Category category = categoryDAO.findOne(categoryId);
        category.addPost(post);
        post.setCategory(category);
        postDAO.save(post);
        categoryDAO.update(category);
    }

    public void movePost(long postId,long categoryId) {

    }

    public void removePost(Long id) {
       Post p = postDAO.findOne(id);
        Category c = p.getCategory();
        p.getCategory().getPosts().remove(p);
        p.setCategory(null);
        categoryDAO.update(c);
        postDAO.delete(p);
    }


    /*** CATEGORY ***/

    public CategoryDTO getCategoryFromId(long id){
        return categoryDAO.findOne(id).toDTO();
    }

    public List<Long> getAllCategoryIds() {
        List<Category> list = categoryDAO.findAll();
        LinkedList<Long> result = new LinkedList<>();
        for (Category category : list) {
            result.addLast(category.getId());
        }

        return result;
    }
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> list = new LinkedList<>();
        for (Category category : categoryDAO.findAll()) {
            list.add(category.toDTO());
        }
        return list;
    }
    public void addCategory(long boardId,Category category) {
        Board board = boardDAO.findOne(boardId);
        board.getCategories().add(category);
        category.setBoard(board);
        categoryDAO.save(category);
        boardDAO.update(board);
    }

    public void removeCategory(Long id) {
        categoryDAO.delete(categoryDAO.findOne(id));
    }


    /*** TAGS ***/















}
