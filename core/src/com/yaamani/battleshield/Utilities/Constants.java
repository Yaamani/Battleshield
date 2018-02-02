package com.yaamani.battleshield.Utilities;

/**
 * Created by mahmo on 28/01/2018.
 */

public class Constants {

    public static final float WORLD_SIZE = 510.0f;

    public static final float TURRET_SIZE = WORLD_SIZE / 12.5f;

    public static class SETTINGS {

        public static class STARS {
            public enum EXISTENCE {ON, OFF}

            public enum MOVEMENT {SIMPLE, COMPLEX}

            public enum DENSITY {LOW, MEDIUM, HIGH}
        }

        public static class DEFAULTS {
            public static final STARS.EXISTENCE STARS_EXISTENCE = STARS.EXISTENCE.ON;

            public static final STARS.MOVEMENT STARS_MOVEMENT = STARS.MOVEMENT.COMPLEX;

            public static final STARS.DENSITY STARS_DENSITY = STARS.DENSITY.MEDIUM;
        }
    }
}
