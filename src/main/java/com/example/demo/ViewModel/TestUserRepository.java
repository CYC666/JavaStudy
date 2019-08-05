package com.example.demo.ViewModel;

import com.example.demo.Model.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 数据库操作类，加上才会被扫描到，识别
public interface TestUserRepository extends JpaRepository<TestUser, Integer> {

    public TestUser getTestUserByUserName(String userName);

//    @Query("SELECT * from TestUser where userName=#{username} and email = #{email}")
//    public TestUser getTestUserByUserNameaAndAndEmail(String userName);

    @Query(value = "SELECT * from TestUser where userName = :name", nativeQuery = true)
    public List<TestUser> getList(String name);
}
