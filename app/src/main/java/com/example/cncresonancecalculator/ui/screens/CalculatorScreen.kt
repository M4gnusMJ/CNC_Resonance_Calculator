package com.example.cncresonancecalculator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cncresonancecalculator.R
import com.example.cncresonancecalculator.ui.components.Material
import com.example.cncresonancecalculator.ui.components.calculateResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    var selectedMaterial by remember { mutableStateOf(Material.ALUMINUM) }
    var inputValue by remember { mutableStateOf("") }
    var outerDiameter by remember { mutableStateOf("") }
    var innerDiameter by remember { mutableStateOf("") }
    var useTailstock by remember { mutableStateOf(false) }
    var isMaterialDropdownExpanded by remember { mutableStateOf(false) }

    val calculatedResults by remember(
        selectedMaterial,
        inputValue,
        outerDiameter,
        innerDiameter,
        useTailstock
    ) {
        derivedStateOf {
            calculateResult(
                selectedMaterial,
                inputValue,
                outerDiameter,
                innerDiameter,
                useTailstock
            )
        }
    }
    val (calculatedResult1, calculatedResult2, calculatedResult3) = calculatedResults

    Column(modifier = modifier.padding(16.dp)) {
        // Page Title
        Text(
            text = stringResource(id = R.string.calculator_title),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        // Material Dropdown
        ExposedDropdownMenuBox(
            expanded = isMaterialDropdownExpanded,
            onExpandedChange = { isMaterialDropdownExpanded = !isMaterialDropdownExpanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selectedMaterial.displayName,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isMaterialDropdownExpanded) },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = isMaterialDropdownExpanded,
                onDismissRequest = { isMaterialDropdownExpanded = false }
            ) {
                Material.entries.forEach { material ->
                    DropdownMenuItem(
                        text = { Text(text = material.displayName) },
                        onClick = {
                            selectedMaterial = material
                            isMaterialDropdownExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        // Input Field
        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text(stringResource(id = R.string.input_length_label)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedTextField(
            value = outerDiameter,
            onValueChange = { outerDiameter = it },
            label = { Text(stringResource(id = R.string.outer_diameter_label)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedTextField(
            value = innerDiameter,
            onValueChange = { innerDiameter = it },
            label = { Text(stringResource(id = R.string.inner_diameter_label)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        // Tailstock Checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = useTailstock,
                onCheckedChange = { useTailstock = it }
            )
            Text(text = stringResource(id = R.string.use_tailstock_label))
        }

        Spacer(modifier = Modifier.padding(8.dp))

        // Result Field
        Row {
            Text(text = stringResource(id = R.string.first_frequency_result), style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = calculatedResult1.toString(), style = MaterialTheme.typography.bodyLarge)
        }
        Row {
            Text(text = stringResource(id = R.string.second_frequency_result), style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = calculatedResult2.toString(), style = MaterialTheme.typography.bodyLarge)
        }
        Row {
            Text(text = stringResource(id = R.string.third_frequency_result), style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = calculatedResult3.toString(), style = MaterialTheme.typography.bodyLarge)
        }
    }
}