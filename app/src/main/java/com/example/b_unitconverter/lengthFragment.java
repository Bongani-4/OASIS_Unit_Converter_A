package com.example.b_unitconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class lengthFragment extends Fragment {

    private EditText resultmetre, resultMillimeters, resultCentimeters, resultKilometers,
            resultInches, resultFeet;
    private boolean converting = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_length, container, false);

        resultmetre = view.findViewById(R.id.metre);
        resultMillimeters = view.findViewById(R.id.millimetre);
        resultCentimeters = view.findViewById(R.id.centmetre);
        resultKilometers = view.findViewById(R.id.kilometre);
        resultInches = view.findViewById(R.id.inches);
        resultFeet = view.findViewById(R.id.feet);






        //numerical calculator buttons

        Button buttonOne = view.findViewById(R.id.one);
        Button buttonTwo = view.findViewById(R.id.two);
        Button button3 = view.findViewById(R.id.three);
        Button button4 = view.findViewById(R.id.four);
        Button button5 = view.findViewById(R.id.five);
        Button button6 = view.findViewById(R.id.six);
        Button button7 = view.findViewById(R.id.seven);
        Button button8 = view.findViewById(R.id.eight);
        Button button9 = view.findViewById(R.id.nine);
        Button button0 = view.findViewById(R.id.zero);
        Button buttoncomma = view.findViewById(R.id.comma);
        ImageView back = view.findViewById(R.id.backspace);
         Button clear = view.findViewById(R.id.clearButton);

        //numerical calculator buttons colors

        setButtonBackgroundColor(view, R.id.one);
        setButtonBackgroundColor(view, R.id.two);
        setButtonBackgroundColor(view, R.id.three);
        setButtonBackgroundColor(view, R.id.four);
        setButtonBackgroundColor(view, R.id.five);
        setButtonBackgroundColor(view, R.id.six);
        setButtonBackgroundColor(view, R.id.seven);
        setButtonBackgroundColor(view, R.id.eight);
        setButtonBackgroundColor(view, R.id.nine);
        setButtonBackgroundColor(view, R.id.zero);
        setButtonBackgroundColor(view, R.id.comma);


        resultmetre.setInputType(InputType.TYPE_NULL);
        resultMillimeters.setInputType(InputType.TYPE_NULL);
        resultCentimeters.setInputType(InputType.TYPE_NULL);
        resultKilometers.setInputType(InputType.TYPE_NULL);
        resultInches.setInputType(InputType.TYPE_NULL);
        resultFeet.setInputType(InputType.TYPE_NULL);

        setupTextWatchers();

 //click listeners for all edittexts




        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }

        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        buttoncomma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumericKeyPressed(v);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBackspace();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllEditTexts();
            }
        });



        return view;
    }
    private void clearAllEditTexts() {

        // Clear all EditText fields
        resultmetre.setText(String.valueOf(0));
        resultMillimeters.setText(String.valueOf(0));
        resultCentimeters.setText(String.valueOf(0));
        resultKilometers.setText(String.valueOf(0));
        resultInches.setText(String.valueOf(0));
        resultFeet.setText(String.valueOf(0));



    }








    private void setupTextWatchers() {
        resultmetre.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No implementation yet
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!converting) {
                    convert();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No implementation yet
            }
        });

        resultMillimeters.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No implementation yet

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!converting) {
                    updateValuesFromMillimeters();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No implementation yet
            }
        });
        resultCentimeters.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!converting) {
                    updateValuesFromCentimeters();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        resultFeet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!converting) {
                    updateValuesFromFeet();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        resultInches.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!converting) {
                    updateValuesFromInches();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        resultKilometers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!converting) {
                    updateValuesFromKilometers();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    private void convert() {
        converting = true;

        String inputStr = resultmetre.getText().toString();
        if (inputStr.isEmpty()) {
            // No implementation yet
            return;
        } else {


            try {
                double inputMetersValue = Double.parseDouble(inputStr);

                double millimeters = Math.round(inputMetersValue * 1000 * 100.0) / 100.0;
                double centimeters = Math.round(inputMetersValue * 100 * 100.0) / 100.0;
                double kilometers = Math.round(inputMetersValue / 1000 * 100.0) / 100.0;
                double inches = Math.round(inputMetersValue * 39.3701 * 100.0) / 100.0;
                double feet = Math.round(inputMetersValue * 3.28084 * 100.0) / 100.0;

                resultMillimeters.setText(String.format(Locale.US, "%.2f", millimeters));
                resultCentimeters.setText(String.format(Locale.US, "%.2f", centimeters));
                resultKilometers.setText(String.format(Locale.US, "%.2f", kilometers));
                resultInches.setText(String.format(Locale.US, "%.2f", inches));
                resultFeet.setText(String.format(Locale.US, "%.2f", feet));


            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Enter a numeric value on meter", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } finally {
                converting = false;
            }
        }
        Log.d("Converter", "convert() finished");

    }

    private void updateValuesFromMillimeters() {
        converting = true;
        String millimetersStr = resultMillimeters.getText().toString();
        if (!millimetersStr.isEmpty()) {
            try {
                double millimetersValue = Double.parseDouble(millimetersStr);

                double meters = millimetersValue / 1000;
                double centimeters = millimetersValue / 10;
                double kilometers = millimetersValue / 1_000_000;
                double inches = millimetersValue / 25.4;
                double feet = millimetersValue / 304.8;


                resultmetre.setText(String.valueOf(meters));
                resultCentimeters.setText(String.format(Locale.US, "%.2f", centimeters));
                resultKilometers.setText(String.format(Locale.US, "%.2f", kilometers));
                resultInches.setText(String.format(Locale.US, "%.2f", inches));
                resultFeet.setText(String.format(Locale.US, "%.2f", feet));


            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Invalid millimeter value", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } finally {
                converting = false;
            }
        }
        Log.d("Converter", "updateValuesFromMillimeters() finished");
    }







    private void setButtonBackgroundColor(View parentView, int buttonId) {
        Button button = parentView.findViewById(buttonId);
        button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.grey));
    }

    public void onNumericKeyPressed(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            String key = button.getText().toString();



            if(view.getId() == R.id.metre)
            {
                resultmetre.requestFocus();
            }
                else if (view.getId() == R.id.millimetre) {
                resultMillimeters.requestFocus();
            }

            // Append the numeric key to the focused EditText
            View focusedView = requireActivity().getCurrentFocus();
            if (focusedView instanceof EditText) {
                ((EditText) focusedView).append(key);
            }
        }

}

    private void handleBackspace() {
        View focusedView = requireActivity().getCurrentFocus();

        if (focusedView instanceof EditText) {
            EditText editText = (EditText) focusedView;
            Editable editable = editText.getText();
            int length = editable.length();

            if (length > 1) {
                editable.delete(length - 1, length);
            } else {
                clearAllEditTexts();
            }

        }


    }
    private void updateValuesFromCentimeters() {
        converting = true;
        String centimetersStr = resultCentimeters.getText().toString();
        if (!centimetersStr.isEmpty()) {
            try {
                double centimetersValue = Double.parseDouble(centimetersStr);

                double meters = centimetersValue / 100;
                double millimeters = centimetersValue * 10;
                double kilometers = centimetersValue / 100000;
                double inches = centimetersValue / 2.54;
                double feet = centimetersValue / 30.48;

                resultmetre.setText(String.format(Locale.US, "%.2f", meters));
                resultMillimeters.setText(String.format(Locale.US, "%.2f", millimeters));
                resultKilometers.setText(String.format(Locale.US, "%.2f", kilometers));
                resultInches.setText(String.format(Locale.US, "%.2f", inches));
                resultFeet.setText(String.format(Locale.US, "%.2f", feet));

            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Invalid centimeter value", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } finally {
                converting = false;
            }
        }
        Log.d("Converter", "updateValuesFromCentimeters() finished");
    }
    private void updateValuesFromKilometers() {
        converting = true;
        String kilometersStr = resultKilometers.getText().toString();
        if (!kilometersStr.isEmpty()) {
            try {
                double kilometersValue = Double.parseDouble(kilometersStr);

                double meters = kilometersValue * 1000;
                double millimeters = kilometersValue * 1_000_000;
                double centimeters = kilometersValue * 100_000;
                double inches = kilometersValue * 39370.1;
                double feet = kilometersValue * 3280.84;

                resultmetre.setText(String.format(Locale.US, "%.2f", meters));
                resultMillimeters.setText(String.format(Locale.US, "%.2f", millimeters));
                resultCentimeters.setText(String.format(Locale.US, "%.2f", centimeters));
                resultInches.setText(String.format(Locale.US, "%.2f", inches));
                resultFeet.setText(String.format(Locale.US, "%.2f", feet));

            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Invalid kilometer value", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } finally {
                converting = false;
            }
        }
        Log.d("Converter", "updateValuesFromKilometers() finished");
    }
    private void updateValuesFromInches() {
        converting = true;
        String inchesStr = resultInches.getText().toString();
        if (!inchesStr.isEmpty()) {
            try {
                double inchesValue = Double.parseDouble(inchesStr);

                double meters = inchesValue * 0.0254;
                double millimeters = inchesValue * 25.4;
                double centimeters = inchesValue * 2.54;
                double kilometers = inchesValue * 0.0000254;
                double feet = inchesValue * 0.0833333;

                resultmetre.setText(String.format(Locale.US, "%.2f", meters));
                resultMillimeters.setText(String.format(Locale.US, "%.2f", millimeters));
                resultCentimeters.setText(String.format(Locale.US, "%.2f", centimeters));
                resultKilometers.setText(String.format(Locale.US, "%.6f", kilometers));
                resultFeet.setText(String.format(Locale.US, "%.2f", feet));

            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Invalid inches value", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } finally {
                converting = false;
            }
        }
        Log.d("Converter", "updateValuesFromInches() finished");
    }
    private void updateValuesFromFeet() {
        converting = true;
        String feetStr = resultFeet.getText().toString();
        if (!feetStr.isEmpty()) {
            try {
                double feetValue = Double.parseDouble(feetStr);

                double meters = feetValue * 0.3048;
                double millimeters = feetValue * 304.8;
                double centimeters = feetValue * 30.48;
                double kilometers = feetValue * 0.0003048;
                double inches = feetValue * 12;

                resultmetre.setText(String.format(Locale.US, "%.2f", meters));
                resultMillimeters.setText(String.format(Locale.US, "%.2f", millimeters));
                resultCentimeters.setText(String.format(Locale.US, "%.2f", centimeters));
                resultKilometers.setText(String.format(Locale.US, "%.6f", kilometers));
                resultInches.setText(String.format(Locale.US, "%.2f", inches));

            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Invalid feet value", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } finally {
                converting = false;
            }
        }
        Log.d("Converter", "updateValuesFromFeet() finished");
    }




}//for 0.00 fix strirngformat



