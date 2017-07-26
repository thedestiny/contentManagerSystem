package com.yxb.cms.dao;


import com.yxb.cms.domain.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户信息DAO
 * 
 * @date   2016年8月11日 下午4:43:35
 * @author yangxiaobing@tomstaff.com
 *
 */
@Mapper
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_user
     *
     * @mbggenerated Thu Aug 11 16:34:46 CST 2016
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_user
     *
     * @mbggenerated Thu Aug 11 16:34:46 CST 2016
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_user
     *
     * @mbggenerated Thu Aug 11 16:34:46 CST 2016
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_user
     *
     * @mbggenerated Thu Aug 11 16:34:46 CST 2016
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_user
     *
     * @mbggenerated Thu Aug 11 16:34:46 CST 2016
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cc_user
     *
     * @mbggenerated Thu Aug 11 16:34:46 CST 2016
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据登陆用户名和状态查询用户信息
     * @param userLoginName
     * @param userStatus
     * @return
     */
    User selectUserByloginNameAndStatus(@Param("userLoginName") String userLoginName,@Param("userStatus") Long userStatus);


    /**
     * 查询用户总记录数
     * @param user 用户实体
     * @return
     */
    Long selectCountUser(User user);
    /**
     * 用户信息分页列表显示
     * @param user 用户实体
     * @return
     */
    List<User> selectUserListByPage(User user);
    
    
    
    
}