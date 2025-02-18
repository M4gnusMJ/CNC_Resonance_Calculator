package com.example.cncresonancecalculator.ui.components

fun calculateResult(material: Material, shape: Shape, inputValue: String): Pair<Double, Double> {
    // Basic calculation logic (replace with your actual logic)
    val input = inputValue.toDoubleOrNull() ?: 0.0
    val result1 = input * material.value
    val result2 = input * shape.value
    return Pair(result1, result2)
}