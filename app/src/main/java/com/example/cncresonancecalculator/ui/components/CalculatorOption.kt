package com.example.cncresonancecalculator.ui.components

enum class Material(val displayName: String, val value: Double) {
    ALUMINUM("Aluminum", 2.7),
    STEEL("Steel", 7.85),
    TITANIUM("Titanium", 4.51),
    COPPER("Copper", 8.96),
    BRASS("Brass", 8.73),
    CAST_IRON("Cast Iron", 7.20),
    STAINLESS_STEEL("Stainless Steel", 8.00),
    CARBON_FIBER("Carbon Fiber", 1.75),
    WOOD("Wood", 0.50),
    PLASTIC("Plastic", 1.30),
    GLASS("Glass", 2.50),
    CONCRETE("Concrete", 2.40),
    STONE("Stone", 2.70),
    RUBBER("Rubber", 1.50),
    CERAMIC("Ceramic", 3.00),
    GOLD("Gold", 19.30),
    SILVER("Silver", 10.50),
    LEAD("Lead", 11.30),
    ZINC("Zinc", 7.14),
    MAGNESIUM("Magnesium", 1.74);

    override fun toString(): String {
        return displayName
    }
}

enum class Shape(val displayName: String, val value: Double) {
    SQUARE("Square", 1.0),
    CIRCLE("Circle", 0.785),
    RECTANGLE("Rectangle", 0.8),
    TRIANGLE("Triangle", 0.5),
    HEXAGON("Hexagon", 0.866),
    OCTAGON("Octagon", 0.828),
    PENTAGON("Pentagon", 0.809),
    TRAPEZOID("Trapezoid", 0.75),
    ELLIPSE("Ellipse", 0.785),
    RHOMBUS("Rhombus", 0.5),
    PARALLELOGRAM("Parallelogram", 0.75),
    SEMI_CIRCLE("Semi-Circle", 0.393),
    QUARTER_CIRCLE("Quarter-Circle", 0.196),
    SECTOR("Sector", 0.5),
    ANNULUS("Annulus", 0.785),
    CUBE("Cube", 1.0),
    SPHERE("Sphere", 0.524),
    CYLINDER("Cylinder", 0.785),
    CONE("Cone", 0.262),
    PYRAMID("Pyramid", 0.333);

    override fun toString(): String {
        return displayName
    }
}