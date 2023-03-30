package com.company.gamestore.repository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class T_shirtsRepositoryTest {

    @Autowired
    T_shirtsRepository t_shirtsRepository;

    @Before
    public void setUp() {
        t_shirtsRepository.deleteAll();
    }

}