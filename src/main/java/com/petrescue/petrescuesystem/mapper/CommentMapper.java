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

    List<Comment> selectByPostId(@Param("postId") Long postId);

    List<Comment> selectByUserId(@Param("userId") Long userId);

    List<Comment> selectRootCommentsByPostId(@Param("postId") Long postId);

    List<Comment> selectRepliesByParentId(@Param("parentId") Long parentId);

    IPage<Comment> selectCommentPage(
            Page<Comment> page,
            @Param("postId") Long postId,
            @Param("userId") Long userId
    );

    Integer countByPostId(@Param("postId") Long postId);

    Integer countByUserId(@Param("userId") Long userId);

    Integer updateLikeCount(
            @Param("commentId") Long commentId,
            @Param("likeCount") Integer likeCount
    );

    Integer incrementLikeCount(@Param("commentId") Long commentId);

    Integer decrementLikeCount(@Param("commentId") Long commentId);

    List<Comment> selectPopularComments(
            @Param("postId") Long postId,
            @Param("limit") Integer limit
    );

    List<Comment> selectRecentComments(@Param("limit") Integer limit);

    List<Comment> searchComments(@Param("keyword") String keyword);

    Integer deleteCommentAndReplies(@Param("commentId") Long commentId);

    List<Comment> selectRepliesToUser(@Param("replyToUserId") Long replyToUserId);
}