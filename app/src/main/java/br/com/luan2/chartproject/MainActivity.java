package br.com.luan2.chartproject;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected PieChart mPiechat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mPiechat = (PieChart) findViewById(R.id.m_piechat);


        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        float num = Float.parseFloat("5.0");

        entries.add(new PieEntry(Float.parseFloat("5.0"),"Primeiro"));
        entries.add(new PieEntry(Float.parseFloat("15.0"),"Segundo"));
        entries.add(new PieEntry(Float.parseFloat("20.0"),"Terceiro"));
        entries.add(new PieEntry(Float.parseFloat("8.0"),"Quarta"));
        entries.add(new PieEntry(Float.parseFloat("22.0"),"Quinta"));
        entries.add(new PieEntry(Float.parseFloat("30.0"),"Sexta"));


        PieDataSet dataset = new PieDataSet(entries, "");

        final int[] MY_COLORS = {Color.rgb(192,0,0), Color.rgb(255,0,0), Color.rgb(255,192,0),
                Color.rgb(127,127,127), Color.rgb(146,208,80), Color.rgb(0,176,80), Color.rgb(79,129,189)};
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for(int c: MY_COLORS) colors.add(c);

        dataset.setColors(colors);

        PieData data = new PieData(dataset);        // initialize Piedata
        mPiechat.setData(data);

        Legend l = mPiechat.getLegend();
        l.setTextSize(14f);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setTextColor(Color.BLACK);
        l.setEnabled(false);
        // calling method to set center text
        mPiechat.setCenterText(generateCenterSpannableText());
        // if no need to add description
        mPiechat.getDescription().setEnabled(false);
        // animation and the center text color
        mPiechat.animateY(5000);
        mPiechat.setEntryLabelColor(Color.BLACK);
    }

    // If we need to display center text with textStyle
    private SpannableString generateCenterSpannableText() {
        SpannableString s = new SpannableString("TOTAL SPENT\n$ 4000");
        s.setSpan(new RelativeSizeSpan(2f), 11, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.BOLD), 11, s.length(), 0);
        return s;
    }
    }

