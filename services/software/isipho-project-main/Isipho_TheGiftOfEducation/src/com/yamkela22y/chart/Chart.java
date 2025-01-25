///*
// * This class creates the charts. 
// * When you call the a method to plot the chart you must also specify the JPanel(as a parameter)
//*/
//package com.yamkela22y.chart;
//
//import static com.yamkela22y.Register.Graphs.panelLineChart;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import javax.swing.JPanel;
//import javax.swing.JTable;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.renderer.category.LineAndShapeRenderer;
//import org.jfree.data.category.DefaultCategoryDataset;
//
///**
// *
// * @author yamkela
// */
//public class Chart {
//    /**
//     * Creates the line chart (moving average),
//     * the read from the database.  
//     * @param panel 
//     */
//    public void showLineChart(JPanel panel){
//        
//        
//        //create dataset for the graph
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.setValue(200, "Amount", "january");
//        dataset.setValue(150, "Amount", "february");
//        dataset.setValue(18, "Amount", "march");
//        dataset.setValue(100, "Amount", "april");
//        dataset.setValue(80, "Amount", "may");
//        dataset.setValue(250, "Amount", "june");
//        
//        //create chart
//        JFreeChart linechart = ChartFactory.createLineChart("contribution","monthly","amount", 
//                dataset, PlotOrientation.VERTICAL, false,true,false);
//        
//        //create plot object
//         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
//       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
//        lineCategoryPlot.setBackgroundPaint(Color.white);
//        
//        //create render object to change the moficy the line properties like color
//        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
//        Color lineChartColor = new Color(204,0,51);
//        lineRenderer.setSeriesPaint(0, lineChartColor);
//        
//         //create chartPanel to display chart(graph)
//        ChartPanel lineChartPanel = new ChartPanel(linechart);
//        panel.removeAll();
//        panel.add(lineChartPanel, BorderLayout.CENTER);
//        panel.validate();
//    }
//    
//    public static void showLineChart(JTable table) {
//        //create dataset for the graph
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        for (int i = 1; i <= table.getColumnCount(); i++) {
//            dataset.setValue((Number) table.getValueAt(i, 9), "Amount", (Comparable) table.getValueAt(i, 8));
//        }
//
//        //create chart
//        JFreeChart linechart = ChartFactory.createLineChart("Isipho Applications", "Time", "Time difference",
//                dataset, PlotOrientation.VERTICAL, false, true, false);
//
//        //create plot object
//        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
//        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
//        lineCategoryPlot.setBackgroundPaint(Color.white);
//
//        //create render object to change the moficy the line properties like color
//        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
//        Color lineChartColor = new Color(204, 0, 51);
//        lineRenderer.setSeriesPaint(0, lineChartColor);
//
//        //create chartPanel to display chart(graph)
//        ChartPanel lineChartPanel = new ChartPanel(linechart);
//        panelLineChart.removeAll();
//        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
//        panelLineChart.validate();
//    }
//    
//    
//    public void showPieChart(){
//        
//        //create dataset
//      DefaultPieDataset barDataset = new DefaultPieDataset( );
//      barDataset.setValue( "IPhone 5s" , new Double( 20 ) );  
//      barDataset.setValue( "SamSung Grand" , new Double( 20 ) );   
//      barDataset.setValue( "MotoG" , new Double( 40 ) );    
//      barDataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
//      
//      //create chart
//       JFreeChart piechart = ChartFactory.createPieChart("mobile sales",barDataset, false,true,false);//explain
//      
//        PiePlot piePlot =(PiePlot) piechart.getPlot();
//      
//       //changing pie chart blocks colors
//       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
//        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
//        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
//        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
//      
//       
//        piePlot.setBackgroundPaint(Color.white);
//        
//        //create chartPanel to display chart(graph)
//        ChartPanel barChartPanel = new ChartPanel(piechart);
//        panelBarChart.removeAll();
//        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
//        panelBarChart.validate();
//    }
//
//    /*=============================================================================*/
//    
//    public void showLineChart(){
//        //create dataset for the graph
//         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.setValue(200, "Amount", "january");
//        dataset.setValue(150, "Amount", "february");
//        dataset.setValue(18, "Amount", "march");
//        dataset.setValue(100, "Amount", "april");
//        dataset.setValue(80, "Amount", "may");
//        dataset.setValue(250, "Amount", "june");
//        
//        //create chart
//        JFreeChart linechart = ChartFactory.createLineChart("contribution","monthly","amount", 
//                dataset, PlotOrientation.VERTICAL, false,true,false);
//        
//        //create plot object
//         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
//       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
//        lineCategoryPlot.setBackgroundPaint(Color.white);
//        
//        //create render object to change the moficy the line properties like color
//        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
//        Color lineChartColor = new Color(204,0,51);
//        lineRenderer.setSeriesPaint(0, lineChartColor);
//        
//         //create chartPanel to display chart(graph)
//        ChartPanel lineChartPanel = new ChartPanel(linechart);
//        panelLineChart.removeAll();
//        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
//        panelLineChart.validate();
//    }
//
//    /*========================================================================================*/
//    
//    public void showHistogram(){
//        
//         double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
//                            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
//                            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
//                            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
//                            77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
//                          };
// 
// 
//        HistogramDataset dataset = new HistogramDataset();
//        dataset.addSeries("key", values, 20);
//        
//         JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram","Data", "Frequency", dataset,PlotOrientation.VERTICAL, false,true,false);
//            XYPlot plot= chart.getXYPlot();
//        plot.setBackgroundPaint(Color.WHITE);
//
//        
//        
//        ChartPanel barpChartPanel2 = new ChartPanel(chart);
//        jPanel3.removeAll();
//        jPanel3.add(barpChartPanel2, BorderLayout.CENTER);
//        jPanel3.validate();
//    }
//
//    /*========================================================================================*/
//    
//    public void showBarChart(){
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.setValue(200, "Amount", "january");
//        dataset.setValue(150, "Amount", "february");
//        dataset.setValue(18, "Amount", "march");
//        dataset.setValue(100, "Amount", "april");
//        dataset.setValue(80, "Amount", "may");
//        dataset.setValue(250, "Amount", "june");
//        
//        JFreeChart chart = ChartFactory.createBarChart("contribution","monthly","amount", 
//                dataset, PlotOrientation.VERTICAL, false,true,false);
//        
//        CategoryPlot categoryPlot = chart.getCategoryPlot();
//        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
//        categoryPlot.setBackgroundPaint(Color.WHITE);
//        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
//        Color clr3 = new Color(204,0,51);
//        renderer.setSeriesPaint(0, clr3);
//        
//        ChartPanel barpChartPanel = new ChartPanel(chart);
//        jPanel1.removeAll();
//        jPanel1.add(barpChartPanel, BorderLayout.CENTER);
//        jPanel1.validate();
//        
//        
//    }
//    
//}
