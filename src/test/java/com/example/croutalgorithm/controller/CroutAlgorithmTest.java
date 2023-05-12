package com.example.croutalgorithm.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CroutAlgorithmTest {
    private CroutAlgorithm algorithm;

    @BeforeAll
    public void setUp(){
        algorithm = new CroutAlgorithm();
    }

    @Test
    public void testGetCroutAlgorithm(){
        double[][] A = {
                {4, -1, 0},
                {1, 3, -1},
                {0, -1, 4}
        };

        double[][] expectedLU = {
                {4, -1, 0},
                {0.25, 2.75, -1},
                {0, -0.3636363636363637, 3.727272727272727}
        };

        double[][] expectedL = {
                {1, 0, 0},
                {0.25, 1, 0},
                {0, -0.3636363636363637, 1}
        };

        double[][] expectedU = {
                {4, -1, 0},
                {0, 2.75, -1},
                {0, 0, 3.727272727272727}
        };

        algorithm.croutAlgorithm(A);
        assertEquals(algorithm.getLu(), expectedLU);
        assertEquals(algorithm.getLowerMatrix(), expectedL);
        assertEquals(algorithm.getUpperMatrix(), expectedU);
    }
}
