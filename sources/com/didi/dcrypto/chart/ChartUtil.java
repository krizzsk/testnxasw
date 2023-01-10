package com.didi.dcrypto.chart;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.dcrypto.cryptoprice.CryptoPriceCallback;
import com.didi.dcrypto.model.GraphDataPoint;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.dcrypto.util.FileUtils;
import com.didi.dcrypto.util.network.GetGraphDataAsyncTask;
import com.didi.dcrypto.util.network.NetworkConstants;
import com.didi.sdk.apm.SystemUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChartUtil {
    public static final int GRAPH_CATEGORIES_DAY = 0;
    public static final int GRAPH_CATEGORIES_MONTH = 2;
    public static final int GRAPH_CATEGORIES_WEEK = 1;
    public static final int GRAPH_CATEGORIES_YEAR = 3;
    public static int currentSelectedGraphCategories;

    /* renamed from: a */
    private CryptoPriceCallback f18342a;

    /* renamed from: b */
    private ChartCallback f18343b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ScrollViewCallback f18344c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LineChart f18345d;

    /* renamed from: e */
    private GraphDataPoint[] f18346e;

    /* renamed from: f */
    private GraphDataPoint[] f18347f;

    /* renamed from: g */
    private GraphDataPoint[] f18348g;

    /* renamed from: h */
    private GraphDataPoint[] f18349h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Context f18350i;

    /* renamed from: j */
    private FileUtils f18351j;

    /* renamed from: k */
    private DCryptoUtils f18352k;

    /* renamed from: l */
    private OnChartValueSelectedListener f18353l = new OnChartValueSelectedListener() {
        public void onNothingSelected() {
        }

        public void onValueSelected(Entry entry, Highlight highlight) {
            SystemUtils.log(4, "VAL SELECTED", "Value: " + entry.getY() + ", xIndex: " + entry.getX() + ", DataSet index: " + highlight.getDataSetIndex(), (Throwable) null, "com.didi.dcrypto.chart.ChartUtil$1", 79);
            ChartUtil.this.m15560a(entry);
        }
    };

    /* renamed from: m */
    private View.OnTouchListener f18354m = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (ChartUtil.this.f18350i == null) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                ChartUtil.this.f18344c.setInterceptTouch(true);
                DCryptoMainFragment.shouldUpdatePrice = false;
            } else if (action == 1 || action == 3) {
                ChartUtil.this.f18344c.setInterceptTouch(false);
                DCryptoMainFragment.shouldUpdatePrice = true;
            }
            return false;
        }
    };

    public ChartUtil(CryptoPriceCallback cryptoPriceCallback, ChartCallback chartCallback, ScrollViewCallback scrollViewCallback, Context context, View view) {
        this.f18342a = cryptoPriceCallback;
        this.f18343b = chartCallback;
        this.f18344c = scrollViewCallback;
        this.f18350i = context;
        m15558a(view);
        this.f18351j = new FileUtils();
        this.f18352k = new DCryptoUtils();
    }

    public LineChart getChart() {
        return this.f18345d;
    }

    /* renamed from: a */
    private void m15561a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        int optInt = jSONObject.optInt("errno");
        String optString = jSONObject.optString("errmsg");
        if (optInt == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = optJSONObject.optJSONArray("day_chart");
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("week_chart");
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("month_chart");
            JSONArray optJSONArray4 = optJSONObject.optJSONArray("year_chart");
            m15557a(0, optJSONArray);
            m15557a(1, optJSONArray2);
            m15557a(2, optJSONArray3);
            m15557a(3, optJSONArray4);
            refreshGraph(0);
            this.f18343b.onInitChart();
            return;
        }
        SystemUtils.log(4, "getprice", "getprice error = " + optString, (Throwable) null, "com.didi.dcrypto.chart.ChartUtil", 148);
    }

    /* renamed from: a */
    private void m15557a(int i, JSONArray jSONArray) throws JSONException {
        if (i == 0) {
            this.f18346e = m15563a(jSONArray);
        } else if (i == 1) {
            this.f18347f = m15563a(jSONArray);
        } else if (i == 2) {
            this.f18348g = m15563a(jSONArray);
        } else if (i == 3) {
            this.f18349h = m15563a(jSONArray);
        }
    }

    /* renamed from: a */
    private GraphDataPoint[] m15563a(JSONArray jSONArray) throws JSONException {
        GraphDataPoint[] graphDataPointArr = new GraphDataPoint[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray optJSONArray = jSONArray.optJSONArray(i);
            long parseLong = Long.parseLong(optJSONArray.optString(0));
            graphDataPointArr[i] = new GraphDataPoint((float) parseLong, Float.parseFloat(optJSONArray.optString(1)), new Date(parseLong));
        }
        return graphDataPointArr;
    }

    public void updateData(String str, String str2) {
        try {
            m15561a(str);
            if (this.f18350i != null) {
                this.f18351j.onWriteToFile(this.f18350i, str, str2);
            }
            this.f18352k.setGraphTimestamp(this.f18350i, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void refreshGraph(int i) {
        this.f18345d.clear();
        if (i == 0) {
            currentSelectedGraphCategories = 0;
            m15562a(this.f18346e);
        } else if (i == 1) {
            currentSelectedGraphCategories = 1;
            m15562a(this.f18347f);
        } else if (i == 2) {
            currentSelectedGraphCategories = 2;
            m15562a(this.f18348g);
        } else if (i == 3) {
            currentSelectedGraphCategories = 3;
            m15562a(this.f18349h);
        }
    }

    public void startGraphChart(String str) {
        Context context = this.f18350i;
        if (context != null) {
            if (context != null) {
                String onReadFromFile = this.f18351j.onReadFromFile(context, str);
                if (!onReadFromFile.equalsIgnoreCase("")) {
                    try {
                        m15561a(onReadFromFile);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        this.f18351j.onWriteToFile(this.f18350i, "", str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (onReadFromFile.equalsIgnoreCase("")) {
                    this.f18351j.onWriteToFile(this.f18350i, "", str);
                }
            }
            if (this.f18352k.shouldFetchGraphData(this.f18350i, str)) {
                new GetGraphDataAsyncTask(this.f18343b, str).execute(new String[]{""});
            }
        }
    }

    /* renamed from: a */
    private void m15558a(View view) {
        if (this.f18350i != null) {
            LineChart lineChart = (LineChart) view.findViewById(R.id.crypto_graph_chart);
            this.f18345d = lineChart;
            lineChart.setViewPortOffsets(0.0f, 0.0f, 0.0f, 0.0f);
            this.f18345d.getDescription().setEnabled(false);
            this.f18345d.setTouchEnabled(true);
            this.f18345d.setDragYEnabled(false);
            this.f18345d.setScaleYEnabled(false);
            this.f18345d.setDragXEnabled(true);
            this.f18345d.setScaleXEnabled(false);
            this.f18345d.setBackgroundColor(0);
            this.f18345d.setPinchZoom(false);
            this.f18345d.setDrawGridBackground(false);
            this.f18345d.setMaxHighlightDistance(300.0f);
            MyMarkerView myMarkerView = new MyMarkerView(this.f18350i, R.layout.custom_marker_view, currentSelectedGraphCategories);
            myMarkerView.setOffset(new MPPointF(0.0f, 300.0f));
            myMarkerView.setChartView(this.f18345d);
            this.f18345d.setMarker(myMarkerView);
            this.f18345d.getXAxis().setEnabled(false);
            YAxis axisLeft = this.f18345d.getAxisLeft();
            axisLeft.setDrawGridLines(false);
            axisLeft.setAxisLineColor(-1);
            this.f18345d.getAxisRight().setEnabled(false);
            this.f18345d.setOnTouchListener(this.f18354m);
            this.f18345d.setOnChartValueSelectedListener(this.f18353l);
            this.f18345d.getLegend().setEnabled(false);
            this.f18345d.animateXY(2000, 2000);
            this.f18345d.invalidate();
        }
    }

    /* renamed from: a */
    private void m15562a(GraphDataPoint[] graphDataPointArr) {
        if (graphDataPointArr != null && graphDataPointArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (GraphDataPoint graphDataPoint : graphDataPointArr) {
                arrayList.add(new Entry(graphDataPoint.f18370x, graphDataPoint.f18371y, (Object) graphDataPoint.date));
            }
            if (this.f18345d.getData() == null || ((LineData) this.f18345d.getData()).getDataSetCount() <= 0) {
                LineDataSet lineDataSet = new LineDataSet(arrayList, "DataSet 1");
                lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                lineDataSet.setCubicIntensity(0.2f);
                lineDataSet.setDrawFilled(true);
                lineDataSet.setDrawCircles(false);
                lineDataSet.setLineWidth(2.0f);
                lineDataSet.setCircleRadius(4.0f);
                lineDataSet.setCircleColor(-1);
                lineDataSet.setHighLightColor(-16777216);
                lineDataSet.setColor(Color.parseColor("#FF38CCE3"));
                lineDataSet.setFillAlpha(100);
                lineDataSet.setDrawHorizontalHighlightIndicator(false);
                lineDataSet.setFillFormatter(new IFillFormatter() {
                    public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
                        return ChartUtil.this.f18345d.getAxisLeft().getAxisMinimum();
                    }
                });
                this.f18345d.setBackgroundColor(0);
                if (Utils.getSDKInt() >= 18) {
                    Context context = this.f18350i;
                    if (context != null) {
                        lineDataSet.setFillDrawable(ContextCompat.getDrawable(context, R.drawable.fade_blue));
                    }
                } else {
                    lineDataSet.setFillColor(-16777216);
                }
                LineData lineData = new LineData(lineDataSet);
                lineData.setValueTextSize(9.0f);
                lineData.setDrawValues(false);
                this.f18345d.setData(lineData);
            } else {
                ((LineDataSet) ((LineData) this.f18345d.getData()).getDataSetByIndex(0)).setValues(arrayList);
                ((LineData) this.f18345d.getData()).notifyDataChanged();
                this.f18345d.notifyDataSetChanged();
            }
            this.f18345d.setDrawMarkers(false);
            this.f18345d.setMarker((IMarker) null);
            MyMarkerView myMarkerView = new MyMarkerView(this.f18350i, R.layout.custom_marker_view, currentSelectedGraphCategories);
            myMarkerView.setOffset(new MPPointF(0.0f, 300.0f));
            myMarkerView.setChartView(this.f18345d);
            this.f18345d.setMarker(myMarkerView);
            this.f18345d.setDrawMarkers(true);
            this.f18345d.invalidate();
        }
    }

    public void resetChart() {
        if (this.f18350i != null) {
            this.f18345d.clear();
            this.f18343b.onResetChart();
            this.f18352k.clearTimestamp(this.f18350i, NetworkConstants.CURRENCY_BTC);
            this.f18352k.clearTimestamp(this.f18350i, NetworkConstants.CURRENCY_ETH);
            this.f18352k.clearTimestamp(this.f18350i, NetworkConstants.CURRENCY_USDC);
            this.f18352k.clearTimestamp(this.f18350i, NetworkConstants.CURRENCY_SOLANA);
            this.f18352k.clearTimestamp(this.f18350i, NetworkConstants.CURRENCY_MANA);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15560a(Entry entry) {
        if (this.f18350i != null) {
            int i = currentSelectedGraphCategories;
            if (i == 0) {
                this.f18342a.updateMainPriceTitle(String.valueOf(entry.getY()), String.valueOf(this.f18346e[0].f18371y));
            } else if (i == 1) {
                this.f18342a.updateMainPriceTitle(String.valueOf(entry.getY()), String.valueOf(this.f18347f[0].f18371y));
            } else if (i == 2) {
                this.f18342a.updateMainPriceTitle(String.valueOf(entry.getY()), String.valueOf(this.f18348g[0].f18371y));
            } else if (i == 3) {
                this.f18342a.updateMainPriceTitle(String.valueOf(entry.getY()), String.valueOf(this.f18349h[0].f18371y));
            }
        }
    }
}
