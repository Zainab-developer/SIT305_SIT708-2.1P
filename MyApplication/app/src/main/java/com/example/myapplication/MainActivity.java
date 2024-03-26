package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Spinner sourceSpinner, destinationSpinner;
    private EditText valueInput;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sourceSpinner = findViewById(R.id.source_spinner);
        destinationSpinner = findViewById(R.id.destination_spinner);
        valueInput = findViewById(R.id.value_input);
        resultView = findViewById(R.id.result_view);
        Button convertButton = findViewById(R.id.convert_button);


        ArrayAdapter<CharSequence> convertFromAdapter = ArrayAdapter.createFromResource(this, R.array.conversionUnits, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> convertToAdapter = ArrayAdapter.createFromResource(this, R.array.conversionUnits, android.R.layout.simple_spinner_item);
        convertFromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertToAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceSpinner.setAdapter(convertFromAdapter);
        destinationSpinner.setAdapter(convertToAdapter);


        sourceSpinner.setSelection(0);
        destinationSpinner.setSelection(0);


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the convert units
                String convertFromUnit = sourceSpinner.getSelectedItem().toString();
                String convertToUnit = destinationSpinner.getSelectedItem().toString();


                String valueString = valueInput.getText().toString();

                if (valueString.isEmpty() || Double.parseDouble(valueString) == 0) {
                    Toast.makeText(getApplicationContext(), "Kindly choose valid convert-from/to units. Kindly input an appropriate number for conversion(No '0')", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate to ensure that the source unit and destination unit are not the same
                if (convertFromUnit.equals(convertToUnit)) {
                    Toast.makeText(getApplicationContext(), "Please select a different destination/convert-to unit.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert the value and display the result
                double value = 0;
                try {
                    value = Double.parseDouble(valueString);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Kindly input an appropriate number for conversion", Toast.LENGTH_SHORT).show();
                    return;
                }



                double result = 0;

                // convert from one length unit to other length units, from one weight unit to other weight units, from one temperature unit to other temperature units
                if (convertFromUnit.equals("centimeter")) {
                    if (convertToUnit.equals("centimeter")) {
                        result = value;
                    } else if (convertToUnit.equals("yard")) {
                        result = value / 91.44;
                    } else if (convertToUnit.equals("foot")) {
                        result = value / 30.48;
                    } else if (convertToUnit.equals("inch")) {
                        result = value / 2.54;
                    } else if (convertToUnit.equals("kilometer")) {
                        result = value / 100000;
                    } else if (convertToUnit.equals("mile")) {
                        result = value / 160934;
                    }
                } else if (convertFromUnit.equals("yard")) {
                    if (convertToUnit.equals("centimeter")) {
                        result = value * 91.44;
                    } else if (convertToUnit.equals("yard")) {
                        result = value;
                    } else if (convertToUnit.equals("foot")) {
                        result = value * 3;
                    } else if (convertToUnit.equals("inch")) {
                        result = value * 36;
                    }
                } else if (convertFromUnit.equals("foot")) {
                    if (convertToUnit.equals("centimeter")) {
                        result = value * 30.48;
                    } else if (convertToUnit.equals("yard")) {result = value / 3;
                    } else if (convertToUnit.equals("foot")) {
                        result = value;
                    } else if (convertToUnit.equals("inch")) {
                        result = value * 12;
                    }
                } else if (convertFromUnit.equals("inch")) {
                    if (convertToUnit.equals("centimeter")) {
                        result = value * 2.54;
                    } else if (convertToUnit.equals("yard")) {
                        result = value / 36;
                    } else if (convertToUnit.equals("foot")) {
                        result = value / 12;
                    } else if (convertToUnit.equals("inch")) {
                        result = value;
                    }
                } else if (convertFromUnit.equals("kilogram")) {
                    if (convertToUnit.equals("kilogram")) {
                        result = value;
                    } else if (convertToUnit.equals("gram")) {
                        result = value * 1000;
                    } else if (convertToUnit.equals("pound")) {
                        result = value * 2.20462;
                    } else if (convertToUnit.equals("ounce")) {
                        result = value * 35.27396;
                    } else if (convertToUnit.equals("ton")) {
                        result = value * 0.001;
                    }
                } else if (convertFromUnit.equals("gram")) {
                    if (convertToUnit.equals("kilogram")) {
                        result = value * 0.001;
                    } else if (convertToUnit.equals("gram")) {
                        result = value;
                    } else if (convertToUnit.equals("pound")) {
                        result = value * 0.00220462;
                    } else if (convertToUnit.equals("ounce")) {
                        result = value * 0.03527396;
                    } else if (convertToUnit.equals("ton")) {
                        result = value * 1e-6;
                    }
                } else if (convertFromUnit.equals("pound")) {
                    if (convertToUnit.equals("kilogram")) {
                        result = value * 0.453592;
                    } else if (convertToUnit.equals("gram")) {
                        result = value * 453.592;
                    } else if (convertToUnit.equals("pound")) {
                        result = value;
                    } else if (convertToUnit.equals("ounce")) {
                        result = value * 16;
                    } else if (convertToUnit.equals("ton")) {
                        result = value * 0.000453592;
                    }
                } else if (convertFromUnit.equals("ounce")) {
                    if (convertToUnit.equals("kilogram")) {
                        result = value * 0.0283495;
                    } else if (convertToUnit.equals("gram")) {
                        result = value * 28.3495;
                    } else if (convertToUnit.equals("pound")) {
                        result = value * 0.0625;
                    } else if (convertToUnit.equals("ounce")) {
                        result = value;
                    } else if (convertToUnit.equals("ton")) {
                        result = value * 2.835e-5;
                    }
                } else if (convertFromUnit.equals("ton")) {
                    if (convertToUnit.equals("kilogram")) {
                        result = value * 907.185;
                    } else if (convertToUnit.equals("gram")) {
                        result = value * 907185;
                    } else if (convertToUnit.equals("pound")) {
                        result = value * 2000;
                    } else if (convertToUnit.equals("ounce")) {
                        result = value * 32000;
                    } else if (convertToUnit.equals("ton")) {
                        result = value;
                    }
                } else if (convertFromUnit.equals("celsius")) {
                    if (convertToUnit.equals("celsius")) {
                        result = value;
                    } else if (convertToUnit.equals("fahrenheit")) {
                        result = (value * 9 / 5) + 32;
                    } else if (convertToUnit.equals("kelvin")) {
                        result = value + 273.15;
                    }
                } else if (convertFromUnit.equals("fahrenheit")) {
                    if (convertToUnit.equals("celsius")) {
                        result = (value - 32) * 5 / 9;
                    } else if (convertToUnit.equals("fahrenheit")) {
                        result = value;
                    } else if (convertToUnit.equals("kelvin")) {
                        result = (value - 32) * 5 / 9 + 273.15;
                    }
                } else if (convertFromUnit.equals("kelvin")) {
                    if (convertToUnit.equals("celsius")) {
                        result = value - 273.15;
                    } else if (convertToUnit.equals("fahrenheit")) {
                        result = (value - 273.15) * 9 / 5 + 32;
                    } else if (convertToUnit.equals("kelvin")) {
                        result = value;
                    }
                }


                if (result == 0) {
                    Toast.makeText(getApplicationContext(), "Please choose valid convert-from/to units. Don't convert one type of units to another type of units", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Display the result
                resultView.setText(String.valueOf(result));
                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
