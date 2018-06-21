package com.example.posmachinetextview;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PosMachineTextView extends RelativeLayout {
    private Context context;
    private TextView textView;
    private EditText editText;
    private String before = "";
    private String after = "";
    int l = 0;

    public PosMachineTextView(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_pos, null, false);
        editText = (EditText) view.findViewById(R.id.amount_dummy_edit_text);
        textView = (TextView) view.findViewById(R.id.amount_edit_text);
        after = "";
        before = "";
        l = 0;
        this.addView(view);
        setUpViews(view);
    }

    public PosMachineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_pos, null, false);
        editText = (EditText) view.findViewById(R.id.amount_dummy_edit_text);
        textView = (TextView) view.findViewById(R.id.amount_edit_text);
        after = "";
        before = "";
        l = 0;
        this.addView(view);
        setUpViews(view);
    }

    private void setUpViews(View view) {
        String setString = "";
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != keyEvent.ACTION_DOWN) {
                    if (keyEvent.getKeyCode() == keyEvent.KEYCODE_BACK) {
                        ((Activity) context).onBackPressed();
                    }
                    return true;
                } else {
                    if (i == keyEvent.KEYCODE_DEL) {
                        double set = Double.parseDouble((textView.getText().toString()));
                        set = set / 10.00;
                        if (set < 10) {
                            BigDecimal bigDecimal = new BigDecimal(set);
                            bigDecimal = bigDecimal.setScale(2, RoundingMode.DOWN);
                            textView.setText("0" + String.valueOf(bigDecimal));
                        } else {
                            BigDecimal bigDecimal = new BigDecimal(set);
                            bigDecimal = bigDecimal.setScale(2, RoundingMode.DOWN);

                            textView.setText(String.valueOf(bigDecimal));
                        }
                    }
                    return false;
                }
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                before = charSequence.toString();
                l = i;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                double set = Double.parseDouble(textView.getText().toString());
                if (editable.toString().length() < before.length()) {

                } else {
                    char inserted = editable.toString().charAt(l);
                    if (inserted == '1') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 1.0 / 100.00;
                    }
                    if (inserted == '2') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 2.0 / 100.00;
                    }
                    if (inserted == '3') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 3.0 / 100.00;
                    }
                    if (inserted == '4') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 4.0 / 100.00;
                    }
                    if (inserted == '5') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 5.0 / 100.00;
                    }
                    if (inserted == '0') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 0.0 / 100.00;
                    }
                    if (inserted == '6') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 6.0 / 100.00;
                    }
                    if (inserted == '7') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 7.0 / 100.00;
                    }
                    if (inserted == '8') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 8.0 / 100.00;
                    }
                    if (inserted == '9') {
                        set = Double.parseDouble((textView.getText().toString()));
                        set = set * 10.00 + 9.0 / 100.00;
                    }
                    if (set < 10) {
                        String setString = "0" + String.format("%.2f", set);

                        textView.setText(setString);

                    } else {
                        String setString = String.format("%.2f", set);
                        textView.setText(setString);
                    }
                }

            }
        });
    }

    public String getText() {
        return textView.getText().toString();
    }
}
