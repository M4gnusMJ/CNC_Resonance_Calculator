package com.example.cncresonancecalculator.ui.components

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

fun calculateResult(
    material: Material,
    inputValue: String,
    outerDiameter: String,
    innerDiameter: String,
    useTailstock: Boolean
): Triple<Double, Double, Double> {
    val length = inputValue.toDoubleOrNull() ?: 0.0
    val outerD = outerDiameter.toDoubleOrNull() ?: 0.0
    val innerD = innerDiameter.toDoubleOrNull() ?: 0.0

    // Calculate area
    val area = calculateArea(outerD, innerD)

    // Calculate moment of inertia
    val momentOfInertia = calculateMomentOfInertia(outerD, innerD)

    // Calculate frequencies
    val frequency1 = calculateFrequency(material, length, area, momentOfInertia, 1, useTailstock)
    val frequency2 = calculateFrequency(material, length, area, momentOfInertia, 2, useTailstock)
    val frequency3 = calculateFrequency(material, length, area, momentOfInertia, 3, useTailstock)

    return Triple(frequency1, frequency2, frequency3)
}

fun calculateArea(outerDiameter: Double, innerDiameter: Double): Double {
    return PI * ((outerDiameter / 2).pow(2) - (innerDiameter / 2).pow(2))
}

fun calculateMomentOfInertia(outerDiameter: Double, innerDiameter: Double): Double {
    return (PI / 64) * (outerDiameter.pow(4) - innerDiameter.pow(4))
}

fun calculateFrequency(
    material: Material,
    length: Double,
    area: Double,
    momentOfInertia: Double,
    mode: Int,
    useTailstock: Boolean
): Double {
    if (length <= 0 || area <= 0 || momentOfInertia <= 0) {
        return 0.0
    }

    val density = material.density
    val youngsModulus = material.youngsModulus
    val k = sqrt(momentOfInertia / area)
    val beta = when (mode) {
        1 -> if (useTailstock) 3.927 else 1.875
        2 -> if (useTailstock) 7.069 else 4.694
        3 -> if (useTailstock) 10.210 else 7.855
        else -> 0.0
    }

    return (beta.pow(2) / (2 * PI)) * sqrt((youngsModulus * k.pow(2)) / (density * area * length.pow(4)))
}