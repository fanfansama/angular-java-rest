package com.etrali.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.runners.MockitoJUnitRunner;



/**
 * User: francois b.
 * Date: 14/12/14 07:40
 */
@RunWith(MockitoJUnitRunner.class)
public class MatchServiceImplTest {

    @Test
    public void deleteMatch() 
    {}
/*
    @Mock
    private MatchEntityDao matchEntityDao;
    @InjectMocks
    private MatchService matchService = new MatchServiceImpl();

    @Test
    public void deleteMatch() {
        Integer i = 10;
        MatchEntity match = new MatchEntity();
        match.setKey(i);

        given(matchEntityDao.findOne(i)).willReturn(match);

        try {
            matchService.deleteMatchById(i);
        } catch (Exception e) {
            fail();
        }

        verify(matchEntityDao).delete(i);
    }
*/
}