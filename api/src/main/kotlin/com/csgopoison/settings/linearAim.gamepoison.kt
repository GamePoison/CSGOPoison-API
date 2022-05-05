package com.csgopoison.settings

//The smoothing function types the aimbot can use
enum class E_SMOOTH_TYPE {
            //Standard in every cheat ever
    FLAT,   //A flat % smoothing applied from the current player angle to the destination (enemy bone xyz),
            //Standard in every cheat ever


    FLAT_RAMP, //A % smoothing that ramps up over time, from MIN to MAX, over Time (in seconds)
    INV_FLAT_RAMP //A % smoothing that ramps down over time, from MAX to MIN, over Time (in seconds)
}

//The selection smoothing function from above
val AIM_TYPE = E_SMOOTH_TYPE.INV_FLAT_RAMP



////////// [ FLAT ]

//Flat aimbot smoothing % [range from 0.00 (no movement) to 1.00 (instant) ]
//Lerp current angle to target angle
//Default value = 0.01
val AIM_SMOOTHNESS = 0.01



////////// [ FLAT_RAMP & INV_FLAT_RAMP ]

//MIN should NOT be equal to or greater than MAX
//The minimum aimbot smoothing - see [LINEAR] AIM_SMOOTHNESS
val MIN_AIM_SMOOTHNESS = 0.01

//MAX should NOT be equal to or less than MIN
//The maximum aimbot smoothing - see [LINEAR] AIM_SMOOTHNESS
val MAX_AIM_SMOOTHNESS = 0.03

//The time to reach MAX from MIN over Time (in seconds)
// starting from when mouse1 is first held down, in seconds [range from 0.00 to Double.MAX_VALUE]
val LINEAR_RAMP_TIME = 2.0



////////// [ ALL ]

//The % amount of smoothing to decrease (which increases aimbot speed) based on how many shots have been fired (automatic only)
val SHOTS_FIRED_ADDITIVE_SMOOTH = .005