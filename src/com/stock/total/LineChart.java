/*
 * TianFang science corporation (c)2012 all rights reserved.
 * Description:  create LineChart .
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-12-20   Li.Hai-Han(**)        Create
 */
package com.stock.total;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 * LineChart.
 * 
 * @author Li.Hai-Han(**)
 */
public class LineChart extends ApplicationFrame
{

	private static final long serialVersionUID = 1L;

	public LineChart(String s, String path , String title, TotalForm form, List<Integer> list) {
		super(s);
		JPanel jpanel = createDemoPanel(path,title,form,list);
		jpanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(jpanel);
	}

	private static CategoryDataset createDataset(TotalForm form, List<Integer> list) {
		//2012-11-11	
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		
		if(form.getKaijis() != null && !form.getKaijis().equals("")) {
			String kaijis = form.getKaijis();
			kaijis = kaijis.substring(0, 7);
			String year = kaijis.substring(0, 4);
			String month = kaijis.substring(5, 7);
			int m = Integer.parseInt(month);
			int y = Integer.parseInt(year);
			for (int i = 0 ; i < list.size() ; i++) {
				defaultcategorydataset.addValue(list.get(i) , form.getXiaoqu().length() < 1 ? "全部小区" : form.getXiaoqu() , String.valueOf(y) + "-" + String.valueOf(m));
				if(m < 12) {
					m++;
				} else {
					y++;
					m = 1;
				}
			}
			return defaultcategorydataset;
		}
		defaultcategorydataset.addValue(0 , "无查询" , "无查询");
		return defaultcategorydataset;
	}

	private static JFreeChart createChart(CategoryDataset categorydataset,String title) {
		JFreeChart jfreechart = ChartFactory.createLineChart(title, null, title.substring(0,2), categorydataset, PlotOrientation.VERTICAL, true, true, false);
		jfreechart.getTitle().setFont(new Font("黑体",Font.PLAIN,20));//设置标题字体
		jfreechart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 18));//横轴框里的标题字体
		//jfreechart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 15));//横轴框里的标题字体
		//jfreechart.addSubtitle(new TextTitle("Number of Classes By Release"));
		//TextTitle texttitle = new TextTitle("Source: Java In A Nutshell (5th Edition) by David Flanagan (O'Reilly)");
		//texttitle.setFont(new Font("SansSerif", 0, 10));
		//texttitle.setPosition(RectangleEdge.BOTTOM);
		//texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		//jfreechart.addSubtitle(texttitle);
		CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
		categoryplot.setRangeGridlinesVisible(false);
		categoryplot.getRangeAxis().setLabelFont(new Font("黑体", Font.PLAIN, 15));
		categoryplot.getDomainAxis().setTickLabelFont(new Font("新宋体", Font.BOLD, 15));
		categoryplot.getDomainAxis().setLabelFont(new Font("新宋体", Font.PLAIN, 12));
		
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(false);
		numberaxis.setUpperMargin(0.12D);
		//ChartUtilities.applyCurrentTheme(jfreechart);
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true);
		lineandshaperenderer.setDrawOutlines(true);
		lineandshaperenderer.setUseFillPaint(true);
		lineandshaperenderer.setBaseFillPaint(Color.white);
		lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F));
		lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		lineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));
		lineandshaperenderer.setBaseShapesVisible(true); 
        lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineandshaperenderer.setBaseItemLabelsVisible(true);

		XYStepRenderer xysteprenderer = new XYStepRenderer();
		xysteprenderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xysteprenderer.setBaseItemLabelsVisible(true);
		
		return jfreechart;
	}

	public static JPanel createDemoPanel(String path,String title, TotalForm form, List<Integer> list) {
		JFreeChart jfreechart = createChart(createDataset(form,list),title);
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			ChartUtilities.writeChartAsJPEG(fileOutputStream , jfreechart , list.size() == 0 ? 300 : list.size() * 200 , 300);
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ChartPanel(jfreechart);
	}
}
