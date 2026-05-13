package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    
    /**
     * 根据帖子ID查询评论列表
     * @param postId 帖子ID
     * @return 评论列表
     */
    List<Comment> selectByPostId(@Param("postId") Long postId);
    
    /**
     * 根据用户ID查询评论列表
     * @param userId 用户ID
     * @return 评论列表
     */
    List<Comment> selectByUserId(@Param("userId") Long userId);
    
    /**
     * 查询帖子的根评论（非回复评论）
     * @param postId 帖子ID
     * @return 根评论列表
     */
    List<Comment> selectRootCommentsByPostId(@Param("postId") Long postId);
    
    /**
     * 查询评论的回复列表
     * @param parentId 父评论ID
     * @return 回复列表
     */
    List<Comment> selectRepliesByParentId(@Param("parentId") Long parentId);
    
    /**
     * 分页查询评论列表
     * @param page 分页参数
     * @param postId 帖子ID（可选）
     * @param userId 用户ID（可选）
     * @return 分页结果
     */
    IPage<Comment> selectCommentPage(
            Page<Comment> page,
            @Param("postId") Long postId,
            @Param("userId") Long userId
    );
    
    /**
     * 统计帖子的评论数量
     * @param postId 帖子ID
     * @return 评论数量
     */
    Integer countByPostId(@Param("postId") Long postId);
    
    /**
     * 统计用户的评论数量
     * @param userId 用户ID
     * @return 评论数量
     */
    Integer countByUserId(@Param("userId") Long userId);
    
    /**
     * 更新评论点赞数
     * @param commentId 评论ID
     * @param likeCount 新的点赞数
     * @return 影响行数
     */
    Integer updateLikeCount(
            @Param("commentId") Long commentId,
            @Param("likeCount") Integer likeCount
    ); 
    
    /**
     * 增加评论点赞数
     * @param commentId 评论ID
     * @return 影响行数
     */
    Integer incrementLikeCount(@Param("commentId") Long commentId);
    
    /**
     * 减少评论点赞数
     * @param commentId 评论ID
     * @return 影响行数
     */
    Integer decrementLikeCount(@Param("commentId") Long commentId);
    
    /**
     * 查询热门评论（按点赞数排序）
     * @param postId 帖子ID
     * @param limit 限制数量
     * @return 热门评论列表
     */
    List<Comment> selectPopularComments(
            @Param("postId") Long postId,
            @Param("limit") Integer limit
    );
    
    /**
     * 查询最近评论
     * @param limit 限制数量
     * @return 最近评论列表
     */
    List<Comment> selectRecentComments(@Param("limit") Integer limit);
    
    /**
     * 根据关键字搜索评论内容
     * @param keyword 搜索关键字
     * @return 搜索结果列表
     */
    List<Comment> searchComments(@Param("keyword") String keyword);
    
    /**
     * 删除评论及其所有回复
     * @param commentId 评论ID
     * @return 影响行数
     */
    Integer deleteCommentAndReplies(@Param("commentId") Long commentId);
    
    /**
     * 查询用户被回复的评论
     * @param replyToUserId 被回复的用户ID
     * @return 被回复的评论列表
     */
    List<Comment> selectRepliesToUser(@Param("replyToUserId") Long replyToUserId);
}