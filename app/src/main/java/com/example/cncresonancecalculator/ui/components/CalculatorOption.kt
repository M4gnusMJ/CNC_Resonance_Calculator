package com.example.cncresonancecalculator.ui.components

enum class Material(
    val displayName: String,
    val density: Double, // kg/m^3
    val youngsModulus: Double // Pa
) {
    ALUMINUM("Aluminum", 2700.0, 70e9),
    STEEL("Steel", 7850.0, 200e9),
    TITANIUM("Titanium", 4510.0, 110e9),
    COPPER("Copper", 8960.0, 117e9),
    BRASS("Brass", 8730.0, 100e9),
    CAST_IRON("Cast Iron", 7200.0, 140e9),
    STAINLESS_STEEL("Stainless Steel", 8000.0, 193e9),
    CARBON_FIBER("Carbon Fiber", 1750.0, 230e9),
    WOOD("Wood", 500.0, 10e9),
    PLASTIC("Plastic", 1300.0, 3e9),
    GLASS("Glass", 2500.0, 70e9),
    CONCRETE("Concrete", 2400.0, 30e9),
    STONE("Stone", 2700.0, 50e9),
    RUBBER("Rubber", 1500.0, 0.01e9),
    CERAMIC("Ceramic", 3000.0, 300e9),
    GOLD("Gold", 19300.0, 79e9),
    SILVER("Silver", 10500.0, 76e9),
    LEAD("Lead", 11300.0, 16e9),
    ZINC("Zinc", 7140.0, 108e9),
    MAGNESIUM("Magnesium", 1740.0, 45e9);

    override fun toString(): String {
        return displayName
    }
}
