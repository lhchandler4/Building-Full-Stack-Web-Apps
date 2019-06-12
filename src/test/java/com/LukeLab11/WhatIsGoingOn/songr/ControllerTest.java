package com.LukeLab11.WhatIsGoingOn.songr;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTest {
    @Test
    public void testCapitalizeMe(){
        Controller testing = new Controller();
        String resultingOutput = "GODZILLA";
        assertEquals(resultingOutput, testing.capitalizeMe("godzilla"));
    }

    @Test
    public void testReverseMe(){
        Controller testing = new Controller();
        String resultingOutput = "Get to the Chopper ";
        assertEquals(resultingOutput, testing.reverseMe("Chopper the to Get"));
    }

}
